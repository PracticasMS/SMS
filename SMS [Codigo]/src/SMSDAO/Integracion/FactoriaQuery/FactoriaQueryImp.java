/**
 * @ProjectName SMSProg
 */
package SMSDAO.Integracion.FactoriaQuery;

import SMSDAO.Integracion.Query.CursosVigentesActualmente;
import SMSDAO.Integracion.Query.ListarAlumnosConNMatriculasEnMAnos;
import SMSDAO.Integracion.Query.ListarMatriculasNCursos;
import SMSDAO.Integracion.Query.MatriculaVigenteByDNI;
import SMSDAO.Integracion.Query.Query;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Tomas
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class FactoriaQueryImp extends FactoriaQuery {
	/**
	 * (sin Javadoc)
	 * 
	 * @see FactoriaQuery#creaQuery(int tipoQuery)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Query creaQuery(int tipoQuery) {
		// begin-user-code
		Query miQuery = null;

		switch (tipoQuery) {
			case Querys.cursosVigentesActualmente: {
				miQuery = new CursosVigentesActualmente();
	
			} break;
			
			case Querys.MatriculasVigentesByDNI: {
				miQuery = new MatriculaVigenteByDNI();
			} break;
			
			case Querys.listarAlumnosConNMatriculasEnMAnos: {
				miQuery = new ListarAlumnosConNMatriculasEnMAnos();
			}
			break;
			
			case Querys.listarMatriculasNCursos: {
				miQuery = new ListarMatriculasNCursos();
			}
			break;
		}

		return miQuery;
		// end-user-code
	}
}