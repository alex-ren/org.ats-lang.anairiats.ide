/*
 * generated by Xtext
 */
package org.ats_lang.ui.outline;

import org.ats_lang.anairiatsSats.*;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;

/**
 * customization of the default outline structure
 * 
 */
public class AnairiatsSatsOutlineTreeProvider extends
		DefaultOutlineTreeProvider {
	protected void _createChildren(DocumentRootNode parentNode,
			satprogram staprog) {
		d0ecseq_sta a1 = staprog.getM_sta();
		if (a1 == null) {
			System.out.println("a1 == null");
			return;
		}
		createNode(parentNode, a1);

	}

	protected void _createChildren(IOutlineNode parentNode, d0ecseq_sta seq) {
		d0ecseq_sta_rev a2 = seq.getM_d0ecseq_sta_rev();
		if (a2 == null) {
			System.out.println("a2 == null");
			return;
		}

		EList<d0ec_sta> lst = a2.getM_d0ec_sta();
		if (lst == null) {
			System.out.println("lst");
			return;
		}
		
		for (d0ec_sta n : lst) {
			d0ec m_d0ec = n.getM_d0ec();
			if (m_d0ec != null) {
				createNode(parentNode, m_d0ec);
			}
			else
			{
			    createNode(parentNode, n);
			}
			// show the recursive definition
			andd0cstdecseq m_seq = n.getM_seq();
			if (m_seq != null) {
				EList<refentity> m_andd0cstdecseq = m_seq.getM_andd0cstdecseq();
				for (refentity node: m_andd0cstdecseq) {
					createNode(parentNode, node);
				}
			}
		}
	}
    
	protected void _createChildren(IOutlineNode parentNode, d0ec_sta ele) {
		/* m_d0ec=d0ec */
		if (ele.getM_d0ec() != null) {
			System.out.println("This should not happen. (m_d0ec=d0ec)");
			createNode(parentNode, ele.getM_d0ec());
			return;
		}
			
		/* m_kind=dcstkind */
		// template args
		createNode(parentNode, ele.getM_tmparg());
		
//		d0cstdec: 
//		    name=di0de  // list_insert
//		    m_d0argseq=d0argseq  // {x: int} (x: int)
//		    m_col=colonwith  // :<fun>
//		    m_s0exp=s0exp  // int
//		    m_extname=extnamopt  // = "foo"
//		    ;
		d0cstdec m_d0cstdec = (d0cstdec)ele.getName();
		// args
		createNode(parentNode, m_d0cstdec.getM_d0argseq());
		// fun type
		createNode(parentNode, m_d0cstdec.getM_col());
		// return type
		createNode(parentNode, m_d0cstdec.getM_s0exp());
		// external name
		createNode(parentNode, m_d0cstdec.getM_extname());
		return;
	}
		
	
}
