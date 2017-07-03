/**
 * 
 */
package SMSJPA.Presentacion.Turno;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import SMSJPA.Negocio.Turno.TTurno;
import SMSJPA.Presentacion.Controlador.Controlador;
import SMSJPA.Presentacion.Controlador.EventoGUI;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class VentanaModificarTurno extends JFrame {

	
	private static final long serialVersionUID = -5778320782241828297L;
	private static VentanaModificarTurno uniqueInstance;
	
	//ID
	private JLabel labelID;
	private JTextField txtFieldID;
	
	
	//Observaciones
	private JLabel labelObservaciones;
	private JTextField txtFieldObservaciones;

	// Botones
	private JButton botonModificar;
	private JButton botonAtras;

	//Hora inicio y hora de fin.
	private JLabel labelHoraInicio;
	private JComboBox comboHoraInicio;

	private JLabel labelHoraFin;
	private JComboBox comboHoraFin;

	//_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-

	private JPanel panelDatosArriba;
	private JPanel panelDatosCentro;
	private JPanel panelBotones;
	private JPanel panelHoras;

	public static void main(String args[]) {
		VentanaModificarTurno.getInstance().setVisible(true);
	}

	public VentanaModificarTurno() {
		super("Modificar turno");
		create();
		agregarManejadoresDeEventos();
		setLocationRelativeTo(null);
		setResizable(false);
	}

	public static VentanaModificarTurno getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new VentanaModificarTurno();
		}
		return uniqueInstance;
	}

	// Agregamos oyentes
	private void agregarManejadoresDeEventos() {
		addWindowListener(new WLVentanaModificarTurno());

		ALVentanaModificarTurno oyente = new ALVentanaModificarTurno();
		botonModificar.addActionListener(oyente);
		botonAtras.addActionListener(oyente);
		comboHoraInicio.addActionListener(oyente);
		comboHoraFin.addActionListener(oyente);
	}

	private void create() {
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setSize(300, 300);
		this.setLayout(new BorderLayout());
		
		//ID
		labelID = new JLabel("ID: ");
		txtFieldID = new JTextField(5);
		txtFieldID.setEditable(false);
;
		// Observaciones
		labelObservaciones = new JLabel("Observaciones: ");
		txtFieldObservaciones = new JTextField(35);
		//Hora inicio y hora de fin.
		labelHoraInicio = new JLabel("Hora inicio: ");
		Vector<String> horasIni = new Vector<String>();
		for (int i = 1; i<=24 ; i++)
			horasIni.add(Integer.toString(i));
		comboHoraInicio = new JComboBox(horasIni);

		labelHoraFin = new JLabel("Hora fin: ");
		Vector<String> horasFin = new Vector<String>();
		for (int i = 1; i<=24 ; i++)
			horasFin.add(Integer.toString(i));
		comboHoraFin = new JComboBox(horasFin);

		panelHoras = new JPanel();
		panelHoras.add(labelHoraInicio);
		panelHoras.add(comboHoraInicio);
		panelHoras.add(labelHoraFin);
		panelHoras.add(comboHoraFin);

		panelDatosArriba = new JPanel();
		panelDatosArriba.setLayout(new FlowLayout());
		panelBotones = new JPanel();

		panelDatosArriba.add(labelID);
		panelDatosArriba.add(txtFieldID);
		panelDatosArriba.add(labelObservaciones);
		panelDatosArriba.add(txtFieldObservaciones);

		//Botones.
		botonModificar = new JButton("Modificar");
		botonAtras = new JButton("Atras");

		//Agregado de botones al panel.
		panelBotones.add(botonAtras);
		panelBotones.add(botonModificar);

		panelDatosCentro = new JPanel();
		panelDatosCentro.setLayout(new BorderLayout());
		panelDatosCentro.add(panelDatosArriba, BorderLayout.NORTH);
		panelDatosCentro.add(panelHoras, BorderLayout.SOUTH);

		this.add(panelDatosCentro, BorderLayout.CENTER);
		this.add(panelBotones, BorderLayout.SOUTH);
		setLocationRelativeTo(null);

		// Inicializamos la vista.
		limpiarCampos();
		txtFieldObservaciones.requestFocus();

		pack();
	}

	public void limpiarCampos(){
		comboHoraInicio.setSelectedIndex(0);
		comboHoraFin.setSelectedIndex(0);
		txtFieldObservaciones.setText("");
		txtFieldID.setText("");
	}

	public void update(int eventoGUI, Object datos) {
		switch (eventoGUI) {
		case EventoGUI.BUSCAR_TURNO:{
			TTurno miturno = (TTurno) datos;
			
			//ID
			this.txtFieldID.setText(Integer.toString(miturno.getID()));
			
			//Hora Inicio
			comboHoraInicio.setSelectedIndex(miturno.getHora_inicio()-1);
			
			
			//hora fin
			comboHoraFin.setSelectedIndex((miturno.getHora_fin())-1);
			
			// observaciones
			this.txtFieldObservaciones.setText(miturno.getObservaciones());
			
			Controlador.getInstance().action(EventoGUI.ABRIR_VENTANA_MODIFICAR_TURNO,0);
			
		}
		break;
		case (EventoGUI.BUSCAR_TURNO_ERROR): {
			JOptionPane.showMessageDialog(null, "El turno no existe en la BBDD");
		
		}
		break;
		case (EventoGUI.TURNO_MODIFICADO): {
			Integer ID = (Integer) datos;

			JOptionPane.showMessageDialog(null, "Turno con [ ID: " + ID.intValue() + " ] Modificado.");

			limpiarCampos();

			//Mandamos el foco al primer campo.
			VentanaModificarTurno.this.dispose();
			Controlador.getInstance().action(EventoGUI.ABRIR_JPRINCIPAL, null);
		}
		break;
		case (EventoGUI.MODIFICAR_TURNO_ERROR): {
			JOptionPane.showMessageDialog(null, "El turno no existe en la BBDD");
			txtFieldObservaciones.requestFocus();
		}
		break;
		}
	}

	// ****************************************************//
	// ***************** Action Listener ******************//
	// ****************************************************//

	public class ALVentanaModificarTurno implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {

			if (event.getSource() == botonAtras) {

				limpiarCampos();
				VentanaModificarTurno.this.dispose();
				Controlador.getInstance().action(EventoGUI.ABRIR_JPRINCIPAL, 0);
			}

			if (event.getSource() == botonModificar) {

				try{
					// ******* Obtencion de datos de la ventana ******
					// Observaciones
					String stringObservaciones = "";
					stringObservaciones = txtFieldObservaciones.getText();
					// Horas
					String horaInicio = "";
					horaInicio = comboHoraInicio.getSelectedItem().toString();
					String horaFin = "";
					horaFin = comboHoraFin.getSelectedItem().toString();

					if (!stringObservaciones.equalsIgnoreCase("")
							&& !horaInicio.equalsIgnoreCase("")
							&& !horaFin.equalsIgnoreCase("")) {

						//Comprobamos que la hora de fin es mayor que la hora de inicio.
						if (Integer.parseInt(horaInicio) >= Integer.parseInt(horaFin))
							JOptionPane.showMessageDialog(null, "La hora de fin tiene que ser superior a la de inicio.");
						else{
							TTurno tTurno = new TTurno(Integer.parseInt(txtFieldID.getText()), Integer.parseInt(horaInicio), Integer.parseInt(horaFin), stringObservaciones);
							Controlador.getInstance().action(EventoGUI.MODIFICAR_TURNO, tTurno);
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Introduce alguna observación.");
						txtFieldObservaciones.requestFocus();
					}


				} catch (NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Introduzca datos correctamente");
				}

			}
			
			
			if (event.getSource() == comboHoraInicio) {
				if(Integer.parseInt(comboHoraInicio.getSelectedItem().toString())== 24){
					comboHoraFin.setSelectedIndex(0);
				}else{
					comboHoraFin.setSelectedIndex(Integer.parseInt(comboHoraInicio.getSelectedItem().toString()));
				}
			}
			
			
			
				
			
		}
	}

	// ****************************************************//
	// ***************** Window Listener ******************//
	// ****************************************************//
	public class WLVentanaModificarTurno implements WindowListener {

		public void windowOpened(WindowEvent arg0) {
			txtFieldObservaciones.requestFocus();
		}

		public void windowClosing(WindowEvent arg0) {
			limpiarCampos();
			VentanaModificarTurno.this.dispose();
			Controlador.getInstance().action(EventoGUI.ABRIR_JPRINCIPAL, null);
		}

		public void windowClosed(WindowEvent arg0) {
		}

		public void windowIconified(WindowEvent arg0) {
		}

		public void windowDeiconified(WindowEvent arg0) {
		}

		public void windowActivated(WindowEvent arg0) {
		}

		public void windowDeactivated(WindowEvent arg0) {
		}
	}
}