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
public class VentanaCrearTurno extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3164641167877349134L;
	
	
	private static VentanaCrearTurno uniqueInstance;
	// Observaciones
	private JLabel labelObservaciones;
	private JTextField txtFieldObservaciones;
	
	// Botones
	private JButton botonCrear;
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
		VentanaCrearTurno.getInstance().setVisible(true);
	}
	
	public VentanaCrearTurno() {
		super("Crear turno");
		create();
		agregarManejadoresDeEventos();
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public static VentanaCrearTurno getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new VentanaCrearTurno();
		}
		return uniqueInstance;
	}
	
	// Agregamos oyentes
	private void agregarManejadoresDeEventos() {
		addWindowListener(new WLVentanaCrearTurno());

		ALVentanaCrearTurno oyente = new ALVentanaCrearTurno();
		botonCrear.addActionListener(oyente);
		botonAtras.addActionListener(oyente);
		
		comboHoraInicio.addActionListener(oyente);
		comboHoraFin.addActionListener(oyente);
	}

	private void create() {
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setSize(300, 300);
		this.setLayout(new BorderLayout());
		
		// Observaciones
		labelObservaciones = new JLabel("Observaciones: ");
		txtFieldObservaciones = new JTextField(50);
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

		panelDatosArriba.add(labelObservaciones);
		panelDatosArriba.add(txtFieldObservaciones);
		
		//Botones.
		botonCrear = new JButton("Crear");
		botonAtras = new JButton("Atras");
		
		//Agregado de botones al panel.
		panelBotones.add(botonAtras);
		panelBotones.add(botonCrear);

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
	}
	
	public void update(int eventoGUI, Object datos) {
		switch (eventoGUI) {
		case (EventoGUI.TURNO_CREADO): {
			Integer ID = (Integer) datos;

			JOptionPane.showMessageDialog(null,
					"Turno con [ ID: " + ID.intValue() + " ] Creado.");
			
			limpiarCampos();
			
			//Mandamos el foco al primer campo.
			txtFieldObservaciones.requestFocus();
		}
			break;
		case (EventoGUI.TURNO_CREAR_ERROR): {
			JOptionPane.showMessageDialog(null,
					"El turno ya existe en la BBDD");
			txtFieldObservaciones.requestFocus();
		}
		}
	}
	
	// ****************************************************//
	// ***************** Action Listener ******************//
	// ****************************************************//

	public class ALVentanaCrearTurno implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {

			if (event.getSource() == botonAtras) {
				
				limpiarCampos();
				VentanaCrearTurno.this.dispose();
				Controlador.getInstance().action(EventoGUI.ABRIR_JPRINCIPAL, 0);
			}

			if (event.getSource() == botonCrear) {
				
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
							TTurno tTurno = new TTurno(0, Integer.parseInt(horaInicio), Integer.parseInt(horaFin), stringObservaciones);
							Controlador.getInstance().action(EventoGUI.CREAR_TURNO, tTurno);
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
	public class WLVentanaCrearTurno implements WindowListener {

		public void windowOpened(WindowEvent arg0) {
			txtFieldObservaciones.requestFocus();
		}

		public void windowClosing(WindowEvent arg0) {
			limpiarCampos();
			VentanaCrearTurno.this.dispose();
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