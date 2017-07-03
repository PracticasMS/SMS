/**
 * 
 */
package SMSJPA.Presentacion.Comandos.Turno;

import SMSJPA.Negocio.ExcepcionNegocio.ExcepcionNegocio;
import SMSJPA.Negocio.FactoriaSA.FactoriaSA;
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
public class ComandoMostrarTurno implements Comando {
	/** 
	 * (sin Javadoc)
	 * @return 
	 * @see Comando#execute()
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public Contexto execute(Object datos) {
		
		TTurno Turno;
		Contexto contex = null;
		
		SATurno SaTurno = FactoriaSA.getInstance().crearSATurno();
		
		try{
			
			Turno = SaTurno.buscarTurno((TTurno)datos);
			
			if(Turno == null){
				contex = new Contexto(EventoGUI.BUSCAR_TURNO_ERROR, null);
			}else{
				contex = new Contexto(EventoGUI.BUSCAR_TURNO, Turno);
			}
		}
		catch(ExcepcionNegocio e) {
			contex = new Contexto(EventoGUI.BUSCAR_TURNO_ERROR, null);
		}
		
		return contex;
	}
}