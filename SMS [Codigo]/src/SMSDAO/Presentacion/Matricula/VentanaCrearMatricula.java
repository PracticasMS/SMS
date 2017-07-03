/**
 * 
 */
package SMSDAO.Presentacion.Matricula;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
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

import org.freixas.jcalendar.JCalendarCombo;

import SMSDAO.Negocio.Matricula.TCursoNivel;
import SMSDAO.Negocio.Matricula.TMatricula;
import SMSDAO.Presentacion.Controlador.Controlador;
import SMSDAO.Presentacion.JPrincipal.EventoGUI;
import SMSDAO.Presentacion.JPrincipal.EventoNegocio;
import SMSDAO.Presentacion.JPrincipal.JPrincipalSMS;

public class VentanaCrearMatricula extends JFrame {

	private static final long serialVersionUID = 7174590503159048790L;

	private static VentanaCrearMatricula uniqueInstance;
	// DNI
	private JLabel labelDNI;
	private JTextField txtField_DNI;
	// Precio
	private JLabel labelPrecio;
	private JTextField txtField_Precio;
	// Label TIPO
	private JLabel labelTipo;
	private JComboBox comboTipo;
	// Fecha curso
	private JLabel labelFechaCurso;
	private JCalendarCombo calendarComboFecha_alumno;

	// Niveles
	private JLabel labelNivelesCursos;
	private JTextField txtField_NivelesCursos;

	private JScrollPane tableScrollPane;
	private JTable tTablaCursos;

	private JButton botonCrearMatricula;
	private JButton botonAtras;
	private JButton botonAñadirCursoAMatricula;
	private JButton botonQuitarCursoAMatricula;

	private JPanel panelDatos;
	private JPanel panelCentral;
	private JPanel panelTabla;
	private JPanel panelBotonesCrear;
	private JPanel panelCentralBotones;
	private JPanel panelSur;
	private JPanel panelBotonesDeTabla;

	private MyModeloTabla model;

	private JPanel panelTablaYBotones;

	public static void main(String[] args) {
		VentanaCrearMatricula.getInstance().setVisible(true);
	}

	public VentanaCrearMatricula() {
		super("Crear Matrícula");

		create();
		agregarManejadoresDeEventos();

		setLocationRelativeTo(null);
		setResizable(false);
	}

	public static VentanaCrearMatricula getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new VentanaCrearMatricula();
		}

		return uniqueInstance;
	}

	public void update(int eventoGUI, Object datos) {
		//TCursoNivel cursoNivel = (TCursoNivel) datos;
		
		switch (eventoGUI) {
		case (EventoGUI.MATRICULA_CREADO): {
			Integer ID_Matricula = 0;
			try {
				ID_Matricula = (Integer) datos;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,
						"Error al convertir a entero la ID_Matricula");
			}

			JOptionPane.showMessageDialog(null, "Matrícula con [ ID: "
					+ ID_Matricula.intValue() + " ] Creada.");

			// Vaciamos los campos.
			vaciarCampos();

			// Mandamos el foco al primer campo.
			txtField_DNI.requestFocus();
		}
			break;

		case (EventoGUI.MATRICULA_CREAR_ERROR): {
			JOptionPane.showMessageDialog(null, "Error al crear la matrícula");
		}
		break;
		case (EventoGUI.MATRICULA_CREAR_ERROR_VIGENTE): {
			JOptionPane.showMessageDialog(null, "Matrícula ya vigente.");
		}
		break;
		
		case (EventoGUI.MATRICULA_CREAR_ERROR_CURSOS): {
			JOptionPane.showMessageDialog(null, "Curso no existente o no activo. Operación cancelada");
		}
		break;
		
		case (EventoGUI.MATRICULA_CREAR_ERROR_ALUMNO_NOEXISTS): {
			JOptionPane.showMessageDialog(null, "DNI invalido. Inactivo o inexistente.");
		}
		break;

		case (EventoGUI.BUSCAR_CURSO_PARA_AÑADIR_A_MATRICULA): {
			model.add((TCursoNivel) datos);
			
			
		}
		break;
		
		}
	}
		

	public void create() {
		panelCentral = new JPanel();
		// panelTabla = new JPanel();
		panelCentralBotones = new JPanel();

		panelDatos = new JPanel();
		panelDatos.setBorder(BorderFactory
				.createTitledBorder("Datos de la matrícula"));

		labelDNI = new JLabel("DNI: ");
		txtField_DNI = new JTextField(10);
		// Precio
		labelPrecio = new JLabel("Precio: ");
		txtField_Precio = new JTextField(10);
		// Label TIPO
		labelTipo = new JLabel("Tipo: ");
		comboTipo = new JComboBox();
		comboTipo.addItem("Normal");
		comboTipo.addItem("Fam_Numerosa");
		comboTipo.addItem("Becario");
		// Fecha curso
		// labelFechaCurso = new JLabel("Fecha: ");
		// calendarComboFecha_alumno = new JCalendarCombo();

		panelDatos.add(labelDNI);
		panelDatos.add(txtField_DNI);
		panelDatos.add(labelPrecio);
		panelDatos.add(txtField_Precio);
		panelDatos.add(labelTipo);
		panelDatos.add(comboTipo);
		// panelDatos.add(labelFechaCurso);
		// panelDatos.add(calendarComboFecha_alumno);

		this.add(panelDatos, BorderLayout.NORTH);
		setLocationRelativeTo(null);

		// *******************
		// *******************
		// ****TABLA**********
		// *******************
		// *******************
		// *******************

		panelTabla = new JPanel(new BorderLayout());
		panelTabla.setBorder(BorderFactory
				.createTitledBorder("Cursos asociados"));
		this.setSize(300, 200);

		model = new MyModeloTabla();
		tTablaCursos = new JTable(model);
		tableScrollPane = new JScrollPane(tTablaCursos);

		panelTabla.add(tableScrollPane);

		// **************************************
		// PANEL BOTONES DE TABLA
		panelBotonesDeTabla = new JPanel(new GridLayout(3, 1));
		panelBotonesDeTabla.setBorder(BorderFactory
				.createTitledBorder("Opciones"));

		botonAñadirCursoAMatricula = new JButton("Añadir Curso");
		botonQuitarCursoAMatricula = new JButton("Quitar Curso");

		panelBotonesDeTabla.add(botonAñadirCursoAMatricula);
		panelBotonesDeTabla.add(new Panel());
		panelBotonesDeTabla.add(botonQuitarCursoAMatricula);

		panelTablaYBotones = new JPanel();
		panelTablaYBotones.add(panelTabla, BorderLayout.CENTER);
		panelTablaYBotones.add(panelBotonesDeTabla, BorderLayout.WEST);

		this.add(panelTablaYBotones);

		// panel de botones crear

		panelBotonesCrear = new JPanel();
		panelBotonesCrear.setBorder(BorderFactory
				.createTitledBorder("Finalizar proceso"));
		botonAtras = new JButton("Atras");
		botonCrearMatricula = new JButton("Crear Matricula");

		panelBotonesCrear.add(botonAtras);
		panelBotonesCrear.add(botonCrearMatricula);

		this.add(panelBotonesCrear, BorderLayout.SOUTH);

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		//
		pack();
	}

	public class ALVentanaCrearMatricula implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {

			if (event.getSource() == botonAñadirCursoAMatricula) {
				
				java.awt.Dimension pantallaTamano = Toolkit.getDefaultToolkit().getScreenSize();
				int ancho = ((pantallaTamano.width / 2) - (VentanaBuscarCursoMatricula.getInstance().getWidth()) / 2);
				int alto = (pantallaTamano.height / 2) - (VentanaBuscarCursoMatricula.getInstance().getHeight() );
				int alto2 = alto + VentanaBuscarCursoMatricula.getInstance().getHeight() + 10 ;

				VentanaBuscarCursoMatricula.getInstance().setLocation(pantallaTamano.width-1,alto); // 1300 300
				VentanaBuscarCursoMatricula.getInstance().setVisible(true);

				moverAutomaticamenteVentana(VentanaBuscarCursoMatricula.getInstance(),pantallaTamano.width-1,ancho*2,alto,alto, 1);

				Controlador.getInstance().action(EventoNegocio.LISTAR_CURSOS_ParaMatricula,null);
				//VentanaListarCursos.getInstance().setLocation(pantallaTamano.width-1,alto2); // 1300 450
				
				//moverAutomaticamenteVentana(VentanaListarCursos.getInstance(),pantallaTamano.width-1,ancho*2,alto2,alto2, 1);
				
				
			} else if (event.getSource() == botonAtras) {
				
				vaciarCampos();
				VentanaCrearMatricula.this.dispose();
				VentanaBuscarCursoMatricula.getInstance().dispose();
				JPrincipalSMS.getInstance().setVisible(true);
			
			}else if (event.getSource() == botonQuitarCursoAMatricula) {
				int fila = tTablaCursos.getSelectedRow();
				model.remove(fila);
				
			} else if (event.getSource() == botonCrearMatricula) {

				// Cogemos todos los datos de la ventana.
				boolean todocorrecto = true;
				int DNI = 0;
				int precio = 0;
				try {
					DNI = Integer.parseInt(txtField_DNI.getText());
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "DNI Incorrecto");
					VentanaCrearMatricula.this.txtField_DNI.requestFocus();
					todocorrecto = false;
				}
				if (todocorrecto) {
					try {
						precio = Integer.parseInt(txtField_Precio.getText());
						if(precio < 0)throw new Exception("Precio Negativo");
					} catch (NumberFormatException t) {
						JOptionPane.showMessageDialog(null, "Precio no válido");
						todocorrecto = false;
						VentanaCrearMatricula.this.txtField_Precio.requestFocus();
					}
					catch (Exception e) {
						
						JOptionPane.showMessageDialog(null, "El precio debe tener un valor positivo");
						VentanaCrearMatricula.this.txtField_Precio.requestFocus();
						todocorrecto = false;
					}
					String tipo = comboTipo.getSelectedItem().toString();

					ArrayList<TCursoNivel> misCursosNiveles = model.getListaTabla();
					if (todocorrecto) {
						// Comprobamos que todo lo que ha metido es correcto.
						if (DNI != 0 && precio != 0 && !misCursosNiveles.isEmpty() ) {
							TMatricula transMatri = new TMatricula(DNI,
									tipo, precio, null, misCursosNiveles, 1);
							Controlador.getInstance().action( EventoNegocio.CREAR_MATRICULA, transMatri);
						} else if (DNI == 0) {
							JOptionPane.showMessageDialog(null, "Introduce DNI alumno");
							txtField_DNI.requestFocus();
						} else if (precio == 0) {
							JOptionPane.showMessageDialog(null, "Introduce precio");
							txtField_Precio.requestFocus();
						} else if (misCursosNiveles.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Ningún curso asignado.");
						}
					}
				}
			}
		}
	}

	// Metodo realizar movimiento.
	public void moverAutomaticamenteVentana(JFrame ventana, int desdeX, int hastaX,
			int desdeY, int hastaY, int demora) {
		//System.out.println(" desdeX " + desdeX + " hastaX " + hastaX	+ " desdeY " + desdeY + " hastaY " + hastaY);
		
		while ((desdeX != hastaX) || (desdeY != hastaY)) {
			// Movimiento vertical
			if (desdeY != hastaY) {
				try {
					Thread.sleep(demora / 2);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (desdeY < hastaY) {
					desdeY++;
				} else if (desdeY != hastaY) {
					desdeY--;
				}
				ventana.setLocation(desdeX, desdeY);
			}
			// Movimiento horizontal
			if (desdeX != hastaX) {
				try {
					Thread.sleep(demora / 2);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (desdeX < hastaX) {
					desdeX++;
				} else if (desdeX != hastaX) {
					desdeX--;
				}
				ventana.setLocation(desdeX, desdeY);
			}
		}
	}
	
	private void vaciarCampos(){
		txtField_DNI.setText("");
		txtField_Precio.setText("");
		model.clear();
		//tTablaCursos.setModel(new MyModeloTabla());
	}

	private void agregarManejadoresDeEventos() {
		ALVentanaCrearMatricula oyente = new ALVentanaCrearMatricula();
		this.addWindowListener(new WLVentanaCrearMatricula());

		botonAñadirCursoAMatricula.addActionListener(oyente);
		botonQuitarCursoAMatricula.addActionListener(oyente);
		botonCrearMatricula.addActionListener(oyente);
		botonAtras.addActionListener(oyente);
	}

	// TABLA
	public class MyModeloTabla extends AbstractTableModel {

		private static final long serialVersionUID = -1400601842772476569L;

		private String[] columnas = { "ID", "NOMBRE", "NIVEL" };
		private ArrayList<TCursoNivel> listaTabla = new ArrayList<TCursoNivel>();

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
				TCursoNivel i = listaTabla.get(rowIndex);

				if (columnIndex == 0)
					return i.getId_Curso();
				else if (columnIndex == 1)
					return i.getNombre();
				else if (columnIndex == 2)
					return i.getNivel();
				else
					return null;
			}
		}

		@Override
		public String getColumnName(int col) {
			return columnas[col];
		}

		@SuppressWarnings("unused")
		public void add(TCursoNivel i){
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

		public void remove(int fila) {
			if(fila!=-1){
				//borramos la fila de la tTablaCursos
				tTablaCursos.removeRowSelectionInterval(fila, fila);
				listaTabla.remove(fila);

				this.fireTableDataChanged();
			}
			else{
				//no podemos borrar nada porque no esta seleccionado
				JOptionPane.showMessageDialog(null, "No hay ningún curso seleccionado para quitar de la lista");
			}
			
		}		
		
		@SuppressWarnings("unused")
		public void clear() {
			listaTabla.clear();
			this.fireTableDataChanged();
		}

		public void setListaTabla(ArrayList<TCursoNivel> listaTabla) {
			this.listaTabla = listaTabla;
		}
		
		public ArrayList<TCursoNivel> getListaTabla() {
			return this.listaTabla;
		}

	}

	public class WLVentanaCrearMatricula implements WindowListener {

		public void windowOpened(WindowEvent arg0) {

		}

		public void windowClosing(WindowEvent arg0) {
			vaciarCampos();
			VentanaCrearMatricula.this.dispose();
			VentanaBuscarCursoMatricula.getInstance().dispose();
			JPrincipalSMS.getInstance().setVisible(true);

		}

		public void windowClosed(WindowEvent arg0) {
			
		}

		public void windowIconified(WindowEvent arg0) {

		}

		public void windowDeiconified(WindowEvent arg0) {

		}

		public void windowActivated(WindowEvent arg0) {

		}

		public void windowDeactivated(WindowEvent arg0) {

		}

	}
}