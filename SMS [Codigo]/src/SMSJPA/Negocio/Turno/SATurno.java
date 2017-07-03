/**
 * 
 */
package SMSJPA.Negocio.Turno;

import java.util.ArrayList;

import SMSJPA.Negocio.ExcepcionNegocio.ExcepcionNegocio;



/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public abstract interface SATurno {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @throws SMSJPA.Negocio.ExcepcionNegocio.ExcepcionNegocio 
	 * @throws ExcepcionNegocio 
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public abstract int crearTurno(TTurno datos) throws ExcepcionNegocio;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public abstract int borrarTurno(TTurno datos) throws ExcepcionNegocio;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public abstract ArrayList<TTurno> listarTurnos() throws ExcepcionNegocio;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public abstract TTurno buscarTurno(TTurno datos) throws ExcepcionNegocio;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public abstract int modificarTurno(TTurno datos) throws ExcepcionNegocio;
	
	public int Calcular_Nomina_Turno(TTurno datos) throws ExcepcionNegocio;



}