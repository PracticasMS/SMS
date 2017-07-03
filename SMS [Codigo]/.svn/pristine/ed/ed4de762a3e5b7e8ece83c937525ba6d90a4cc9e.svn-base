/**
 * 
 */
package SMSJPA.Presentacion.Comandos.Turno;

import SMSJPA.Negocio.ExcepcionNegocio.ExcepcionNegocio;
import SMSJPA.Negocio.FactoriaSA.FactoriaSA;
import SMSJPA.Negocio.Profesor.TProfesor;
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
public class ComandoCalcularNominaTurno implements Comando {

	public Contexto execute(Object datos) {

		int salario;
		Contexto contex = null;
		
		SATurno SaTurno = FactoriaSA.getInstance().crearSATurno();
		
		try{
			
			salario = SaTurno.Calcular_Nomina_Turno((TTurno)datos);
			
			
			if(salario == -1){
				contex = new Contexto(EventoGUI.CALCULAR_NOMINA_TURNO_INEXISTENTE, null);
			}else{
				contex = new Contexto(EventoGUI.CALCULAR_NOMINA_TURNO, salario);
			}
		}
		catch(ExcepcionNegocio e) {
			contex = new Contexto(EventoGUI.CALCULAR_NOMINA_TURNO_ERROR, null);
		}
		
		return contex;
	}
}