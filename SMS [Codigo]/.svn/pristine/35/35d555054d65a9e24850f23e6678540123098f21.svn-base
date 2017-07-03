package SMSJPA.Presentacion.Materia;

import java.awt.GridLayout;
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

import SMSJPA.Negocio.Materia.TMateria;
import SMSJPA.Negocio.Turno.TTurno;
import SMSJPA.Presentacion.Controlador.Controlador;
import SMSJPA.Presentacion.Controlador.EventoGUI;

public class VentanaBuscarMateria extends JFrame{

	private static final long serialVersionUID = -4715304550616277710L;
	
	private static VentanaBuscarMateria uniqueInstance;
	
	// Observaciones
	private JLabel id_Materia;
	private JTextField txtId_Materia;
	
	// Botones
	private JButton botonAtras;
	private JButton botonBuscar;

	
	//_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-

	private JPanel panelDatos;
	private JPanel panelBotones;
	
	private int eventoGUI;

	
	public static VentanaBuscarMateria getInstance(){

		if(uniqueInstance == null){
			
			uniqueInstance = new VentanaBuscarMateria();
			
		}
		
		return uniqueInstance;
		
	}
	
	public static void main(String args[]) {
		
		VentanaBuscarMateria.getInstance().setVisible(true);
	}
	
	
	public VentanaBuscarMateria() {
		super("Buscar materia");
		create();
		agregarManejadoresDeEventos();
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	private void agregarManejadoresDeEventos() {
		
		addWindowListener(new WLVentanaMostrarMateria());

		ALVentanaMostrarMateria oyente = new ALVentanaMostrarMateria();
		botonAtras.addActionListener(oyente);
		botonBuscar.addActionListener(oyente);
		
	}
	
	private void create() {
		
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setSize(300, 300);
		this.setLayout(new GridLayout(2,1));
		
		id_Materia = new JLabel("ID_Materia: ");
		txtId_Materia = new  JTextField(10);
		
		botonBuscar = new JButton("Buscar Materia");
		botonAtras = new JButton("Atras");
		
		panelDatos = new JPanel();
		panelBotones = new JPanel();
		
		
		panelDatos.add(id_Materia);
		panelDatos.add(txtId_Materia);
		
		panelBotones.add(botonAtras);
		panelBotones.add(botonBuscar);
		
		this.add(panelDatos);
		this.add(panelBotones);
		setLocationRelativeTo(null);
	
		pack();
	}

	
	public void update(int eventoGUI, Object datos) {
		
		
	}
	
	// ****************************************************//
	// ***************** Window Listener ******************//
	// ****************************************************//
	public class WLVentanaMostrarMateria implements WindowListener {

		public void windowOpened(WindowEvent arg0) {
			
		}

		
		public void windowClosing(WindowEvent arg0) {
			VentanaBuscarMateria.this.dispose();
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
	public class ALVentanaMostrarMateria implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			if (event.getSource() == botonAtras) {
				
				VentanaBuscarMateria.this.dispose();
				Controlador.getInstance().action(EventoGUI.ABRIR_JPRINCIPAL, 0);
			}
			if (event.getSource() == botonBuscar){
				
				try{
					// ******* Obtencion de datos de la ventana ******
					if(txtId_Materia.getText() != ""){
					
						int id = Integer.parseInt(txtId_Materia.getText());
						
						if(id < 0)throw new NumberFormatException();
					
						TMateria tMateria = new TMateria(id);
						if(eventoGUI == EventoGUI.BUSCAR_MATERIA){
							Controlador.getInstance().action(EventoGUI.BUSCAR_MATERIA, tMateria);
						}else{
							Controlador.getInstance().action(EventoGUI.BUSCAR_MATERIA_PARA_MODIFICAR, tMateria);
						}
						
						VentanaBuscarMateria.this.dispose();
						txtId_Materia.setText("");
					}
					else{
						JOptionPane.showMessageDialog(null, "Introduce el id de la materia que deseas buscar.");
						txtId_Materia.requestFocus();
					}
				} 
				catch (NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Introduzca el ID correctamente");
				}
			}
		}
	}


	/**
	 * @param eventoGUI el eventoGUI a establecer
	 */
	public void setEventoGUI(int eventoGUI) {
		this.eventoGUI = eventoGUI;
	}

}
