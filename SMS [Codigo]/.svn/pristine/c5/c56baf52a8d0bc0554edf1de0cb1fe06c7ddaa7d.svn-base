/**
 * 
 */
package SMSDAO.Presentacion.Dispacher;

import SMSDAO.Presentacion.Controlador.Contexto;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class Dispacher {
	/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
	private static Dispacher uniqueInstance;

	/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @return
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
	public static Dispacher getInstance() {
		// begin-user-code
		
		if(uniqueInstance == null){
			uniqueInstance = new DispacherImp();
		}
		return uniqueInstance;
		
		// end-user-code
}

	/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @param parDatosEvento
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
	public abstract void dispach(int eventoNegocio, Contexto parDatosEvento);
}