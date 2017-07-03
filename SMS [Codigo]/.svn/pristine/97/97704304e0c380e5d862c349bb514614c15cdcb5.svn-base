/**
 * 
 */
package SMSDAO.Presentacion.Comandos.Alumno;

import SMSDAO.Negocio.Alumnos.SAAlumno;
import SMSDAO.Negocio.Alumnos.TAlumno;
import SMSDAO.Negocio.ExcepcionNegocio.ExcepcionNegocio;
import SMSDAO.Negocio.FactoriaSA.FactoriaSA;
import SMSDAO.Presentacion.Comandos.Comando;
import SMSDAO.Presentacion.Controlador.Contexto;
import SMSDAO.Presentacion.JPrincipal.EventoGUI;

public class ComandoEliminarAlumno implements Comando {

	public Contexto execute(Object datos) {
		// begin-user-code
		//TCurso miCurso = 
		int ID_Alumno;
		Contexto contx = null;
		
		SAAlumno miSAAlumno = FactoriaSA.getInstance().creaSAAlumno();
		
		try {
			ID_Alumno = miSAAlumno.borrarAlumno((TAlumno)datos);
			if(ID_Alumno == -1){
				contx = new Contexto(EventoGUI.ALUMNO_INEXISTENTE_O_CON_MATRICULA_VIGENTE, ID_Alumno);
			}else{
				contx = new Contexto(EventoGUI.ALUMNO_BORRADO, ID_Alumno);
			}
			
		} catch (ExcepcionNegocio e) {
			contx = new Contexto(EventoGUI.ALUMNO_BORRAR_ERROR, null);
		}
		
		return contx;
		// end-user-code
	}
}