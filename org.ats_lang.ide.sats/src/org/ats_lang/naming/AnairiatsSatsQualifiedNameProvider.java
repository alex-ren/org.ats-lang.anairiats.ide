package org.ats_lang.naming;

import java.util.Collections;
import java.util.WeakHashMap;

import org.ats_lang.anairiatsSats.atmd0exp_argd0exp_let;
import org.ats_lang.anairiatsSats.atmd0exp_argd0expi_let;
import org.ats_lang.anairiatsSats.atmd0exp_let;
import org.ats_lang.anairiatsSats.d0atcon;
import org.ats_lang.anairiatsSats.d0exp;
import org.ats_lang.anairiatsSats.d0exp_trytype;
import org.ats_lang.anairiatsSats.d0expcasetype;
import org.ats_lang.anairiatsSats.d0expgo;
import org.ats_lang.anairiatsSats.d0expi;
import org.ats_lang.anairiatsSats.f0undec;
import org.ats_lang.anairiatsSats.i0deseq;
import org.ats_lang.anairiatsSats.i0mpdec;
import org.ats_lang.anairiatsSats.refentity;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.BidiIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.Tuples;
import org.w3c.dom.css.Counter;

import com.google.common.base.Function;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class AnairiatsSatsQualifiedNameProvider extends
		org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider {
	
	@Override
	public QualifiedName getFullyQualifiedName(final EObject obj) {
		// for datatype constructor
		if (obj instanceof d0atcon) {
			return QualifiedName.create(((d0atcon) obj).getM_di0de().getName());
		}
		
//		if (obj instanceof i0deseq) {
//			EList<String> nameList = ((i0deseq)obj).getM_i0des();
//			if (nameList.size() > 0) {
//				return QualifiedName.create(nameList.get(0));
//			}
//		}
		
		QualifiedName qname = super.getFullyQualifiedName(obj);
//		if (null != qname) {
//		    System.out.println("qname is " + qname);
//		} else {
//			System.out.println("qname is null");
//		}
		return qname;  // QualifiedName.create("xxx1");  // qname;
	}
}