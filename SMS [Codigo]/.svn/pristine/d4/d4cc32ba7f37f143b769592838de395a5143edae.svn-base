package SMSJPA.Negocio.Materia;

import java.util.ArrayList;

import SMSJPA.Negocio.Profesor.TProfesor;
import SMSJPA.Negocio.Profesor.TProfesorAñosExpe;

public class TMateriaAñosExpe extends TMateria {

	private int añosExperiecia;

	public TMateriaAñosExpe() {
		// TODO Apéndice de constructor generado automáticamente
	}

	public TMateriaAñosExpe(int iD) {
		super(iD);
		// TODO Apéndice de constructor generado automáticamente
	}
	public TMateriaAñosExpe(int id_materia, int añosExperiencia){
		super(id_materia);
		this.añosExperiecia = añosExperiencia;
		// TODO Apéndice de constructor generado automáticamente
	}
	
	public TMateriaAñosExpe(TMateria materia, int añosExperiencia){
		super(materia.getID(), materia.getActivo(), materia.getProfesores(), materia.getNombre(), materia.getDescripcion());
		
		this.añosExperiecia = añosExperiencia;
	}

	public TMateriaAñosExpe(int iD, int activo,
			ArrayList<TProfesorAñosExpe> profesores, String nombre, String descripcion, int añosExperiencia) {
		super(iD, activo, profesores, nombre, descripcion);
		this.añosExperiecia = añosExperiencia;
	}
	
	public int getAñosExperiecia() {
		return añosExperiecia;
	}

	public void setAñosExperiecia(int añosExperiecia) {
		this.añosExperiecia = añosExperiecia;
	}
	
	

}
