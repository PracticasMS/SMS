package SMSDAO.Presentacion.Alumnos;

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

import SMSDAO.Negocio.Alumnos.TAlumno;
import SMSDAO.Presentacion.Controlador.Controlador;
import SMSDAO.Presentacion.JPrincipal.EventoGUI;
import SMSDAO.Presentacion.JPrincipal.EventoNegocio;
import SMSDAO.Presentacion.JPrincipal.JPrincipalSMS;

public class VentanaBuscarAlumno extends JFrame{
	private static final long serialVersionUID = -9134779943129310760L;
	
	private JPanel panelDatos;
	private JPanel panelBotones;
	
	private JLabel labelDNI;
	private JTextField txtFieldDNI;
	
	private JButton botonBuscarAlumno;
	private JButton botonAtras;
	private int tipoEventoGUI;

	private static VentanaBuscarAlumno uniqueInstance;
	
	public VentanaBuscarAlumno(){
		super("Buscar Alumno");
		
		create();
		
		agregarManejadoresDeEventos();
		
		setLocationRelativeTo(null);
		setResizable(false);
	}
	//Metodo principal
	public static void main(String args[]) {
		VentanaBuscarAlumno.getInstance().setVisible(true);
	}
	public static VentanaBuscarAlumno getInstance() {
		if(uniqueInstance == null){
			uniqueInstance = new VentanaBuscarAlumno();
		}
		
		return uniqueInstance;
	}
	
	private void create() {
		
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setSize(300, 300);
		this.setLayout(new GridLayout(2,1));
		
		labelDNI = new JLabel("DNI: ");
		txtFieldDNI = new  JTextField(10);
		
		
		botonBuscarAlumno = new JButton("Buscar Alumno");
		botonAtras = new JButton("Atras");
		
		panelDatos = new JPanel();
		panelBotones = new JPanel();
		
		
		panelDatos.add(labelDNI);
		panelDatos.add(txtFieldDNI);
		
		panelBotones.add(botonAtras);
		panelBotones.add(botonBuscarAlumno);
		
		this.add(panelDatos);
		this.add(panelBotones);
		setLocationRelativeTo(null);
	
		pack();
		
	}
	private void agregarManejadoresDeEventos() {
		
		ALVentanaBuscarAlumno oyente = new ALVentanaBuscarAlumno();
		this.addWindowListener(new WLVentanaBuscarAlumno());
		botonBuscarAlumno.addActionListener(oyente);
		botonAtras.addActionListener(oyente);
		
	}
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void update(int evento, Object datos) {
		switch (evento){

		case EventoGUI.BUSCAR_ALUMNO_ERROR:{
			JOptionPane.showMessageDialog(null, "El alumno no existe en el sistema");
			
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
	public class ALVentanaBuscarAlumno implements ActionListener{

		/* (sin Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == botonAtras){
				VentanaBuscarAlumno.this.txtFieldDNI.setText("");				
				VentanaBuscarAlumno.this.dispose();
				JPrincipalSMS.getInstance().setVisible(true);
			}
			
			if(event.getSource() == botonBuscarAlumno){
				String stringID = "";
				stringID = txtFieldDNI.getText();
				//******* Obtencion de datos de la ventana ******
				try{
					if (!stringID.equalsIgnoreCase("")){
						TAlumno tAlumno = new TAlumno(Integer.parseInt(stringID));
						if(tipoEventoGUI == EventoGUI.BUSCA_ALUMNO_PARA_MODIFICAR){
							Controlador.getInstance().action(EventoNegocio.BUSCA_ALUMNO_MODIFICAR, tAlumno);
						}else if (tipoEventoGUI == EventoGUI.BUSCAR_ALUMNO){
							Controlador.getInstance().action(EventoNegocio.BUSCAR_ALUMNO, tAlumno);
						}
					txtFieldDNI.setText("");	
					}else{
						JOptionPane.showMessageDialog(null, "Introduzca el ID_Alumno");
						//Devolvemos el foco.
						txtFieldDNI.requestFocus();
						txtFieldDNI.setText("");	
					}
				}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Introduzca un ID valido");
					txtFieldDNI.setText("");	
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
	public class WLVentanaBuscarAlumno implements WindowListener {

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
			VentanaBuscarAlumno.this.dispose();
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
