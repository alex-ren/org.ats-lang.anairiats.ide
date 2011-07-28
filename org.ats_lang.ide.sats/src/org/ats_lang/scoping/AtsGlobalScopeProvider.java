package org.ats_lang.scoping;

import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.scoping.impl.AbstractGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.DelegatingEventSource;
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;
import org.eclipse.xtext.scoping.impl.LoadOnDemandResourceDescriptions;
import org.eclipse.xtext.scoping.impl.SelectableBasedScope;


import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Event.Source;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.containers.FilterUriContainer;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.util.OnChangeEvictingCache;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class AtsGlobalScopeProvider extends AbstractGlobalScopeProvider {

 
	// from DefaultGlobalScopeProvider
	@Inject
	private IContainer.Manager containerManager;

	@Inject
	private IResourceDescription.Manager descriptionManager;
	
	protected IScope getScope(IScope parent, final Resource context, boolean ignoreCase, EClass type, Predicate<IEObjectDescription> filter) {
//		System.out.println("======getScope ===========");
		IScope result = parent;
		if (context == null || context.getResourceSet() == null)
			return result;
		List<IContainer> containers = Lists.newArrayList(getVisibleContainers(context));
//		for (IContainer con: containers) {
//			System.out.println("======con " + con.getResourceDescriptions());
//		}
		
		Collections.reverse(containers);
		Iterator<IContainer> iter = containers.iterator();
		while (iter.hasNext()) {
			IContainer container = iter.next();
			result = createContainerScopeWithContext(context, result, container, filter, type, ignoreCase);
		}
		
//		Iterator<IEObjectDescription> e1 = result.getAllElements().iterator();
//		while (e1.hasNext())
//		{
//			System.out.println("e.next = " + e1.next().toString());
//		}
//		
//		System.out.println("====================================");
		IScope ret = getScopeImport(result, context, ignoreCase, type, filter);
//		Iterator<IEObjectDescription> e2 = ret.getAllElements().iterator();
//		while (e2.hasNext())
//		{
//			System.out.println("e.next = " + e2.next().toString());
//		}
		return ret;
	}
	
	@Override
	protected IScope getScope(final Resource context, boolean ignoreCase, EClass type, Predicate<IEObjectDescription> filter) {
		return getScope(IScope.NULLSCOPE, context, ignoreCase, type, filter);
	}

	protected List<IContainer> getVisibleContainers(Resource resource) {
		IResourceDescription description = descriptionManager.getResourceDescription(resource);
		IResourceDescriptions resourceDescriptions = getResourceDescriptions(resource);
		String cacheKey = getCacheKey("VisibleContainers", resource.getResourceSet());
		OnChangeEvictingCache.CacheAdapter cache = new OnChangeEvictingCache().getOrCreate(resource);
		List<IContainer> result = null;
		result = cache.get(cacheKey);
		if (result == null) {
			result = containerManager.getVisibleContainers(description,	resourceDescriptions);
			// SZ: I'ld like this dependency to be moved to the implementation of the
			// container manager, but it is not aware of a CacheAdapter
			if (resourceDescriptions instanceof IResourceDescription.Event.Source) {
				IResourceDescription.Event.Source eventSource = (Source) resourceDescriptions;
				DelegatingEventSource delegatingEventSource = new DelegatingEventSource(eventSource);
				delegatingEventSource.addListeners(Lists.newArrayList(Iterables.filter(result, IResourceDescription.Event.Listener.class)));
				delegatingEventSource.initialize();
				cache.addCacheListener(delegatingEventSource);
			}
			cache.set(cacheKey, result);
		}
		return result;
	}
	
	protected String getCacheKey(String base, ResourceSet context) {
		Map<Object, Object> loadOptions = context.getLoadOptions();
		if (loadOptions.containsKey(ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE)) {
			return base + "@" + ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE;
		} 
		return base + "@DEFAULT_SCOPE"; 
	}

	protected IScope createContainerScopeWithContext(Resource eResource, IScope parent, IContainer container,
			Predicate<IEObjectDescription> filter, EClass type, boolean ignoreCase) {
		if (eResource != null) {
			URI uriToFilter = eResource.getURI();
			if (container.hasResourceDescription(uriToFilter))
				container = new FilterUriContainer(uriToFilter, container);
		}
		return createContainerScope(parent, container, filter, type, ignoreCase);
	}

	protected IScope createContainerScope(IScope parent, IContainer container, Predicate<IEObjectDescription> filter, EClass type, boolean ignoreCase) {
		return SelectableBasedScope.createScope(parent, container, filter, type, ignoreCase);
	}
	
	// =======================
	// from ImportUriGlobalScopeProvider

	@Inject
	private ImportUriResolver importResolver;
	
	@Inject
	private Provider<LoadOnDemandResourceDescriptions> loadOnDemandDescriptions;
	
	@Inject
	private IResourceScopeCache cache;
	
	public ImportUriResolver getImportUriResolver() {
		return importResolver;
	}
	
	public void setImportResolver(ImportUriResolver importResolver) {
		this.importResolver = importResolver;
	}
	
	public void setCache(IResourceScopeCache cache) {
		this.cache = cache;
	}
	
	public IResourceDescriptions getResourceDescriptions(Resource resource, Collection<URI> importUris) {
		IResourceDescriptions result = getResourceDescriptions(resource);
		LoadOnDemandResourceDescriptions demandResourceDescriptions = loadOnDemandDescriptions.get();
		demandResourceDescriptions.initialize(result, importUris, resource);
		return demandResourceDescriptions;
	}

	// modified by Zhiqiang Ren
	protected IScope getScopeImport(IScope parent, Resource resource, boolean ignoreCase, EClass type, Predicate<IEObjectDescription> filter) {
		final LinkedHashSet<URI> uniqueImportURIs = getImportedUris(resource);
		IResourceDescriptions descriptions = getResourceDescriptions(resource, uniqueImportURIs);
		List<URI> urisAsList = Lists.newArrayList(uniqueImportURIs);
		Collections.reverse(urisAsList);
		// IScope scope = IScope.NULLSCOPE;
		for (URI uri : urisAsList) {
			parent = createLazyResourceScope(parent, uri, descriptions, type, filter, ignoreCase);
		}
		return parent;
	}

	protected LinkedHashSet<URI> getImportedUris(final Resource resource) {
		return cache.get(ImportUriGlobalScopeProvider.class.getName(), resource, new Provider<LinkedHashSet<URI>>(){
			public LinkedHashSet<URI> get() {
				TreeIterator<EObject> iterator = resource.getAllContents();
				final LinkedHashSet<URI> uniqueImportURIs = new LinkedHashSet<URI>(10);
				while (iterator.hasNext()) {
					EObject object = iterator.next();
					String uri = importResolver.apply(object);
					if (uri != null) {
						URI importUri = URI.createURI(uri);
						uniqueImportURIs.add(importUri);
					}
				}
				Iterator<URI> uriIter = uniqueImportURIs.iterator();
				while(uriIter.hasNext()) {
					if (!EcoreUtil2.isValidUri(resource, uriIter.next()))
						uriIter.remove();
				}
				return uniqueImportURIs;
			}
		});
	}

	protected IScope createLazyResourceScope(IScope parent, final URI uri, final IResourceDescriptions descriptions,
			EClass type, final Predicate<IEObjectDescription> filter, boolean ignoreCase) {
		IResourceDescription description = descriptions.getResourceDescription(uri);
		return SelectableBasedScope.createScope(parent, description, filter, type, ignoreCase);
	}

	public void setLoadOnDemandDescriptions(Provider<LoadOnDemandResourceDescriptions> loadOnDemandDescriptions) {
		this.loadOnDemandDescriptions = loadOnDemandDescriptions;
	}

	public Provider<LoadOnDemandResourceDescriptions> getLoadOnDemandDescriptions() {
		return loadOnDemandDescriptions;
	}

}
