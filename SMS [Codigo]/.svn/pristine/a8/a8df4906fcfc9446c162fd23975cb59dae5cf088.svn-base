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

@Entity
@NamedQueries({
		@NamedQuery(name = "SMSJPA.Integracion.Profesor.ProfesorResidente.findByid", query = "select obj from ProfesorResidente obj where obj.id = :id"),
		@NamedQuery(name = "SMSJPA.Integracion.Profesor.ProfesorResidente.findByDNI", query = "select obj from ProfesorResidente obj where obj.DNI = :DNI") })
public class ProfesorResidente extends profesor implements Serializable {

	private static final long serialVersionUID = 0;
	//@Id
	//private Integer id;
	private int DNI;
	private double sueldoBase;
	private double suplemento;
	
	@Version
	private int version;
	

	public ProfesorResidente() {
	}

	public ProfesorResidente(int id, String nombre, String apellidos,
			int telefono, String email, int activo, String tipo,
			SMSJPA.Negocio.Turno.turno turno, Set<ProfMateria> profMateria , int DNI) {
			

		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.email = email;
		this.activo = activo;
		this.tipo = tipo;
		this.turno = turno;
		this.profMateria = profMateria;
		this.DNI = DNI;
	}

	public double calculaNominaProfesor(){
		
		double sueldo = 0;
		
		sueldo = sueldoBase + suplemento;

		
		return sueldo; 		
	}

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int dNI) {
		DNI = dNI;
	}

	public double getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public double getSuplemento() {
		return suplemento;
	}

	public void setSuplemento(double suplemento) {
		this.suplemento = suplemento;
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
				email, tMaterias, tipo, DNI, sueldoBase, suplemento, -1, -1, -1);
	}

	@Override
	public double getEurosPorHora() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHorasTrabajadas() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setEurosPorHora(double eurosPorHora) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHorasTrabajadas(int horasTrabajadas) {
		// TODO Auto-generated method stub
		
	}





}