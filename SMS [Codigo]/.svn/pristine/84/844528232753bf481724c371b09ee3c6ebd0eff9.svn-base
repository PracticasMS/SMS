package SMSDAO.Presentacion.Comandos.Matricula;

import SMSDAO.Negocio.Curso.SACurso;
import SMSDAO.Negocio.Curso.TCurso;
import SMSDAO.Negocio.ExcepcionNegocio.ExcepcionNegocio;
import SMSDAO.Negocio.FactoriaSA.FactoriaSA;
import SMSDAO.Negocio.Matricula.TCursoNivel;
import SMSDAO.Presentacion.Comandos.Comando;
import SMSDAO.Presentacion.Controlador.Contexto;
import SMSDAO.Presentacion.JPrincipal.EventoGUI;

public class ComandoAñadirCursoAMatricula implements Comando {

	@Override
	public Contexto execute(Object datos) {

		TCursoNivel cursoNivel = (TCursoNivel) datos;
		TCurso tCurso = new TCurso(cursoNivel.getId_Curso(), cursoNivel.getNombre(), 1);

		Contexto contx = null;
		
		SACurso miSACurso = FactoriaSA.getInstance().creaSACurso();
		
		try {
			
			tCurso = miSACurso.mostrarCurso(tCurso);

			//rellenar el contexto
			if(tCurso == null){
				contx = new Contexto(EventoGUI.BUSCAR_CURSO_ERROR, null);
			}else{

				
				TCursoNivel tCursoNivel = new TCursoNivel (tCurso.getId_Curso(), tCurso.getNombre(), cursoNivel.getNivel());
				
				contx = new Contexto(EventoGUI.BUSCAR_CURSO_PARA_AÑADIR_A_MATRICULA, tCursoNivel);

			}
		}catch (ExcepcionNegocio e) {
			contx = new Contexto(EventoGUI.BUSCAR_CURSO_ERROR, null);
		}
			
		return contx;
	}

}
