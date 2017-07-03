/**
 * 
 */
package SMSJPA.Negocio.FactoriaSA;

import SMSJPA.Negocio.Materia.SAMateria;
import SMSJPA.Negocio.Profesor.SAProfesor;
import SMSJPA.Negocio.Turno.SATurno;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public abstract class FactoriaSA {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private static FactoriaSA uniqueInstance;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public abstract SATurno crearSATurno();
	
	public abstract SAMateria crearSAMateria();
	
	public abstract SAProfesor crearSAProfesor();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public static FactoriaSA getInstance() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		if (uniqueInstance == null){
			uniqueInstance = new FactoriaSAImp();
		}
		return uniqueInstance;
		
		// end-user-code
	}
}