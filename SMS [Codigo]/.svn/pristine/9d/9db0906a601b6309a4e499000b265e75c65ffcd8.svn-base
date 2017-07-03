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
public class ComandoCrearCurso implements Comando {
	
	public Contexto execute(Object datos) {
		
		int ID_Curso;
		Contexto contex = null;
		
		SACurso SaCurso = FactoriaSA.getInstance().creaSACurso();
		
		try{
			
			ID_Curso = SaCurso.crearCurso((TCurso)datos);
			
			if(ID_Curso == -1){
				contex = new Contexto(EventoGUI.CURSO_EXISTENTE, null);
			}else{
				contex = new Contexto(EventoGUI.CURSO_CREADO, ID_Curso);
			}
		}
		catch(ExcepcionNegocio e) {
			
			contex = new Contexto(EventoGUI.CURSO_CREAR_ERROR, null);
			
		}
		
		return contex;
		// end-user-code
	}
}