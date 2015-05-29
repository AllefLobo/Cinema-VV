package br.ufc.vv.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

// Ja imprimi

public class ProgramacaoImpl implements IProgramacao{

	private ICinema cinema;
	private Calendar diaInicial;
	private List<IEvento> eventos;
	
	public ProgramacaoImpl(ICinema cinema, Calendar diaInicial) {
		this.cinema = cinema;
		this.diaInicial = diaInicial;
		this.init();
	}
	
	public ProgramacaoImpl(ICinema cinema) {
		this.cinema = cinema;
		this.init();
	}
	
	public ProgramacaoImpl() {
		this.init();
	}
	
	private void init(){
		eventos = new ArrayList<IEvento>();
	}
	
	@Override
	public void setCinema(ICinema cinema) {
		this.cinema = cinema;
	}

	@Override
	public ICinema getCinema() {
		return this.cinema;
	}

	@Override
	public void addEvento(IEvento evento) {
		this.eventos.add(evento);
	}

	@Override
	public void addListaDeEvento(List<IEvento> eventos) {
		this.eventos.addAll(eventos);
		
	}

	@Override
	public void removerEvento(IEvento evento) {
		this.eventos.remove(evento);
	}

	@Override
	public void removerEventos(List<IEvento> eventos) {	
		this.eventos.removeAll(eventos);
	}

	@Override
	public Iterator<IEvento> getEventos() {
		return this.eventos.iterator();
	}

	@Override
	public Calendar getDiaInicial() {
		return this.diaInicial;
	}

	@Override
	public void setDiaInicial(Calendar data) {
		this.diaInicial = data;
		
	}

	@Override
	public int getQuantidadeDeEventos() {
		return this.eventos.size();
	}

	@Override
	public String retornaEvento() {
		// TODO Auto-generated method stub
		return null;
	}
}
