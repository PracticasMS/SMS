/**
 * 
 */
package SMSJPA.Negocio.Profesor;

import java.util.ArrayList;

import SMSJPA.Negocio.Materia.TMateria;
import SMSJPA.Negocio.Materia.TMateriaAñosExpe;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class TProfesor {
	
	private int id;
	private String nombre;
	private String apellidos;
	private int telefono;
	private String email;
	private int id_turno;
	private int activo;
	private String tipo;
	private int DNI;	
	private double sueldoBase;
	private double suplementos;
	private int Num_SS;
	private int horasTrabajadas;
	private double eurosPorHora;
	private ArrayList<TMateriaAñosExpe> materias;
	
	public TProfesor() {
		id = 0;
		nombre = "";
		apellidos = "";
		telefono = 0;
		email = "";
		id_turno = 0;
		activo = 1;
		tipo = "";
		DNI = 0;
		Num_SS = 0;
		materias = null;
	}
	public TProfesor(int iD) {
		super();
		id = iD;
	}
	public TProfesor(int id, int id_turno, int activo,
			String nombre, String apellidos, int telefono, String email, int dni,
			int num_ss, ArrayList<TMateriaAñosExpe> materias) {
		
		this.id = id;
		this.id_turno = id_turno;
		this.activo = activo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.email = email;
		this.DNI = dni;
		this.Num_SS = num_ss;
		this.materias = materias;
	}

	public TProfesor(int id, int id_turno, int activo,
			String nombre, String apellidos, int telefono,
			String email, ArrayList<TMateriaAñosExpe> tMaterias) {

		this.id = id;
		this.id_turno = id_turno;
		this.activo = activo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.email = email;
		this.materias = tMaterias;
	}
	
	public TProfesor(int id, int id_turno, int activo,
			String nombre, String apellidos, int telefono,
			String email, ArrayList<TMateriaAñosExpe> tMaterias,
			String tipo, int DNI, int Num_SS) {

		this.id = id;
		this.id_turno = id_turno;
		this.activo = activo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.email = email;
		this.materias = tMaterias;
		
		this.tipo =tipo;
		this.DNI = DNI;
		this.Num_SS = Num_SS;;
	}
	
	public TProfesor(int id, int id_turno, int activo,
			String nombre, String apellidos, int telefono,
			String email, ArrayList<TMateriaAñosExpe> tMaterias,
			String tipo, int DNI, double sueldoBase, double suplementos,
			int Num_SS, double eurosHora, int horasTrabajadas) {

		this.id = id;
		this.id_turno = id_turno;
		this.activo = activo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.email = email;
		this.materias = tMaterias;
		
		this.tipo =tipo;
		this.DNI = DNI;
		this.sueldoBase = sueldoBase;
		this.suplementos = suplementos;
		this.Num_SS = Num_SS;
		this.eurosPorHora = eurosHora;
		this.horasTrabajadas = horasTrabajadas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_turno() {
		return id_turno;
	}

	public void setId_turno(int id_turno) {
		this.id_turno = id_turno;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
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
	public int getDNI() {
		return DNI;
	}

	public void setDNI(int dni) {
		this.DNI = dni;
	}	
	public int getNum_SS() {
		return Num_SS;
	}

	public void setNum_SS(int num_ss) {
		this.Num_SS = num_ss;
	}

	public ArrayList<TMateriaAñosExpe> getMaterias() {
		return materias;
	}

	public void setMaterias(ArrayList<TMateriaAñosExpe> materias) {
		this.materias = materias;
	}
	public void setSueldoBase(double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}
	public double getSueldoBase() {
		return sueldoBase;
	}
	public void setSuplementos(double suplementos) {
		this.suplementos = suplementos;
	}
	public double getSuplementos() {
		return suplementos;
	}
	public void setHorasTrabajadas(int horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}
	public int getHorasTrabajadas() {
		return horasTrabajadas;
	}
	public void setEurosPorHora(double eurosPorHora) {
		this.eurosPorHora = eurosPorHora;
	}
	public double getEurosPorHora() {
		return eurosPorHora;
	}
}