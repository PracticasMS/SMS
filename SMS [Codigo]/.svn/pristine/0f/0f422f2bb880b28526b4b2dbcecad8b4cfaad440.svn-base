/**
 * 
 */
package SMSDAO.Presentacion.Curso;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import SMSDAO.Negocio.Curso.TCurso;
import SMSDAO.Presentacion.Controlador.Controlador;
import SMSDAO.Presentacion.JPrincipal.EventoGUI;
import SMSDAO.Presentacion.JPrincipal.EventoNegocio;
import SMSDAO.Presentacion.JPrincipal.JPrincipalSMS;

public class VentanaModificarCurso extends JFrame {

	private static final long serialVersionUID = 747281424280303200L;

	private JLabel labelID_Curso;
	private JTextField txtFieldID_Curso;
	private JLabel labelNombre_Curso;
	private JTextField txtFieldNombre_Curso;
	
	private JButton botonAtras;
	private JButton botonModificarCurso;
	
	private JPanel panelDatos;
	private JPanel panelBotones;
	
	private static VentanaModificarCurso uniqueInstance;
	
	//Metodo principal
	public static void main(String args[]) {
		VentanaModificarCurso.getInstance().setVisible(true);
	}
	
	public VentanaModificarCurso(){
		super("Modificar Curso");		
		create();
		agregarManejadoresDeEventos();
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	//agragamos oyentes
	private void agregarManejadoresDeEventos() {
		addWindowListener(new WLVentanaModificarCurso());
		
		ALVentanaModificarCursos oyente = new ALVentanaModificarCursos();
		
		botonAtras.addActionListener(oyente);
		botonModificarCurso.addActionListener(oyente);		
	}
	
	//creamos la ventana
	private void create() {
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setSize(300, 300);
		this.setLayout(new GridLayout(2,1));
		
		labelID_Curso = new JLabel("ID_Curso: ");
		txtFieldID_Curso = new JTextField(15);
		txtFieldID_Curso.setEnabled(false);

		labelNombre_Curso = new JLabel("Nombre_Curso: ");
		txtFieldNombre_Curso = new JTextField(30);
		
		panelDatos = new JPanel();
		panelBotones = new JPanel();
		
		panelDatos.add(labelID_Curso);
		panelDatos.add(txtFieldID_Curso);
		
		panelDatos.add(labelNombre_Curso);
		panelDatos.add(txtFieldNombre_Curso);

		botonModificarCurso = new JButton("Modificar Curso");
		botonAtras = new JButton("Atras");
		panelBotones.add(botonAtras);
		panelBotones.add(botonModificarCurso);
		
		this.add(panelDatos);
		this.add(panelBotones);
		setLocationRelativeTo(null);
		
		//Inicializamos la vista.
		txtFieldID_Curso.setText("");
		txtFieldID_Curso.requestFocus();
	
		pack();		
	}
	
	public static VentanaModificarCurso getInstance() {
		// begin-user-code
		if(uniqueInstance == null){
			uniqueInstance = new VentanaModificarCurso();
		}
		return uniqueInstance;
		// end-user-code
	}

	public void update(int evento, Object datos) {
		// begin-user-code
		//Integer ID_Curso = (Integer)datos;
		//TCurso tCurso = (TCurso)datos;
		//String stringID = Integer.toString(tCurso.getId_Curso());	
		
		switch (evento) 
		{
			case (EventoGUI.MOSTRAR_CURSO):
			{
				TCurso tCurso = (TCurso)datos;	
				//JOptionPane.showMessageDialog(null, "Se deberian mostrar los datos de la ventana para ser modificados");
				//limpio y foco
				int ID_Curso = tCurso.getId_Curso();
				String stringID = Integer.toString(ID_Curso);
				txtFieldID_Curso.setText(stringID);
				txtFieldNombre_Curso.setText(tCurso.getNombre());
				txtFieldNombre_Curso.requestFocus();
				this.setVisible(true);
				
			}
			break;
			
			case (EventoGUI.MODIFICAR_CURSO_CORRECTO):
			{
				int id = Integer.parseInt(txtFieldID_Curso.getText());
				JOptionPane.showMessageDialog(null, "Curso con [ ID: " + id + " ] Modificado.");
				
				//limpio y foco
				txtFieldID_Curso.requestFocus();
			}
			break;
			
			case (EventoGUI.MODIFICAR_CURSO_DUPLICADO):
			{
				int id = Integer.parseInt(txtFieldID_Curso.getText());
				JOptionPane.showMessageDialog(null, "Curso ya existente.");
				
				//limpio y foco
				txtFieldID_Curso.requestFocus();
			}
			break;
			
			case (EventoGUI.MODIFICAR_CURSO_ERROR):
			{
				//TCurso tCurso = (TCurso)datos;	
				JOptionPane.showMessageDialog(null, "ERROR al modificar los datos");
				//String stringNombre = tCurso.getNombre();
				//txtFieldNombre_Curso.setText(stringNombre);
				VentanaModificarCurso.getInstance().setVisible(true);
			}
			break;
		}
		// end-user-code
	}
	
	
	//****************************************************//
	//***************** Action Listener ******************//
	//****************************************************// 
	

	public class ALVentanaModificarCursos implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
			if(event.getSource() == botonAtras){
				VentanaModificarCurso.this.dispose();
				VentanaBuscarCurso.getInstance().setVisible(true);
	
			}

			if(event.getSource() == botonModificarCurso){
				//******* Obtencion de datos de la ventana ******
				String stringID = "";
				stringID = txtFieldID_Curso.getText();

				String stringNombreCurso = "";
				stringNombreCurso = txtFieldNombre_Curso.getText();

				if(!stringNombreCurso.equalsIgnoreCase("")){
					int ID_Curso = Integer.parseInt(stringID);
					TCurso tCurso = new TCurso(ID_Curso, stringNombreCurso, 1);
					
					Controlador.getInstance().action(EventoNegocio.MODIFICAR_CURSO, tCurso);

				}
				else{
					JOptionPane.showMessageDialog(null, "Introduzca un nombre para el curso");
					//Devolvemos el foco.
					txtFieldID_Curso.requestFocus();
				}
			}
		}
	}
	
	//****************************************************//
	//***************** Window Listener ******************//
	//****************************************************// 

	public class WLVentanaModificarCurso implements WindowListener {

		public void windowOpened(WindowEvent arg0) {
			// begin-user-code
			txtFieldID_Curso.requestFocus();
			// end-user-code
		}

		public void windowClosing(WindowEvent arg0) {
			VentanaModificarCurso.this.dispose();
			JPrincipalSMS.getInstance().setVisible(true);
		}

		public void windowClosed(WindowEvent arg0) {
			// begin-user-code
			// TODO Ap�ndice de m�todo generado autom�ticamente

			// end-user-code
		}

		public void windowIconified(WindowEvent arg0) {
			// begin-user-code
			// TODO Ap�ndice de m�todo generado autom�ticamente

			// end-user-code
		}

		public void windowDeiconified(WindowEvent arg0) {
			// begin-user-code
			// TODO Ap�ndice de m�todo generado autom�ticamente

			// end-user-code
		}

		public void windowActivated(WindowEvent arg0) {
			// begin-user-code
			// TODO Ap�ndice de m�todo generado autom�ticamente

			// end-user-code
		}

		public void windowDeactivated(WindowEvent arg0) {
			// begin-user-code
			// TODO Ap�ndice de m�todo generado autom�ticamente

			// end-user-code
		}
	}
	
	
	
	
}