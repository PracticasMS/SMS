/**
 * 
 */
package SMSDAO.Presentacion.Dispacher;

import SMSDAO.Presentacion.Alumnos.VentanaBuscarAlumno;
import SMSDAO.Presentacion.Alumnos.VentanaCrearAlumno;
import SMSDAO.Presentacion.Alumnos.VentanaEliminarAlumno;
import SMSDAO.Presentacion.Alumnos.VentanaListarAlumnos;
import SMSDAO.Presentacion.Alumnos.VentanaListarAlumnosConNMatricEnMAños;
import SMSDAO.Presentacion.Alumnos.VentanaModificarAlumno;
import SMSDAO.Presentacion.Alumnos.VentanaMostrarAlumno;
import SMSDAO.Presentacion.Controlador.Contexto;
import SMSDAO.Presentacion.Curso.VentanaBorrarCurso;
import SMSDAO.Presentacion.Curso.VentanaBuscarCurso;
import SMSDAO.Presentacion.Curso.VentanaCrearCurso;
import SMSDAO.Presentacion.Curso.VentanaListarCursos;
import SMSDAO.Presentacion.Curso.VentanaModificarCurso;
import SMSDAO.Presentacion.Curso.VentanaMostrarCurso;
import SMSDAO.Presentacion.JPrincipal.EventoGUI;
import SMSDAO.Presentacion.JPrincipal.EventoNegocio;
import SMSDAO.Presentacion.JPrincipal.JPrincipalSMS;
import SMSDAO.Presentacion.Matricula.VentanaBuscarCursoMatricula;
import SMSDAO.Presentacion.Matricula.VentanaBuscarMatricula;
import SMSDAO.Presentacion.Matricula.VentanaCrearMatricula;
import SMSDAO.Presentacion.Matricula.VentanaEliminarMatricula;
import SMSDAO.Presentacion.Matricula.VentanaListarMatriculas;
import SMSDAO.Presentacion.Matricula.VentanaListarMatriculasNCursos;
import SMSDAO.Presentacion.Matricula.VentanaModificarMatricula;
import SMSDAO.Presentacion.Matricula.VentanaMostrarMatricula;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DispacherImp extends Dispacher {


	/* (sin Javadoc)
	 * @see SMSDAO.Presentacion.Dispacher.Dispacher#dispach(int, SMSDAO.Presentacion.Controlador.Contexto)
	 */
	@Override
	public void dispach(int eventoNegocio, Contexto parDatosEvento) {

		if(eventoNegocio >=100 && eventoNegocio <= 199){
			dispachEventosDeCurso(eventoNegocio, parDatosEvento);
		}else if(eventoNegocio >=200 && eventoNegocio <= 299){
			dispachEventosDeAlumno(eventoNegocio, parDatosEvento);
		}else if (eventoNegocio >=300 && eventoNegocio <= 399){
			dispachEventosDeMatricula(eventoNegocio, parDatosEvento);
		}

	}

	/**
	 * @param eventoNegocio
	 * @param parDatosEvento
	 */
	private void dispachEventosDeCurso(int eventoNegocio, Contexto parDatosEvento) {

		switch (eventoNegocio) {
		//***************** Dispacher CURSO ******************//

		case EventoNegocio.BORRAR_CURSO:
			VentanaBorrarCurso.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());

			break;

		case EventoNegocio.LISTAR_CURSOS:
			JPrincipalSMS.getInstance().setVisible(false);
			//if(parDatosEvento.getEvento() == EventoGUI.l)
			VentanaListarCursos.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			VentanaBuscarCursoMatricula.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			VentanaListarCursos.getInstance().setVisible(true);
			break;

		case EventoNegocio.CREAR_CURSO:
			//JPrincipalSMS.getInstance().setVisible(false);
			VentanaCrearCurso.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());

			break;
		case EventoNegocio.BUSCA_CURSO_MODIFICAR:
			//Comprobamos si se ha podido realizar con éxito o no.
			if(parDatosEvento.getEvento() == EventoGUI.MOSTRAR_CURSO){
				VentanaBuscarCurso.getInstance().setVisible(false);
				VentanaModificarCurso.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
				VentanaModificarCurso.getInstance().setVisible(true);
			}else if(parDatosEvento.getEvento() == EventoGUI.BUSCAR_CURSO_ERROR){
				VentanaBuscarCurso.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			}
			break;

		case EventoNegocio.BUSCAR_CURSO:

			if(parDatosEvento.getEvento() == EventoGUI.MOSTRAR_CURSO){
				VentanaBuscarCurso.getInstance().setVisible(false);
				VentanaMostrarCurso.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
				VentanaMostrarCurso.getInstance().setVisible(true);
			}else if(parDatosEvento.getEvento() == EventoGUI.BUSCAR_CURSO_ERROR){
				VentanaBuscarCurso.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			}else if(parDatosEvento.getEvento() == EventoGUI.BUSCAR_CURSO_PARA_AÑADIR_A_MATRICULA){
				VentanaBuscarCurso.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
				VentanaCrearMatricula.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
				VentanaModificarMatricula.getInstance().Update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			}

			break;

		case EventoNegocio.MODIFICAR_CURSO:
			
			VentanaModificarCurso.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			VentanaBuscarCurso.getInstance().setVisible(false);
			VentanaModificarCurso.getInstance().setVisible(true);
		
			break;

		}

	}

	private void dispachEventosDeAlumno(int eventoNegocio, Contexto parDatosEvento) {

		switch (eventoNegocio) {

		//***************** Dispacher ALUMNO ******************//

		case EventoNegocio.BORRAR_ALUMNO:
			VentanaEliminarAlumno.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());

			break;

		case EventoNegocio.CREAR_ALUMNO:
			VentanaCrearAlumno.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());

			break;

		case EventoNegocio.BUSCAR_ALUMNO:

			if(parDatosEvento.getEvento() == EventoGUI.MOSTRAR_ALUMNO){
				VentanaBuscarAlumno.getInstance().setVisible(false);
				VentanaMostrarAlumno.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
				VentanaMostrarAlumno.getInstance().setVisible(true);
			}else if(parDatosEvento.getEvento() == EventoGUI.BUSCAR_ALUMNO_ERROR){
				VentanaBuscarAlumno.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			}

			break;

		case EventoNegocio.BUSCA_ALUMNO_MODIFICAR:
			//Comprobamos si se ha podido realizar con éxito o no.
			if(parDatosEvento.getEvento() == EventoGUI.MOSTRAR_ALUMNO){
				VentanaBuscarAlumno.getInstance().setVisible(false);
				VentanaModificarAlumno.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
				VentanaModificarAlumno.getInstance().setVisible(true);
			}else if(parDatosEvento.getEvento() == EventoGUI.BUSCAR_ALUMNO_ERROR){
				VentanaBuscarAlumno.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			}
			break;

		case EventoNegocio.MODIFICAR_ALUMNO:

			VentanaModificarAlumno.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			VentanaBuscarAlumno.getInstance().setVisible(false);
			VentanaModificarAlumno.getInstance().setVisible(true);


			break;
		case EventoNegocio.LISTAR_ALUMNO:

			VentanaListarAlumnos.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			//VentanaListarAlumnos.getInstance().setVisible(true);
			//VentanaListarAlumnos.getInstance().setVisible(true);
			//VentanaListarAlumnos.getInstance().setVisible(true);
			//VentanaListarAlumnos.getInstance().setVisible(true);
			break;

		case EventoNegocio.LISTAR_ALUMNOS_NMATRICULAS_MAÑOS:
			VentanaListarAlumnosConNMatricEnMAños.getInstance().setVisible(false);
			VentanaListarAlumnosConNMatricEnMAños.getInstance().estadoVentanaInicial();
			VentanaListarAlumnos.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			break;

		default:
			break;
		}


	}

	private void dispachEventosDeMatricula(int eventoNegocio, Contexto parDatosEvento) {


		switch (eventoNegocio) {
		//***************** Dispacher Matricula ******************//

		case EventoNegocio.BORRAR_MATRICULA:
			JPrincipalSMS.getInstance().setVisible(false);
			VentanaEliminarMatricula.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());

			break;

		case EventoNegocio.CREAR_MATRICULA:
			VentanaCrearMatricula.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());

			break;

		case EventoNegocio.BUSCAR_MATRICULA:

			if(parDatosEvento.getEvento() == EventoGUI.MOSTRAR_MATRICULA){
				VentanaBuscarMatricula.getInstance().setVisible(false);
				VentanaMostrarMatricula.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
				VentanaMostrarMatricula.getInstance().setVisible(true);
			}else if(parDatosEvento.getEvento() == EventoGUI.BUSCAR_MATRICULA_ERROR){
				VentanaBuscarMatricula.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			}

			break;

		case EventoNegocio.BUSCA_MATRICULA_MODIFICAR:
			//Comprobamos si se ha podido realizar con éxito o no.
			if(parDatosEvento.getEvento() == EventoGUI.BUSCA_MATRICULA_PARA_MODIFICAR){
				VentanaBuscarMatricula.getInstance().setVisible(false);
				VentanaModificarMatricula.getInstance().Update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
				VentanaModificarMatricula.getInstance().setVisible(true);
			}else if(parDatosEvento.getEvento() == EventoGUI.BUSCAR_MATRICULA_ERROR){
				VentanaBuscarMatricula.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			}
			break;

		case EventoNegocio.MODIFICAR_MATRICULA:

			VentanaModificarMatricula.getInstance().Update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			VentanaModificarMatricula.getInstance().setVisible(true);


			break;
		
		case EventoNegocio.BUSCAR_CURSO_PARA_AÑADIR_A_MATRICULA:

			VentanaCrearMatricula.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			VentanaModificarMatricula.getInstance().Update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			VentanaBuscarCursoMatricula.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			VentanaBuscarCursoMatricula.getInstance().setVisible(true);

			break;	
			
		case EventoNegocio.LISTAR_MATRICULAS:

			VentanaListarMatriculas.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			VentanaListarMatriculas.getInstance().setVisible(true);

			break;
		
		
		case EventoNegocio.LISTAR_CURSOS_ParaMatricula:
			VentanaBuscarCursoMatricula.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());

			break;
		
		case EventoNegocio.LISTAR_MATRICULAS_NCURSOS:
			VentanaListarMatriculasNCursos.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());

			break;
		}
		

	}

}

