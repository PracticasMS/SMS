/**
 * 
 */
package SMSDAO.Integracion.Curso;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import SMSDAO.Integracion.ExcepcionesIntegracion.ExcepcionIntegracion;
import SMSDAO.Integracion.Transacciones.Transaccion;
import SMSDAO.Integracion.TransactionManager.TransactionManager;
import SMSDAO.Negocio.Curso.TCurso;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DAOCursoImp implements DAOCurso {
	
	/** 
	 * (sin Javadoc)
	 * @see DAOCurso#crearCurso(TCurso datos)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int crearCurso(TCurso datos) throws ExcepcionIntegracion {
		// begin-user-code
		
		int id_curso = -1;
		Transaccion miTrans = (Transaccion) TransactionManager.getInstance().dameTransaccion();
		Connection conn = (Connection) miTrans.getResource();
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
		}catch (SQLException e) {
			throw new ExcepcionIntegracion("Error al recuperar los recursos de la BBDD");
		}
		
		//:::INSERCION EN LA BBDD:::
		
	   String query="INSERT Curso(Nombre, Activo) " +
	           		"VALUES('"+datos.getNombre()+"', 1)";
	   try {
			stmt.executeUpdate(query,Statement.RETURN_GENERATED_KEYS);
	   }catch (SQLException e1) {
			throw new ExcepcionIntegracion("Error al crear el nuevo curso en la BBDD");
	   } 
	   
	   //Recuperamos el último ID_Curso insertado.
	   try{
		   rs = stmt.getGeneratedKeys();
		   if (rs.next()){
			   id_curso = rs.getInt(1);
	       }
	           
		   //Realizamos el cierre de los recursos.
		   stmt.close();
		   rs.close();
		}catch (Exception e){
			throw new ExcepcionIntegracion("Error al recuperar el último ID_Curso insertado.");
		}	
		return id_curso;

		// end-user-code
	}
	
	/** 
	 * (sin Javadoc)
	 * @see DAOCurso#buscarCursoByID(int idCurso)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TCurso buscarCursoByID(int idCurso) throws ExcepcionIntegracion {
		// begin-user-code
		TCurso miCurso = null;

		Transaccion miTrans = (Transaccion) TransactionManager.getInstance().dameTransaccion();
		Connection conn = (Connection) miTrans.getResource();
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			stmt = conn.createStatement();
			
		}catch (SQLException e) {
			throw new ExcepcionIntegracion("Error al recuperar los recursos de la BBDD");
		}
		
		//:::CONSULTAMOS LA BBDD:::
		
		String query="SELECT * FROM curso WHERE ID_Curso=" + idCurso + " AND Activo = 1 FOR UPDATE";
		
		try{
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			throw new ExcepcionIntegracion("Error al buscar el curso.");
		}
		
		try{
			if (rs.next()){
				miCurso = new TCurso(rs.getInt(1), rs.getString(2), rs.getInt(3));
	               
	        }else{
	       	   miCurso=null;
	       	   //throw new ExcepcionIntegracion("Error al buscar el curso.");
	        }
	           
			//Realizamos el cierre de los recursos.
		    stmt.close();
		    rs.close();
		}
		catch (Exception e){
			throw new ExcepcionIntegracion("Error en la busqueda del curso.");
		}	
		
		return miCurso;
		// end-user-code
	}
	
	/** 
	 * (sin Javadoc)
	 * @see DAOCurso#buscarCursoByNombre(String nombre)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TCurso buscarCursoByNombre(String nombre) throws ExcepcionIntegracion {
		// begin-user-code
		TCurso miCurso = null;

		Transaccion miTrans = (Transaccion) TransactionManager.getInstance().dameTransaccion();
		Connection conn = (Connection) miTrans.getResource();
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			stmt = conn.createStatement();
			
		}catch (SQLException e) {
			throw new ExcepcionIntegracion("Error al recuperar los recursos de la BBDD");
		}
		
		//:::CONSULTAMOS LA BBDD:::
		
		String query="SELECT * FROM curso WHERE Nombre='" + nombre + "' FOR UPDATE";
		
		try{
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			throw new ExcepcionIntegracion("Error al buscar el curso.");
		}
		
		try{
			if (rs.next()){
				miCurso = new TCurso(rs.getInt(1), rs.getString(2), rs.getInt(3));
	               
	        }else{
	       	   miCurso=null;
	        }
	           
			//Realizamos el cierre de los recursos.
		    stmt.close();
		    rs.close();
		}
		catch (Exception e){
			throw new ExcepcionIntegracion("Error en la busqueda del curso.");
		}	
		
		return miCurso;
		// end-user-code
	}
	
	/** 
	 * (sin Javadoc)
	 * @see DAOCurso#modificarCurso(TCurso datos)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int modificarCurso(TCurso datos) throws ExcepcionIntegracion {
		// begin-user-code
		Transaccion miTrans = (Transaccion) TransactionManager.getInstance().dameTransaccion();
		Connection conn = (Connection) miTrans.getResource();
		
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			throw new ExcepcionIntegracion("Error al recuperar los recursos de la BBDD");
		}
		
				
		try{
			String sql="UPDATE curso SET Nombre='"+datos.getNombre()+"', Activo="+datos.getActivo()+" WHERE ID_Curso=" + datos.getId_Curso();
			stmt.executeUpdate(sql);

			//Realizamos el cierre de los recursos.
			stmt.close();

		}catch (Exception e){
			throw new ExcepcionIntegracion("Error al modificar el curso.");
		}	   

		return datos.getId_Curso();
		// end-user-code
	}
	
	/** 
	 * (sin Javadoc)
	 * @see DAOCurso#eliminarCurso(TCurso datos)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int eliminarCurso(TCurso datos) throws ExcepcionIntegracion {
		// begin-user-code
		int id_curso = -1;
		boolean sw = false;
		Transaccion miTrans = (Transaccion) TransactionManager.getInstance().dameTransaccion();
		Connection conn = (Connection) miTrans.getResource();
		
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			
		}catch (SQLException e) {
			throw new ExcepcionIntegracion("Error al recuperar los recursos de la BBDD");
		}
		// :::BORRAR UN CURSO:::
		try {
			// Comprobamos si existe el alumno y está activo.
			String sql = "SELECT * FROM curso WHERE ID_Curso="
					+ datos.getId_Curso() + " AND Activo=1";
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				sw = true;
			}
		} catch (Exception e) {
			throw new ExcepcionIntegracion(
					"Error SQL al buscar el alumno en la BBDD para desactivarlo.");
		}
		//:::BORRAR UNA CURSO:::
		if(sw){
			try{
				//Modificamos su cambio activo a 'NO ACTIVO', en este caso = 0
				String sql="UPDATE curso SET Activo=0 WHERE ID_Curso="+datos.getId_Curso();
				stmt.executeUpdate(sql);
				//rs = stmt.getResultSet();

				id_curso = datos.getId_Curso();

				//Realizamos el cierre de los recursos.
				stmt.close();
				rs.close();
			}catch (Exception e){
				throw new ExcepcionIntegracion("Error al desactivar un curso.");
			}	   
		}
		return id_curso;

		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see DAOCurso#listarCursos()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList<TCurso> listarCursos() throws ExcepcionIntegracion {
		// begin-user-code
		TCurso miCurso = null;
		ArrayList<TCurso> misCursos = new ArrayList<TCurso>();

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
		           String sql="SELECT * FROM curso WHERE Activo=1 FOR UPDATE";
		           rs=stmt.executeQuery(sql);
		           //Añadimos a la lista todos los cursos encontrados en la base de datos.
		           while(rs.next()){
			           miCurso = new TCurso(rs.getInt(1), rs.getString(2), rs.getInt(3));
				       misCursos.add(miCurso);
		           }
		           //Realizamos el cierre de los recursos
			       stmt.close();
			       rs.close();
			}catch (Exception e){
		    	throw new ExcepcionIntegracion("Error SQL al buscar los cursos en la BBDD.");
		    }
			return misCursos;
		// end-user-code
	}
}