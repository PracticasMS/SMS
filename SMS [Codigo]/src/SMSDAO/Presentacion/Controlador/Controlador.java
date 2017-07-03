/**
 * 
 */
package SMSDAO.Presentacion.Controlador;

public abstract class Controlador {

	private static Controlador uniqueInstance;

	public static Controlador getInstance() {
		// begin-user-code
		if (uniqueInstance == null) {
			uniqueInstance = new ControladorImp();
		}
		return uniqueInstance;
		// end-user-code
	}

	public abstract void action(int eventoNegocio, Object datos);
}