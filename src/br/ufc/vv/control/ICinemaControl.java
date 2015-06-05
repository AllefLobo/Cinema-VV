package br.ufc.vv.control;

import java.util.List;

import br.ufc.vv.model.ICinema;
import br.ufc.vv.model.ISala;
import br.ufc.vv.model.Sala;

public interface ICinemaControl {

	public void criarCinema( String nome, String endereco );
	
	public void atualizarCinema( ICinema novoCinema );
	
	public ICinema buscarCinema( );
	
	public void excluirCinema( );
	
	public void mostrarProgramacao(  );
	
	public void adicionarSalas( int capacidadeMaxima);
	
	public void removerSalas( ISala salas );
	
	public List<Sala> buscarSalas(  );
		
	
}
