/**
 * 
 */
package SMSJPA.Negocio.Materia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import SMSJPA.Negocio.ExcepcionNegocio.ExcepcionNegocio;
import SMSJPA.Negocio.Profesor.TProfesor;
import SMSJPA.Negocio.Profesor.profesor;
import SMSJPA.Negocio.Turno.TTurno;
import SMSJPA.Negocio.Turno.turno;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class SAMateriaImp implements SAMateria {
	/** 
	 * (sin Javadoc)
	 * @see SAMateria#crearMateria(TMateria datos)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public int crearMateria(TMateria datos) throws ExcepcionNegocio {
		
		// TODO Apéndice de método generado automáticamente
		//Creación del entity manager.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SMSProgJPA"); 
		EntityManager em = emf.createEntityManager();
		
		
		String Nombre = datos.getNombre();
		String Descripcion = datos.getDescripcion();
		
				
		//Creamos y persistimos una materia.
		em.getTransaction().begin();
		materia mymateria = new materia(1, Nombre, Descripcion, 1, null);
		
		em.persist(mymateria);
			
		em.getTransaction().commit(); 
		
		//Cerramos las conexiones.
		em.close();
		emf.close();
		
		return mymateria.getId();
		
	}

	/** 
	 * (sin Javadoc)
	 * @see SAMateria#buscarMateria(TMateria Parámetro1)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public TMateria buscarMateria(TMateria datos)  throws ExcepcionNegocio{

		//Creación del entity manager.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SMSProgJPA"); 
		EntityManager em = emf.createEntityManager();
		
		TMateriaAñosExpe mat = null;
		//cojo el id de la materia recogida por el transfer
		
		int id = datos.getID();
		
		materia miBOMateria;
		
		//Creamos y persistimos una materia.
		em.getTransaction().begin();
			miBOMateria = em.find(materia.class, id, LockModeType.OPTIMISTIC);
		em.getTransaction().commit(); 
		
		
		if(miBOMateria != null){
			if(miBOMateria.getActivo()==1)
				mat = miBOMateria.creaTMateriaAñosExpe();	
		}
			
		
		//Cerramos las conexiones.
		em.close();
		emf.close();
		
		
		return mat;
	}


	public int modificarMateria(TMateria datos)  throws ExcepcionNegocio{
		
		int id_result = -1;
		
		//Creación del entity manager.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SMSProgJPA"); 
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		materia materia = em.find(materia.class, datos.getID(), LockModeType.OPTIMISTIC);
		
		if(materia != null){
			if(materia.getActivo()==1){
				materia.setDescripcion(datos.getDescripcion());
				materia.setNombre(datos.getNombre());			
				id_result = materia.getId();
			}
		}
		else {
			
			throw new ExcepcionNegocio("Materia Inexistente");
			
		}
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		
		return id_result;
		
	}

	/** 
	 * (sin Javadoc)
	 * @see SAMateria#eliminarMateria(TMateria datos)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public int eliminarMateria(TMateria datos) throws ExcepcionNegocio{
		//Creación del entity manager.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SMSProgJPA"); 
		EntityManager em = emf.createEntityManager();
		
		int ID = datos.getID();
		materia myMateria;
		
		//borramos una materia.
		em.getTransaction().begin();
		myMateria = em.find(materia.class, ID, LockModeType.OPTIMISTIC);
		if(myMateria != null){
			if(myMateria.getActivo() == 1)
				if(myMateria.getProfMateria().size() == 0)
					myMateria.setActivo(0);
				else
					ID = -2;
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

	/** 
	 * (sin Javadoc)
	 * @see SAMateria#listarMaterias()
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<TMateria> listarMaterias() throws ExcepcionNegocio{
		ArrayList<TMateria> misMaterias = new ArrayList<TMateria>();
		
		//Creación del entity manager.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SMSProgJPA"); 
		EntityManager em = emf.createEntityManager();
		//Creamos y comenzamos una transaccion.
		em.getTransaction().begin();
		//Guardamos todos los turnos en el array
		//turno t = em.find(turno.class, 1);
		javax.persistence.Query query = em.createNativeQuery("SELECT * FROM materia t", materia.class);
		List<materia> listaMateriasAux = query.getResultList();
		//Finalizamos la transaccion
		em.getTransaction().commit(); 
		
		//Cerramos las conexiones.
		em.close();
		emf.close();
			
		Iterator<materia> it = listaMateriasAux.iterator();
		while(it.hasNext()){
			materia t = it.next();
			if(t.getActivo()==1){
				misMaterias.add(t.creaTMateriaAñosExpe());
			}
		}
				
		return misMaterias;
	}
	
}