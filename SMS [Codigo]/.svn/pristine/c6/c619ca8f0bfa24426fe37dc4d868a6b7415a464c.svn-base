/**
 * 
 */
package SMSDAO.Presentacion.Controlador;

import SMSDAO.Presentacion.Comandos.Comando;
import SMSDAO.Presentacion.Dispacher.Dispacher;
import SMSDAO.Presentacion.FactoriaComandos.FactoriaComandos;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ControladorImp extends Controlador {

	/** 
	 * (sin Javadoc)
	 * @see Controlador#action(int eventoNegocio, Object datos)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void action(int eventoNegocio, Object datos) {
		// begin-user-code
		//System.out.println("ControladorIMP:: -- Evento Pedido: "+ eventoNegocio);
		Comando comando = FactoriaComandos.getInstance().crearComando(eventoNegocio);
		Contexto contexto = comando.execute(datos);
		Dispacher.getInstance().dispach(eventoNegocio, contexto);

		// end-user-code
	}
}