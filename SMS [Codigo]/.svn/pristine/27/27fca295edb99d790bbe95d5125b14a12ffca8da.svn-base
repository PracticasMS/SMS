
/**
 * 
 */
package SMSDAO.Presentacion.Comandos.Matricula;

import SMSDAO.Negocio.ExcepcionNegocio.ExcepcionNegocio;
import SMSDAO.Negocio.FactoriaSA.FactoriaSA;
import SMSDAO.Negocio.Matricula.SAMatricula;
import SMSDAO.Negocio.Matricula.TMatricula;
import SMSDAO.Presentacion.Comandos.Comando;
import SMSDAO.Presentacion.Controlador.Contexto;
import SMSDAO.Presentacion.JPrincipal.EventoGUI;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Eduardo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ComandoBuscarMatricula implements Comando {
	/** 
	 * (sin Javadoc)
	 * @see Comando#execute(Object datos)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Contexto execute(Object datos) {
		// begin-user-code
		TMatricula miMatricula = null;
		Contexto contx = null;
		
		SAMatricula miSAMatricula = FactoriaSA.getInstance().creaSAMatricula();
		
		try {
			miMatricula = miSAMatricula.buscarMatricula((TMatricula)datos);
			//rellenar el contexto
			
			if(miMatricula == null){
				contx = new Contexto(EventoGUI.BUSCAR_MATRICULA_ERROR, null);
			}else{
				contx = new Contexto(EventoGUI.MOSTRAR_MATRICULA, miMatricula);
			}
		}catch (ExcepcionNegocio e) {
			contx = new Contexto(EventoGUI.BUSCAR_MATRICULA_ERROR, null);
		}
			
		return contx;
		// end-user-code
	}
}