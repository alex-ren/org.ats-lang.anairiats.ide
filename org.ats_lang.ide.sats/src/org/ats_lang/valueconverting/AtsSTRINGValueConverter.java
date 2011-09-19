package org.ats_lang.valueconverting;

import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.STRINGValueConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

public class AtsSTRINGValueConverter extends STRINGValueConverter {
	@Override
	public String toValue(String string, INode node) {
		if (string == null)
			return null;
		try {
			return Strings.convertFromJavaString(string.substring(1, string.length() - 1), true);
		} catch (IllegalArgumentException e) {
			return string;
		}
	}
}
