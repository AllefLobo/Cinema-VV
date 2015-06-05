package br.ufc.vv.control;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.ufc.vv.model.EventoImpl;
import br.ufc.vv.model.IEvento;



public class ControladorDeEventosImpl implements IControladorEvento{

	@Override
	public List<IEvento> buscarEventosPorIntervaloDeTempo(
			Calendar inicio, Calendar fim) {
		
		List<IEvento> eventos = new ArrayList<IEvento>();
		
		EventoImpl evento = new EventoImpl();
		
		eventos.add(evento);
		
		return eventos;
	}

	@Override
	public List<IEvento> buscarTodosOsEventos() {
		// TODO Auto-generated method stub
		List<IEvento> eventos = new ArrayList<IEvento>();
		
		EventoImpl evento = new EventoImpl();
		
		eventos.add(evento);
		
		return eventos;
	}

}
