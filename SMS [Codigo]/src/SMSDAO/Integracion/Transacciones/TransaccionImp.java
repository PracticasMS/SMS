/**
 * 
 */
package SMSDAO.Integracion.Transacciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import SMSDAO.Integracion.ExcepcionesIntegracion.ExcepcionIntegracion;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TransaccionImp implements Transaccion {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Connection connection;

	/** 
	 * (sin Javadoc)
	 * @see Transaccion#start()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void start() throws ExcepcionIntegracion {
		// begin-user-code
		
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost/smsbbdd","root","");
	    	connection.setAutoCommit(false);
			
		}catch (Exception e) {
			throw new ExcepcionIntegracion("Error al establecer conexion con la BBDD.");
		}
		
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see Transaccion#getResource()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Object getResource() {
		// begin-user-code

		return connection;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see Transaccion#commit()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void commit() throws ExcepcionIntegracion {
		// begin-user-code
		
		try {
			connection.commit();
			
			connection.close();
			
		} catch (Exception e) {
			throw new ExcepcionIntegracion("Error al finalizar Transaccion");
		}
	
		
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see Transaccion#rollBack()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void rollBack() throws ExcepcionIntegracion {
		// begin-user-code
		try {
			connection.rollback();
			connection.close();
			
		} catch (SQLException e) {
			throw new ExcepcionIntegracion("Error al finalizar Transaccion");
		}
		// end-user-code
	}
}