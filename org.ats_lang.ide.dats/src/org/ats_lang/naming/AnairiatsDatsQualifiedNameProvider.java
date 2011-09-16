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
import org.ats_lang.anairiatsSats.i0mpdec;
import org.ats_lang.anairiatsSats.refentity;
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

public class AnairiatsDatsQualifiedNameProvider extends
		org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider {

	@Override
	public QualifiedName getFullyQualifiedName(final EObject obj) {
		QualifiedName qname = super.getFullyQualifiedName(obj);
//		if (null != qname) {
//			System.out.println("qname is " + qname);
//		} else {
//			System.out.println("qname is null");
//		}
		return qname; // QualifiedName.create("xxx1"); // qname;
	}
	//
	// private int m_counter;
	// private WeakHashMap<EObject, String> m_nametable;
	//
	// public AnairiatsDatsQualifiedNameProvider() {
	// m_counter = 0;
	// m_nametable = new WeakHashMap<EObject, String>();
	// }
	//
	// private PolymorphicDispatcher<QualifiedName> qualifiedName = new
	// PolymorphicDispatcher<QualifiedName>(
	// "qualifiedName", 1, 1, Collections.singletonList(this),
	// PolymorphicDispatcher.NullErrorHandler.<QualifiedName> get()) {
	// @Override
	// protected QualifiedName handleNoSuchMethod(Object... params) {
	// return null;
	// }
	// };
	//
	// @Inject
	// private IQualifiedNameConverter converter = new
	// IQualifiedNameConverter.DefaultImpl();
	//
	// @Inject
	// private IResourceScopeCache cache =
	// IResourceScopeCache.NullImpl.INSTANCE;
	//
	// private Function<EObject, String> resolver = SimpleAttributeResolver
	// .newResolver(String.class, "name");
	//
	// protected Function<EObject, String> getResolver() {
	// return resolver;
	// }
	//
	// public QualifiedName getFullyQualifiedName(final EObject obj) {
	// return cache.get(Tuples.pair(obj, "fqn"), obj.eResource(),
	// new Provider<QualifiedName>() {
	// public QualifiedName get() {
	// EObject temp = obj;
	// String name = null;
	// // deal with "implement foo"
	// if (temp instanceof i0mpdec) {
	// // cannot use the following (runtime error)
	// // name =
	// // ((i0mpdec)obj).getM_imp().getName().getName()
	// // + "_";
	// ICompositeNode cnode = NodeModelUtils
	// .findActualNodeFor(temp);
	// INode node = cnode.getFirstChild();
	// // BidiIterator<INode> iter =
	// // cnode.getChildren()
	// // .iterator();
	// // int k = 0;
	// // while (iter.hasNext()) {
	// // name = NodeModelUtils.getTokenText(iter
	// // .next());
	// // System.out.println("========== next is "
	// // + name + "_" + k);
	// // k++;
	// // }
	// name = NodeModelUtils.getTokenText(node);
	// // name += Integer.toString(m_counter++);
	//
	// } else if (temp instanceof atmd0exp_argd0exp_let ||
	// temp instanceof atmd0exp_argd0expi_let ||
	// temp instanceof atmd0exp_let) {
	// name = m_nametable.get(obj);
	// if (null == name) {
	// name = "let_" + Integer.toString(m_counter++);
	// m_nametable.put(obj, name);
	// }
	// } else if (temp instanceof d0expgo) {
	// name = m_nametable.get(obj);
	// if (null == name) {
	// name = "case_" + Integer.toString(m_counter++);
	// m_nametable.put(obj, name);
	// }
	//
	// EObject parent;
	// while (true) {
	// parent = temp.eContainer();
	// if (parent instanceof d0exp) {
	// System.out.println("=========name parent instanceof d0exp");
	// break;
	// } else if (parent instanceof d0expi) {
	// System.out.println("=========name parent instanceof d0expi");
	// break;
	// } else { // (parent instanceof d0expgo)
	// d0expgo dobj = (d0expgo) temp;
	// if (null != dobj.getM_dcase() ||
	// null != dobj.getM_scase()) {
	// System.out.println("=========name parent instanceof xxx");
	// break;
	// }
	// else {
	// temp = parent;
	// }
	// }
	// }
	//
	// } else if (temp instanceof d0exp_trytype) {
	// name = m_nametable.get(obj);
	// if (null == name) {
	// name = "try_" + Integer.toString(m_counter++);
	// m_nametable.put(obj, name);
	// }
	// } else if (temp instanceof refentity) {
	// System.out.println("xxxxxxxxxxxxxxxxxxx");
	// QualifiedName qualifiedNameFromDispatcher = qualifiedName
	// .invoke(temp);
	// if (qualifiedNameFromDispatcher != null) {
	// System.out.println("yyyyyyyyyyyyyyyyyyyyyyy");
	// return qualifiedNameFromDispatcher;
	// }
	//
	// name = getResolver().apply(temp);
	// if (Strings.isEmpty(name)) {
	// System.out.println("zzzzzzzzzzzzzzzzzzzzzz");
	// return null;
	// }
	//
	// } else {
	//
	// QualifiedName qualifiedNameFromDispatcher = qualifiedName
	// .invoke(temp);
	// if (qualifiedNameFromDispatcher != null)
	// return qualifiedNameFromDispatcher;
	// name = getResolver().apply(temp);
	// if (Strings.isEmpty(name))
	// return null;
	// }
	// QualifiedName qualifiedNameFromConverter = converter
	// .toQualifiedName(name);
	// while (temp.eContainer() != null) {
	// temp = temp.eContainer();
	// QualifiedName parentsQualifiedName = getFullyQualifiedName(temp);
	// if (parentsQualifiedName != null) {
	// qualifiedNameFromConverter = parentsQualifiedName
	// .append(qualifiedNameFromConverter);
	// break;
	// }
	// }
	// System.out.println("=========name is "
	// + qualifiedNameFromConverter.toString());
	// return qualifiedNameFromConverter;
	// }
	// });
	// }
	//
	// protected IQualifiedNameConverter getConverter() {
	// return converter;
	// }

}
