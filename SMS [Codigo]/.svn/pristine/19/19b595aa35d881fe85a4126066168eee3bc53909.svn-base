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

import SMSDAO.Negocio.Matricula.TCursoNivel;
import SMSDAO.Negocio.Matricula.TMatricula;
import SMSDAO.Presentacion.Alumnos.VentanaModificarAlumno;
import SMSDAO.Presentacion.Controlador.Controlador;
import SMSDAO.Presentacion.JPrincipal.EventoGUI;
import SMSDAO.Presentacion.JPrincipal.EventoNegocio;
import SMSDAO.Presentacion.JPrincipal.JPrincipalSMS;
/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Eduardo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VentanaModificarMatricula extends JFrame {
	
	private static final long serialVersionUID = -2162145823190449376L;

	
	private static VentanaModificarMatricula uniqueInstance;
	
	//id_matricula
	private JLabel labelID_Matricula;
	private JTextField txtField_ID_Matricula;
	
	//alumno
	private JLabel labelDNI;
	private JTextField txtFieldDNI;
	//Precio
	private JLabel labelPrecio;
	private JTextField txtField_Precio;
	//Label TIPO
	private JLabel labelTipo;
	private JComboBox comboTipo;
	
	
	
	private JScrollPane tableScrollPane;
	private JTable tTablaCursos;
	
	private JButton botonModificarMatricula;
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
	
	public static VentanaModificarMatricula getInstance() {
		
		if (uniqueInstance == null){
			
			uniqueInstance = new VentanaModificarMatricula();
		}
		
		return uniqueInstance;
	}
	
	
	public VentanaModificarMatricula(){
		
		super("Modificar Matrícula");

		create();
		agregarManejadoresDeEventos();

		setLocationRelativeTo(null);
		setResizable(false);
		
	}
	
	public void create()
	{
		panelCentral = new JPanel();
		panelCentralBotones = new JPanel();
		
		panelDatos = new JPanel();
		panelDatos.setBorder(BorderFactory.createTitledBorder("Datos de la Matrícula"));
		
		//matricula
		labelID_Matricula = new JLabel("ID_Matricula: ");
		txtField_ID_Matricula = new JTextField(10);
		//alumno
		labelDNI = new JLabel("DNI: ");
		txtFieldDNI = new JTextField(10);
		//Precio
		labelPrecio = new JLabel("Precio: ");
		txtField_Precio = new JTextField(10);
		//Label TIPO
		labelTipo = new JLabel("Tipo: ");
		comboTipo = new JComboBox();
		comboTipo.addItem("Normal");
		comboTipo.addItem("Fam_Numerosa");
		comboTipo.addItem("Becario");
		//Fecha curso
		
		panelDatos.add(labelID_Matricula);
		panelDatos.add(txtField_ID_Matricula);
		panelDatos.add(labelDNI);
		panelDatos.add(txtFieldDNI);
		panelDatos.add(labelPrecio);
		panelDatos.add(txtField_Precio);
		panelDatos.add(labelTipo);
		panelDatos.add(comboTipo);
		
		
		txtFieldDNI.setEnabled(false);
		txtField_ID_Matricula.setEnabled(false);
		
		this.add(panelDatos, BorderLayout.NORTH);
		setLocationRelativeTo(null);
		
		//*******************		
		//*******************			
		//****TABLA**********			
		//*******************			
		//*******************			
		//*******************	
		

		panelTabla = new JPanel(new BorderLayout());
		panelTabla.setBorder(BorderFactory.createTitledBorder("Cursos asociados"));
		this.setSize(300, 200);

	
		model = new MyModeloTabla();
		tTablaCursos = new JTable(model);
		tableScrollPane = new JScrollPane(tTablaCursos);

		panelTabla.add(tableScrollPane);

		
		//**************************************
		// PANEL BOTONES DE TABLA  
		panelBotonesDeTabla = new JPanel(new GridLayout(3,1));
		panelBotonesDeTabla.setBorder(BorderFactory.createTitledBorder("Opciones"));
		
		
		botonAñadirCursoAMatricula = new JButton("Añadir Curso");
		botonQuitarCursoAMatricula = new JButton("Quitar Curso");
		
		panelBotonesDeTabla.add(botonAñadirCursoAMatricula);
		panelBotonesDeTabla.add(new Panel());
		panelBotonesDeTabla.add(botonQuitarCursoAMatricula);
		
		panelTablaYBotones = new JPanel();
		panelTablaYBotones.add(panelTabla, BorderLayout.CENTER);
		panelTablaYBotones.add(panelBotonesDeTabla, BorderLayout.WEST);

		this.add(panelTablaYBotones);

		
		//panel de botones crear
		
		
		panelBotonesCrear = new JPanel();
		panelBotonesCrear.setBorder(BorderFactory.createTitledBorder("Finalizar proceso"));
		botonAtras = new JButton("Atras");
		botonModificarMatricula = new JButton("Modificar Matricula");
		
		
		panelBotonesCrear.add(botonAtras);
		panelBotonesCrear.add(botonModificarMatricula);
		
		this.add(panelBotonesCrear, BorderLayout.SOUTH);
		
		
		
		
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
//	
		pack();
	}
	
	
	//MAIN DE PRUEBA PARA VER LA VENTANA///
	
	public static void main(String []args) {
		VentanaModificarMatricula.getInstance().setVisible(true);
	}
	

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param EventoGUI
	 * @param Datos
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void Update(int evento, Object datos) {
		
		switch (evento) {
		case (EventoGUI.BUSCA_MATRICULA_PARA_MODIFICAR): {
			TMatricula tMatricula = (TMatricula) datos;
			// limpio y foco
			
			// ID
			int ID_Matricula = tMatricula.getID_Matricula();
			String stringIDM = Integer.toString(ID_Matricula);
			txtField_ID_Matricula.setText(stringIDM);
			
			int DNI = tMatricula.getDNI();
			String stringDNI = Integer.toString(DNI);
			txtFieldDNI.setText(stringDNI);
			// Precio
			int precio = tMatricula.getPrecio();
			String StringPrecio = Integer.toString(precio);
			txtField_Precio.setText(StringPrecio);
			
			// Tipo
			String StringTipo = tMatricula.getTipo();
			if(StringTipo == "Normal")			
				comboTipo.setSelectedIndex(0);
			else if(StringTipo == "Fam_numerosa")			
				comboTipo.setSelectedIndex(1);
			else if(StringTipo == "Becario")			
				comboTipo.setSelectedIndex(2);
			
			///Actualizar la tabla///
			
			model.setListaTabla(tMatricula.getCursos());
			
			tTablaCursos.setModel(model);
			
			this.setVisible(true);

		}
			break;
		
		case (EventoGUI.BUSCAR_CURSO_PARA_AÑADIR_A_MATRICULA): {
			
			model.add((TCursoNivel) datos);
		}
			break;

		case (EventoGUI.MODIFICAR_MATRICULA_CORRECTO): {
			
			JOptionPane.showMessageDialog(null, "La Matricula con [ ID: " + (Integer)datos + " ] Modificada.");
			//vaciarCampos();
		}
			break;

		case (EventoGUI.MODIFICAR_ALUMNO_ERROR): {
			JOptionPane.showMessageDialog(null, "ERROR al modificar los datos");
			VentanaModificarAlumno.getInstance().setVisible(true);
		}
		
			break;
		}
	}
	
	private void vaciarCampos(){
		txtField_ID_Matricula.setText("");
		txtFieldDNI.setText("");
		txtField_Precio.setText("");
		model.clear();
	}

	public class ALVentanaModificarMatricula implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
			if(event.getSource() == botonAñadirCursoAMatricula){
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
			}
			
			if(event.getSource() == botonQuitarCursoAMatricula){
				
				int fila = tTablaCursos.getSelectedRow();
				model.remove(fila);}
			
			if(event.getSource() == botonModificarMatricula){
							
				// Cogemos todos los datos de la ventana.
				boolean todocorrecto = true;
				
				int precio = 0;
				String tipo = null;
				
				try {
					
					precio = Integer.parseInt(txtField_Precio.getText());
					
					if(precio <= 0)throw new Exception("Precio Negativo");
					
					
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "El precio solo acepta Valores Numericos");
					VentanaModificarMatricula.this.txtField_Precio.requestFocus();
					todocorrecto = false;
				} catch (Exception e) {
					
					JOptionPane.showMessageDialog(null, "El precio debe tener un valor positivo");
					VentanaModificarMatricula.this.txtField_Precio.requestFocus();
					todocorrecto = false;
					
				}
				if (todocorrecto) {
					
					tipo = comboTipo.getSelectedItem().toString();

					ArrayList<TCursoNivel> misCursosNiveles = model.getListaTabla();
					
					try{
						
						if (misCursosNiveles.size() == 0)throw new Exception("Tabla de cursos Vacia");
						
					}
					catch(Exception e){
						
						JOptionPane.showMessageDialog(null, "La matricula debe tener al menos un curso asignado");
						todocorrecto = false;
						
					}
					
					
					if (todocorrecto) {
						// Comprobamos que todo lo que ha metido es correcto.
						if (precio != 0) {
							
							int id_alumno = 0;
							id_alumno = Integer.parseInt(txtFieldDNI.getText());
							
							TMatricula transMatri = new TMatricula(Integer.parseInt(txtField_ID_Matricula.getText()),id_alumno, tipo, precio, null, misCursosNiveles, 1);
							Controlador.getInstance().action(EventoNegocio.MODIFICAR_MATRICULA, transMatri);
						}
						else if (precio == 0) {
							JOptionPane.showMessageDialog(null,"Introduce precio");
							txtField_Precio.requestFocus();
						} else if (misCursosNiveles.isEmpty()) {
							JOptionPane.showMessageDialog(null,"Ningún curso asignado.");
						}
					}		
				
			}
			}
			
			if(event.getSource() == botonAtras){
				
				JPrincipalSMS.getInstance().setVisible(true);
				VentanaBuscarCursoMatricula.getInstance().dispose();
				uniqueInstance.setVisible(false);
				
			}
			
		}
	
	}
	
	public class WLVentanaModificarMatricula implements WindowListener {
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
			JPrincipalSMS.getInstance().setVisible(true);
			VentanaBuscarCursoMatricula.getInstance().dispose();
			VentanaModificarMatricula.this.dispose();
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
	//TABLA
	public class MyModeloTabla extends AbstractTableModel {

		private static final long serialVersionUID = -1400601842772476569L;

		private String[] columnas = { "ID", "NOMBRE", "NIVEL" };
		private ArrayList<TCursoNivel> listaTabla = new ArrayList<TCursoNivel>();

		@Override
		public int getColumnCount() {
			return columnas.length;
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
	
	private void agregarManejadoresDeEventos() {
		ALVentanaModificarMatricula oyente = new ALVentanaModificarMatricula();	
		this.addWindowListener(new WLVentanaModificarMatricula());

		botonAñadirCursoAMatricula.addActionListener(oyente);
		botonQuitarCursoAMatricula.addActionListener(oyente);
		botonAtras.addActionListener(oyente);
		botonModificarMatricula.addActionListener(oyente);
		
	}
	
	// Metodo realizar movimiento.
	public void moverAutomaticamenteVentana(JFrame ventana, int desdeX, int hastaX,
			int desdeY, int hastaY, int demora) {
		System.out.println(" desdeX " + desdeX + " hastaX " + hastaX
				+ " desdeY " + desdeY + " hastaY " + hastaY);
		
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

	
}