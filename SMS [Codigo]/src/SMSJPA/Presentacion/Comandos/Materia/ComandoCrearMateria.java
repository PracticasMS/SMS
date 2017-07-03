/**
 * 
 */
package SMSJPA.Presentacion.Comandos.Materia;

import SMSJPA.Negocio.ExcepcionNegocio.ExcepcionNegocio;
import SMSJPA.Negocio.FactoriaSA.FactoriaSA;
import SMSJPA.Negocio.Materia.SAMateria;
import SMSJPA.Negocio.Materia.TMateria;
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
public class ComandoCrearMateria implements Comando {
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
			
			ID_Materia = SaMateria.crearMateria((TMateria)datos);
			
			if(ID_Materia == -1){
				contex = new Contexto(EventoGUI.MATERIA_CREAR_ERROR, null);
			}else{
				contex = new Contexto(EventoGUI.MATERIA_CREADO, ID_Materia);
			}
		}
		catch(ExcepcionNegocio e) {
			contex = new Contexto(EventoGUI.MATERIA_CREAR_ERROR, null);
		}
		
		return contex;
		// end-user-code
	}
}