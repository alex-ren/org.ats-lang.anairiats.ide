package org.ats_lang.naming;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;

public class AnairiatsDatsQualifiedNameProvider extends
		org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider {
	public QualifiedName getFullyQualifiedName(final EObject obj) {
		QualifiedName t = super.getFullyQualifiedName(obj);
		if (t != null){
		System.out.println("=============="
				+ t.toString());
		}
		return t;
	}

}
