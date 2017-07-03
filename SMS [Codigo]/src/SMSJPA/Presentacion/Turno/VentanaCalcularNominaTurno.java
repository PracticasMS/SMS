/**
 * 
 */
package SMSJPA.Presentacion.Turno;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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

import SMSJPA.Negocio.Turno.TTurno;
import SMSJPA.Presentacion.Controlador.Controlador;
import SMSJPA.Presentacion.Controlador.EventoGUI;
import SMSJPA.Presentacion.JPrincipal.JPrincipalSMS;
import SMSJPA.Presentacion.Turno.VentanaEliminarTurno.ALVentanaEliminarTurno;
import SMSJPA.Presentacion.Turno.VentanaEliminarTurno.WLVentanaEliminarTurno;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class VentanaCalcularNominaTurno extends JFrame {
	
	private static final long serialVersionUID = -2402549527334380120L;
	
	private static VentanaCalcularNominaTurno uniqueInstance;
	// Observaciones
	private JLabel labelId_turno;
	private JTextField txtFieldId_turno;
	
	// Botones
	private JButton botonCalcular;
	private JButton botonAtras;

	private JPanel panelDatos;
	private JPanel panelBotones;

	public static void main(String args[]) {
		VentanaCalcularNominaTurno.getInstance().setVisible(true);
	}
	
	public VentanaCalcularNominaTurno() {
		super("Calcular Nomina de un turno");
		create();
		agregarManejadoresDeEventos();
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public static VentanaCalcularNominaTurno getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new VentanaCalcularNominaTurno();
		}
		return uniqueInstance;
	}
	
	// Agregar manejadores de eventos
	private void agregarManejadoresDeEventos() {
		addWindowListener(new WLVentanaCalcularNominaTurno());

		ALVentanaCalcularNominaTurno oyente = new ALVentanaCalcularNominaTurno();
		botonCalcular.addActionListener(oyente);
		botonAtras.addActionListener(oyente);
	}
	
	private void create() {
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setSize(300, 300);
		this.setLayout(new BorderLayout());
		
		// Observaciones
		
		labelId_turno = new JLabel("Introduzca el Id_turno: ");
		txtFieldId_turno = new JTextField(20);
		

		panelDatos = new JPanel();
		panelDatos.setLayout(new FlowLayout());
		panelBotones = new JPanel();

		panelDatos.add(labelId_turno);
		panelDatos.add(txtFieldId_turno);
		
		//Botones.
		botonCalcular = new JButton("Calcular Nomina");
		botonAtras = new JButton("Atras");
		
		//Agregado de botones al panel.
		panelBotones.add(botonAtras);
		panelBotones.add(botonCalcular);


		this.add(panelDatos, BorderLayout.NORTH);
		this.add(panelBotones, BorderLayout.SOUTH);
		setLocationRelativeTo(null);

		// Inicializamos la vista.
		limpiarCampos();

		pack();
	}
	
	public void limpiarCampos(){
		txtFieldId_turno.setText("");
	}
	
	public void update(int eventoGUI, Object datos) {
				
		switch (eventoGUI) {
		
			case (EventoGUI.CALCULAR_NOMINA_TURNO_INEXISTENTE): {
				JOptionPane.showMessageDialog(null, "No hay ningún profesor"
						+ " asignado a dicho turno ");
			} break;
			
			case (EventoGUI.CALCULAR_NOMINA_TURNO): {
				JOptionPane.showMessageDialog(null, "La nomina total es " + datos + "€");
			} break;
		}
		
	}
	
	// ****************************************************//
	// ***************** Action Listener ******************//
	// ****************************************************//
	
	public class ALVentanaCalcularNominaTurno implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			
			if (event.getSource() == botonAtras) {
				
				limpiarCampos();
				VentanaCalcularNominaTurno.this.dispose();
				Controlador.getInstance().action(EventoGUI.ABRIR_JPRINCIPAL, 0);
			}
			
			if (event.getSource() == botonCalcular) {
				
				try{
					// ******* Obtencion de datos de la ventana ******
					// Observaciones
					String stringId_Turno = "";
					stringId_Turno = txtFieldId_turno.getText();
					
					if (!stringId_Turno.equalsIgnoreCase("")){
						TTurno tTurno = new TTurno(Integer.parseInt(stringId_Turno));
						Controlador.getInstance().action(EventoGUI.CALCULAR_NOMINA_TURNO, tTurno);
						
					}
					else{
						JOptionPane.showMessageDialog(null, "Introduce una Id_turno.");
						txtFieldId_turno.requestFocus();
					}
					
				} catch (NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Introduzca datos correctamente");
				}	
			}
		}
	}
	
	// ****************************************************//
	// ***************** Window Listener ******************//
	// ****************************************************//
	
	public class WLVentanaCalcularNominaTurno implements WindowListener {

		public void windowOpened(WindowEvent arg0) {
			txtFieldId_turno.requestFocus();
		}
		
		public void windowClosing(WindowEvent arg0) {
			limpiarCampos();
			VentanaCalcularNominaTurno.this.dispose();
			JPrincipalSMS.getInstance().setVisible(true);
		}
		
		public void windowActivated(WindowEvent e) {
		}

		public void windowClosed(WindowEvent e) {
		}

		public void windowDeactivated(WindowEvent e) {
		}

		public void windowDeiconified(WindowEvent e) {
		}

		public void windowIconified(WindowEvent e) {
		}


	}
}