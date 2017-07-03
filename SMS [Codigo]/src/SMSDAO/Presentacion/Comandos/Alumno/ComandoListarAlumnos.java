/**
 * 
 */
package SMSDAO.Presentacion.Comandos.Alumno;

import java.util.ArrayList;

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
public class ComandoListarAlumnos implements Comando {
	/** 
	 * (sin Javadoc)
	 * @see Comando#execute(Object datos)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Contexto execute(Object datos) {
		Contexto contx = null;
		ArrayList<TAlumno> misAlumnos = null;
		SAAlumno miSAAlumno = FactoriaSA.getInstance().creaSAAlumno();
		
		try {
			
			misAlumnos = miSAAlumno.listarAlumnos();
			contx = new Contexto(EventoGUI.LISTAR_ALUMNOS, misAlumnos);
			
		}catch (ExcepcionNegocio e) {
			contx = new Contexto(EventoGUI.LISTAR_ALUMNOS_ERROR, null);
		}

		return contx;
	}
}