/**
 * 
 */
package SMSJPA.Presentacion.Profesor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import SMSJPA.Negocio.Profesor.TProfesor;
import SMSJPA.Negocio.Turno.TTurno;
import SMSJPA.Presentacion.Controlador.Controlador;
import SMSJPA.Presentacion.Controlador.EventoGUI;
import SMSJPA.Presentacion.JPrincipal.JPrincipalSMS;
import SMSJPA.Presentacion.Turno.VentanaEliminarTurno;
import SMSJPA.Presentacion.Turno.VentanaEliminarTurno.ALVentanaEliminarTurno;
import SMSJPA.Presentacion.Turno.VentanaEliminarTurno.WLVentanaEliminarTurno;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */

public class VentanaEliminarProfesor extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5976250009668219540L;
	private static VentanaEliminarProfesor uniqueInstance;
	// Observaciones
	private JLabel labelId_profesor;
	private JTextField txtFieldId_profesor;
	
	// Botones
	private JButton botonBorrar;
	private JButton botonAtras;

	private JPanel panelDatos;
	private JPanel panelBotones;

	public static void main(String args[]) {
		VentanaEliminarProfesor.getInstance().setVisible(true);
	}
	
	public VentanaEliminarProfesor() {
		super("Profesor turno");
		create();
		agregarManejadoresDeEventos();
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public static VentanaEliminarProfesor getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new VentanaEliminarProfesor();
		}
		return uniqueInstance;
	}
	
	private void agregarManejadoresDeEventos() {
		addWindowListener(new WLVentanaEliminarProfesor());

		ALVentanaEliminarProfesor oyente = new ALVentanaEliminarProfesor();
		botonBorrar.addActionListener(oyente);
		botonAtras.addActionListener(oyente);
	}
	
	private void create() {
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setSize(300, 300);
		this.setLayout(new BorderLayout());
		
		// Observaciones
		
		labelId_profesor = new JLabel("Introduzca el Id_Profesor: ");
		txtFieldId_profesor = new JTextField(20);
		

		panelDatos = new JPanel();
		panelDatos.setLayout(new FlowLayout());
		panelBotones = new JPanel();

		panelDatos.add(labelId_profesor);
		panelDatos.add(txtFieldId_profesor);
		
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
		txtFieldId_profesor.setText("");
	}
	
	public void update(int eventoGUI, Object datos) {
		switch (eventoGUI) {
		case (EventoGUI.PROFESOR_BORRADO): {
			Integer ID = (Integer) datos;

			JOptionPane.showMessageDialog(null,
					"Profesor con [ ID: " + ID.intValue() + " ] Eliminado.");
			
			limpiarCampos();
			
			//Mandamos el foco al primer campo.
			txtFieldId_profesor.requestFocus();
		}
			break;
			
		case (EventoGUI.PROFESOR_INEXISTENTE): {
			JOptionPane.showMessageDialog(null,
					"El profesor no existe.");
			
			limpiarCampos();

			//Mandamos el foco al primer campo.
			txtFieldId_profesor.requestFocus();
		}
			break;
			
		case (EventoGUI.PROFESOR_BORRAR_ERROR): {
			JOptionPane.showMessageDialog(null,
					"El profesor NO existe en la BBDD");
			txtFieldId_profesor.requestFocus();
		}
		}
	}
	
	public class ALVentanaEliminarProfesor implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			if (event.getSource() == botonAtras) {
				
				limpiarCampos();
				VentanaEliminarProfesor.this.dispose();
				Controlador.getInstance().action(EventoGUI.ABRIR_JPRINCIPAL, 0);
			}

			if (event.getSource() == botonBorrar) {
				
				try{
					// ******* Obtencion de datos de la ventana ******
					// Observaciones
					String stringId_Profesor = "";
					stringId_Profesor = txtFieldId_profesor.getText();
					
					if (!stringId_Profesor.equalsIgnoreCase("")){
						TProfesor tProfesor = new TProfesor(Integer.parseInt(stringId_Profesor));
						Controlador.getInstance().action(EventoGUI.BORRAR_PROFESOR, tProfesor);
						
					}
					else{
						JOptionPane.showMessageDialog(null, "Introduce el Id_profesor a borrar.");
						txtFieldId_profesor.requestFocus();
					}
					
				} catch (NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Introduzca datos correctamente");
				}
						
			}
		}
	}
	
	public class WLVentanaEliminarProfesor implements WindowListener {

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Apéndice de método generado automáticamente
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Apéndice de método generado automáticamente
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			limpiarCampos();
			VentanaEliminarProfesor.this.dispose();
			JPrincipalSMS.getInstance().setVisible(true);
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Apéndice de método generado automáticamente
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Apéndice de método generado automáticamente
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Apéndice de método generado automáticamente
			
		}

		@Override
		public void windowOpened(WindowEvent e) {
			txtFieldId_profesor.requestFocus();
		}
	}
}