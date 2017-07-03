/**
 * 
 */
package SMSJPA.Negocio.Materia;

import java.util.ArrayList;

import SMSJPA.Negocio.Profesor.TProfesor;
import SMSJPA.Negocio.Profesor.TProfesorAñosExpe;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class TMateria {
	
	private int ID;

	private int activo;
	
	private String Nombre;
	
	private String Descripcion;
	
	private ArrayList<TProfesorAñosExpe> profesores;
	

	//CONSTRUCTORES.
	
	public TMateria() {
		super();
		ID = 0;
		this.activo = 1;
		profesores = null;
		Nombre = "";
		Descripcion = "";
	}
	public TMateria(int iD) {
		super();
		ID = iD;
	}
	public TMateria(int iD, int activo, ArrayList<TProfesorAñosExpe> profesores,
			String nombre, String descripcion) {
		ID = iD;
		this.activo = activo;
		this.profesores = profesores;
		Nombre = nombre;
		Descripcion = descripcion;
	}

	//SETTERS AND GETTERS.
	
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}


	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	//ToString
	
	@Override
	public String toString() {
		return "TMateria [ID=" + ID + ", activo=" + activo + ", ID_Profesor="
				+ profesores + ", Nombre=" + Nombre + ", Descripcion="
				+ Descripcion + "]";
	}

	public ArrayList<TProfesorAñosExpe> getProfesores() {
		return profesores;
	}

	public void setProfesores(ArrayList<TProfesorAñosExpe> profesores) {
		this.profesores = profesores;
	}
	
}