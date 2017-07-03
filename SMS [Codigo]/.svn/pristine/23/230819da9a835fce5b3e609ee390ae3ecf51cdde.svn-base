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
import SMSDAO.Presentacion.JPrincipal.EventoGUI;
import SMSDAO.Presentacion.JPrincipal.JPrincipalSMS;


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VentanaMostrarCurso extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8301925892122307163L;
	
	private static VentanaMostrarCurso uniqueInstance;

	private JPanel panelDatos;
	private JPanel panelBoton;
	
	private JLabel labelID_Curso;
	private JLabel labelNombre;
	
	private JTextField txtFieldID_Curso;
	private JTextField txtFieldNombre;
	
	private JButton botonAtras;
	
	public static void main(String []args){
		VentanaMostrarCurso.getInstance().setVisible(true);
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public VentanaMostrarCurso(){
		super("Mostrar Curso");
		
		create();
		
		agregarManejadoresDeEventos();
		
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	
	public static VentanaMostrarCurso getInstance() {
		if(uniqueInstance == null){
			uniqueInstance = new VentanaMostrarCurso();
		}
		
		return uniqueInstance;
	}
	
	private void create() {
		
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setSize(300, 300);
		this.setLayout(new GridLayout(2,1));
		
		
		labelID_Curso = new JLabel("ID_Curso: ");
		txtFieldID_Curso = new  JTextField(10);
		
		
		labelNombre = new JLabel("Nombre: ");
		txtFieldNombre = new JTextField(10);
		
		botonAtras = new JButton("Atras");
		
		panelDatos = new JPanel();
		panelBoton = new JPanel();
		
		
		panelDatos.add(labelID_Curso);
		panelDatos.add(txtFieldID_Curso);
		panelDatos.add(txtFieldNombre);
		panelDatos.add(labelNombre);
		panelDatos.add(txtFieldNombre);
		
		panelBoton.add(botonAtras);
		
		this.add(panelDatos);
		this.add(panelBoton);
		setLocationRelativeTo(null);
		
		txtFieldID_Curso.setEditable(false);
		txtFieldNombre.setEditable(false);
	
		pack();
		
	}
	
	private void agregarManejadoresDeEventos() {
		ALVentanaMostrarCurso oyente = new ALVentanaMostrarCurso();
		this.addWindowListener(new WLMostrarCurso());
		botonAtras.addActionListener(oyente);
		
	}
	
	public void update(int evento, Object datos) {
		
		switch (evento) {
			case (SMSDAO.Presentacion.JPrincipal.EventoGUI.MOSTRAR_CURSO):{
				TCurso tCurso = (TCurso)datos;
				String stringID = Integer.toString(tCurso.getId_Curso());
				txtFieldID_Curso.setText(stringID);
				
				String stringNombre = tCurso.getNombre();
				txtFieldNombre.setText(stringNombre);

			}break;
			
			case (EventoGUI.CURSO_INEXISTENTE):{
				JOptionPane.showMessageDialog(null, "ERROR: el curso no existe");
				
				txtFieldID_Curso.requestFocus();
				
			}break;
			
	
		}
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
	public class ALVentanaMostrarCurso implements ActionListener{
		/** 
		 * <!-- begin-UML-doc -->
		 * <!-- end-UML-doc -->
		 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
		 */
		public void actionPerformed(ActionEvent event) {
			
			
			if(event.getSource() == botonAtras){
				VentanaMostrarCurso.this.dispose();
				VentanaBuscarCurso.getInstance().setVisible(true);
				
			}
			
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
	public class WLMostrarCurso implements WindowListener {

		public void windowOpened(WindowEvent arg0) {
			
		}

		public void windowClosing(WindowEvent arg0) {
			JPrincipalSMS.getInstance().setVisible(true);
			VentanaMostrarCurso.this.dispose();
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