/**
 * 
 */
package SMSJPA.Negocio.Turno;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class turno {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;
	private Time HoraInicio;
	private Time HoraFin;
	private String observaciones;
	private int activo;
	
	@Version
	private int version;
	
	
	public turno() {}

	public turno(int id) {
		super();
		this.ID = id;
		this.observaciones = "";
		this.activo = 0;
	}
	
	public turno(int id, Time horaInicio, Time horaFin, String observaciones, int activo) {
		super();
		this.ID = id;
		HoraInicio = horaInicio;
		HoraFin = horaFin;
		this.observaciones = observaciones;
		this.activo = activo;
	}

	public int getId() {
		return ID;
	}

	public void setId(int id) {
		this.ID = id;
	}

	public Time getHoraInicio() {
		return HoraInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		HoraInicio = horaInicio;
	}

	public Time getHoraFin() {
		return HoraFin;
	}

	public void setHoraFin(Time horaFin) {
		HoraFin = horaFin;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "turno [ID=" + ID + ", HoraInicio=" + HoraInicio + ", HoraFin="
				+ HoraFin + ", observaciones=" + observaciones + ", activo="
				+ activo + "]";
	}

		
}