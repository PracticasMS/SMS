/**
 * 
 */
package SMSJPA.Presentacion.Controlador;

import SMSJPA.Presentacion.Comandos.Comando;
import SMSJPA.Presentacion.Comandos.FactoriaComandos.FactoriaComandos;
import SMSJPA.Presentacion.Dispacher.Dispacher;



/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class ControladorImp extends Controlador {
	/** 
	 * (sin Javadoc)
	 * @see Controlador#action(int EventoNegocio, Object datos)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public void action(int evento, Object datos) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		Comando comando = FactoriaComandos.getInstance().crearComando(evento);
		Contexto contexto = comando.execute(datos);
		Dispacher.getInstance().dispach(evento, contexto);
		// end-user-code
	}
}