/**
 * 
 */
package SMSJPA.Negocio.Profesor;
import javax.annotation.Resource;


import javax.persistence.Entity;
import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;

import SMSJPA.Negocio.Materia.TMateria;
import SMSJPA.Negocio.Materia.TMateriaAñosExpe;
import SMSJPA.Negocio.Materia.materia;
import SMSJPA.Negocio.Turno.turno;
import javax.persistence.ManyToOne;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import org.eclipse.persistence.annotations.ReturnInsert;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQueries({
		@NamedQuery(name = "SMSJPA.Negocio.Profesor.profesor.findByid", query = "select obj from profesor obj where obj.id = :id"),
		@NamedQuery(name = "SMSJPA.Negocio.Profesor.profesor.findBynombre", query = "select obj from profesor obj where obj.nombre = :nombre"),
		@NamedQuery(name = "SMSJPA.Negocio.Profesor.profesor.findByapellidos", query = "select obj from profesor obj where obj.apellidos = :apellidos"),
		@NamedQuery(name = "SMSJPA.Negocio.Profesor.profesor.findBytelefono", query = "select obj from profesor obj where obj.telefono = :telefono"),
		@NamedQuery(name = "SMSJPA.Negocio.Profesor.profesor.findByemail", query = "select obj from profesor obj where obj.email = :email"),
		@NamedQuery(name = "SMSJPA.Negocio.Profesor.profesor.findByactivo", query = "select obj from profesor obj where obj.activo = :activo"),
		@NamedQuery(name = "SMSJPA.Negocio.Profesor.profesor.findByturno", query = "select obj from profesor obj where obj.turno = :turno"),
		@NamedQuery(name = "SMSJPA.Negocio.Profesor.profesor.findByprofMateria", query = "select obj from profesor obj where obj.profMateria = :profMateria"),
		@NamedQuery(name = "SMSJPA.Negocio.Profesor.profesor.findByTurnoYActivo", query = "select obj from profesor obj where obj.turno = :turno") })

public abstract class profesor implements Serializable {

	private static final long serialVersionUID = 0;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;

	protected String nombre;

	protected String apellidos;

	protected int telefono;

	protected String email;

	protected String tipo;
	
	protected int activo;

	@ManyToOne
	protected turno turno;

	@OneToMany(mappedBy = "profesor")
	protected Set<ProfMateria> profMateria;
	
	@Version
	private int version;


	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	protected void calcularSueldoProfesor() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public turno getTurno() {
		return turno;
	}

	public void setTurno(turno turno) {
		this.turno = turno;
	}
	
	public Set<ProfMateria> getProfMateria() {
		return profMateria;
	}

	public void setProfMateria(Set<ProfMateria> profMateria) {
		this.profMateria = profMateria;
	}
	
	public abstract double getSueldoBase();
	public abstract double getSuplemento();
	public abstract double getEurosPorHora();
	public abstract int getHorasTrabajadas();
	
	public abstract void setSueldoBase(double salariobase);
	public abstract void setSuplemento(double suplemento);
	public abstract void setEurosPorHora(double eurosPorHora);
	public abstract void setHorasTrabajadas(int horasTrabajadas);
	
	
	
	
	/*  Retorna un transfer TProfesor con sus TMateias, pero no con los profesores asignados a dichas materias
	 * 
	 * Retorna El TProfesor correspondiente
	 */ 
	abstract public TProfesor creaTProfesor();

	
	/* dado una BO Materia retorna un transfer TMateria sin los profesores asiganados
	 * 
	 * Retorna un tmateria sin sus pofesores asignados
	 */ 
	protected TMateriaAñosExpe creaTMateriaExpe(materia materia, int añosExperiencia) {
		return new TMateriaAñosExpe(materia.getId(), materia.getActivo(), null, materia.getNombre(), materia.getDescripcion(), añosExperiencia);
	}
	
	abstract public double calculaNominaProfesor();
	
	/*
	public double calculaNominaProfesor(){
		double eurosPorHora = 10;
		int horas = 0;
		if(this.turno != null){
			horas = this.turno.getHoraFin().getHours() - this.turno.getHoraInicio().getHours();
		}	
		return eurosPorHora * horas * 30;
	}*/
	
}