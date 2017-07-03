/**
 * 
 */
package SMSJPA.Presentacion.Controlador;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class Contexto {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private int evento;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private Object datos;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public Contexto() {
		// begin-user-code
		// TODO Apéndice de constructor generado automáticamente
		// end-user-code
	}
	
	/**
	 * @param evento
	 * @param datos
	 */
	public Contexto(int evento, Object datos) {
		this.evento = evento;
		this.datos = datos;
	}

	/**
	 * @return el evento
	 */
	public int getEvento() {
		return evento;
	}

	/**
	 * @return el datos
	 */
	public Object getDatos() {
		return datos;
	}
}