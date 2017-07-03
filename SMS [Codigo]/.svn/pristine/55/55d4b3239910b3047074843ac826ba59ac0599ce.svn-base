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

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VentanaBorrarCurso extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4483329104870978880L;

	
	
	private JPanel panelDatos;
	private JPanel panelBotones;
	
	
	private JButton botonAtras;
	
	private JButton botonBorrarCurso;

	private JTextField txtFieldID_Curso;

	private JLabel labelID_Curso;

	private static VentanaBorrarCurso uniqueInstance;

	
	
	public static void main(String []args){
		VentanaBorrarCurso.getInstance().setVisible(true);
	}
	
	
	public VentanaBorrarCurso(){
		super("Borrar Curso");
		
		create();
		
		agregarManejadoresDeEventos();
		
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	/**
	 * 
	 */
	private void agregarManejadoresDeEventos() {
		addWindowListener(new WLVentanaBorrarCurso());
		
		ALVentanaBorrarCurso oyente = new ALVentanaBorrarCurso();
		
		botonAtras.addActionListener(oyente);
		botonBorrarCurso.addActionListener(oyente);		
	}

	/**
	 * 
	 */
	private void create() {
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setSize(300, 300);
		this.setLayout(new GridLayout(2,1));
		
		labelID_Curso = new JLabel("ID_Curso: ");
		txtFieldID_Curso = new JTextField(15);
		botonBorrarCurso = new JButton("Borrar Curso");
		botonAtras = new JButton("Atras");
		
		panelDatos = new JPanel();
		panelBotones = new JPanel();
		
		
		panelDatos.add(labelID_Curso);
		panelDatos.add(txtFieldID_Curso);
		
		panelBotones.add(botonAtras);
		panelBotones.add(botonBorrarCurso);
		
		this.add(panelDatos);
		this.add(panelBotones);
		setLocationRelativeTo(null);
		
		//Inicializamos la vista.
		txtFieldID_Curso.setText("");
		txtFieldID_Curso.requestFocus();
	
		pack();		
	}

	public static VentanaBorrarCurso getInstance() {
		// begin-user-code
		if(uniqueInstance == null){
			uniqueInstance = new VentanaBorrarCurso();
		}
		return uniqueInstance;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void update(int evento, Object datos) {
		// begin-user-code
		Integer ID_Curso = (Integer)datos;
		
		switch (evento) {
		case (EventoGUI.CURSO_BORRADO):{
			JOptionPane.showMessageDialog(null, "Curso con [ ID: " + ID_Curso.intValue() + " ] borrado.");
			//limpio y foco
			txtFieldID_Curso.setText("");
			txtFieldID_Curso.requestFocus();
			
		}break;

		case (EventoGUI.CURSO_INEXISTENTE):{
			JOptionPane.showMessageDialog(null, "ERROR: el curso no existe o no está activo");
			txtFieldID_Curso.requestFocus();
		}break;
		
		case (EventoGUI.CURSO_BORRAR_ERROR):{
			JOptionPane.showMessageDialog(null, "ERROR: al intentar borrar el curso");
			txtFieldID_Curso.requestFocus();
		}break;
		
		case (EventoGUI.CURSO_VIGENTE):{
			JOptionPane.showMessageDialog(null, "ERROR: Existe una matricula vigente con este curso.");
			txtFieldID_Curso.requestFocus();
		}break;
		
	}
		// end-user-code
	}
	
	
	
	
	//****************************************************//
	//***************** Action Listener ******************//
	//****************************************************// 
	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @author Tomas
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public class ALVentanaBorrarCurso implements ActionListener {
		
		/** 
		 * (sin Javadoc)
		 * @see ActionListener#actionPerformed(ActionEvent arg0)
		 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
		 */
		public void actionPerformed(ActionEvent event) {
			// begin-user-code

			
			if(event.getSource() == botonAtras){
				VentanaBorrarCurso.this.dispose();
				txtFieldID_Curso.setText("");
				txtFieldID_Curso.requestFocus();
				JPrincipalSMS.getInstance().setVisible(true);
				
			}
			
			if(event.getSource() == botonBorrarCurso){
				
				//******* Obtencion de datos de la ventana ******
				String stringID = "";
				stringID = txtFieldID_Curso.getText();
				if(!stringID.equalsIgnoreCase("")){
					try{
						int ID_Curso = Integer.parseInt(stringID);
						
						TCurso tCurso = new TCurso(ID_Curso, null, 1);
						Controlador.getInstance().action(EventoNegocio.BORRAR_CURSO, tCurso);
						
					}catch (NumberFormatException e){
						
						JOptionPane.showMessageDialog(null, "ID incorrecto");
						
					}
					
				}else{
					
					JOptionPane.showMessageDialog(null, "Introduzca un ID");
					
				}
				
				
			}
			// end-user-code
		}
	}
	
	
	
	
	
	//****************************************************//
	//***************** Window Listener ******************//
	//****************************************************// 

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @author Tomas
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public class WLVentanaBorrarCurso implements WindowListener {
		/** 
		 * (sin Javadoc)
		 * @see WindowListener#windowOpened(WindowEvent arg0)
		 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
		 */
		public void windowOpened(WindowEvent arg0) {
			// begin-user-code
			txtFieldID_Curso.setText("");
			txtFieldID_Curso.requestFocus();
			// end-user-code
		}

		/** 
		 * (sin Javadoc)
		 * @see WindowListener#windowClosing(WindowEvent arg0)
		 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
		 */
		public void windowClosing(WindowEvent arg0) {
			// begin-user-code
			VentanaBorrarCurso.this.dispose();
			txtFieldID_Curso.setText("");
			txtFieldID_Curso.requestFocus();
			JPrincipalSMS.getInstance().setVisible(true);
			
			// end-user-code
		}

		/** 
		 * (sin Javadoc)
		 * @see WindowListener#windowClosed(WindowEvent arg0)
		 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
		 */
		public void windowClosed(WindowEvent arg0) {
			// begin-user-code
			// TODO Ap�ndice de m�todo generado autom�ticamente

			// end-user-code
		}

		/** 
		 * (sin Javadoc)
		 * @see WindowListener#windowIconified(WindowEvent arg0)
		 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
		 */
		public void windowIconified(WindowEvent arg0) {
			// begin-user-code
			// TODO Ap�ndice de m�todo generado autom�ticamente

			// end-user-code
		}

		/** 
		 * (sin Javadoc)
		 * @see WindowListener#windowDeiconified(WindowEvent arg0)
		 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
		 */
		public void windowDeiconified(WindowEvent arg0) {
			// begin-user-code
			// TODO Ap�ndice de m�todo generado autom�ticamente

			// end-user-code
		}

		/** 
		 * (sin Javadoc)
		 * @see WindowListener#windowActivated(WindowEvent arg0)
		 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
		 */
		public void windowActivated(WindowEvent arg0) {
			// begin-user-code
			// TODO Ap�ndice de m�todo generado autom�ticamente

			// end-user-code
		}

		/** 
		 * (sin Javadoc)
		 * @see WindowListener#windowDeactivated(WindowEvent arg0)
		 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
		 */
		public void windowDeactivated(WindowEvent arg0) {
			// begin-user-code
			// TODO Ap�ndice de m�todo generado autom�ticamente

			// end-user-code
		}
	}
	
	
}