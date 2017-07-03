/**
 * 
 */
package SMSDAO.Presentacion.Alumnos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.freixas.jcalendar.JCalendarCombo;

import SMSDAO.Negocio.Alumnos.TAlumno;
import SMSDAO.Negocio.Alumnos.TAlumnoFamNumerosa;
import SMSDAO.Negocio.Alumnos.TAlumnoNoFamNumerosa;
import SMSDAO.Presentacion.JPrincipal.EventoGUI;
import SMSDAO.Presentacion.JPrincipal.JPrincipalSMS;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VentanaMostrarAlumno extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6580105426314519285L;
	//DNI
	private JLabel labelDNI;
	private JTextField txtFieldDNI;
	//Nombre
	private JLabel labelNombre_Alumno;
	private JTextField txtFieldNombre_Alumno;
	//Apellidos
	private JLabel labelApellidos_Alumno;
	private JTextField txtFieldApellidos_Alumno;
	//Dirrecion
	private JLabel labelDireccion_Alumno;
	private JTextField txtFieldDireccion_Alumno;
	//Fecha de Nacimiento
	private JLabel labelFecha_Alumno;
	private JCalendarCombo calendarComboFecha_alumno;
	//private JTextField txtFieldFecha_Alumno;
	//Telefono
	private JLabel labelTelefono_Alumno;
	private JTextField txtFieldTelefono_Alumno;
	//Numero familia numerosa
	private JLabel labelFamNumerosa_Alumno;
	private JTextField txtFieldFamNumerosa_Alumno;
	//Numero familia no numerosa
	private JLabel labelFamNoNumerosa_Alumno;
	private JTextField txtFieldFamNoNumerosa_Alumno;
	
	//Botones
	private JButton botonAtras;
	
	private JPanel panelDatosArriba;
	private JPanel panelDatosAbajo;
	private JPanel panelDatosCentro;
	private JPanel panelBotones;
	private JPanel panelTipoAlumno;
	
	//Tipo alumno
	private JTextField txtFieldTipo_Alumno;
	private JLabel labelTipoAlumno;
	
	private static VentanaMostrarAlumno uniqueInstace;
	
	public static void main(String args[]) {
		VentanaMostrarAlumno.getInstance().setVisible(true);
	}
	
	public VentanaMostrarAlumno(){
		super("Mostrar Alumno");		
		create();
		agregarManejadoresDeEventos();
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	//Agregamos oyentes
	private void agregarManejadoresDeEventos() {
		addWindowListener(new WLVentanaMostrarAlumno());
		
		ALVentanaMostrarAlumno oyente = new ALVentanaMostrarAlumno();
		botonAtras.addActionListener(oyente);	
	}
	
	private void create() {
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setSize(300, 300);
		this.setLayout(new BorderLayout());
		//ID
		labelDNI = new JLabel("ID_Alumno: ");
		txtFieldDNI = new JTextField(9);
		txtFieldDNI.setEnabled(false);
		//Nombre
		labelNombre_Alumno = new JLabel("Nombre: ");
		txtFieldNombre_Alumno = new JTextField(9);
		txtFieldNombre_Alumno.setEnabled(false);
		//Apellidos
		labelApellidos_Alumno= new JLabel("Apellidos: ");
		txtFieldApellidos_Alumno = new JTextField(15);
		txtFieldApellidos_Alumno.setEnabled(false);
		//Direccion
		labelDireccion_Alumno = new JLabel("Dirección: ");
		txtFieldDireccion_Alumno = new JTextField(15);
		txtFieldDireccion_Alumno.setEnabled(false);
		//Fecha de Nacimiento
		labelFecha_Alumno = new JLabel("Fecha: ");
		calendarComboFecha_alumno = new JCalendarCombo();
		calendarComboFecha_alumno.setEnabled(false);
		//Telefono
		labelTelefono_Alumno = new JLabel("Teléfono: ");
		txtFieldTelefono_Alumno = new JTextField(9);
		txtFieldTelefono_Alumno.setEnabled(false);
		//Num. Familia Numerosa
		labelFamNumerosa_Alumno = new JLabel("Nº Familia Numerosa: ");
		txtFieldFamNumerosa_Alumno = new JTextField(10);
		txtFieldFamNumerosa_Alumno.setEnabled(false);
		//Num. Seguridad Social
		labelFamNoNumerosa_Alumno = new JLabel("Nº Seguridad Social: ");
		txtFieldFamNoNumerosa_Alumno = new JTextField(10);
		txtFieldFamNoNumerosa_Alumno.setEnabled(false);
		//Num. Seguridad Social
		labelTipoAlumno = new JLabel("Tipo Alumno ");
		txtFieldTipo_Alumno = new JTextField(15);
		txtFieldTipo_Alumno.setEnabled(false);

		panelTipoAlumno = new JPanel();
		panelTipoAlumno.add(labelTipoAlumno);
		panelTipoAlumno.add(txtFieldTipo_Alumno);
		panelTipoAlumno.add(labelApellidos_Alumno);
		
		panelDatosArriba = new JPanel();
		panelDatosArriba.setLayout(new FlowLayout());
		panelDatosAbajo = new JPanel();
		panelDatosAbajo.setLayout(new FlowLayout());
		panelBotones = new JPanel();
				
		panelDatosArriba.add(labelDNI);
		panelDatosArriba.add(txtFieldDNI);
		panelDatosArriba.add(labelNombre_Alumno);
		panelDatosArriba.add(txtFieldNombre_Alumno);
		panelDatosArriba.add(labelApellidos_Alumno);
		panelDatosArriba.add(txtFieldApellidos_Alumno);
		panelDatosArriba.add(labelDireccion_Alumno);
		panelDatosArriba.add(txtFieldDireccion_Alumno);
		
		panelDatosAbajo.add(labelFecha_Alumno);
		panelDatosAbajo.add(calendarComboFecha_alumno);
		panelDatosAbajo.add(labelTelefono_Alumno);
		panelDatosAbajo.add(txtFieldTelefono_Alumno);
		
		labelFamNoNumerosa_Alumno.setVisible(false);
		txtFieldFamNoNumerosa_Alumno.setVisible(false);
		
		panelDatosAbajo.add(labelFamNumerosa_Alumno);
		panelDatosAbajo.add(txtFieldFamNumerosa_Alumno);
		panelDatosAbajo.add(labelFamNoNumerosa_Alumno);
		panelDatosAbajo.add(txtFieldFamNoNumerosa_Alumno);
		
		botonAtras = new JButton("Atras");
		panelBotones.add(botonAtras);
		
		panelDatosCentro = new JPanel();
		panelDatosCentro.setLayout(new BorderLayout());
		panelDatosCentro.add(panelDatosArriba, BorderLayout.NORTH);
		panelDatosCentro.add(panelDatosAbajo, BorderLayout.SOUTH);
		
		this.add(panelTipoAlumno, BorderLayout.NORTH);
		this.add(panelDatosCentro, BorderLayout.CENTER);
		this.add(panelBotones, BorderLayout.SOUTH);
		setLocationRelativeTo(null);
		
		pack();		
	}

	public static VentanaMostrarAlumno getInstance() {
		// begin-user-code
		if(uniqueInstace == null){
			uniqueInstace = new VentanaMostrarAlumno();
		}
		return uniqueInstace;
		// end-user-code
	}

	public void update(int evento, Object datos) {
		// begin-user-code
		TAlumno tAlumno = (TAlumno) datos;
		switch (evento) {
		case (EventoGUI.MOSTRAR_ALUMNO):{
			
			int DNI = tAlumno.getDni();
			String stringDNI = Integer.toString(DNI);
			txtFieldDNI.setText(letraDNI(tAlumno.getDni()));
			//Nombre
			txtFieldNombre_Alumno.setText(tAlumno.getNombre());
			//Apellidos
			txtFieldApellidos_Alumno.setText(tAlumno.getApellidos());
			//Direccion
			txtFieldDireccion_Alumno.setText(tAlumno.getDireccion());
			//Fecha
			try{
			String stringFecha = tAlumno.getFecha_Nacimiento();
			calendarComboFecha_alumno.setDate(new SimpleDateFormat("yyyy-mm-dd").parse(stringFecha));	
			}
			catch (ParseException e){
				
				JOptionPane.showMessageDialog(null, "Error al parsear la fecha");
				
			}
			//Telefono
			txtFieldTelefono_Alumno.setText(Integer.toString(tAlumno.getTelefono()));
			
			if(datos instanceof TAlumnoFamNumerosa){

				txtFieldTipo_Alumno.setText("Nº FAMILIA NUMEROSA");
				txtFieldTipo_Alumno.setEnabled(false);

				 
				TAlumnoFamNumerosa mialumno = (TAlumnoFamNumerosa) datos;
				txtFieldFamNumerosa_Alumno.setText(Integer.toString(mialumno.getNum_fam()));

				labelFamNumerosa_Alumno.setVisible(true);
				txtFieldFamNumerosa_Alumno.setVisible(true);
				
				
				labelFamNoNumerosa_Alumno.setVisible(false);
				txtFieldFamNoNumerosa_Alumno.setVisible(false);
				
			}else if (datos instanceof TAlumnoNoFamNumerosa){

				txtFieldTipo_Alumno.setText("Nº SEGURIDAD SOCIAL");
				txtFieldTipo_Alumno.setEnabled(false);
				
				TAlumnoNoFamNumerosa miAlumno = (TAlumnoNoFamNumerosa) datos;
				txtFieldFamNoNumerosa_Alumno.setText(Integer.toString(miAlumno.getNum_seg_social()));
				
				labelFamNumerosa_Alumno.setVisible(false);
				txtFieldFamNumerosa_Alumno.setVisible(false);

				labelFamNoNumerosa_Alumno.setVisible(true);
				txtFieldFamNoNumerosa_Alumno.setVisible(true);
			}
			
			txtFieldDNI.requestFocus();
			this.setVisible(true);
			
		}break;
		
		case (EventoGUI.ALUMNO_INEXISTENTE_O_CON_MATRICULA_VIGENTE):{
			JOptionPane.showMessageDialog(null, "ERROR: el alumno no existe");
			txtFieldDNI.requestFocus();
			
		}break;
		
	}
		// end-user-code
	}
	

	  
	  /**
	   * Devuelve un NIF completo a partir de un DNI. Es decir, añade la letra del NIF
	   * @param dni dni al que se quiere añadir la letra del NIF
	   * @return NIF completo.
	   */
	  public static String letraDNI(int dni) {
		  String NIF_STRING_ASOCIATION = "TRWAGMYFPDXBNJZSQVHLCKE";
	    return String.valueOf(dni) + NIF_STRING_ASOCIATION.charAt(dni % 23);
	  }
	
	//ACTION LISTENER
	
	public class ALVentanaMostrarAlumno implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			
			if(event.getSource() == botonAtras){
				VentanaMostrarAlumno.this.dispose();
				VentanaBuscarAlumno.getInstance().setVisible(true);
				
			}
		}
	}
	
	//WINDOW LISTENER
	
	public class WLVentanaMostrarAlumno implements WindowListener {

		public void windowOpened(WindowEvent arg0) {
		}

		public void windowClosing(WindowEvent arg0) {
			JPrincipalSMS.getInstance().setVisible(true);
			VentanaMostrarAlumno.this.dispose();
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