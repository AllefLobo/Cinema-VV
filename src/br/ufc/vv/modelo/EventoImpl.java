package br.ufc.vv.modelo;

import java.util.Calendar;

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

}
