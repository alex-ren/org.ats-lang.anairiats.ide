package org.ats_lang.valueconverting;

import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractDeclarativeValueConverterService;
import org.eclipse.xtext.conversion.impl.STRINGValueConverter;
import org.eclipse.xtext.nodemodel.INode;

import com.google.inject.Inject;


//refer to DefaultTerminalConverters as example
public class AtsValueConverterService extends AbstractDeclarativeValueConverterService{

	@Inject
	private AtsSTRINGValueConverter stringValueConverter;
	
	@ValueConverter(rule = "tmpqi0de")
	// The name of the following function doesn't matter.
	public IValueConverter<String> conv_tmpqi0de() {
		return NO_OP_TMP_CONVERTER;
	}
	
	@ValueConverter(rule = "STRING")
	// The name of the following function doesn't matter.
	public IValueConverter<String> conv_STRING() {
		return stringValueConverter;
	}
	
	@ValueConverter(rule = "SATS_STRING")
	// The name of the following function doesn't matter.
	public IValueConverter<String> conv_SATS_STRING() {
		return stringValueConverter;
	}
	
	IValueConverter<String> NO_OP_TMP_CONVERTER = new IValueConverter<String>() {
		public String toString(String value) {
			return value;
		}
		public String toValue(String string, INode node) {
			if (string.endsWith("<")) {
				return string.substring(0, string.length() - 1);
			} else {
				System.out.println("String toValue(String string: You should not see me");
				return string;
			}
		}
	};
//	
//	@Override
//	public Object toValue(String string, String lexerRule, INode node) throws ValueConverterException {
//		System.out.println("==============toValue rule is " + lexerRule);
//		return super.toValue(string, lexerRule, node);
//	}

}
