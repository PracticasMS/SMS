/**
 * 
 */
package SMSDAO.Presentacion.Comandos.Matricula;

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
public class ComandoCrearMatricula implements Comando {
	/** 
	 * (sin Javadoc)
	 * @see Comando#execute(Object datos)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Contexto execute(Object datos) {
		int ID_Matricula;
		Contexto contex = null;
		
		SAMatricula SaMatricula = FactoriaSA.getInstance().creaSAMatricula();
		
		try{
		
			ID_Matricula = SaMatricula.crearMatricula((TMatricula)datos);
			
			if(ID_Matricula == -1){
				contex = new Contexto(EventoGUI.MATRICULA_CREAR_ERROR, null);
			}
			else if (ID_Matricula == -2){
				contex = new Contexto(EventoGUI.MATRICULA_CREAR_ERROR_VIGENTE, null);
			}
			else if (ID_Matricula == -3){
				contex = new Contexto(EventoGUI.MATRICULA_CREAR_ERROR_CURSOS, null);
			}
			else if (ID_Matricula == -4){
				contex = new Contexto(EventoGUI.MATRICULA_CREAR_ERROR_ALUMNO_NOEXISTS, null);
			}
			else{
				contex = new Contexto(EventoGUI.MATRICULA_CREADO, ID_Matricula);
			}
		}
		catch(ExcepcionNegocio e) {

			contex = new Contexto(EventoGUI.ALUMNO_CREAR_ERROR, null);
			
		}

		return contex;
	}
}