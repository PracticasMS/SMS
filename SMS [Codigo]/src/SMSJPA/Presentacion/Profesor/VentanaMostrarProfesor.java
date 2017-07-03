/**
 * 
 */
package SMSJPA.Presentacion.Profesor;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import SMSJPA.Presentacion.Controlador.Controlador;
import SMSJPA.Presentacion.Controlador.EventoGUI;
import SMSJPA.Presentacion.JPrincipal.JPrincipalSMS;
import SMSJPA.Negocio.Materia.TMateriaAñosExpe;
import SMSJPA.Negocio.Profesor.TProfesor;


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class VentanaMostrarProfesor extends JFrame {
	
	private static VentanaMostrarProfesor uniqueInstance;
	//ID
	private JLabel labelID_Profesor;
	private JTextField txtField_ID_Profesor;
	//Nombre
	private JLabel labelNombre;
	private JTextField txtFieldNombre;
	//Apellidos
	private JLabel labelApellidos;
	private JTextField txtField_Apellidos;
	//Telefono
	private JLabel labelTelefono;
	private JTextField txtFieldTelefono;
	//Email
	private JLabel labelEmail;
	private JTextField txtFieldEmail;
	//ID_Turno
	private JLabel labelID_Turno;
	private JTextField txtFieldID_Turno;
	//Tipo
	private JLabel labelTipo;
	private JTextField txtFieldTipo;
	//DNI
	private JLabel labelDNI;
	private JTextField txtFieldDNI;
	//SueldoBase
	private JLabel labelSueldoBase;
	private JTextField txtFieldSueldoBase;
	//Suplementos
	private JLabel labelSuplementos;
	private JTextField txtFieldSuplementos;
	//NUM_SS
	private JLabel labelNUM_SS;
	private JTextField txtFieldNUM_SS;
	//NUM_SS
	private JLabel labelEurosPorHora;
	private JTextField txtFieldEurosPorHora;
	//NUM_SS
	private JLabel labelHorasTrabajadas;
	private JTextField txtFieldHorasTrabajadas;
	
	
	//SCROLLPANE
	private JScrollPane tableScrollPane;
	//TABLA
	private JTable tTablaMaterias;
	//BOTONES
	private JButton botonAtras;
	//PANELES
	private JPanel panelDatos;
	private JPanel panelDatosArriba;
	private JPanel panelDatosCentro;
	private JPanel panelDatosAbajo;
	private JPanel panelTabla;
	private JPanel panelBotones;
	private JPanel panelTablaYBotones;
	
	private MyModeloTabla model;

	
	
	public static void main(String[] args) {
		VentanaMostrarProfesor.getInstance().setVisible(true);
	}

	public VentanaMostrarProfesor() {
		super("Mostrar Profesor");

		create();
		agregarManejadoresDeEventos();

		setLocationRelativeTo(null);
		setResizable(false);
	}	
	
	public static VentanaMostrarProfesor getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new VentanaMostrarProfesor();
		}

		return uniqueInstance;
	}
	public void create() {
		//PANELES DE DATOS - DATOS PROFESOR
		panelDatos = new JPanel();
		panelDatos.setBorder(BorderFactory
				.createTitledBorder("Datos del Profesor"));
		panelDatos.setLayout(new BorderLayout());
		
		panelDatosArriba = new JPanel();
		panelDatosCentro = new JPanel();
		panelDatosAbajo = new JPanel();
		
		labelID_Profesor = new JLabel("ID_Profesor");
		txtField_ID_Profesor = new JTextField(5);
		txtField_ID_Profesor.setEditable(false);
		
		labelNombre = new JLabel("Nombre: ");
		txtFieldNombre= new JTextField(17);
		txtFieldNombre.setEditable(false);
		
		labelApellidos = new JLabel("Apellidos: ");
		txtField_Apellidos= new JTextField(17);
		txtField_Apellidos.setEditable(false);
		
		labelTelefono = new JLabel("Telefono: ");
		txtFieldTelefono = new JTextField(9);
		txtFieldTelefono.setEditable(false);
		
		labelEmail = new JLabel("Email: ");
		txtFieldEmail= new JTextField(20);
		txtFieldEmail.setEditable(false);
		
		labelID_Turno = new JLabel("ID_Turno: ");
		txtFieldID_Turno = new JTextField(7);
		txtFieldID_Turno.setEditable(false);
		
		labelTipo = new JLabel("Tipo: ");
		txtFieldTipo = new JTextField(10);
		txtFieldTipo.setEditable(false);
		
		labelDNI = new JLabel("DNI: ");
		txtFieldDNI = new JTextField(9);
		txtFieldDNI.setEditable(false);
		
		labelSueldoBase = new JLabel("Sueldo Base: ");
		txtFieldSueldoBase = new JTextField(9);
		txtFieldSueldoBase.setEditable(false);
		
		labelSuplementos = new JLabel("Suplementos: ");
		txtFieldSuplementos = new JTextField(9);
		txtFieldSuplementos.setEditable(false);
		
		labelNUM_SS = new JLabel("Num. Seg. Social: ");
		txtFieldNUM_SS = new JTextField(9);
		txtFieldNUM_SS.setEditable(false);
		
		labelEurosPorHora = new JLabel("Euros/Hora: ");
		txtFieldEurosPorHora = new JTextField(9);
		txtFieldEurosPorHora.setEditable(false);
		
		labelHorasTrabajadas = new JLabel("Horas Trabajadas: ");
		txtFieldHorasTrabajadas = new JTextField(9);
		txtFieldHorasTrabajadas.setEditable(false);
		//ARRIBA
		panelDatosArriba.add(labelID_Profesor);
		panelDatosArriba.add(txtField_ID_Profesor);
		panelDatosArriba.add(labelNombre);
		panelDatosArriba.add(txtFieldNombre);
		panelDatosArriba.add(labelApellidos);
		panelDatosArriba.add(txtField_Apellidos);
		panelDatosArriba.add(labelTelefono);
		panelDatosArriba.add(txtFieldTelefono);
		//CENTRO
		panelDatosCentro.add(labelID_Turno);
		panelDatosCentro.add(txtFieldID_Turno);
		panelDatosCentro.add(labelEmail);
		panelDatosCentro.add(txtFieldEmail);
		panelDatosCentro.add(labelTipo);
		panelDatosCentro.add(txtFieldTipo);
		//ABAJO
		panelDatosAbajo.add(labelDNI);
		panelDatosAbajo.add(txtFieldDNI);
		panelDatosAbajo.add(labelSueldoBase);
		panelDatosAbajo.add(txtFieldSueldoBase);
		panelDatosAbajo.add(labelSuplementos);
		panelDatosAbajo.add(txtFieldSuplementos);
		panelDatosAbajo.add(labelNUM_SS);
		panelDatosAbajo.add(txtFieldNUM_SS);
		panelDatosAbajo.add(labelEurosPorHora);
		panelDatosAbajo.add(txtFieldEurosPorHora);
		panelDatosAbajo.add(labelHorasTrabajadas);
		panelDatosAbajo.add(txtFieldHorasTrabajadas);

		panelDatos.add(panelDatosArriba, BorderLayout.NORTH);
		panelDatos.add(panelDatosCentro, BorderLayout.CENTER);
		panelDatos.add(panelDatosAbajo, BorderLayout.SOUTH);
		
		this.add(panelDatos, BorderLayout.NORTH);
		setLocationRelativeTo(null);

		//PANELES DE LA TABLA - MATERIAS ASOCIADAS
		panelTabla = new JPanel(new BorderLayout());
		panelTabla.setBorder(BorderFactory.createTitledBorder("Materias asociadas"));
		this.setSize(500, 200);

		model = new MyModeloTabla();
		tTablaMaterias = new JTable(model);
		tableScrollPane = new JScrollPane(tTablaMaterias);

		panelTabla.add(tableScrollPane);


		panelTablaYBotones = new JPanel();
		panelTablaYBotones.add(panelTabla, BorderLayout.CENTER);

		this.add(panelTablaYBotones);

		//PANEL DE BOTONES - FINALIZAR PROCESO
		panelBotones = new JPanel();
		panelBotones.setBorder(BorderFactory.createTitledBorder("Finalizar proceso"));
		botonAtras = new JButton("Atras");

		panelBotones.add(botonAtras);

		this.add(panelBotones, BorderLayout.SOUTH);

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		//
		pack();
	}
	
	
	private void agregarManejadoresDeEventos() {
		ALVentanaMostrarProfesor oyente = new ALVentanaMostrarProfesor();
		this.addWindowListener(new WLVentanaMostrarProfesor());

		botonAtras.addActionListener(oyente);
	}
	
	public void update(int eventoGUI, Object datos) {
		TProfesor miProfesor = (TProfesor) datos;
		switch (eventoGUI) {
		
			case (EventoGUI.MOSTRAR_PROFESOR): {
				
				txtField_ID_Profesor.setText(Integer.toString(miProfesor.getId()));
				txtFieldNombre.setText(miProfesor.getNombre());
				txtField_Apellidos.setText(miProfesor.getApellidos());
				txtFieldTelefono.setText(Integer.toString(miProfesor.getTelefono()));
				txtFieldID_Turno.setText(Integer.toString(miProfesor.getId_turno()));
				txtFieldEmail.setText(miProfesor.getEmail());
				txtFieldTipo.setText(miProfesor.getTipo());
				if(miProfesor.getTipo().equalsIgnoreCase("AUXILIAR")){
					txtFieldNUM_SS.setText(Integer.toString(miProfesor.getNum_SS()));
					txtFieldEurosPorHora.setText(Double.toString(miProfesor.getEurosPorHora()));
					txtFieldHorasTrabajadas.setText(Integer.toString(miProfesor.getHorasTrabajadas()));
					labelNUM_SS.setVisible(true);
					txtFieldNUM_SS.setVisible(true);
					labelEurosPorHora.setVisible(true);
					txtFieldEurosPorHora.setVisible(true);
					labelHorasTrabajadas.setVisible(true);
					txtFieldHorasTrabajadas.setVisible(true);
					
					txtFieldDNI.setText("");
					txtFieldSueldoBase.setText("");
					txtFieldSuplementos.setText("");
					labelDNI.setVisible(false);
					txtFieldDNI.setVisible(false);
					labelSueldoBase.setVisible(false);
					txtFieldSueldoBase.setVisible(false);
					labelSuplementos.setVisible(false);
					txtFieldSuplementos.setVisible(false);
				}
				else if(miProfesor.getTipo().equalsIgnoreCase("RESIDENTE")){
					
					txtFieldDNI.setText(letraDNI(miProfesor.getDNI()));
					txtFieldSueldoBase.setText(Double.toString(miProfesor.getSueldoBase()));
					txtFieldSuplementos.setText(Double.toString(miProfesor.getSuplementos()));
					labelDNI.setVisible(true);
					txtFieldDNI.setVisible(true);
					labelSueldoBase.setVisible(true);
					txtFieldSueldoBase.setVisible(true);					
					labelSuplementos.setVisible(true);
					txtFieldSuplementos.setVisible(true);					
					
					txtFieldNUM_SS.setText("");
					txtFieldEurosPorHora.setText("");
					txtFieldHorasTrabajadas.setText("");
					labelNUM_SS.setVisible(false);
					txtFieldNUM_SS.setVisible(false);
					labelEurosPorHora.setVisible(false);
					txtFieldEurosPorHora.setVisible(false);
					labelHorasTrabajadas.setVisible(false);
					txtFieldHorasTrabajadas.setVisible(false);
				}
				
				
				model.setListaTabla(miProfesor.getMaterias());
				this.setVisible(true);
			} break;
			case(EventoGUI.BUSCAR_PROFESOR_ERROR):
			{
				JOptionPane.showMessageDialog(null, "El profesor al que desea acceder no esta registrada");
				Controlador.getInstance().action(EventoGUI.ABRIR_JPRINCIPAL, 0);
			}
		}
	}
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

		private String[] columnas = { "ID", "NOMBRE", "AÑOS_EXPERIENCIA" };
		private ArrayList<TMateriaAñosExpe> listaTabla = new ArrayList<TMateriaAñosExpe>();

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
				TMateriaAñosExpe i = listaTabla.get(rowIndex);

				if (columnIndex == 0)
					return i.getID();
				else if (columnIndex == 1)
					return i.getNombre();
				else if (columnIndex == 2)
					return i.getAñosExperiecia();
				else
					return null;
			}
		}

		@Override
		public String getColumnName(int col) {
			return columnas[col];
		}

		public void add(TMateriaAñosExpe i) {
			boolean encontrado = false;
			int j = 0;

			while (!encontrado && j < listaTabla.size()) {

				if (listaTabla.get(j).getID() == i.getID()) {
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

		public void setListaTabla(ArrayList<TMateriaAñosExpe> listaTabla) {
			this.listaTabla = listaTabla;
		}

		public ArrayList<TMateriaAñosExpe> getListaTabla() {
			return this.listaTabla;
		}

	}
	
	public class ALVentanaMostrarProfesor implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == botonAtras) {
				VentanaMostrarProfesor.this.dispose();
				JPrincipalSMS.getInstance().setVisible(true);
			}
		}
	}
	
	public class WLVentanaMostrarProfesor implements WindowListener {

		@Override
		public void windowActivated(WindowEvent e) {}

		@Override
		public void windowClosed(WindowEvent e) {}

		@Override
		public void windowClosing(WindowEvent e) {
			VentanaMostrarProfesor.this.dispose();
			JPrincipalSMS.getInstance().setVisible(true);
		}

		@Override
		public void windowDeactivated(WindowEvent e) {}

		@Override
		public void windowDeiconified(WindowEvent e) {}

		@Override
		public void windowIconified(WindowEvent e) {}

		@Override
		public void windowOpened(WindowEvent e) {}
	}
}