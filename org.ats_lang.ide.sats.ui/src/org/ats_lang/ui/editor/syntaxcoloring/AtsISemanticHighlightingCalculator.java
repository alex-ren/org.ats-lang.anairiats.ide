package org.ats_lang.ui.editor.syntaxcoloring;

import org.ats_lang.anairiatsSats.atmd0exp_argd0exp;
import org.ats_lang.anairiatsSats.atms0expA;
import org.ats_lang.anairiatsSats.atms0expA_base;
import org.ats_lang.anairiatsSats.atms0rt;
import org.ats_lang.anairiatsSats.commasi0deseq;
import org.ats_lang.anairiatsSats.d0atarg;
import org.ats_lang.anairiatsSats.d0atcon;
import org.ats_lang.anairiatsSats.d0atcon_di0de;
import org.ats_lang.anairiatsSats.d0atdec;
import org.ats_lang.anairiatsSats.d0ec;
import org.ats_lang.anairiatsSats.d0exp;
import org.ats_lang.anairiatsSats.s0exp;
import org.ats_lang.anairiatsSats.s0qua;
import org.ats_lang.anairiatsSats.simple_atmp0at;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.BidiIterable;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;

public class AtsISemanticHighlightingCalculator implements
		ISemanticHighlightingCalculator {
	public void provideHighlightingFor(XtextResource resource,
			IHighlightedPositionAcceptor acceptor) {
		if (resource == null || resource.getParseResult() == null)
			return;
		INode root = resource.getParseResult().getRootNode();
		for (INode node : root.getAsTreeIterable()) {
			// EObject gramm = node.getGrammarElement();
			// if (null != gramm) {
			// System.out.println("gramm element is " + gramm.toString());
			// } else {
			// System.out.println("gramm element is null");
			// }
			// EObject seman = node.getSemanticElement();
			// if (null != seman) {
			// System.out.println("seman element is " + seman.toString());
			// } else {
			// System.out.println("seman element element is null");
			// }

			// if (node.getSemanticElement() != null) {
			// System.out.println("1 "
			// + NodeModelUtils.findActualSemanticObjectFor(node)
			// .eClass().getName());
			// } else
			// System.out.println("1 + ==============");
			// System.out.println("");

			if (node.hasDirectSemanticElement() == true) {
				EObject semantic_ele = node.getSemanticElement();
				String name = semantic_ele.eClass().getName();
				System.out.println("name is " + name);

				// val (x, y) = ...
				if (semantic_ele instanceof simple_atmp0at) {
					acceptor.addPosition(node.getOffset(), node.getLength(),
							AtsIHighlightingConfiguration.DYNCODE_ID);
				}

				// statics
				if (semantic_ele instanceof atms0expA_base) {
					acceptor.addPosition(node.getOffset(), node.getLength(),
							AtsIHighlightingConfiguration.STACODE_ID);
				}

				// ... = (1, 2)
				if (semantic_ele instanceof atmd0exp_argd0exp) {
					atmd0exp_argd0exp d0exp_ele = (atmd0exp_argd0exp) semantic_ele;

					if (d0exp_ele.getM_di0de() != null
							|| d0exp_ele.getM_content() != null) {
						acceptor.addPosition(node.getOffset(),
								node.getLength(),
								AtsIHighlightingConfiguration.DYNCODE_ID);
					}
				}

				// staload xxx = "..."
				if (semantic_ele instanceof d0ec) {
					d0ec d0ec_ele = (d0ec) semantic_ele;

					if (d0ec_ele.getM_stai0de() != null) {
						ICompositeNode cnode = NodeModelUtils
								.findActualNodeFor(semantic_ele);

						Iterable<ILeafNode> leaf_nodes = cnode.getLeafNodes();
						// BidiIterable<INode> all_nodes = cnode.getChildren();

						int count = 0;
						for (ILeafNode ele : leaf_nodes) {
							if (!ele.isHidden()) {
								count++;
								if (2 == count) {
									acceptor
											.addPosition(
													ele.getOffset(),
													ele.getLength(),
													AtsIHighlightingConfiguration.STACODE_ID);
									break;
								}
							}
						}
					}
				}

				// datatype xxx = ...
				if (semantic_ele instanceof d0atdec) {
					ICompositeNode cnode = NodeModelUtils
							.findActualNodeFor(semantic_ele);
					INode ele = cnode.getFirstChild();
					acceptor.addPosition(ele.getOffset(), ele.getLength(),
							AtsIHighlightingConfiguration.STACODE_ID);
				}

				// demonstrate the difference between "cnode.getChildren()"
				// and "cnode.getLeafNodes()"
				if (semantic_ele instanceof d0atcon) {
					ICompositeNode cnode = NodeModelUtils
							.findActualNodeFor(semantic_ele);
					BidiIterable<INode> all_nodes = cnode.getChildren();
					for (INode ele : all_nodes) {
						System.out.println("=== >" + ele.getText() + "<");
					}

					System.out.println("999999999999999999999");
					Iterable<ILeafNode> leaf_nodes = cnode.getLeafNodes();
					for (ILeafNode ele : leaf_nodes) {
						System.out.println("=== >" + ele.getText() + "<");
					}
				}

				// | cons (...) of ...
				if (semantic_ele instanceof d0atcon_di0de) {
					acceptor.addPosition(node.getOffset(), node.getLength(),
							AtsIHighlightingConfiguration.DYNCODE_ID);
				}
				
				// | {x: ...} cons (...) of ...
				if (semantic_ele instanceof s0qua) {
					ICompositeNode cnode = NodeModelUtils
					.findActualNodeFor(semantic_ele);
					INode ele = cnode.getFirstChild();
					acceptor.addPosition(ele.getOffset(), ele.getLength(),
							AtsIHighlightingConfiguration.STACODE_ID);
				}
				
				// | {x, y: ...} cons (...) of ...
				if (semantic_ele instanceof commasi0deseq) {
					ICompositeNode cnode = NodeModelUtils
					   .findActualNodeFor(semantic_ele);
					BidiIterable<INode> all_nodes = cnode.getChildren();
					for (INode ele: all_nodes) {
						if (!ele.getText().equals(",")) {
							acceptor.addPosition(ele.getOffset(), ele.getLength(),
									AtsIHighlightingConfiguration.STACODE_ID);
						}
					}
				}
				
				// | {x, y: int}
				if (semantic_ele instanceof atms0rt) {
					atms0rt ele = (atms0rt)semantic_ele;
					if (ele.getM_s0rtid() != null) {
						acceptor.addPosition(node.getOffset(), node.getLength(),
								AtsIHighlightingConfiguration.STACODE_ID);
					}
				}
				
				if (semantic_ele instanceof d0atarg) {
					d0atarg d0atarg_ele = (d0atarg)semantic_ele;
					if (d0atarg_ele.getM_i0de() != null) {
						ICompositeNode cnode = NodeModelUtils
						   .findActualNodeFor(semantic_ele);
						INode ele = cnode.getFirstChild();
						acceptor.addPosition(ele.getOffset(), ele.getLength(),
								AtsIHighlightingConfiguration.STACODE_ID);
					}
					
				}

			} else {
				System.out.println("no name at all");
			}
		}
	}

}
