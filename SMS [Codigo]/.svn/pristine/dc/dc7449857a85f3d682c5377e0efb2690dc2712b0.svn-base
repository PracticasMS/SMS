/**
 * 
 */
package SMSDAO.Integracion.TransactionManager;

import java.util.concurrent.ConcurrentHashMap;

import SMSDAO.Integracion.FactoriaTransaction.FactoriaTransaction;
import SMSDAO.Integracion.Transacciones.Transaccion;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TransactionManagerImp extends TransactionManager {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private ConcurrentHashMap<Thread, Transaccion> concurrentHashMap;
	
	
	public TransactionManagerImp(){
		concurrentHashMap = new ConcurrentHashMap<Thread, Transaccion>();
	}

	@Override
	public void creaTransaccion(){
		concurrentHashMap.put(Thread.currentThread(), FactoriaTransaction.getInstance().creaTransaccion());
	}

	@Override
	public boolean eliminaTransaccion(){
		boolean elimOK = true;
		try{
			concurrentHashMap.remove(Thread.currentThread());
		}
		catch(NullPointerException e){
			elimOK = false;
		}
		return elimOK;
	}

	/** En caso de no exixstir la transaccion para el hilo pedido se
	 * lanza una excpcion NullPointerexception
	 * 
	 * @throws NullPointerException
	 */
	@Override
	public Transaccion dameTransaccion() throws NullPointerException{
		return concurrentHashMap.get(Thread.currentThread());
	}
}