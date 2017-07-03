 /**
 * 
 */
package SMSJPA.Presentacion.Materia;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

import SMSJPA.Negocio.Materia.TMateria;
import SMSJPA.Negocio.Turno.TTurno;
import SMSJPA.Presentacion.Controlador.Controlador;
import SMSJPA.Presentacion.Controlador.EventoGUI;
import SMSJPA.Presentacion.JPrincipal.JPrincipalSMS;
import SMSJPA.Presentacion.Turno.VentanaEliminarTurno;
import SMSJPA.Presentacion.Turno.VentanaEliminarTurno.ALVentanaEliminarTurno;
import SMSJPA.Presentacion.Turno.VentanaEliminarTurno.WLVentanaEliminarTurno;


public class VentanaEliminarMateria extends JFrame {
	
	private static final long serialVersionUID = -6482013052235052222L;
	
	private static VentanaEliminarMateria uniqueInstance;
	// Observaciones
	private JLabel labelId_Materia;
	private JTextField txtFieldId_Materia;
	
	// Botones
	private JButton botonBorrar;
	private JButton botonAtras;

	private JPanel panelDatos;
	private JPanel panelBotones;

	public static void main(String args[]) {
		VentanaEliminarTurno.getInstance().setVisible(true);
	}
	
	public VentanaEliminarMateria() {
		super("Borrar Materia");
		create();
		agregarManejadoresDeEventos();
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public static VentanaEliminarMateria getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new VentanaEliminarMateria();
		}
		return uniqueInstance;
	}
	// Agregamos oyentes
	private void agregarManejadoresDeEventos() {
		addWindowListener(new WLVentanaEliminarMateria());

		ALVentanaEliminarMateria oyente = new ALVentanaEliminarMateria();
		botonBorrar.addActionListener(oyente);
		botonAtras.addActionListener(oyente);
	}
	
	private void create() {
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setSize(300, 300);
		this.setLayout(new BorderLayout());
		
		// Observaciones
		
		labelId_Materia = new JLabel("Introduzca el Id_Materia: ");
		txtFieldId_Materia = new JTextField(20);
		

		panelDatos = new JPanel();
		panelDatos.setLayout(new FlowLayout());
		panelBotones = new JPanel();

		panelDatos.add(labelId_Materia);
		panelDatos.add(txtFieldId_Materia);
		
		//Botones.
		botonBorrar = new JButton("Borrar");
		botonAtras = new JButton("Atras");
		
		//Agregado de botones al panel.
		panelBotones.add(botonAtras);
		panelBotones.add(botonBorrar);


		this.add(panelDatos, BorderLayout.NORTH);
		this.add(panelBotones, BorderLayout.SOUTH);
		setLocationRelativeTo(null);

		// Inicializamos la vista.
		limpiarCampos();

		pack();
	}
	
	public void limpiarCampos(){
		txtFieldId_Materia.setText("");
	}
	
	public void update(int eventoGUI, Object datos) {
		switch (eventoGUI) {
			case (EventoGUI.MATERIA_BORRADO): {
				Integer ID = (Integer) datos;
	
				JOptionPane.showMessageDialog(null,
						"Materia con [ ID: " + ID.intValue() + " ] Eliminada.");
				
				limpiarCampos();
				
				//Mandamos el foco al primer campo.
				txtFieldId_Materia.requestFocus();
			}
				break;
			case (EventoGUI.MATERIA_INEXISTENTE): {
				JOptionPane.showMessageDialog(null,
						"La materia NO existe en la BBDD");
				txtFieldId_Materia.requestFocus();
			}break;
			case (EventoGUI.MATERIA_BORRAR_ERROR): {
				JOptionPane.showMessageDialog(null,
						"La materia NO se pudo borrar porque tiene un profesor asignado");
				txtFieldId_Materia.requestFocus();
			}break;
		}
	}
	
	
	
	public class ALVentanaEliminarMateria implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent evento) {
			if (evento.getSource() == botonAtras) {
				
				limpiarCampos();
				VentanaEliminarMateria.this.dispose();
				Controlador.getInstance().action(EventoGUI.ABRIR_JPRINCIPAL, 0);
			}

			if (evento.getSource() == botonBorrar) {
				
				try{
					// ******* Obtencion de datos de la ventana ******
					// Observaciones
					String stringId_Materia = "";
					stringId_Materia = txtFieldId_Materia.getText();
					
					if (!stringId_Materia.equalsIgnoreCase("")){
						TMateria tMateria = new TMateria(Integer.parseInt(stringId_Materia));
						Controlador.getInstance().action(EventoGUI.BORRAR_MATERIA, tMateria);
						
					}
					else{
						JOptionPane.showMessageDialog(null, "Introduce el Id_Materia a borrar.");
						txtFieldId_Materia.requestFocus();
					}
					
				} catch (NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Introduzca datos correctamente");
				}
						
			}
		}
			
	}
	
	
	public class WLVentanaEliminarMateria implements WindowListener {

		@Override
		public void windowActivated(WindowEvent e) {
			txtFieldId_Materia.requestFocus();
		}

		@Override
		public void windowClosed(WindowEvent e) {}

		@Override
		public void windowClosing(WindowEvent e) {
			limpiarCampos();
			VentanaEliminarMateria.this.dispose();
			JPrincipalSMS.getInstance().setVisible(true);
		}

		@Override
		public void windowDeactivated(WindowEvent e) {}

		@Override
		public void windowDeiconified(WindowEvent e) {}

		@Override
		public void windowIconified(WindowEvent e) {}

		@Override
		public void windowOpened(WindowEvent e) {}
	}
}