/**
 * 
 */
package SMSJPA.Negocio.Profesor;

import javax.persistence.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import SMSJPA.Negocio.Materia.TMateriaAñosExpe;
import SMSJPA.Negocio.Materia.materia;
import SMSJPA.Negocio.Profesor.profesor;

import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Version;
import javax.persistence.NamedQueries;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "SMSJPA.Integracion.Profesor.ProfesorAuxiliar.findByid", query = "select obj from ProfesorAuxiliar obj where obj.id = :id"),
		@NamedQuery(name = "SMSJPA.Integracion.Profesor.ProfesorAuxiliar.findByNum_SS", query = "select obj from ProfesorAuxiliar obj where obj.Num_SS = :Num_SS") })
public class ProfesorAuxiliar extends profesor implements Serializable {

	
	private static final long serialVersionUID = 0;
//	@Id
//	private Integer id;
	private int Num_SS;
	private double eurosPorHora;
	private int horasTrabajadas;
	@Version
	private int version;

	
	public ProfesorAuxiliar() { }


	public ProfesorAuxiliar(int id, String nombre, String apellidos,
			int telefono, String email, int activo, String tipo,
			SMSJPA.Negocio.Turno.turno turno, Set<ProfMateria> profMateria , int SS) {
			

		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.email = email;
		this.activo = activo;
		this.tipo = tipo;
		this.turno = turno;
		this.profMateria = profMateria;
		this.setNum_SS(SS);
	}
	
	


	public int getNum_SS() {
		return Num_SS;
	}

	
	public void setNum_SS(int num_SS) {
		Num_SS = num_SS;
	}

	public double calculaNominaProfesor(){
		
		double sueldo = 0;
		
		sueldo = eurosPorHora * horasTrabajadas;

		
		return sueldo; 		
	}


	public double getEurosPorHora() {
		return eurosPorHora;
	}


	public void setEurosPorHora(double eurosPorHora) {
		this.eurosPorHora = eurosPorHora;
	}


	public int getHorasTrabajadas() {
		return horasTrabajadas;
	}


	public void setHorasTrabajadas(int horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}
	public TProfesor creaTProfesor() {
		//convertir el array profmaterias a TMaterias
		ArrayList<TMateriaAñosExpe> tMaterias = new ArrayList<TMateriaAñosExpe>();
		
		ArrayList<materia> misMaterias = null;
		Iterator<ProfMateria> it = this.profMateria.iterator();
		while(it.hasNext()){
			ProfMateria t = it.next();
			tMaterias.add(super.creaTMateriaExpe(t.getMateria(), t.getAnos_experiencia()));
			
		}
		
		
		return new TProfesor(id, turno.getId(), activo,	nombre, apellidos, telefono,
				email, tMaterias, tipo, -1, -1, -1, Num_SS, eurosPorHora, horasTrabajadas);
	}


	@Override
	public double getSueldoBase() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public double getSuplemento() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void setSueldoBase(double salariobase) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setSuplemento(double suplemento) {
		// TODO Auto-generated method stub
		
	}


	



}