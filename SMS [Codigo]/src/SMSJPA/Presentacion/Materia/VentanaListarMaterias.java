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
import static javax.swing.JOptionPane.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.AbstractTableModel;

import SMSJPA.Negocio.Materia.TMateria;
import SMSJPA.Presentacion.Controlador.Controlador;
import SMSJPA.Presentacion.Controlador.EventoGUI;
import SMSJPA.Presentacion.JPrincipal.JPrincipalSMS;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class VentanaListarMaterias extends JFrame {
	private static final long serialVersionUID = 1397619556807294138L;

	private static VentanaListarMaterias uniqueInstance;

	private MyModeloTabla model;

	private JScrollPane tableScrollPane;
	private JTable tTabla;
	private JButton botonAtras;
	private JPanel panelBotones;
	private JPanel panelDatos;
	private JPanel panelPrincipal;

	public static void main(String args[]) {
		VentanaListarMaterias.getInstance().setVisible(true);
	}	
	
	public static VentanaListarMaterias getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new VentanaListarMaterias();
		}
		return uniqueInstance;
	}
	
	public VentanaListarMaterias(){
		super("Listar Materias");

		create();
		agregarManejadoresDeEventos();

		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	// Agregamos oyentes
	private void agregarManejadoresDeEventos() {
		addWindowListener(new WLVentanaListarMaterias());

		ALVentanaListarMaterias oyente = new ALVentanaListarMaterias();
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
	
	
	public void update(int evento, Object datos) {
		
		@SuppressWarnings("unchecked")
		ArrayList<TMateria> misMaterias = (ArrayList<TMateria>) datos;
			
			switch (evento) {
				case (EventoGUI.LISTAR_MATERIAS):{
		
					model.setListaTabla(misMaterias);
		
					tTabla.setModel(model);
		
					setLocationRelativeTo(null);
					
					Controlador.getInstance().action(EventoGUI.ABRIR_VENTANA_LISTAR_MATERIAS, null);
				}break;
		
				case (EventoGUI.LISTAR_MATERIAS_ERRORAUX):{
		
					JOptionPane.showMessageDialog(null, "No existen materias que listar.");
					Controlador.getInstance().action(EventoGUI.ABRIR_JPRINCIPAL, 0);
		
				}break;
		
				case (EventoGUI.LISTAR_MATERIAS_ERROR):{
					//Mostramos un mensaje de error.
		
					JOptionPane.showMessageDialog(null, "Error al listar los materias");
		
				}break;
			}
	}
	
	// ****************************************************//
	// ***************** Action Listener ******************//
	// ****************************************************//
	public class ALVentanaListarMaterias implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent evento) {
			if(evento.getSource() == botonAtras){
				VentanaListarMaterias.this.dispose();
				Controlador.getInstance().action(EventoGUI.ABRIR_JPRINCIPAL, 0);
			}			
		}
	}
	
	// ****************************************************//
	// ***************** Window Listener ******************//
	// ****************************************************//
	public class WLVentanaListarMaterias implements WindowListener {

		@Override
		public void windowActivated(WindowEvent arg0) {}

		@Override
		public void windowClosed(WindowEvent arg0) {}

		@Override
		public void windowClosing(WindowEvent arg0) {
			JPrincipalSMS.getInstance().setVisible(true);
			VentanaListarMaterias.this.dispose();			
		}

		@Override
		public void windowDeactivated(WindowEvent arg0) {}

		@Override
		public void windowDeiconified(WindowEvent arg0) {}

		@Override
		public void windowIconified(WindowEvent arg0) {}

		@Override
		public void windowOpened(WindowEvent arg0) {}
	}
	private class MyModeloTabla extends AbstractTableModel {

		private static final long serialVersionUID = 1109804275955269237L;
		
		private String[] columnas = { "ID", "NOMBRE", "DESCRIPCIÓN" };
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
				else if (columnIndex == 2)
					return i.getDescripcion();
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