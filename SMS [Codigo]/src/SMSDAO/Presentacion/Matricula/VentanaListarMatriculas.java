
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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import SMSDAO.Negocio.Matricula.TMatricula;
import SMSDAO.Presentacion.JPrincipal.EventoGUI;
import SMSDAO.Presentacion.JPrincipal.JPrincipalSMS;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Eduardo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VentanaListarMatriculas extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8317981606967605750L;


	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static VentanaListarMatriculas uniqueInstance;
	
	
	private MyModeloTabla model;

	private JScrollPane tableScrollPane;
	private JTable tTabla;
	private JButton botonAtras;
	private JPanel panelBotones;
	private JPanel panelDatos;
	private JPanel panelPrincipal;
	
	public static void main(String[] args) {
		VentanaListarMatriculas.getInstance().setVisible(true);
	}

	
	public static VentanaListarMatriculas getInstance() {
		// begin-user-code
		
		if(uniqueInstance == null) {
			uniqueInstance = new VentanaListarMatriculas();
		}
		
		return uniqueInstance;
		// end-user-code
	}

	
	
	public VentanaListarMatriculas(){
		super("Listar Matriculas");

		create();
		agregarManejadoresDeEventos();

		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	private void create() {

		//panelPrincipal = new JPanel(new GridLayout(2,1));
		panelPrincipal = new JPanel(new BorderLayout());
		//panelPrincipal.setBorder(BorderFactory.createTitledBorder("Panel Principal"));
		this.setSize(750, 250);

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
		ALVentanaListarMatriculas oyente = new ALVentanaListarMatriculas();	
		this.addWindowListener(new WLVentanaListarMatriculas());

		botonAtras.addActionListener(oyente);
	}


	//****************************************************//
	//***************** Action Listener ******************//
	//****************************************************// 

	public class ALVentanaListarMatriculas implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {

			if(event.getSource() == botonAtras){
				VentanaListarMatriculas.this.dispose();
				JPrincipalSMS.getInstance().setVisible(true);
			}
		}
	}


	//****************************************************//
	//***************** Window Listener ******************//
	//****************************************************// 

	class WLVentanaListarMatriculas implements WindowListener{

		@Override
		public void windowActivated(WindowEvent e) {
		}

		@Override
		public void windowClosed(WindowEvent e) {

		}

		@Override
		public void windowClosing(WindowEvent e) {
			JPrincipalSMS.getInstance().setVisible(true);
			VentanaListarMatriculas.this.dispose();
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
		ArrayList<TMatricula> misReservas = (ArrayList<TMatricula>) datos;
		
		switch (evento) {
		case (EventoGUI.LISTAR_MATRICULAS):{

			model.setListaTabla(misReservas);

			tTabla.setModel(model);

			setLocationRelativeTo(null);

		}break;

		case (EventoGUI.LISTAR_MATRICULAS_ERRORAUX):{

			JOptionPane.showMessageDialog(null, "No existen matriculas que listar.");
			JPrincipalSMS.getInstance().setVisible(true);

		}break;

		case (EventoGUI.LISTAR_MATRICULAS_ERROR):{
			//Mostramos un mensaje de error.

			JOptionPane.showMessageDialog(null, "Error al listar las matriculas");

		}break;
		}
	}
	
	
	private class MyModeloTabla extends AbstractTableModel {

		private static final long serialVersionUID = -1400601842772476569L;

		private String[] columnas = { "ID_MATRÍCULA", "DNI", "TIPO", "PRECIO", "FECHA CURSO", "CANTIDAD CURSOS"};
		private ArrayList<TMatricula> listaTabla = new ArrayList<TMatricula>();

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
				TMatricula i = listaTabla.get(rowIndex);
				//int numCursos = i.getCursos().size();

				if (columnIndex == 0)
					return i.getID_Matricula();
				else if (columnIndex == 1)
					return letraDNI(i.getDNI());
				else if (columnIndex == 2)
					return i.getTipo().toUpperCase();
				else if (columnIndex == 3)
					return i.getPrecio();
				else if (columnIndex == 4)
					return procesarFecha(i.getFechaCurso());
				else if (columnIndex == 5)
					return i.getNumCursos();
				else 
					return null;
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
		
		public String procesarFecha(String fecha){
			fecha = fecha.substring(0, 4);
			int primerAño = Integer.parseInt(fecha);
			int segundoAño = primerAño+1;
			segundoAño = segundoAño%100;
			return primerAño + "/" + segundoAño;
		}
		

		@Override
		public String getColumnName(int col) {
			return columnas[col];
		}

		@SuppressWarnings("unused")
		public void add(TMatricula i){
			boolean encontrado = false;
			int j = 0;

			while(!encontrado && j< listaTabla.size()){

				if(listaTabla.get(j).getID_Matricula() == i.getID_Matricula()){
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

		public void setListaTabla(ArrayList<TMatricula> listaTabla) {
			this.listaTabla = listaTabla;
		}
	}
}