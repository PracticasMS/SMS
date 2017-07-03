package SMSDAO.Presentacion.Matricula;


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

import SMSDAO.Negocio.Curso.TCurso;
import SMSDAO.Negocio.Matricula.TCursoNivel;
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
public class VentanaBuscarCursoMatricula extends JFrame{

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
	
	private JLabel labelID_Curso;
	private JTextField txtFieldID_Curso;
	
	private JLabel labelNivel;
	private JComboBox comboBoxNivel;
	
	private JButton botonBuscarCurso;
	private JButton botonAtras;
	private int tipoEventoGUI;

	private JPanel panelPrincipal;

	private static VentanaBuscarCursoMatricula uniqueInstance;
	
	public VentanaBuscarCursoMatricula(){
		super("Añadir Curso");
		
		create();
		
		agregarManejadoresDeEventos();
		
		setLocationRelativeTo(null);
		setResizable(false);
	}
	public static VentanaBuscarCursoMatricula getInstance() {
		if(uniqueInstance == null){
			uniqueInstance = new VentanaBuscarCursoMatricula();
		}
		
		return uniqueInstance;
	}
	
	private void create() {
		
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		//this.setLayout(new GridLayout(2,1));
		
		
		labelID_Curso = new JLabel("ID_Curso: ");
		txtFieldID_Curso = new  JTextField(10);
		
		botonBuscarCurso = new JButton("Añadir Curso");
		botonAtras = new JButton("Cerrar");
		
		panelDatos = new JPanel();
		panelBotones = new JPanel();
		//panelTabla = new JPanel(new GridLayout(2,1));
		panelTabla = new JPanel(new FlowLayout());
		//panelDatosTabla = new JPanel(new GridLayout(2,2));
		panelDatosTabla = new JPanel(new BorderLayout());

		
		
		//***NIVEL***
		labelNivel = new JLabel("Nivel curso: ");
		Vector<String> items = new Vector<String>();
		items.add("Normal");
		items.add("Diversificación");
		items.add("Excelencia");
		
		comboBoxNivel = new JComboBox(items);
		
		//***TABLA***
		
		model = new MyModeloTabla();
		tTabla = new JTable(model);
		
		tableScrollPane = new JScrollPane(tTabla);

		panelDatosTabla.add(tableScrollPane);
		//panelTabla.add(panelDatosTabla);
		
		//**********
		
		panelDatos.add(labelNivel);
		panelDatos.add(comboBoxNivel);
		
		panelDatos.add(labelID_Curso);
		panelDatos.add(txtFieldID_Curso);
		
		panelBotones.add(botonAtras);
		panelBotones.add(botonBuscarCurso);
		
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
		
		ALVentanaBuscarCursoMatricula oyente = new ALVentanaBuscarCursoMatricula();
		this.addWindowListener(new WLVentanaBuscarCursoMatricula());
		botonBuscarCurso.addActionListener(oyente);
		botonAtras.addActionListener(oyente);
		
	}
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void update(int evento, Object datos) {
		
		
		
		switch (evento){
		
		case EventoGUI.BUSCAR_CURSO_ERROR:{
			JOptionPane.showMessageDialog(null, "El curso no existe en el sistema");
			
		}; break;
		
		case (EventoGUI.LISTAR_CURSOS):{
			@SuppressWarnings("unchecked")
			ArrayList<TCurso> misReservas = (ArrayList<TCurso>) datos;

			model.setListaTabla(misReservas);

			tTabla.setModel(model);

		}break;
		
		case (EventoGUI.LISTAR_CURSOS_ERRORAUX):{

			JOptionPane.showMessageDialog(null, "No existen cursos que listar.");
			JPrincipalSMS.getInstance().setVisible(true);

		}break;
		
		case (EventoGUI.LISTAR_CURSOS_ERROR):{
			//Mostramos un mensaje de error.

			JOptionPane.showMessageDialog(null, "Error al listar los cursos");

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
	public class ALVentanaBuscarCursoMatricula implements ActionListener{

		/* (sin Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == botonAtras){
				VentanaBuscarCursoMatricula.this.txtFieldID_Curso.setText("");				
				VentanaBuscarCursoMatricula.this.dispose();

			}
			
			if(event.getSource() == botonBuscarCurso){
				int nivel = 1;
				String stringID = "";
				stringID = txtFieldID_Curso.getText();
				
				//******* Obtencion de datos de la ventana ******
				try{
					if (!stringID.equalsIgnoreCase("")){
						
						TCursoNivel tCursoNivel = new TCursoNivel(Integer.parseInt(stringID), null, comboBoxNivel.getSelectedItem().toString().toUpperCase());

							Controlador.getInstance().action(EventoNegocio.BUSCAR_CURSO_PARA_AÑADIR_A_MATRICULA, tCursoNivel);
							//JOptionPane.showMessageDialog(null, tCursoNivel.getNivel());
							
					}else{
						JOptionPane.showMessageDialog(null, "Introduzca el ID_Curso");
						//Devolvemos el foco.
						txtFieldID_Curso.requestFocus();
					}
				}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Introduzca un ID valido");
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
			VentanaBuscarCursoMatricula.this.dispose();
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
	
	private class MyModeloTabla extends AbstractTableModel {

		private static final long serialVersionUID = -1400601842772476569L;

		private String[] columnas = { "ID", "NOMBRE" };
		private ArrayList<TCurso> listaTabla = new ArrayList<TCurso>();

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
				TCurso i = listaTabla.get(rowIndex);

				if (columnIndex == 0)
					return i.getId_Curso();
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
		public void add(TCurso i){
			boolean encontrado = false;
			int j = 0;

			while(!encontrado && j< listaTabla.size()){

				if(listaTabla.get(j).getId_Curso() == i.getId_Curso()){
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

		public void setListaTabla(ArrayList<TCurso> listaTabla) {
			this.listaTabla = listaTabla;
		}
	}
}
