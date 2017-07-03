package SMSJPA.Presentacion.Profesor;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import SMSDAO.Negocio.Matricula.TCursoNivel;
import SMSDAO.Presentacion.JPrincipal.EventoNegocio;
import SMSDAO.Presentacion.Matricula.VentanaBuscarCursoMatricula;
import SMSJPA.Presentacion.Controlador.Controlador;
import SMSJPA.Presentacion.Controlador.EventoGUI;
import SMSJPA.Presentacion.JPrincipal.JPrincipalSMS;
import SMSJPA.Negocio.Materia.TMateriaAñosExpe;
import SMSJPA.Negocio.Profesor.TProfesor;
import SMSJPA.Negocio.Profesor.TProfesorAñosExpe;


public class VentanaCrearProfesor extends JFrame {

	private static final long serialVersionUID = -4342293404144809882L;
	private static VentanaCrearProfesor uniqueInstance;

	//Nombre
	private JLabel labelNombre;
	private JTextField txtField_Nombre;

	//Apellidos
	private JLabel labelApellidos;
	private JTextField txtField_Apellidos;
	//Telefono
	private JLabel labelTelefono;
	private JTextField txtFieldTelefono;
	//Email
	private JLabel labelEmail;
	private JTextField txtFieldEmail;
	//ID_Turno
	private JLabel labelID_Turno;
	private JTextField txtFieldID_Turno;
	//Nomina
	private JLabel labelSueldo;
	private JTextField txtFieldSueldo;
	//Tipo
	private JLabel labelTipo;
	private JComboBox<String> comboBoxTipo;


	//SueldoBase
	private JLabel labelSueldoBase;
	private JTextField txtFieldSueldoBase;
	//suplemento
	private JLabel labelSuplemento;
	private JTextField txtFieldSuplemento;


	//EurosPorHora	
	private JLabel labelEurosPorHora;
	private JTextField txtFieldEurosPorHora;
	//HorasTrabajadas
	private JLabel labelHorasTrabajadas;
	private JTextField txtFieldHorasTrabajadas;


	//DNI
	private JLabel labelDNI;
	private JTextField txtFieldDNI;
	//NUM_SS
	private JLabel labelNUM_SS;
	private JTextField txtFieldNUM_SS;

	private JScrollPane tableScrollPane;
	private JTable tTablaMaterias;

	private JButton botonCrearProfesor;
	private JButton botonAtras;
	private JButton botonAñadirMateria;
	private JButton botonEliminarMateria;

	private JPanel panelDatos;
	private JPanel panelDatosSup;
	private JPanel panelDatosCen;
	private JPanel panelDatosInf;
	private JPanel panelCentral;
	private JPanel panelTabla;
	private JPanel panelBotonesCrear;
	private JPanel panelCentralBotones;
	private JPanel panelSur;
	private JPanel panelBotonesDeTabla;

	private MyModeloTabla model;

	private JPanel panelTablaYBotones;

	public static void main(String[] args) {
		VentanaCrearProfesor.getInstance().setVisible(true);
	}

	public VentanaCrearProfesor() {
		super("Crear Profesor");

		create();
		agregarManejadoresDeEventos();



		setLocationRelativeTo(null);
		setResizable(false);
	}	

	public static VentanaCrearProfesor getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new VentanaCrearProfesor();
		}

		return uniqueInstance;
	}
	public void create() {
		panelCentral = new JPanel();
		panelCentralBotones = new JPanel();

		panelDatosSup = new JPanel();
		panelDatosCen = new JPanel();
		panelDatosInf = new JPanel();

		panelDatos = new JPanel(new BorderLayout());
		panelDatos.setBorder(BorderFactory .createTitledBorder("Datos del Profesor"));


		labelNombre = new JLabel("Nombre");
		txtField_Nombre = new JTextField(5);

		labelApellidos = new JLabel("Apellidos: ");
		txtField_Apellidos= new JTextField(15 );

		labelDNI = new JLabel("DNI: ");
		txtFieldDNI = new JTextField(7);

		labelTelefono = new JLabel("Telefono: ");
		txtFieldTelefono = new JTextField(7);

		labelEmail = new JLabel("Email: ");
		txtFieldEmail= new JTextField(15);

		labelID_Turno = new JLabel("ID_Turno: ");
		txtFieldID_Turno = new JTextField(7);

		labelSueldo = new JLabel("Nomina: ");
		txtFieldSueldo = new JTextField(7);

		labelTipo = new JLabel("Tipo: ");

		Vector<String> vector = new Vector<String>();

		vector.addElement("RESIDENTE");
		vector.addElement("AUXILIAR");
		comboBoxTipo = new JComboBox<String>(vector);

		labelSueldoBase = new JLabel("Sueldo Base: ");
		txtFieldSueldoBase = new JTextField(6);

		labelSuplemento = new JLabel("Suplemento: ");
		txtFieldSuplemento = new JTextField(6);


		labelEurosPorHora = new JLabel("Euros/Hora: ");
		txtFieldEurosPorHora = new JTextField(6);

		labelHorasTrabajadas = new JLabel("Horas/Trabajadas: ");
		txtFieldHorasTrabajadas = new JTextField(6);

		labelNUM_SS = new JLabel("Num. Seg. Social: ");
		txtFieldNUM_SS = new JTextField(5);

		labelNUM_SS.setVisible(false);
		txtFieldNUM_SS.setText("");
		txtFieldNUM_SS.setVisible(false);

		labelEurosPorHora.setVisible(false);
		txtFieldEurosPorHora.setText("");
		txtFieldEurosPorHora.setVisible(false);

		labelHorasTrabajadas.setVisible(false);
		txtFieldHorasTrabajadas.setText("");
		txtFieldHorasTrabajadas.setVisible(false);

		panelDatosSup.add(labelNombre);
		panelDatosSup.add(txtField_Nombre);
		panelDatosSup.add(labelApellidos);
		panelDatosSup.add(txtField_Apellidos);
		panelDatosSup.add(labelTelefono);
		panelDatosSup.add(txtFieldTelefono);

		panelDatosSup.add(labelEmail);
		panelDatosSup.add(txtFieldEmail);
		panelDatosSup.add(labelID_Turno);
		panelDatosSup.add(txtFieldID_Turno);
		//panelDatosInf.add(labelSueldo);
		//panelDatosInf.add(txtFieldSueldo);
		panelDatosInf.add(labelTipo);
		panelDatosInf.add(comboBoxTipo);
		panelDatosInf.add(labelDNI);
		panelDatosInf.add(txtFieldDNI);
		panelDatosInf.add(labelNUM_SS);
		panelDatosInf.add(txtFieldNUM_SS);


		panelDatosInf.add(labelSueldoBase);
		panelDatosInf.add(txtFieldSueldoBase);

		panelDatosInf.add(labelSuplemento);
		panelDatosInf.add(txtFieldSuplemento);

		panelDatosInf.add(labelEurosPorHora);
		panelDatosInf.add(txtFieldEurosPorHora);

		panelDatosInf.add(labelHorasTrabajadas);
		panelDatosInf.add(txtFieldHorasTrabajadas);


		panelDatos.add(panelDatosSup, BorderLayout.NORTH);
		panelDatos.add(panelDatosCen, BorderLayout.CENTER);
		panelDatos.add(panelDatosInf, BorderLayout.SOUTH);

		this.add(panelDatos, BorderLayout.NORTH);
		setLocationRelativeTo(null);

		// *******************
		// *******************
		// ****TABLA**********
		// *******************
		// *******************
		// *******************

		panelTabla = new JPanel(new BorderLayout());
		panelTabla.setBorder(BorderFactory.createTitledBorder("Materias asociadas"));
		this.setSize(500, 250);

		model = new MyModeloTabla();
		tTablaMaterias = new JTable(model);
		tableScrollPane = new JScrollPane(tTablaMaterias);

		panelTabla.add(tableScrollPane);


		panelBotonesDeTabla = new JPanel(new GridLayout(3, 1));
		panelBotonesDeTabla.setBorder(BorderFactory.createTitledBorder("Opciones"));

		botonAñadirMateria = new JButton("Añadir materia");
		botonEliminarMateria = new JButton("Quitar materia");

		panelBotonesDeTabla.add(botonAñadirMateria);
		panelBotonesDeTabla.add(new Panel());
		panelBotonesDeTabla.add(botonEliminarMateria);

		panelTablaYBotones = new JPanel();
		panelTablaYBotones.add(panelTabla, BorderLayout.CENTER);
		panelTablaYBotones.add(panelBotonesDeTabla, BorderLayout.WEST);
		this.add(panelTablaYBotones);

		// panel de botones crear

		panelBotonesCrear = new JPanel();
		panelBotonesCrear.setBorder(BorderFactory.createTitledBorder("Finalizar proceso"));
		botonAtras = new JButton("Atras");
		botonCrearProfesor = new JButton("Crear");

		panelBotonesCrear.add(botonAtras);
		panelBotonesCrear.add(botonCrearProfesor);

		this.add(panelBotonesCrear, BorderLayout.SOUTH);


		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		
		pack();
	}


	private void agregarManejadoresDeEventos() {
		ALVentanaMostrarProfesor oyente = new ALVentanaMostrarProfesor();
		FLVentanaCrearProfesor oyenteFocus = new FLVentanaCrearProfesor();

		this.addWindowListener(new WLVentanaMostrarProfesor());

		botonAñadirMateria.addActionListener(oyente);
		botonEliminarMateria.addActionListener(oyente);
		botonAtras.addActionListener(oyente);
		botonCrearProfesor.addActionListener(oyente);
		comboBoxTipo.addActionListener(oyente);

		txtFieldID_Turno.addFocusListener(oyenteFocus);
		txtFieldDNI.addFocusListener(oyenteFocus);

	}

	public class FLVentanaCrearProfesor implements FocusListener{

		int cont;

		public FLVentanaCrearProfesor(){
			cont = 0;
		}

		public void focusGained(FocusEvent e) {

			if(e.getSource() == txtFieldID_Turno){
				if(cont == 0){

					Controlador.getInstance().action(EventoGUI.LISTAR_TURNOS_PARA_PROFESOR, 0);
					txtFieldID_Turno.requestFocus();

				}
				cont++;

			}

			if(e.getSource() == txtFieldDNI){
				if(txtFieldDNI.getText().length()>= 1){
					txtFieldDNI.setText(txtFieldDNI.getText().substring(0, txtFieldDNI.getText().length()-1));
				}
			}

		}

		public void focusLost(FocusEvent e) {
			if(e.getSource() == txtFieldID_Turno){
				if(cont == 2){
					Controlador.getInstance().action(EventoGUI.CERRAR_VENTANA_LISTAR_TURNOS, 0);
					cont = 0;
				}
				
			}

			if(e.getSource() == txtFieldDNI){
				try{
					txtFieldDNI.setText(letraDNI(Integer.parseInt(txtFieldDNI.getText())));
				}catch (NumberFormatException ex) {
					if(!txtFieldDNI.getText().equalsIgnoreCase("")){
						JOptionPane.showMessageDialog(null,	"No escriba letra en el DNI");
						txtFieldDNI.requestFocus();
					}
				}


			}

		}


	}



	public void update(int eventoGUI, Object datos) {

		switch (eventoGUI) {

		case (EventoGUI.PROFESOR_CREADO): {
			Integer id = (Integer) datos;
			JOptionPane.showMessageDialog(null, "Profesor con [ ID: " + id.intValue() + " ] Creado.");

			VentanaCrearProfesor.this.dispose();
			VentanaCrearProfesor.this.borrarCampos();
			JPrincipalSMS.getInstance().setVisible(true);

		} break;

		case (EventoGUI.PROFESOR_REACTIVADO): {
			JOptionPane.showMessageDialog(null, "El profesor ha sido reactivado en el sistema");

		} break;

		case (EventoGUI.PROFESOR_EXISTENTE): {
			JOptionPane.showMessageDialog(null, "ERROR: El profesor ya existe en el sistema");

		} break;

		case (EventoGUI.PROFESOR_CREAR_ERROR): {
			JOptionPane.showMessageDialog(null,"Hubo un error al crear el profesor");

		} break;
		case (EventoGUI.BUSCAR_MATERIA_PARA_AÑADIR_A_PROFESOR): {
			model.add((TMateriaAñosExpe) datos);

		} break;

		case (EventoGUI.BUSCAR_MATERIA_ERROR): {
			JOptionPane.showMessageDialog(null, "No existe esa materia en el sistema");

		} break;

		case (EventoGUI.TURNO_INEXISTENTE): {
			JOptionPane.showMessageDialog(null, "El turno introducido no existee en el sistema");

		} break;

		case (EventoGUI.MATERIA_INEXISTENTE): {
			JOptionPane.showMessageDialog(null, "Una de las materias no existe en el sistema");

		} break;

		}
	}
	public String letraDNI(int dni) {
		String NIF_STRING_ASOCIATION = "TRWAGMYFPDXBNJZSQVHLCKE";
		return String.valueOf(dni) + NIF_STRING_ASOCIATION.charAt(dni % 23);
	}

	//****************************************************//
	//*************** Abstract Table Model ***************//
	//****************************************************// 

	// TABLA
	public class MyModeloTabla extends AbstractTableModel {

		private static final long serialVersionUID = -1400601842772476569L;

		private String[] columnas = { "ID", "NOMBRE", "AÑOS_EXPERIENCIA" };
		private ArrayList<TMateriaAñosExpe> listaTabla = new ArrayList<TMateriaAñosExpe>();

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
				TMateriaAñosExpe i = listaTabla.get(rowIndex);

				if (columnIndex == 0)
					return i.getID();
				else if (columnIndex == 1)
					return i.getNombre();
				else if (columnIndex == 2)
					return i.getAñosExperiecia();
				else
					return null;
			}
		}

		@Override
		public String getColumnName(int col) {
			return columnas[col];
		}

		public void add(TMateriaAñosExpe i) {
			boolean encontrado = false;
			int j = 0;

			while (!encontrado && j < listaTabla.size()) {

				if (listaTabla.get(j).getID() == i.getID()) {
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

		public void remove(int fila) {
			if(fila!=-1){
				//borramos la fila de la tTablaCursos
				tTablaMaterias.removeRowSelectionInterval(fila, fila);
				listaTabla.remove(fila);

				this.fireTableDataChanged();
			}
			else{
				//no podemos borrar nada porque no esta seleccionado
				JOptionPane.showMessageDialog(null, "No hay ninguna materia seleccionada para quitar de la lista");
			}

		}	

		public void clear() {
			this.listaTabla.clear();
		}

		public void setListaTabla(ArrayList<TMateriaAñosExpe> listaTabla) {
			this.listaTabla = listaTabla;
		}

		public ArrayList<TMateriaAñosExpe> getListaTabla() {
			return this.listaTabla;
		}

	}

	public class ALVentanaMostrarProfesor implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == botonAñadirMateria){
				Controlador.getInstance().action(EventoGUI.LISTAR_MATERIAS_PARA_PROFESOR,null);

			}

			if (e.getSource() == botonAtras) {
				VentanaCrearProfesor.this.dispose();
				VentanaCrearProfesor.this.borrarCampos();
				JPrincipalSMS.getInstance().setVisible(true);
			}

			if (e.getSource() == botonCrearProfesor) {

				boolean todocorrecto = comprobarDatosCorrectos();
				if(todocorrecto){
					
					String tipo = (String) comboBoxTipo.getSelectedItem();
					int DNI = -1;
					double sueldoBase = 0.0;
					double suplemento = 0.0;	
					
					// ESPECIALIZADA 2
					int num_SS = -1;
					int horasTrabajadas = -1;
					double eurosPorHoras = 0.0;
						
					
						if(tipo.equalsIgnoreCase("RESIDENTE")){

							DNI = Integer.parseInt(txtFieldDNI.getText().substring(0, txtFieldDNI.getText().length()-1));
							sueldoBase = Double.parseDouble(txtFieldSueldoBase.getText());
							suplemento = Double.parseDouble(txtFieldSuplemento.getText());

						}

						else{
							num_SS = Integer.parseInt(txtFieldNUM_SS.getText());
							horasTrabajadas = Integer.parseInt(txtFieldHorasTrabajadas.getText());
							eurosPorHoras = Double.parseDouble(txtFieldEurosPorHora.getText());

						}


						TProfesor profeNuevo = new TProfesor(-1, Integer.parseInt(txtFieldID_Turno.getText()), 1, txtField_Nombre.getText(), txtField_Apellidos.getText(), 
								Integer.parseInt(txtFieldTelefono.getText()), txtFieldEmail.getText(), model.getListaTabla(), tipo, DNI, sueldoBase, suplemento, num_SS, eurosPorHoras, horasTrabajadas);	

					
						Controlador.getInstance().action(EventoGUI.CREAR_PROFESOR, profeNuevo);
					
				}
			}	



			if(e.getSource() == comboBoxTipo){

				if(comboBoxTipo.getSelectedIndex() == 0){ //PROFESOR RESIDENTE
					labelDNI.setVisible(true);
					txtFieldDNI.setText("");
					txtFieldDNI.setVisible(true);

					//SUeldo base SUplemento
					labelSueldoBase.setVisible(true);
					txtFieldSueldoBase.setText("");
					txtFieldSueldoBase.setVisible(true);

					labelSuplemento.setVisible(true);
					txtFieldSuplemento.setText("");
					txtFieldSuplemento.setVisible(true);

					labelNUM_SS.setVisible(false);
					txtFieldNUM_SS.setText("");
					txtFieldNUM_SS.setVisible(false);

					labelHorasTrabajadas.setVisible(false);
					txtFieldHorasTrabajadas.setText("");
					txtFieldHorasTrabajadas.setVisible(false);

					labelEurosPorHora.setVisible(false);
					txtFieldEurosPorHora.setText("");
					txtFieldEurosPorHora.setVisible(false);


				}else if(comboBoxTipo.getSelectedIndex() == 1){ // PROFESOR AUXILIAR

					labelDNI.setVisible(false);
					txtFieldDNI.setText("");
					txtFieldDNI.setVisible(false);

					labelSueldoBase.setVisible(false);
					txtFieldSueldoBase.setText("");
					txtFieldSueldoBase.setVisible(false);

					labelSuplemento.setVisible(false);
					txtFieldSuplemento.setText("");
					txtFieldSuplemento.setVisible(false);


					//eurosporhora y horas trabajadas

					labelNUM_SS.setVisible(true);
					txtFieldNUM_SS.setText("");
					txtFieldNUM_SS.setVisible(true);

					labelHorasTrabajadas.setVisible(true);
					txtFieldHorasTrabajadas.setText("");
					txtFieldHorasTrabajadas.setVisible(true);

					labelEurosPorHora.setVisible(true);
					txtFieldEurosPorHora.setText("");
					txtFieldEurosPorHora.setVisible(true);
				}
			}

			if(e.getSource() == botonEliminarMateria){
				int fila = tTablaMaterias.getSelectedRow();
				model.remove(fila);
			}


		}


		private boolean comprobarDatosCorrectos() {
			// Cogemos todos los datos de la ventana.
			boolean todocorrecto = true;
			
			if(txtField_Nombre.getText().equalsIgnoreCase("")){
				JOptionPane.showMessageDialog(null, "Introduzca un nombre");
				txtField_Nombre.requestFocus();
				todocorrecto = false;
			}
			if (todocorrecto) {
				if(txtField_Apellidos.getText().equalsIgnoreCase("")){
					JOptionPane.showMessageDialog(null, "Introduzca los apellidos");
					txtField_Apellidos.requestFocus();
					todocorrecto = false;
				}
				if (todocorrecto) {
					try {
						Integer.parseInt(txtFieldTelefono.getText());
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Introduzca un telefono de contacto");
						txtFieldTelefono.requestFocus();
						todocorrecto = false;
					}

					if (todocorrecto) {
						if(txtFieldEmail.getText().equalsIgnoreCase("")){
							JOptionPane.showMessageDialog(null, "Introduzca un email de contacto");
							txtFieldEmail.requestFocus();
							todocorrecto = false;
						}
						if (todocorrecto) {
							try {
								Integer.parseInt(txtFieldID_Turno.getText());
							} catch (NumberFormatException e) {
								JOptionPane.showMessageDialog(null, "Introduzca un id de turno");
								//txtFieldID_Turno.requestFocus();
								todocorrecto = false;
							}
							
							if (todocorrecto) {

								model.getListaTabla();
								if(model.getListaTabla().isEmpty()){	
									JOptionPane.showMessageDialog(null, "Ninguna materia asignada.");
									botonAñadirMateria.requestFocus();
									todocorrecto = false;
								}
								if (todocorrecto) {

									if(comboBoxTipo.getSelectedIndex() == 0){ //PROFESOR RESIDENTE (DNI)

										try {
											if(txtFieldDNI.getText().length()>= 1){
												Integer.parseInt(txtFieldDNI.getText().substring(0, txtFieldDNI.getText().length()-1));
											}else if(txtFieldDNI.getText().equalsIgnoreCase("")){
												throw new NumberFormatException();
											}
										} catch (NumberFormatException e) {
											JOptionPane.showMessageDialog(null, "Introduzca el DNI");
											txtFieldDNI.requestFocus();
											todocorrecto = false;
										}

										if (todocorrecto) {
											try {
												Integer.parseInt(txtFieldSueldoBase.getText());
											} catch (NumberFormatException e) {
												JOptionPane.showMessageDialog(null, "Introduzca un sueldo");
												txtFieldSueldoBase.requestFocus();
												todocorrecto = false;
											}
											
											if (todocorrecto) {

												//suplemento
												try {
													Integer.parseInt(txtFieldSuplemento.getText());
												} catch (NumberFormatException e) {
													JOptionPane.showMessageDialog(null, "Introduzca un suplemento");
													txtFieldSuplemento.requestFocus();
													todocorrecto = false;
												}
											}
										}



									}else if(comboBoxTipo.getSelectedIndex() == 1){ //PROFESOR AUXILIAR (NUM_SS)

										//if(txtFieldNUM_SS.getText().equalsIgnoreCase("")){
										try {
											Integer.parseInt(txtFieldNUM_SS.getText());
										} catch (NumberFormatException e) {
											JOptionPane.showMessageDialog(null, "Introduzca el número de la Seguridad Social");
											txtFieldNUM_SS.requestFocus();
											todocorrecto = false;
										}
										
										
										if (todocorrecto) {
											try {
												Integer.parseInt(txtFieldEurosPorHora.getText());
											} catch (NumberFormatException e) {
												JOptionPane.showMessageDialog(null, "Introduzca euros/hora");
												txtFieldEurosPorHora.requestFocus();
												todocorrecto = false;
											}
											
											if (todocorrecto) {

												try {
													Integer.parseInt(txtFieldHorasTrabajadas.getText());
												} catch (NumberFormatException e) {
													JOptionPane.showMessageDialog(null, "Introduzca las horas trabajadas");
													txtFieldHorasTrabajadas.requestFocus();
													todocorrecto = false;
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}



			return todocorrecto;
		}
	}





	public class WLVentanaMostrarProfesor implements WindowListener {

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Apéndice de método generado automáticamente

		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Apéndice de método generado automáticamente

		}

		@Override
		public void windowClosing(WindowEvent e) {
			VentanaCrearProfesor.this.dispose();
			VentanaCrearProfesor.this.borrarCampos();
			JPrincipalSMS.getInstance().setVisible(true);
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

	/**
	 * 
	 */
	public void borrarCampos() {

		txtField_Nombre.setText("");
		txtField_Apellidos.setText("");
		txtFieldTelefono.setText("");
		txtFieldEmail.setText("");
		txtFieldID_Turno.setText("");
		txtFieldSueldo.setText("");
		comboBoxTipo.setSelectedIndex(0);
		txtFieldDNI.setText("");
		txtFieldNUM_SS.setText("");
		model.clear();
	}
}