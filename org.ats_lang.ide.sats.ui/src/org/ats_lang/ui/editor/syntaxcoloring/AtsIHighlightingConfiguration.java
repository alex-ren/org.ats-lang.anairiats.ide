package org.ats_lang.ui.editor.syntaxcoloring;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;

public class AtsIHighlightingConfiguration implements
		IHighlightingConfiguration {

	public static final String KEYWORD_ID = "keyword";
	public static final String COMMENT_ID = "comment";
	public static final String STRING_ID = "string";
	public static final String NUMBER_ID = "number";
	public static final String EXTCODE_ID = "extcode";
	public static final String STACODE_ID = "statics";
	public static final String DYNCODE_ID = "dynamics";
	public static final String SEMANTIC_ID = "semantic_color";
	public static final String IDENTITY_ID = "identity";
	public static final String SPCHAR_ID = "spcharacter";
	public static final String DEFAULT_ID = "default";
	

	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		acceptor.acceptDefaultHighlighting(KEYWORD_ID, "Keyword",
				keywordTextStyle());
		acceptor.acceptDefaultHighlighting(COMMENT_ID, "Comment",
				commentTextStyle());
		acceptor.acceptDefaultHighlighting(STRING_ID, "String",
				stringTextStyle());
		acceptor.acceptDefaultHighlighting(NUMBER_ID, "Number",
				numberTextStyle());
		acceptor.acceptDefaultHighlighting(EXTCODE_ID, "External Code",
				extcodeTextStyle());
		acceptor.acceptDefaultHighlighting(STACODE_ID, "Code in statics",
				staticsTextStyle());
		acceptor.acceptDefaultHighlighting(DYNCODE_ID, "Code in dynamics",
				dynamicsTextStyle());
		acceptor.acceptDefaultHighlighting(IDENTITY_ID, "Identity",
				identityTextStyle());
		
		acceptor.acceptDefaultHighlighting(SEMANTIC_ID, "Semantic Item",
				semantic_colorTextStyle());
		
		acceptor.acceptDefaultHighlighting(SPCHAR_ID, "Special Character",
				spchar_colorTextStyle());
		
		acceptor.acceptDefaultHighlighting(DEFAULT_ID, "default",
				default_colorTextStyle());
	}

	public TextStyle defaultTextStyle() {
		TextStyle textStyle = new TextStyle();
		// textStyle.setBackgroundColor(new RGB(255, 255, 255));
		textStyle.setColor(new RGB(0, 0, 0));
		return textStyle;
	}
	public TextStyle extcodeTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(139, 105, 20));
		return textStyle;
	}
	
	public TextStyle staticsTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(0, 0, 250));
		return textStyle;
	}
	
	public TextStyle dynamicsTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(200, 10, 10));
		return textStyle;
	}
	
	public TextStyle identityTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(0, 0, 0));
		return textStyle;
	}
	
	public TextStyle stringTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(66, 138, 66));
		return textStyle;
	}

	public TextStyle numberTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(26, 26, 26));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}
	
	public TextStyle commentTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(191, 191, 191));
		return textStyle;
	}

	public TextStyle keywordTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(165, 42, 42));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	  public TextStyle semantic_colorTextStyle() {
		    TextStyle textStyle = new TextStyle();
		    textStyle.setStyle(SWT.ITALIC);
		    return textStyle;
	  }
	  
	  public TextStyle spchar_colorTextStyle() {
		    TextStyle textStyle = new TextStyle();
		    return textStyle;
	  }
	  
	  public TextStyle default_colorTextStyle() {
		    TextStyle textStyle = new TextStyle();
		    return textStyle;
	  }
}
