/**
 * @ProjectName SMSProg
 */
package SMSDAO.Presentacion.Comandos.Alumno;

import java.util.ArrayList;

import SMSDAO.Negocio.Alumnos.SAAlumno;
import SMSDAO.Negocio.Alumnos.TAlumno;
import SMSDAO.Negocio.ExcepcionNegocio.ExcepcionNegocio;
import SMSDAO.Negocio.FactoriaSA.FactoriaSA;
import SMSDAO.Presentacion.Comandos.Comando;
import SMSDAO.Presentacion.Controlador.Contexto;
import SMSDAO.Presentacion.JPrincipal.EventoGUI;

/**
 * @Project_Name SMSProg
 * @Author Rodrigo de Miguel González
 * @Date 06/12/2015
 * @File_Name ComandoListarAlumnosNMatriculasNAños.java
 */
public class ComandoListarAlumnosNMatriculasNAños implements Comando {

	/* (sin Javadoc)
	 * @see SMSDAO.Presentacion.Comandos.Comando#execute(java.lang.Object)
	 */
	@Override
	public Contexto execute(Object datos) {
		Contexto contx = null;
		ArrayList<TAlumno> misAlumnos;
		
		TAlumno misDatos = (TAlumno) datos;
		
		SAAlumno miSA = FactoriaSA.getInstance().creaSAAlumno();
		
		try {
			
			
			misAlumnos = miSA.listarAlumnosNMatriculasMAños(misDatos);
			
			if (misAlumnos.size()==0){
				contx = new Contexto(EventoGUI.LISTAR_ALUMNOS_ERRORAUX, misAlumnos);
				
			}
			else contx = new Contexto(EventoGUI.LISTAR_ALUMNOS_NMatriculas_MAnos, misAlumnos); 
		
			
		} catch (ExcepcionNegocio e) {
			contx = new Contexto(EventoGUI.LISTAR_ALUMNOS_ERROR, null);
		}
		
		
		return contx;
	}

}
