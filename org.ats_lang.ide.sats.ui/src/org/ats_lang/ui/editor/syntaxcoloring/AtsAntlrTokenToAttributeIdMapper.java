package org.ats_lang.ui.editor.syntaxcoloring;

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;

public class AtsAntlrTokenToAttributeIdMapper extends
		DefaultAntlrTokenToAttributeIdMapper {
	@Override
	protected String calculateId(String tokenName, int tokenType) {
//		System.out.println("tokenName is " + tokenName);
		if("RULE_FUN".equals(tokenName)) {
			return AtsIHighlightingConfiguration.KEYWORD_ID;
		}
		if("RULE_COMMENT_REST".equals(tokenName)) {
			return AtsIHighlightingConfiguration.COMMENT_ID;
		}
		if("RULE_COMMENT_CLIKE".equals(tokenName)) {
			return AtsIHighlightingConfiguration.COMMENT_ID;
		}
		if("RULE_COMMENT_LINE".equals(tokenName)) {
			return AtsIHighlightingConfiguration.COMMENT_ID;
		}
		if("RULE_COMMENT0".equals(tokenName)) {
			return AtsIHighlightingConfiguration.COMMENT_ID;
		}
		if("RULE_LITERAL_EXTCODE".equals(tokenName)) {
			return AtsIHighlightingConfiguration.EXTCODE_ID;
		}
		return AtsIHighlightingConfiguration.DEFAULT_ID;
	}

}
