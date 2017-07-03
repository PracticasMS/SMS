/**
 * 
 */
package SMSJPA.Integracion.FactoriaQuery;


import SMSJPA.Integracion.Query.Query;


public abstract class FactoriaQuery {
	
	private static FactoriaQuery uniqueInstance;

	public static FactoriaQuery getInstance() {
		
		if (uniqueInstance == null) {
			uniqueInstance = new FactoriaQueryImp();
		}
		return uniqueInstance;
	}
	
	public abstract Query creaQuery(int tipoQuery);
}