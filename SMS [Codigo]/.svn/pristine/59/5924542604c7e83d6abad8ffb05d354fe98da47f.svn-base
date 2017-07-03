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
public class ComandoEliminarMateria implements Comando {
	/** 
	 * (sin Javadoc)
	 * @see Comando#execute(Object datos)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public Contexto execute(Object datos) {
		int ID_Materia;
		Contexto contex = null;
		
		SAMateria SaMateria = FactoriaSA.getInstance().crearSAMateria();
		
		try{
			
			ID_Materia = SaMateria.eliminarMateria((TMateria)datos);
			
			if(ID_Materia == -1){
				contex = new Contexto(EventoGUI.MATERIA_INEXISTENTE, null);
			}
			else if(ID_Materia == -2){
				contex = new Contexto(EventoGUI.MATERIA_BORRAR_ERROR, null);
			}
			else{
				contex = new Contexto(EventoGUI.MATERIA_BORRADO, ID_Materia);
			}
		}
		catch(ExcepcionNegocio e) {
			contex = new Contexto(EventoGUI.TURNO_BORRAR_ERROR, null);
		}
		
		return contex;
	}
}