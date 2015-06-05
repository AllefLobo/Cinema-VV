package br.ufc.vv.control;
import java.util.Calendar;
import java.util.List;

import br.ufc.vv.model.IEvento;


public interface IControladorEvento {

	
	public List<IEvento> buscarEventosPorIntervaloDeTempo(Calendar inicio, Calendar fim);
	public List<IEvento> buscarTodosOsEventos();
}
