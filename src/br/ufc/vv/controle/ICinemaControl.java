package br.ufc.vv.controle;

import java.util.List;

import br.ufc.vv.modelo.ICinema;
import br.ufc.vv.modelo.IProgramacao;
import br.ufc.vv.modelo.ISala;
import br.ufc.vv.modelo.Sala;

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
