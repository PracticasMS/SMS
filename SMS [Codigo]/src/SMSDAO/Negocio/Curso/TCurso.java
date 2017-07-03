/**
 * 
 */
package SMSDAO.Negocio.Curso;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TCurso {
	
	public TCurso(int id_Curso, String nombre, int activo) {
		super();
		Id_Curso = id_Curso;
		Nombre = nombre;
		Activo = activo;
	}
	/** 
	 * 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private int Id_Curso;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private String Nombre;
	
	private int Activo;
	
	
	public int getId_Curso() {
		return Id_Curso;
	}
	public void setId_Curso(int id_Curso) {
		Id_Curso = id_Curso;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public int getActivo() {
		return Activo;
	}
	public void setActivo(int activo){
		Activo = activo;
	}


}