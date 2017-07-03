/**
 * 
 */
package SMSDAO.Presentacion.JPrincipal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;

import SMSDAO.Presentacion.Alumnos.VentanaBuscarAlumno;
import SMSDAO.Presentacion.Alumnos.VentanaCrearAlumno;
import SMSDAO.Presentacion.Alumnos.VentanaEliminarAlumno;
import SMSDAO.Presentacion.Alumnos.VentanaListarAlumnosConNMatricEnMAños;
import SMSDAO.Presentacion.Controlador.Controlador;
import SMSDAO.Presentacion.Curso.VentanaBorrarCurso;
import SMSDAO.Presentacion.Curso.VentanaBuscarCurso;
import SMSDAO.Presentacion.Curso.VentanaCrearCurso;
import SMSDAO.Presentacion.Matricula.VentanaBuscarMatricula;
import SMSDAO.Presentacion.Matricula.VentanaCrearMatricula;
import SMSDAO.Presentacion.Matricula.VentanaEliminarMatricula;
import SMSDAO.Presentacion.Matricula.VentanaListarMatricualsConNcursos;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class JPrincipalSMS extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = -7356989246860859103L;
	
	private javax.swing.JMenuItem itemModificaCurso;
	private javax.swing.JMenuItem itemListarCursos;
	private javax.swing.JMenuItem itemMostrarCurso;
	private javax.swing.JMenuItem itemCrearCurso;
	private javax.swing.JMenuItem itemBorrarCurso;
	
	private javax.swing.JMenuItem itemModificaAlumno;
	private javax.swing.JMenuItem itemListarAlumnos;
	private javax.swing.JMenuItem itemListarAlumnosNMatriculasManos;
	private javax.swing.JMenuItem itemMostrarAlumno;
	private javax.swing.JMenuItem itemCrearAlumno;
	private javax.swing.JMenuItem itemBorrarAlumno;	
	
	private javax.swing.JMenuItem itemModificaMatricula;
	private javax.swing.JMenuItem itemListarMatriculas;
	private javax.swing.JMenuItem itemListarMatriculasNCursos;
	private javax.swing.JMenuItem itemMostrarMatricula;
	private javax.swing.JMenuItem itemCrearMatricula;
	private javax.swing.JMenuItem itemBorrarMatricula;

	private javax.swing.JLabel jLabel1;
	private javax.swing.JMenuBar jMenuBar1;

	private javax.swing.JMenu menuCurso;
	private javax.swing.JMenu menuAlumno;
	private javax.swing.JMenu menuMatricula;

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
		
		menuCurso = new javax.swing.JMenu();
			itemCrearCurso = new javax.swing.JMenuItem();
			itemBorrarCurso = new javax.swing.JMenuItem();
			itemModificaCurso = new javax.swing.JMenuItem();
			itemMostrarCurso = new javax.swing.JMenuItem();
			itemListarCursos = new javax.swing.JMenuItem();
		
			menuAlumno = new javax.swing.JMenu();
			itemCrearAlumno = new javax.swing.JMenuItem();
			itemBorrarAlumno = new javax.swing.JMenuItem();
			itemModificaAlumno = new javax.swing.JMenuItem();
			itemMostrarAlumno = new javax.swing.JMenuItem();
			itemListarAlumnos = new javax.swing.JMenuItem();
			itemListarAlumnosNMatriculasManos = new JMenuItem();
			
			menuMatricula = new javax.swing.JMenu();
			itemCrearMatricula = new javax.swing.JMenuItem();
			itemBorrarMatricula = new javax.swing.JMenuItem();
			itemModificaMatricula = new javax.swing.JMenuItem();
			itemMostrarMatricula = new javax.swing.JMenuItem();
			itemListarMatriculas = new javax.swing.JMenuItem();
			itemListarMatriculasNCursos = new javax.swing.JMenuItem();
			
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

		menuCurso.setText("Curso");
		{
			itemCrearCurso.setText("Crear curso");
			itemCrearCurso.addActionListener(oyenteJPrincipal);
			menuCurso.add(itemCrearCurso);
	
			itemModificaCurso.setText("Modificar curso");
			itemModificaCurso.addActionListener(oyenteJPrincipal);
			menuCurso.add(itemModificaCurso);
			
			itemBorrarCurso.setText("Borrar curso");
			itemBorrarCurso.addActionListener(oyenteJPrincipal);
			menuCurso.add(itemBorrarCurso);
			
			itemMostrarCurso.setText("Mostrar curso");
			itemMostrarCurso.addActionListener(oyenteJPrincipal);
			menuCurso.add(itemMostrarCurso);
			
			itemListarCursos.setText("Listar cursos");
			itemListarCursos.addActionListener(oyenteJPrincipal);
			menuCurso.add(itemListarCursos);
	
			jMenuBar1.add(menuCurso);
		}
		menuAlumno.setText("Alumno");
		{
			itemCrearAlumno.setText("Crear alumno");
			itemCrearAlumno.addActionListener(oyenteJPrincipal);
			menuAlumno.add(itemCrearAlumno);
	
			itemModificaAlumno.setText("Modificar Alumno");
			itemModificaAlumno.addActionListener(oyenteJPrincipal);
			menuAlumno.add(itemModificaAlumno);
			
			itemBorrarAlumno.setText("Borrar Alumno");
			itemBorrarAlumno.addActionListener(oyenteJPrincipal);
			menuAlumno.add(itemBorrarAlumno);
			
			itemMostrarAlumno.setText("Mostrar Alumno");
			itemMostrarAlumno.addActionListener(oyenteJPrincipal);
			menuAlumno.add(itemMostrarAlumno);
			
			itemListarAlumnos.setText("Listar Alumnos");
			itemListarAlumnos.addActionListener(oyenteJPrincipal);
			menuAlumno.add(itemListarAlumnos);
			
			itemListarAlumnosNMatriculasManos.setText("Listar Alumnos N Matriculas M Años");
			itemListarAlumnosNMatriculasManos.addActionListener(oyenteJPrincipal);
			menuAlumno.add(itemListarAlumnosNMatriculasManos);
	
			jMenuBar1.add(menuAlumno);
		}
		menuMatricula.setText("Matricula");
		{
			itemCrearMatricula.setText("Crear Matricula");
			itemCrearMatricula.addActionListener(oyenteJPrincipal);
			menuMatricula.add(itemCrearMatricula);
	
			itemModificaMatricula.setText("Modificar Matricula");
			itemModificaMatricula.addActionListener(oyenteJPrincipal);
			menuMatricula.add(itemModificaMatricula);
			
			itemBorrarMatricula.setText("Borrar Matricula");
			itemBorrarMatricula.addActionListener(oyenteJPrincipal);
			menuMatricula.add(itemBorrarMatricula);
			
			itemMostrarMatricula.setText("Mostrar Matricula");
			itemMostrarMatricula.addActionListener(oyenteJPrincipal);
			menuMatricula.add(itemMostrarMatricula);
			
			itemListarMatriculas.setText("Listar Matriculas");
			itemListarMatriculas.addActionListener(oyenteJPrincipal);
			menuMatricula.add(itemListarMatriculas);
			
			itemListarMatriculasNCursos.setText("Listar Matriculas N Cursos");
			itemListarMatriculasNCursos.addActionListener(oyenteJPrincipal);
			menuMatricula.add(itemListarMatriculasNCursos);
	
			jMenuBar1.add(menuMatricula);
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

			//************* ITEMS CURSO *************
			if (event.getSource() == itemCrearCurso) {

				JPrincipalSMS.this.setVisible(false);
				VentanaCrearCurso.getInstance().setVisible(true);
			}

			if (event.getSource() == itemBorrarCurso) {

				JPrincipalSMS.this.setVisible(false);
				VentanaBorrarCurso.getInstance().setVisible(true);

			}
			if (event.getSource() == itemModificaCurso) {

				JPrincipalSMS.this.setVisible(false);
				VentanaBuscarCurso.getInstance().setTipoEventoGUI(EventoGUI.BUSCA_CURSO_PARA_MODIFICAR);
				VentanaBuscarCurso.getInstance().estadoVentanaInicial();
				VentanaBuscarCurso.getInstance().setVisible(true);

			}
			if (event.getSource() == itemMostrarCurso) {
				JPrincipalSMS.this.setVisible(false);
				VentanaBuscarCurso.getInstance().setTipoEventoGUI(EventoGUI.BUSCAR_CURSO);
				VentanaBuscarCurso.getInstance().estadoVentanaInicial();
				VentanaBuscarCurso.getInstance().setVisible(true);

			}
			if (event.getSource() == itemListarCursos) {

				JPrincipalSMS.this.setVisible(false);
				Controlador.getInstance().action(EventoNegocio.LISTAR_CURSOS, null);

			}	
			
			//************* ITEMS ALUMNO *************
			if (event.getSource() == itemCrearAlumno) {
				JPrincipalSMS.this.setVisible(false);
				VentanaCrearAlumno.getInstance().setVisible(true);
			}

			if (event.getSource() == itemBorrarAlumno) {

				JPrincipalSMS.this.setVisible(false);
				VentanaEliminarAlumno.getInstance().setVisible(true);

			}
			if (event.getSource() == itemModificaAlumno) {

				JPrincipalSMS.this.setVisible(false);
				VentanaBuscarAlumno.getInstance().setTipoEventoGUI(EventoGUI.BUSCA_ALUMNO_PARA_MODIFICAR);
				VentanaBuscarAlumno.getInstance().estadoVentanaInicial();
				VentanaBuscarAlumno.getInstance().setVisible(true);

			}
			if (event.getSource() == itemMostrarAlumno) {
				JPrincipalSMS.this.setVisible(false);
				VentanaBuscarAlumno.getInstance().setTipoEventoGUI(EventoGUI.BUSCAR_ALUMNO);
				VentanaBuscarAlumno.getInstance().estadoVentanaInicial();
				VentanaBuscarAlumno.getInstance().setVisible(true);

			}
			if (event.getSource() == itemListarAlumnos) {

				JPrincipalSMS.this.setVisible(false);
				Controlador.getInstance().action(EventoNegocio.LISTAR_ALUMNO, null);

			}
			
			if (event.getSource() == itemListarAlumnosNMatriculasManos){
				
				JPrincipalSMS.this.setVisible(false);
				VentanaListarAlumnosConNMatricEnMAños.getInstance().setVisible(true);
			}
			
			
			//*************MATRICULAS******
			if (event.getSource() == itemCrearMatricula) {
				JPrincipalSMS.this.setVisible(false);
				VentanaCrearMatricula.getInstance().setVisible(true);
			}

			if (event.getSource() == itemBorrarMatricula) {

				JPrincipalSMS.this.setVisible(false);
				VentanaEliminarMatricula.getInstance().setVisible(true);

			}
			if (event.getSource() == itemModificaMatricula) {

				JPrincipalSMS.this.setVisible(false);
				VentanaBuscarMatricula.getInstance().setTipoEventoGUI(EventoGUI.BUSCA_MATRICULA_PARA_MODIFICAR);
				VentanaBuscarMatricula.getInstance().estadoVentanaInicial();
				VentanaBuscarMatricula.getInstance().setVisible(true);
			}
			
			if (event.getSource() == itemMostrarMatricula) {
				JPrincipalSMS.this.setVisible(false);
				VentanaBuscarMatricula.getInstance().setTipoEventoGUI(EventoGUI.BUSCAR_MATRICULA);
				VentanaBuscarMatricula.getInstance().estadoVentanaInicial();
				VentanaBuscarMatricula.getInstance().setVisible(true);
				
			}
			if (event.getSource() == itemListarMatriculas) {

				JPrincipalSMS.this.setVisible(false);
				Controlador.getInstance().action(EventoNegocio.LISTAR_MATRICULAS, null);

			}
			
			if (event.getSource() == itemListarMatriculasNCursos) {

				JPrincipalSMS.this.setVisible(false);
				
				VentanaListarMatricualsConNcursos.getInstance().setVisible(true);

			}

		}
	}
	
	public void update(int evento, Object datos) {
		/*switch (evento) {
			case (EventoGUI.RESERVAS_ACTUALIZADAS):{
				JOptionPane.showMessageDialog(null, "Reservas actualizadas correctamente.");
			}break;
			
			case (EventoGUI.ACTUALIZACION_ERROR):{
				JOptionPane.showMessageDialog(null, "ERROR al actualizar las reservas.");
			}break;
		}*/
	}
}
	
	
	