/**
 * 
 */
package SMSJPA.Negocio.Turno;



/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class TTurno {
	
	private Integer ID;
	private int hora_inicio;
	private int hora_fin;
	private String observaciones;
	
	//===================================
	//===========CONSTRUCTORES===========
	//===================================
	
	public TTurno() {
		super();
		ID=0;
		observaciones="";
	}
	
	public TTurno(int id) {
		super();
		ID=id;
		observaciones="";
	}
	
	public TTurno(int iD, int hora_inicio, int hora_fin,
			String observaciones) {
		super();
		ID = iD;
		this.hora_inicio = hora_inicio;
		this.hora_fin = hora_fin;
		this.observaciones = observaciones;
	}

	
	//===================================
	//==========GETTERS & SETTERS========
	//===================================
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(int hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public int getHora_fin() {
		return hora_fin;
	}

	public void setHora_fin(int hora_fin) {
		this.hora_fin = hora_fin;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	
	//===================================
	
	@Override
	public String toString() {
		return "TTurno [ID=" + ID + ", hora_inicio=" + hora_inicio
				+ ", hora_fin=" + hora_fin + ", observaciones=" + observaciones
				+ "]";
	}
}