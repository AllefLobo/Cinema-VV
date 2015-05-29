package br.ufc.vv.visao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.jmock.Mockery;

import br.ufc.vv.controle.IControladorEvento;
import br.ufc.vv.modelo.ICinema;
import br.ufc.vv.modelo.IEvento;

public class ControladorDeEventosImpl implements IControladorEvento{

	@Override
	public List<IEvento> buscarEventosPorIntervaloDeTempo(ICinema cinema,
			Calendar inicio, Calendar fim) {
		
		List<IEvento> eventos = new ArrayList<IEvento>();
		
		EventoImpl evento = new EventoImpl();
		
		eventos.add(evento);
		
		return eventos;
	}

	@Override
	public List<IEvento> buscarTodosOsEventos(ICinema cinema) {
		// TODO Auto-generated method stub
		List<IEvento> eventos = new ArrayList<IEvento>();
		
		EventoImpl evento = new EventoImpl();
		
		eventos.add(evento);
		
		return eventos;
	}

}
