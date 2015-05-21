package br.ufc.vv.modelo;

import java.util.List;

public class Cinema implements ICinema {

	private String nome;
	private String endereco;
	private List<ISala> salas;
	private IProgramacao programacao;

	
	public Cinema(String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return nome;
	}

	@Override
	public void setNome(String novoNome) {
		// TODO Auto-generated method stub
		this.nome = novoNome;
	}

	@Override
	public String getEndereco() {
		// TODO Auto-generated method stub
		return endereco;
	}

	@Override
	public void setEndereco(String novoEndereco) {
		// TODO Auto-generated method stub
		this.endereco = novoEndereco;
	}

	@Override
	public List<ISala> getSala() {
		// TODO Auto-generated method stub
		return salas;
	}

	@Override
	public void setSala( List<ISala> salas ) {
		// TODO Auto-generated method stub
		this.salas = salas;
	}

	@Override
	public IProgramacao getProgramacao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProgramacao( IProgramacao programacao ) {
		// TODO Auto-generated method stub
		this.programacao = programacao;
	}
	
}

