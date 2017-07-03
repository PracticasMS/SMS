/**
 * 
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
import SMSDAO.Negocio.Matricula.TMatricula;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ListarMatriculasNCursos implements Query {
	
	public Object execute(Object datos) throws ExcepcionIntegracion {
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
					"GROUP BY n.ID_Matricula HAVING numCursos>="+ (Integer)datos +
					" FOR UPDATE";
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
	}
}