/*
 * generated by Xtext
 */
package org.ats_lang.ui;

//import org.ats_lang.ui.builder.AtsProjectBasedBuilderParticipant;
import org.ats_lang.ui.editor.syntaxcoloring.AtsAntlrTokenToAttributeIdMapper;
import org.ats_lang.ui.editor.syntaxcoloring.AtsIHighlightingConfiguration;
import org.ats_lang.ui.editor.syntaxcoloring.AtsISemanticHighlightingCalculator;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;

/**
 * Use this class to register components to be used within the IDE.
 */
public class AnairiatsSatsUiModule extends org.ats_lang.ui.AbstractAnairiatsSatsUiModule {
	public AnairiatsSatsUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return AtsIHighlightingConfiguration.class;
	}

	public Class<? extends AbstractAntlrTokenToAttributeIdMapper> bindAbstractAntlrTokenToAttributeIdMapper() {
		return AtsAntlrTokenToAttributeIdMapper.class;
	}
	
	public Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		return AtsISemanticHighlightingCalculator.class;
	}
	
//	public Class<? extends org.eclipse.xtext.builder.IXtextBuilderParticipant> bindIXtextBuilderParticipant() {
//		return AtsProjectBasedBuilderParticipant.class;
//	}
}
