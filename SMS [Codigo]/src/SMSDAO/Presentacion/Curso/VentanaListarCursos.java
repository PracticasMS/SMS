/**
 * 
 */
package SMSDAO.Presentacion.Curso;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
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

import SMSDAO.Negocio.Curso.TCurso;
import SMSDAO.Presentacion.JPrincipal.EventoGUI;
import SMSDAO.Presentacion.JPrincipal.JPrincipalSMS;



/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author 
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VentanaListarCursos extends JFrame {

	private static final long serialVersionUID = -4745547839503845772L;

	private static VentanaListarCursos uniqueInstance = null; // instancia sigleton

	private MyModeloTabla model;

	private JScrollPane tableScrollPane;
	private JTable tTabla;
	private JButton botonAtras;
	private JPanel panelBotones;
	private JPanel panelDatos;
	private JPanel panelPrincipal;



	public static void main(String []args){
		VentanaListarCursos.getInstance().setVisible(true);
	}
	

	/**
	 * @throws HeadlessException
	 */
	public VentanaListarCursos(){
		super("Listar Cursos");

		create();
		agregarManejadoresDeEventos();

		setLocationRelativeTo(null);
		setResizable(false);
	}

	public static VentanaListarCursos getInstance(){
		if(uniqueInstance == null){
			uniqueInstance = new VentanaListarCursos();
		}

		return uniqueInstance;
	}

	/**
	 * 
	 */
	private void create() {

		//panelPrincipal = new JPanel(new GridLayout(2,1));
		panelPrincipal = new JPanel(new BorderLayout());
		//panelPrincipal.setBorder(BorderFactory.createTitledBorder("Panel Principal"));
		this.setSize(300, 200);

		panelDatos = new JPanel(new BorderLayout());
		//panelDatos.setBorder(BorderFactory.createTitledBorder("Panel Datos"));
		model = new MyModeloTabla();
		tTabla = new JTable(model);
		tableScrollPane = new JScrollPane(tTabla);
		//tTabla.setFillsViewportHeight(true);
		//tableScrollPane.setBorder(BorderFactory.createTitledBorder("Tabla datos"));

		panelDatos.add(tableScrollPane);

		botonAtras = new JButton("Atras");
		panelBotones = new JPanel();
		//panelBotones.setBorder(BorderFactory.createTitledBorder("Panel botones"));
		panelBotones.add(botonAtras);

		panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
		panelPrincipal.add(panelDatos, BorderLayout.CENTER);

		this.add(panelPrincipal);

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);

		//pack();
	}

	/**
	 * 
	 */
	private void agregarManejadoresDeEventos() {
		ALVentanaListarCursos oyente = new ALVentanaListarCursos();	
		this.addWindowListener(new EscuchaVentana());

		botonAtras.addActionListener(oyente);
	}


	//****************************************************//
	//***************** Action Listener ******************//
	//****************************************************// 

	public class ALVentanaListarCursos implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {

			if(event.getSource() == botonAtras){
				VentanaListarCursos.this.dispose();
				JPrincipalSMS.getInstance().setVisible(true);
			}
		}
	}


	//****************************************************//
	//***************** Window Listener ******************//
	//****************************************************// 

	class EscuchaVentana implements WindowListener{

		@Override
		public void windowActivated(WindowEvent e) {
		}

		@Override
		public void windowClosed(WindowEvent e) {

		}

		@Override
		public void windowClosing(WindowEvent e) {
			JPrincipalSMS.getInstance().setVisible(true);
			VentanaListarCursos.this.dispose();
		}

		@Override
		public void windowDeactivated(WindowEvent e) {

		}

		@Override
		public void windowDeiconified(WindowEvent e) {

		}

		@Override
		public void windowIconified(WindowEvent e) {

		}

		@Override
		public void windowOpened(WindowEvent e) {

		}
	}

	public void update(int evento, Object datos) {
		
		@SuppressWarnings("unchecked")
		ArrayList<TCurso> misReservas = (ArrayList<TCurso>) datos;
		
		switch (evento) {
		case (EventoGUI.LISTAR_CURSOS):{

			model.setListaTabla(misReservas);

			tTabla.setModel(model);

			setLocationRelativeTo(null);

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