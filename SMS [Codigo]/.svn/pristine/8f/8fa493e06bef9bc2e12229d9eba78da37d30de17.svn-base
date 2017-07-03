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
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Tomas
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class CursosVigentesActualmente implements Query {

	public Object execute(Object datos) throws ExcepcionIntegracion {
		// begin-user-code
		int id_curso;
		boolean llave = false;

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
			String sql = "SELECT nivel.ID_Curso"
					+ " FROM nivel_matric_cursos as nivel, matriculas as matri"
					+ " WHERE nivel.ID_Matricula=matri.ID_Matricula AND" 
					+ " substring(matri.Fecha_curso,1,4)=substring(CURDATE(),1,4)"
					+ " AND nivel.ID_Curso= " + datos
					+ " GROUP BY nivel.ID_Curso" 
					+ " FOR UPDATE";
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			throw new ExcepcionIntegracion(
					"Error SQL al buscar los cursos en la BBDD.");
		}

		try {

			// Añadimos a la lista todas las zonas encontradas en la base de
			// datos.
			while (rs.next()) {
				id_curso = rs.getInt(1);
				llave = true;
			}

			// Realizamos el cierre de la conexion
			stmt.close();
			rs.close();
		} catch (Exception e) {
			throw new ExcepcionIntegracion(
					"Error en la busqueda de los cursos.");
		}
		return llave;
		// end-user-code

	}
}