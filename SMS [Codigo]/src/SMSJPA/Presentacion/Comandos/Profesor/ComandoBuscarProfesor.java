/**
 * 
 */
package SMSJPA.Presentacion.Comandos.Profesor;

import SMSJPA.Negocio.ExcepcionNegocio.ExcepcionNegocio;
import SMSJPA.Negocio.FactoriaSA.FactoriaSA;
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
public class ComandoBuscarProfesor implements Comando {
	/** 
	 * (sin Javadoc)
	 * @see Comando#execute(Object datos)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public Contexto execute(Object datos) {
		TProfesor miProfesor;
		Contexto contex = null;
		
		SAProfesor miSAProfesor = FactoriaSA.getInstance().crearSAProfesor();
		
		try{
			
			miProfesor = miSAProfesor.buscarProfesor((TProfesor)datos);
			
			if(miProfesor == null){
				contex = new Contexto(EventoGUI.BUSCAR_PROFESOR_ERROR, null);
			}else{
				contex = new Contexto(EventoGUI.MOSTRAR_PROFESOR, miProfesor);
			}
		}
		catch(ExcepcionNegocio e) {
			contex = new Contexto(EventoGUI.BUSCAR_PROFESOR_ERROR, null);
		}
		
		return contex;
	}
}