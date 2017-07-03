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
public class ComandoMostrarAlumno implements Comando {
	/** 
	 * (sin Javadoc)
	 * @see Comando#execute(Object datos)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Contexto execute(Object datos) {
		TAlumno tAlumno = null;
		Contexto contx = null;
		
		SAAlumno miSAAlumno = FactoriaSA.getInstance().creaSAAlumno();
		
		try {
			tAlumno = miSAAlumno.mostrarAlumno((TAlumno)datos);
			//rellenar el contexto
			
			if(tAlumno == null){
				contx = new Contexto(EventoGUI.BUSCAR_ALUMNO_ERROR, tAlumno);
			}else{
				contx = new Contexto(EventoGUI.MOSTRAR_ALUMNO, tAlumno);
			}
		}catch (ExcepcionNegocio e) {
			contx = new Contexto(EventoGUI.BUSCAR_ALUMNO_ERROR, tAlumno);
		}
			
		return contx;
		// end-user-code
	}
}