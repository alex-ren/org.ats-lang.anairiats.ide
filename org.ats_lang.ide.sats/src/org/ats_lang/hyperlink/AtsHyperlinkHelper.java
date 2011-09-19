package org.ats_lang.hyperlink;

import java.util.List;

import org.ats_lang.anairiatsSats.d0ec;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkHelper;
import org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkLabelProvider;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkAcceptor;
import org.eclipse.xtext.ui.editor.hyperlinking.XtextHyperlink;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class AtsHyperlinkHelper extends HyperlinkHelper {
	@Inject
	@HyperlinkLabelProvider
	private ILabelProvider labelProvider;

	@Inject
	private Provider<XtextHyperlink> hyperlinkProvider;

	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	@Override
	public IHyperlink[] createHyperlinksByOffset(XtextResource resource,
			int offset, boolean createMultipleHyperlinks) {
		// System.out.println("offset is " + offset);

		IHyperlink[] links = super.createHyperlinksByOffset(resource, offset,
				createMultipleHyperlinks);
		if (null != links) {
			return links;
		}

		// handle the import statement
		EObject obj = eObjectAtOffsetHelper.resolveElementAt(resource, offset);
		if (!(obj instanceof d0ec)) {
			return null;
		}

		d0ec staloaddec = (d0ec) obj;
		String loadname = staloaddec.getM_kind();
		
		String loadPath = null;
		if (loadname.equals("staload")) {
			loadPath = staloaddec.getImportURI();
//			if (null == loadPath) {
//				loadPath = staloaddec.getFilename();
//			}
		} else if (loadname.equals("dynload")) {
//			loadPath = staloaddec.getFilename();
			loadPath = staloaddec.getImportURI();
		} else {
			return null;
		}
//		System.out.println("path is " + loadPath);

		// must click on the string
		ICompositeNode cnode = NodeModelUtils.findActualNodeFor(staloaddec);
		INode pathnode = cnode.getLastChild();
		int pathoffset = pathnode.getOffset();
		int pathlen = pathnode.getLength();
		if (offset < pathoffset || offset >= (pathoffset + pathlen)) {
			return null;
		}

		// URI of current resource
		String curpath = resource.getURI().toString();
//		System.out.println("resource.getURI() is " + curpath);

		List<IHyperlink> defaultlinks = Lists.newArrayList();
		IHyperlinkAcceptor acceptor = new HyperlinkAcceptor(defaultlinks);

		XtextHyperlink defaultlink = hyperlinkProvider.get();

		// set region for showing hyperlink
		Region region = new Region(pathoffset, pathlen);
		defaultlink.setHyperlinkRegion(region);

		// It seems this has no effect at all. What is the setHyperlinkText used
		// for?
		final String hyperlinkText = labelProvider.getText(obj);
		// System.out.println("hyperlinkText is " + hyperlinkText);
		defaultlink.setHyperlinkText(hyperlinkText);

		URI importUri = URI.createURI(loadPath);
		if (EcoreUtil2.isValidUri(resource, importUri)) {
//			System.out.println("===========isvalid");
			if ("platform".equals(importUri.scheme()) || importUri.isPlatform()) {
				defaultlink.setURI(importUri);
			} else {
				// path relative to the current file
				String topath = curpath.substring(0, curpath.lastIndexOf('/'));
				topath = topath + "/" + loadPath;
				// System.out.println("topath is " + topath);
				importUri = URI.createURI(topath);
				defaultlink.setURI(importUri);
			}
			acceptor.accept(defaultlink);
		} else {
			// path relative to the project folder
			// System.out.println("===========not isvalid");
			final String platform = "platform:/resource/";
			String topath = curpath.substring(0,
					curpath.indexOf('/', platform.length()));
			topath = topath + "/" + loadPath;
//			System.out.println("topath is " + topath);
			importUri = URI.createURI(topath);
			if (EcoreUtil2.isValidUri(resource, importUri)) {
				defaultlink.setURI(importUri);
				acceptor.accept(defaultlink);
			} else {
//				System.out.println("===========not isvalid again");
			}
		}

		if (!defaultlinks.isEmpty()) {
			return Iterables.toArray(defaultlinks, IHyperlink.class);
		} else {
			return null;
		}
	}
}
