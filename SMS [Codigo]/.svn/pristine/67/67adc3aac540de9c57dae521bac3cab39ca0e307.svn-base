/**
 * 
 */
package SMSDAO.Presentacion.Matricula;

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

import SMSDAO.Negocio.Matricula.TMatricula;
import SMSDAO.Presentacion.Controlador.Controlador;
import SMSDAO.Presentacion.JPrincipal.EventoGUI;
import SMSDAO.Presentacion.JPrincipal.EventoNegocio;
import SMSDAO.Presentacion.JPrincipal.JPrincipalSMS;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Eduardo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VentanaEliminarMatricula extends JFrame {
	

	private static final long serialVersionUID = -3126663140819639438L;
	
	private static VentanaEliminarMatricula uniqueInstance;
	//Paneles
	private JPanel panelDatos;
	private JPanel panelBotones;	
	//Botones
	private JButton botonAtras;
	private JButton botonBorrarMatricula;
	//ID
	private JLabel labelID_Matricula;
	private JTextField txtFieldID_Matricula;

	public static VentanaEliminarMatricula getInstance() {
		if(uniqueInstance == null){
			uniqueInstance = new VentanaEliminarMatricula();
		}
		return uniqueInstance;
	}
	
	public static void main(String []args){
		VentanaEliminarMatricula.getInstance().setVisible(true);
	}
	
	
	public VentanaEliminarMatricula(){
		super("Borrar Matricula");
		
		create();
		
		agregarManejadoresDeEventos();
		
		setLocationRelativeTo(null);
		setResizable(false);
	}

	private void agregarManejadoresDeEventos() {
		addWindowListener(new WLVentanaEliminarMatricula());
		
		ALVentanaEliminarMatricula oyente = new ALVentanaEliminarMatricula();
		
		botonAtras.addActionListener(oyente);
		botonBorrarMatricula.addActionListener(oyente);		
	}

	private void create() {
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setSize(300, 300);
		this.setLayout(new GridLayout(2,1));
		
		labelID_Matricula = new JLabel("ID_Matricula: ");
		txtFieldID_Matricula = new JTextField(15);
		botonBorrarMatricula = new JButton("Borrar Matricula");
		botonAtras = new JButton("Atras");
		
		panelDatos = new JPanel();
		panelBotones = new JPanel();
		
		
		panelDatos.add(labelID_Matricula);
		panelDatos.add(txtFieldID_Matricula);
		
		panelBotones.add(botonAtras);
		panelBotones.add(botonBorrarMatricula);
		
		this.add(panelDatos);
		this.add(panelBotones);
		setLocationRelativeTo(null);
		
		//Inicializamos la vista.
		txtFieldID_Matricula.setText("");
		txtFieldID_Matricula.requestFocus();
	
		pack();		
	}
	
	public void update(int evento, Object datos) {
		Integer ID_Matricula = (Integer)datos;
		
		switch (evento) {
			case (EventoGUI.MATRICULA_BORRADO):{
				JOptionPane.showMessageDialog(null, "Matricula con [ ID: " + ID_Matricula.intValue() + " ] borrada.");
				//limpio y foco
				txtFieldID_Matricula.setText("");
				txtFieldID_Matricula.requestFocus();
				
			}break;
	
			case (EventoGUI.MATRICULA_INEXISTENTE_O_CON_CURSO_VIGENTE):{
				JOptionPane.showMessageDialog(null, "ERROR: La Matrícula no existe o tiene un curso vigente.");
				txtFieldID_Matricula.setText("");
				txtFieldID_Matricula.requestFocus();
			}break;
			
			case (EventoGUI.MATRICULA_BORRAR_ERROR):{
				JOptionPane.showMessageDialog(null, "ERROR al borrar la matricula.");
				txtFieldID_Matricula.setText("");
				txtFieldID_Matricula.requestFocus();
			}break;
		}
	}
	//****************************************************//
	//***************** Action Listener ******************//
	//****************************************************// 
	
	public class ALVentanaEliminarMatricula implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			if(event.getSource() == botonAtras){
				VentanaEliminarMatricula.this.dispose();
				txtFieldID_Matricula.setText("");
				txtFieldID_Matricula.requestFocus();
				JPrincipalSMS.getInstance().setVisible(true);
			}
			
			if(event.getSource() == botonBorrarMatricula){
				
				//******* Obtencion de datos de la ventana ******
				String stringID = "";
				stringID = txtFieldID_Matricula.getText();
				if(!stringID.equalsIgnoreCase("")){
					try{
						int ID_Matricula = Integer.parseInt(stringID);
						
						TMatricula tMatricula = new TMatricula(ID_Matricula);
						Controlador.getInstance().action(EventoNegocio.BORRAR_MATRICULA, tMatricula);
					}catch (NumberFormatException e){
						JOptionPane.showMessageDialog(null, "ID incorrecto");
						txtFieldID_Matricula.setText("");
						txtFieldID_Matricula.requestFocus();
					}
					
				}else{
					JOptionPane.showMessageDialog(null, "ID incorrecto");
				}
			}
		}
	}

	//****************************************************//
	//***************** Window Listener ******************//
	//****************************************************// 

	public class WLVentanaEliminarMatricula implements WindowListener {
	
		public void windowOpened(WindowEvent arg0) {
			txtFieldID_Matricula.setText("");
			txtFieldID_Matricula.requestFocus();
		}

		public void windowClosing(WindowEvent arg0) {

			VentanaEliminarMatricula.this.dispose();
			txtFieldID_Matricula.setText("");
			txtFieldID_Matricula.requestFocus();
			JPrincipalSMS.getInstance().setVisible(true);
		}
		
		public void windowClosed(WindowEvent arg0) {}

		public void windowIconified(WindowEvent arg0) {}

		public void windowDeiconified(WindowEvent arg0) {}

		public void windowActivated(WindowEvent arg0) {}

		public void windowDeactivated(WindowEvent arg0) {}
	}
}