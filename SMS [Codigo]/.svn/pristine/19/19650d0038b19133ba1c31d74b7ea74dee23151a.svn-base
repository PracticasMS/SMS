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
public class ComandoModificarCurso implements Comando {
	/** 
	 * (sin Javadoc)
	 * @see Comando#execute()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Contexto execute(Object datos) {
		// begin-user-code
		//TCurso miCurso = 
		int id_curso = -1;
		Contexto contx = null;
		
		SACurso miSACurso = FactoriaSA.getInstance().creaSACurso();
		
		try {
			id_curso = miSACurso.modificarCurso((TCurso)datos);
			//rellenar el contexto
			if(id_curso == -1){
				contx = new Contexto(EventoGUI.MODIFICAR_CURSO_ERROR, id_curso);
			}else if (id_curso == -2){
				contx = new Contexto(EventoGUI.MODIFICAR_CURSO_DUPLICADO, id_curso);
			}
			else{
				contx = new Contexto(EventoGUI.MODIFICAR_CURSO_CORRECTO, id_curso);
			}
			
		}catch (ExcepcionNegocio e) {
			contx = new Contexto(EventoGUI.MODIFICAR_CURSO_ERROR, id_curso);
		}
		
		return contx;
		// end-user-code
	}
}