/*
 * generated by Xtext
 */
package org.ats_lang.ui.labeling;

import org.ats_lang.anairiatsSats.*;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 * 
 * see
 * http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class AnairiatsDatsLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	public AnairiatsDatsLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	String text(d0ecseq_dyn_rev ele) {
		return "Program";
	}
	
	String text(d0ec_dyn_ext ele) {
		dcstkind m_kind = ele.getM_kind();
		String funname = ((d0cstdec)ele.getName()).getName();
		return "extern " + m_kind.toString() + " " + funname;
	}
	
	String text(d0ec_dyn_ext_val ele) {
		String m_str = ele.getM_str();
		return "extern val " + m_str;
	}
	
	String text(d0ec_dyn_val ele) {
		String m_valkind = ele.getM_valkind();
		refentity m_atmp0at = ele.getM_v0aldec().getName().getName();
		String name = text(m_atmp0at);
		return m_valkind + " " + name;
	} 
	
	String text(refentity ele) {
		String name;
		if (ele instanceof simple_atmp0at) {
			name = text((simple_atmp0at)ele);
		} else if (ele instanceof literal_atmp0at) {
			name = text((literal_atmp0at)ele);
		} else if (ele instanceof compound_atmp0at) {
			name = text((compound_atmp0at)ele);
		} else if (ele instanceof f0undec) {
			name = text((f0undec)ele);

		} else if (ele instanceof d0cstdec) {
			name = text((d0cstdec)ele);
		} else if (ele instanceof i0nvarg) {
			name = text((i0nvarg)ele);
		} else{
			name = "you should not see me";
		}
		return name;
	}
	String text(d0cstdec ele) {
		return ele.getName();
		
	}
	String text(i0nvarg ele) {
		return ele.getName();
	}
	
	String text(d0ec_dyn_val_par ele) {
		refentity m_atmp0at = ele.getM_v0aldec().getName().getName();
		return "val par " + text(m_atmp0at);
	}
	
	String text(d0ec_dyn_val_rec ele) {
		refentity m_atmp0at = ele.getM_v0aldec().getName().getName();
		return "val rec " + text(m_atmp0at);
	}
	
	String text(literal_atmp0at ele) {
		return ele.getLiteral_name();
	}
	
	String text(simple_atmp0at ele) {
		return ele.getName();
	}
	
	String text(compound_atmp0at ele) {
		return "compound element";
	}
	String text(d0ec_dyn_fun ele) {
		String m_funkind = ele.getM_funkind();
		f0undec m_f0undec = (f0undec)ele.getM_fundec();
		String m_name = m_f0undec.getName();
		return m_funkind + " " + m_name;
	}
	
	String text(f0undec ele) {
		return ele.getName();
	}
	
	String text(d0ec_dyn_var ele) {
		v0ardec m_v0ardec = ele.getM_v0ardec();
		String m_name = m_v0ardec.getName();
		return "var " + m_name;
	}
	
	String text(d0ec_dyn_impl ele) {
		i0mpdec m_i0mpdec = ele.getM_i0mpdec();
		impqi0de m_imp = m_i0mpdec.getM_imp();
		String m_name = "xx";  // m_imp.getName();  // todo

		return "implement " + m_name;
	}
	
	String text(d0ec_dyn_local ele) {
		return "local";
	}
	
	String text(d0ec_dyn_extcode ele) {
		return "external code";
	}
	
	String text(d0ec_dyn_srpif ele) {
		return ele.getM_ifkind();
	}
	
	String text(d0ec_dyn_incl ele) {
		return "#include";
	}
	
	String text(d0expbase ele) {
		return "d0expbase";
	}
	
	String text(d0expcase ele) {
		return "d0expcase";
	}
	
	String text(d0expgo ele) {
		return "d0expgo";
	}
	
	String text(d0exp ele) {
		return "d0exp";
	}
	
	String text(argd0expseq1 ele) {
		return "argd0expseq1";
	}
	
	String text(argd0exp ele) {
		return "argd0exp";
	}
	String text(atmd0exp_argd0exp ele) {
		return "atmd0exp_argd0exp";
	}

	/*
	 * //Labels and icons can be computed like this:
	 * 
	 * String text(MyModel ele) { return "my "+ele.getName(); }
	 * 
	 * String image(MyModel ele) { return "MyModel.gif"; }
	 */
}
