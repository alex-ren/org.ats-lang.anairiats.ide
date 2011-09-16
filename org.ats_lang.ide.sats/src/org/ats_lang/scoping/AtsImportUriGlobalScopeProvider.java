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
//			System.out.println("projname in getUris is " + projname);
			temp.add(URI.createURI("platform:/resource/" + projname + "/dummy.sats"));
            temp.add(URI.createURI("platform:/resource/" + projname + "/prelude/basics_sta.sats"));
            temp.add(URI.createURI("platform:/resource/" + projname + "/prelude/sortdef.sats"));
            temp.add(URI.createURI("platform:/resource/" + projname + "/prelude/basics_dyn.sats"));
            temp.add(URI.createURI("platform:/resource/" + projname + "/prelude/macrodef.sats"));
            			
            temp.add(URI.createURI("platform:/resource/" + projname + "/prelude/SATS/arith.sats"));
            temp.add(URI.createURI("platform:/resource/" + projname + "/prelude/SATS/vsubrw.sats"));
            temp.add(URI.createURI("platform:/resource/" + projname + "/prelude/SATS/bool.sats"));
            temp.add(URI.createURI("platform:/resource/" + projname + "/prelude/SATS/byte.sats"));
            temp.add(URI.createURI("platform:/resource/" + projname + "/prelude/SATS/char.sats"));
            temp.add(URI.createURI("platform:/resource/" + projname + "/prelude/SATS/extern.sats"));
            temp.add(URI.createURI("platform:/resource/" + projname + "/prelude/SATS/filebas.sats"));
            temp.add(URI.createURI("platform:/resource/" + projname + "/prelude/SATS/float.sats"));
            temp.add(URI.createURI("platform:/resource/" + projname + "/prelude/SATS/integer.sats"));
            temp.add(URI.createURI("platform:/resource/" + projname + "/prelude/SATS/integer_fixed.sats"));
            temp.add(URI.createURI("platform:/resource/" + projname + "/prelude/SATS/integer_ptr.sats"));
            temp.add(URI.createURI("platform:/resource/" + projname + "/prelude/SATS/lazy.sats"));
            temp.add(URI.createURI("platform:/resource/" + projname + "/prelude/SATS/lazy_vt.sats"));
            temp.add(URI.createURI("platform:/resource/" + projname + "/prelude/SATS/memory.sats"));
            temp.add(URI.createURI("platform:/resource/" + projname + "/prelude/SATS/pointer.sats"));
            temp.add(URI.createURI("platform:/resource/" + projname + "/prelude/SATS/printf.sats"));
            temp.add(URI.createURI("platform:/resource/" + projname + "/prelude/SATS/reference.sats"));
            temp.add(URI.createURI("platform:/resource/" + projname + "/prelude/SATS/sizetype.sats"));
            temp.add(URI.createURI("platform:/resource/" + projname + "/prelude/SATS/string.sats"));
            temp.add(URI.createURI("platform:/resource/" + projname + "/prelude/SATS/array.sats"));
            temp.add(URI.createURI("platform:/resource/" + projname + "/prelude/SATS/array0.sats"));
            temp.add(URI.createURI("platform:/resource/" + projname + "/prelude/SATS/list.sats"));
            temp.add(URI.createURI("platform:/resource/" + projname + "/prelude/SATS/list0.sats"));
            temp.add(URI.createURI("platform:/resource/" + projname + "/prelude/SATS/list_vt.sats"));
            temp.add(URI.createURI("platform:/resource/" + projname + "/prelude/SATS/matrix.sats"));
            temp.add(URI.createURI("platform:/resource/" + projname + "/prelude/SATS/matrix0.sats"));
            temp.add(URI.createURI("platform:/resource/" + projname + "/prelude/SATS/option.sats"));
            temp.add(URI.createURI("platform:/resource/" + projname + "/prelude/SATS/option0.sats"));
            temp.add(URI.createURI("platform:/resource/" + projname + "/prelude/SATS/option_vt.sats"));
            temp.add(URI.createURI("platform:/resource/" + projname + "/prelude/SATS/ptrarr.sats"));
            temp.add(URI.createURI("platform:/resource/" + projname + "/prelude/SATS/prelude_finish.sats"));
		}

		return temp;
	}
}
