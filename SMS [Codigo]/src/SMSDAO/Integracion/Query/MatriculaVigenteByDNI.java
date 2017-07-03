/**
 * 
 */
package SMSDAO.Integracion.Query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import SMSDAO.Integracion.ExcepcionesIntegracion.ExcepcionIntegracion;
import SMSDAO.Integracion.Transacciones.Transaccion;
import SMSDAO.Integracion.TransactionManager.TransactionManager;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class MatriculaVigenteByDNI implements Query {
	
	public Object execute(Object datos) throws ExcepcionIntegracion {
		// begin-user-code
		int DNI = (Integer) datos;
		boolean matriculaVigente=false;
		
		Transaccion miTrans = (Transaccion) TransactionManager.getInstance().dameTransaccion();
		Connection conn = (Connection) miTrans.getResource();
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
		    	stmt=conn.createStatement();
		    }
		    catch(SQLException e){
		    	throw new ExcepcionIntegracion("Error al establecer conexion con la BBDD.");
		    }
			//:::CONSULTAMOS A LA BBDD:::
			try{
		           String sql="SELECT * FROM alumnos as alu, matriculas as mat" 
		           		+" WHERE alu.DNI=mat.DNI"
		           		+" AND substring(mat.Fecha_curso,1,4)=substring(CURDATE(),1,4)" 
		           		+" AND alu.DNI="+DNI
		           		+" AND alu.Activo=1" 
		           		+" GROUP BY mat.DNI " 
		           		+" FOR UPDATE";
		           rs=stmt.executeQuery(sql);
		    }
		    catch (Exception e){
		    	throw new ExcepcionIntegracion("Error SQL alumnos en una matricula en la BBDD.");
		    }
		    
		    try{

		    	//Añadimos a la lista todas las zonas encontradas en la base de datos.
		    	while(rs.next()){
		    		matriculaVigente=true;
		    	}

		    	//Realizamos el cierre de la conexion
		    	stmt.close();
		    	rs.close();
		    }catch (Exception e){
		    	throw new ExcepcionIntegracion("Error en la busqueda de los alumnos en las matrículas.");
		    }
			return matriculaVigente;
		// end-user-code
	
	}
}