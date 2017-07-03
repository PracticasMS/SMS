/**
 * 
 */
package SMSDAO.Presentacion.Comandos.Alumno;

import SMSDAO.Negocio.Alumnos.SAAlumno;
import SMSDAO.Negocio.Alumnos.TAlumno;
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
public class ComandoCrearAlumno implements Comando {
	/** 
	 * (sin Javadoc)
	 * @see Comando#execute(Object datos)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Contexto execute(Object datos) {
		int ID_Alumno;
		Contexto contex = null;
		
		SAAlumno SaAlumno = FactoriaSA.getInstance().creaSAAlumno();
		
		try{
			
			ID_Alumno = SaAlumno.crearAlumno((TAlumno)datos);
			
			if(ID_Alumno == -1){
				contex = new Contexto(EventoGUI.ALUMNO_CREAR_ERROR, null);
			}else if (ID_Alumno == -2){
				contex = new Contexto(EventoGUI.ALUMNO_CREAR_ERROR_DNI, null);
			}
			else{
				contex = new Contexto(EventoGUI.ALUMNO_CREADO, ID_Alumno);
			}
		}
		catch(ExcepcionNegocio e) {

			contex = new Contexto(EventoGUI.ALUMNO_CREAR_ERROR, null);
			
		}

		return contex;
	}
}