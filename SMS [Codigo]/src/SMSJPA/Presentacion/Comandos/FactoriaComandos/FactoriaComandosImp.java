/**
 * 
 */
package SMSJPA.Presentacion.Comandos.FactoriaComandos;
import SMSJPA.Presentacion.Comandos.Comando;
import SMSJPA.Presentacion.Comandos.Materia.ComandoBuscarMateria;
import SMSJPA.Presentacion.Comandos.Materia.ComandoCrearMateria;
import SMSJPA.Presentacion.Comandos.Materia.ComandoEliminarMateria;
import SMSJPA.Presentacion.Comandos.Materia.ComandoListarMaterias;
import SMSJPA.Presentacion.Comandos.Materia.ComandoModificarMateria;
import SMSJPA.Presentacion.Comandos.Profesor.ComandoBuscarMateriaParaProfesor;
import SMSJPA.Presentacion.Comandos.Profesor.ComandoBuscarProfesor;
import SMSJPA.Presentacion.Comandos.Profesor.ComandoCrearProfesor;
import SMSJPA.Presentacion.Comandos.Profesor.ComandoEliminarProfesor;
import SMSJPA.Presentacion.Comandos.Profesor.ComandoListarProfesor;
import SMSJPA.Presentacion.Comandos.Profesor.ComandoModificarProfesor;
import SMSJPA.Presentacion.Comandos.Turno.ComandoCalcularNominaTurno;
import SMSJPA.Presentacion.Comandos.Turno.ComandoCrearTurnos;
import SMSJPA.Presentacion.Comandos.Turno.ComandoEliminarTurnos;
import SMSJPA.Presentacion.Comandos.Turno.ComandoListarTurnos;
import SMSJPA.Presentacion.Comandos.Turno.ComandoModificarTurno;
import SMSJPA.Presentacion.Comandos.Turno.ComandoMostrarTurno;
import SMSJPA.Presentacion.Comandos.Ventanas.ComandoRedireccionVentanas;
import SMSJPA.Presentacion.Controlador.EventoGUI;


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class FactoriaComandosImp extends FactoriaComandos {

	@Override
	public Comando crearComando(int evento) {

		Comando miComando = null;
		
		switch (evento) {
		
		//***************************************************//
		//************ Comandos ABRIR_JPRINCIPAL ************//
		//***************************************************//
			case EventoGUI.ABRIR_JPRINCIPAL:
			case EventoGUI.ABRIR_VENTANA_CREAR_TURNO:
			case EventoGUI.ABRIR_VENTANA_ELIMINAR_TURNO:
			case EventoGUI.ABRIR_VENTANA_MODIFICAR_TURNO:
			case EventoGUI.ABRIR_VENTANA_LISTAR_TURNOS:
			case EventoGUI.ABRIR_VENTANA_BUSCAR_TURNO:
			case EventoGUI.ABRIR_VENTANA_BUSCAR_TURNO_PARA_MODIFICAR:
			case EventoGUI.ABRIR_VENTANA_CALCULAR_NOMINA_TURNO:
			
			case EventoGUI.ABRIR_VENTANA_CREAR_MATERIA:
			case EventoGUI.ABRIR_VENTANA_ELIMINAR_MATERIA:
			case EventoGUI.ABRIR_VENTANA_MODIFICAR_MATERIA:
			case EventoGUI.ABRIR_VENTANA_LISTAR_MATERIAS:
			case EventoGUI.ABRIR_VENTANA_BUSCAR_MATERIA:			
			case EventoGUI.ABRIR_VENTANA_BUSCAR_MATERIA_PARA_MODIFICAR:
			case EventoGUI.CERRAR_VENTANA_LISTAR_TURNOS:
			
			case EventoGUI.ABRIR_VENTANA_CREAR_PROFESOR:
			case EventoGUI.ABRIR_VENTANA_ELIMINAR_PROFESOR:
			case EventoGUI.ABRIR_VENTANA_MODIFICAR_PROFESOR:
			case EventoGUI.ABRIR_VENTANA_LISTAR_PROFESORES:
			case EventoGUI.ABRIR_VENTANA_BUSCAR_PROFESOR:			
			case EventoGUI.ABRIR_VENTANA_BUSCAR_PROFESOR_PARA_MODIFICAR:
			case EventoGUI.VENTANA_LISTAR_TURNOS_PARA_PROFESOR_CERRADA:	
				miComando = new ComandoRedireccionVentanas();
			break;
		
		//***************************************************//
		//***************** Comandos TURNO ******************//
		//***************************************************//
			
			case EventoGUI.CREAR_TURNO:
				miComando = new ComandoCrearTurnos();
			break;
			case EventoGUI.CALCULAR_NOMINA_TURNO:
				miComando = new ComandoCalcularNominaTurno();
			break;
			case EventoGUI.BORRAR_TURNO:
				miComando = new ComandoEliminarTurnos();
				break;
			case EventoGUI.BUSCAR_TURNO:
			case EventoGUI.BUSCAR_TURNO_PARA_MODIFICAR:
				miComando = new ComandoMostrarTurno();
			break;
			
			case EventoGUI.LISTAR_TURNOS:
			case EventoGUI.LISTAR_TURNOS_PARA_PROFESOR:
				miComando = new ComandoListarTurnos();
			break;
			
			case EventoGUI.MODIFICAR_TURNO:
				miComando = new ComandoModificarTurno();
			break;
			
		//***************************************************//
		//***************** Comandos MATERIA ****************//
		//***************************************************//
			
			case EventoGUI.CREAR_MATERIA:
				miComando = new ComandoCrearMateria();
			break;
			case EventoGUI.BORRAR_MATERIA:
				miComando = new ComandoEliminarMateria();
				break;
			case EventoGUI.BUSCAR_MATERIA:
				miComando = new ComandoBuscarMateria();
			break;
			case EventoGUI.BUSCAR_MATERIA_PARA_MODIFICAR:
				miComando = new ComandoBuscarMateria();
			break;
			case EventoGUI.LISTAR_MATERIAS:
				miComando = new ComandoListarMaterias();
			break;
			
			case EventoGUI.MODIFICAR_MATERIA:
				miComando = new ComandoModificarMateria();
			break;	
		
		//***************************************************//
		//***************** Comandos PROFESOR ***************//
		//***************************************************//
			
			case EventoGUI.CREAR_PROFESOR:
				miComando = new ComandoCrearProfesor();
			break;
			case EventoGUI.BORRAR_PROFESOR:
				miComando = new ComandoEliminarProfesor();
				break;
			case EventoGUI.BUSCAR_PROFESOR:
				miComando = new ComandoBuscarProfesor();
			break;
			case EventoGUI.BUSCAR_PROFESOR_PARA_MODIFICAR:
				miComando = new ComandoBuscarProfesor();
			break;
			case EventoGUI.LISTAR_PROFESORES:
				miComando = new ComandoListarProfesor();
			break;
			
			case EventoGUI.MODIFICAR_PROFESOR:
				miComando = new ComandoModificarProfesor();
			break;
			
			case EventoGUI.LISTAR_MATERIAS_PARA_PROFESOR:
				miComando = new ComandoListarMaterias();
			break;		
			
			case EventoGUI.BUSCAR_MATERIA_PARA_AÑADIR_A_PROFESOR:
				miComando = new ComandoBuscarMateriaParaProfesor();
			break;	
		}
		
		return miComando;
	}
}