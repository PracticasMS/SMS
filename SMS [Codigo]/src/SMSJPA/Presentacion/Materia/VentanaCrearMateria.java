/**
 * 
 */
package SMSJPA.Presentacion.Materia;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

import javax.swing.JFrame;
import static SMSJPA.Presentacion.Controlador.EventoGUI.*;
import static javax.swing.JOptionPane.*;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import SMSJPA.Negocio.Materia.TMateria;
import SMSJPA.Negocio.Turno.TTurno;
import SMSJPA.Presentacion.Controlador.Controlador;
import SMSJPA.Presentacion.Controlador.EventoGUI;
import SMSJPA.Presentacion.JPrincipal.JPrincipalSMS;
import SMSJPA.Presentacion.Turno.VentanaCrearTurno;
import SMSJPA.Presentacion.Turno.VentanaCrearTurno.ALVentanaCrearTurno;
import SMSJPA.Presentacion.Turno.VentanaCrearTurno.WLVentanaCrearTurno;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class VentanaCrearMateria extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8680313633554111360L;

	/**
	 */
	private static VentanaCrearMateria uniqueInstance;

	// Descripcion
	private JLabel labelDescripcion;
	private JTextField txtFieldDescripcion;

	// Nombre
	private JLabel labelNombre;
	private JTextField txtFieldNombre;

	// Botones
	private JButton botonCrear;
	private JButton botonAtras;
	
	//_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
	
	private JPanel panelDatos;//PANEL CON EL ID_PROFESOR Y EL NOMBRE
	private JPanel panelDescripcion;
	private JPanel panelBotones;
	
	public static void main(String args[]) {
		VentanaCrearMateria.getInstance().setVisible(true);
	}
	
	public VentanaCrearMateria() {
		super("Crear Materia");
		create();
		agregarManejadoresDeEventos();
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public static VentanaCrearMateria getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new VentanaCrearMateria();
		}
		return uniqueInstance;
	}	

	// Agregamos oyentes
	private void agregarManejadoresDeEventos() {
		addWindowListener(new WLVentanaCrearMateria());

		AlVentanaCrearMateria oyente = new AlVentanaCrearMateria();
		botonCrear.addActionListener(oyente);
		botonAtras.addActionListener(oyente);
		
	}

	public void limpiarCampos(){
		txtFieldNombre.setText("");
		txtFieldDescripcion.setText("");
	}

	private void create() {
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setSize(300, 300);
		this.setLayout(new BorderLayout());

		// Nombres
		labelNombre = new JLabel("Nombre: ");
		txtFieldNombre = new JTextField(25);
		// Descripcion
		labelDescripcion = new JLabel("Descripcion: ");
		txtFieldDescripcion = new JTextField(40);

		panelDatos = new JPanel();
		panelDatos.setLayout(new FlowLayout());
		panelDescripcion = new JPanel();
		panelDescripcion.setLayout(new FlowLayout());
		panelBotones = new JPanel();

		panelDatos.add(labelNombre);
		panelDatos.add(txtFieldNombre);
		panelDescripcion.add(labelDescripcion);
		panelDescripcion.add(txtFieldDescripcion);
		
		//Botones.
		botonCrear = new JButton("Crear");
		botonAtras = new JButton("Atras");
		
		//Agregado de botones al panel.
		panelBotones.add(botonAtras);
		panelBotones.add(botonCrear);

		this.add(panelDatos, BorderLayout.NORTH);
		this.add(panelDescripcion, BorderLayout.CENTER);
		this.add(panelBotones, BorderLayout.SOUTH);
		setLocationRelativeTo(null);

		// Inicializamos la vista.
		limpiarCampos();
		txtFieldNombre.requestFocus();

		pack();
	}
	
	public void update(int eventoGUI, Object datos) {
		switch (eventoGUI) {
		case (EventoGUI.MATERIA_CREADO): {
			Integer ID = (Integer) datos;

			JOptionPane.showMessageDialog(null,
					"Materia con [ ID: " + ID.intValue() + " ] Creado.");
			
			limpiarCampos();
			
			//Mandamos el foco al primer campo.
			txtFieldNombre.requestFocus();
		}
			break;
		case (EventoGUI.MATERIA_CREAR_ERROR): {
			JOptionPane.showMessageDialog(null,
					"La Materia ya existe en la BBDD");
			txtFieldNombre.requestFocus();
		}
		}
	}
	
	
	public class AlVentanaCrearMateria implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {

			if (event.getSource() == botonAtras) {
				
				limpiarCampos();
				VentanaCrearMateria.this.dispose();
				Controlador.getInstance().action(EventoGUI.ABRIR_JPRINCIPAL, 0);
			}

			if (event.getSource() == botonCrear) {
				
				try{
					// ******* Obtencion de datos de la ventana ******
								
					// NOMBRE
					String stringNombre = "";
					stringNombre = txtFieldNombre.getText();
					
					// DESCRIPCION
					String stringDescripcion = "";
					stringDescripcion = txtFieldDescripcion.getText();
					
					if (!stringDescripcion.equalsIgnoreCase("")
						&& !stringNombre.equalsIgnoreCase("")) {
							
						TMateria tMateria = new TMateria(0, 1, null, stringNombre, stringDescripcion);
						Controlador.getInstance().action(EventoGUI.CREAR_MATERIA, tMateria);
					}
					else{
						JOptionPane.showMessageDialog(null, "Introduce Los Datos.");
						if(stringNombre.equalsIgnoreCase(""))
							txtFieldNombre.requestFocus();
						else
							txtFieldDescripcion.requestFocus();
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
	
	public class WLVentanaCrearMateria implements WindowListener {

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Apéndice de método generado automáticamente
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Apéndice de método generado automáticamente
			
		}
		public void windowOpened(WindowEvent arg0) {
			txtFieldNombre.requestFocus();
		}

		public void windowClosing(WindowEvent arg0) {
			limpiarCampos();
			VentanaCrearMateria.this.dispose();
			Controlador.getInstance().action(EventoGUI.ABRIR_JPRINCIPAL, null);
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

		
	}
	
	
	
}