/**
 * 
 */
package SMSDAO.Presentacion.Curso;


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

import SMSDAO.Negocio.Curso.TCurso;
import SMSDAO.Presentacion.Controlador.Controlador;
import SMSDAO.Presentacion.JPrincipal.EventoGUI;
import SMSDAO.Presentacion.JPrincipal.EventoNegocio;
import SMSDAO.Presentacion.JPrincipal.JPrincipalSMS;


public class VentanaCrearCurso extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4644119061260521032L;
	
	
	private JLabel labelNombreCurso;
	private JTextField txtFieldNombreCurso;
	private JButton botonCrearCurso;
	private JButton botonAtras;
	private JPanel panelDatos;
	private JPanel panelBotones;
	
	private static VentanaCrearCurso uniqueInstance;
	
	public static void main(String []args) {
		VentanaCrearCurso.getInstance().setVisible(true);
	}
	
	public VentanaCrearCurso(){
		super("Crear Curso");
		create();
		
		agregarManejadoresDeEventos();
		setLocationRelativeTo(null);
		setResizable(false);
	}


	/**
	 * 
	 */
	private void create() {
		
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setSize(300, 300);
		this.setLayout(new GridLayout(3,1));
		
		labelNombreCurso = new JLabel("Nombre Curso: ");
		txtFieldNombreCurso = new JTextField(20);
		
		botonCrearCurso = new JButton("Crear Curso");
		botonAtras = new JButton("Atras");
		
			
		panelDatos = new JPanel();
		panelBotones = new JPanel();
		
		
		panelDatos.add(labelNombreCurso);
		panelDatos.add(txtFieldNombreCurso);
				
		panelBotones.add(botonAtras);
		panelBotones.add(botonCrearCurso);
		
		this.add(panelDatos);
		this.add(panelBotones);
		setLocationRelativeTo(null);
	
		pack();
	}


	/**
	 * 
	 */
	private void agregarManejadoresDeEventos() {
		ALVentanaCrearCurso oyente = new ALVentanaCrearCurso();
		this.addWindowListener(new WLVentanaCrearCurso());
		botonCrearCurso.addActionListener(oyente);
		botonAtras.addActionListener(oyente);
		
	}


	public static VentanaCrearCurso getInstance() {
		
		if(uniqueInstance == null){
			
			uniqueInstance = new VentanaCrearCurso();
			
		}
		
		return uniqueInstance;
	}


	public void update(int evento, Object datos) {
		
		Integer ID_Curso = (Integer)datos;
		
		switch (evento) {
		case (EventoGUI.CURSO_CREADO):{
			
			JOptionPane.showMessageDialog(null, "Curso con [ ID: " + ID_Curso.intValue() + " ] Creado.");
			txtFieldNombreCurso.setText("");
			
		}break;

		case (EventoGUI.CURSO_CREAR_ERROR):{
			
			JOptionPane.showMessageDialog(null, "ERROR al crear el curso");
			
		}break;
		
		case (EventoGUI.CURSO_EXISTENTE):{
			
			JOptionPane.showMessageDialog(null, "EL curso ya existe y está activo");
			
		}break;
	}
		
		
	}
	

	
	//****************************************************//
	//***************** Action Listener ******************//
	//****************************************************// 
	
	public class ALVentanaCrearCurso implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			
			if(event.getSource() == botonAtras){
				VentanaCrearCurso.this.dispose();
				JPrincipalSMS.getInstance().setVisible(true);
				
			}
			
			if(event.getSource() == botonCrearCurso){
				String stringNombreCurso = "";
				stringNombreCurso = txtFieldNombreCurso.getText();
				
				
				//******* Obtencion de datos de la ventana ******
			
			
				if(!stringNombreCurso.equalsIgnoreCase("")){
					
					TCurso tCurso = new TCurso(-1, stringNombreCurso, 1);
					Controlador.getInstance().action(EventoNegocio.CREAR_CURSO, tCurso);

				}else{
					JOptionPane.showMessageDialog(null, "Introduzca el nombre del curso");
					//Devolvemos el foco.
					txtFieldNombreCurso.requestFocus();
				}
		
			}
		}
	}
	
	
	//****************************************************//
	//***************** Window Listener ******************//
	//****************************************************// 

	public class WLVentanaCrearCurso implements WindowListener {
	
		public void windowOpened(WindowEvent arg0) {
			
		}

		public void windowClosing(WindowEvent arg0) {
			
			JPrincipalSMS.getInstance().setVisible(true);
			VentanaCrearCurso.this.dispose();
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