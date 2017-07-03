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
public class ComandoEliminarMatricula implements Comando {

	public Contexto execute(Object datos) {
		int ID_Matricula;
		Contexto contx = null;
		
		SAMatricula miSAMatricula = FactoriaSA.getInstance().creaSAMatricula();
		
		try {
			ID_Matricula = miSAMatricula.eliminarMatricula((TMatricula)datos);
			if(ID_Matricula == -1){
				contx = new Contexto(EventoGUI.MATRICULA_INEXISTENTE_O_CON_CURSO_VIGENTE, ID_Matricula);
			}else{
				contx = new Contexto(EventoGUI.MATRICULA_BORRADO, ID_Matricula);
			}
			
		} catch (ExcepcionNegocio e) {
			contx = new Contexto(EventoGUI.MATRICULA_BORRAR_ERROR, null);
		}
		
		return contx;
	}
}