/**
 * 
 */
package SMSDAO.Negocio.Matricula;

import java.util.ArrayList;
import java.util.Calendar;

import SMSDAO.Integracion.ExcepcionesIntegracion.ExcepcionIntegracion;
import SMSDAO.Integracion.FactoriaDAO.FactoriaDAO;
import SMSDAO.Integracion.FactoriaQuery.FactoriaQuery;
import SMSDAO.Integracion.FactoriaQuery.Querys;
import SMSDAO.Integracion.Matricula.DAOMatricula;
import SMSDAO.Integracion.Query.Query;
import SMSDAO.Integracion.Transacciones.Transaccion;
import SMSDAO.Integracion.TransactionManager.TransactionManager;
import SMSDAO.Negocio.Alumnos.TAlumno;
import SMSDAO.Negocio.Curso.TCurso;
import SMSDAO.Negocio.ExcepcionNegocio.ExcepcionNegocio;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Eduardo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SAMatriculaImp implements SAMatricula {
	/** 
	 * (sin Javadoc)
	 * @see SAMatricula#buscarMatricula()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TMatricula buscarMatricula(TMatricula datos) throws ExcepcionNegocio {
		// begin-user-code
		
		TMatricula miMatricula = null;
		
		TransactionManager.getInstance().creaTransaccion();
		Transaccion mitrans = (Transaccion)TransactionManager.getInstance().dameTransaccion();
		
		try {
			mitrans.start();
			
			miMatricula = FactoriaDAO.getInstance().creaDAOMatricula().buscarMatriculaByID(datos.getID_Matricula());
			
		} catch (ExcepcionIntegracion e) {
			throw new ExcepcionNegocio(e.getMessage());
		}finally{
			try {
				mitrans.commit();
			} catch (ExcepcionIntegracion e) {
				throw new ExcepcionNegocio(e.getMessage());
			}
		}
		return miMatricula;
		
		
		
		
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SAMatricula#crearMatricula()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int crearMatricula(TMatricula datos) throws ExcepcionNegocio {
		int id_Matricula = -1;
		
		TransactionManager.getInstance().creaTransaccion();
		Transaccion mitrans = (Transaccion)TransactionManager.getInstance().dameTransaccion();
		
		try {
			mitrans.start();
			
			//Comprobamos que el id de alumno insertado pertenece a un alumno activo.
			TAlumno mialumno = new TAlumno(datos.getDNI());
			mialumno = FactoriaDAO.getInstance().creaDAOAlumnos().buscarAlumnoByDNI(mialumno);
			boolean todocorrecto=true;
			
			if (mialumno!=null){
				//Compruebo que no existe una matrícula vigente del alumno dado.
				Query miQuery = FactoriaQuery.getInstance().creaQuery(Querys.MatriculasVigentesByDNI);
				Object obj = miQuery.execute(datos.getDNI());
				boolean cursoVigente = (Boolean) obj;
				if (!cursoVigente){
					//Insertamos la matricula.

					id_Matricula = FactoriaDAO.getInstance().creaDAOMatricula().crearMatricula(datos);

					if (id_Matricula!=-1){
						//Insertamos en la tabla nivel_matricula_curso comprobando que existen y están activos.

						ArrayList<TCursoNivel> miscursos = datos.getCursos();
						for( int i = 0 ; (i < miscursos.size()) && todocorrecto ; i++ ){
							//Compruebo si existe el curso y está activo.
							TCurso micurso = FactoriaDAO.getInstance().creaDAOCurso().buscarCursoByID(miscursos.get(i).getId_Curso());

							if (micurso!=null){
								//Si está activo lo insertamos.	
								FactoriaDAO.getInstance().creaDAOMatricula().insertarNivelMatriculaCurso(id_Matricula, miscursos.get(i));
							}
							else todocorrecto=false;
						}
					}
					//Caso en el que al insertar la asociacion de un curso a una matrícula no se haya encontrado o no esté activo.
					if (!todocorrecto){
						id_Matricula = -3;
						mitrans.rollBack();
					}
					else mitrans.commit();
				}
				else id_Matricula = -2;
			}
			else id_Matricula = -4;
			
		} catch (ExcepcionIntegracion e) {
			throw new ExcepcionNegocio(e.getMessage());
		}
		return id_Matricula;
	}

	/** 
	 * (sin Javadoc)
	 * @see SAMatricula#modificarMatricula()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int modificarMatricula(TMatricula datos) throws ExcepcionNegocio {
		
		int id_Matricula = -1;
		
		TransactionManager.getInstance().creaTransaccion();
		Transaccion mitrans = (Transaccion)TransactionManager.getInstance().dameTransaccion();
		
		try {
			mitrans.start();
			
			boolean todocorrecto=true;
						
			
					//Modificamos la matricula.

					id_Matricula = FactoriaDAO.getInstance().creaDAOMatricula().modificarMatricula(datos);

					if (id_Matricula!=-1){
						//Insertamos en la tabla nivel_matricula_curso comprobando que existen y están activos.

						ArrayList<TCursoNivel> miscursos = datos.getCursos();
						ArrayList<TCursoNivel> cursosbbdd = FactoriaDAO.getInstance().creaDAOMatricula().buscarMatriculaByID(datos.getID_Matricula()).getCursos();
						
						for( int i = 0 ; (i < miscursos.size()) && todocorrecto ; i++ ){
							//Compruebo si existe el curso y está activo.
							
							TCurso micurso = FactoriaDAO.getInstance().creaDAOCurso().buscarCursoByID(miscursos.get(i).getId_Curso());

							if (micurso!=null){
								
								boolean encontrado = false;
								int j = 0;
								//comprobamos que el curso esta en la bbdd
								while(j < cursosbbdd.size() && !encontrado){
									
									if(micurso.getId_Curso() == cursosbbdd.get(j).getId_Curso())
										encontrado = true;
									
									j++;
								}
								if(encontrado){
									
									FactoriaDAO.getInstance().creaDAOMatricula().actualizarNivelMatriculaCurso(id_Matricula, miscursos.get(i));
									
								}
								else if(/*el curso no esta en la BBDD y vamos a insertarlo*/true){
									
									FactoriaDAO.getInstance().creaDAOMatricula().insertarNivelMatriculaCurso(id_Matricula, miscursos.get(i));
									
								}
							}
							else todocorrecto=false;
						}
						
						//Hasta aqui tenemos los nuevos cursos añadidos y los que ya estaban modificados
						
						//ahora tenemos que quitar cursos que estaban en la bbdd y en la ventana de modificar los hemos quitado 
						
						//preguntamos a la base de datos si tiene mas cursos que los que deberia tener, si eso es cierto significa que hay que quitar alguno
						cursosbbdd = FactoriaDAO.getInstance().creaDAOMatricula().buscarMatriculaByID(datos.getID_Matricula()).getCursos();
						
						if(miscursos.size() < cursosbbdd.size()){
							
							//recorremos la lista de cursos de la bbdd hasta que encontremos el curso que no esta en la lista de la ventana y lo eliminamos
							for(int i = 0; i < cursosbbdd.size(); i++){
								int j = 0;
								boolean encontrado = false;
								while(j < miscursos.size() && !encontrado){
									
									if(cursosbbdd.get(i).getId_Curso() == miscursos.get(j).getId_Curso())
										encontrado = true;
									
									j++;
								}
								
								if(!encontrado){ //quiere decir que ese curso esta en la bbdd pero no en la ventana de modificar asik lo eliminamos de la bbdd
									
									FactoriaDAO.getInstance().creaDAOMatricula().borrarNivelMatriculaCurso(id_Matricula, cursosbbdd.get(i));
									
								}
							}
							
						}
						
						
						
					}
					//Caso en el que al modificar la asociacion de un curso a una matrícula no se haya encontrado o no esté activo.
					if (!todocorrecto){
						id_Matricula = -3;
						mitrans.rollBack();
					}
					else mitrans.commit();
			
			
			
		} catch (ExcepcionIntegracion e) {
			throw new ExcepcionNegocio(e.getMessage());
		}finally{
			/*try {
				//mitrans.commit();
			} catch (ExcepcionIntegracion e) {
				throw new ExcepcionNegocio(e.getMessage());
			}*/
		}
		
		return id_Matricula;
}

	/** 
	 * (sin Javadoc)
	 * @see SAMatricula#eliminarMatricula()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int eliminarMatricula(TMatricula datos) throws ExcepcionNegocio {
		int id_Matricula = datos.getID_Matricula();
		boolean cursoVigente = false;
		//Creamos una transaccion y la pedimos
		TransactionManager.getInstance().creaTransaccion();
		Transaccion mitrans = (Transaccion)TransactionManager.getInstance().dameTransaccion();

		try {
			//Iniciamos la transaccion
			mitrans.start();
			//Creamos un DAOMatricula
			DAOMatricula miDAO = FactoriaDAO.getInstance().creaDAOMatricula();
			//Recuperamos la matricula de la BBDD
			datos = miDAO.buscarMatriculaByID(id_Matricula);

			//Obtenemos la año del curso perteneciente a la matricula
			String fecha = datos.getFechaCurso();
			fecha = fecha.substring(0, 4);
			int añoCurso = Integer.parseInt(fecha);
			//Obtenemos la fecha actual
			//Date fechaActual = new Date();
			//@SuppressWarnings("deprecation")
			int añoActual = Calendar.getInstance().get(Calendar.YEAR);
			//Si el año actual coincide con la decha del curso de la matricula,
			//el curso estaria vigente y la matricula no se podria borrar
			if (añoCurso == añoActual){
				cursoVigente = true;
			}
			if(!cursoVigente){ //no tiene CURSO vigente
				miDAO = FactoriaDAO.getInstance().creaDAOMatricula();
				id_Matricula = miDAO.eliminarMatricula(datos);
				
			}else{ //Tiene curso vigente
				id_Matricula = -1;
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
		
		return id_Matricula;
	}

	/** 
	 * (sin Javadoc)
	 * @see SAMatricula#listarMatriculas()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList<TMatricula> listarMatriculas() throws ExcepcionNegocio {
		// begin-user-code

		ArrayList<TMatricula> misMatriculas = null;
		DAOMatricula DAOMatriculas = FactoriaDAO.getInstance().creaDAOMatricula();
		
		TransactionManager.getInstance().creaTransaccion();
		Transaccion mitrans = (Transaccion)TransactionManager.getInstance().dameTransaccion();
		
		try{
			mitrans.start();
			
			misMatriculas = DAOMatriculas.listarMatriculas();
			
			mitrans.commit();
			
		} catch (ExcepcionIntegracion e){
			
			throw new ExcepcionNegocio(e.getMessage());
			
		}
		
		return misMatriculas;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SAMatricula#listarMatriculasnalunos()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<TMatricula> listarMatriculasNCursos(int datos) throws ExcepcionNegocio {
		// begin-user-code

		ArrayList<TMatricula> misMatriculas = null;
		
		TransactionManager.getInstance().creaTransaccion();
		Transaccion mitrans = (Transaccion)TransactionManager.getInstance().dameTransaccion();
		
		try{
			mitrans.start();
			
			misMatriculas = (ArrayList<TMatricula>) FactoriaQuery.getInstance().creaQuery(Querys.listarMatriculasNCursos).execute(datos);
			
			mitrans.commit();
			
		} catch (ExcepcionIntegracion e){
			
			throw new ExcepcionNegocio(e.getMessage());
			
		}
		
		return misMatriculas;
		// end-user-code
	}
}