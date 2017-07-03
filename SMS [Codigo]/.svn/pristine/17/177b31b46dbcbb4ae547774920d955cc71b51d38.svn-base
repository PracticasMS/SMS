/**
 * 
 */
package SMSDAO.Negocio.Alumnos;

import java.util.ArrayList;

import SMSDAO.Integracion.Alumnos.DAOAlumno;
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
public class SAAlumnoImp implements SAAlumno {
	
	public int crearAlumno(TAlumno datos) throws ExcepcionNegocio {
		int miAlumno = -1;
		
		TransactionManager.getInstance().creaTransaccion();
		Transaccion mitrans = (Transaccion)TransactionManager.getInstance().dameTransaccion();

		try {
			mitrans.start();
		
			//Comprobamos que no existe ningún alumno activo con ese DNI.
			
			TAlumno mialumno = FactoriaDAO.getInstance().creaDAOAlumnos().buscarAlumnoByDNIALL(datos);
			
			//Caso en el que no existe.
			if (mialumno == null){
				miAlumno = FactoriaDAO.getInstance().creaDAOAlumnos().crearAlumnos(datos);
			}
			else if (mialumno.getActivo()==1) //Caso en el que exista un alumno con ese dni y este activo.
				miAlumno = -2;
			else if (mialumno.getActivo()==0){
				datos.setActivo(1);
				miAlumno = FactoriaDAO.getInstance().creaDAOAlumnos().modificarAlumnos(datos);	
			}
			else miAlumno = -1;
					
			
		} catch (ExcepcionIntegracion e) {
			throw new ExcepcionNegocio(e.getMessage());
		}finally{
			try {
				mitrans.commit();
			} catch (ExcepcionIntegracion e) {
				throw new ExcepcionNegocio(e.getMessage());
			}
		}
		
		return miAlumno;
	}

	/** 
	 * (sin Javadoc)
	 * @see SAAlumno#modificarAlumno(TAlumno datos)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int modificarAlumno(TAlumno datos) throws ExcepcionNegocio {
		int dni_Alumno = -1;
		
		TransactionManager.getInstance().creaTransaccion();
		Transaccion mitrans = (Transaccion)TransactionManager.getInstance().dameTransaccion();
		
		try {
			mitrans.start();
			
			//Comprobamos que no existe ningún alumno activo con ese DNI.
		
			//TAlumno mialumno = FactoriaDAO.getInstance().creaDAOAlumnos().buscarAlumnoByDNI(datos);
			
			//Caso en el que no existe.
			//if (mialumno == null){
				datos.setActivo(1);
				dni_Alumno = FactoriaDAO.getInstance().creaDAOAlumnos().modificarAlumnos(datos);
			//}else //Caso en el que existe un alumno con ese dni.
				//id_Alumno = -2;
			
							
		} catch (ExcepcionIntegracion e) {
			throw new ExcepcionNegocio(e.getMessage());
		}finally{
			try {
				mitrans.commit();
			} catch (ExcepcionIntegracion e) {
				throw new ExcepcionNegocio(e.getMessage());
			}
		}
		
		return dni_Alumno;
	}

	/** 
	 * (sin Javadoc)
	 * @see SAAlumno#borrarAlumno(TAlumno datos)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int borrarAlumno(TAlumno datos) throws ExcepcionNegocio {
		// begin-user-code
		int DNI_Alumno = datos.getDni();
		boolean matriculaVigente = false;
		
		TransactionManager.getInstance().creaTransaccion();
		Transaccion mitrans = (Transaccion)TransactionManager.getInstance().dameTransaccion();

		try {
			mitrans.start();
		
			Query miQuery = FactoriaQuery.getInstance().creaQuery(Querys.MatriculasVigentesByDNI);
			
			
			Object obj = miQuery.execute(DNI_Alumno);
			matriculaVigente = (Boolean) obj;
			
			if(!matriculaVigente){ //no tiene matricula asignada
				DAOAlumno miDAO = FactoriaDAO.getInstance().creaDAOAlumnos();
				DNI_Alumno = miDAO.eliminarAlumno(datos);
				
			}else{ //Tiene matricula asignada
				DNI_Alumno = -1;
			}

			
		} catch (ExcepcionIntegracion e) {
			throw new ExcepcionNegocio(e.getMessage());
		}finally{
			try {
				mitrans.commit();
			} catch (ExcepcionIntegracion e) {
				throw new ExcepcionNegocio(e.getMessage());
			}
		}
		
		return DNI_Alumno;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SAAlumno#listarAlumnos()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList<TAlumno> listarAlumnos() throws ExcepcionNegocio {
		
		ArrayList<TAlumno> misAlumnos = null;
		DAOAlumno DAOAlumno = FactoriaDAO.getInstance().creaDAOAlumnos();
		
		TransactionManager.getInstance().creaTransaccion();
		Transaccion mitrans = (Transaccion)TransactionManager.getInstance().dameTransaccion();
		
		try{
			mitrans.start();
			
			misAlumnos = DAOAlumno.listarAlumnos();
			
			mitrans.commit();
			
		} catch (ExcepcionIntegracion e){
			
			throw new ExcepcionNegocio(e.getMessage());
			
		}
		
		return misAlumnos;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SAAlumno#mostrarAlumno(TAlumno datos)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TAlumno mostrarAlumno(TAlumno datos) throws ExcepcionNegocio {
		TAlumno tAlumno = null;
		TransactionManager.getInstance().creaTransaccion();
		Transaccion mitrans = (Transaccion)TransactionManager.getInstance().dameTransaccion();

		try {
			mitrans.start();
			
			DAOAlumno miDAO = FactoriaDAO.getInstance().creaDAOAlumnos();
			tAlumno = miDAO.buscarAlumnoByDNI(datos);
		} catch (ExcepcionIntegracion e) {
			throw new ExcepcionNegocio(e.getMessage());
		}finally{
			try {
				mitrans.commit();
			} catch (ExcepcionIntegracion e) {
				throw new ExcepcionNegocio(e.getMessage());
			}
		}
		return tAlumno;
	}

	/* (sin Javadoc)
	 * @see SMSDAO.Negocio.Alumnos.SAAlumno#listarAlumnosNMatriculasMAños()
	 */
	
	@Override
	public ArrayList<TAlumno> listarAlumnosNMatriculasMAños(TAlumno datos) throws ExcepcionNegocio {
		
		ArrayList<TAlumno> misAlumnos = null;
		Query miQuery = FactoriaQuery.getInstance().creaQuery(Querys.listarAlumnosConNMatriculasEnMAnos);

		TransactionManager.getInstance().creaTransaccion();
		Transaccion mitrans = (Transaccion)TransactionManager.getInstance().dameTransaccion();
		
		try{
			mitrans.start();
			
			misAlumnos = (ArrayList<TAlumno>) miQuery.execute(datos);
			
			mitrans.commit();
			
		} catch (ExcepcionIntegracion e){
			
			throw new ExcepcionNegocio(e.getMessage());
			
		}
		
		return misAlumnos;

	}
}