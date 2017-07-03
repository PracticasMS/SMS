/**
 * 
 */
package SMSDAO.Negocio.Alumnos;

import java.util.ArrayList;

import SMSDAO.Negocio.ExcepcionNegocio.ExcepcionNegocio;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract interface SAAlumno {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param datos
	 * @return
	 * @throws ExcepcionNegocio
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract int crearAlumno(TAlumno datos) throws ExcepcionNegocio;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param datos
	 * @return
	 * @throws ExcepcionNegocio
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract int modificarAlumno(TAlumno datos) throws ExcepcionNegocio;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param datos
	 * @return
	 * @throws ExcepcionNegocio
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract int borrarAlumno(TAlumno datos) throws ExcepcionNegocio;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @throws ExcepcionNegocio
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract ArrayList<TAlumno> listarAlumnos() throws ExcepcionNegocio;
	
	
	
	public abstract ArrayList<TAlumno> listarAlumnosNMatriculasMAños(TAlumno datos) throws ExcepcionNegocio;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param datos
	 * @return
	 * @throws ExcepcionNegocio
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract TAlumno mostrarAlumno(TAlumno datos)
			throws ExcepcionNegocio;
}