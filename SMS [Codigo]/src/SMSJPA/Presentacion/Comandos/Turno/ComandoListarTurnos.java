/**
 * 
 */
package SMSJPA.Presentacion.Comandos.Turno;

import java.util.ArrayList;

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
public class ComandoListarTurnos implements Comando {
	/** 
	 * (sin Javadoc)
	 * @return 
	 * @see Comando#execute()
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public Contexto execute(Object datos) {
		
		Contexto contx = null;
		ArrayList<TTurno> misTurnos = null;
		SATurno miSATurno = FactoriaSA.getInstance().crearSATurno();
		
		try {
			
			misTurnos = miSATurno.listarTurnos();
			if (misTurnos.size() == 0){
				contx = new Contexto(EventoGUI.LISTAR_TURNOS_ERRORAUX, misTurnos);
				
			}
			else contx = new Contexto(EventoGUI.LISTAR_TURNOS, misTurnos);
			
		}catch (ExcepcionNegocio e) {
			contx = new Contexto(EventoGUI.LISTAR_TURNOS_ERROR, null);
		}

		return contx;
	}
}