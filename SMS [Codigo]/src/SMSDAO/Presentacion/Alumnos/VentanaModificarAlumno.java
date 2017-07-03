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
public class VentanaModificarAlumno extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3941880832528278607L;

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
	private JButton botonAtras;
	private JButton botonModificarAlumno;

	private JPanel panelDatosArriba;
	private JPanel panelDatosAbajo;
	private JPanel panelDatosCentro;
	private JPanel panelBotones;
	private JPanel panelTipoAlumno;

	private JLabel labelTipoAlumno;
	private JComboBox comboBox_TipoAlumno;

	private static VentanaModificarAlumno uniqueInstance;

	// Metodo principal
	public static void main(String args[]) {
		VentanaModificarAlumno.getInstance().setVisible(true);
	}

	// Constructor
	public VentanaModificarAlumno() {
		super("Modificar Alumno");
		create();
		agregarManejadoresDeEventos();
		setLocationRelativeTo(null);
		setResizable(false);
	}

	// Agregamos oyentes
	private void agregarManejadoresDeEventos() {
		addWindowListener(new WLVentanaModificarAlumno());

		ALVentanaModificarAlumno oyente = new ALVentanaModificarAlumno();

		botonAtras.addActionListener(oyente);
		comboBox_TipoAlumno.addActionListener(oyente);
		botonModificarAlumno.addActionListener(oyente);
	}

	// Creamos la ventana
	private void create() {
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setSize(300, 300);
		this.setLayout(new BorderLayout());
		// dni
		labelDNI = new JLabel("ID: ");
		txtFieldDNI = new JTextField(9);
		txtFieldDNI.setEnabled(false);
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
		labelFecha_Alumno = new JLabel("Fecha: ");
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

		botonModificarAlumno = new JButton("Modificar Alumno");
		botonAtras = new JButton("Atras");
		panelBotones.add(botonAtras);
		panelBotones.add(botonModificarAlumno);

		panelDatosCentro = new JPanel();
		panelDatosCentro.setLayout(new BorderLayout());
		panelDatosCentro.add(panelDatosArriba, BorderLayout.NORTH);
		panelDatosCentro.add(panelDatosAbajo, BorderLayout.SOUTH);

		this.add(panelTipoAlumno, BorderLayout.NORTH);
		this.add(panelDatosCentro, BorderLayout.CENTER);
		this.add(panelBotones, BorderLayout.SOUTH);
		setLocationRelativeTo(null);

		// Inicializamos la vista.
		txtFieldNombre_Alumno.setText("");
		txtFieldNombre_Alumno.requestFocus();

		pack();
	}

	public void update(int evento, Object datos) {
		// begin-user-code

		switch (evento) {
		case (EventoGUI.MOSTRAR_ALUMNO): {
			TAlumno tAlumno = (TAlumno) datos;
			// limpio y foco
			// DNI
			int DNI = tAlumno.getDni();
			txtFieldDNI.setText(letraDNI(DNI));
			//String stringDNI = Integer.toString(Dni_Alumno);
			// Nombre
			txtFieldNombre_Alumno.setText(tAlumno.getNombre());
			// Apellidos
			txtFieldApellidos_Alumno.setText(tAlumno.getApellidos());
			// Direccion
			txtFieldDireccion_Alumno.setText(tAlumno.getDireccion());
			// Fecha
			try {
				String stringFecha = tAlumno.getFecha_Nacimiento();
				calendarComboFecha_alumno.setDate(new SimpleDateFormat(
						"yyyy-mm-dd").parse(stringFecha));
			} catch (ParseException e) {

				JOptionPane
						.showMessageDialog(null, "Error al parsear la fecha");

			}
			// Telefono
			txtFieldTelefono_Alumno.setText(Integer.toString(tAlumno
					.getTelefono()));

			// Especialidades
			if (datos instanceof TAlumnoNoFamNumerosa) {
				TAlumnoNoFamNumerosa tAlumnoNoFamNumerosa = (TAlumnoNoFamNumerosa) datos;
				int numSegSocial = tAlumnoNoFamNumerosa.getNum_seg_social();
				txtFieldFamNoNumerosa_Alumno.setText(Integer
						.toString(numSegSocial));

				// Visibilizamos la especializacion correcta
				labelFamNumerosa_Alumno.setVisible(false);
				txtFieldFamNumerosa_Alumno.setVisible(false);
				// Ocultamos la otra especializacion
				labelFamNoNumerosa_Alumno.setVisible(true);
				txtFieldFamNoNumerosa_Alumno.setVisible(true);

				// Colocamos el comboBox en la especialidad actual
				comboBox_TipoAlumno.setSelectedItem("Nº SEGURIDAD SOCIAL");

			} else if (datos instanceof TAlumnoFamNumerosa) {
				TAlumnoFamNumerosa tAlumnoFamNumerosa = (TAlumnoFamNumerosa) datos;
				int numFamNumerosa = tAlumnoFamNumerosa.getNum_fam();
				txtFieldFamNumerosa_Alumno.setText(Integer
						.toString(numFamNumerosa));

				// Visibilizamos la especializacion correcta
				labelFamNumerosa_Alumno.setVisible(true);
				txtFieldFamNumerosa_Alumno.setVisible(true);
				// Ocultamos la otra especializacion
				labelFamNoNumerosa_Alumno.setVisible(false);
				txtFieldFamNoNumerosa_Alumno.setVisible(false);

				// Colocamos el comboBox en la especialidad actual
				comboBox_TipoAlumno.setSelectedItem("Nº FAMILIA NUMEROSA");
			}

			txtFieldNombre_Alumno.requestFocus();
			this.setVisible(true);

		}
			break;

		case (EventoGUI.MODIFICAR_ALUMNO_CORRECTO): {
			
			JOptionPane.showMessageDialog(null, "Alumno con [ DNI: " + letraDNI((Integer) datos) + " ] Modificado.");

			// limpio y foco
			txtFieldNombre_Alumno.requestFocus();
		}
			break;

		case (EventoGUI.MODIFICAR_ALUMNO_ERROR): {
			JOptionPane.showMessageDialog(null, "ERROR al modificar los datos");
			VentanaModificarAlumno.getInstance().setVisible(true);
		}
			break;
		case (EventoGUI.MODIFICAR_ALUMNO_ERROR_DNI): {
			JOptionPane.showMessageDialog(null, "Alumno con ese DNI ya registrado.");
			VentanaModificarAlumno.getInstance().setVisible(true);
		}
			break;
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
	  
	  

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static VentanaModificarAlumno getInstance() {
		// begin-user-code
		if (uniqueInstance == null) {
			uniqueInstance = new VentanaModificarAlumno();
		}
		return uniqueInstance;
		// end-user-code
	}

	// ****************************************************//
	// ***************** Action Listener ******************//
	// ****************************************************//
	public class ALVentanaModificarAlumno implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			if (event.getSource() == botonAtras) {
				VentanaModificarAlumno.this.dispose();
				VentanaBuscarAlumno.getInstance().setVisible(true);
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
			if (event.getSource() == botonModificarAlumno) {
				// ******* Obtencion de datos de la ventana ******
				// DNI
				String stringDNI = "";
				stringDNI = txtFieldDNI.getText();
				stringDNI = stringDNI.substring(0, stringDNI.length()-1);
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
				String stringFecha = new SimpleDateFormat("yyyy-MM-dd")
						.format(fechaEscogida);
				// Telefono
					String stringTelefonoAlumno = txtFieldTelefono_Alumno.getText();
					
				// FALTA POR AÑADIR LOS CONTROLES DE LAS ESPECIALIDADES DE
				// ALUMNO
					try {
					
				if (!stringDNI.equalsIgnoreCase("")
						&& !stringNombreAlumno.equalsIgnoreCase("")
						&& !stringApellidosAlumno.equalsIgnoreCase("")
						&& !stringDireccionAlumno.equalsIgnoreCase("")
						&& !stringFecha.equalsIgnoreCase("")
						&& !stringTelefonoAlumno.equalsIgnoreCase("")) 
				{
					int DNI_Alumno = Integer.parseInt(stringDNI);
					int telefono_Alumno = Integer.parseInt(stringTelefonoAlumno);

					// Especialidades
					if (comboBox_TipoAlumno.getSelectedItem().equals(
							"Nº SEGURIDAD SOCIAL")) {

						String stringNumFamNoNumerosa = txtFieldFamNoNumerosa_Alumno
								.getText();
						if (stringNumFamNoNumerosa.equalsIgnoreCase("")) {
							JOptionPane.showMessageDialog(null,
									"Introduce Num seguridad social");
							txtFieldFamNoNumerosa_Alumno.requestFocus();
						} else {
							TAlumnoNoFamNumerosa tAlumno = new TAlumnoNoFamNumerosa(
									DNI_Alumno, stringNombreAlumno,
									stringApellidosAlumno,
									stringDireccionAlumno, stringFecha,
									telefono_Alumno,
									Integer.parseInt(stringNumFamNoNumerosa));
							Controlador.getInstance().action(
									EventoNegocio.MODIFICAR_ALUMNO, tAlumno);
						}
					} else if (comboBox_TipoAlumno.getSelectedItem().equals(
							"Nº FAMILIA NUMEROSA")) {
						String stringNumFamNumerosa = txtFieldFamNumerosa_Alumno
								.getText();
						if (stringNumFamNumerosa.equalsIgnoreCase("")) {
							JOptionPane.showMessageDialog(null,
									"Introduce Num familia numerosa");
							txtFieldFamNumerosa_Alumno.requestFocus();
						} else {
							TAlumnoFamNumerosa tAlumno = new TAlumnoFamNumerosa(
									DNI_Alumno, stringNombreAlumno,
									stringApellidosAlumno,
									stringDireccionAlumno, stringFecha,
									telefono_Alumno,
									Integer.parseInt(stringNumFamNumerosa));
							Controlador.getInstance().action(
									EventoNegocio.MODIFICAR_ALUMNO, tAlumno);
						}
					}

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
					txtFieldNombre_Alumno.requestFocus();
				}
			} catch (NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Introduzca datos correctamente");
				txtFieldTelefono_Alumno.setText("");
			}
				
			}
		}
	}

	// ****************************************************//
	// ***************** Window Listener ******************//
	// ****************************************************//

	public class WLVentanaModificarAlumno implements WindowListener {

		public void windowOpened(WindowEvent arg0) {

			txtFieldDNI.requestFocus();
		}

		public void windowClosing(WindowEvent arg0) {
			VentanaModificarAlumno.this.dispose();
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