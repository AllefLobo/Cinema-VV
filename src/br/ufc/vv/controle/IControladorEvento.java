package br.ufc.vv.controle;
import java.util.Calendar;
import java.util.List;

import br.ufc.vv.modelo.ICinema;
import br.ufc.vv.modelo.IEvento;


public interface IControladorEvento {

	
	public List<IEvento> buscarEventosPorIntervaloDeTempo(Calendar inicio, Calendar fim);
	public List<IEvento> buscarTodosOsEventos();
}
