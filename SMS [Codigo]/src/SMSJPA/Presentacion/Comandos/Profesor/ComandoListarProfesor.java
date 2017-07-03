/**
 * 
 */
package SMSJPA.Presentacion.Comandos.Profesor;

import java.util.ArrayList;

import SMSJPA.Negocio.ExcepcionNegocio.ExcepcionNegocio;
import SMSJPA.Negocio.FactoriaSA.FactoriaSA;
import SMSJPA.Negocio.Materia.SAMateria;
import SMSJPA.Negocio.Materia.TMateria;
import SMSJPA.Negocio.Profesor.SAProfesor;
import SMSJPA.Negocio.Profesor.TProfesor;
import SMSJPA.Presentacion.Comandos.Comando;
import SMSJPA.Presentacion.Controlador.Contexto;
import SMSJPA.Presentacion.Controlador.EventoGUI;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class ComandoListarProfesor implements Comando {
	/** 
	 * (sin Javadoc)
	 * @see Comando#execute(Object datos)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public Contexto execute(Object datos) {
		Contexto contx = null;
		ArrayList<TProfesor> misProfesores = null;
		SAProfesor miSAProfesor = FactoriaSA.getInstance().crearSAProfesor();
		
		try {
			
			misProfesores = miSAProfesor.listarProfesores();
			if (misProfesores.size() == 0){
				contx = new Contexto(EventoGUI.LISTAR_PROFESORES_ERRORAUX, misProfesores);
			}
			else contx = new Contexto(EventoGUI.LISTAR_PROFESORES, misProfesores);
			
		}catch (ExcepcionNegocio e) {
			contx = new Contexto(EventoGUI.LISTAR_PROFESORES_ERROR, null);
		}

		return contx;
	}
}