/**
 * 
 */
package SMSJPA.Presentacion.Comandos.Profesor;

import SMSJPA.Negocio.ExcepcionNegocio.ExcepcionNegocio;
import SMSJPA.Negocio.FactoriaSA.FactoriaSA;
import SMSJPA.Negocio.Materia.TMateria;
import SMSJPA.Negocio.Profesor.SAProfesor;
import SMSJPA.Negocio.Profesor.TProfesor;
import SMSJPA.Negocio.Turno.SATurno;
import SMSJPA.Negocio.Turno.TTurno;
import SMSJPA.Presentacion.Comandos.Comando;
import SMSJPA.Presentacion.Controlador.Contexto;
import SMSJPA.Presentacion.Controlador.EventoGUI;

public class ComandoEliminarProfesor implements Comando {

	public Contexto execute(Object datos) {
		
		int ID_Profesor;
		Contexto contex = null;
		
		SAProfesor SaProfesor = FactoriaSA.getInstance().crearSAProfesor();
		
		try{
			
			ID_Profesor = SaProfesor.eliminarProfesor((TProfesor)datos);
			
			if(ID_Profesor == -1){
				contex = new Contexto(EventoGUI.PROFESOR_INEXISTENTE, null);
			}
			else {
				contex = new Contexto(EventoGUI.PROFESOR_BORRADO, ID_Profesor);
			}
		}
		catch(ExcepcionNegocio e) {
			contex = new Contexto(EventoGUI.PROFESOR_BORRAR_ERROR, null);
		}
		
		return contex;

	}
}