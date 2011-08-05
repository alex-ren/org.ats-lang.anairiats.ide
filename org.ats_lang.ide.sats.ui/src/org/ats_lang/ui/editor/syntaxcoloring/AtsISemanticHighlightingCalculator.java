package org.ats_lang.ui.editor.syntaxcoloring;

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
//			if (node.getSemanticElement() != null) {
//				System.out.println("1 "
//						+ NodeModelUtils.findActualSemanticObjectFor(node)
//								.eClass().getName());
//			} else
//				System.out.println("1 + ==============");
//			System.out.println("");

			if (node.hasDirectSemanticElement() == true) {
				String name = node.getSemanticElement().eClass().getName();
				if (name.equals("f0arg1_sta")
						|| name.equals("d0arg_sta")) {
					acceptor.addPosition(node.getOffset(), node.getLength(),
							AtsIHighlightingConfiguration.STACODE_ID);
				}
				
				if (name.equals("d0arg_dyn")) {
					acceptor.addPosition(node.getOffset(), node.getLength(),
							AtsIHighlightingConfiguration.DYNCODE_ID);
				}

			}
		}
	}

}
