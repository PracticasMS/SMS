/**
 * 
 */
package SMSJPA.Presentacion.Materia;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
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
import SMSJPA.Negocio.Turno.TTurno;
import SMSJPA.Presentacion.Controlador.Controlador;
import SMSJPA.Presentacion.Controlador.EventoGUI;
import SMSJPA.Presentacion.Materia.VentanaMostrarMateria.MyModeloTabla;
import SMSJPA.Presentacion.Turno.VentanaModificarTurno;
import SMSJPA.Presentacion.Turno.VentanaModificarTurno.ALVentanaModificarTurno;
import SMSJPA.Presentacion.Turno.VentanaModificarTurno.WLVentanaModificarTurno;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class VentanaModificarMateria extends JFrame {
	
	private static VentanaModificarMateria uniqueInstance;
	
	//id, id_profesor, nombre y descripcion.
	
	private JLabel labelId;
	private JLabel labelNombre;
	private JLabel labelDescripcion;

	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtDescripcion;

	private JButton BotonModificar;
	private JButton botonAtras;
	
	private MyModeloTabla model;
	
	private JTable tTablaProfesores;
	
	private JScrollPane tableScrollPane;
	
	private JPanel panelDatosArriba;
	private JPanel panelBotones;
	private JPanel panelTabla;
	private JPanel panelTablaYBotones;

	public static VentanaModificarMateria getInstance() {
		
		if(uniqueInstance == null){
			
			uniqueInstance = new VentanaModificarMateria();
			
		}
		
		return uniqueInstance;
	}
	
	public static void main(String args[]) {
		VentanaModificarMateria.getInstance().setVisible(true);
	}
	
	
	public VentanaModificarMateria() {
		super("Modificar Materia");
		create();
		agregarManejadoresDeEventos();
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public void limpiarCampos(){
		txtDescripcion.setText("");
		txtId.setText("");
		txtNombre.setText("");
	}
	
	// Agregamos oyentes
	private void agregarManejadoresDeEventos() {
		addWindowListener(new WLVentanaModificarMateria());

		ALVentanaModificarMateria oyente = new ALVentanaModificarMateria();
		BotonModificar.addActionListener(oyente);
		botonAtras.addActionListener(oyente);
		
	}
	
	private void create() {
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setSize(300, 300);
		this.setLayout(new BorderLayout());
		
		//ID
		labelId = new JLabel("ID: ");
		txtId = new JTextField(5);
		txtId.setEditable(false);

		//Descripcion

		labelDescripcion = new JLabel("Descripcion: ");
		txtDescripcion = new JTextField(35);
		
		//Nombre

		labelNombre = new JLabel("Nombre: ");
		txtNombre = new JTextField(15);
				
		

		panelDatosArriba = new JPanel();
		panelDatosArriba.setLayout(new FlowLayout());
		
		panelBotones = new JPanel();

		panelDatosArriba.add(labelId);
		panelDatosArriba.add(txtId);
		
		panelDatosArriba.add(labelNombre);
		panelDatosArriba.add(txtNombre);
		
		panelDatosArriba.add(labelDescripcion);
		panelDatosArriba.add(txtDescripcion);

		//Botones
		BotonModificar = new JButton("Modificar");
		botonAtras = new JButton("Atras");

		//Agregado de botones al panel.
		panelBotones.add(botonAtras);
		panelBotones.add(BotonModificar);
		
		
		
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

		panelTablaYBotones = new JPanel();
		panelTablaYBotones.add(panelTabla, BorderLayout.CENTER);

		this.add(panelTablaYBotones, BorderLayout.CENTER);

		this.add(panelDatosArriba, BorderLayout.NORTH);
		//this.add(panelDatosDescripcion, BorderLayout.NORTH);
		this.add(panelBotones, BorderLayout.SOUTH);
		setLocationRelativeTo(null);

		// Inicializamos la vista.
		limpiarCampos();
		txtNombre.requestFocus();

		pack();
	}



	public void update(int eventoGUI, Object datos) {
		
		switch (eventoGUI) {
		case EventoGUI.MOSTRAR_MATERIA:{
			TMateria miMateria = (TMateria) datos;
			this.setVisible(true);
			//ID
			this.txtId.setText(Integer.toString(miMateria.getID()));
			
			//Nombre
			this.txtNombre.setText(miMateria.getNombre());
			
			// observaciones
			this.txtDescripcion.setText(miMateria.getDescripcion());
			
			// Profesores
			
			model.setListaTabla(miMateria.getProfesores());
			
		}
		break;
		
		case (EventoGUI.MATERIA_MODIFICADO): {
			Integer ID = (Integer) datos;

			JOptionPane.showMessageDialog(null, "Materia con [ ID: " + ID.intValue() + " ] Modificada.");

			limpiarCampos();

			//Mandamos el foco al primer campo.
			VentanaModificarMateria.this.dispose();
			Controlador.getInstance().action(EventoGUI.ABRIR_JPRINCIPAL, null);
		}
		break;
		case (EventoGUI.BUSCAR_MATERIA_ERROR ): {
			JOptionPane.showMessageDialog(null, "La Materia no existe en la BBDD");
			txtId.requestFocus();
			Controlador.getInstance().action(EventoGUI.ABRIR_JPRINCIPAL, null);
		}
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

		public void setListaTabla(ArrayList<TProfesorAñosExpe> arrayList) {
			this.listaTabla = arrayList;
		}

		public ArrayList<TProfesorAñosExpe> getListaTabla() {
			return this.listaTabla;
		}

	}
	
	

	
	
	public class WLVentanaModificarMateria implements WindowListener {

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Apéndice de método generado automáticamente
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			VentanaModificarMateria.this.dispose();
			Controlador.getInstance().action(EventoGUI.ABRIR_JPRINCIPAL, null);
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			VentanaModificarMateria.this.dispose();
			Controlador.getInstance().action(EventoGUI.ABRIR_JPRINCIPAL, null);
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Apéndice de método generado automáticamente
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Apéndice de método generado automáticamente
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Apéndice de método generado automáticamente
			
		}

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Apéndice de método generado automáticamente
			
		}
	}
	
	// ****************************************************//
	// ***************** Action Listener ******************//
	// ****************************************************//

	public class ALVentanaModificarMateria implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			if (event.getSource() == botonAtras) {

				limpiarCampos();
				VentanaModificarMateria.this.dispose();
				Controlador.getInstance().action(EventoGUI.ABRIR_JPRINCIPAL, 0);
			}

			if (event.getSource() == BotonModificar) {

				try{
					// ******* Obtencion de datos de la ventana ******
					String Descripcion = txtDescripcion.getText();
					String nombre = txtNombre.getText();
					
					if (!Descripcion.equalsIgnoreCase("")){
						if(!nombre.equalsIgnoreCase("")){
							
							TMateria tmateria = new TMateria(Integer.parseInt(txtId.getText()), 1, null, nombre, Descripcion);
							
							Controlador.getInstance().action(EventoGUI.MODIFICAR_MATERIA, tmateria);
							
							
						}
						else{
							JOptionPane.showMessageDialog(null, "Introduce algun nombre a la asignatura.");
							
						}
						
					}
					else{
						JOptionPane.showMessageDialog(null, "Introduce alguna observación.");
						//txtFieldObservaciones.requestFocus();
					}


				} catch (NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Introduzca datos correctamente");
				}
				
			}
			
						
			
		}
	}
	
	
}