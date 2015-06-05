package br.ufc.vv.model;

import java.util.Calendar;
import java.util.Date;

public class EventoImpl implements IEvento {

	private int id;
	private IFilme filme;
	private Calendar dataInicial;
	private ISala sala;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public IFilme getFilme() {
		return filme;
	}

	public void setFilme(IFilme filme) {
		this.filme = filme;
	}

	public Calendar getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Calendar dataInicial) {
		this.dataInicial = dataInicial;
	}

	public ISala getSala() {
		return sala;
	}

	public void setSala(ISala sala) {
		this.sala = sala;
	}

	@Override
	public String toString() {
		return id + "Filme 1" + dataInicial;
	}

	@Override
	public Date consultarDataDeInicioDoEvento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date consultarDataDeTerminoDoEvento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double consultarValorDaEntradaNoEvento() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IFilme consultarFilmeDoEvento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ICinema consultarCinemaDoEvento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ISala consultarSalaDoEvento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void definirCinemaDoEvento(ICinema cinema) {
		// TODO Auto-generated method stub

	}

	@Override
	public void definirFilmeDoEvento(IFilme filme) {
		// TODO Auto-generated method stub

	}

	@Override
	public void definirSalaDoEvento(ISala sala) {
		// TODO Auto-generated method stub

	}

	@Override
	public void definirDataDeInicioDoEvento(Date dataInicio) {
		// TODO Auto-generated method stub

	}

	@Override
	public void definirDataDeTerminoDoEvento(Date dataTermino) {
		// TODO Auto-generated method stub

	}

}
