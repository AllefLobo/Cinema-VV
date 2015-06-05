package br.ufc.vv.model;

import java.util.Date;

public class Evento implements IEvento {

	private Date dataInicio;
	private Date dataTermino;
	private ICinema cinema;
	private ISala sala;
	private IFilme filme;

	@Override
	public Date consultarDataDeInicioDoEvento() {
		return dataInicio;
	}

	@Override
	public Date consultarDataDeTerminoDoEvento() {
		return dataTermino;
	}

	@Override
	public double consultarValorDaEntradaNoEvento() {
		return  1; //cinema.getValorIngresso();
	}

	@Override
	public IFilme consultarFilmeDoEvento() {
		return filme;
	}

	@Override
	public ICinema consultarCinemaDoEvento() {
		return cinema;
	}

	@Override
	public ISala consultarSalaDoEvento() {
		return sala;
	}

	@Override
	public void definirCinemaDoEvento(ICinema cinema) {
		this.cinema = cinema;
	}

	@Override
	public void definirFilmeDoEvento(IFilme filme) {
		this.filme = filme;
	}

	@Override
	public void definirSalaDoEvento(ISala sala) {
		this.sala = sala;
	}

	@Override
	public void definirDataDeInicioDoEvento(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	@Override
	public void definirDataDeTerminoDoEvento(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

}
