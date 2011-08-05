package org.ats_lang.ui.editor.syntaxcoloring;

import java.util.HashMap;

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;

public class AtsAntlrTokenToAttributeIdMapper extends
		DefaultAntlrTokenToAttributeIdMapper {
	protected HashMap<String, String> m_tokenmap = new HashMap<String, String>();

	AtsAntlrTokenToAttributeIdMapper() {
		m_tokenmap.put("'fun'", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("'val'", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("'castfn'", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("'praxi'", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("'prfun'", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("'prval'", AtsIHighlightingConfiguration.KEYWORD_ID);

		m_tokenmap.put("RULE_AMPERSAND",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_BACKQUOTE",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_BANG", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_BAR", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_COLON", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_DOLLAR", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_DOT", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_EQ", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_HASH", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_TILDE", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_DOTDOT", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_DOTDOTDOT",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_EQGT", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_EQLT", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_EQLTGT", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_EQSLASHEQGT",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_EQGTGT", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_EQSLASHEQGTGT",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_LT", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_GT", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_GTLT", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_DOTLT", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_GTDOT", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_DOTLTGTDOT",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap
				.put("RULE_MINUSGT", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap
				.put("RULE_MINUSLT", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_MINUSLTGT",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap
				.put("RULE_COLONLT", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_COLONLTGT",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap
				.put("RULE_ABSPROP", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap
				.put("RULE_ABSTYPE", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap
				.put("RULE_ABSVIEW", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_ABSVIEWTYPE",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_AND", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_AS", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_ASSUME", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_BEGIN", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_BREAK", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_CASE", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_CLASSDEC",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_CONTINUE",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_DATASORT",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_DATAPARASORT",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_DATAPROP",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_DATATYPE",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_DATAVIEW",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_DATAVIEWTYPE",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_DO", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_DYN", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap
				.put("RULE_DYNLOAD", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_ELSE", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_END", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_EXCEPTION",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_EXTERN", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_FIX", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_FN", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_FOR", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_IF", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_IMPLEMENT",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_IN", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_INFIX", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_INFIXL", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_INFIXR", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_LAM", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_LET", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_LLAM", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_LOCAL", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_MACDEF", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_MACRODEF",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_NONFIX", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_OVERLOAD",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_PAR", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap
				.put("RULE_POSTFIX", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_PREFIX", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_PRFN", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_OF", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_OP", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap
				.put("RULE_PROPDEF", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_REC", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_SCASE", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_SIF", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap
				.put("RULE_SORTDEF", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_STA", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_STADEF", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_STAIF", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap
				.put("RULE_STALOAD", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_STAVAR", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap
				.put("RULE_SYMELIM", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap
				.put("RULE_SYMINTR", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_THEN", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_TRY", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap
				.put("RULE_TYPEDEF", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_RET_T", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_RET_VT", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_VAR", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap
				.put("RULE_VIEWDEF", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_VIEWTYPEDEF",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_WHEN", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_WHERE", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_WHILE", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_WITH", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_WITHPROP",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_WITHTYPE",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_WITHVIEW",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_WITHVIEWTYPE",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_DLRARRSZ",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_DLRDECRYPT",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_DLRDELAY",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_DLRDYNLOAD",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_DLREFFMASK_ALL",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_DLREFFMASK_EXN",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_DLREFFMASK_NTM",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_DLREFFMASK_REF",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_DLREXTERN",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_DLREXTVAL",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_DLREXTYPE",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_DLREXTYPE_STRUCT",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_DLRENCRYPT",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_DLRLDELAY",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_DLRLST", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_LRLST_VT",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_DLRRAISE",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_DLRREC_T",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_DLRREC_VT",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_DLRTUP_T",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_DLRTUP_VT",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_DLRTYPEOF",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_SRPASSERT",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_SRPDEFINE",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap
				.put("RULE_SRPELIF", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_SRPELIFDEF",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_SRPELIFNDEF",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap
				.put("RULE_SRPELSE", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_SRPENDIF",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_SRPERROR",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_SRPIF", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_SRPIFDEF",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_SRPIFNDEF",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_SRPINCLUDE",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_SRPPRINT",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap
				.put("RULE_SRPTHEN", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_SRPUNDEF",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_SRPFILENAME",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_SRPLOCATION",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_SRPCHARCOUNT",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_SRPLINECOUNT",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_CASEMINUS",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_CASEPLUS",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_FNSTAR", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap
				.put("RULE_FORSTAR", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_WHILESTAR",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_ABST0YPE",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_ABSVIEWT0YPE",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_PROPPLUS",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_PROPMINUS",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_TYPEPLUS",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_TYPEMINUS",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_T0YPE", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_T0YPEPLUS",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_T0YPEMINUS",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_VIEWPLUS",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_VIEWMINUS",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_VIEWTYPEPLUS",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_VIEWTYPEMINUS",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_VIEWT0YPE",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_VIEWT0YPEPLUS",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_VIEWT0YPEMINUS",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap
				.put("RULE_VALPLUS", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_VALMINUS",
				AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_FOLDAT", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_FREEAT", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_VIEWAT", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_ATLAM", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_ATLLAM", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_ATFIX", AtsIHighlightingConfiguration.KEYWORD_ID);
		m_tokenmap.put("RULE_R0EAD", AtsIHighlightingConfiguration.KEYWORD_ID);
		
		m_tokenmap.put("RULE_COMMENT_REST",
				AtsIHighlightingConfiguration.COMMENT_ID);
		m_tokenmap.put("RULE_COMMENT_CLIKE",
				AtsIHighlightingConfiguration.COMMENT_ID);
		m_tokenmap.put("RULE_COMMENT_LINE",
				AtsIHighlightingConfiguration.COMMENT_ID);
		m_tokenmap.put("RULE_COMMENT0",
				
				AtsIHighlightingConfiguration.COMMENT_ID);
		m_tokenmap.put("RULE_LITERAL_EXTCODE",
				AtsIHighlightingConfiguration.EXTCODE_ID);
		
		m_tokenmap.put("RULE_STRING",
				AtsIHighlightingConfiguration.STRING_ID);
		m_tokenmap.put("RULE_LITERAL_char",
				AtsIHighlightingConfiguration.STRING_ID);
		
		m_tokenmap.put("RULE_LITERAL_int",
				AtsIHighlightingConfiguration.NUMBER_ID);
		m_tokenmap.put("RULE_LITERAL_intsp",
				AtsIHighlightingConfiguration.NUMBER_ID);
		m_tokenmap.put("RULE_LITERAL_float",
				AtsIHighlightingConfiguration.NUMBER_ID);
		m_tokenmap.put("RULE_LITERAL_floatsp",
				AtsIHighlightingConfiguration.NUMBER_ID);
		
		m_tokenmap.put("RULE_ALNUMRIC_IDENTIFIER",
				AtsIHighlightingConfiguration.IDENTITY_ID);
		m_tokenmap.put("RULE_IDENTIFIER_arr",
				AtsIHighlightingConfiguration.IDENTITY_ID);
		m_tokenmap.put("RULE_IDENTIFIER_tmp",
				AtsIHighlightingConfiguration.IDENTITY_ID);
		m_tokenmap.put("RULE_IDENTIFIER_ext",
				AtsIHighlightingConfiguration.IDENTITY_ID);
		m_tokenmap.put("RULE_IDENTIFIER_dlr",
				AtsIHighlightingConfiguration.IDENTITY_ID);
		m_tokenmap.put("RULE_IDENTIFIER_srp",
				AtsIHighlightingConfiguration.IDENTITY_ID);
		m_tokenmap.put("RULE_SYMBOLIC_IDENTIFIER",
				AtsIHighlightingConfiguration.IDENTITY_ID);
		
		m_tokenmap.put("RULE_LPAREN",
				AtsIHighlightingConfiguration.SPCHAR_ID);
		m_tokenmap.put("RULE_RPAREN",
				AtsIHighlightingConfiguration.SPCHAR_ID);
		m_tokenmap.put("RULE_LBRACKET",
				AtsIHighlightingConfiguration.SPCHAR_ID);
		m_tokenmap.put("RULE_RBRACKET",
				AtsIHighlightingConfiguration.SPCHAR_ID);
		m_tokenmap.put("RULE_LBRACE",
				AtsIHighlightingConfiguration.SPCHAR_ID);
		m_tokenmap.put("RULE_RBRACE",
				AtsIHighlightingConfiguration.SPCHAR_ID);
		m_tokenmap.put("RULE_QUOTELPAREN",
				AtsIHighlightingConfiguration.SPCHAR_ID);
		m_tokenmap.put("RULE_QUOTELBRACKET",
				AtsIHighlightingConfiguration.SPCHAR_ID);
		m_tokenmap.put("RULE_QUOTELBRACE",
				AtsIHighlightingConfiguration.SPCHAR_ID);
		m_tokenmap.put("RULE_ATLPAREN",
				AtsIHighlightingConfiguration.SPCHAR_ID);
		m_tokenmap.put("RULE_ATLBRACKET",
				AtsIHighlightingConfiguration.SPCHAR_ID);
		m_tokenmap.put("RULE_ATLBRACE",
				AtsIHighlightingConfiguration.SPCHAR_ID);
		m_tokenmap.put("RULE_HASHLPAREN",
				AtsIHighlightingConfiguration.SPCHAR_ID);
		m_tokenmap.put("RULE_HASHLBRACKET",
				AtsIHighlightingConfiguration.SPCHAR_ID);
		m_tokenmap.put("RULE_HASHLBRACE",
				AtsIHighlightingConfiguration.SPCHAR_ID);
		m_tokenmap.put("RULE_COMMA",
				AtsIHighlightingConfiguration.SPCHAR_ID);
		m_tokenmap.put("RULE_SEMICOLON",
				AtsIHighlightingConfiguration.SPCHAR_ID);
		m_tokenmap.put("RULE_BACKSLASH",
				AtsIHighlightingConfiguration.SPCHAR_ID);
		m_tokenmap.put("RULE_BACKQUOTELPAREN",
				AtsIHighlightingConfiguration.SPCHAR_ID);
		m_tokenmap.put("RULE_COMMALPAREN",
				AtsIHighlightingConfiguration.SPCHAR_ID);
		m_tokenmap.put("RULE_PERCENTLPAREN",
				AtsIHighlightingConfiguration.SPCHAR_ID);

	}

	@Override
	protected String calculateId(String tokenName, int tokenType) {
		// System.out.println("tokenName is " + tokenName);

		String type = m_tokenmap.get(tokenName);
		if (null != type) {
			return type;
		} else {
			return AtsIHighlightingConfiguration.DEFAULT_ID;
		}
	}

}
