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
import SMSJPA.Presentacion.JPrincipal.JPrincipalSMS;

public class VentanaEliminarTurno extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5882279724145137257L;
	
	private static VentanaEliminarTurno uniqueInstance;
	// Observaciones
	private JLabel labelId_turno;
	private JTextField txtFieldId_turno;
	
	// Botones
	private JButton botonBorrar;
	private JButton botonAtras;

	private JPanel panelDatos;
	private JPanel panelBotones;

	public static void main(String args[]) {
		VentanaEliminarTurno.getInstance().setVisible(true);
	}
	
	public VentanaEliminarTurno() {
		super("Borrar turno");
		create();
		agregarManejadoresDeEventos();
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public static VentanaEliminarTurno getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new VentanaEliminarTurno();
		}
		return uniqueInstance;
	}
	
	// Agregamos oyentes
	private void agregarManejadoresDeEventos() {
		addWindowListener(new WLVentanaEliminarTurno());

		ALVentanaEliminarTurno oyente = new ALVentanaEliminarTurno();
		botonBorrar.addActionListener(oyente);
		botonAtras.addActionListener(oyente);
	}
	
	private void create() {
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setSize(300, 300);
		this.setLayout(new BorderLayout());
		
		// Observaciones
		
		labelId_turno = new JLabel("Introduzca el Id_turno: ");
		txtFieldId_turno = new JTextField(20);
		

		panelDatos = new JPanel();
		panelDatos.setLayout(new FlowLayout());
		panelBotones = new JPanel();

		panelDatos.add(labelId_turno);
		panelDatos.add(txtFieldId_turno);
		
		//Botones.
		botonBorrar = new JButton("Borrar");
		botonAtras = new JButton("Atras");
		
		//Agregado de botones al panel.
		panelBotones.add(botonAtras);
		panelBotones.add(botonBorrar);


		this.add(panelDatos, BorderLayout.NORTH);
		this.add(panelBotones, BorderLayout.SOUTH);
		setLocationRelativeTo(null);

		// Inicializamos la vista.
		limpiarCampos();

		pack();
	}

	public void limpiarCampos(){
		txtFieldId_turno.setText("");
	}
	
	public void update(int eventoGUI, Object datos) {
		switch (eventoGUI) {
		case (EventoGUI.TURNO_BORRADO): {
			Integer ID = (Integer) datos;

			JOptionPane.showMessageDialog(null,
					"Turno con [ ID: " + ID.intValue() + " ] Eliminado.");
			
			limpiarCampos();
			
			//Mandamos el foco al primer campo.
			txtFieldId_turno.requestFocus();
		}
			break;
		case (EventoGUI.TURNO_BORRAR_ERROR): {
			JOptionPane.showMessageDialog(null,
					"El turno NO existe en la BBDD");
			txtFieldId_turno.requestFocus();
		}
		}
	}
	
	// ****************************************************//
	// ***************** Action Listener ******************//
	// ****************************************************//

	public class ALVentanaEliminarTurno implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {

			if (event.getSource() == botonAtras) {
				
				limpiarCampos();
				VentanaEliminarTurno.this.dispose();
				Controlador.getInstance().action(EventoGUI.ABRIR_JPRINCIPAL, 0);
			}

			if (event.getSource() == botonBorrar) {
				
				try{
					// ******* Obtencion de datos de la ventana ******
					// Observaciones
					String stringId_Turno = "";
					stringId_Turno = txtFieldId_turno.getText();
					
					if (!stringId_Turno.equalsIgnoreCase("")){
						TTurno tTurno = new TTurno(Integer.parseInt(stringId_Turno));
						Controlador.getInstance().action(EventoGUI.BORRAR_TURNO, tTurno);
						
					}
					else{
						JOptionPane.showMessageDialog(null, "Introduce el Id_turno a borrar.");
						txtFieldId_turno.requestFocus();
					}
					
				} catch (NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Introduzca datos correctamente");
				}
						
			}
		}
	}
	
	// ****************************************************//
	// ***************** Window Listener ******************//
	// ****************************************************//
	public class WLVentanaEliminarTurno implements WindowListener {

		public void windowOpened(WindowEvent arg0) {
			txtFieldId_turno.requestFocus();
		}

		public void windowClosing(WindowEvent arg0) {
			limpiarCampos();
			VentanaEliminarTurno.this.dispose();
			JPrincipalSMS.getInstance().setVisible(true);
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