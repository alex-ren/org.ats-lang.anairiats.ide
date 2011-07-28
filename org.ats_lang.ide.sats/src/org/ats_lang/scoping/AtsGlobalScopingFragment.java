package org.ats_lang.scoping;

import org.eclipse.xtext.generator.scoping.AbstractScopingFragment;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;

/**
 * @author Zhiqiang Ren
 */

public class AtsGlobalScopingFragment extends AbstractScopingFragment {
	@Override
	protected Class<? extends IScopeProvider> getLocalScopeProvider() {
		return ImportedNamespaceAwareLocalScopeProvider.class;
	}
	
	protected Class<? extends IGlobalScopeProvider> getGlobalScopeProvider() {
		return AtsGlobalScopeProvider.class;
	}
}