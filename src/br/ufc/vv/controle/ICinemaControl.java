package br.ufc.vv.controle;

import br.ufc.vv.modelo.ICinema;
import br.ufc.vv.modelo.IProgramacao;
import br.ufc.vv.modelo.ISala;

public interface ICinemaControl {

	public void criarCinema( String nome, String endereco );
	
	public void atualizarCinema( ICinema cinema );
	
	public ICinema buscarCinema( String nome );
	
	public void excluirCinema( String nome );
	
	public void adicionarProgramacao( IProgramacao programacao, ICinema cinema );
	
	public void removerProgramacao( IProgramacao programacao, ICinema cinemaa );
	
	public IProgramacao buscarProgramacao( ICinema cinema );
	
	public void adicionarSalas( ISala salas, ICinema cinema );
	
	public void removerSalas( ISala salas, ICinema cinema );
	
	public IProgramacao buscarSalas( ISala salas );
		
	
}
