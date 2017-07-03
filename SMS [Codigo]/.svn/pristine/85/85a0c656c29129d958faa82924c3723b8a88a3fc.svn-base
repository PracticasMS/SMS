/**
 * 
 */
package SMSJPA.Presentacion.Comandos.Materia;

import java.util.ArrayList;

import SMSJPA.Negocio.ExcepcionNegocio.ExcepcionNegocio;
import SMSJPA.Negocio.FactoriaSA.FactoriaSA;
import SMSJPA.Negocio.Materia.SAMateria;
import SMSJPA.Negocio.Materia.TMateria;
import SMSJPA.Presentacion.Comandos.Comando;
import SMSJPA.Presentacion.Controlador.Contexto;
import SMSJPA.Presentacion.Controlador.EventoGUI;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class ComandoListarMaterias implements Comando {
	/** 
	 * (sin Javadoc)
	 * @see Comando#execute(Object datos)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public Contexto execute(Object datos) {
		Contexto contx = null;
		ArrayList<TMateria> misMaterias = null;
		SAMateria miSAMateria = FactoriaSA.getInstance().crearSAMateria();
		
		try {
			
			misMaterias = miSAMateria.listarMaterias();
			if (misMaterias.size() == 0){
				contx = new Contexto(EventoGUI.LISTAR_MATERIAS_ERRORAUX, misMaterias);
			}
			else contx = new Contexto(EventoGUI.LISTAR_MATERIAS, misMaterias);
			
		}catch (ExcepcionNegocio e) {
			contx = new Contexto(EventoGUI.LISTAR_MATERIAS_ERROR, null);
		}

		return contx;
	}
}