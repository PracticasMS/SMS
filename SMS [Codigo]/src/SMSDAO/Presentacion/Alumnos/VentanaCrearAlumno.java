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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.freixas.jcalendar.JCalendarCombo;

import SMSDAO.Negocio.Alumnos.TAlumno;
import SMSDAO.Negocio.Alumnos.TAlumnoFamNumerosa;
import SMSDAO.Negocio.Alumnos.TAlumnoNoFamNumerosa;
import SMSDAO.Presentacion.Controlador.Controlador;
import SMSDAO.Presentacion.JPrincipal.EventoGUI;
import SMSDAO.Presentacion.JPrincipal.EventoNegocio;
import SMSDAO.Presentacion.JPrincipal.JPrincipalSMS;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Tomas
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VentanaCrearAlumno extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 90512047975121398L;
	private static VentanaCrearAlumno uniqueInstance;
	// ID
	private JLabel labelDNI;
	private JTextField txtFieldDNI;
	// Nombre
	private JLabel labelNombre_Alumno;
	private JTextField txtFieldNombre_Alumno;
	// Apellidos
	private JLabel labelApellidos_Alumno;
	private JTextField txtFieldApellidos_Alumno;
	// Dirrecion
	private JLabel labelDireccion_Alumno;
	private JTextField txtFieldDireccion_Alumno;
	// Fecha de Nacimiento
	private JLabel labelFecha_Alumno;
	private JCalendarCombo calendarComboFecha_alumno;
	// private JTextField txtFieldFecha_Alumno;
	// Telefono
	private JLabel labelTelefono_Alumno;
	private JTextField txtFieldTelefono_Alumno;
	// Numero familia numerosa
	private JLabel labelFamNumerosa_Alumno;
	private JTextField txtFieldFamNumerosa_Alumno;
	// Numero familia no numerosa
	private JLabel labelFamNoNumerosa_Alumno;
	private JTextField txtFieldFamNoNumerosa_Alumno;

	// Botones
	private JButton botonCrear;
	private JButton botonAtras;

	private JPanel panelDatosArriba;
	private JPanel panelDatosAbajo;
	private JPanel panelDatosCentro;
	private JPanel panelBotones;
	private JPanel panelTipoAlumno;

	private JLabel labelTipoAlumno;
	private JComboBox comboBox_TipoAlumno;

	public static void main(String args[]) {
		VentanaCrearAlumno.getInstance().setVisible(true);
	}

	public VentanaCrearAlumno() {
		super("Crear Alumno");
		create();
		agregarManejadoresDeEventos();
		setLocationRelativeTo(null);
		setResizable(false);
	}

	// Agregamos oyentes
	private void agregarManejadoresDeEventos() {
		addWindowListener(new WLVentanaCrearAlumno());

		ALVentanaCrearAlumno oyente = new ALVentanaCrearAlumno();
		comboBox_TipoAlumno.addActionListener(oyente);
		botonCrear.addActionListener(oyente);
		botonAtras.addActionListener(oyente);
	}

	private void create() {
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setSize(300, 300);
		this.setLayout(new BorderLayout());
		// DNI
		labelDNI = new JLabel("DNI: ");
		txtFieldDNI = new JTextField(8);
		// Nombre
		labelNombre_Alumno = new JLabel("Nombre: ");
		txtFieldNombre_Alumno = new JTextField(9);
		// Apellidos
		labelApellidos_Alumno = new JLabel("Apellidos: ");
		txtFieldApellidos_Alumno = new JTextField(15);
		// Direccion
		labelDireccion_Alumno = new JLabel("Dirección: ");
		txtFieldDireccion_Alumno = new JTextField(15);
		// Fecha de Nacimiento
		labelFecha_Alumno = new JLabel("Fecha Nacimiento: ");
		calendarComboFecha_alumno = new JCalendarCombo();
		// Telefono
		labelTelefono_Alumno = new JLabel("Teléfono: ");
		txtFieldTelefono_Alumno = new JTextField(9);
		// Num. Familia Numerosa
		labelFamNumerosa_Alumno = new JLabel("Nº Familia Numerosa: ");
		txtFieldFamNumerosa_Alumno = new JTextField(10);
		// Num. Seguridad Social
		labelFamNoNumerosa_Alumno = new JLabel("Nº Seguridad Social: ");
		txtFieldFamNoNumerosa_Alumno = new JTextField(10);

		labelTipoAlumno = new JLabel("Tipo Alumno ");
		Vector<String> items = new Vector<String>();
		items.add("Nº FAMILIA NUMEROSA");
		items.add("Nº SEGURIDAD SOCIAL");
		comboBox_TipoAlumno = new JComboBox(items);

		panelTipoAlumno = new JPanel();
		panelTipoAlumno.add(labelTipoAlumno);
		panelTipoAlumno.add(comboBox_TipoAlumno);

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

		botonCrear = new JButton("Crear");
		botonAtras = new JButton("Atras");
		
		panelBotones.add(botonAtras);
		panelBotones.add(botonCrear);

		panelDatosCentro = new JPanel();
		panelDatosCentro.setLayout(new BorderLayout());
		panelDatosCentro.add(panelDatosArriba, BorderLayout.NORTH);
		panelDatosCentro.add(panelDatosAbajo, BorderLayout.SOUTH);

		this.add(panelTipoAlumno, BorderLayout.NORTH);
		this.add(panelDatosCentro, BorderLayout.CENTER);
		this.add(panelBotones, BorderLayout.SOUTH);
		setLocationRelativeTo(null);

		// Inicializamos la vista.
		txtFieldDNI.setText("");
		txtFieldDNI.requestFocus();

		pack();
	}

	public static VentanaCrearAlumno getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new VentanaCrearAlumno();
		}
		return uniqueInstance;
	}
	
	private void limpiarCampos(){
		
		txtFieldDNI.setText("");
		txtFieldNombre_Alumno.setText("");
		txtFieldApellidos_Alumno.setText("");
		txtFieldDireccion_Alumno.setText("");
		txtFieldFamNoNumerosa_Alumno.setText("");
		txtFieldFamNumerosa_Alumno.setText("");
		txtFieldTelefono_Alumno.setText("");
		
		
	}

	public void update(int eventoGUI, Object datos) {
		switch (eventoGUI) {
		case (EventoGUI.ALUMNO_CREADO): {
			Integer DNI = (Integer) datos;

			JOptionPane.showMessageDialog(null,
					"Alumno con [ DNI: " + DNI.intValue() + " ] Creado.");
			// DNI
			txtFieldDNI.setText("");
			// Nombre
			txtFieldNombre_Alumno.setText("");
			// Apellidos
			txtFieldApellidos_Alumno.setText("");
			// Dirrecion
			txtFieldDireccion_Alumno.setText("");
			// Telefono
			txtFieldTelefono_Alumno.setText("");
			// Numero familia numerosa
			txtFieldFamNumerosa_Alumno.setText("");
			// Numero familia no numerosa
			txtFieldFamNoNumerosa_Alumno.setText("");
			// Coloco de nuevo el dato de hoy.
			calendarComboFecha_alumno.setDate(new Date());
			
			//Mandamos el foco al primer campo.
			txtFieldDNI.requestFocus();
		}
			break;
		case (EventoGUI.ALUMNO_CREAR_ERROR): {
			JOptionPane.showMessageDialog(null,
					"El alumno ya existe en la BBDD");
		}
		case (EventoGUI.ALUMNO_CREAR_ERROR_DNI): {
			JOptionPane.showMessageDialog(null,
				"Ya existe un alumno registrado con ese DNI.");
				txtFieldDNI.requestFocus();
		}
			break;
		}
	}

	// ****************************************************//
	// ***************** Action Listener ******************//
	// ****************************************************//

	public class ALVentanaCrearAlumno implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {

			if (event.getSource() == botonAtras) {
				
				limpiarCampos();
				VentanaCrearAlumno.this.dispose();
				JPrincipalSMS.getInstance().setVisible(true);
			}

			if (event.getSource() == comboBox_TipoAlumno) {

				if (comboBox_TipoAlumno.getSelectedItem().equals(
						"Nº SEGURIDAD SOCIAL")) {

					labelFamNumerosa_Alumno.setVisible(false);
					txtFieldFamNumerosa_Alumno.setVisible(false);
					txtFieldFamNumerosa_Alumno.setText("");

					labelFamNoNumerosa_Alumno.setVisible(true);
					txtFieldFamNoNumerosa_Alumno.setVisible(true);

				} else if (comboBox_TipoAlumno.getSelectedItem().equals(
						"Nº FAMILIA NUMEROSA")) {

					labelFamNoNumerosa_Alumno.setVisible(false);
					txtFieldFamNoNumerosa_Alumno.setVisible(false);
					txtFieldFamNoNumerosa_Alumno.setText("");

					labelFamNumerosa_Alumno.setVisible(true);
					txtFieldFamNumerosa_Alumno.setVisible(true);
				}
			}
			if (event.getSource() == botonCrear) {
				
				try{
				// ******* Obtencion de datos de la ventana ******
				// DNI
				String stringDNI = "";
				stringDNI = txtFieldDNI.getText();
				// Nombre
				String stringNombreAlumno = "";
				stringNombreAlumno = txtFieldNombre_Alumno.getText();
				// Apellidos
				String stringApellidosAlumno = txtFieldApellidos_Alumno
						.getText();
				// Direccion
				String stringDireccionAlumno = txtFieldDireccion_Alumno
						.getText();
				// Fecha

				Date fechaEscogida = calendarComboFecha_alumno.getDate();
				String stringFecha = new SimpleDateFormat("yyyy/MM/dd")
						.format(fechaEscogida);

				// Telefono
				String stringTelefonoAlumno = txtFieldTelefono_Alumno.getText();

				// Especialidades.
				String stringFamNoNumerosa = "";
				String stringFamNumerosa = "";

				// FALTA POR AÑADIR LOS CONTROLES DE LAS ESPECIALIDADES DE
				// ALUMNO
				if (!stringDNI.equalsIgnoreCase("")
						&& !stringNombreAlumno.equalsIgnoreCase("")
						&& !stringApellidosAlumno.equalsIgnoreCase("")
						&& !stringDireccionAlumno.equalsIgnoreCase("")
						&& !stringFecha.equalsIgnoreCase("")
						&& !stringTelefonoAlumno.equalsIgnoreCase("")) {
					int telefono_Alumno = Integer
							.parseInt(stringTelefonoAlumno);

					// Comprobamos que ha introducido bien la especialidad.
					if (comboBox_TipoAlumno.getSelectedItem().equals(
							"Nº SEGURIDAD SOCIAL")) {
						stringFamNoNumerosa = txtFieldFamNoNumerosa_Alumno
								.getText();
						if (stringFamNoNumerosa.equalsIgnoreCase("")) {
							JOptionPane.showMessageDialog(null,
									"Introduce Num seguridad social");
							txtFieldFamNoNumerosa_Alumno.requestFocus();
						} else {
							TAlumno tAlumno = new TAlumnoNoFamNumerosa(Integer.parseInt(stringDNI),
									stringNombreAlumno, stringApellidosAlumno,
									stringDireccionAlumno, stringFecha,
									telefono_Alumno, 1,
									Integer.parseInt(stringFamNoNumerosa));
							Controlador.getInstance().action(
									EventoNegocio.CREAR_ALUMNO, tAlumno);
						}

					} else if (comboBox_TipoAlumno.getSelectedItem().equals(
							"Nº FAMILIA NUMEROSA")) {
						stringFamNumerosa = txtFieldFamNumerosa_Alumno
								.getText();
						if (stringFamNumerosa.equalsIgnoreCase("")) {
							JOptionPane.showMessageDialog(null,
									"Introduce Num familia numerosa");
							txtFieldFamNumerosa_Alumno.requestFocus();
						} else {
							try{
							TAlumno tAlumno = new TAlumnoFamNumerosa(Integer.parseInt(stringDNI),
									stringNombreAlumno, stringApellidosAlumno,
									stringDireccionAlumno, stringFecha,
									telefono_Alumno, 1,
									Integer.parseInt(stringFamNumerosa));
							Controlador.getInstance().action( EventoNegocio.CREAR_ALUMNO, tAlumno);
							}catch (NumberFormatException e) {
								JOptionPane.showMessageDialog(null, "Introduzca el DNI o el Numero Familia Numerosa del alumno correctamente");
							}
						}
					}
				} else if (stringDNI.equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null,
							"Introduzca el DNI del alumno");
					txtFieldDNI.requestFocus();
				} else if (stringNombreAlumno.equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null,
							"Introduzca el NOMBRE del alumno");
					txtFieldNombre_Alumno.requestFocus();
				} else if (stringApellidosAlumno.equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null,
							"Introduzca los APELLIDOS del alumno");
					txtFieldApellidos_Alumno.requestFocus();
				} else if (stringDireccionAlumno.equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null,
							"Introduzca la DIRECCIÓN del alumno");
					txtFieldDireccion_Alumno.requestFocus();
				} else if (stringFecha.equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null,
							"Introduzca su Fecha de Nacimiento");
					calendarComboFecha_alumno.requestFocus();
				} else if (stringTelefonoAlumno.equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null,
							"Introduzca el TELÉFONO del alumno");
					txtFieldTelefono_Alumno.requestFocus();
				} else {
					JOptionPane.showMessageDialog(null,
							"Faltan campos por rellenar");
					// Devolvemos el foco.
					txtFieldDNI.requestFocus();
				}
				
				
				} catch (NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Introduzca datos correctamente");
				}
						
			}
		}
	}

	// ****************************************************//
	// ***************** Window Listener ******************//
	// ****************************************************//
	public class WLVentanaCrearAlumno implements WindowListener {

		public void windowOpened(WindowEvent arg0) {
			txtFieldDNI.requestFocus();
		}

		public void windowClosing(WindowEvent arg0) {
			limpiarCampos();
			VentanaCrearAlumno.this.dispose();
			JPrincipalSMS.getInstance().setVisible(true);
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