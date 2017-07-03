/**
 * 
 */
package SMSDAO.Negocio.Matricula;

import java.util.ArrayList;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Eduardo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TMatricula {
	


	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private int ID_Matricula;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private int DNI;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private String Tipo;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private int Precio;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private String FechaMatricula;
	
	
	private ArrayList<TCursoNivel> cursosNivel;
	
	private int numCursos;
	
	protected int Activo;

	
	
	public TMatricula(int ID_Matricula, int Dni, String tipo, int precio, String fechaMatricula, ArrayList<TCursoNivel> cursosNivel,
			int numCursos, int activo) {
		
		this.ID_Matricula = ID_Matricula;
		this.DNI = Dni;
		Tipo = tipo;
		Precio = precio;
		FechaMatricula = fechaMatricula;
		this.cursosNivel = cursosNivel;
		this.numCursos = numCursos;
		Activo = activo;
	}
	
	
	public TMatricula(int Dni, String tipo, int precio,
			String fechaCurso, ArrayList<TCursoNivel> cursosNivel, int activo) {
		DNI = Dni;
		Tipo = tipo;
		Precio = precio;
		FechaMatricula = fechaCurso;
		this.cursosNivel = cursosNivel;
		Activo = activo;
	}
	
	public TMatricula(int ID_Matricula, int Dni, String tipo, int precio, String fechaMatricula, ArrayList<TCursoNivel> cursosNivel,
			int activo) {
		
		this.ID_Matricula = ID_Matricula;
		this.DNI = Dni;
		Tipo = tipo;
		Precio = precio;
		FechaMatricula = fechaMatricula;
		this.cursosNivel = cursosNivel;
		Activo = activo;
	}


	public TMatricula(int ID_Matricula) {
		this.ID_Matricula = ID_Matricula;
	}
	
	
	
	/**
	 * 
	 */
	public TMatricula() {
		// TODO Apéndice de constructor generado automáticamente
	}


	public int getID_Matricula() {
		return ID_Matricula;
	}

	public void setID_Matricula(int iD_Matricula) {
		iD_Matricula = iD_Matricula;
	}

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int Dni) {
		DNI = Dni;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public int getPrecio() {
		return Precio;
	}

	public void setPrecio(int precio) {
		Precio = precio;
	}

	public String getFechaCurso() {
		return FechaMatricula;
	}

	public void setFechaCurso(String fechaCurso) {
		FechaMatricula = fechaCurso;
	}

	public int getActivo() {
		return Activo;
	}

	public void setActivo(int activo) {
		Activo = activo;
	}

	public ArrayList<TCursoNivel> getCursos(){
		
		return this.cursosNivel;
		
	}


	/**
	 * @param cursosNivel el cursosNivel a establecer
	 */
	public void setCursosNivel(ArrayList<TCursoNivel> cursosNivel) {
		this.cursosNivel = cursosNivel;
		this.numCursos = cursosNivel.size();
	}


	/**
	 * @return el numCursos
	 */
	public int getNumCursos() {
		return numCursos;
	}


	/**
	 * @param numCursos el numCursos a establecer
	 */
	public void setNumCursos(int numCursos) {
		this.numCursos = numCursos;
	}

	

}