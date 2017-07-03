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

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.AbstractTableModel;

import SMSJPA.Negocio.Profesor.TProfesor;
import SMSJPA.Presentacion.Controlador.Controlador;
import SMSJPA.Presentacion.Controlador.EventoGUI;
import SMSJPA.Presentacion.JPrincipal.JPrincipalSMS;


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class VentanaListarProfesor extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9046841381687130439L;

	private static VentanaListarProfesor uniqueInstance;
	
	private JButton botonAtras;

	private JTable tTabla;
	
	private JScrollPane tableScrollPane;

	private MyModeloTabla model;
	
	private JPanel panelPrincipal;
	private JPanel panelDatos;
	private JPanel panelBotones;
	
	public static void main(String args[]) {
		VentanaListarProfesor.getInstance().setVisible(true);
	}

	public static VentanaListarProfesor getInstance() {
		
		if(uniqueInstance == null) uniqueInstance = new VentanaListarProfesor();
		
		return uniqueInstance;
		
	}
	
	public VentanaListarProfesor() {
		// TODO Apéndice de constructor generado automáticamente
		super("Listar Profesores");

		create();
		agregarManejadoresDeEventos();

		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	// Agregamos oyentes
	private void agregarManejadoresDeEventos() {
		addWindowListener(new WLVentanaListarProfesor());

		ALVentanaListarProfesor oyente = new ALVentanaListarProfesor();
		botonAtras.addActionListener(oyente);
	}
	
	private void create() {
		
		panelPrincipal = new JPanel(new BorderLayout());
		this.setSize(750, 250);

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


	public void update(int eventoGUI, Object datos) {
		@SuppressWarnings("unchecked")
		ArrayList<TProfesor> misProfesores = (ArrayList<TProfesor>) datos;
			
			switch (eventoGUI) {
				case (EventoGUI.LISTAR_PROFESORES):{
		
					model.setListaTabla(misProfesores);
		
					tTabla.setModel(model);
		
					setLocationRelativeTo(null);
					
					Controlador.getInstance().action(EventoGUI.ABRIR_VENTANA_LISTAR_PROFESORES, null);
					
				}break;
		
				case (EventoGUI.LISTAR_PROFESORES_ERRORAUX):{
		
					JOptionPane.showMessageDialog(null, "No existen profesores que listar.");
					Controlador.getInstance().action(EventoGUI.ABRIR_JPRINCIPAL, 0);
		
				}break;
		
				case (EventoGUI.LISTAR_PROFESORES_ERROR):{
					//Mostramos un mensaje de error.
		
					JOptionPane.showMessageDialog(null, "Error al listar los Profesores");
		
				}break;
			}
	}
	
	public class ALVentanaListarProfesor implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == botonAtras){
				VentanaListarProfesor.this.dispose();
				Controlador.getInstance().action(EventoGUI.ABRIR_JPRINCIPAL, 0);
			}
			
		}
	}
	

	private class MyModeloTabla extends AbstractTableModel {

		private static final long serialVersionUID = 1109804275955269237L;
		
		private String[] columnas = { "ID", "NOMBRE", "APELLIDOS", "ID_TURNO", "TELEFONO", "EMAIL" };
		private ArrayList<TProfesor> listaTabla = new ArrayList<TProfesor>();

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
				TProfesor i = listaTabla.get(rowIndex);

				if (columnIndex == 0)
					return i.getId();
				else if (columnIndex == 1)
					return i.getNombre();
				else if (columnIndex == 2)
					return i.getApellidos();
				else if (columnIndex == 3)
					return i.getId_turno();
				else if (columnIndex == 4)
					return i.getTelefono();
				else if (columnIndex == 5)
					return i.getEmail();
				else 
					return null;
			}
		}

		@Override
		public String getColumnName(int col) {
			return columnas[col];
		}

		@SuppressWarnings("unused")
		public void add(TProfesor i){
			boolean encontrado = false;
			int j = 0;

			while(!encontrado && j< listaTabla.size()){

				if(listaTabla.get(j).getId() == i.getId()){
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

		public void setListaTabla(ArrayList<TProfesor> listaTabla) {
			this.listaTabla = listaTabla;
		}
	}
	
	
	public class WLVentanaListarProfesor implements WindowListener {

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Apéndice de método generado automáticamente
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			JPrincipalSMS.getInstance().setVisible(true);
			VentanaListarProfesor.this.dispose();
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			JPrincipalSMS.getInstance().setVisible(true);
			VentanaListarProfesor.this.dispose();
			
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
	
}