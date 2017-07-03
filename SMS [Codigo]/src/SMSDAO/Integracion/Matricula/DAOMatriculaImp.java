/**
 * 
 */
package SMSDAO.Integracion.Matricula;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import SMSDAO.Integracion.ExcepcionesIntegracion.ExcepcionIntegracion;
import SMSDAO.Integracion.Transacciones.Transaccion;
import SMSDAO.Integracion.TransactionManager.TransactionManager;
import SMSDAO.Negocio.Matricula.TCursoNivel;
import SMSDAO.Negocio.Matricula.TMatricula;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Eduardo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DAOMatriculaImp implements DAOMatricula {
	
	
	/** Rellena un Transfer matricula con todo slos datos de la misma, incluyendo los cursos que tiene matriculados
	 */
	public TMatricula buscarMatriculaByID(int id_Matricula) throws ExcepcionIntegracion {
		TMatricula miMatricula = null;

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
		
		try{
			miMatricula = rellenarDatosMatricula(stmt, id_Matricula);
			miMatricula = rellenarCursosDeMatricula(stmt, miMatricula);
		
	           
			//Realizamos el cierre de los recursos
			stmt.close();
		}
		catch (Exception e){
			throw new ExcepcionIntegracion("Error en la busqueda del curso.");
		}	
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return miMatricula;
		// end-user-code
	}

	/** 
	 * @param stmt
	 * @param miMatricula
	 * @return
	 * @throws ExcepcionIntegracion 
	 * @see DAOMatricula#buscarMatriculaByID()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private TMatricula rellenarCursosDeMatricula(Statement stmt, TMatricula miMatricula) throws ExcepcionIntegracion {
		//TMatricula miMatricula = null;
		TCursoNivel miCursoNivel = null;
		int numCursos = 0;
		ArrayList<TCursoNivel> misCursos = new ArrayList<TCursoNivel>();
		
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		String sql = "SELECT n.ID_Curso, c.nombre, n.Nivel " +
				"FROM nivel_matric_cursos n, curso c " +
				"WHERE n.ID_Curso = c.ID_Curso AND n.ID_Matricula = " + miMatricula.getID_Matricula() +" FOR UPDATE";

		try{
			ResultSet rs=stmt.executeQuery(sql);
			//Añadimos a la lista todos las matriculas encontradas en la base de datos.
			while(rs.next()){

				int id_curso = rs.getInt(1);
				String nombreCurso = rs.getString(2);
				String nivelCurso = rs.getString(3);
				numCursos++;
				
				miCursoNivel = new TCursoNivel(id_curso, nombreCurso, nivelCurso);
				misCursos.add(miCursoNivel);
			}	
			
			miMatricula.setCursosNivel(misCursos);
			miMatricula.setNumCursos(numCursos);
			
			rs.close();
		}catch (Exception e){
			throw new ExcepcionIntegracion("Error en la busqueda del curso.");
		}
		return miMatricula;
		// end-user-code
	}


	/** 
	 * @param stmt
	 * @param miMatricula
	 * @throws ExcepcionIntegracion 
	 */
	private TMatricula rellenarDatosMatricula(Statement stmt, int ID_Matricula) throws ExcepcionIntegracion {
		TMatricula miMatricula = null;
		String sql="SELECT * FROM matriculas WHERE ID_Matricula=" + ID_Matricula + " AND Activo = 1 FOR UPDATE";

		try{
			ResultSet rs=stmt.executeQuery(sql);
			//Añadimos a la lista todos las matriculas encontradas en la base de datos.
			while(rs.next()){

				int id_matricula = rs.getInt(1);
				int id_alumno = rs.getInt(2);
				String tipo = rs.getString(3);
				int precio = rs.getInt(4);
				String fecha = rs.getString(5);
				int activo = rs.getInt(6);
				int numCursos = 0;

				miMatricula = new TMatricula(id_matricula, id_alumno, tipo, precio, fecha, null, numCursos, activo);
			}	
		}catch (Exception e){
			throw new ExcepcionIntegracion("Error en la busqueda del curso.");
		}
		return miMatricula;
	}

	/** 
	 * (sin Javadoc)
	 * @see DAOMatricula#buscaMatriculaByAlumno()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TMatricula buscaMatriculaByAlumno(int datos) throws ExcepcionIntegracion {
		// begin-user-code
		TMatricula miMatricula = null;

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
		
		String query="SELECT * FROM matriculas WHERE ID_Alumno=" + datos + " AND Activo = 1 FOR UPDATE";
		
		try{
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			throw new ExcepcionIntegracion("Error al buscar el alumno en matriculas.");
		}
		
		try{
			if (rs.next()){
				miMatricula = new TMatricula(rs.getInt(2));
	               
	        }else{
	        	miMatricula=null;
	       	   //throw new ExcepcionIntegracion("Error al buscar el curso.");
	        }
	           
			//Realizamos el cierre de los recursos.
		    stmt.close();
		    rs.close();
		}
		catch (Exception e){
			throw new ExcepcionIntegracion("Error en la busqueda del alumno en matrículas.");
		}	
		
		return miMatricula;
	}

	/** 
	 * (sin Javadoc)
	 * @see DAOMatricula#crearMatricula()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int crearMatricula(TMatricula datos) throws ExcepcionIntegracion {
		// begin-user-code
		Transaccion miTrans = (Transaccion) TransactionManager.getInstance()
				.dameTransaccion();
		Connection conn = (Connection) miTrans.getResource();

		int id_matricula = -1;

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();

		} catch (SQLException e) {
			throw new ExcepcionIntegracion(
					"Error al recuperar los recursos de la BBDD");
		}

		// :::CREACIÓN DE UNA Matricula:::
		String sql = "";
		try {

			sql = "INSERT matriculas(DNI, Tipo, Precio, Fecha_curso, Activo) VALUES ("
					+ datos.getDNI()
					+ ", '"
					+ datos.getTipo()
					+ "', "
					+ datos.getPrecio() + ", CURDATE(), 1) ";

			stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

		} catch (Exception e) {
			throw new ExcepcionIntegracion(
					"Error SQL al insertar una matricula en la BBDD.");
		}
		// Recuperamos el último ID_Curso insertado.
		try {
			rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				id_matricula = rs.getInt(1);
			}

			// Realizamos el cierre de los recursos.
			stmt.close();
			rs.close();
		} catch (Exception e) {
			throw new ExcepcionIntegracion(
					"Error al recuperar el último ID_Matricula insertado.");
		}
		return id_matricula;
		// end-user-code
	}
	
	/** 
	 * (sin Javadoc)
	 * @see DAOMatricula#crearMatricula()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean insertarNivelMatriculaCurso(int id_matricula, TCursoNivel datos) throws ExcepcionIntegracion {
		// begin-user-code
		Transaccion miTrans = (Transaccion) TransactionManager.getInstance()
				.dameTransaccion();
		Connection conn = (Connection) miTrans.getResource();

		boolean llave = false;
		int retorno = -1;

		Statement stmt = null;
		

		try {
			stmt = conn.createStatement();

		} catch (SQLException e) {
			throw new ExcepcionIntegracion(
					"Error al recuperar los recursos de la BBDD");
		}

		// :::INSERCCIÓN DE UN NIVEL MATRICULA CURSO:::
		String sql = "";
		try {

			sql = "INSERT nivel_matric_cursos(ID_Matricula, ID_Curso, Nivel) VALUES ("+id_matricula+","+datos.getId_Curso()+",'"+datos.getNivel()+"')";

			retorno = stmt.executeUpdate(sql);

		} catch (Exception e) {
			throw new ExcepcionIntegracion(
					"Error SQL al insertar asociacion matricula-nivel-alumno en la BBDD.");
		}
		// Comprobamos si lo ha insertado correctamente.
		try {
			
			if (retorno == 1) {
				llave = true;	
			}

			// Realizamos el cierre de los recursos.
			stmt.close();
			
		} catch (Exception e) {
			throw new ExcepcionIntegracion(
					"Error SQL al insertar asociacion matricula-nivel-alumno en la BBDD.");
		}
		return llave;
		// end-user-code
	}
	
	
	public boolean actualizarNivelMatriculaCurso(int id_matricula, TCursoNivel datos) throws ExcepcionIntegracion {
		// begin-user-code
		Transaccion miTrans = (Transaccion) TransactionManager.getInstance().dameTransaccion();
		Connection conn = (Connection) miTrans.getResource();

		boolean llave = false;
		int retorno = -1;

		Statement stmt = null;
		

		try {
			stmt = conn.createStatement();

		} catch (SQLException e) {
			throw new ExcepcionIntegracion(
					"Error al recuperar los recursos de la BBDD");
		}

		// :::INSERCCIÓN DE UN NIVEL MATRICULA CURSO:::
		String sql = "";
		try {

			sql = "UPDATE nivel_matric_cursos SET nivel='"+datos.getNivel()+"' WHERE ID_Matricula="+ id_matricula + " AND ID_Curso =" + datos.getId_Curso();

			retorno = stmt.executeUpdate(sql);

		} catch (Exception e) {
			throw new ExcepcionIntegracion(
					"Error SQL al modificar asociacion matricula-nivel-alumno en la BBDD.");
		}
		// Comprobamos si lo ha insertado correctamente.
		try {
			
			if (retorno == 1) {
				llave = true;	
			}

			// Realizamos el cierre de los recursos.
			stmt.close();
			
		} catch (Exception e) {
			throw new ExcepcionIntegracion(
					"Error SQL al modificar asociacion matricula-nivel-alumno en la BBDD.");
		}
		return llave;
		// end-user-code
	}
	
	
	public boolean borrarNivelMatriculaCurso(int id_matricula, TCursoNivel datos) throws ExcepcionIntegracion {
		// begin-user-code
		Transaccion miTrans = (Transaccion) TransactionManager.getInstance().dameTransaccion();
		Connection conn = (Connection) miTrans.getResource();

		boolean llave = false;
		int retorno = -1;

		Statement stmt = null;
		

		try {
			stmt = conn.createStatement();

		} catch (SQLException e) {
			throw new ExcepcionIntegracion(
					"Error al recuperar los recursos de la BBDD");
		}

		// :::INSERCCIÓN DE UN NIVEL MATRICULA CURSO:::
		String sql = "";
		try {
			
			sql = "DELETE FROM nivel_matric_cursos WHERE ID_Matricula="+ id_matricula + " AND ID_Curso =" + datos.getId_Curso();

			retorno = stmt.executeUpdate(sql);

		} catch (Exception e) {
			throw new ExcepcionIntegracion(
					"Error SQL al modificar asociacion matricula-nivel-alumno en la BBDD.");
		}
		// Comprobamos si lo ha insertado correctamente.
		try {
			
			if (retorno == 1) {
				llave = true;	
			}

			// Realizamos el cierre de los recursos.
			stmt.close();
			
		} catch (Exception e) {
			throw new ExcepcionIntegracion(
					"Error SQL al modificar asociacion matricula-nivel-alumno en la BBDD.");
		}
		return llave;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see DAOMatricula#modificarMatricula()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int modificarMatricula(TMatricula datos) throws ExcepcionIntegracion {
		// begin-user-code
		Transaccion miTrans = (Transaccion) TransactionManager.getInstance().dameTransaccion();
		Connection conn = (Connection) miTrans.getResource();

		Statement stmt = null;

		try {
			stmt = conn.createStatement();

		} catch (SQLException e) {
			throw new ExcepcionIntegracion(
					"Error al recuperar los recursos de la BBDD");
		}

		// :::MODIFICACION DE UNA Matricula:::
		String sql = "";
		try {

			sql = "UPDATE matriculas SET Precio=" + datos.getPrecio() + ","
					+ "Tipo='" + datos.getTipo() + "' WHERE ID_Matricula="
					+ datos.getID_Matricula();

			stmt.executeUpdate(sql);
			stmt.close();

		} catch (Exception e) {
			throw new ExcepcionIntegracion(
					"Error SQL al modificar una matricula en la BBDD.");
		}
		return datos.getID_Matricula();
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @throws ExcepcionIntegracion 
	 * @see DAOMatricula#eliminarMatricula()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int eliminarMatricula(TMatricula datos) throws ExcepcionIntegracion {
		boolean sw = false;
		int id_Matricula = -1;
		Transaccion miTrans = (Transaccion) TransactionManager.getInstance().dameTransaccion();
		Connection conn = (Connection) miTrans.getResource();

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();

		} catch (SQLException e) {
			throw new ExcepcionIntegracion(
					"Error al recuperar los recursos de la BBDD");
		}

		// :::BORRAR UNA MATRICULA:::
		try {
			// Comprobamos si existe la matricula y está activa.
			String sql = "SELECT * FROM matriculas WHERE ID_Matricula="
					+ datos.getID_Matricula() + " AND Activo=1 FOR UPDATE";
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				sw = true;
			}
		} catch (Exception e) {
			throw new ExcepcionIntegracion(
					"Error SQL al buscar la Matricula en la BBDD para eliminarla.");
		}

		if (sw) {
			try {
				// Modificamos su cambio activo a 'NO ACTIVO', en este caso = 0
				String sql = "UPDATE matriculas SET Activo=0 WHERE ID_Matricula="
						+ datos.getID_Matricula();
				stmt.executeUpdate(sql);

				id_Matricula = datos.getID_Matricula();
				// Realizamos el cierre de los recursos.
				stmt.close();
				rs.close();

			} catch (Exception e) {
				throw new ExcepcionIntegracion(
						"Error al eliminar una matricula.");
			}
		}
		return id_Matricula;
	}

	
	
	
	
	public ArrayList<TMatricula> listarMatriculas() throws ExcepcionIntegracion{
		// begin-user-code
		// m.ID_Alumno, m.tipo, m.precio, m.fecha_curso, m.Activo,
		
		TMatricula miMatricula = null;
		ArrayList<TMatricula> misMatriculas = new ArrayList<TMatricula>();
		int numCursos = -1;
		
		
		Transaccion miTrans = (Transaccion) TransactionManager.getInstance().dameTransaccion();
		Connection conn = (Connection) miTrans.getResource();
		
		Statement stmt = null;
		ResultSet rs = null;
		
		/*
		 * SELECT m.ID_Matricula, count(n.ID_Curso) as numCursos
			FROM nivel_matric_cursos n, matriculas m
			group by n.ID_Matricula
			having n.ID_Matricula = 1;
		 */
		
		try{
			stmt=conn.createStatement();
		}
		catch(SQLException e){
			throw new ExcepcionIntegracion("Error al establecer conexion con la BBDD.");
		}
		//:::CONSULTAMOS A LA BBDD:::
		try{
			String sql="SELECT m.ID_Matricula, m.DNI, m.tipo, m.precio, m.Fecha_curso, m.activo, count(n.ID_Curso) as numCursos " +
					"FROM nivel_matric_cursos n, matriculas m " +
					"WHERE m.id_matricula = n.ID_Matricula AND m.activo = 1 " +
					"GROUP BY n.ID_Matricula " +
					"FOR UPDATE";
			rs=stmt.executeQuery(sql);
			//Añadimos a la lista todos las matriculas encontradas en la base de datos.
			while(rs.next()){

				int id_matricula = rs.getInt(1);
				int id_alumno = rs.getInt(2);
				String tipo = rs.getString(3);
				int precio = rs.getInt(4);
				String fecha = rs.getString(5);
				int activo = rs.getInt(6);
				numCursos = rs.getInt(7);
				
				miMatricula = new TMatricula(id_matricula, id_alumno, tipo, precio, fecha, null, numCursos, activo);
				
				misMatriculas.add(miMatricula);
			}
			//Realizamos el cierre de los recursos
			stmt.close();
			rs.close();
		}catch (Exception e){
			throw new ExcepcionIntegracion("Error SQL al buscar los cursos en la BBDD.");
		}
		return misMatriculas;

		// end-user-code
	}



}