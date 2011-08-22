package org.ats_lang.scoping;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;



public class AtsImportUriResolver extends ImportUriResolver {

	// override resolve instead of apply since it's also used
	// by validation
	@Override
	public String resolve(EObject from) {
		String resolvename = super.resolve(from);
		if (null == resolvename) {
			return resolvename;
		}
		
		if (!resolvename.endsWith(".sats") && !resolvename.endsWith(".dats")) {
			// todo didn't check whether path is valid
			return null;
		}
		
		// System.out.println("resolve: " + resolvename);
		
		Resource resource = from.eResource();
		URI importUri = URI.createURI(resolvename);
		// is already valid uri
		if (EcoreUtil2.isValidUri(resource, importUri)) {
			return resolvename;
		}

		// get the name of the project
		String projname = null;
		String path = from.eResource().getURI().toString();
		final String platform = "platform:/resource/";
		// final String filesys = "file://";
		if (path.startsWith(platform)) {
			projname = path.substring(platform.length()).split("/")[0];
			// System.out.println("projname is " + projname);
		    resolvename = platform + projname + "/" + resolvename;
		}

		return resolvename;

	}

//	@Override
//	public String apply(EObject from) {
//		return this.resolve(from);
//	}
}
