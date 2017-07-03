/**
 * 
 */
package SMSDAO.Presentacion.FactoriaComandos;

import SMSDAO.Presentacion.Comandos.Comando;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class FactoriaComandos {
	
	
	private static FactoriaComandos uniqueInstance;
	
	
	/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @return
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
	public static FactoriaComandos getInstance() {
		// begin-user-code
		if(uniqueInstance == null){
			uniqueInstance = new FactoriaComandosImp();
		}
		return uniqueInstance;
		// end-user-code
}

	/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @param eventoNegocio
 * @return
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
	public abstract Comando crearComando(int eventoNegocio);
}