/**
 * 
 */
package SMSDAO.Presentacion.Comandos.Curso;

import java.util.ArrayList;

import SMSDAO.Negocio.Curso.SACurso;
import SMSDAO.Negocio.Curso.TCurso;
import SMSDAO.Negocio.ExcepcionNegocio.ExcepcionNegocio;
import SMSDAO.Negocio.FactoriaSA.FactoriaSA;
import SMSDAO.Presentacion.Comandos.Comando;
import SMSDAO.Presentacion.Controlador.Contexto;
import SMSDAO.Presentacion.JPrincipal.EventoGUI;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ComandoListarCurso implements Comando {
	/** 
	 * (sin Javadoc)
	 * @see Comando#execute()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Contexto execute(Object datos) {
		Contexto contx = null;
		ArrayList<TCurso> misReservas = null;
		SACurso miSACurso = FactoriaSA.getInstance().creaSACurso();
		
		try {
			
			misReservas = miSACurso.listarCursos();
			contx = new Contexto(EventoGUI.LISTAR_CURSOS, misReservas);
			
		}catch (ExcepcionNegocio e) {
			contx = new Contexto(EventoGUI.LISTAR_CURSOS_ERROR, null);
		}

		return contx;
		// end-user-code
	}
}