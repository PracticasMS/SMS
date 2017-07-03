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
public class VentanaListarMatricualsConNcursos extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9134779943129310760L;
	
	private JPanel panelDatos;
	private JPanel panelBotones;
	
	private JLabel labelnumCursos;
	private JTextField txtFieldnumCursos;
	
	private JButton botonListarMatricula;
	private JButton botonAtras;
	private int tipoEventoGUI;

	private static VentanaListarMatricualsConNcursos uniqueInstance;
	
	public VentanaListarMatricualsConNcursos(){
		super("listar Matrícula con N cursos");
		
		create();
		
		agregarManejadoresDeEventos();
		
		setLocationRelativeTo(null);
		setResizable(false);
	}
	public static VentanaListarMatricualsConNcursos getInstance() {
		if(uniqueInstance == null){
			uniqueInstance = new VentanaListarMatricualsConNcursos();
		}
		
		return uniqueInstance;
	}
	
	private void create() {
		
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setSize(300, 300);
		this.setLayout(new GridLayout(2,1));
		
		labelnumCursos = new JLabel("Num cursos: ");
		txtFieldnumCursos = new  JTextField(10);
		
		botonListarMatricula = new JButton("Listar Matrícula");
		botonAtras = new JButton("Atras");
		
		panelDatos = new JPanel();
		panelBotones = new JPanel();
		
		
		panelDatos.add(labelnumCursos);
		panelDatos.add(txtFieldnumCursos);
		
		panelBotones.add(botonAtras);
		panelBotones.add(botonListarMatricula);
		
		this.add(panelDatos);
		this.add(panelBotones);
		setLocationRelativeTo(null);
		
		txtFieldnumCursos.setText("");
	
		pack();
		
	}
	private void agregarManejadoresDeEventos() {
		
		ALVentanaLisatrMatriculaConNCursos oyente = new ALVentanaLisatrMatriculaConNCursos();
		this.addWindowListener(new WLVentanaListarMatriculaConNCursos());
		botonListarMatricula.addActionListener(oyente);
		botonAtras.addActionListener(oyente);
		
	}
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void update(int evento, Object datos) {
		switch (evento){

		case EventoGUI.LISTAR_MATRICULA_NCURSOS_ERROR:{
			JOptionPane.showMessageDialog(null, "No hay matriculas con " + txtFieldnumCursos.getText() + " cursos");
			
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
	public class ALVentanaLisatrMatriculaConNCursos implements ActionListener{

		/* (sin Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == botonAtras){
				VentanaListarMatricualsConNcursos.this.txtFieldnumCursos.setText("");				
				VentanaListarMatricualsConNcursos.this.dispose();
				JPrincipalSMS.getInstance().setVisible(true);
			}
			
			if(event.getSource() == botonListarMatricula){
				String stringID = "";
				stringID = txtFieldnumCursos.getText();
				//******* Obtencion de datos de la ventana ******
				try{
					if (!stringID.equalsIgnoreCase("")){
						TMatricula miMatricula = new TMatricula();
						miMatricula.setNumCursos(Integer.parseInt(txtFieldnumCursos.getText()));
						
						Controlador.getInstance().action(EventoNegocio.LISTAR_MATRICULAS_NCURSOS, miMatricula);
					}else{
						JOptionPane.showMessageDialog(null, "Introduzca el numero de cursos");
						//Devolvemos el foco.
						txtFieldnumCursos.requestFocus();
					}
				}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Introduzca un numero valido");
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
	public class WLVentanaListarMatriculaConNCursos implements WindowListener {

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
			VentanaListarMatricualsConNcursos.this.dispose();
			txtFieldnumCursos.setText("");
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