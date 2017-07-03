/**
 * 
 */
package SMSJPA.Integracion.FactoriaQuery;

import SMSJPA.Integracion.Query.CalcularNominaTurno;
import SMSJPA.Integracion.Query.Query;

public class FactoriaQueryImp extends FactoriaQuery {
	
	public Query creaQuery(int tipoQuery) {
		// begin-user-code
		Query miQuery = null;

		switch (tipoQuery) {
			case Querys.CalcularNominaTurno: {
				miQuery = new CalcularNominaTurno();
	
			} break;
		}

		return miQuery;

	}
}