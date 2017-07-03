/**
 * 
 */
package SMSJPA.Negocio.Profesor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import SMSJPA.Negocio.Materia.TMateriaAñosExpe;
import SMSJPA.Negocio.Materia.materia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import SMSJPA.Negocio.ExcepcionNegocio.ExcepcionNegocio;
import SMSJPA.Negocio.Turno.turno;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class SAProfesorImp implements SAProfesor {
	/** 
	 * (sin Javadoc)
	 * @see SAProfesor#crearProfesor()
	 * @return -1 error, -2 el turno no exixte, -3 una materia no existe
	 */
	public int crearProfesor(TProfesor profeNuevo)  throws ExcepcionNegocio{
		int retorno =-1;
		boolean todoOK = true;
		boolean hayReactivacion = false;
		profesor miProfeNuevo = null;
		profesor profeAux = null;

		Set<ProfMateria> profMaterias = new HashSet<ProfMateria>();
		ArrayList<TMateriaAñosExpe> arrayMat = profeNuevo.getMaterias();

		
		miProfeNuevo = creaBOProfesor(profeNuevo);

		try{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("SMSProgJPA"); 
			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();

			try{
				if(profeNuevo.getTipo().equalsIgnoreCase("RESIDENTE")){
					TypedQuery<ProfesorResidente> query = em.createNamedQuery("SMSJPA.Integracion.Profesor.ProfesorResidente.findByDNI", ProfesorResidente.class);
					profeAux = query.setParameter("DNI", profeNuevo.getDNI()).getSingleResult();


				}else if(profeNuevo.getTipo().equalsIgnoreCase("AUXILIAR")){
					TypedQuery<ProfesorAuxiliar> query = em.createNamedQuery("SMSJPA.Integracion.Profesor.ProfesorAuxiliar.findByNum_SS", ProfesorAuxiliar.class);
					profeAux = query.setParameter("Num_SS", profeNuevo.getNum_SS()).getSingleResult();

				}

			}catch(NoResultException e){
				profeAux = null;
			}

			if(profeAux != null){ //el profesor existe

				if(profeAux.getActivo() == 0){ // ya existe y no está activo //REACTIVACION DEL PROFESOR

					hayReactivacion = true;


					//todoOK = creaProfMaterias(em, profeAux, arrayMat, profMaterias );
					//profeAux.setProfMateria(profMaterias);

					turno turno = em.find(turno.class, profeNuevo.getId_turno(), LockModeType.OPTIMISTIC);
					if(turno != null){

						profeAux.setTurno(turno);

						profeAux.setActivo(1);

						profeAux.setApellidos(miProfeNuevo.getApellidos());
						profeAux.setEmail(miProfeNuevo.getEmail());
						profeAux.setNombre(miProfeNuevo.getNombre());
						profeAux.setProfMateria(miProfeNuevo.getProfMateria());
						profeAux.setTelefono(miProfeNuevo.getTelefono());

						todoOK = true;
						retorno =-5; //turno existente

					}else{
						retorno =-2; //turno existente
						todoOK=false;
					}
				}else{ // el profe existe y está activo
					
					retorno =-4; // profesor existente
					todoOK=false;
					
				}
				
			}else { //el profe no existe
				
				if(!creaProfMaterias(em, miProfeNuevo, arrayMat, profMaterias )){
					retorno = -3; //materia inexistente
					todoOK=false;
				}else{

					miProfeNuevo.setProfMateria(profMaterias);

					turno turno = em.find(turno.class, profeNuevo.getId_turno(), LockModeType.OPTIMISTIC);
					if(turno != null){

						miProfeNuevo.setTurno(turno);

						em.persist(miProfeNuevo);

						todoOK = true;

					}else{
						retorno =-2; //turno existente
						todoOK=false;
					}
				}
			}
			em.getTransaction().commit(); 

			if(todoOK){
				if(hayReactivacion){

					retorno = -5; //profesor reactivado
				}else{
					retorno = miProfeNuevo.getId();
				}
			}

			//Cerramos las conexiones.
			em.close();
			emf.close();

		}catch (PersistenceException e) {
			throw new ExcepcionNegocio();
		}

		return retorno;
	}
		

	/**
	 * @param em
	 * @param profeNuevo
	 * @param arrayMat
	 * @param profMaterias
	 */
	private boolean creaProfMaterias(EntityManager em, profesor profeNuevo, ArrayList<TMateriaAñosExpe> arrayMat, Set<ProfMateria> profMaterias) {
		materia materiaAux = new materia();
		boolean todoOK = true;
		
		//para un unico profesor hay que crear tantas materias y profMaterias como trnasfers tenga el arraylist (si exixsten de antemano en la BBDD)
		boolean fin=false;
		for(int i=0; i<arrayMat.size() && !fin;i++){

			materiaAux = em.find(materia.class, arrayMat.get(i).getID(), LockModeType.OPTIMISTIC);

			if( materiaAux != null){
				ProfMateria profMatAux = new ProfMateria(profeNuevo, materiaAux, arrayMat.get(i).getAñosExperiecia());
				em.persist(profMatAux);
				profMaterias.add(profMatAux);

			}else{
				
			}
		}
		return todoOK;
		
	}

	/**
	 * @param profeNuevo
	 * @return
	 */

	private profesor creaBOProfesor(TProfesor profeNuevo) {
	
		
		turno miturno = new turno(profeNuevo.getId_turno());
		profesor miprofe = null;
		
		if(profeNuevo.getTipo().equalsIgnoreCase("RESIDENTE")){
			miprofe =  new ProfesorResidente(-1, profeNuevo.getNombre(), profeNuevo.getApellidos(), profeNuevo.getTelefono(), profeNuevo.getEmail(), 1, profeNuevo.getTipo(), miturno, null, profeNuevo.getDNI());
			miprofe.setSueldoBase(profeNuevo.getSueldoBase());
			miprofe.setSuplemento(profeNuevo.getSuplementos());
			
		}else if(profeNuevo.getTipo().equalsIgnoreCase("AUXILIAR")){
			miprofe = new ProfesorAuxiliar(-1, profeNuevo.getNombre(), profeNuevo.getApellidos(), profeNuevo.getTelefono(), profeNuevo.getEmail(), 1, profeNuevo.getTipo(),miturno , null, profeNuevo.getNum_SS());
			miprofe.setEurosPorHora(profeNuevo.getEurosPorHora());
			miprofe.setHorasTrabajadas(profeNuevo.getHorasTrabajadas());
		}
		
		return miprofe;
		
	}

		//return new profesor(-1, profeNuevo.getNombre(), profeNuevo.getApellidos(), profeNuevo.getTelefono(), profeNuevo.getEmail(), 1, profeNuevo.getTipo(), null, null);
	//}
	
	

	public TProfesor buscarProfesor(TProfesor datos) {
		TProfesor tProfesor;
		//Creación del entity manager.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SMSProgJPA"); 
		EntityManager em = emf.createEntityManager();
		
		//cojo el id del Profesor recogido en el transfer
		
		int id = datos.getId();
		
		profesor miBOProfesor;
		
		//Creamos y persistimos un Profesor.
		em.getTransaction().begin();
		miBOProfesor = em.find(profesor.class, id, LockModeType.OPTIMISTIC);
		em.getTransaction().commit(); 
		
		if(miBOProfesor == null)
			tProfesor = null;
		else
			if(miBOProfesor.getActivo() == 1)
				tProfesor =  miBOProfesor.creaTProfesor();
			else
				tProfesor = null;
		//Cerramos las conexiones.
		em.close();
		emf.close();
		
		return tProfesor;
	}

	public int modificarProfesor(TProfesor datos) throws ExcepcionNegocio {
		
		int id_result = -1;
		
		//Creación del entity manager.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SMSProgJPA"); 
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		profesor profesor = em.find(profesor.class, datos.getId(), LockModeType.OPTIMISTIC);
				
		try{	
			if(profesor != null){

				if(profesor.getActivo() == 1){
					// 	COMPARAMOS EL TIPO DE LA BBDD CON EL DEL BO
					String tipoAnterior = profesor.getTipo();
				
					profesor.setNombre(datos.getNombre());
					profesor.setApellidos(datos.getApellidos());
					profesor.setTelefono(datos.getTelefono());
					profesor.setEmail(datos.getEmail());
					turno miturno = em.find(turno.class, datos.getId_turno(), LockModeType.OPTIMISTIC);
					if (miturno!=null){
						//turno miturno = new turno(datos.getId_turno());
						//buscar el turno y comprobar que existe
						profesor.setTurno(miturno);
						
						/**/
						if(tipoAnterior.equalsIgnoreCase(datos.getTipo()))
						{
							if(datos.getTipo().equalsIgnoreCase("RESIDENTE")){
								profesor.setSuplemento(datos.getSuplementos());
								profesor.setSueldoBase(datos.getSueldoBase());
							}
							if(datos.getTipo().equalsIgnoreCase("AUXILIAR")){
								profesor.setEurosPorHora(datos.getEurosPorHora());
								profesor.setHorasTrabajadas(datos.getHorasTrabajadas());
							}
							/* Set<ProfMateria> profMaterias = new HashSet<ProfMateria>();
							ArrayList<TMateriaAñosExpe> mismaterias = datos.getMaterias();
							boolean nofin = true;
							for (int i = 0; i<mismaterias.size() && nofin; i++){
								materia materiaux = em.find(materia.class, mismaterias.get(i).getID(), LockModeType.OPTIMISTIC);
								if (materiaux!=null){
									profMaterias.add(new ProfMateria(profesor,materiaux,mismaterias.get(i).getAñosExperiecia()));
								}
								else{
									nofin = false;
									id_result = -3;
								}
							}
							
							profesor.setProfMateria(profMaterias); */
						
						}
						else{

							// BORRADO FISICO, COMPLETO, DE LA BASE DE DATOS
							//ELIMINAR SOLO LA TUPLA DE LA ESPECIALIDAD
							Iterator<ProfMateria> it = profesor.getProfMateria().iterator();
							while(it.hasNext()){
								ProfMateria t = it.next();
								em.remove(t);
							}
							em.remove(profesor);
							
							// VOLVEMOS A CREAR EL BO DE PROFESOR PORQUE HAY QUE CAMBIARLO DE TABLA
							profesor nuevoProfesor = creaBOProfesor(datos);
							Set<ProfMateria> profMaterias = new HashSet<ProfMateria>();
							
							creaProfMaterias(em, nuevoProfesor, datos.getMaterias(), profMaterias );
							
							nuevoProfesor.setProfMateria(profMaterias);
							
							em.persist(nuevoProfesor);
							
						}
						id_result = datos.getId();
					}
					else id_result = -2;
				}
				else{
					throw new ExcepcionNegocio("Profesor Inexistente");
				}		
					
			}
		}
		catch (PersistenceException e) {
			throw new ExcepcionNegocio("Profesor Inexistente");
		}
	
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		return id_result;
		
	}

	public int eliminarProfesor(TProfesor datos) throws ExcepcionNegocio {
		//Creación del entity manager.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SMSProgJPA"); 
		EntityManager em = emf.createEntityManager();
		
		int ID = datos.getId();
		profesor myProfesor;
		
		//borramos un profesor.
		em.getTransaction().begin();
		myProfesor = em.find(profesor.class, ID, LockModeType.OPTIMISTIC);
		if(myProfesor != null){
			if(myProfesor.getActivo() == 1){
				myProfesor.setActivo(0);
				// BORRADO FISICO, COMPLETO, DE LA BASE DE DATOS
				//ELIMINAR SOLO LA TUPLA DE LA ESPECIALIDAD
				Iterator<ProfMateria> it = myProfesor.getProfMateria().iterator();
				while(it.hasNext()){
					ProfMateria t = it.next();
					em.remove(t);
				}
			}
			else ID = -1;
		}else{
			ID = -1;
		}
		em.getTransaction().commit(); 
		
		//Cerramos las conexiones.
		em.close();
		emf.close();
		
		return ID;
	}

	public ArrayList<TProfesor> listarProfesores()  throws ExcepcionNegocio{
		
		ArrayList<TProfesor> misProfesores = new ArrayList<TProfesor>();
		
		//Creación del entity manager.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SMSProgJPA"); 
		EntityManager em = emf.createEntityManager();
		
		//Creamos y comenzamos una transaccion.
		em.getTransaction().begin();
		
		//Guardamos todos los profesores en el array
		
		javax.persistence.Query query = em.createNativeQuery("SELECT * FROM profesor t", profesor.class);
		List<profesor> listaProfesoresAux = query.getResultList();
		
		//Finalizamos la transaccion
		em.getTransaction().commit(); 
		
		//Cerramos las conexiones.
		em.close();
		emf.close();
			
		Iterator<profesor> it = listaProfesoresAux.iterator();
		while(it.hasNext()){
			profesor t = it.next();
			if(t.getActivo() == 1)
				misProfesores.add(t.creaTProfesor());
		}
				
		return misProfesores;
	}
}