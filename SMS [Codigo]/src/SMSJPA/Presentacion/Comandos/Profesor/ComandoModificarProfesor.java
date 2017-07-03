/**
 * 
 */
package SMSJPA.Presentacion.Comandos.Profesor;

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
public class ComandoModificarProfesor implements Comando {
	/** 
	 * (sin Javadoc)
	 * @see Comando#execute(Object datos)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public Contexto execute(Object datos) {
		int ID_Profesor;
		Contexto contex = null;
		
		SAProfesor saProfesor = FactoriaSA.getInstance().crearSAProfesor();
		
		try{
			
			ID_Profesor = saProfesor.modificarProfesor((TProfesor)datos);
			
			if(ID_Profesor == -1){
				contex = new Contexto(EventoGUI.MODIFICAR_PROFESOR_ERROR, null);
			}else if(ID_Profesor == -2){
				contex = new Contexto(EventoGUI.TURNO_INEXISTENTE, null);
			}else if(ID_Profesor == -3){
				contex = new Contexto(EventoGUI.MATERIA_INEXISTENTE, null);
			}else{
				contex = new Contexto(EventoGUI.PROFESOR_MODIFICADO, ID_Profesor);
			}
		}
		catch(ExcepcionNegocio e) {
			contex = new Contexto(EventoGUI.MODIFICAR_PROFESOR_ERROR, null);
		}
		
		return contex;
	}
}