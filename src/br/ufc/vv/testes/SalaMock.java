package br.ufc.vv.tests;

import br.ufc.vv.model.contract.ISala;

public class SalaMock implements ISala {

	private int id;
	private String nome;
	private int capacidade;
	
	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public int capacidade() {
		return capacidade;
	}

	@Override
	public int consultarIdentificador() {
		return id;
	}

	@Override
	public void definirIdentificador(int identificador) {
		this.id = identificador;
	}

}
