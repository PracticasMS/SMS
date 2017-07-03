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
public class ComandoBorrarCurso implements Comando {
	/** 
	 * (sin Javadoc)
	 * @see Comando#execute()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Contexto execute(Object datos) {
		// begin-user-code
		//TCurso miCurso = 
		int ID_Curso;
		Contexto contx = null;
		
		SACurso miSACurso = FactoriaSA.getInstance().creaSACurso();
		
		try {
			ID_Curso = miSACurso.borrarCurso((TCurso)datos);
			if(ID_Curso == -1){
				contx = new Contexto(EventoGUI.CURSO_INEXISTENTE, ID_Curso);
			}else if (ID_Curso == -2){
				contx = new Contexto(EventoGUI.CURSO_VIGENTE, ID_Curso);
			}
			else{
				contx = new Contexto(EventoGUI.CURSO_BORRADO, ID_Curso);
			}
			
		} catch (ExcepcionNegocio e) {
			contx = new Contexto(EventoGUI.CURSO_BORRAR_ERROR, null);

		}
		
		return contx;
		// end-user-code
	}
}