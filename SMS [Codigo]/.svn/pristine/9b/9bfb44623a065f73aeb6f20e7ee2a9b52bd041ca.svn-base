/**
 * 
 */
package SMSDAO.Presentacion.FactoriaComandos;

import SMSDAO.Presentacion.Comandos.Comando;
import SMSDAO.Presentacion.Comandos.Alumno.ComandoCrearAlumno;
import SMSDAO.Presentacion.Comandos.Alumno.ComandoEliminarAlumno;
import SMSDAO.Presentacion.Comandos.Alumno.ComandoListarAlumnos;
import SMSDAO.Presentacion.Comandos.Alumno.ComandoListarAlumnosNMatriculasNAños;
import SMSDAO.Presentacion.Comandos.Alumno.ComandoModificarAlumno;
import SMSDAO.Presentacion.Comandos.Alumno.ComandoMostrarAlumno;
import SMSDAO.Presentacion.Comandos.Curso.ComandoBorrarCurso;
import SMSDAO.Presentacion.Comandos.Curso.ComandoCrearCurso;
import SMSDAO.Presentacion.Comandos.Curso.ComandoListarCurso;
import SMSDAO.Presentacion.Comandos.Curso.ComandoModificarCurso;
import SMSDAO.Presentacion.Comandos.Curso.ComandoMostrarCurso;
import SMSDAO.Presentacion.Comandos.Matricula.ComandoAñadirCursoAMatricula;
import SMSDAO.Presentacion.Comandos.Matricula.ComandoBuscarMatricula;
import SMSDAO.Presentacion.Comandos.Matricula.ComandoBuscarMatriculaParaModificar;
import SMSDAO.Presentacion.Comandos.Matricula.ComandoCrearMatricula;
import SMSDAO.Presentacion.Comandos.Matricula.ComandoEliminarMatricula;
import SMSDAO.Presentacion.Comandos.Matricula.ComandoListarMatriculas;
import SMSDAO.Presentacion.Comandos.Matricula.ComandoListarMatriculasNCursos;
import SMSDAO.Presentacion.Comandos.Matricula.ComandoModificarMatricula;
import SMSDAO.Presentacion.JPrincipal.EventoNegocio;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class FactoriaComandosImp extends FactoriaComandos {

	/** 
	 * (sin Javadoc)
	 * @see FactoriaComandos#crearComando(int eventoNegocio)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Comando crearComando(int eventoNegocio) {
		// begin-user-code
		
		Comando miComando = null;
		
		switch (eventoNegocio) {
		
		
		//***************************************************//
		//***************** Comandos CURSO ******************//
		//***************************************************//
			case EventoNegocio.BORRAR_CURSO:
				miComando = new ComandoBorrarCurso();
			break;
			
			case EventoNegocio.LISTAR_CURSOS:
				miComando = new ComandoListarCurso();
			break;
			case EventoNegocio.CREAR_CURSO:
				miComando = new ComandoCrearCurso();
			break;
			
			case EventoNegocio.BUSCA_CURSO_MODIFICAR:
				miComando = new ComandoMostrarCurso();
			break;
			case EventoNegocio.BUSCAR_CURSO:
				miComando = new ComandoMostrarCurso();
			break;
			case EventoNegocio.MODIFICAR_CURSO:
				miComando = new ComandoModificarCurso();
			break;

			
			//****************************************************//
			//***************** Comandos ALUMNO ******************//
			//****************************************************//
			case EventoNegocio.BORRAR_ALUMNO:
				miComando = new ComandoEliminarAlumno();
			break;
			case EventoNegocio.LISTAR_ALUMNO:
				miComando = new ComandoListarAlumnos();
			break;
			case EventoNegocio.CREAR_ALUMNO:
				miComando = new ComandoCrearAlumno();
			break;
			case EventoNegocio.BUSCA_ALUMNO_MODIFICAR:
				miComando = new ComandoMostrarAlumno();
			break;
			case EventoNegocio.BUSCAR_ALUMNO:
				miComando = new ComandoMostrarAlumno();
			break;
			case EventoNegocio.MODIFICAR_ALUMNO:
				miComando = new ComandoModificarAlumno();
			break;
			case EventoNegocio.LISTAR_ALUMNOS_NMATRICULAS_MAÑOS:
				miComando = new ComandoListarAlumnosNMatriculasNAños();
			break;
		
			
			
			//****************************************************//
			//*************** Comandos MATRICULA ****************//
			//***************************************************//
			case EventoNegocio.BORRAR_MATRICULA:
				miComando = new ComandoEliminarMatricula();
			break;
			case EventoNegocio.LISTAR_MATRICULAS:
				miComando = new ComandoListarMatriculas();
			break;
			case EventoNegocio.CREAR_MATRICULA:
				miComando = new ComandoCrearMatricula();
			break;
			case EventoNegocio.BUSCA_MATRICULA_MODIFICAR:
				miComando = new ComandoBuscarMatriculaParaModificar();
			break;
			case EventoNegocio.BUSCAR_MATRICULA:
				miComando = new ComandoBuscarMatricula();
			break;
			case EventoNegocio.BUSCAR_CURSO_PARA_AÑADIR_A_MATRICULA:
				miComando = new ComandoAñadirCursoAMatricula();
			break;
			case EventoNegocio.MODIFICAR_MATRICULA:
				miComando = new ComandoModificarMatricula();
			break;
			case EventoNegocio.LISTAR_CURSOS_ParaMatricula:
				miComando = new ComandoListarCurso();
			break;
			case EventoNegocio.LISTAR_MATRICULAS_NCURSOS:
				miComando = new ComandoListarMatriculasNCursos();
			break;
 
		}

		
		return miComando;
		// end-user-code
	}
}