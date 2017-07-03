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
public class ComandoModificarAlumno implements Comando {
	/** 
	 * (sin Javadoc)
	 * @see Comando#execute(Object datos)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Contexto execute(Object datos) {
		//TCurso miCurso = 
		int dni_alumno = -1;
		Contexto contx = null;
		
		SAAlumno miSAAlumno = FactoriaSA.getInstance().creaSAAlumno();
		
		try {
			dni_alumno = miSAAlumno.modificarAlumno((TAlumno)datos);
			//rellenar el contexto
			if(dni_alumno == -1){
				contx = new Contexto(EventoGUI.MODIFICAR_ALUMNO_ERROR, dni_alumno);
			}else if (dni_alumno == -2){
				contx = new Contexto(EventoGUI.MODIFICAR_ALUMNO_ERROR_DNI, dni_alumno);
			}else{
				contx = new Contexto(EventoGUI.MODIFICAR_ALUMNO_CORRECTO, dni_alumno);
			}
			
		}catch (ExcepcionNegocio e) {
			contx = new Contexto(EventoGUI.MODIFICAR_ALUMNO_ERROR, dni_alumno);
		}
		
		return contx;
	}
}