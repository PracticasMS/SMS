package SMSJPA.Presentacion.Profesor;

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
import SMSJPA.Negocio.Profesor.TProfesor;
import SMSJPA.Presentacion.Controlador.Controlador;
import SMSJPA.Presentacion.Controlador.EventoGUI;
import SMSJPA.Presentacion.Materia.VentanaBuscarMateria;
import SMSJPA.Presentacion.Materia.VentanaBuscarMateria.ALVentanaMostrarMateria;
import SMSJPA.Presentacion.Materia.VentanaBuscarMateria.WLVentanaMostrarMateria;

public class VentanaBuscarProfesor extends JFrame{
	
	private static VentanaBuscarProfesor uniqueInstance;
	
	// Observaciones
	private JLabel id_Profesor;
	private JTextField txtId_Profesor;
	
	// Botones
	private JButton botonAtras;
	private JButton botonBuscar;
	//Paneles
	private JPanel panelDatos;
	private JPanel panelBotones;
	
	private int eventoGUI;

	
	public static VentanaBuscarProfesor getInstance(){
		if(uniqueInstance == null){			
			uniqueInstance = new VentanaBuscarProfesor();			
		}		
		return uniqueInstance;
	}
	
	public static void main(String args[]) {
		
		VentanaBuscarProfesor.getInstance().setVisible(true);
	}
	
	
	public VentanaBuscarProfesor() {
		super("Buscar Profesor");
		create();
		agregarManejadoresDeEventos();
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	private void agregarManejadoresDeEventos() {
		
		addWindowListener(new WLVentanaMostrarProfesor());

		ALVentanaMostrarProfesor oyente = new ALVentanaMostrarProfesor();
		botonAtras.addActionListener(oyente);
		botonBuscar.addActionListener(oyente);
		
	}
	
	private void create() {
		
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setSize(300, 300);
		this.setLayout(new GridLayout(2,1));
		
		id_Profesor = new JLabel("ID_Profesor: ");
		txtId_Profesor = new  JTextField(10);
		
		botonBuscar = new JButton("Buscar Profesor");
		botonAtras = new JButton("Atras");
		
		panelDatos = new JPanel();
		panelBotones = new JPanel();
		
		
		panelDatos.add(id_Profesor);
		panelDatos.add(txtId_Profesor);
		
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
	public class WLVentanaMostrarProfesor implements WindowListener {

		public void windowOpened(WindowEvent arg0) {}

		
		public void windowClosing(WindowEvent arg0) {
			VentanaBuscarProfesor.this.dispose();
			Controlador.getInstance().action(EventoGUI.ABRIR_JPRINCIPAL, 0);
		}

		
		public void windowClosed(WindowEvent arg0) {}

		
		public void windowIconified(WindowEvent arg0) {}

		
		public void windowDeiconified(WindowEvent arg0) {}

		
		public void windowActivated(WindowEvent arg0) {}

		
		public void windowDeactivated(WindowEvent arg0) {}
	}
	
	
	// ****************************************************//
	// ***************** Action Listener ******************//
	// ****************************************************//
	public class ALVentanaMostrarProfesor implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			if (event.getSource() == botonAtras) {
				
				VentanaBuscarProfesor.this.dispose();
				txtId_Profesor.setText("");
				Controlador.getInstance().action(EventoGUI.ABRIR_JPRINCIPAL, 0);
			}
			if (event.getSource() == botonBuscar){
				
				try{
					// ******* Obtencion de datos de la ventana ******
					if(txtId_Profesor.getText() != ""){
					
						int id = Integer.parseInt(txtId_Profesor.getText());
						
						if(id < 0)throw new NumberFormatException();
					
						TProfesor tProfesor = new TProfesor(id);
						if(eventoGUI == EventoGUI.BUSCAR_PROFESOR){
							Controlador.getInstance().action(EventoGUI.BUSCAR_PROFESOR, tProfesor);
						}else{
							Controlador.getInstance().action(EventoGUI.BUSCAR_PROFESOR_PARA_MODIFICAR, tProfesor);
						}
						
						VentanaBuscarProfesor.this.dispose();
						txtId_Profesor.setText("");
					}
					else{
						JOptionPane.showMessageDialog(null, "Introduce el id del Profesor que deseas buscar.");
						txtId_Profesor.requestFocus();
					}
				}
				catch (NullPointerException e){
					JOptionPane.showMessageDialog(null, "El Profesor al que desea acceder no esta registrado");	
					txtId_Profesor.setText("");
					txtId_Profesor.requestFocus();
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
