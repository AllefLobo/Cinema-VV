package br.ufc.vv.controle;

import java.util.List;

import br.ufc.vv.modelo.ICinema;
import br.ufc.vv.modelo.IProgramacao;
import br.ufc.vv.modelo.ISala;

public interface ICinemaControl {

	public void criarCinema( String nome, String endereco );
	
	public void atualizarCinema( ICinema novoCinema );
	
	public ICinema buscarCinema( );
	
	public void excluirCinema( );
	
	public void adicionarProgramacao( IProgramacao programacao );
	
	public void removerProgramacao( IProgramacao programacao );
	
	public String buscarProgramacao(  );
	
	public void adicionarSalas( ISala salas);
	
	public void removerSalas( ISala salas );
	
	public int buscarSalas(  );
		
	
}
