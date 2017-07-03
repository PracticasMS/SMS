
/**
 * 
 */
package SMSJPA.Presentacion.Materia;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import SMSJPA.Negocio.Materia.TMateria;
import SMSJPA.Negocio.Profesor.TProfesor;
import SMSJPA.Negocio.Profesor.TProfesorAñosExpe;
import SMSJPA.Presentacion.Controlador.Controlador;
import SMSJPA.Presentacion.Controlador.EventoGUI;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class VentanaMostrarMateria extends JFrame {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static VentanaMostrarMateria uniqueInstance;
	
	private static final long serialVersionUID = 7174590503159048790L;

	private JLabel labelID_Materia;
	private JTextField txtField_ID_Materia;
	
	// ID del alumno
	private JLabel labelNombre;
	private JTextField txtFieldNombre;
	// Precio
	private JLabel labelDescripcion;
	private JTextField txtField_Descripcion;

	// Niveles
	private JLabel labelNivelesCursos;
	private JTextField txtField_NivelesCursos;

	private JScrollPane tableScrollPane;
	private JTable tTablaProfesores;

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
		VentanaMostrarMateria.getInstance().setVisible(true);
	}

	public VentanaMostrarMateria() {
		super("Mostrar Materia");

		create();
		agregarManejadoresDeEventos();

		setLocationRelativeTo(null);
		setResizable(false);
	}
	

	public static VentanaMostrarMateria getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new VentanaMostrarMateria();
		}

		return uniqueInstance;
	}
	
	

	public void create() {
		panelCentral = new JPanel();
		// panelTabla = new JPanel();
		panelCentralBotones = new JPanel();

		panelDatos = new JPanel();
		panelDatos.setBorder(BorderFactory
				.createTitledBorder("Datos de la materia"));
		
		labelID_Materia = new JLabel("ID_Materia");
		txtField_ID_Materia = new JTextField(5);
		txtField_ID_Materia.setEditable(false);
		
		labelNombre = new JLabel("Nombre: ");
		txtFieldNombre = new JTextField(7);
		txtFieldNombre.setEditable(false);
		
		// Precio
		labelDescripcion = new JLabel("Descripcion: ");
		txtField_Descripcion = new JTextField(30);
		txtField_Descripcion.setEditable(false);
		

		panelDatos.add(labelID_Materia);
		panelDatos.add(txtField_ID_Materia);
		panelDatos.add(labelNombre);
		panelDatos.add(txtFieldNombre);
		panelDatos.add(labelDescripcion);
		panelDatos.add(txtField_Descripcion);
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
		panelTabla.setBorder(BorderFactory .createTitledBorder("Profesores asociados"));
		this.setSize(300, 200);

		model = new MyModeloTabla();
		tTablaProfesores = new JTable(model);
		tableScrollPane = new JScrollPane(tTablaProfesores);

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
		ALVentanaMostrarMateria oyente = new ALVentanaMostrarMateria();
		this.addWindowListener(new WLVentanaMostrarMateria());

		//botonAñadirCursoAMatricula.addActionListener(oyente);
		//botonCrearMatricula.addActionListener(oyente);
		botonAtras.addActionListener(oyente);
	}

	

	public void update(int eventoGUI, Object datos) {
		TMateria miMatricula = (TMateria) datos;
		switch (eventoGUI) {
		
			case (EventoGUI.MOSTRAR_MATERIA): {
				
				txtField_ID_Materia.setText(Integer.toString(miMatricula.getID()));
				txtFieldNombre.setText(miMatricula.getNombre());
				txtField_Descripcion.setText(miMatricula.getDescripcion());
				
				model.setListaTabla(miMatricula.getProfesores());
				this.setVisible(true);
			} break;
			
			case(EventoGUI.BUSCAR_MATERIA_ERROR):{
				
				JOptionPane.showMessageDialog(null, "La Materia a la que desea acceder no esta registrada");
				Controlador.getInstance().action(EventoGUI.ABRIR_JPRINCIPAL, 0);
			}break;
			
			
	
		}
	}


	
	
	
	//****************************************************//
	//*************** Abstract Table Model ***************//
	//****************************************************// 
	
	// TABLA
	public class MyModeloTabla extends AbstractTableModel {

		private static final long serialVersionUID = -1400601842772476569L;

		private String[] columnas = { "ID_PROFESOR", "NOMBRE", "AÑOS_EXPERIENCIA" };
		private ArrayList<TProfesorAñosExpe> listaTabla = new ArrayList<TProfesorAñosExpe>();

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
				TProfesorAñosExpe i = listaTabla.get(rowIndex);

				if (columnIndex == 0)
					return i.getId();
				else if (columnIndex == 1)
					return i.getNombre();
				else if (columnIndex == 2)
					return i.getAñosExperiencia();
				else
					return null;
			}
		}

		@Override
		public String getColumnName(int col) {
			return columnas[col];
		}

		public void add(TProfesorAñosExpe i) {
			boolean encontrado = false;
			int j = 0;

			while (!encontrado && j < listaTabla.size()) {

				if (listaTabla.get(j).getId() == i.getId()) {
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

		public void setListaTabla(ArrayList<TProfesorAñosExpe> listaTabla) {
			this.listaTabla = listaTabla;
		}

		public ArrayList<TProfesorAñosExpe> getListaTabla() {
			return this.listaTabla;
		}

	}
	
	//****************************************************//
	//***************** Action Listener ******************//
	//****************************************************// 

	public class ALVentanaMostrarMateria implements ActionListener {
		/** 
		 * (sin Javadoc)
		 * @see ActionListener#actionPerformed(ActionEvent arg0)
		 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
		 */
		public void actionPerformed(ActionEvent event) {
			// begin-user-code
			if (event.getSource() == botonAtras) {
				VentanaMostrarMateria.this.dispose();
				Controlador.getInstance().action(EventoGUI.ABRIR_JPRINCIPAL, null);
				
			}
			// end-user-code
		}
	}
	
	//****************************************************//
	//***************** Window Listener ******************//
	//****************************************************// 

	public class WLVentanaMostrarMateria implements WindowListener {
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
			VentanaMostrarMateria.this.dispose();
			Controlador.getInstance().action(EventoGUI.ABRIR_JPRINCIPAL, null);

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

			//end-user-code
		}
		
	}

}
