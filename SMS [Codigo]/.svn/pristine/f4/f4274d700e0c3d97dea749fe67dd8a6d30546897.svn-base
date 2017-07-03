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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import SMSJPA.Negocio.Turno.TTurno;
import SMSJPA.Presentacion.Controlador.Controlador;
import SMSJPA.Presentacion.Controlador.EventoGUI;


public class VentanaMostrarTurno extends JFrame {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 3329448933724035698L;

	private static VentanaMostrarTurno uniqueInstance;
	
	// Observaciones
	private JLabel labelObservaciones;
	private JTextField txtFieldObservaciones;
	
	// Botones
	private JButton botonAtras;

	//Hora inicio y hora de fin.
	private JLabel labelHoraInicio;
	private JTextField HoraInicio;
	
	private JLabel labelHoraFin;
	private JTextField HoraFin;
	
	//_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
	
	private JPanel panelDatosArriba;
	private JPanel panelDatosCentro;
	private JPanel panelBotones;
	private JPanel panelHoras;
	
	
	public static VentanaMostrarTurno getInstance(){

		if(uniqueInstance == null){
			
			uniqueInstance = new VentanaMostrarTurno();
			
		}
		
		return uniqueInstance;
		
	}
	
	public static void main(String args[]) {
		
		VentanaMostrarTurno.getInstance().setVisible(true);
	}
	
	
	public VentanaMostrarTurno() {
		super("Mostrar turno");
		create();
		agregarManejadoresDeEventos();
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	private void agregarManejadoresDeEventos() {
		
		addWindowListener(new WLVentanaMostrarTurno());

		ALVentanaMostrarTurno oyente = new ALVentanaMostrarTurno();
		botonAtras.addActionListener(oyente);
		
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
		HoraInicio = new JTextField(10);
		
		labelHoraFin = new JLabel("Hora fin: ");
		HoraFin = new JTextField(10);

		panelHoras = new JPanel();
		panelHoras.add(labelHoraInicio);
		panelHoras.add(HoraInicio);
		panelHoras.add(labelHoraFin);
		panelHoras.add(HoraFin);

		panelDatosArriba = new JPanel();
		panelDatosArriba.setLayout(new FlowLayout());
		
		panelBotones = new JPanel();

		panelDatosArriba.add(labelObservaciones);
		panelDatosArriba.add(txtFieldObservaciones);
		
		//Botones.
		botonAtras = new JButton("Atras");
		
		//Agregado de botones al panel.
		panelBotones.add(botonAtras);

		panelDatosCentro = new JPanel();
		panelDatosCentro.setLayout(new BorderLayout());
		panelDatosCentro.add(panelDatosArriba, BorderLayout.NORTH);
		panelDatosCentro.add(panelHoras, BorderLayout.SOUTH);

		this.add(panelDatosArriba, BorderLayout.CENTER);
		this.add(panelDatosCentro, BorderLayout.NORTH);
		this.add(panelBotones, BorderLayout.SOUTH);
		setLocationRelativeTo(null);


		pack();
	}

	
	public void update(int eventoGUI, Object datos) {
		
		TTurno Tturno = (TTurno) datos;
		
		switch (eventoGUI) {
		case (EventoGUI.BUSCAR_TURNO):
			
			int hora_inicio = Tturno.getHora_inicio();
			int hora_fin = Tturno.getHora_fin();
			String Observaciones = Tturno.getObservaciones();
			
			HoraFin.setText(Integer.toString(hora_fin));
			HoraInicio.setText(Integer.toString(hora_inicio));
			txtFieldObservaciones.setText(Observaciones);
			
			HoraFin.setEditable(false);
			HoraInicio.setEditable(false);
			txtFieldObservaciones.setEditable(false);
			
			this.setVisible(true);
			
		break;
		case(EventoGUI.BUSCAR_TURNO_ERROR):
			
			JOptionPane.showMessageDialog(null, "El Turno al que desea acceder no esta registrado");
			Controlador.getInstance().action(EventoGUI.ABRIR_VENTANA_BUSCAR_TURNO, 0);
			
		break;
		}
		
		
	}
	
	// ****************************************************//
	// ***************** Window Listener ******************//
	// ****************************************************//
	public class WLVentanaMostrarTurno implements WindowListener {

		public void windowOpened(WindowEvent arg0) {
			
		}

		
		public void windowClosing(WindowEvent arg0) {
			VentanaMostrarTurno.this.dispose();
			Controlador.getInstance().action(EventoGUI.ABRIR_JPRINCIPAL, 0);
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
	
	
	// ****************************************************//
	// ***************** Action Listener ******************//
	// ****************************************************//
	public class ALVentanaMostrarTurno implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			if (event.getSource() == botonAtras) {
				
				VentanaMostrarTurno.this.dispose();
				Controlador.getInstance().action(EventoGUI.ABRIR_JPRINCIPAL, 0);
			}

		}
	}
	
}