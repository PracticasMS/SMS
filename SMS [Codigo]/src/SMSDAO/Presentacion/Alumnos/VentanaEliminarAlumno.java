/**
 * 
 */
package SMSDAO.Presentacion.Alumnos;

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

import SMSDAO.Negocio.Alumnos.TAlumno;
import SMSDAO.Presentacion.Controlador.Controlador;
import SMSDAO.Presentacion.JPrincipal.EventoGUI;
import SMSDAO.Presentacion.JPrincipal.EventoNegocio;
import SMSDAO.Presentacion.JPrincipal.JPrincipalSMS;


public class VentanaEliminarAlumno extends JFrame {
	

		/**
	 * 
	 */
	private static final long serialVersionUID = 3567686711994038470L;
		private JPanel panelDatos;
		private JPanel panelBotones;
		
		
		private JButton botonAtras;
		
		private JButton botonBorrarAlumno;

		private JTextField txtFieldDNI;

		private JLabel labelDNI;

		private static VentanaEliminarAlumno uniqueInstance;

		public static void main(String []args){
			VentanaEliminarAlumno.getInstance().setVisible(true);
		}
		
		
		public VentanaEliminarAlumno(){
			super("Borrar Alumno");
			
			create();
			
			agregarManejadoresDeEventos();
			
			setLocationRelativeTo(null);
			setResizable(false);
		}

		private void agregarManejadoresDeEventos() {
			addWindowListener(new WLVentanaEliminarAlumno());
			
			ALVentanaEliminarAlumno oyente = new ALVentanaEliminarAlumno();
			
			botonAtras.addActionListener(oyente);
			botonBorrarAlumno.addActionListener(oyente);		
		}

		private void create() {
			setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
			this.setSize(300, 300);
			this.setLayout(new GridLayout(2,1));
			
			labelDNI = new JLabel("DNI: ");
			txtFieldDNI = new JTextField(15);
			botonBorrarAlumno = new JButton("Borrar Alumno");
			botonAtras = new JButton("Atras");
			
			panelDatos = new JPanel();
			panelBotones = new JPanel();
			
			
			panelDatos.add(labelDNI);
			panelDatos.add(txtFieldDNI);
			
			panelBotones.add(botonAtras);
			panelBotones.add(botonBorrarAlumno);
			
			this.add(panelDatos);
			this.add(panelBotones);
			setLocationRelativeTo(null);
			
			//Inicializamos la vista.
			txtFieldDNI.setText("");
			txtFieldDNI.requestFocus();
		
			pack();		
		}

		public static VentanaEliminarAlumno getInstance() {
			// begin-user-code
			if(uniqueInstance == null){
				uniqueInstance = new VentanaEliminarAlumno();
			}
			return uniqueInstance;
			// end-user-code
		}

		public void update(int evento, Object datos) {
			// begin-user-code
			Integer DNI = (Integer)datos;
			
			switch (evento) {
			case (EventoGUI.ALUMNO_BORRADO):{
				JOptionPane.showMessageDialog(null, "Alumno con [ DNI: " + DNI.intValue() + " ] borrado.");
				//limpio y foco
				txtFieldDNI.setText("");
				txtFieldDNI.requestFocus();
				
			}break;

			case (EventoGUI.ALUMNO_INEXISTENTE_O_CON_MATRICULA_VIGENTE):{
				JOptionPane.showMessageDialog(null, "ERROR: el Alumno no existe o tiene matricula asignada.");

				txtFieldDNI.requestFocus();
				
			}break;
			
			case (EventoGUI.ALUMNO_BORRAR_ERROR):{
				JOptionPane.showMessageDialog(null, "ERROR al intentar borrar el alumno.");
				txtFieldDNI.requestFocus();
			}break;
		}
			// end-user-code
		}

		//****************************************************//
		//***************** Action Listener ******************//
		//****************************************************// 
		
		public class ALVentanaEliminarAlumno implements ActionListener {

			public void actionPerformed(ActionEvent event) {
				// begin-user-code

				
				if(event.getSource() == botonAtras){
					VentanaEliminarAlumno.this.dispose();
					txtFieldDNI.setText("");
					txtFieldDNI.requestFocus();
					JPrincipalSMS.getInstance().setVisible(true);
					
				}
				
				if(event.getSource() == botonBorrarAlumno){
					
					//******* Obtencion de datos de la ventana ******
					String stringID = "";
					stringID = txtFieldDNI.getText();
					if(!stringID.equalsIgnoreCase("")){
						try{
							int DNI = Integer.parseInt(stringID);
							//DNI, telefono, direccion, fecha_direccion, activo, nombre, apellido
							TAlumno tAlumno = new TAlumno(DNI);
							Controlador.getInstance().action(EventoNegocio.BORRAR_ALUMNO, tAlumno);
						}catch (NumberFormatException e){
							JOptionPane.showMessageDialog(null, "DNI incorrecto");
							txtFieldDNI.setText("");
						}
						
					}else{
						JOptionPane.showMessageDialog(null, "DNI incorrecto");
					}
				}
				// end-user-code
			}
		}

		//****************************************************//
		//***************** Window Listener ******************//
		//****************************************************// 

		public class WLVentanaEliminarAlumno implements WindowListener {
		
			public void windowOpened(WindowEvent arg0) {
				// begin-user-code
				txtFieldDNI.setText("");
				txtFieldDNI.requestFocus();
				// end-user-code
			}

			public void windowClosing(WindowEvent arg0) {
				// begin-user-code
				VentanaEliminarAlumno.this.dispose();
				txtFieldDNI.setText("");
				txtFieldDNI.requestFocus();
				JPrincipalSMS.getInstance().setVisible(true);
				
				// end-user-code
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