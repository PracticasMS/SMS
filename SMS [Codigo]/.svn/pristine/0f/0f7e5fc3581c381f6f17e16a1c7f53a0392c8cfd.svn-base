
/**
 * 
 */
package SMSJPA.Presentacion.Comandos.Materia;

import SMSJPA.Negocio.ExcepcionNegocio.ExcepcionNegocio;
import SMSJPA.Negocio.FactoriaSA.FactoriaSA;
import SMSJPA.Negocio.Materia.SAMateria;
import SMSJPA.Negocio.Materia.TMateria;
import SMSJPA.Negocio.Turno.SATurno;
import SMSJPA.Negocio.Turno.TTurno;
import SMSJPA.Presentacion.Comandos.Comando;
import SMSJPA.Presentacion.Controlador.Contexto;
import SMSJPA.Presentacion.Controlador.EventoGUI;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class ComandoBuscarMateria implements Comando {
	/** 
	 * (sin Javadoc)
	 * @see Comando#execute(Object datos)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public Contexto execute(Object datos) {
		TMateria miMateria;
		Contexto contex = null;
		
		SAMateria miSAMateria = FactoriaSA.getInstance().crearSAMateria();
		
		try{
			
			miMateria = miSAMateria.buscarMateria((TMateria)datos);
			
			if(miMateria == null){
				contex = new Contexto(EventoGUI.BUSCAR_MATERIA_ERROR, null);
			}else{
				contex = new Contexto(EventoGUI.MOSTRAR_MATERIA, miMateria);
			}
		}
		catch(ExcepcionNegocio e) {
			contex = new Contexto(EventoGUI.BUSCAR_MATERIA_ERROR, null);
		}
		
		return contex;
	
	}
}