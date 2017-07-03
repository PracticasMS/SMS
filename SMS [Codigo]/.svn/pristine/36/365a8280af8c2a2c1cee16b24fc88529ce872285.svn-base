package SMSJPA.Presentacion.Comandos.Profesor;

import SMSDAO.Negocio.Curso.TCurso;
import SMSDAO.Negocio.Matricula.TCursoNivel;
import SMSJPA.Negocio.ExcepcionNegocio.ExcepcionNegocio;
import SMSJPA.Negocio.FactoriaSA.FactoriaSA;
import SMSJPA.Negocio.Materia.SAMateria;
import SMSJPA.Negocio.Materia.TMateria;
import SMSJPA.Negocio.Materia.TMateriaAñosExpe;
import SMSJPA.Negocio.Profesor.SAProfesor;
import SMSJPA.Negocio.Profesor.TProfesor;
import SMSJPA.Presentacion.Comandos.Comando;
import SMSJPA.Presentacion.Controlador.Contexto;
import SMSJPA.Presentacion.Controlador.EventoGUI;

public class ComandoBuscarMateriaParaProfesor implements Comando {

	@Override
	public Contexto execute(Object datos) {
		Contexto contex = null;
		
		SAMateria miSAMateria = FactoriaSA.getInstance().crearSAMateria();
		
		try{
			TMateriaAñosExpe MatAñosExpe = (TMateriaAñosExpe) datos;
			TMateria miMateria = miSAMateria.buscarMateria(MatAñosExpe);
			
			
			
			
			if(miMateria == null){
				contex = new Contexto(EventoGUI.BUSCAR_MATERIA_ERROR, null);
			}else{
				MatAñosExpe = new TMateriaAñosExpe(miMateria, MatAñosExpe.getAñosExperiecia());
				contex = new Contexto(EventoGUI.BUSCAR_MATERIA_PARA_AÑADIR_A_PROFESOR, MatAñosExpe);
			}
		}
		catch(ExcepcionNegocio e) {
			contex = new Contexto(EventoGUI.BUSCAR_MATERIA_ERROR, null);
		}
		
		return contex;
	}

}
