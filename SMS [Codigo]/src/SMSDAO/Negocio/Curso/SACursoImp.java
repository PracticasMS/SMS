/**
 * 
 */
package SMSDAO.Negocio.Curso;

import java.util.ArrayList;

import SMSDAO.Integracion.Curso.DAOCurso;
import SMSDAO.Integracion.ExcepcionesIntegracion.ExcepcionIntegracion;
import SMSDAO.Integracion.FactoriaDAO.FactoriaDAO;
import SMSDAO.Integracion.FactoriaQuery.FactoriaQuery;
import SMSDAO.Integracion.FactoriaQuery.Querys;
import SMSDAO.Integracion.Query.Query;
import SMSDAO.Integracion.Transacciones.Transaccion;
import SMSDAO.Integracion.TransactionManager.TransactionManager;
import SMSDAO.Negocio.ExcepcionNegocio.ExcepcionNegocio;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SACursoImp implements SACurso {
	/** 
	 * (sin Javadoc)
	 * @see SACurso#crearCurso()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	
	public int crearCurso(TCurso datos) throws ExcepcionNegocio {
		// begin-user-code
		int miCurso = -1;
		TCurso curso;
		
		TransactionManager.getInstance().creaTransaccion();
		Transaccion mitrans = (Transaccion)TransactionManager.getInstance().dameTransaccion();

		try {
			mitrans.start();
			
			/*Comprobamos que no existe un curso con este nombre.
			 * en el caso de que exista se realiza update en vez de crear si está desactivado.
			 */
			curso = FactoriaDAO.getInstance().creaDAOCurso().buscarCursoByNombre(datos.getNombre());

			if (curso!=null){
				//Caso en el que lo encuentre y no esté activo.
				if (curso.getActivo()==0){
					//Realizamos la actualización.
					curso.setActivo(1);
					FactoriaDAO.getInstance().creaDAOCurso().modificarCurso(curso);
					miCurso = curso.getId_Curso();
				}
				else miCurso=-1;
				
			}
			else miCurso = FactoriaDAO.getInstance().creaDAOCurso().crearCurso(datos);
						
			
		} catch (ExcepcionIntegracion e) {
			throw new ExcepcionNegocio(e.getMessage());
		}finally{
			try {
				mitrans.commit();
			} catch (ExcepcionIntegracion e) {
				throw new ExcepcionNegocio(e.getMessage());
			}
		}
		
		return miCurso;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SACurso#modificarCurso()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int modificarCurso(TCurso datos) throws ExcepcionNegocio {
		
		int id_Curso = -1;
		
		TransactionManager.getInstance().creaTransaccion();
		Transaccion mitrans = (Transaccion)TransactionManager.getInstance().dameTransaccion();
		
		try {
			mitrans.start();
			
			DAOCurso miDAO = FactoriaDAO.getInstance().creaDAOCurso();
			
			//Comprobamos que no existe ningún curso activo con el nombre puesto.
			
			TCurso curso= miDAO.buscarCursoByNombre(datos.getNombre());
			
			if(curso == null){
				id_Curso = miDAO.modificarCurso(datos);
			}
			else id_Curso = -2;
			
		} catch (ExcepcionIntegracion e) {
			throw new ExcepcionNegocio(e.getMessage());
		}finally{
			try {
				mitrans.commit();
			} catch (ExcepcionIntegracion e) {
				throw new ExcepcionNegocio(e.getMessage());
			}
		}
		
		return id_Curso;
		// end-user-code
		
	}

	public int borrarCurso(TCurso datos) throws ExcepcionNegocio {
		// begin-user-code
		int id_Curso = datos.getId_Curso();
		boolean cursoVigente = false;
		
		TransactionManager.getInstance().creaTransaccion();
		Transaccion mitrans = (Transaccion)TransactionManager.getInstance().dameTransaccion();

		try {
			mitrans.start();
			
			TCurso micurso = FactoriaDAO.getInstance().creaDAOCurso().buscarCursoByID(datos.getId_Curso());
			
			if (micurso!=null){ //Caso en el que exista el curso.
				Query miQuery = FactoriaQuery.getInstance().creaQuery(Querys.cursosVigentesActualmente);
				
				Object obj = miQuery.execute(id_Curso);
				
				cursoVigente = (Boolean) obj;
				
				if(!cursoVigente){
					DAOCurso miDAO = FactoriaDAO.getInstance().creaDAOCurso();
					id_Curso = miDAO.eliminarCurso(datos);
					
				}else{
					id_Curso = -2;
				}
			}
			else id_Curso=-1;
		
			
		} catch (ExcepcionIntegracion e) {
			throw new ExcepcionNegocio(e.getMessage());
		}finally{
			try {
				mitrans.commit();
			} catch (ExcepcionIntegracion e) {
				throw new ExcepcionNegocio(e.getMessage());
			}
		}
		
		return id_Curso;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SACurso#listarCursos()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList<TCurso> listarCursos() throws ExcepcionNegocio {

		ArrayList<TCurso> misCursos = null;
		DAOCurso DAOCurso = FactoriaDAO.getInstance().creaDAOCurso();
		
		TransactionManager.getInstance().creaTransaccion();
		Transaccion mitrans = (Transaccion)TransactionManager.getInstance().dameTransaccion();
		
		try{
			mitrans.start();
			
			misCursos = DAOCurso.listarCursos();
			
			mitrans.commit();
			
		} catch (ExcepcionIntegracion e){
			
			throw new ExcepcionNegocio(e.getMessage());
			
		}
		
		return misCursos;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SACurso#mostrarCurso()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TCurso mostrarCurso(TCurso datos) throws ExcepcionNegocio {
		TCurso tCurso = null;
		TransactionManager.getInstance().creaTransaccion();
		Transaccion mitrans = (Transaccion)TransactionManager.getInstance().dameTransaccion();
		
		try {
			mitrans.start();
			
			DAOCurso miDAO = FactoriaDAO.getInstance().creaDAOCurso();
			tCurso = miDAO.buscarCursoByID(datos.getId_Curso());
		} catch (ExcepcionIntegracion e) {
			throw new ExcepcionNegocio(e.getMessage());
		}finally{
			try {
				mitrans.commit();
			} catch (ExcepcionIntegracion e) {
				throw new ExcepcionNegocio(e.getMessage());
			}
		}
		return tCurso;
	}
}