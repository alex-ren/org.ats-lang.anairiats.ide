package org.ats_lang.scoping;

import java.util.LinkedHashSet;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider;

public class AtsImportUriGlobalScopeProvider extends
		ImportUriGlobalScopeProvider {
	
	@Override
	protected LinkedHashSet<URI> getImportedUris(final Resource resource) {
		LinkedHashSet<URI> temp = super.getImportedUris(resource);

		// file format of URI doesn't work
		// temp.add(URI.createURI("file://G:/WORKSPACE/Xtext/runtime-EclipseApplication/clspath/ti04.testimport"));

		// get the name of the project
		String projname = null;
		String path = resource.getURI().toString();
		final String platform = "platform:/resource/";
		// final String filesys = "file://";
		if (path.startsWith(platform)) {
			projname = path.substring(platform.length()).split("/")[0];
			// System.out.println("projname in getUris is " + projname);
			String libpath = "prelude/SATS/";
			temp.add(URI.createURI("platform:/resource/" + projname + "/"
					+ libpath + "list0.sats"));
			// temp.add(URI.createURI("platform:/resource/" + projname +
			// "list0.sats"));
		}

		return temp;
	}
}
