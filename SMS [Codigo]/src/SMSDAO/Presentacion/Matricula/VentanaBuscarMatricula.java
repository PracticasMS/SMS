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
 * @author Tomas
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VentanaBuscarMatricula extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9134779943129310760L;
	
	private JPanel panelDatos;
	private JPanel panelBotones;
	
	private JLabel labelID_Matriucla;
	private JTextField txtFieldID_Matricula;
	
	private JButton botonBuscarMatricula;
	private JButton botonAtras;
	private int tipoEventoGUI;

	private static VentanaBuscarMatricula uniqueInstance;
	
	public VentanaBuscarMatricula(){
		super("Buscar Matrícula");
		
		create();
		
		agregarManejadoresDeEventos();
		
		setLocationRelativeTo(null);
		setResizable(false);
	}
	public static VentanaBuscarMatricula getInstance() {
		if(uniqueInstance == null){
			uniqueInstance = new VentanaBuscarMatricula();
		}
		
		return uniqueInstance;
	}
	
	private void create() {
		
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setSize(300, 300);
		this.setLayout(new GridLayout(2,1));
		
		labelID_Matriucla = new JLabel("ID_Matrícula: ");
		txtFieldID_Matricula = new  JTextField(10);
		
		botonBuscarMatricula = new JButton("Buscar Matrícula");
		botonAtras = new JButton("Atras");
		
		panelDatos = new JPanel();
		panelBotones = new JPanel();
		
		
		panelDatos.add(labelID_Matriucla);
		panelDatos.add(txtFieldID_Matricula);
		
		panelBotones.add(botonAtras);
		panelBotones.add(botonBuscarMatricula);
		
		this.add(panelDatos);
		this.add(panelBotones);
		setLocationRelativeTo(null);
	
		pack();
		
	}
	private void agregarManejadoresDeEventos() {
		
		ALVentanaBuscarMatricula oyente = new ALVentanaBuscarMatricula();
		this.addWindowListener(new WLVentanaBuscarMatricula());
		botonBuscarMatricula.addActionListener(oyente);
		botonAtras.addActionListener(oyente);
		
	}
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void update(int evento, Object datos) {
		switch (evento){

		case EventoGUI.BUSCAR_MATRICULA_ERROR:{
			JOptionPane.showMessageDialog(null, "La matrícula no existe en el sistema");
			
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
	public class ALVentanaBuscarMatricula implements ActionListener{

		/* (sin Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == botonAtras){
				VentanaBuscarMatricula.this.txtFieldID_Matricula.setText("");				
				VentanaBuscarMatricula.this.dispose();
				JPrincipalSMS.getInstance().setVisible(true);
			}
			
			if(event.getSource() == botonBuscarMatricula){
				String stringID = "";
				stringID = txtFieldID_Matricula.getText();
				//******* Obtencion de datos de la ventana ******
				try{
					if (!stringID.equalsIgnoreCase("")){
						TMatricula miMatricula = new TMatricula(Integer.parseInt(stringID));
						if(tipoEventoGUI == EventoGUI.BUSCA_MATRICULA_PARA_MODIFICAR){
							Controlador.getInstance().action(EventoNegocio.BUSCA_MATRICULA_MODIFICAR, miMatricula);
						}else if (tipoEventoGUI == EventoGUI.BUSCAR_MATRICULA){
							Controlador.getInstance().action(EventoNegocio.BUSCAR_MATRICULA, miMatricula);
						}
					}else{
						JOptionPane.showMessageDialog(null, "Introduzca el ID_Matricula");
						//Devolvemos el foco.
						txtFieldID_Matricula.requestFocus();
					}
				}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Introduzca un ID valido");
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
	public class WLVentanaBuscarMatricula implements WindowListener {

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
			VentanaBuscarMatricula.this.dispose();
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