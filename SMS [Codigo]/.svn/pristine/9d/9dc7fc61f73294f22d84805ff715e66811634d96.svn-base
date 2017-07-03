/**
 * 
 */
package SMSDAO.Presentacion.Alumnos;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import SMSDAO.Negocio.Alumnos.TAlumno;
import SMSDAO.Negocio.Alumnos.TAlumnoFamNumerosa;
import SMSDAO.Negocio.Alumnos.TAlumnoNoFamNumerosa;
import SMSDAO.Presentacion.Alumnos.VentanaListarAlumnosConNMatricEnMAños.ParElementos;
import SMSDAO.Presentacion.JPrincipal.EventoGUI;
import SMSDAO.Presentacion.JPrincipal.JPrincipalSMS;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VentanaListarAlumnos extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2048322630522096757L;
	
	
	private static VentanaListarAlumnos uniqueInstance;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	
	private MyModeloTabla model;

	private JScrollPane tableScrollPane;
	private JTable tTabla;
	private JButton botonAtras;
	private JPanel panelBotones;
	private JPanel panelDatos;
	private JPanel panelPrincipal;
	
	
	
	public static VentanaListarAlumnos getInstance() {
		// begin-user-code
		
		if(uniqueInstance == null)
			uniqueInstance = new VentanaListarAlumnos();
		
		return uniqueInstance;
		
		// end-user-code
	}
	
	public VentanaListarAlumnos(){
		
		super("Listar Alumnos");

		create();
		agregarManejadoresDeEventos();

		setLocationRelativeTo(null);
		setResizable(false);
		
		
	}

	private void create() {
		
		panelPrincipal = new JPanel(new BorderLayout());
		//this.setSize(750, 300);
		//this.setSize(850, 300);
		//this.setSize(850, 300);
		//this.setSize(850, 300);
		this.setSize(900, 300);

		panelDatos = new JPanel(new BorderLayout());
		model = new MyModeloTabla();
		tTabla = new JTable(model);
		tableScrollPane = new JScrollPane(tTabla);

		panelDatos.add(tableScrollPane);

		botonAtras = new JButton("Atras");
		panelBotones = new JPanel();
		panelBotones.add(botonAtras);

		panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
		panelPrincipal.add(panelDatos, BorderLayout.CENTER);

		this.add(panelPrincipal);

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	private void agregarManejadoresDeEventos() {
		
		ALVentanaListarAlumnos oyente = new ALVentanaListarAlumnos();	
		this.addWindowListener(new WLVentanaListarAlumno());

		botonAtras.addActionListener(oyente);
		
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param evento
	 * @param datos
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@SuppressWarnings("unchecked")
	public void update(int evento, Object datos) {
		
		
		switch (evento) {
		case (EventoGUI.LISTAR_ALUMNOS):{
			ArrayList<TAlumno> misAlumnos = (ArrayList<TAlumno>) datos;

			model.setListaTabla(misAlumnos);

			tTabla.setModel(model);

			setLocationRelativeTo(null);
			this.setVisible(true);

		}break;
		
		case (EventoGUI.LISTAR_ALUMNOS_NMatriculas_MAnos):{
			ArrayList<TAlumno> misAlumnos = (ArrayList<TAlumno>) datos;
			ParElementos par = VentanaListarAlumnosConNMatricEnMAños.getInstance().getParDatos();
			String nombre = "Listar alumnos con " + par.getNumMatricuals() + " matrículas en " + par.getNumAnos() + " años";
			this.setTitle(nombre);
			
			model.setListaTabla(misAlumnos);

			tTabla.setModel(model);

			setLocationRelativeTo(null);
			this.setVisible(true);

		}break;

		case (EventoGUI.LISTAR_ALUMNOS_ERRORAUX):{

			JOptionPane.showMessageDialog(null, "No existen Alumnos que listar.");
			VentanaListarAlumnosConNMatricEnMAños.getInstance().setVisible(true);

		}break;

		case (EventoGUI.LISTAR_ALUMNOS_ERROR):{
			//Mostramos un mensaje de error.

			JOptionPane.showMessageDialog(null, "Error al listar los Alumnos");
			JPrincipalSMS.getInstance().setVisible(true);

		}break;
		}
	}
	
	private class MyModeloTabla extends AbstractTableModel {

		private static final long serialVersionUID = -1400601842772476568L;
		//private String[] columnas = { "DNI", "NOMBRE", "APELLIDOS", "DIRECCION", "FECHA_NACIMIENTO", "TELEFONO", "NUM_SEGURIDAD_SOCIAL", "NUM_FAMILIARES"};
		//private String[] columnas = { "DNI", "NOMBRE", "APELLIDOS", "DIRECCION", "FECHA_NACIMIENTO", "TELEFONO", "NUM_FAMILIARES", "NUM_SEGURIDAD_SOCIAL"};

		private String[] columnas = { "DNI", "NOMBRE", "APELLIDOS", "DIRECCION", "FECHA_NACIMIENTO", "TELEFONO", "NUM_FAMILIARES", "NUM_SEGURIDAD_SOCIAL"};
		private ArrayList<TAlumno> listaTabla = new ArrayList<TAlumno>();

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
			
			
			//boolean alumnFamNum = false;
			boolean alumnFamNum = false;
			if (rowIndex >= listaTabla.size()) {
				return null;
			} else {
				TAlumno i = listaTabla.get(rowIndex);
				//boolean alumnFamNum = false;
				
				/*if(i instanceof TAlumnoFamNumerosa){
					
					alumnFamNum = true;
					
				}*/
				
				/*if(i instanceof TAlumnoFamNumerosa){
					alumnFamNum = true;
				}else{
					alumnFamNum = false;
				}*/
				
				if(i instanceof TAlumnoFamNumerosa){
					alumnFamNum = true;
				}else{
					alumnFamNum = false;
				}
				
				if(columnIndex == 0)
					return letraDNI(i.getDni());
				else if (columnIndex == 1)
					return i.getNombre();
				else if (columnIndex == 2)
					return i.getApellidos();
				else if (columnIndex == 3)
					return i.getDireccion();
				else if (columnIndex == 4)
					return procesarFecha(i.getFecha_Nacimiento());
				else if (columnIndex == 5)
					return i.getTelefono();
			/*
				else if (alumnFamNum){
					if(columnIndex == 6){
						return ((TAlumnoFamNumerosa) i).getNum_fam();
					}
				}else if(!alumnFamNum){
					if(columnIndex == 7){
						return ((TAlumnoNoFamNumerosa) i).getNum_seg_social();
					}
				}//else 
				
				return null;*/
				else if (alumnFamNum){
					if(columnIndex == 6){
						return ((TAlumnoFamNumerosa) i).getNum_fam();
					}
				}else if(!alumnFamNum){
					if(columnIndex == 7){
						return ((TAlumnoNoFamNumerosa) i).getNum_seg_social();
					}
				}//else 
				
				return null;
			}
		}
		
		 public String letraDNI(int dni) {
			  String NIF_STRING_ASOCIATION = "TRWAGMYFPDXBNJZSQVHLCKE";
		    return String.valueOf(dni) + NIF_STRING_ASOCIATION.charAt(dni % 23);
		  }
		 
		public String procesarFecha(String fecha){
			fecha = fecha.substring(0, 9);
			//int primerAño = Integer.parseInt(fecha);
			//int segundoAño = primerAño+1;
			//segundoAño = segundoAño%100;
			return fecha /*+ "/" + segundoAño*/;
		}
		

		@Override
		public String getColumnName(int col) {
			return columnas[col];
		}

		@SuppressWarnings("unused")
		public void add(TAlumno i){
			boolean encontrado = false;
			int j = 0;

			while(!encontrado && j< listaTabla.size()){

				if(listaTabla.get(j).getDni() == i.getDni()){
					listaTabla.remove(j);
					listaTabla.add(j, i);
					encontrado = true;
				}
				j++;
			}

			if(!encontrado){
				listaTabla.add(i);
			}

			this.fireTableDataChanged();
		}

		@SuppressWarnings("unused")
		public void clear() {
			this.listaTabla.clear();
		}

		public void setListaTabla(ArrayList<TAlumno> listaTabla) {
			this.listaTabla = listaTabla;
		}
	}
	
	
	public class ALVentanaListarAlumnos implements ActionListener {
	
		
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == botonAtras){
				VentanaListarAlumnos.this.dispose();
				JPrincipalSMS.getInstance().setVisible(true);
			}
		}
	}
	
	
	public class WLVentanaListarAlumno implements WindowListener {
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
			
			JPrincipalSMS.getInstance().setVisible(true);
			VentanaListarAlumnos.this.dispose();

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

