/**
 * 
 */
package SMSJPA.Negocio.Profesor;

import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.IdClass;
import javax.persistence.MapsId;
import javax.persistence.NamedQuery;
import SMSJPA.Negocio.Materia.materia;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import SMSJPA.Negocio.Profesor.profesor;


@Entity
//@IdClass(ClavesProfesorMateria.class)
@NamedQueries({
		@NamedQuery(name = "SMSJPA.Integracion.Profesor.ProfMateria.findByid", query = "select obj from ProfMateria obj where obj.id = :id"),
		@NamedQuery(name = "SMSJPA.Integracion.Profesor.ProfMateria.findBymateria", query = "select obj from ProfMateria obj where obj.materia = :materia"),
		@NamedQuery(name = "SMSJPA.Integracion.Profesor.ProfMateria.findByprofesor", query = "select obj from ProfMateria obj where obj.profesor = :profesor"),
		@NamedQuery(name = "SMSJPA.Integracion.Profesor.ProfMateria.findByanos_experiencia", query = "select obj from ProfMateria obj where obj.anos_experiencia = :anos_experiencia") })
public class ProfMateria implements Serializable {

	private static final long serialVersionUID = 0;
	
	@EmbeddedId private ClavesProfesorMateria id;

	@ManyToOne
	@MapsId("idMateria")
	private materia materia;
	
	@ManyToOne
	@MapsId("idProfesor")
	private profesor profesor;

private int anos_experiencia;
	
	
	
	public ProfMateria() {}


	/**
	 * @param profe
	 * @param materia
	 */
	public ProfMateria(profesor profe, materia materia, int añosExpe) {
		this.profesor=profe;
		this.materia=materia;
		this.anos_experiencia=añosExpe;
	}
	
	//Getters and setters.

	public ClavesProfesorMateria getId() {
		return id;
	}
	public void setId(ClavesProfesorMateria id) {
		this.id = id;
	}
	public materia getMateria() {
		return materia;
	}
	public void setMateria(materia materia) {
		this.materia = materia;
	}
	public profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(profesor profesor) {
		this.profesor = profesor;
	}
	public int getAnos_experiencia() {
		return anos_experiencia;
	}
	public void setAnos_experiencia(int anos_experiencia) {
		this.anos_experiencia = anos_experiencia;
	}
	
	
}