/**
 * 
 */
package SMSJPA.Negocio.Turno;

import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.eclipse.persistence.jpa.config.NamedNativeQuery;

import SMSJPA.Integracion.FactoriaQuery.FactoriaQuery;
import SMSJPA.Integracion.FactoriaQuery.Querys;
//import SMSJPA.Integracion.Query.Query;
import SMSJPA.Negocio.ExcepcionNegocio.ExcepcionNegocio;
import SMSJPA.Negocio.Profesor.ProfesorResidente;
import SMSJPA.Negocio.Profesor.TProfesor;
import SMSJPA.Negocio.Profesor.profesor;


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class SATurnoImp implements SATurno {

	@Override
	public int crearTurno(TTurno datos) throws ExcepcionNegocio {
		// TODO Apéndice de método generado automáticamente
		
		//Creación del entity manager.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SMSProgJPA"); 
		EntityManager em = emf.createEntityManager();
		
		
		//Convierto las horas recogidas en los transfer a objetos del tipo Time para el BOTurno
		String _hIni = Integer.toString(datos.getHora_inicio()) + ":00:00";
		Time timeIni = Time.valueOf(_hIni); 
		
		String _hFin = Integer.toString(datos.getHora_fin()) + ":00:00";
		Time timeFin = Time.valueOf(_hFin); 
				
		//Creamos y persistimos un turno.
		em.getTransaction().begin();

		//turno myturno = new turno(1, timeIni, timeFin, datos.getObservaciones());

		turno myturno = new turno(1, timeIni, timeFin, datos.getObservaciones(), 1);

		em.persist(myturno);
		em.getTransaction().commit(); 
	
		//Cerramos las conexiones.
		em.close();
		emf.close();
		
		return myturno.getId();
	}

	@Override
	public int borrarTurno(TTurno datos) throws ExcepcionNegocio {
		// TODO Apéndice de método generado automáticamente
		//Creación del entity manager.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SMSProgJPA"); 
		EntityManager em = emf.createEntityManager();
		
		int ID = datos.getID();
		turno myTurno;
		
		//borramos un turno.
		em.getTransaction().begin();
		myTurno = em.find(turno.class, ID, LockModeType.OPTIMISTIC);
		if(myTurno != null){
			if(myTurno.getActivo() == 1)
					myTurno.setActivo(0);
			// OJO ESTO ES BORRADO FISICO  em.remove(myTurno);
			else
				ID = -1;
			
		}else{
			ID = -1;
		}
		em.getTransaction().commit(); 
		
		//Cerramos las conexiones.
		em.close();
		emf.close();
		
		return ID;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public ArrayList<TTurno> listarTurnos() throws ExcepcionNegocio{
		ArrayList<TTurno> misTurnos = new ArrayList<TTurno>();
		
		//Creación del entity manager.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SMSProgJPA"); 
		EntityManager em = emf.createEntityManager();
		//Creamos y comenzamos una transaccion.
		em.getTransaction().begin();
		//Guardamos todos los turnos en el array
		//turno t = em.find(turno.class, 1);
		Query query = em.createNativeQuery("SELECT * FROM turno t", turno.class);
		List<turno> listaTurnosAux = query.getResultList();
		//Finalizamos la transaccion
		em.getTransaction().commit(); 
		
		//Cerramos las conexiones.
		em.close();
		emf.close();
		
		Iterator<turno> it = listaTurnosAux.iterator();
		while(it.hasNext()){
			turno t = it.next();
			
			if(t.getActivo()==1){
				@SuppressWarnings("deprecation")
				TTurno Tturno = new TTurno(t.getId(), t.getHoraInicio().getHours(), t.getHoraFin().getHours(), t.getObservaciones());
				misTurnos.add(Tturno);
			}
		}
				
		return misTurnos;
	}

	@SuppressWarnings("deprecation")
	@Override
	public TTurno buscarTurno(TTurno datos) throws ExcepcionNegocio{
		
		//Creación del entity manager.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SMSProgJPA"); 
		EntityManager em = emf.createEntityManager();
		
		//cojo el id de turno recogido por el transfer
		
		int ID = datos.getID();
		TTurno Tturno;
		turno myTurno;
		
		//Creamos y persistimos un turno.
		em.getTransaction().begin();
		myTurno = em.find(turno.class, ID, LockModeType.OPTIMISTIC);
		em.getTransaction().commit(); 
		
		//Cerramos las conexiones.
		em.close();
		emf.close();
		if(myTurno != null)
			Tturno = new TTurno(myTurno.getId(), myTurno.getHoraInicio().getHours(), myTurno.getHoraFin().getHours(), myTurno.getObservaciones());
		else
			Tturno = null;
		
		
		return Tturno;
		
		
	}
	
	@SuppressWarnings("rawtypes")
	public int Calcular_Nomina_Turno(TTurno datos) throws ExcepcionNegocio{
		//Creación del entity manager.
		
		int nominaTurno = 0;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SMSProgJPA"); 
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		turno turno = em.find(turno.class, datos.getID(), LockModeType.OPTIMISTIC);
		
		TypedQuery<profesor> query = em.createNamedQuery("SMSJPA.Negocio.Profesor.profesor.findByTurnoYActivo", profesor.class);
		List<profesor> listaProfesores = query.setParameter("turno", turno).getResultList();

		int numProfesActivos = 0;
		profesor p;
		Iterator<profesor> it = listaProfesores.iterator();
		while(it.hasNext()){
			p = it.next();
			if(p.getActivo() == 1){
				nominaTurno += p.calculaNominaProfesor();
				numProfesActivos++;
			}
		}
		if(numProfesActivos == 0)
			nominaTurno = -1;
		
		em.getTransaction().commit();

		em.close();
		emf.close();
		
		return nominaTurno;
		
	}

	@Override
	public int modificarTurno(TTurno datos) throws ExcepcionNegocio{
		int id_result = -1;
		
		//Creación del entity manager.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SMSProgJPA"); 
		EntityManager em = emf.createEntityManager();
		
		//Convierto las horas recogidas en los transfer a objetos del tipo Time para el BOTurno
		String _hIni = Integer.toString(datos.getHora_inicio()) + ":00:00";
		Time timeIni = Time.valueOf(_hIni); 
		
		String _hFin = Integer.toString(datos.getHora_fin()) + ":00:00";
		Time timeFin = Time.valueOf(_hFin); 
				
		//Creamos y persistimos un turno.
		em.getTransaction().begin();
		
		//turno miturno = new turno(datos.getID(), timeIni, timeFin, datos.getObservaciones());
		//em.persist(miturno);
		
		turno turno = em.find(turno.class, datos.getID(), LockModeType.OPTIMISTIC);
		
		if(turno != null){
			turno.setObservaciones(datos.getObservaciones());
			turno.setHoraInicio(timeIni);
			turno.setHoraFin(timeFin);
			id_result = turno.getId();
		}
		
		em.getTransaction().commit(); 
		
		//Cerramos las conexiones.
		em.close();
		emf.close();
		
		return id_result;
		
	}	
}