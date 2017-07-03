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
public class VentanaBuscarCurso extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9134779943129310760L;
	
	private JPanel panelDatos;
	private JPanel panelBotones;
	
	private JLabel labelID_Curso;
	private JTextField txtFieldID_Curso;
	
	private JButton botonBuscarCurso;
	private JButton botonAtras;
	private int tipoEventoGUI;

	private static VentanaBuscarCurso uniqueInstance;
	
	public VentanaBuscarCurso(){
		super("Buscar Curso");
		
		create();
		
		agregarManejadoresDeEventos();
		
		setLocationRelativeTo(null);
		setResizable(false);
	}
	public static VentanaBuscarCurso getInstance() {
		if(uniqueInstance == null){
			uniqueInstance = new VentanaBuscarCurso();
		}
		
		return uniqueInstance;
	}
	
	private void create() {
		
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setSize(300, 300);
		this.setLayout(new GridLayout(2,1));
		
		labelID_Curso = new JLabel("ID_Curso: ");
		txtFieldID_Curso = new  JTextField(10);
		
		botonBuscarCurso = new JButton("Buscar Curso");
		botonAtras = new JButton("Atras");
		
		panelDatos = new JPanel();
		panelBotones = new JPanel();
		
		
		panelDatos.add(labelID_Curso);
		panelDatos.add(txtFieldID_Curso);
		
		panelBotones.add(botonAtras);
		panelBotones.add(botonBuscarCurso);
		
		this.add(panelDatos);
		this.add(panelBotones);
		setLocationRelativeTo(null);
	
		pack();
		
	}
	private void agregarManejadoresDeEventos() {
		
		ALVentanaBuscarCurso oyente = new ALVentanaBuscarCurso();
		this.addWindowListener(new WLVentanaBuscarCurso());
		botonBuscarCurso.addActionListener(oyente);
		botonAtras.addActionListener(oyente);
		
	}
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void update(int evento, Object datos) {
		switch (evento){
		case EventoGUI.MOSTRAR_CURSO:{
			VentanaMostrarCurso.getInstance().update(evento, datos);
			VentanaBuscarCurso.getInstance().setVisible(false);
			VentanaMostrarCurso.getInstance().setVisible(true);
		}break;
		case EventoGUI.MODIFICAR_CURSO_CORRECTO:{
			VentanaModificarCurso.getInstance().update(evento, datos);
			VentanaBuscarCurso.getInstance().setVisible(false);
			VentanaModificarCurso.getInstance().setVisible(true);
		}break;
		case EventoGUI.BUSCAR_CURSO_ERROR:{
			JOptionPane.showMessageDialog(null, "El curso no existe en el sistema");
			
		}; break;
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
	public class ALVentanaBuscarCurso implements ActionListener{

		/* (sin Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == botonAtras){
				VentanaBuscarCurso.this.txtFieldID_Curso.setText("");				
				VentanaBuscarCurso.this.dispose();
				JPrincipalSMS.getInstance().setVisible(true);
			}
			
			if(event.getSource() == botonBuscarCurso){
				String stringID = "";
				stringID = txtFieldID_Curso.getText();
				//******* Obtencion de datos de la ventana ******
				try{
					if (!stringID.equalsIgnoreCase("")){
						TCurso tCurso = new TCurso(Integer.parseInt(stringID), null, 1);
						if(tipoEventoGUI == EventoGUI.BUSCA_CURSO_PARA_MODIFICAR){
							Controlador.getInstance().action(EventoNegocio.BUSCA_CURSO_MODIFICAR, tCurso);
						}else if (tipoEventoGUI == EventoGUI.BUSCAR_CURSO){
							Controlador.getInstance().action(EventoNegocio.BUSCAR_CURSO, tCurso);
						}
					txtFieldID_Curso.setText("");
					}else{
						JOptionPane.showMessageDialog(null, "Introduzca el ID_Curso");
						//Devolvemos el foco.
						txtFieldID_Curso.requestFocus();
					}
				}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Introduzca un ID valido");
					txtFieldID_Curso.setText("");
				}
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
	public class WLVentanaBuscarCurso implements WindowListener {

		/* (sin Javadoc)
		 * @see java.awt.event.WindowListener#windowActivated(java.awt.event.WindowEvent)
		 */
		@Override
		public void windowActivated(WindowEvent arg0) {
			// TODO Apéndice de método generado automáticamente
			
		}

		/* (sin Javadoc)
		 * @see java.awt.event.WindowListener#windowClosed(java.awt.event.WindowEvent)
		 */
		@Override
		public void windowClosed(WindowEvent arg0) {
		}

		/* (sin Javadoc)
		 * @see java.awt.event.WindowListener#windowClosing(java.awt.event.WindowEvent)
		 */
		@Override
		public void windowClosing(WindowEvent arg0) {
			// TODO Apéndice de método generado automáticamente
			JPrincipalSMS.getInstance().setVisible(true);
			VentanaBuscarCurso.this.dispose();
		}

		/* (sin Javadoc)
		 * @see java.awt.event.WindowListener#windowDeactivated(java.awt.event.WindowEvent)
		 */
		@Override
		public void windowDeactivated(WindowEvent arg0) {
			// TODO Apéndice de método generado automáticamente
			
		}

		/* (sin Javadoc)
		 * @see java.awt.event.WindowListener#windowDeiconified(java.awt.event.WindowEvent)
		 */
		@Override
		public void windowDeiconified(WindowEvent arg0) {
			// TODO Apéndice de método generado automáticamente
			
		}

		/* (sin Javadoc)
		 * @see java.awt.event.WindowListener#windowIconified(java.awt.event.WindowEvent)
		 */
		@Override
		public void windowIconified(WindowEvent arg0) {
			// TODO Apéndice de método generado automáticamente
			
		}

		/* (sin Javadoc)
		 * @see java.awt.event.WindowListener#windowOpened(java.awt.event.WindowEvent)
		 */
		@Override
		public void windowOpened(WindowEvent arg0) {
			// TODO Apéndice de método generado automáticamente
			
		}
	}

	/**
	 * @param buscaCursoParaModificar
	 */
	public void setTipoEventoGUI(int tipoEventoGUI) {
		this.tipoEventoGUI = tipoEventoGUI;		
	}



	/**
	 * 
	 */
	public void estadoVentanaInicial() {
		//txtFieldID_Curso.setText("");		
	}
}