/**
 * 
 */
package SMSDAO.Negocio.Alumnos;


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TAlumnoFamNumerosa extends TAlumno {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private int num_fam;

	

	/**
	 * @param id
	 * @param nombre
	 * @param apellidos
	 * @param direccion
	 * @param fecha_Nacimiento
	 * @param telefono
	 * @param activo
	 * @param num_fam
	 */
	public TAlumnoFamNumerosa(int Dni, String nombre, String apellidos,
			String direccion, String fecha_Nacimiento, int telefono, int activo,
			int num_fam) {
		super(Dni, nombre, apellidos, direccion, fecha_Nacimiento, telefono,
				activo);
		this.num_fam = num_fam;
	}
	public TAlumnoFamNumerosa(int Dni, String nombre, String apellidos, String direccion,
			String fecha, int telefono, int num_familia_numerosa) {
		
		super(Dni, nombre, apellidos, direccion, fecha, telefono);
		this.num_fam = num_familia_numerosa;
	}
	
	public int getNum_fam() {
		return num_fam;
	}

	public void setNum_fam(int num_fam) {
		this.num_fam = num_fam;
	}

}