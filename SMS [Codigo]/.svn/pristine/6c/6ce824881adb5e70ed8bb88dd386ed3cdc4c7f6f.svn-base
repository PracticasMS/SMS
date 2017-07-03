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
public class ComandoModificarMatricula implements Comando {
	/** 
	 * (sin Javadoc)
	 * @see Comando#execute(Object datos)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Contexto execute(Object datos) {

		int id_Matricula = -1;
		Contexto contx = null;
		
		SAMatricula miSAMatricula = FactoriaSA.getInstance().creaSAMatricula();
		
		try {
			id_Matricula = miSAMatricula.modificarMatricula((TMatricula)datos);
			//rellenar el contexto
			if(id_Matricula == -1){
				contx = new Contexto(EventoGUI.MODIFICAR_MATRICULA_ERROR, id_Matricula);
			}else{
				contx = new Contexto(EventoGUI.MODIFICAR_MATRICULA_CORRECTO, id_Matricula);
			}
			
		}catch (ExcepcionNegocio e) {
			contx = new Contexto(EventoGUI.MODIFICAR_MATRICULA_ERROR, id_Matricula);
		}
		
		return contx;
	}
}