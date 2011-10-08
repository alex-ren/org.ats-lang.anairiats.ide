/*
 * generated by Xtext
 */
package org.ats_lang.ui.labeling;

import org.ats_lang.anairiatsSats.*;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 * 
 * see
 * http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class AnairiatsSatsLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	public AnairiatsSatsLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}


	protected String text(d0ecseq_dyn_rev ele) {
		return "d0ecseq_dyn_rev";
	}

	protected String text(d0ec_dyn_ext ele) {
		dcstkind m_kind = ele.getM_kind();
		String funname = ((d0cstdec) ele.getName()).getName();
		return "extern " + m_kind.toString() + " " + funname + " (d0ec_dyn_ext)";
	}

	protected String text(d0ec ele) {
		String kind = ele.getM_kind();
		if (kind.equals("symintr")) {
			return "symintr " + cleanText(ele.getM_i0deseq()) + "(d0ec)";
		} else if (kind.equals("#undef")) {
			return "#undef " + ele.getM_i0de();
		} else if (kind.equals("#define")) {
			refi0de ref = (refi0de)ele.getM_def_refi0de();
			return "#define " + cleanText(ref) + " (dec)";
		} else if (kind.equals("sortdef")) {
			return "sortdef " + ele.getM_d0rtdef().getM_id() + " (dec)";
		} else if (kind.equals("datasort")) {
			return "sortdef " + ele.getM_d0atsrtdec().getM_d0de() + " (dec)";
		} else if (kind.equals("dataparasort")) {
			return "sortdef " + ele.getM_d0atsrtdec().getM_d0de() + " (dec)";
		} else if (kind.equals("absprop") || kind.equals("abstype") || 
				kind.equals("abst@ype") || kind.equals("absview") || 
				kind.equals("absviewtype") || kind.equals("absviewt@ype")) {
			return kind + " " + ele.getM_s0tacon().getM_si0de() + " (d0ec)";
		} else if (kind.equals("sta")) {
			return "sta " + ele.getM_s0tacst().getM_si0de() + " (d0ec)";
		} else if (kind.equals("stavar")) {
			return "stavar " + ele.getM_s0tavar().getM_si0de() + " (d0ec)";
		} else if (kind.equals("stadef") || kind.equals("propdef") || 
				kind.equals("typedef") || kind.equals("viewdef") || 
				kind.equals("viewtypedef")) {
			return kind + " " + ele.getM_s0expdef().getM_si0de() + " (d0ec)";
		} else if (kind.equals("assume")) {
			return "assume " + cleanText(ele.getM_s0asdec().getM_sqi0de()) + " (d0ec)";
		} else if (kind.equals("dataprop") || kind.equals("datatype") || 
				kind.equals("dataview") || kind.equals("dataviewtype")) {
			return kind + " " + ele.getM_d0atdec().getM_si0de() + " (d0ec)";
		} else if (kind.equals("exception")) {
			return "exception " + cleanText((e0xndec)ele.getM_e0xndec()) + " (d0ec)";
		} else if (kind.equals("classdec")) {
			return "classdec " + ele.getM_si0de() + " (d0ec)";
		} else if (kind.equals("overload")) {
			String text = "overload";
			refdi0de ref = (refdi0de)ele.getM_di0de();
			if (null == ref) {
				text += " [] with ";
			} else {
				text += " " + cleanText(ref) + " with ";
			}
			
			ICompositeNode actNode = NodeModelUtils.findActualNodeFor(ele);
			INode nameINode = actNode.getLastChild();
			Iterable<ILeafNode> leafNodes = nameINode.getLeafNodes();
//			System.out.println("=============================");
			
			String m_name = "";
			for (ILeafNode leafNode : leafNodes) {
				if (leafNode.isHidden() == false) {
//					System.out.println("==== leafNode is " + leafNode.getText());
					m_name += leafNode.getText();
				}
			}
			text += m_name;
			return text;
		} else if (kind.equals("macdef") || kind.equals("macrodef")) {
			return kind + " " + cleanText((m0acdef)ele.getM_m0acdef()) + " (d0ec)";
		} else if (kind.equals("staload") || kind.equals("dynload")) {
			String loadPath = ele.getImportURI();
			return kind + " " + loadPath + " (d0ec)";
		} else {
			return kind;
		}
	}

	protected String text(d0ec_dyn_ext_val ele) {
		String m_str = ele.getM_str();
		return "extern val " + m_str + " (d0ec_dyn_val)";
	}


	protected String text(refi0de ele) {
		return cleanText(ele);
	}
	
	protected String cleanText(refi0de ele) {
		return ele.getName();
	}
	
	protected String text(e0xndec ele) {
		return cleanText(ele) + " (e0xndec)";
	}
	
	protected String cleanText(e0xndec ele) {
		return ele.getName();
	}
	
	protected String text(m0acdef ele) {
		return cleanText(ele) + " (m0acdef)";
	}
	
	protected String cleanText(m0acdef ele) {
		return ele.getName();
	}
	
	protected String text(andm0acdefseq ele) {
		return "andm0acdefseq";
	}
	
	protected String text(m0arg ele) {
		return ele.getName() + " (m0arg)";
	}
	
	protected String text(v0ardec ele) {
		return ele.getName() + " (v0ardec)";
	}

	protected String cleanText(i0deseq ele) {
		EList<refentity> refList = ele.getM_i0des();
		String text = "";
		for (refentity ref: refList) {
			text = text + text((refi0de)ref) + " ";
		}
		return text;
	}
	
	protected String text(d0atcon ele) {
		return "d0atcon";
	}
	
	protected String text(d0cstdec ele) {
		return ele.getName() + " (d0cstdec)";	

	}

	protected String text(i0nvarg ele) {
		return ele.getName() + " (i0nvarg)";
	}

	protected String text(d0ec_dyn_val ele) {
		String m_valkind = ele.getM_valkind();
		refentity m_atmp0at = ele.getM_v0aldec().getName().getName();
		String name = text(m_atmp0at);
		return m_valkind + " " + name + " (d0ec_dyn_val)";
	}
	
	protected String text(d0ec_dyn_val_par ele) {
		refentity m_atmp0at = ele.getM_v0aldec().getName().getName();
		return "val par " + text(m_atmp0at) + "(d0ec_dyn_val_par)";
	}

	protected String text(d0ec_dyn_val_rec ele) {
		refentity m_atmp0at = ele.getM_v0aldec().getName().getName();
		return "val rec " + text(m_atmp0at) + "(d0ec_dyn_val_rec)";
	}

	protected String text(literal_atmp0at ele) {
		return ele.getLiteral_name() + "(literal_atmp0at)";
	}

	protected String text(simple_atmp0at ele) {
		return ele.getName() + "(simple_atmp0at)";
	}

	protected String text(compound_atmp0at ele) {
		return "compound element" + "(compound_atmp0at)";
	}

	protected String text(d0ec_dyn_fun ele) {
		String m_funkind = ele.getM_funkind();
		f0undec m_f0undec = (f0undec) ele.getM_fundec();
		String m_name = m_f0undec.getName();
		return m_funkind + " " + m_name + "(d0ec_dyn_fun)";
	}
	
	protected String text(decs0argseqseq ele) {
		return "decs0argseqseq";
	}
	
	protected String text(i0mpdec ele) {
		return "i0mpdec";
	}
	
	protected String text(impqi0de ele) {
		return "impqi0de";
	}
	
	protected String text(f0arg2seq ele) {
		return "f0arg2seq";
	}
	
	protected String text(colons0expopt ele) {
		return "colons0expopt";
	}

	protected String text(f0undec ele) {
		return "f0undec: " + ele.getName();
	}

	
	protected String text(witht0ype ele) {
		return "witht0ype";
	}
	
	protected String text(d0ec_dyn_var ele) {
		v0ardec m_v0ardec = (v0ardec)ele.getM_v0ardec();
		String m_name = m_v0ardec.getName();
		return "var " + m_name + "(d0ec_dyn_var)";
	}

	protected String text(d0ec_dyn_impl ele) {
		i0mpdec m_i0mpdec = ele.getM_i0mpdec();
		impqi0de m_imp = m_i0mpdec.getM_imp();
		
		ICompositeNode actNode = NodeModelUtils.findActualNodeFor(m_imp);
		INode nameINode = actNode.getFirstChild();
		Iterable<ILeafNode> leafNodes = nameINode.getLeafNodes();
//		System.out.println("=============================");
		
		String m_name = "";
		// e.g. implement /*comment*/ foo () = ()
		// leafnode 1 is blank  -- hidden
		// leafnode 2 is /*comment*/  -- hidden
		// leafnode 3 is foo  -- not hidden
		for (ILeafNode leafNode : leafNodes) {
			if (leafNode.isHidden() == false) {
//				System.out.println("==== leafNode is " + leafNode.getText());
				m_name += leafNode.getText();
			}
		}
//		System.out.println("=============================");
		return "implement " + m_name + " (d0ec_dyn_impl)";
	}

	protected String text(d0ec_dyn_local ele) {
		return "d0ec_dyn_local";
	}

	protected String text(f0arg1seq ele) {
		return "f0arg1seq";
	}

	protected String text(d0ec_dyn_extcode ele) {
		return "external code (d0ec_dyn_extcode)";
	}

	protected String text(d0ec_dyn_srpif ele) {
		return ele.getM_ifkind() + " (d0ec_dyn_srpif)";
	}

	protected String text(d0ec_dyn_incl ele) {
		return "#include (d0ec_dyn_incl)";
	}

	protected String text(d0expbase ele) {
		return "d0expbase";
	}

	protected String text(d0expcase ele) {
		return "d0expcase";
	}

	protected String text(d0expgo ele) {
		return "d0expgo";
	}

	protected String text(d0exp ele) {
		return "d0exp";
	}

	protected String text(argd0expseq1 ele) {
		return "argd0expseq1";
	}

	protected String text(argd0exp ele) {
		return "argd0exp";
	}

	protected String text(atmd0exp_argd0exp ele) {
		return "atmd0exp_argd0exp";
	}

	protected String text(s0exp ele) {
		return "s0exp";
	}

	protected String text(apps0exp ele) {
		return "apps0exp";
	}

	protected String text(exts0exp ele) {
		return "exts0exp";
	}

	protected String text(d0ecargseq ele) {
		return "d0ecargseq";
	}

	protected String text(s0argseqseq ele) {
		return "s0argseqseq";
	}

	protected String text(apps0expA ele) {
		return "apps0expA";
	}

	protected String text(apps0expB ele) {
		return "apps0expB";
	}

	protected String text(apps0expC ele) {
		return "apps0expC";
	}

	protected String text(atms0expA ele) {
		return "atms0expA";
	}

	protected String text(atms0expB ele) {
		return "atms0expB";
	}

	protected String text(atms0expC ele) {
		return "atms0expC";
	}

	protected String text(s0quaseq ele) {
		return "s0quaseq";
	}

	protected String text(f0arg1 ele) {
		return "f0arg1";
	}

	protected String text(f0arg1_sta ele) {
		return "f0arg1_sta";
	}
	
	
	protected String text(d0expsemiseq0 ele) {
		return "d0expsemiseq0";
	}
	
	protected String text(v0aldec ele) {
		return "v0aldec";
	}
	
	protected String text(andv0aldecseq ele) {
		return "andv0aldecseq";
	}
	
	protected String text(p0at ele) {
		return "p0at";
	}
	
	protected String text(p0atseq ele) {
		return "p0atseq";
	}

	protected String text(commabarp0atseq ele) {
		return "commabarp0atseq";
	}
	
	protected String text(argp0atseq ele) {
		return "argp0atseq";
	}
	
	protected String text(d0argseq ele) {
		return "d0argseq";
	}
	

	protected String text(d0arg ele) {
		return "d0arg";
	}
	
	protected String text(andd0cstdecseq ele) {
		return "andd0cstdecseq";
	}
	
	protected String text(extnamopt ele) {
		return "extnamopt";
	}
	
	protected String text(f0arg2 ele) {
		return "f0arg2";
	}
	
	protected String text(guap0at ele) {
		return "guap0at";
	}
	
	protected String text(d0expbasei ele) {
		return "d0expbasei";
	}
	
	protected String text(argd0expseq1i ele) {
		return "argd0expseq1i";
	}
	
	protected String text(argd0expi ele) {
		return "argd0expi";
	}
	
	protected String text(atmd0exp_argd0expi ele) {
		return "atmd0exp_argd0expi";
	}

	protected String text(caseinv ele) {
		return "caseinv";
	}
	
	protected String text(m0acarg ele) {
		return "m0acarg";
	}
	
	protected String text(satprogram ele) {
		return "satprogram";
	}

	protected String text(d0ecseq_sta ele) {
		return "Program (d0ecseq_sta)";
	}

	protected String text(d0ec_sta ele) {
		// m_d0ec=d0ec
		if (ele.getM_d0ec() != null) {
			return "d0ec";
		}
		
		// m_extcode=LITERAL_extcode
		if (ele.getM_extcode() != null) {
			return "extcode";
		}
		
		// m_sif=srpifkind m_guad=guad0ec_sta
		String sif = ele.getM_sif();
		if (sif != null) {
			return sif;
		}
		
		// SRPINCLUDE m_include=STRING
		if (ele.getM_include() != null) {
			return "#include";
		}
		
		// LOCAL m_local=d0ecseq_sta IN m_body=d0ecseq_sta END
		if (ele.getM_local() != null) {
			return "local";
		}
		
		dcstkind m_kind = ele.getM_kind();
		if (m_kind != null) {
//			System.out.println("literal is " + m_kind.getLiteral());  // fun
//			System.out.println("name is " + m_kind.getName());  // FUN
//			System.out.println(m_kind.toString());  // fun
			
			refentity m_d0cstdec = ele.getName();
			return m_kind.toString() + " " + ((d0cstdec)m_d0cstdec).getName();
		}
		
		return "d0ec_sta";
	}

	protected String text(d0ecseq_sta_rev ele) {
		return "d0ecseq_sta_rev";
	}

	protected String text(dcstkind ele) {
		return ele.toString();
	}
	
	protected String text(guad0ec_sta ele) {
		return "guad0ec_sta";
	}
	
	protected String text(colonwith ele) {
//		String m_colon = ele.getM_colon();
//		if (m_colon != null) {
//			return m_colon;
//		}
//		
//		
		return "fun type: colonwith";
	}

	protected String text(d0arg_dyn ele) {
		return "d0arg_dyn";
	}

	protected String text(d0arg_sta ele) {
		return "d0arg_sta";
	}

	protected String text(p0argseq ele) {
		return "p0argseq";
	}

	protected String text(commap0argseq ele) {
		return "commap0argseq";
	}
	
	protected String text(p0arg ele) {
		return ele.getName() + " (p0arg)";
	}

	protected String text(d0ecarg ele) {
		return "d0ecarg";
	}
	
	protected String text(commasi0deseq ele) {
		return "commasi0deseq";
	}
	
	protected String text(s0rtext ele) {
		return "s0rtext";
	}
		
	protected String text(s0expseq ele) {
		return "s0expseq";
	}
		
	protected String text(labs0expseq ele) {
		return "labs0expseq";
	}
	
	protected String text(commalabs0expseq ele) {
		return "commalabs0expseq";
	}
	
	protected String text(m0acargseq ele) {
		return "m0acargseq";
	}
	
	protected String text(m0argseq ele) {
		return "m0argseq";
	}
	
	protected String text(commam0argseq ele) {
		return "commam0argseq";
	}

	protected String text(d0expcommabarsemiseq ele) {
		return "d0expcommabarsemiseq";
	}

	protected String text(commabarsemid0expseq ele) {
		return "commabarsemid0expseq";
	}
	
	protected String text(refdi0de ele) {
		return cleanText(ele) + " (refdi0de)" ;
	}
	
	protected String cleanText(refdi0de ele) {
		return ele.getName();
	}
	
	protected String text(s0expseq1 ele) {
		return "s0expseq1";
	}
	
	protected String text(commabars0expseq ele) {
		return "commabars0expseq";
	}
	
	protected String cleanText(sqi0de ele) {
		return ele.getM_s0taq() + ele.getM_si0de();
	}

	protected String text(d0atdec ele) {
		return "d0atdec";
	}
	
	protected String text(andd0atdecseq ele) {
		return "andd0atdecseq";
	}
	
	protected String text(s0expdefseqopt ele) {
		return "s0expdefseqopt";
	}
	
	protected String text(d0atargseq ele) {
		return "d0atargseq";
	}
	
	protected String text(d0atconseq ele) {
		return "d0atconseq";
	}
	
	protected String text(s0expdef ele) {
		return "s0expdef";
	}
	
	protected String text(colons0rtopt ele) {
		return "colons0rtopt";
	}
	
	protected String text(ands0expdefseq ele) {
		return "ands0expdefseq";
	
	}


	
	
	// This one gets called.
	protected String text(refentity ele) {
		String name;
		if (ele instanceof simple_atmp0at) {
			name = text((simple_atmp0at) ele);
		} else if (ele instanceof literal_atmp0at) {
			name = text((literal_atmp0at) ele);
		} else if (ele instanceof compound_atmp0at) {
			name = text((compound_atmp0at) ele);
		} else if (ele instanceof f0undec) {
			name = text((f0undec) ele);
		} else if (ele instanceof d0cstdec) {
			name = text((d0cstdec) ele);
		} else if (ele instanceof refi0de) {
			return text((refi0de) ele);
		} else if (ele instanceof d0atcon) {
			return text((d0atcon) ele);
		} else if (ele instanceof e0xndec) {
			return text((e0xndec)ele);
		} else if (ele instanceof refdi0de) {
			return text((refdi0de)ele);
		} else if (ele instanceof m0acdef) {
			return text((m0acdef)ele);
		} else if (ele instanceof v0ardec) {
			return text((v0ardec)ele);
		} else if (ele instanceof i0nvarg) {
			name = text((i0nvarg)ele);
		} else if (ele instanceof m0arg) {
			name = text((m0arg)ele);
		} else {
			name = "you should not see me";
		}
		return name;
	}
	
	/*
	 * //Labels and icons can be computed like this:
	 * 
	 * String image(MyModel ele) { return "MyModel.gif"; }
	 */
}
