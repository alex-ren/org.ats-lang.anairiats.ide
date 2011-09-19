/*
 * generated by Xtext
 */
package org.ats_lang.scoping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.ats_lang.anairiatsSats.argd0expseq1;
import org.ats_lang.anairiatsSats.argd0expseq1i;
import org.ats_lang.anairiatsSats.argp0at;
import org.ats_lang.anairiatsSats.compound_atmp0at;
import org.ats_lang.anairiatsSats.d0atcon;
import org.ats_lang.anairiatsSats.d0atconseq;
import org.ats_lang.anairiatsSats.d0atdec;
import org.ats_lang.anairiatsSats.d0cstdec;
import org.ats_lang.anairiatsSats.d0ec;
import org.ats_lang.anairiatsSats.d0ec_dyn;
import org.ats_lang.anairiatsSats.d0ec_dyn_d0ec;
import org.ats_lang.anairiatsSats.d0ec_dyn_ext;
import org.ats_lang.anairiatsSats.d0ec_dyn_fun;
import org.ats_lang.anairiatsSats.d0ec_dyn_val;
import org.ats_lang.anairiatsSats.d0ec_dyn_val_par;
import org.ats_lang.anairiatsSats.d0ec_dyn_val_rec;
import org.ats_lang.anairiatsSats.d0ec_dyn_var;
import org.ats_lang.anairiatsSats.d0ec_sta;
import org.ats_lang.anairiatsSats.d0ecseq_dyn_rev;
import org.ats_lang.anairiatsSats.d0exp;
import org.ats_lang.anairiatsSats.d0expbase;
import org.ats_lang.anairiatsSats.d0expbasei;
import org.ats_lang.anairiatsSats.d0expgo;
import org.ats_lang.anairiatsSats.d0expi;
import org.ats_lang.anairiatsSats.e0xndec;
import org.ats_lang.anairiatsSats.f0arg1;
import org.ats_lang.anairiatsSats.f0arg1seq;
import org.ats_lang.anairiatsSats.f0arg2;
import org.ats_lang.anairiatsSats.f0arg2seq;
import org.ats_lang.anairiatsSats.f0undec;
import org.ats_lang.anairiatsSats.guap0at;
import org.ats_lang.anairiatsSats.i0deseq;
import org.ats_lang.anairiatsSats.i0nvarg;
import org.ats_lang.anairiatsSats.literal_atmp0at;
import org.ats_lang.anairiatsSats.m0acarg;
import org.ats_lang.anairiatsSats.m0acargseq;
import org.ats_lang.anairiatsSats.m0acdef;
import org.ats_lang.anairiatsSats.m0arg;
import org.ats_lang.anairiatsSats.m0argseq;
import org.ats_lang.anairiatsSats.p0at;
import org.ats_lang.anairiatsSats.p0atseq;
import org.ats_lang.anairiatsSats.refdi0de;
import org.ats_lang.anairiatsSats.refentity;
import org.ats_lang.anairiatsSats.refi0de;
import org.ats_lang.anairiatsSats.simple_atmp0at;
import org.ats_lang.anairiatsSats.v0aldec;
import org.ats_lang.anairiatsSats.v0ardec;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.eclipse.xtext.util.PolymorphicDispatcher;

import com.google.inject.Inject;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it 
 *
 */
public class AnairiatsSatsScopeProvider extends AbstractDeclarativeScopeProvider {
	
	// obsolete code
	// I keep them here for study purpose
	// private PolymorphicDispatcher<List<IEObjectDescription>> iEObjectDesc =
	// new PolymorphicDispatcher<List<IEObjectDescription>>(
	// "getIEObjectDescriptions", 1, 1, Collections.singletonList(this),
	// PolymorphicDispatcher.NullErrorHandler
	// .<List<IEObjectDescription>> get()) {
	// @Override
	// protected List<IEObjectDescription> handleNoSuchMethod(Object... params)
	// {
	// return null;
	// }
	// };

	// IScope scope_atmd0exp_argd0exp_m_di0de(atmd0exp_argd0exp exp, EReference
	// ref) {
	// System.out.println("===========xxx");
	// return delegateGetScope(exp, ref);
	// }

	// @Inject(optional = true)
	// @Named(NAMED_ERROR_HANDLER)
	// private PolymorphicDispatcher.ErrorHandler<IScope> errorHandler = new
	// PolymorphicDispatcher.NullErrorHandler<IScope>();


	@Inject
	private IQualifiedNameConverter converter = new IQualifiedNameConverter.DefaultImpl();

	@Inject
	private IGlobalScopeProvider globalScopeProvider;
	
	@Override
	public IScope getScope(EObject context, EReference reference) {
		// System.out.println("ddddddddddddddd name is " + reference.getName());
		// System.out.println("getScope =====" + context.getClass().getName() + "======" + context.eResource().getURI().toString());
		
		List<INode> iNodeList = NodeModelUtils.findNodesForFeature(context,
				reference);
		INode lastNode = iNodeList.get(iNodeList.size() - 1);
		if (lastNode == null) {
			System.out.println("last node is null, should not happen");
			return null;
		}
		
		String token = NodeModelUtils.getTokenText(lastNode);
		// System.out.println("startline is " + last.getStartLine() +
		// " end line is " + last.getEndLine() +
		// " offset is " + lastNode.getTotalOffset());
		int lastOffset = lastNode.getTotalEndOffset();

		PolymorphicDispatcher<List<IEObjectDescription>> dispatcher = new PolymorphicDispatcher<List<IEObjectDescription>>(
				Collections.singletonList(this), getPredicate(context,
						reference.getEReferenceType()/* refentity or ... */),
				PolymorphicDispatcher.NullErrorHandler
						.<List<IEObjectDescription>> get()) {
			@Override
			protected List<IEObjectDescription> handleNoSuchMethod(
					Object... params) {
				return null;
			}
		};

		return getScope(context, reference, lastOffset, token, dispatcher);
	}

	protected IScope getScope(EObject context, EReference reference,
			int lastOffset, String token,
			PolymorphicDispatcher<List<IEObjectDescription>> dispatcher) {
		IScope outerScope = null;
		EObject container = null;

		if (context instanceof d0expgo) {
			container = context;
			// jump out of the case expression
			while (true) {
				container = container.eContainer();
				// System.out.println("container is " +
				// container.getClass().getName());
				if (container instanceof d0exp) {
					container = container.eContainer();
					break;
				} else if (container instanceof d0expgo) {
					if (((d0expgo) container).getM_dcase() != null) {
						container = container.eContainer();
						break;
					}

				} else if (container instanceof d0expi) {
					container = container.eContainer();
					break;
				} else {
					System.out.println("This cannot happen.");
					break;
				}
			}
		} else {
			container = context.eContainer();
		}
		
		EList<EObject> eleList = context.eContents();

		List<IEObjectDescription> curScope = new ArrayList<IEObjectDescription>();
	
		// special case for f0undec due to the fact that di0de is just a String
		if (context instanceof f0undec) {
			curScope.addAll(getIEObjectDescriptions((f0undec) context));
		}

		for (EObject ele : eleList) {
			// handle where statement
			if (ele instanceof d0expbase) {
				d0expbase aD0exp = (d0expbase)ele;
				argd0expseq1 cover = aD0exp.getM_seq1();
				if (null != cover) {
					if (getStartOffset(cover) <= lastOffset && getLastOffset(cover) >= lastOffset) {
						d0ecseq_dyn_rev whereStat = aD0exp.getM_d0ecseq();
						if (whereStat != null) {
							curScope.addAll(getIEObjectDescriptions(whereStat));
						}
					}
				}
			}
			
			// handle where statement
			if (ele instanceof d0expbasei) {
				d0expbasei aD0exp = (d0expbasei) ele;
				argd0expseq1i cover = aD0exp.getM_seq1();
				if (null != cover) {
					if (getStartOffset(cover) <= lastOffset
							&& getLastOffset(cover) >= lastOffset) {
						d0ecseq_dyn_rev whereStat = aD0exp.getM_d0ecseq();
						if (whereStat != null) {
							curScope.addAll(getIEObjectDescriptions(whereStat));
						}
					}
				}
			}

			// System.out.println(ele.getClass().getName());
			if (getLastOffset(ele) >= lastOffset) {
				continue;
			} else {
				List<IEObjectDescription> descList = dispatcher.invoke(ele,
						reference);
				// It's possible that descList is null due to that no 
				// corresponding function is provided.
				// But all the functions I implemented should not return null but
				// empty list
				if (null != descList) {
					curScope.addAll(descList);
				}
			}
		}

		// reverse the order, so that jump to the closest one
		Collections.reverse(curScope);
		
		// search at the current level
		IEObjectDescription target = null;
		QualifiedName qToken = converter.toQualifiedName(token);
		for (IEObjectDescription objDesc: curScope) {
			if (objDesc.getName().compareTo(qToken) == 0) {
				target = objDesc;
				break;
			}
		}
		if (target != null) {  // found the reference
			curScope = new ArrayList<IEObjectDescription>();
			curScope.add(target);
			return new SimpleScope(IScope.NULLSCOPE, curScope);
		} else {
			if (null == container) {
				outerScope = globalScopeProvider.getScope(context.eResource(),
						reference, null);
			} else {
				outerScope = getScope(container, reference, lastOffset, token, dispatcher);
			}
			return outerScope;
		}
	}

	// example for function signature
	// IScope scope_atmd0exp_argd0exp_m_di0de(d0ec_dyn_val context, EReference
	// ref) {
	// return null;
	// }

	List<IEObjectDescription> scope_refentity(d0ec_dyn_fun ele,
			EReference reference) {
		return getIEObjectDescriptions(ele);
	}

	List<IEObjectDescription> scope_refentity(d0ecseq_dyn_rev ele,
			EReference reference) {
		return getIEObjectDescriptions(ele);
	}

	// for sth. like 
	// val x = y
	// for the cross-reference of y, we check x as well.
	// doesn't seem useful, so remove this function temporarily to
	// see whether there is any bad consequence
//	List<IEObjectDescription> scope_refentity(p0at ele, EReference reference) {
//		System.out.println("scope_refentity(p0at ele is called");
//		return getIEObjectDescriptions(ele);
//	}

	List<IEObjectDescription> scope_refentity(f0arg1seq ele,
			EReference reference) {
		// System.out.println("scope_refentity(f0arg1seq ele,");
		EList<f0arg1> argList = ele.getM_f0arg1seq();
		List<IEObjectDescription> descList = new ArrayList<IEObjectDescription>();

		for (f0arg1 arg : argList) {
			refentity ref = arg.getM_atmp0at();
			if (null != ref) {
				List<IEObjectDescription> curDescList = getIEObjectDescriptions(arg
						.getM_atmp0at());
				descList.addAll(curDescList);
			}
		}
		return descList;
	}

	List<IEObjectDescription> scope_refentity(f0arg2seq ele,
			EReference reference) {
		// System.out.println("scope_refentity(f0arg1seq ele,");
		EList<f0arg2> argList = ele.getM_f0arg2seq();
		List<IEObjectDescription> descList = new ArrayList<IEObjectDescription>();

		for (f0arg2 arg : argList) {
			refentity ref = arg.getM_atmp0at();
			if (null != ref) {
				List<IEObjectDescription> curDescList = getIEObjectDescriptions(arg
						.getM_atmp0at());
				descList.addAll(curDescList);
			}
		}
		return descList;
	}

	List<IEObjectDescription> scope_refentity(d0ec_dyn_ext ele,
			EReference reference) {
		return getIEObjectDescriptions(ele);
	}

	List<IEObjectDescription> scope_refentity(guap0at ele, EReference reference) {
		p0at p = ele.getM_p0at();
		EList<argp0at> argp0atList = p.getM_p0atargseq().getM_argp0at();
		if (0 == argp0atList.size()) {
			refentity ref = p.getName();
			return getIEObjectDescriptions(ref);
		} else {
			List<IEObjectDescription> descList = new ArrayList<IEObjectDescription>();
			for (argp0at arg : argp0atList) {
				refentity ref = arg.getM_atmp0at();
				if (null != ref) {
					descList.addAll(getIEObjectDescriptions(ref));
				}
			}
			return descList;
		}
	}

	List<IEObjectDescription> scope_refentity(d0ec_dyn_d0ec ele,
			EReference reference) {
		return getIEObjectDescriptions(ele);
	}

	List<IEObjectDescription> scope_refentity(d0ec_dyn_var ele,
			EReference reference) {
		return getIEObjectDescriptions(ele);
	}
	
	List<IEObjectDescription> scope_refentity(d0ec_dyn_val ele,
			EReference reference) {
		return getIEObjectDescriptions(ele);
	}
	
	List<IEObjectDescription> scope_refentity(m0acargseq ele,
			EReference reference) {
		return getIEObjectDescriptions(ele);
	}
	
	List<IEObjectDescription> scope_refentity(d0ec_sta ele,
			EReference reference) {
		
		d0ec aD0ec = ele.getM_d0ec();
		if (aD0ec != null) {  // option 1: d0ec
			return getIEObjectDescriptions(aD0ec);
		}
		
		refentity ref = ele.getName();
		if (ref != null) {  // option 2: fun
			List<IEObjectDescription> descList = getIEObjectDescriptions(ref);
			EList<refentity> refList = ele.getM_seq().getM_andd0cstdecseq();
			for (refentity refName: refList) {
				descList.addAll(getIEObjectDescriptions(refName));
			}
			return descList;
		}
		
		return new ArrayList<IEObjectDescription>();
	}

	public List<IEObjectDescription> getIEObjectDescriptions(d0ec_dyn_ext ele) {
		refentity name = ele.getName();
		List<IEObjectDescription> descList = getIEObjectDescriptions(name);
		EList<refentity> refList = ele.getM_rec_d0cstdec().getM_andd0cstdecseq();
		for (refentity refName: refList) {
			descList.addAll(getIEObjectDescriptions(refName));
		}

		return descList;
	}
	
	public List<IEObjectDescription> getIEObjectDescriptions(d0ecseq_dyn_rev ele) {
		EList<d0ec_dyn> d0ecList = ele.getM_d0ec_dyn();

		List<IEObjectDescription> descList = new ArrayList<IEObjectDescription>();
		for (d0ec_dyn aD0ec : d0ecList) {
			if (aD0ec instanceof d0ec_dyn_d0ec) {
				descList.addAll(getIEObjectDescriptions((d0ec_dyn_d0ec) aD0ec));
			} else if (aD0ec instanceof d0ec_dyn_ext) {
				descList.addAll(getIEObjectDescriptions((d0ec_dyn_ext) aD0ec));
			} else if (aD0ec instanceof d0ec_dyn_val) {
				descList.addAll(getIEObjectDescriptions((d0ec_dyn_val) aD0ec));
			} else if (aD0ec instanceof d0ec_dyn_val_par) {
				descList.addAll(getIEObjectDescriptions((d0ec_dyn_val_par) aD0ec));
			} else if (aD0ec instanceof d0ec_dyn_val_rec) {
				descList.addAll(getIEObjectDescriptions((d0ec_dyn_val_rec) aD0ec));
			} else if (aD0ec instanceof d0ec_dyn_fun) {
				descList.addAll(getIEObjectDescriptions((d0ec_dyn_fun) aD0ec));
			} else if (aD0ec instanceof d0ec_dyn_var) {
				descList.addAll(getIEObjectDescriptions((d0ec_dyn_var) aD0ec));
			}
			
			else {
				// not handled now
			}
		}
		return descList;
	}
	
	public List<IEObjectDescription> getIEObjectDescriptions(m0acargseq ele) {
		EList<m0acarg> argsList = ele.getM_args();
		List<IEObjectDescription> descList = new ArrayList<IEObjectDescription>();
		for (m0acarg args: argsList) {
			descList.addAll(getIEObjectDescriptions(args));
		}
		return descList;		
	}
	
	public List<IEObjectDescription> getIEObjectDescriptions(m0acarg ele) {
		refentity arg = ele.getM_m0arg();
		if (null != arg) {
			return getIEObjectDescriptions(arg);  // m0arg
		} else {
			m0argseq aM0argseq = ele.getM_seq();
			refentity head = aM0argseq.getM_arg();
			if (head != null) {
				List<IEObjectDescription> descList = getIEObjectDescriptions(head);
				List<refentity> tail = aM0argseq.getM_seq().getM_args();
				for (refentity ref: tail) {
					descList.addAll(getIEObjectDescriptions(ref));	
				}
				return descList;
			} else {
				return new ArrayList<IEObjectDescription>();
			}
		}
	}
	
	public List<IEObjectDescription> getIEObjectDescriptions(d0ec_dyn_fun ele) {
		List<IEObjectDescription> descList = getIEObjectDescriptions(ele
				.getM_fundec());
		EList<refentity> refList = ele.getM_rec_fundec().getM_f0undec();
		for (refentity ref : refList) {
			descList.addAll(getIEObjectDescriptions(ref));
		}
		return descList;
	}
	
	public List<IEObjectDescription> getIEObjectDescriptions(d0ec_dyn_val ele) {
		v0aldec from = ele.getM_v0aldec();
		p0at p = from.getName();

		EList<argp0at> argp0atList = p.getM_p0atargseq().getM_argp0at();
		if (0 == argp0atList.size()) {
			refentity ref = p.getName();
			return getIEObjectDescriptions(ref);
		} else {
			List<IEObjectDescription> descList = new ArrayList<IEObjectDescription>();
			for (argp0at arg : argp0atList) {
				refentity ref = arg.getM_atmp0at();
				if (null != ref) {
					descList.addAll(getIEObjectDescriptions(ref));
				}
			}
			return descList;
		}
	}
	
	public List<IEObjectDescription> getIEObjectDescriptions(d0ec_dyn_val_par ele) {
		v0aldec from = ele.getM_v0aldec();
		p0at p = from.getName();

		EList<argp0at> argp0atList = p.getM_p0atargseq().getM_argp0at();
		if (0 == argp0atList.size()) {
			refentity ref = p.getName();
			return getIEObjectDescriptions(ref);
		} else {
			List<IEObjectDescription> descList = new ArrayList<IEObjectDescription>();
			for (argp0at arg : argp0atList) {
				refentity ref = arg.getM_atmp0at();
				if (null != ref) {
					descList.addAll(getIEObjectDescriptions(ref));
				}
			}
			return descList;
		}
	}
	
	public List<IEObjectDescription> getIEObjectDescriptions(d0ec_dyn_val_rec ele) {
		v0aldec from = ele.getM_v0aldec();
		p0at p = from.getName();

		EList<argp0at> argp0atList = p.getM_p0atargseq().getM_argp0at();
		if (0 == argp0atList.size()) {
			refentity ref = p.getName();
			return getIEObjectDescriptions(ref);
		} else {
			List<IEObjectDescription> descList = new ArrayList<IEObjectDescription>();
			for (argp0at arg : argp0atList) {
				refentity ref = arg.getM_atmp0at();
				if (null != ref) {
					descList.addAll(getIEObjectDescriptions(ref));
				}
			}
			return descList;
		}
	}
	
	public List<IEObjectDescription> getIEObjectDescriptions(d0ec_dyn_var ele) {
		refentity head=ele.getM_v0ardec();
		List<IEObjectDescription> descList = getIEObjectDescriptions(head);
		EList<refentity> tail = ele.getM_rec_v0ardec().getM_v0ardec();
		for (refentity ref: tail) {
			descList.addAll(getIEObjectDescriptions(ref));
		}
		return descList;	
	}

	public List<IEObjectDescription> getIEObjectDescriptions(d0ec ele) {
		i0deseq aI0deseq = ele.getM_i0deseq();
		if (null != aI0deseq) {  // is symintr
			return getIEObjectDescriptions(aI0deseq);
		} 
		
		d0atdec aD0atdec = ele.getM_d0atdec();
		if (aD0atdec != null) { // is dataprop, datatype and etc.
			List<IEObjectDescription> descList = getIEObjectDescriptions(aD0atdec);
			EList<d0atdec> d0atdecList = ele.getM_datatype().getM_seq();
			for (d0atdec d : d0atdecList) {
				descList.addAll(getIEObjectDescriptions(d));
			}
			return descList;
		} 
		
		refentity def_ref = ele.getM_def_refi0de();
		if (def_ref != null) {  // is #define
			return getIEObjectDescriptions(def_ref);
		}
		
		refentity ref_di0de = ele.getM_di0de();
		if (ref_di0de != null) {  // is overload
			return getIEObjectDescriptions(ref_di0de);
		}
		
		refentity ref_mac = ele.getM_m0acdef();
		if (ref_mac != null) {  // is macdef
			return getIEObjectDescriptions(ref_mac);
		}
		
		refentity ref_exn_head = ele.getM_e0xndec();
		if (ref_exn_head != null) {  // is exception
			List<IEObjectDescription> descList = getIEObjectDescriptions(ref_exn_head);
			EList<refentity> refList = ele.getM_exception().getM_seq();
			for (refentity ref: refList) {
				descList.addAll(getIEObjectDescriptions(ref));
			}
			return descList;
		}
		

		return new ArrayList<IEObjectDescription>();
	}
	
	public List<IEObjectDescription> getIEObjectDescriptions(d0ec_dyn_d0ec ele) {
		d0ec aD0ec = ele.getM_d0ec();
		return getIEObjectDescriptions(aD0ec);
	}

	// for datatype and dataprop
	public List<IEObjectDescription> getIEObjectDescriptions(d0atdec ele) {
		d0atconseq d0atconSeq = ele.getM_seq();

		List<IEObjectDescription> descList = new ArrayList<IEObjectDescription>();

		refentity ref = d0atconSeq.getM_d0atcon();
		if (ref != null) {
			descList.addAll(getIEObjectDescriptions(ref));
		}

		EList<refentity> d0atconList = d0atconSeq.getM_d0atconseq().getM_seq();
		for (refentity refD0atcon : d0atconList) {
			descList.addAll(getIEObjectDescriptions(refD0atcon));
		}

		return descList;
	}


	public List<IEObjectDescription> getIEObjectDescriptions(simple_atmp0at ele) {
		String name = ele.getName();
//		System.out.println("simple_atmp0at name is " + name);
		List<IEObjectDescription> descList = new ArrayList<IEObjectDescription>();
		descList.add(new EObjectDescription(converter.toQualifiedName(name),
				ele, null));
		return descList;
	}

	public List<IEObjectDescription> getIEObjectDescriptions(
			compound_atmp0at ele) {
		p0atseq p0atSeq = ele.getM_p0atseq();

		p0at header = p0atSeq.getM_p0at();
		if (null == header) {
			return new ArrayList<IEObjectDescription>();
		}

		EList<p0at> tail = p0atSeq.getM_p0atseq().getM_commabarp0atseq();

		List<IEObjectDescription> descList = getIEObjectDescriptions(header);
		for (p0at aP0at : tail) {
			descList.addAll(getIEObjectDescriptions(aP0at));
		}
		return descList;
	}

	public List<IEObjectDescription> getIEObjectDescriptions(f0undec ele) {
		String name = ele.getName();
		// System.out.println("name is " + name);
		List<IEObjectDescription> descList = new ArrayList<IEObjectDescription>();
		descList.add(new EObjectDescription(converter.toQualifiedName(name),
				ele, null));
		return descList;
	}

	public List<IEObjectDescription> getIEObjectDescriptions(i0deseq ele) {
		EList<refentity> refList = ele.getM_i0des();
		List<IEObjectDescription> descList = new ArrayList<IEObjectDescription>();
		for (refentity ref : refList) {
			descList.addAll(getIEObjectDescriptions(ref));
		}
		return descList;
	}

	public List<IEObjectDescription> getIEObjectDescriptions(d0cstdec ele) {
		String name = ele.getName();
		// System.out.println("name is " + name);
		List<IEObjectDescription> descList = new ArrayList<IEObjectDescription>();
		descList.add(new EObjectDescription(converter.toQualifiedName(name),
				ele, null));
		return descList;
	}

	public List<IEObjectDescription> getIEObjectDescriptions(p0at ele) {
		refentity ref = ele.getName();
		return getIEObjectDescriptions(ref);
	}

	public List<IEObjectDescription> getIEObjectDescriptions(d0atcon ele) {
		List<IEObjectDescription> descList = new ArrayList<IEObjectDescription>();
		descList.add(new EObjectDescription(converter.toQualifiedName(ele
				.getM_di0de().getName()), ele, null));
		return descList;
	}
	
	public List<IEObjectDescription> getIEObjectDescriptions(refi0de ele) {
		String name = ele.getName();
		List<IEObjectDescription> descList = new ArrayList<IEObjectDescription>();
		descList.add(new EObjectDescription(converter.toQualifiedName(name),
				ele, null));
		return descList;
	}

	
	public List<IEObjectDescription> getIEObjectDescriptions(m0acdef ele) {
		String name = ele.getName();
		List<IEObjectDescription> descList = new ArrayList<IEObjectDescription>();
		descList.add(new EObjectDescription(converter.toQualifiedName(name),
				ele, null));
		return descList;
	}
	
	public List<IEObjectDescription> getIEObjectDescriptions(e0xndec ele) {
		String name = ele.getName();
		List<IEObjectDescription> descList = new ArrayList<IEObjectDescription>();
		descList.add(new EObjectDescription(converter.toQualifiedName(name),
				ele, null));
		return descList;
	}
	
	public List<IEObjectDescription> getIEObjectDescriptions(refdi0de ele) {
		String name = ele.getName();
		List<IEObjectDescription> descList = new ArrayList<IEObjectDescription>();
		descList.add(new EObjectDescription(converter.toQualifiedName(name),
				ele, null));
		return descList;
	}
	
	public List<IEObjectDescription> getIEObjectDescriptions(v0ardec ele) {
		String name = ele.getName();
		List<IEObjectDescription> descList = new ArrayList<IEObjectDescription>();
		descList.add(new EObjectDescription(converter.toQualifiedName(name),
				ele, null));
		return descList;
	}
	
	public List<IEObjectDescription> getIEObjectDescriptions(m0arg ele) {
		String name = ele.getName();
		List<IEObjectDescription> descList = new ArrayList<IEObjectDescription>();
		descList.add(new EObjectDescription(converter.toQualifiedName(name),
				ele, null));
		return descList;
	}
	
	public List<IEObjectDescription> getIEObjectDescriptions(refentity ele) {
		if (ele instanceof simple_atmp0at) {
			return getIEObjectDescriptions((simple_atmp0at) ele);
		} else if (ele instanceof literal_atmp0at) {
			return new ArrayList<IEObjectDescription>(); // todo getIEObjectDescriptions((literal_atmp0at) ele);
		} else if (ele instanceof compound_atmp0at) {
			return getIEObjectDescriptions((compound_atmp0at) ele);
		} else if (ele instanceof f0undec) {
			return getIEObjectDescriptions((f0undec) ele);
		} else if (ele instanceof d0cstdec) {
			return getIEObjectDescriptions((d0cstdec) ele);
		} else if (ele instanceof refi0de) {
			return getIEObjectDescriptions((refi0de) ele);
		} else if (ele instanceof d0atcon) {
			return getIEObjectDescriptions((d0atcon) ele);
		} else if (ele instanceof e0xndec) {
			return getIEObjectDescriptions((e0xndec)ele);
		} else if (ele instanceof refdi0de) {
			return getIEObjectDescriptions((refdi0de)ele);
		} else if (ele instanceof m0acdef) {
			return getIEObjectDescriptions((m0acdef)ele);
		} else if (ele instanceof v0ardec) {
			return getIEObjectDescriptions((v0ardec)ele);
		} else if (ele instanceof m0arg) {
			return getIEObjectDescriptions((m0arg)ele);
		} else if (ele instanceof i0nvarg) {
			return new ArrayList<IEObjectDescription>(); // todo getIEObjectDescriptions((i0nvarg) ele);
		} else {
			return new ArrayList<IEObjectDescription>();
		}
	}
	
	static public int getLastOffset(EObject ele) {
		ICompositeNode node = NodeModelUtils.findActualNodeFor(ele);
		return node.getTotalEndOffset();
	}
	
	static public int getStartOffset(EObject ele) {
		if (ele == null) {
			System.out.println("xxxxxxxxxxxxx");
		}
		ICompositeNode node = NodeModelUtils.findActualNodeFor(ele);
		if (node == null) {
			System.out.println("yyyyyyyyyyyyy");
		}
		return node.getTotalOffset();
	}

	
}
