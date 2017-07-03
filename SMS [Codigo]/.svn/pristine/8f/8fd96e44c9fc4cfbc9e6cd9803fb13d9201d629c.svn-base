/**
 * 
 */
package SMSDAO.Presentacion.Comandos.Curso;

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
public class ComandoMostrarCurso implements Comando {
	/** 
	 * (sin Javadoc)
	 * @see Comando#execute()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Contexto execute(Object datos) {
		TCurso tCurso = null;
		Contexto contx = null;
		
		SACurso miSACurso = FactoriaSA.getInstance().creaSACurso();
		
		try {
			tCurso = miSACurso.mostrarCurso((TCurso)datos);
			//rellenar el contexto
			
			if(tCurso == null){
				contx = new Contexto(EventoGUI.BUSCAR_CURSO_ERROR, tCurso);
			}else{
				contx = new Contexto(EventoGUI.MOSTRAR_CURSO, tCurso);
			}
		}catch (ExcepcionNegocio e) {
			contx = new Contexto(EventoGUI.BUSCAR_CURSO_ERROR, tCurso);
		}
			
		return contx;
		// end-user-code
	}
}