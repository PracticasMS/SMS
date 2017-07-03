/**
 * 
 */
package SMSJPA.Presentacion.Dispacher;

import java.awt.Toolkit;

import javax.swing.JFrame;

import SMSDAO.Presentacion.Controlador.Controlador;
import SMSDAO.Presentacion.JPrincipal.EventoNegocio;
import SMSDAO.Presentacion.Matricula.VentanaBuscarCursoMatricula;
import SMSJPA.Presentacion.Controlador.Contexto;
import SMSJPA.Presentacion.Controlador.EventoGUI;
import SMSJPA.Presentacion.JPrincipal.JPrincipalSMS;
import SMSJPA.Presentacion.Materia.VentanaBuscarMateria;
import SMSJPA.Presentacion.Materia.VentanaMostrarMateria;
import SMSJPA.Presentacion.Materia.VentanaCrearMateria;
import SMSJPA.Presentacion.Materia.VentanaEliminarMateria;
import SMSJPA.Presentacion.Materia.VentanaListarMaterias;
import SMSJPA.Presentacion.Materia.VentanaModificarMateria;
import SMSJPA.Presentacion.Materia.VentanaMostrarMateria;
import SMSJPA.Presentacion.Profesor.VentanaBuscarMateriaProfesor;
import SMSJPA.Presentacion.Profesor.VentanaBuscarProfesor;
import SMSJPA.Presentacion.Profesor.VentanaCrearProfesor;
import SMSJPA.Presentacion.Profesor.VentanaEliminarProfesor;
import SMSJPA.Presentacion.Profesor.VentanaListarProfesor;
import SMSJPA.Presentacion.Profesor.VentanaModificarProfesor;
import SMSJPA.Presentacion.Profesor.VentanaMostrarProfesor;
import SMSJPA.Presentacion.Turno.VentanaBuscarTurno;
import SMSJPA.Presentacion.Turno.VentanaCalcularNominaTurno;
import SMSJPA.Presentacion.Turno.VentanaCrearTurno;
import SMSJPA.Presentacion.Turno.VentanaEliminarTurno;
import SMSJPA.Presentacion.Turno.VentanaListarTurnos;
import SMSJPA.Presentacion.Turno.VentanaModificarTurno;
import SMSJPA.Presentacion.Turno.VentanaMostrarTurno;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class DispacherImp extends Dispacher {
	/** 
	 * (sin Javadoc)
	 * @see Dispacher#dispach()
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public void dispach(int evento, Contexto parDatosEvento) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		
		//******  VENTANAS ******
		if(evento >=00 && evento <= 99){
			dispachEventoDeVentanas(evento);
		}
		
		//******  TURNO ******
		if(evento >=100 && evento <= 199){
			dispachEventosDeTurno(evento, parDatosEvento);
		}
		
		//******  MATERIA ******
		if(evento >=200 && evento <= 299){
			dispachEventosDeMateria(evento, parDatosEvento);
		}
		
		//******  PROFESOR ******
		if(evento >=300 && evento <= 399){
			dispachEventosDeProfesor(evento, parDatosEvento);
		}
		// end-user-code
	}
	
	/**
	 * @param evento
	 */
	private void dispachEventoDeVentanas(int evento) {
		switch (evento) {
		//***************** Dispacher Ventanas ******************//
		
			case EventoGUI.ABRIR_JPRINCIPAL:
				JPrincipalSMS.getInstance().setVisible(true);
				break;
				
			//***************** Turno ******************//
				
			case EventoGUI.ABRIR_VENTANA_BUSCAR_TURNO:
				VentanaBuscarTurno.getInstance().setEventoGUI(EventoGUI.BUSCAR_TURNO);
				VentanaBuscarTurno.getInstance().setVisible(true);
				break;
				
			case EventoGUI.ABRIR_VENTANA_BUSCAR_TURNO_PARA_MODIFICAR:
				VentanaBuscarTurno.getInstance().setEventoGUI(EventoGUI.BUSCAR_TURNO_PARA_MODIFICAR);
				VentanaBuscarTurno.getInstance().setVisible(true);
				break;
				
		
		case EventoGUI.ABRIR_VENTANA_CREAR_TURNO:
			VentanaCrearTurno.getInstance().setVisible(true);
		break;
		
		case EventoGUI.ABRIR_VENTANA_CALCULAR_NOMINA_TURNO:
			VentanaCalcularNominaTurno.getInstance().setVisible(true);
		break;
		
		case EventoGUI.ABRIR_VENTANA_MODIFICAR_TURNO:
			VentanaModificarTurno.getInstance().setVisible(true);
		break;
		
		case EventoGUI.ABRIR_VENTANA_LISTAR_TURNOS:
			VentanaListarTurnos.getInstance().setVisible(true);
		break;
		
		case EventoGUI.ABRIR_VENTANA_ELIMINAR_TURNO:
			VentanaEliminarTurno.getInstance().setVisible(true);
		break;
		
		case EventoGUI.CERRAR_VENTANA_LISTAR_TURNOS:
			VentanaListarTurnos.getInstance().setVisible(false);
		break;
		
		
		//Ventanas de materia
		
		case EventoGUI.ABRIR_VENTANA_BUSCAR_MATERIA_PARA_MODIFICAR:
			VentanaBuscarMateria.getInstance().setEventoGUI(EventoGUI.BUSCAR_MATERIA_PARA_MODIFICAR);
			VentanaBuscarMateria.getInstance().setVisible(true);
		break;
		
		case EventoGUI.ABRIR_VENTANA_BUSCAR_MATERIA:
			VentanaBuscarMateria.getInstance().setEventoGUI(EventoGUI.BUSCAR_MATERIA);
			VentanaBuscarMateria.getInstance().setVisible(true);
		break;
		
		case EventoGUI.ABRIR_VENTANA_CREAR_MATERIA:
			VentanaCrearMateria.getInstance().setVisible(true);
		break;
		
		case EventoGUI.ABRIR_VENTANA_MODIFICAR_MATERIA:
			VentanaModificarMateria.getInstance().setVisible(true);
		break;
		
		case EventoGUI.ABRIR_VENTANA_LISTAR_MATERIAS:
			VentanaListarMaterias.getInstance().setVisible(true);
		break;
		
		case EventoGUI.ABRIR_VENTANA_ELIMINAR_MATERIA:
			VentanaEliminarMateria.getInstance().setVisible(true);
		break;
				
		
		//***************** Profesor ******************//
		
		case EventoGUI.ABRIR_VENTANA_BUSCAR_PROFESOR:
			VentanaBuscarProfesor.getInstance().setEventoGUI(EventoGUI.BUSCAR_PROFESOR);
			VentanaBuscarProfesor.getInstance().setVisible(true);
			break;
		
		case EventoGUI.ABRIR_VENTANA_BUSCAR_PROFESOR_PARA_MODIFICAR:
			VentanaBuscarProfesor.getInstance().setEventoGUI(EventoGUI.BUSCAR_PROFESOR_PARA_MODIFICAR);
			VentanaBuscarProfesor.getInstance().setVisible(true);
			break;
		
		case EventoGUI.ABRIR_VENTANA_CREAR_PROFESOR:
			VentanaCrearProfesor.getInstance().setVisible(true);
		break;
		
		case EventoGUI.ABRIR_VENTANA_MODIFICAR_PROFESOR:
			VentanaModificarProfesor.getInstance().setVisible(true);
		break;
		
		case EventoGUI.ABRIR_VENTANA_LISTAR_PROFESORES:
			VentanaListarProfesor.getInstance().setVisible(true);
		break;
		
		case EventoGUI.ABRIR_VENTANA_ELIMINAR_PROFESOR:
			VentanaEliminarProfesor.getInstance().setVisible(true);
		break;
		}
	}

	private void dispachEventosDeTurno(int evento, Contexto parDatosEvento) {
		
		switch (evento) {

		//***************** Dispacher TURNO ******************//

		case EventoGUI.CREAR_TURNO:
			VentanaCrearTurno.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			break;
			
		case EventoGUI.CALCULAR_NOMINA_TURNO:
			VentanaCalcularNominaTurno.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			break;
			
		case EventoGUI.BORRAR_TURNO:
			VentanaEliminarTurno.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			break;
			
		
		case EventoGUI.LISTAR_TURNOS:
			VentanaListarTurnos.getInstance().setTurnoParaProfe(false);
			
			VentanaListarTurnos.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());

			
			break;
			
		case EventoGUI.LISTAR_TURNOS_PARA_PROFESOR:
			
			VentanaListarTurnos.getInstance().setTurnoParaProfe(true);
			VentanaListarTurnos.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			
			
			java.awt.Dimension pantallaTamano = Toolkit.getDefaultToolkit().getScreenSize();
			int ancho = ((pantallaTamano.width / 2) - (VentanaListarTurnos.getInstance().getWidth()) / 2);
			int alto = (pantallaTamano.height / 2) - (VentanaListarTurnos.getInstance().getHeight() )-100;
			int alto2 = alto + VentanaListarTurnos.getInstance().getHeight() + 10 ;

			VentanaListarTurnos.getInstance().setLocation(pantallaTamano.width-1,alto); // 1300 300
			//VentanaListarTurnos.getInstance().setVisible(true);

			moverAutomaticamenteVentana(VentanaListarTurnos.getInstance(),pantallaTamano.width-1,ancho*2-10,alto,alto, 1);

			//Controlador.getInstance().action(EventoNegocio.LISTAR_CURSOS_ParaMatricula,null);
			
			
			//VentanaListarTurnos.getInstance().setVisible(true);
			
			break;
			
		case EventoGUI.BUSCAR_TURNO:
			VentanaMostrarTurno.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			break;
			
		case EventoGUI.MODIFICAR_TURNO:
			VentanaModificarTurno.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			break;
			
		case EventoGUI.BUSCAR_TURNO_PARA_MODIFICAR:
			VentanaModificarTurno.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			//VentanaModificarTurno.getInstance().setVisible(true);
			break;
		}
	}
	
	private void dispachEventosDeMateria(int evento, Contexto parDatosEvento) {
		
		switch (evento) {

		//***************** Dispacher MATERIA ******************//

		case EventoGUI.CREAR_MATERIA:
			VentanaCrearMateria.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			break;
			
		case EventoGUI.BORRAR_MATERIA:
			VentanaEliminarMateria.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			break;
			
		case EventoGUI.LISTAR_MATERIAS:
			VentanaListarMaterias.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			break;
			
		case EventoGUI.BUSCAR_MATERIA:
			VentanaMostrarMateria.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			break;
			
		case EventoGUI.BUSCAR_MATERIA_PARA_MODIFICAR:
			VentanaModificarMateria.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			break;
			
		case EventoGUI.MODIFICAR_MATERIA:
			VentanaModificarMateria.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			VentanaModificarMateria.getInstance().setVisible(true);
			break;

		}
		
		
	}
	
	private void dispachEventosDeProfesor(int evento, Contexto parDatosEvento) {
		
		switch (evento) {

		//***************** Dispacher PROFESOR ******************//

		case EventoGUI.CREAR_PROFESOR:
			VentanaCrearProfesor.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			break;

			
		case EventoGUI.BORRAR_PROFESOR:
			VentanaEliminarProfesor.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			break;
			
		case EventoGUI.LISTAR_PROFESORES:
			VentanaListarProfesor.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			
			break;
			
		case EventoGUI.BUSCAR_PROFESOR:
			VentanaMostrarProfesor.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			
			break;
			
		case EventoGUI.MODIFICAR_PROFESOR:
			VentanaModificarProfesor.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			break;
			
		case EventoGUI.LISTAR_MATERIAS_PARA_PROFESOR:
			VentanaBuscarMateriaProfesor.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			java.awt.Dimension pantallaTamano = Toolkit.getDefaultToolkit().getScreenSize();
			int ancho = ((pantallaTamano.width / 2) - (VentanaBuscarMateriaProfesor.getInstance().getWidth()) / 2);
			int alto = (pantallaTamano.height / 2) - (VentanaBuscarMateriaProfesor.getInstance().getHeight() );
			int alto2 = alto + VentanaBuscarMateriaProfesor.getInstance().getHeight() + 10 ;

			VentanaBuscarMateriaProfesor.getInstance().setLocation(pantallaTamano.width-1,alto); // 1300 300
			VentanaBuscarMateriaProfesor.getInstance().setVisible(true);

			moverAutomaticamenteVentana(VentanaBuscarMateriaProfesor.getInstance(),pantallaTamano.width-1,ancho*2,alto,alto, 1);
			break;
		case EventoGUI.BUSCAR_MATERIA_PARA_AÑADIR_A_PROFESOR:
			VentanaCrearProfesor.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			VentanaModificarProfesor.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			break;
			
		/*case EventoGUI.BUSCAR_MATERIA_PARA_AÑADIR_A_PROFESOR_MODIFICAR:
			VentanaModificarProfesor.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			break;	*/
			
		case EventoGUI.BUSCAR_PROFESOR_PARA_MODIFICAR:
			VentanaModificarProfesor.getInstance().update(parDatosEvento.getEvento(), parDatosEvento.getDatos());
			break;
		}
	}
	

	
	// Metodo realizar movimiento.
	private void moverAutomaticamenteVentana(JFrame ventana, int desdeX, int hastaX,
			int desdeY, int hastaY, int demora) {
		//System.out.println(" desdeX " + desdeX + " hastaX " + hastaX	+ " desdeY " + desdeY + " hastaY " + hastaY);
		
		while ((desdeX != hastaX) || (desdeY != hastaY)) {
			// Movimiento vertical
			if (desdeY != hastaY) {
				try {
					Thread.sleep(demora / 2);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (desdeY < hastaY) {
					desdeY++;
				} else if (desdeY != hastaY) {
					desdeY--;
				}
				ventana.setLocation(desdeX, desdeY);
			}
			// Movimiento horizontal
			if (desdeX != hastaX) {
				try {
					Thread.sleep(demora / 2);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (desdeX < hastaX) {
					desdeX++;
				} else if (desdeX != hastaX) {
					desdeX--;
				}
				ventana.setLocation(desdeX, desdeY);
			}
		}
	}
	
}