/**
 * 
 */
package SMSJPA.Integracion.Query;

import javax.persistence.EntityManager;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public interface Query {
	
	public Object execute(EntityManager em, Object datos);
	
}