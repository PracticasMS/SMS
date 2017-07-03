/**
 * 
 */
package SMSDAO.Presentacion.Matricula;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import SMSDAO.Negocio.Matricula.TCursoNivel;
import SMSDAO.Negocio.Matricula.TMatricula;
import SMSDAO.Presentacion.JPrincipal.EventoGUI;
import SMSDAO.Presentacion.JPrincipal.JPrincipalSMS;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Eduardo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VentanaMostrarMatricula extends JFrame {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static VentanaMostrarMatricula uniqueInstance;
	
	private static final long serialVersionUID = 7174590503159048790L;

	private JLabel labelID_Matricula;
	private JTextField txtField_ID_Matricula;
	
	// ID del alumno
	private JLabel labelDNI;
	private JTextField txtFieldDNI;
	// Precio
	private JLabel labelPrecio;
	private JTextField txtField_Precio;
	// Label TIPO
	private JLabel labelTipo;
	private JTextField txtFieldTipo;

	// Niveles
	private JLabel labelNivelesCursos;
	private JTextField txtField_NivelesCursos;

	private JScrollPane tableScrollPane;
	private JTable tTablaCursos;

	private JButton botonCrearMatricula;
	private JButton botonAtras;
	private JButton botonAñadirCursoAMatricula;
	private JButton botonQuitarCursoAMatricula;

	private JPanel panelDatos;
	private JPanel panelCentral;
	private JPanel panelTabla;
	private JPanel panelBotonesCrear;
	private JPanel panelCentralBotones;
	private JPanel panelSur;
	private JPanel panelBotonesDeTabla;

	private MyModeloTabla model;

	private JPanel panelTablaYBotones;

	public static void main(String[] args) {
		VentanaMostrarMatricula.getInstance().setVisible(true);
	}

	public VentanaMostrarMatricula() {
		super("Mostrar Matrícula");

		create();
		agregarManejadoresDeEventos();

		setLocationRelativeTo(null);
		setResizable(false);
	}
	

	public static VentanaMostrarMatricula getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new VentanaMostrarMatricula();
		}

		return uniqueInstance;
	}
	
	

	public void create() {
		panelCentral = new JPanel();
		// panelTabla = new JPanel();
		panelCentralBotones = new JPanel();

		panelDatos = new JPanel();
		panelDatos.setBorder(BorderFactory
				.createTitledBorder("Datos de la matrícula"));
		
		labelID_Matricula = new JLabel("ID_Matricula");
		txtField_ID_Matricula = new JTextField(5);
		txtField_ID_Matricula.setEditable(false);
		
		labelDNI = new JLabel("DNI: ");
		txtFieldDNI = new JTextField(7);
		txtFieldDNI.setEditable(false);
		
		// Precio
		labelPrecio = new JLabel("Precio: ");
		txtField_Precio = new JTextField(5);
		txtField_Precio.setEditable(false);
		
		// Label TIPO
		labelTipo = new JLabel("Tipo: ");
		txtFieldTipo = new JTextField(5);
		txtFieldTipo.setEditable(false);
		
		
		// Fecha curso
		// labelFechaCurso = new JLabel("Fecha: ");
		// calendarComboFecha_alumno = new JCalendarCombo();

		panelDatos.add(labelID_Matricula);
		panelDatos.add(txtField_ID_Matricula);
		panelDatos.add(labelDNI);
		panelDatos.add(txtFieldDNI);
		panelDatos.add(labelPrecio);
		panelDatos.add(txtField_Precio);
		panelDatos.add(labelTipo);
		panelDatos.add(txtFieldTipo);
		// panelDatos.add(labelFechaCurso);
		// panelDatos.add(calendarComboFecha_alumno);

		this.add(panelDatos, BorderLayout.NORTH);
		setLocationRelativeTo(null);

		// *******************
		// *******************
		// ****TABLA**********
		// *******************
		// *******************
		// *******************

		panelTabla = new JPanel(new BorderLayout());
		panelTabla.setBorder(BorderFactory
				.createTitledBorder("Cursos asociados"));
		this.setSize(300, 200);

		model = new MyModeloTabla();
		tTablaCursos = new JTable(model);
		tableScrollPane = new JScrollPane(tTablaCursos);

		panelTabla.add(tableScrollPane);

		// **************************************
		// PANEL BOTONES DE TABLA
//		panelBotonesDeTabla = new JPanel(new GridLayout(3, 1));
//		panelBotonesDeTabla.setBorder(BorderFactory.createTitledBorder("Opciones"));

//		botonAñadirCursoAMatricula = new JButton("Añadir Curso");
//		botonQuitarCursoAMatricula = new JButton("Quitar Curso");

//		panelBotonesDeTabla.add(botonAñadirCursoAMatricula);
//		panelBotonesDeTabla.add(new Panel());
//		panelBotonesDeTabla.add(botonQuitarCursoAMatricula);

		panelTablaYBotones = new JPanel();
		panelTablaYBotones.add(panelTabla, BorderLayout.CENTER);
//		panelTablaYBotones.add(panelBotonesDeTabla, BorderLayout.WEST);

		this.add(panelTablaYBotones);

		// panel de botones crear

		panelBotonesCrear = new JPanel();
		panelBotonesCrear.setBorder(BorderFactory.createTitledBorder("Finalizar proceso"));
		botonAtras = new JButton("Atras");
		//botonCrearMatricula = new JButton("Crear Matricula");

		panelBotonesCrear.add(botonAtras);
		//panelBotonesCrear.add(botonCrearMatricula);

		this.add(panelBotonesCrear, BorderLayout.SOUTH);

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		//
		pack();
	}
	
	
	private void agregarManejadoresDeEventos() {
		ALVentanaMostrarMatricula oyente = new ALVentanaMostrarMatricula();
		this.addWindowListener(new WLVentanaMostrarMatricula());

		//botonAñadirCursoAMatricula.addActionListener(oyente);
		//botonCrearMatricula.addActionListener(oyente);
		botonAtras.addActionListener(oyente);
	}

	

	public void update(int eventoGUI, Object datos) {
		TMatricula miMatricula = (TMatricula) datos;
		switch (eventoGUI) {
		
			case (EventoGUI.MOSTRAR_MATRICULA): {
				
				txtField_ID_Matricula.setText(Integer.toString(miMatricula.getID_Matricula()));
				txtFieldDNI.setText(letraDNI(miMatricula.getDNI()));
				txtField_Precio.setText(Integer.toString(miMatricula.getPrecio()));
				txtFieldTipo.setText(miMatricula.getTipo());
				model.setListaTabla(miMatricula.getCursos());

			} break;
		
	
		}
	}
	
	/**
	   * Devuelve un NIF completo a partir de un DNI. Es decir, añade la letra del NIF
	   * @param dni dni al que se quiere añadir la letra del NIF
	   * @return NIF completo.
	   */
	  public String letraDNI(int dni) {
		  String NIF_STRING_ASOCIATION = "TRWAGMYFPDXBNJZSQVHLCKE";
	    return String.valueOf(dni) + NIF_STRING_ASOCIATION.charAt(dni % 23);
	  }

	
	
	
	//****************************************************//
	//*************** Abstract Table Model ***************//
	//****************************************************// 
	
	// TABLA
	public class MyModeloTabla extends AbstractTableModel {

		private static final long serialVersionUID = -1400601842772476569L;

		private String[] columnas = { "ID", "NOMBRE", "NIVEL" };
		private ArrayList<TCursoNivel> listaTabla = new ArrayList<TCursoNivel>();

		@Override
		public int getColumnCount() {
			return columnas.length;
		}

		@Override
		public int getRowCount() {
			return listaTabla.size();
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			if (rowIndex >= listaTabla.size()) {
				return null;
			} else {
				TCursoNivel i = listaTabla.get(rowIndex);

				if (columnIndex == 0)
					return i.getId_Curso();
				else if (columnIndex == 1)
					return i.getNombre();
				else if (columnIndex == 2)
					return i.getNivel();
				else
					return null;
			}
		}

		@Override
		public String getColumnName(int col) {
			return columnas[col];
		}

		public void add(TCursoNivel i) {
			boolean encontrado = false;
			int j = 0;

			while (!encontrado && j < listaTabla.size()) {

				if (listaTabla.get(j).getId_Curso() == i.getId_Curso()) {
					listaTabla.remove(j);
					listaTabla.add(j, i);
					encontrado = true;
				}
				j++;
			}

			if (!encontrado) {
				listaTabla.add(i);
			}

			this.fireTableDataChanged();
		}

		public void clear() {
			this.listaTabla.clear();
		}

		public void setListaTabla(ArrayList<TCursoNivel> listaTabla) {
			this.listaTabla = listaTabla;
		}

		public ArrayList<TCursoNivel> getListaTabla() {
			return this.listaTabla;
		}

	}
	
	
	
	
	//****************************************************//
	//***************** Action Listener ******************//
	//****************************************************// 

	public class ALVentanaMostrarMatricula implements ActionListener {
		/** 
		 * (sin Javadoc)
		 * @see ActionListener#actionPerformed(ActionEvent arg0)
		 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
		 */
		public void actionPerformed(ActionEvent event) {
			// begin-user-code
			if (event.getSource() == botonAtras) {
				VentanaMostrarMatricula.this.dispose();
				JPrincipalSMS.getInstance().setVisible(true);
			}
			// end-user-code
		}
	}
	
	//****************************************************//
	//***************** Window Listener ******************//
	//****************************************************// 

	public class WLVentanaMostrarMatricula implements WindowListener {
		/** 
		 * (sin Javadoc)
		 * @see WindowListener#windowOpened(WindowEvent arg0)
		 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
		 */
		public void windowOpened(WindowEvent arg0) {
			// begin-user-code
			// TODO Apéndice de método generado automáticamente

			// end-user-code
		}

		/** 
		 * (sin Javadoc)
		 * @see WindowListener#windowClosing(WindowEvent arg0)
		 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
		 */
		public void windowClosing(WindowEvent arg0) {
			// begin-user-code
			VentanaMostrarMatricula.this.dispose();
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
			// TODO Apéndice de método generado automáticamente

			// end-user-code
		}

		/** 
		 * (sin Javadoc)
		 * @see WindowListener#windowIconified(WindowEvent arg0)
		 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
		 */
		public void windowIconified(WindowEvent arg0) {
			// begin-user-code
			// TODO Apéndice de método generado automáticamente

			// end-user-code
		}

		/** 
		 * (sin Javadoc)
		 * @see WindowListener#windowDeiconified(WindowEvent arg0)
		 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
		 */
		public void windowDeiconified(WindowEvent arg0) {
			// begin-user-code
			// TODO Apéndice de método generado automáticamente

			// end-user-code
		}

		/** 
		 * (sin Javadoc)
		 * @see WindowListener#windowActivated(WindowEvent arg0)
		 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
		 */
		public void windowActivated(WindowEvent arg0) {
			// begin-user-code
			// TODO Apéndice de método generado automáticamente

			// end-user-code
		}

		/** 
		 * (sin Javadoc)
		 * @see WindowListener#windowDeactivated(WindowEvent arg0)
		 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
		 */
		public void windowDeactivated(WindowEvent arg0) {
			// begin-user-code
			// TODO Apéndice de método generado automáticamente

			// end-user-code
		}
	}
	
	
	
	
}