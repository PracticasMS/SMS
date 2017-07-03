/**
 * 
 */
package SMSDAO.Presentacion.Comandos.Matricula;

import java.util.ArrayList;

import SMSDAO.Negocio.ExcepcionNegocio.ExcepcionNegocio;
import SMSDAO.Negocio.FactoriaSA.FactoriaSA;
import SMSDAO.Negocio.Matricula.SAMatricula;
import SMSDAO.Negocio.Matricula.TMatricula;
import SMSDAO.Presentacion.Comandos.Comando;
import SMSDAO.Presentacion.Controlador.Contexto;
import SMSDAO.Presentacion.JPrincipal.EventoGUI;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Eduardo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ComandoListarMatriculasNCursos implements Comando {
	/** 
	 * (sin Javadoc)
	 * @see Comando#execute(Object datos)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Contexto execute(Object datos) {
		
		// begin-user-code
		int numCursos = ((TMatricula) datos).getNumCursos();
		Contexto contx = null;
		ArrayList<TMatricula> misMatriculas = null;
		SAMatricula miSAMatriculas = FactoriaSA.getInstance().creaSAMatricula();
		
		try {
			
			misMatriculas = miSAMatriculas.listarMatriculasNCursos(numCursos);
			if (misMatriculas.size()!=0)
				contx = new Contexto(EventoGUI.LISTAR_MATRICULA_NCURSOS, misMatriculas);
			else contx = new Contexto(EventoGUI.LISTAR_MATRICULA_NCURSOS_ERROR, misMatriculas);
			
		}catch (ExcepcionNegocio e) {
			contx = new Contexto(EventoGUI.LISTAR_MATRICULAS_ERROR, null);
		}

		return contx;
		// end-user-code
	}
}