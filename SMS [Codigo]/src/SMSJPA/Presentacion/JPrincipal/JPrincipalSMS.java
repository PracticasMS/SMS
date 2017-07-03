/**
 * 
 */
package SMSJPA.Presentacion.JPrincipal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import SMSJPA.Presentacion.Controlador.Controlador;
import SMSJPA.Presentacion.Controlador.EventoGUI;


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class JPrincipalSMS extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4603347147105714769L;
	
	
	private javax.swing.JMenuItem itemModificarTurno;
	private javax.swing.JMenuItem itemListarTurnos;
	private javax.swing.JMenuItem itemMostrarTurno;
	private javax.swing.JMenuItem itemCrearTurno;
	private javax.swing.JMenuItem itemBorrarTurno;
	private javax.swing.JMenuItem itemCalcularNominaTurno;
	
	private javax.swing.JMenuItem itemModificarProfesor;
	private javax.swing.JMenuItem itemListarProfesores;
	private javax.swing.JMenuItem itemMostrarProfesor;
	private javax.swing.JMenuItem itemCrearProfesor;
	private javax.swing.JMenuItem itemBorrarProfesor;
	
	private javax.swing.JMenuItem itemModificarMateria;
	private javax.swing.JMenuItem itemListarMaterias;
	private javax.swing.JMenuItem itemMostrarMateria;
	private javax.swing.JMenuItem itemCrearMateria;
	private javax.swing.JMenuItem itemBorrarMateria;

	
	
	private javax.swing.JLabel jLabel1;
	private javax.swing.JMenuBar jMenuBar1;

	private javax.swing.JMenu menuTurno;
	private javax.swing.JMenu menuProfesor;
	private javax.swing.JMenu menuMateria;

	private static JPrincipalSMS uniqueInstance = null; //Instancia Singleton
	
	
	public JPrincipalSMS() {
		initComponents();
	}
	
	public static JPrincipalSMS getInstance(){
		if(uniqueInstance == null){
			uniqueInstance = new JPrincipalSMS();
		}
		return uniqueInstance;
	}
	
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		
		jMenuBar1 = new javax.swing.JMenuBar();
		
		menuTurno = new javax.swing.JMenu();
		itemCrearTurno = new javax.swing.JMenuItem();
		itemBorrarTurno = new javax.swing.JMenuItem();
		itemModificarTurno = new javax.swing.JMenuItem();
		itemMostrarTurno = new javax.swing.JMenuItem();
		itemListarTurnos = new javax.swing.JMenuItem();
		itemCalcularNominaTurno = new javax.swing.JMenuItem();
	
		menuProfesor = new javax.swing.JMenu();
		itemCrearProfesor = new javax.swing.JMenuItem();
		itemBorrarProfesor = new javax.swing.JMenuItem();
		itemModificarProfesor = new javax.swing.JMenuItem();
		itemMostrarProfesor = new javax.swing.JMenuItem();
		itemListarProfesores = new javax.swing.JMenuItem();
		
		
		
		menuMateria = new javax.swing.JMenu();
		itemCrearMateria = new javax.swing.JMenuItem();
		itemBorrarMateria = new javax.swing.JMenuItem();
		itemModificarMateria = new javax.swing.JMenuItem();
		itemMostrarMateria = new javax.swing.JMenuItem();
		itemListarMaterias = new javax.swing.JMenuItem();
		
			
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowActivated(java.awt.event.WindowEvent evt) {
				formWindowActivated(evt);
			}
		});

	
		//********* Creacion del label para el logo ***********
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		URL url = this.getClass().getResource("logo.png");
		javax.swing.ImageIcon imageicon = new javax.swing.ImageIcon(url);
		jLabel1.setIcon(imageicon);
		getContentPane().add(jLabel1);

		this.setBackground(Color.WHITE);
		
		//******** inicializar los elementos de los menus y añadir el manejador de eventos *********
		ALPrincipalSMS oyenteJPrincipal = new ALPrincipalSMS();

		menuTurno.setText("Turnos");
		{
			itemCrearTurno.setText("Crear turno");
			itemCrearTurno.addActionListener(oyenteJPrincipal);
			menuTurno.add(itemCrearTurno);
			jMenuBar1.add(menuTurno);
			
			itemBorrarTurno.setText("Eliminar Turno");
			itemBorrarTurno.addActionListener(oyenteJPrincipal);
			menuTurno.add(itemBorrarTurno);
			
			itemListarTurnos.setText("Listar Turnos");
			itemListarTurnos.addActionListener(oyenteJPrincipal);
			menuTurno.add(itemListarTurnos);
			
			itemMostrarTurno.setText("Mostrar turno");
			itemMostrarTurno.addActionListener(oyenteJPrincipal);
			menuTurno.add(itemMostrarTurno);

			itemModificarTurno.setText("Modificar turno");
			itemModificarTurno.addActionListener(oyenteJPrincipal);
			menuTurno.add(itemModificarTurno);
			
			itemCalcularNominaTurno.setText("Cacular Nomina de un turno");
			itemCalcularNominaTurno.addActionListener(oyenteJPrincipal);
			menuTurno.add(itemCalcularNominaTurno);
			
			jMenuBar1.add(menuTurno);
		}
	
		
		menuMateria.setText("Materias");
		{
			itemCrearMateria.setText("Crear Materia");
			itemCrearMateria.addActionListener(oyenteJPrincipal);
			menuMateria.add(itemCrearMateria);
			jMenuBar1.add(menuMateria);
			
			itemBorrarMateria.setText("Eliminar Materia");
			itemBorrarMateria.addActionListener(oyenteJPrincipal);
			menuMateria.add(itemBorrarMateria);
			
			itemListarMaterias.setText("Listar Materia");
			itemListarMaterias.addActionListener(oyenteJPrincipal);
			menuMateria.add(itemListarMaterias);
			
			itemMostrarMateria.setText("Mostrar Materia");
			itemMostrarMateria.addActionListener(oyenteJPrincipal);
			menuMateria.add(itemMostrarMateria);

			itemModificarMateria.setText("Modificar Materia");
			itemModificarMateria.addActionListener(oyenteJPrincipal);
			menuMateria.add(itemModificarMateria);
		
			
			jMenuBar1.add(menuMateria);
		
		}
		
		menuProfesor.setText("Profesores");
		{
			
			itemCrearProfesor.setText("Crear Profesor");
			itemCrearProfesor.addActionListener(oyenteJPrincipal);
			menuProfesor.add(itemCrearProfesor);
			jMenuBar1.add(menuProfesor);
			
			itemBorrarProfesor.setText("Eliminar Profesor");
			itemBorrarProfesor.addActionListener(oyenteJPrincipal);
			menuProfesor.add(itemBorrarProfesor);
			
			itemListarProfesores.setText("Listar Profesores");
			itemListarProfesores.addActionListener(oyenteJPrincipal);
			menuProfesor.add(itemListarProfesores);
			
			itemMostrarProfesor.setText("Mostrar Profesor");
			itemMostrarProfesor.addActionListener(oyenteJPrincipal);
			menuProfesor.add(itemMostrarProfesor);

			itemModificarProfesor.setText("Modificar Profesor");
			itemModificarProfesor.addActionListener(oyenteJPrincipal);
			menuProfesor.add(itemModificarProfesor);
		
			
			jMenuBar1.add(menuProfesor);
			
			
		
		}
		
		setJMenuBar(jMenuBar1);

		pack();

		setSize(new Dimension(450, 368));
		setLocationRelativeTo(null);
	}

	private void formWindowActivated(java.awt.event.WindowEvent evt) {
		
		String path = "logo.png";

		URL url = this.getClass().getResource(path);
		ImageIcon fot = new ImageIcon(url);
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(jLabel1.getWidth()-10, jLabel1.getHeight()-10, Image.SCALE_DEFAULT));
		jLabel1.setIcon(icono);
		this.repaint();
	}

	public static void main(String args[]) {
		
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(JPrincipalSMS.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(JPrincipalSMS.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(JPrincipalSMS.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(JPrincipalSMS.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new JPrincipalSMS().setVisible(true);
			}
		});
	}
	
	public class ALPrincipalSMS implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			// begin-user-code

			//************* ITEMS TURNO *************
			if (event.getSource() == itemCrearTurno) {

				JPrincipalSMS.this.setVisible(false);
				Controlador.getInstance().action(EventoGUI.ABRIR_VENTANA_CREAR_TURNO, null);
			}
			if (event.getSource() == itemMostrarTurno) {

				JPrincipalSMS.this.setVisible(false);
				Controlador.getInstance().action(EventoGUI.ABRIR_VENTANA_BUSCAR_TURNO, null);
			}
			
			if (event.getSource() == itemCalcularNominaTurno) {

				JPrincipalSMS.this.setVisible(false);
				Controlador.getInstance().action(EventoGUI.ABRIR_VENTANA_CALCULAR_NOMINA_TURNO, null);
			}
			
			if (event.getSource() == itemListarTurnos){

				JPrincipalSMS.this.setVisible(false);
				Controlador.getInstance().action(EventoGUI.LISTAR_TURNOS, null);
			}
			
			if (event.getSource() == itemModificarTurno){

				JPrincipalSMS.this.setVisible(false);
				Controlador.getInstance().action(EventoGUI.ABRIR_VENTANA_BUSCAR_TURNO_PARA_MODIFICAR, null);
			}
			if (event.getSource() == itemBorrarTurno){

				JPrincipalSMS.this.setVisible(false);
				Controlador.getInstance().action(EventoGUI.ABRIR_VENTANA_ELIMINAR_TURNO, null);
			}
			
			
			//************* ITEMS MATERIA *************
			if (event.getSource() == itemCrearMateria) {

				JPrincipalSMS.this.setVisible(false);
				Controlador.getInstance().action(EventoGUI.ABRIR_VENTANA_CREAR_MATERIA, null);
			}
			
			if (event.getSource() == itemMostrarMateria) {
				JPrincipalSMS.this.setVisible(false);
				Controlador.getInstance().action(EventoGUI.ABRIR_VENTANA_BUSCAR_MATERIA, null);
			}
			
			if (event.getSource() == itemListarMaterias){
				JPrincipalSMS.this.setVisible(false);
				Controlador.getInstance().action(EventoGUI.LISTAR_MATERIAS, null);
			}
			
			if (event.getSource() == itemModificarMateria){

				JPrincipalSMS.this.setVisible(false);
				Controlador.getInstance().action(EventoGUI.ABRIR_VENTANA_BUSCAR_MATERIA_PARA_MODIFICAR, null);
			}
			if (event.getSource() == itemBorrarMateria){

				JPrincipalSMS.this.setVisible(false);
				Controlador.getInstance().action(EventoGUI.ABRIR_VENTANA_ELIMINAR_MATERIA, null);
			}
			
			//************* ITEMS PROFESOR *************
			if (event.getSource() == itemCrearProfesor) {

				JPrincipalSMS.this.setVisible(false);
				Controlador.getInstance().action(EventoGUI.ABRIR_VENTANA_CREAR_PROFESOR, null);
			}
			if (event.getSource() == itemMostrarProfesor) {

				JPrincipalSMS.this.setVisible(false);
				Controlador.getInstance().action(EventoGUI.ABRIR_VENTANA_BUSCAR_PROFESOR, null);
			}
			
			if (event.getSource() == itemBorrarProfesor){

				JPrincipalSMS.this.setVisible(false);
				Controlador.getInstance().action(EventoGUI.ABRIR_VENTANA_ELIMINAR_PROFESOR, null);
			}
			
			if (event.getSource() == itemListarProfesores){

				JPrincipalSMS.this.setVisible(false);
				Controlador.getInstance().action(EventoGUI.LISTAR_PROFESORES, null);
			}
			
			if (event.getSource() == itemModificarProfesor){

				JPrincipalSMS.this.setVisible(false);
				Controlador.getInstance().action(EventoGUI.ABRIR_VENTANA_BUSCAR_PROFESOR_PARA_MODIFICAR, null);
			}
			
		}
	}

	
}