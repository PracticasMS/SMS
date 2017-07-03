package SMSJPA.Presentacion.Turno;

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

import SMSJPA.Negocio.Turno.TTurno;
import SMSJPA.Presentacion.Controlador.Controlador;
import SMSJPA.Presentacion.Controlador.EventoGUI;

public class VentanaBuscarTurno extends JFrame{

	private static final long serialVersionUID = -4715304550616277710L;
	
	private static VentanaBuscarTurno uniqueInstance;
	
	// Observaciones
	private JLabel id_turno;
	private JTextField txtId_turno;
	
	// Botones
	private JButton botonAtras;
	private JButton botonBuscar;

	
	//_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-

	private JPanel panelDatos;
	private JPanel panelBotones;
	
	private int eventoGUI;

	
	public static VentanaBuscarTurno getInstance(){

		if(uniqueInstance == null){
			
			uniqueInstance = new VentanaBuscarTurno();
			
		}
		
		return uniqueInstance;
		
	}
	
	public static void main(String args[]) {
		
		VentanaBuscarTurno.getInstance().setVisible(true);
	}
	
	
	public VentanaBuscarTurno() {
		super("Buscar turno");
		create();
		agregarManejadoresDeEventos();
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	private void agregarManejadoresDeEventos() {
		
		addWindowListener(new WLVentanaMostrarTurno());

		ALVentanaMostrarTurno oyente = new ALVentanaMostrarTurno();
		botonAtras.addActionListener(oyente);
		botonBuscar.addActionListener(oyente);
		
	}
	
	private void create() {
		
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setSize(300, 300);
		this.setLayout(new GridLayout(2,1));
		
		id_turno = new JLabel("ID_Turno: ");
		txtId_turno = new  JTextField(10);
		
		botonBuscar = new JButton("Buscar Turno");
		botonAtras = new JButton("Atras");
		
		panelDatos = new JPanel();
		panelBotones = new JPanel();
		
		
		panelDatos.add(id_turno);
		panelDatos.add(txtId_turno);
		
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
	public class WLVentanaMostrarTurno implements WindowListener {

		public void windowOpened(WindowEvent arg0) {
			
		}

		
		public void windowClosing(WindowEvent arg0) {
			VentanaBuscarTurno.this.dispose();
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
				
				VentanaBuscarTurno.this.dispose();
				txtId_turno.setText("");
				txtId_turno.requestFocus();
				Controlador.getInstance().action(EventoGUI.ABRIR_JPRINCIPAL, 0);
			}
			if (event.getSource() == botonBuscar){
				
				try{
					// ******* Obtencion de datos de la ventana ******
					if(txtId_turno.getText() != ""){
					
						int id = Integer.parseInt(txtId_turno.getText());
						
						if(id < 0)throw new Exception();
					
						TTurno tTurno = new TTurno(id);
						if(eventoGUI == EventoGUI.BUSCAR_TURNO){
							Controlador.getInstance().action(EventoGUI.BUSCAR_TURNO, tTurno);
						}else if(eventoGUI == EventoGUI.BUSCAR_TURNO_PARA_MODIFICAR){
							Controlador.getInstance().action(EventoGUI.BUSCAR_TURNO_PARA_MODIFICAR, tTurno);
						}
						
						//VentanaBuscarTurno.this.setVisible(false);
						txtId_turno.setText("");						
						txtId_turno.requestFocus();
					}
					else{
						JOptionPane.showMessageDialog(null, "Introduce el id del turno que deseas buscar.");
						txtId_turno.requestFocus();
					}
					
					
				} 
				catch (NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Introduzca el ID correctamente");
				}
				catch (NullPointerException e){
					JOptionPane.showMessageDialog(null, "Error: se retorno un nulo");
				}
				catch (Exception e){
					JOptionPane.showMessageDialog(null, "No se aceptan numeros negativos");
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
