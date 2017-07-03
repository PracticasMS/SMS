/**
 * 
 */
package SMSDAO.Integracion.FactoriaTransaction;

import SMSDAO.Integracion.Transacciones.Transaccion;
import SMSDAO.Integracion.Transacciones.TransaccionImp;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class FactoriaTransactionImp extends FactoriaTransaction {

	@Override
	public Transaccion creaTransaccion() {
		return new TransaccionImp();
	}
}