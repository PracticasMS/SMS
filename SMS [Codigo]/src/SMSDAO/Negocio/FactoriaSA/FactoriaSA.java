/**
 * 
 */
package SMSDAO.Negocio.FactoriaSA;

import SMSDAO.Negocio.Alumnos.SAAlumno;
import SMSDAO.Negocio.Curso.SACurso;
import SMSDAO.Negocio.Matricula.SAMatricula;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class FactoriaSA {

	private static FactoriaSA uniqueInstance;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static FactoriaSA getInstance() {
		// begin-user-code	
		if (uniqueInstance == null) {
			uniqueInstance = new FactoriaSAImp();
		}

		return uniqueInstance;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract SACurso creaSACurso();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract SAAlumno creaSAAlumno() ;
	
	public abstract SAMatricula creaSAMatricula() ;
	
}