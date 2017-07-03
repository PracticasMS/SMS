/**
 * 
 */
package SMSDAO.Integracion.Alumnos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import SMSDAO.Integracion.ExcepcionesIntegracion.ExcepcionIntegracion;
import SMSDAO.Integracion.Transacciones.Transaccion;
import SMSDAO.Integracion.TransactionManager.TransactionManager;
import SMSDAO.Negocio.Alumnos.TAlumno;
import SMSDAO.Negocio.Alumnos.TAlumnoFamNumerosa;
import SMSDAO.Negocio.Alumnos.TAlumnoNoFamNumerosa;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Tomas
 */
public class DAOAlumnoImp implements DAOAlumno {

	public int eliminarAlumno(TAlumno datos) throws ExcepcionIntegracion {
		// begin-user-code
		boolean sw = false;
		int DNI = -1;
		Transaccion miTrans = (Transaccion) TransactionManager.getInstance()
				.dameTransaccion();
		Connection conn = (Connection) miTrans.getResource();

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();

		} catch (SQLException e) {
			throw new ExcepcionIntegracion(
					"Error al recuperar los recursos de la BBDD");
		}

		// :::BORRAR UNA CURSO:::
		try {
			// Comprobamos si existe el alumno y está activo.
			String sql = "SELECT * FROM alumnos WHERE DNI="
					+ datos.getDni() + " AND Activo=1";
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				sw = true;
			}
		} catch (Exception e) {
			throw new ExcepcionIntegracion(
					"Error SQL al buscar el alumno en la BBDD para desactivarlo.");
		}

		if (sw) {
			try {
				// Modificamos su cambio activo a 'NO ACTIVO', en este caso = 0
				String sql = "UPDATE alumnos SET Activo=0 WHERE DNI="
						+ datos.getDni();
				stmt.executeUpdate(sql);

				DNI = datos.getDni();
				// Realizamos el cierre de los recursos.
				stmt.close();
				rs.close();

			} catch (Exception e) {
				throw new ExcepcionIntegracion("Error al desactivar un alumno.");
			}
		}
		return DNI;

		// end-user-code
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see DAOAlumno#buscarAlumnoByDNI(TAlumno datos)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TAlumno buscarAlumnoByDNI(TAlumno datos) throws ExcepcionIntegracion {
		// begin-user-code
		TAlumno miAlumno = null;

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String nombre;
		String apellidos;
		String direccion;
		int telefono;

		String fecha_Nacimiento;

		int num_fam;
		int num_Seg_social;

		Transaccion miTrans = TransactionManager.getInstance()
				.dameTransaccion();

		conn = (Connection) miTrans.getResource();

		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			throw new ExcepcionIntegracion(
					"Error al recuperar los recursos de la BBDD");
		}

		String query = "SELECT * FROM alumnos WHERE DNI=" + datos.getDni()
				+ " AND Activo=1 FOR UPDATE";

		try {
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			throw new ExcepcionIntegracion("ERROR al buscar el Alumno");

		}

		try {
			if (rs.next()) {
				nombre = rs.getString(2);
				apellidos = rs.getString(3);
				direccion = rs.getString(4);
				fecha_Nacimiento = rs.getString(5);
				telefono = rs.getInt(6);

				if (rs.getInt(7) == 0) { // No es alumno de familia numerosa
					num_Seg_social = rs.getInt(8);
					miAlumno = new TAlumnoNoFamNumerosa(rs.getInt(1), nombre,
							apellidos, direccion, fecha_Nacimiento, telefono,
							rs.getInt(9), num_Seg_social);
				} else {
					num_fam = rs.getInt(7);
					miAlumno = new TAlumnoFamNumerosa(rs.getInt(1), nombre,
							apellidos, direccion, fecha_Nacimiento, telefono,
							rs.getInt(9), num_fam);
				}
			} else {
				miAlumno = null;
			}

			stmt.close();
			rs.close();

		} catch (SQLException e) {
			throw new ExcepcionIntegracion("ERROR en la busqueda del alumno");
		}

		return miAlumno;
		// end-user-code
	}
	
	/**
	 * (sin Javadoc)
	 * 
	 * @see DAOAlumno#buscarAlumnoByDNI(TAlumno datos)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TAlumno buscarAlumnoByDNIALL(TAlumno datos) throws ExcepcionIntegracion {
		// begin-user-code
		TAlumno miAlumno = null;

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String nombre;
		String apellidos;
		String direccion;
		int telefono;

		String fecha_Nacimiento;

		int num_fam;
		int num_Seg_social;

		Transaccion miTrans = TransactionManager.getInstance()
				.dameTransaccion();

		conn = (Connection) miTrans.getResource();

		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			throw new ExcepcionIntegracion(
					"Error al recuperar los recursos de la BBDD");
		}

		String query = "SELECT * FROM alumnos WHERE DNI=" + datos.getDni()+" FOR UPDATE";

		try {
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			throw new ExcepcionIntegracion("ERROR al buscar el Alumno");

		}

		try {
			if (rs.next()) {
				nombre = rs.getString(2);
				apellidos = rs.getString(3);
				direccion = rs.getString(4);
				fecha_Nacimiento = rs.getString(5);
				telefono = rs.getInt(6);

				if (rs.getInt(7) == 0) { // No es alumno de familia numerosa
					num_Seg_social = rs.getInt(8);
					miAlumno = new TAlumnoNoFamNumerosa(rs.getInt(1), nombre,
							apellidos, direccion, fecha_Nacimiento, telefono,
							rs.getInt(9), num_Seg_social);
				} else {
					num_fam = rs.getInt(7);
					miAlumno = new TAlumnoFamNumerosa(rs.getInt(1), nombre,
							apellidos, direccion, fecha_Nacimiento, telefono,
							rs.getInt(9), num_fam);
				}
			} else {
				miAlumno = null;
			}

			stmt.close();
			rs.close();

		} catch (SQLException e) {
			throw new ExcepcionIntegracion("ERROR en la busqueda del alumno");
		}

		return miAlumno;
		// end-user-code
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see DAOAlumno#buscarAlumnoByID(TAlumno datos)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	/*public TAlumno buscarAlumnoByID(TAlumno datos) throws ExcepcionIntegracion {
		// begin-user-code
		TAlumno miAlumno = null;

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String nombre;
		String apellidos;
		String direccion;
		int telefono;

		String fecha_Nacimiento;

		int num_fam;
		int num_Seg_social;

		Transaccion miTrans = TransactionManager.getInstance()
				.dameTransaccion();

		conn = (Connection) miTrans.getResource();

		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			throw new ExcepcionIntegracion(
					"Error al recuperar los recursos de la BBDD");
		}

		String query = "SELECT * FROM alumnos WHERE ID_Alumno=" + datos.getId()
				+ " AND Activo=1 FOR UPDATE";

		try {
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			throw new ExcepcionIntegracion("ERROR al buscar el Alumno");

		}

		try {
			if (rs.next()) {
				nombre = rs.getString(2);
				apellidos = rs.getString(3);
				direccion = rs.getString(4);
				fecha_Nacimiento = rs.getString(5);
				telefono = rs.getInt(6);

				if (rs.getInt(7) == 0) { // No es alumno de familia numerosa
					num_Seg_social = rs.getInt(8);
					miAlumno = new TAlumnoNoFamNumerosa(rs.getInt(1), nombre,
							apellidos, direccion, fecha_Nacimiento, telefono,
							rs.getInt(9), num_Seg_social, rs.getInt(10));
				} else {
					num_fam = rs.getInt(7);
					miAlumno = new TAlumnoFamNumerosa(rs.getInt(1), nombre,
							apellidos, direccion, fecha_Nacimiento, telefono,
							rs.getInt(9), num_fam, rs.getInt(10));
				}
			} else {
				miAlumno = null;
			}

			stmt.close();
			rs.close();

		} catch (SQLException e) {
			throw new ExcepcionIntegracion("ERROR en la busqueda del alumno");
		}

		return miAlumno;
		// end-user-code
	}*/

	/**
	 * (sin Javadoc)
	 * 
	 * @see DAOAlumno#listarAlumnos()
	 */
	public ArrayList<TAlumno> listarAlumnos() throws ExcepcionIntegracion {
		// begin-user-code
		TAlumno miAlumno = null;
		ArrayList<TAlumno> misAlumnos = new ArrayList<TAlumno>();

		Transaccion miTrans = (Transaccion) TransactionManager.getInstance()
				.dameTransaccion();
		Connection conn = (Connection) miTrans.getResource();

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			throw new ExcepcionIntegracion(
					"Error al establecer conexion con la BBDD.");
		}
		// :::CONSULTAMOS A LA BBDD:::
		try {
			String sql = "SELECT * FROM Alumnos WHERE Activo=1 FOR UPDATE";
			rs = stmt.executeQuery(sql);

			int dni = -1;
			String nombre = null;
			String apellidos = null;
			String fecha_nacimiento = null;
			String direccion = null;
			int telefono = -1;
			int num_familiares = -1;
			int num_seguridad_social = -1;
			int activo = -1;

			// Añadimos a la lista todos los cursos encontrados en la base de
			// datos.
			while (rs.next()) {

				reiniciarParametros(dni, nombre, apellidos, direccion,
						fecha_nacimiento, telefono, num_familiares,
						num_seguridad_social, activo);

				dni = rs.getInt(1);
				nombre = rs.getString(2);
				apellidos = rs.getString(3);
				direccion = rs.getString(4);
				fecha_nacimiento = rs.getString(5);
				telefono = rs.getInt(6);
				num_familiares = rs.getInt(7);
				num_seguridad_social = rs.getInt(8);
				activo = rs.getInt(9);

				if (num_familiares == 0) {
					miAlumno = new TAlumnoNoFamNumerosa(dni, nombre, apellidos,
							direccion, fecha_nacimiento, telefono,
							num_seguridad_social);
				} else {
					miAlumno = new TAlumnoFamNumerosa(dni, nombre, apellidos,
							direccion, fecha_nacimiento, telefono,
							num_familiares);
				}

				misAlumnos.add(miAlumno);
			}
			// Realizamos el cierre de los recursos
			stmt.close();
			rs.close();
		} catch (Exception e) {
			throw new ExcepcionIntegracion(
					"Error SQL al buscar los cursos en la BBDD.");
		}
		return misAlumnos;
		// end-user-code
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see DAOAlumno#modificarAlumnos(TAlumno datos)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int modificarAlumnos(TAlumno datos) throws ExcepcionIntegracion {
		// begin-user-code
		Transaccion miTrans = (Transaccion) TransactionManager.getInstance()
				.dameTransaccion();
		Connection conn = (Connection) miTrans.getResource();

		Statement stmt = null;

		try {
			stmt = conn.createStatement();

		} catch (SQLException e) {
			throw new ExcepcionIntegracion(
					"Error al recuperar los recursos de la BBDD");
		}
		boolean famNumerosa;
		if (datos instanceof TAlumnoNoFamNumerosa) {
			famNumerosa = false;
		} else {
			famNumerosa = true;
		}
		// :::MODIFICACION DE UN ALUMNO:::
		String sql1 = "";
		try {
			if (famNumerosa) {
				TAlumnoFamNumerosa datosAc = (TAlumnoFamNumerosa) datos;
				sql1 = "UPDATE alumnos SET " + "Nombre='" + datosAc.getNombre()
						+ "'," + "Apellidos='" + datosAc.getApellidos() + "',"
						+ "Direccion='" + datosAc.getDireccion() + "',"
						+ "Fecha_Nacimiento='" + datosAc.getFecha_Nacimiento()
						+ "'," + "Telefono=" + datosAc.getTelefono() + ","
						+ "Num_fam_numerosa=" + datosAc.getNum_fam() + ","
						+ "Num_Seg_Social=0, DNI=" + datosAc.getDni()
						+ ", Activo="+ datosAc.getActivo()
						+ " WHERE DNI=" + datosAc.getDni();
			} else {
				TAlumnoNoFamNumerosa datosAc = (TAlumnoNoFamNumerosa) datos;
				sql1 = "UPDATE alumnos SET " + "Nombre='" + datosAc.getNombre()
						+ "'," + "Apellidos='" + datosAc.getApellidos() + "',"
						+ "Direccion='" + datosAc.getDireccion() + "',"
						+ "Fecha_Nacimiento='" + datosAc.getFecha_Nacimiento()
						+ "'," + "Telefono=" + datosAc.getTelefono() + ","
						+ "Num_fam_numerosa=0," + "Num_Seg_Social="
						+ datosAc.getNum_seg_social() + ",DNI="
						+ datosAc.getDni() + " WHERE DNI="
						+ datosAc.getDni();
			}
			stmt.executeUpdate(sql1);
			stmt.close();

		} catch (Exception e) {
			throw new ExcepcionIntegracion(
					"Error SQL al modificar un alumno en la BBDD.");
		}
		return datos.getDni();
		// end-user-code
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see DAOAlumno#crearAlumnos(TAlumno datos)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int crearAlumnos(TAlumno datos) throws ExcepcionIntegracion {
		Transaccion miTrans = (Transaccion) TransactionManager.getInstance()
				.dameTransaccion();
		Connection conn = (Connection) miTrans.getResource();
		int dni = -1;

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();

		} catch (SQLException e) {
			throw new ExcepcionIntegracion(
					"Error al recuperar los recursos de la BBDD");
		}
		boolean famNumerosa;
		if (datos instanceof TAlumnoNoFamNumerosa) {
			famNumerosa = false;
		} else {
			famNumerosa = true;
		}
		// :::CREACIÓN DE UN ALUMNO:::
		String sql1 = "";
		try {
			if (famNumerosa) {
				TAlumnoFamNumerosa datosAc = (TAlumnoFamNumerosa) datos;
				sql1 = "INSERT Alumnos(DNI, Nombre, Apellidos, Direccion, Fecha_Nacimiento, Telefono, Num_fam_numerosa, Num_Seg_Social) "
						+ "VALUES ("
						+ datosAc.getDni()
						+ ",'"
						+ datosAc.getNombre()
						+ "', '"
						+ datosAc.getApellidos()
						+ "', '"
						+ datosAc.getDireccion()
						+ "', '"
						+ datosAc.getFecha_Nacimiento()
						+ "', "
						+ datosAc.getTelefono()
						+ ", "
						+ datosAc.getNum_fam()
						+ ", 0);";
			} else {
				TAlumnoNoFamNumerosa datosAc = (TAlumnoNoFamNumerosa) datos;
				sql1 = "INSERT Alumnos(DNI, Nombre, Apellidos, Direccion, Fecha_Nacimiento, Telefono, Num_fam_numerosa, Num_Seg_Social) "
						+ "VALUES ("
						+ datosAc.getDni()
						+ ",'"
						+ datosAc.getNombre()
						+ "', '"
						+ datosAc.getApellidos()
						+ "', '"
						+ datosAc.getDireccion()
						+ "', '"
						+ datosAc.getFecha_Nacimiento()
						+ "', "
						+ datosAc.getTelefono()
						+ ", 0, "
						+ datosAc.getNum_seg_social() + ");";
			}
			stmt.executeUpdate(sql1, Statement.RETURN_GENERATED_KEYS);
		} catch (Exception e) {
			throw new ExcepcionIntegracion(
					"Error SQL al crear un alumno en la BBDD.");
		}
		// Recuperamos el último ID_Curso insertado.
		try {
			rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				dni = rs.getInt(1);
			}

			// Realizamos el cierre de los recursos.
			stmt.close();
			rs.close();
		} catch (Exception e) {
			throw new ExcepcionIntegracion(
					"Error al recuperar el último ID_Alumno insertado.");
		}
		return dni;
	}

	private void reiniciarParametros(int dni, String nombre, String apellidos,
			String direccion, String fecha_nacimiento, int telefono,
			int num_familiares, int num_seguridad_social, int activo) {

		dni = -1;
		nombre = null;
		apellidos = null;
		fecha_nacimiento = null;
		direccion = null;
		telefono = -1;
		num_familiares = -1;
		num_seguridad_social = -1;
		activo = -1;

	}
}