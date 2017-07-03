package SMSJPA.Presentacion.Profesor;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import SMSJPA.Negocio.Materia.TMateria;
import SMSJPA.Negocio.Materia.TMateriaAñosExpe;
import SMSJPA.Presentacion.Controlador.Controlador;
import SMSJPA.Presentacion.Controlador.EventoGUI;
import SMSJPA.Presentacion.JPrincipal.JPrincipalSMS;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VentanaBuscarMateriaProfesor extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9134779943129310760L;
	
	private JPanel panelDatos;
	private JPanel panelBotones;
	
	private MyModeloTabla model;
	private JScrollPane tableScrollPane;
	private JTable tTabla;
	private JPanel panelBotonesTabla;
	private JPanel panelDatosTabla;
	private JPanel panelTabla;
	
	private JLabel labelID_Materia;
	private JTextField txtFieldID_Materia;
	
	private JLabel labelExperiencia;
	private JTextField txtExperiencia;
	
	private JButton botonBuscarMateria;
	private JButton botonAtras;
	private int tipoEventoGUI;

	private JPanel panelPrincipal;

	private static VentanaBuscarMateriaProfesor uniqueInstance;
	
	public VentanaBuscarMateriaProfesor(){
		super("Añadir materia");
		
		create();
		
		agregarManejadoresDeEventos();
		
		setLocationRelativeTo(null);
		setResizable(false);
	}
	public static VentanaBuscarMateriaProfesor getInstance() {
		if(uniqueInstance == null){
			uniqueInstance = new VentanaBuscarMateriaProfesor();
		}
		
		return uniqueInstance;
	}
	
	private void create() {
		
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		//this.setLayout(new GridLayout(2,1));
		
		
		labelID_Materia = new JLabel("ID_Materia: ");
		txtFieldID_Materia = new  JTextField(10);
		
		botonBuscarMateria = new JButton("Añadir materia");
		botonAtras = new JButton("Cerrar");
		
		labelExperiencia = new JLabel("Años Experiencia:");
		txtExperiencia = new JTextField(5);
		
		
		panelDatos = new JPanel();
		panelBotones = new JPanel();
		//panelTabla = new JPanel(new GridLayout(2,1));
		panelTabla = new JPanel(new FlowLayout());
		//panelDatosTabla = new JPanel(new GridLayout(2,2));
		panelDatosTabla = new JPanel(new BorderLayout());

		
		
		//***EXPERIENCIA***
		
		
		//***TABLA***
		
		model = new MyModeloTabla();
		tTabla = new JTable(model);
		
		tableScrollPane = new JScrollPane(tTabla);

		panelDatosTabla.add(tableScrollPane);
		//panelTabla.add(panelDatosTabla);
		
		//**********

		panelDatos.add(labelID_Materia);
		panelDatos.add(txtFieldID_Materia);
		panelDatos.add(labelExperiencia);
		panelDatos.add(txtExperiencia);
		
		panelBotones.add(botonAtras);
		panelBotones.add(botonBuscarMateria);
		
		panelPrincipal = new JPanel(new BorderLayout());

		panelPrincipal.add(panelDatosTabla, BorderLayout.CENTER);
		panelPrincipal.add(panelDatos, BorderLayout.NORTH);
		panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
		
		this.add(panelPrincipal);
		
		setLocationRelativeTo(null);
	
		
		//pack();
		this.setSize(450, 400);
		//this.setSize(400, 300);
		
	}
	private void agregarManejadoresDeEventos() {
		
		ALVentanaBuscarMateriaProfesor oyente = new ALVentanaBuscarMateriaProfesor();
		this.addWindowListener(new WLVentanaBuscarCursoMatricula());
		botonBuscarMateria.addActionListener(oyente);
		botonAtras.addActionListener(oyente);
		
	}
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void update(int evento, Object datos) {
		
		
		
		switch (evento){
		
		case EventoGUI.BUSCAR_MATERIA_ERROR:{
			JOptionPane.showMessageDialog(null, "La materia no existe en el sistema");
			
		}; break;
		
		case (EventoGUI.LISTAR_MATERIAS):{
			@SuppressWarnings("unchecked")
			ArrayList<TMateria> misMaterias = (ArrayList<TMateria>) datos;

			model.setListaTabla(misMaterias);

			tTabla.setModel(model);

		}break;
		
		case (EventoGUI.LISTAR_MATERIAS_ERRORAUX):{
			VentanaBuscarMateriaProfesor.this.dispose();
			JOptionPane.showMessageDialog(null, "No existen materias que listar.");

		}break;
		
		case (EventoGUI.LISTAR_MATERIAS_ERROR):{
			//Mostramos un mensaje de error.
			VentanaBuscarMateriaProfesor.this.dispose();
			JOptionPane.showMessageDialog(null, "Error al listar las materias");

		}break;
		
		
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
	public class ALVentanaBuscarMateriaProfesor implements ActionListener{

		/* (sin Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == botonAtras){
				VentanaBuscarMateriaProfesor.this.txtFieldID_Materia.setText("");				
				VentanaBuscarMateriaProfesor.this.dispose();

			}
			
			if(event.getSource() == botonBuscarMateria){
				int experiencia = 1;
				String stringID = "";
				String stringExperiencia = "";
				stringID = txtFieldID_Materia.getText();
				stringExperiencia = txtExperiencia.getText();
				
				//******* Obtencion de datos de la ventana ******
				try{
					if (!stringID.equalsIgnoreCase("")){
						
						if (!stringExperiencia.equalsIgnoreCase("")){
							TMateriaAñosExpe tMatAExpe = new TMateriaAñosExpe(Integer.parseInt(stringID), Integer.parseInt(stringExperiencia));
							//TCursoNivel tCursoNivel = new TCursoNivel(Integer.parseInt(stringID), null, comboBoxNivel.getSelectedItem().toString().toUpperCase());

							Controlador.getInstance().action(EventoGUI.BUSCAR_MATERIA_PARA_AÑADIR_A_PROFESOR, tMatAExpe);
							//Controlador.getInstance().action(EventoGUI.BUSCAR_MATERIA_PARA_AÑADIR_A_PROFESOR_MODIFICAR, tMatAExpe);
							
							txtFieldID_Materia.setText("");
							txtExperiencia.setText("");
							
							txtFieldID_Materia.requestFocus();
						}else{
							JOptionPane.showMessageDialog(null, "Introduzca los años de experiencia");
							//Devolvemos el foco.
							txtExperiencia.requestFocus();
						}
							
					}else{
						JOptionPane.showMessageDialog(null, "Introduzca el ID de materia");
						//Devolvemos el foco.
						txtFieldID_Materia.requestFocus();
					}
				}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Solo valores númericos.");
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
	public class WLVentanaBuscarCursoMatricula implements WindowListener {

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
			//JPrincipalSMS.getInstance().setVisible(true);
			VentanaBuscarMateriaProfesor.this.dispose();
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
	
	private class MyModeloTabla extends AbstractTableModel {

		private static final long serialVersionUID = -1400601842772476569L;

		private String[] columnas = { "ID", "NOMBRE" };
		private ArrayList<TMateria> listaTabla = new ArrayList<TMateria>();

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
				TMateria i = listaTabla.get(rowIndex);

				if (columnIndex == 0)
					return i.getID();
				else if (columnIndex == 1)
					return i.getNombre();
				else 
					return null;
			}
		}

		@Override
		public String getColumnName(int col) {
			return columnas[col];
		}

		@SuppressWarnings("unused")
		public void add(TMateria i){
			boolean encontrado = false;
			int j = 0;

			while(!encontrado && j< listaTabla.size()){

				if(listaTabla.get(j).getID() == i.getID()){
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

		public void setListaTabla(ArrayList<TMateria> listaTabla) {
			this.listaTabla = listaTabla;
		}
	}
}
