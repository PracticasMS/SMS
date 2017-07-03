package SMSJPA.Integracion.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import SMSDAO.Integracion.ExcepcionesIntegracion.ExcepcionIntegracion;
import SMSJPA.Integracion.FactoriaQuery.FactoriaQuery;
import SMSJPA.Integracion.FactoriaQuery.Querys;
import SMSJPA.Negocio.Turno.TTurno;
import SMSJPA.Negocio.Turno.turno;

public class CalcularNominaTurno implements Query{

	@Override
	public Object execute(EntityManager em, Object datos) {

		//SMSJPA.Integracion.Query.Query miQuery = FactoriaQuery.getInstance().creaQuery(Querys.CalcularNominaTurno);
		//javax.persistence.Query myQuery = em.createQuery("SELECT sum((substring(HORAFIN,1,2)-substring(HORAINICIO,1,2))*10) as nomina FROM profesor as pro, turno as tur WHERE pro.turno_id=tur.id AND tur.id=1 AND pro.activo=1");
		//javax.persistence.Query myQuery = em.createQuery("SELECT sum(tur.activo) nomina FROM profesor pro, turno tur WHERE pro.turno_id=tur.id AND tur.id=1 AND pro.activo=1");
		//javax.persistence.Query myQuery = em.createQuery("SELECT HORAFIN"  + "FROM TURNO ");
		
		//Query query = em.createQuery("SELECT HORAFIN"  + "FROM TURNO ");
		//return myQuery.getSingleResult();
		
		return null;
	}

}
