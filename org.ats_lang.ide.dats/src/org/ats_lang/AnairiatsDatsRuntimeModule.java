/*
 * generated by Xtext
 */
package org.ats_lang;

import org.ats_lang.naming.AnairiatsDatsQualifiedNameProvider;
import org.ats_lang.scoping.AtsImportUriGlobalScopeProvider;
import org.ats_lang.scoping.AtsImportUriResolver;
import org.ats_lang.hyperlink.AtsHyperlinkHelper;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkHelper;



/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class AnairiatsDatsRuntimeModule extends org.ats_lang.AbstractAnairiatsDatsRuntimeModule {
	
	@Override
	public Class<? extends org.eclipse.xtext.naming.IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return AnairiatsDatsQualifiedNameProvider.class;
	}
	
//	public Class<? extends IContainer.Manager>bindIContainer$Manager() {
//		return StateBasedContainerManager.class;
//	}
	
	public Class<? extends ImportUriResolver> bindImportUriResolver() {
		return AtsImportUriResolver.class;
	}
	
	public Class<? extends org.eclipse.xtext.scoping.IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return AtsImportUriGlobalScopeProvider.class;
	}
	
	public Class<? extends IHyperlinkHelper> bindIHyperlinkHelper() { return AtsHyperlinkHelper.class; }
	
	
	
}
