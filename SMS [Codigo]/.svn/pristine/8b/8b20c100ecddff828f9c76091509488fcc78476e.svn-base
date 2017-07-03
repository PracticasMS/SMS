/**
 * @ProjectName SMSProg
 */
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
import SMSDAO.Presentacion.JPrincipal.EventoNegocio;
import SMSDAO.Presentacion.JPrincipal.JPrincipalSMS;

/**
 * @Project_Name SMSProg
 * @Author Rodrigo de Miguel González
 * @Date 06/12/2015
 * @File_Name VentanaBuscarAlumnosConNMatricEnMAños.java
 */
public class VentanaListarAlumnosConNMatricEnMAños extends JFrame {
	
	
	
	private JPanel panelDatos;
	private JPanel panelBotones;
	
	private JLabel labelNMatriculas;
	private JTextField txtFieldNMatriculas;
	
	private JLabel labelMAnos;
	private JTextField txtFieldMAnos;
	
	private JButton botonListarAlumnos;
	private JButton botonAtras;
	private int tipoEventoGUI;
	
	private int numAnos;
	private int numMatriculas;

	private static VentanaListarAlumnosConNMatricEnMAños uniqueInstance;
	
	public VentanaListarAlumnosConNMatricEnMAños(){
		super("Buscar Alumno con N matroculas en M años");
		
		create();
		
		agregarManejadoresDeEventos();
		
		setLocationRelativeTo(null);
		setResizable(false);
	}
	//Metodo principal
	public static void main(String args[]) {
		VentanaListarAlumnosConNMatricEnMAños.getInstance().setVisible(true);
	}
	
	
	
	public static VentanaListarAlumnosConNMatricEnMAños getInstance() {
		if(uniqueInstance == null){
			uniqueInstance = new VentanaListarAlumnosConNMatricEnMAños();
		}
		
		return uniqueInstance;
	}
	
	private void create() {
		
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setSize(300, 300);
		this.setLayout(new GridLayout(2,1));
		
		labelNMatriculas = new JLabel("Matriculas: ");
		txtFieldNMatriculas = new  JTextField(3);
		
		labelMAnos = new JLabel("Años: ");
		txtFieldMAnos = new  JTextField(3);
		
		botonListarAlumnos = new JButton("Listar Alumnos");
		botonAtras = new JButton("Atras");
		
		panelDatos = new JPanel();
		panelBotones = new JPanel();
		
		
		panelDatos.add(labelNMatriculas);
		panelDatos.add(txtFieldNMatriculas);
		
		panelDatos.add(labelMAnos);
		panelDatos.add(txtFieldMAnos);
		
		panelBotones.add(botonAtras);
		panelBotones.add(botonListarAlumnos);
		
		this.add(panelDatos);
		this.add(panelBotones);
		setLocationRelativeTo(null);
	
		pack();
		
	}
	private void agregarManejadoresDeEventos() {
		
		ALVentanaListarAlumnos oyente = new ALVentanaListarAlumnos();
		this.addWindowListener(new WLVentanaListarAlumnos());
		botonListarAlumnos.addActionListener(oyente);
		botonAtras.addActionListener(oyente);
		
	}

	
	public void update(int evento, Object datos) {
//		switch (evento){
//
//		case EventoGUI.BUSCAR_ALUMNO_ERROR:{
//			JOptionPane.showMessageDialog(null, "El alumno no existe en el sistema");
//			
//		}; break;
//		}
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
	public class ALVentanaListarAlumnos implements ActionListener{



		/* (sin Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == botonAtras){
				VentanaListarAlumnosConNMatricEnMAños.this.txtFieldNMatriculas.setText("");				
				VentanaListarAlumnosConNMatricEnMAños.this.dispose();
				JPrincipalSMS.getInstance().setVisible(true);
				estadoVentanaInicial();
			}
			
			if(event.getSource() == botonListarAlumnos){
				
				//******* Obtencion de datos de la ventana ******
				try{
					
					if (!txtFieldMAnos.getText().equalsIgnoreCase("")){
						if(!txtFieldNMatriculas.getText().equalsIgnoreCase("")){
							numAnos = Integer.parseInt(txtFieldMAnos.getText());
							numMatriculas = Integer.parseInt(txtFieldNMatriculas.getText());
							
							TAlumno datos = new TAlumno(numMatriculas, numAnos);
							
							
							Controlador.getInstance().action(EventoNegocio.LISTAR_ALUMNOS_NMATRICULAS_MAÑOS, datos);
							
						}else{
							JOptionPane.showMessageDialog(null, "Introduzca el numero de matrículas.");
							//Devolvemos el foco.
							txtFieldNMatriculas.requestFocus();
						}
					}else{
						JOptionPane.showMessageDialog(null, "Introduzca el numero de años.");
						//Devolvemos el foco.
						txtFieldNMatriculas.requestFocus();
					}
				}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Introduzca valor correcto");
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
	public class WLVentanaListarAlumnos implements WindowListener {

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
			VentanaListarAlumnosConNMatricEnMAños.this.dispose();
			estadoVentanaInicial();
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
	
	
	public void estadoVentanaInicial() {
		txtFieldMAnos.setText("");
		txtFieldNMatriculas.setText("");
	}
	
	
	public ParElementos getParDatos(){
		return new ParElementos(numMatriculas, numAnos);
	}

	
	public class ParElementos{
		private int numMatricualas;
		private int numAnos;
		
		
		
		/**
		 * @param n
		 * @param m
		 */
		public ParElementos(int numMatricuals, int numAnos) {
			this.numMatricualas = numMatricuals;
			this.numAnos = numAnos;
		}
		/**
		 * @return el n
		 */
		public int getNumMatricuals() {
			return numMatricualas;
		}
		/**
		 * @param n el n a establecer
		 */
		public void setNumMatricualas(int numMatricualas) {
			this.numMatricualas = numMatricualas;
		}
		/**
		 * @return el m
		 */
		public int getNumAnos() {
			return numAnos;
		}
		/**
		 * @param m el m a establecer
		 */
		public void setNumAnos(int numAnos) {
			this.numAnos = numAnos;
		}
		
		
	}

}


