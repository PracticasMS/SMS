/**
 * @ProjectName SMSProg
 */
package SMSDAO.Integracion.Query;

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
 * @Project_Name SMSProg
 * @Author Rodrigo de Miguel González
 * @Date 06/12/2015
 * @File_Name ListarAlumnosConNMatriculasEnMAnos.java
 */
public class ListarAlumnosConNMatriculasEnMAnos implements Query {

	/* (sin Javadoc)
	 * @see SMSDAO.Integracion.Query.Query#execute(java.lang.Object)
	 */
	@Override
	public Object execute(Object datos) throws ExcepcionIntegracion {
		// begin-user-code
		TAlumno miAlumno = null;
		ArrayList<TAlumno> misAlumnos = new ArrayList<TAlumno>();

		TAlumno misDatos = (TAlumno) datos;
		
		int numMatriculas = misDatos.getNumMatriculas();
		int numAnos = misDatos.getNumAñosConMarticulas();
		
		
		Transaccion miTrans = (Transaccion) TransactionManager.getInstance().dameTransaccion();
		Connection conn = (Connection) miTrans.getResource();

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			throw new ExcepcionIntegracion("Error al establecer conexion con la BBDD.");
		}
		// :::CONSULTAMOS A LA BBDD:::
		try {
			String sql = "select alu.* " +
					"from alumnos as alu, matriculas as ma " +
					"WHERE alu.DNI=ma.DNI AND substring(ma.Fecha_curso,1,4)> substring(CURDATE(),1,4) - " + numAnos +
					" GROUP BY ma.DNI HAVING count(ma.DNI)>= " + numMatriculas + 
					" FOR UPDATE";
			
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
	}

}
