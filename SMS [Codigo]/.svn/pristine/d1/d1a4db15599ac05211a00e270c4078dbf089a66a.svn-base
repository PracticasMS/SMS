/**
 * 
 */
package SMSJPA.Presentacion.Turno;

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

import SMSJPA.Negocio.Turno.TTurno;
import SMSJPA.Presentacion.Controlador.Controlador;
import SMSJPA.Presentacion.Controlador.EventoGUI;
import SMSJPA.Presentacion.JPrincipal.JPrincipalSMS;


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class VentanaListarTurnos extends JFrame {

	private static final long serialVersionUID = 1397619556807294138L;

	private static VentanaListarTurnos uniqueInstance;

	private MyModeloTabla model;

	private JScrollPane tableScrollPane;
	private JTable tTabla;
	private JButton botonAtras;
	private JPanel panelBotones;
	private JPanel panelDatos;
	private JPanel panelPrincipal;

	private boolean turnoParaProfe;

	public static void main(String args[]) {
		VentanaListarTurnos.getInstance().setVisible(true);
	}	
	
	public static VentanaListarTurnos getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new VentanaListarTurnos();
		}
		return uniqueInstance;
	}
	
	public VentanaListarTurnos(){
		super("Listar Turnos");

		create();
		agregarManejadoresDeEventos();

		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	// Agregamos oyentes
	private void agregarManejadoresDeEventos() {
		addWindowListener(new WLVentanaListarTurnos());

		ALVentanaListarTurnos oyente = new ALVentanaListarTurnos();
		botonAtras.addActionListener(oyente);
	}

	private void create() {
				
		panelPrincipal = new JPanel(new BorderLayout());
		this.setSize(450, 250);

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
		ArrayList<TTurno> misTurnos = (ArrayList<TTurno>) datos;
			
			switch (evento) {
				case (EventoGUI.LISTAR_TURNOS):{
		
					model.setListaTabla(misTurnos);
		
					tTabla.setModel(model);
		
					setLocationRelativeTo(null);
					//this.turnoParaProfe = false;
					
					Controlador.getInstance().action(EventoGUI.ABRIR_VENTANA_LISTAR_TURNOS, null);
					
				}break;
				
				case (EventoGUI.LISTAR_TURNOS_PARA_PROFESOR):{
					
					model.setListaTabla(misTurnos);
		
					tTabla.setModel(model);
					this.turnoParaProfe = true;
		
					//setLocationRelativeTo(null);
					
					//Controlador.getInstance().action(EventoGUI.ABRIR_VENTANA_LISTAR_TURNOS, null);
				}break;
		
				case (EventoGUI.LISTAR_TURNOS_ERRORAUX):{
		
					JOptionPane.showMessageDialog(null, "No existen turnos que listar.");
					if(!turnoParaProfe){
						Controlador.getInstance().action(EventoGUI.ABRIR_JPRINCIPAL, 0);
					}
					
					setVisible(false);
		
				}break;
		
				case (EventoGUI.LISTAR_TURNOS_ERROR):{
					//Mostramos un mensaje de error.
		
					JOptionPane.showMessageDialog(null, "Error al listar los turnos");
		
				}break;
			}
	}
	
	// ****************************************************//
	// ***************** Action Listener ******************//
	// ****************************************************//
	public class ALVentanaListarTurnos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent evento) {
			if(evento.getSource() == botonAtras){
				VentanaListarTurnos.this.dispose();
				if(!turnoParaProfe){
					Controlador.getInstance().action(EventoGUI.ABRIR_JPRINCIPAL, 0);
				}
			}			
		}
	}
	
	// ****************************************************//
	// ***************** Window Listener ******************//
	// ****************************************************//
	public class WLVentanaListarTurnos implements WindowListener {

		@Override
		public void windowActivated(WindowEvent arg0) {}

		@Override
		public void windowClosed(WindowEvent arg0) {}

		@Override
		public void windowClosing(WindowEvent arg0) {
			if(!turnoParaProfe){
				Controlador.getInstance().action(EventoGUI.ABRIR_JPRINCIPAL, 0);
			}
			VentanaListarTurnos.this.dispose();			
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
		
		private String[] columnas = { "ID", "HORA_INICIO", "HORA_FIN", "OBSERVACIONES" };
		private ArrayList<TTurno> listaTabla = new ArrayList<TTurno>();

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
				TTurno i = listaTabla.get(rowIndex);

				if (columnIndex == 0)
					return i.getID();
				else if (columnIndex == 1)
					return i.getHora_inicio();
				else if (columnIndex == 2)
					return i.getHora_fin();
				else if (columnIndex == 3)
					return i.getObservaciones();
				else 
					return null;
			}
		}

		@Override
		public String getColumnName(int col) {
			return columnas[col];
		}

		@SuppressWarnings("unused")
		public void add(TTurno i){
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

		public void setListaTabla(ArrayList<TTurno> listaTabla) {
			this.listaTabla = listaTabla;
		}
	}
	/**
	 * @return the turnoParaProfe
	 */
	public boolean isTurnoParaProfe() {
		return turnoParaProfe;
	}

	/**
	 * @param turnoParaProfe the turnoParaProfe to set
	 */
	public void setTurnoParaProfe(boolean turnoParaProfe) {
		this.turnoParaProfe = turnoParaProfe;
	}
}