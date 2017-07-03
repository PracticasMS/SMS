/**
 * 
 */
package SMSJPA.Negocio.Materia;

import javax.persistence.Entity;
import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import SMSJPA.Negocio.Profesor.ProfMateria;
import SMSJPA.Negocio.Profesor.TProfesor;
import SMSJPA.Negocio.Profesor.TProfesorAñosExpe;
import SMSJPA.Negocio.Profesor.profesor;

import javax.persistence.OneToMany;
import javax.persistence.Version;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "SMSJPA.Negocio.Materia.materia.findByid", query = "select obj from materia obj where obj.id = :id"),
		//@NamedQuery(name = "SMSJPA.Negocio.Materia.materia.findByid_profesor", query = "select obj from materia obj where obj.id_profesor = :id_profesor"),
		@NamedQuery(name = "SMSJPA.Negocio.Materia.materia.findBynombre", query = "select obj from materia obj where obj.nombre = :nombre"),
		@NamedQuery(name = "SMSJPA.Negocio.Materia.materia.findBydescripcion", query = "select obj from materia obj where obj.descripcion = :descripcion"),
		@NamedQuery(name = "SMSJPA.Negocio.Materia.materia.findByactivo", query = "select obj from materia obj where obj.activo = :activo"),
		@NamedQuery(name = "SMSJPA.Negocio.Materia.materia.findByprofMateria", query = "select obj from materia obj where obj.profMateria = :profMateria") })
public class materia implements Serializable {


	private static final long serialVersionUID = 0;

@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;


	private String nombre;


	private String descripcion;


	private int activo;


	@OneToMany(mappedBy = "materia")
	private Set<ProfMateria> profMateria;
	
	@Version
	private int version;
	
	
	public materia(){}
	
	public materia(int id, String nombre,
			String descripcion, int activo, Set<ProfMateria> profMateria) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
		this.profMateria = profMateria;
	}
	
	public materia(int id) {
		super();
		this.id = id;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public Set<ProfMateria> getProfMateria() {
		return profMateria;
	}

	public void setProfMateria(Set<ProfMateria> profMateria) {
		this.profMateria = profMateria;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	/* retorna el tMateria correspondiente al objeto del negocio, incluidos los profesores asignados (pero sin sus materas asignadas)
	 * 
	 */
	public TMateriaAñosExpe creaTMateriaAñosExpe() {
		//convertir el array profmaterias a t profesores
		ArrayList<TProfesorAñosExpe> TProfesores = new ArrayList<TProfesorAñosExpe>();
		
		Iterator<ProfMateria> it = this.profMateria.iterator();
		while(it.hasNext()){
			ProfMateria t = it.next();
			TProfesores.add(creaTProfesorExpe(t.getProfesor(), t.getAnos_experiencia()));
		}
		
		return new TMateriaAñosExpe(id, activo, TProfesores, nombre, descripcion, -1);
	}
	
	/* retorna un tProfesor dado un BOProfesor, pero sin las materias asignadas
	 * 
	 */
	private TProfesorAñosExpe creaTProfesorExpe(profesor BOprofesor, int añosExperiencia) {

		return  new TProfesorAñosExpe(BOprofesor.getId(), -1, BOprofesor.getTurno().getId(), BOprofesor.getActivo(),
				BOprofesor.getNombre(), BOprofesor.getApellidos(), BOprofesor.getTelefono(), BOprofesor.getEmail(),null, añosExperiencia);
	}
	
	
	
	
	@Override
	public String toString() {
		return "materia [id=" + id 
				+ ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", activo=" + activo + ", profMateria=" + profMateria + "]";
	}
	
}