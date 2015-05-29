package br.ufc.vv.controle;

import java.util.List;

import br.ufc.vv.modelo.Sala;

public interface IControladorSala {
	
	public void inserirSala(int capacidadeMaxima);
	
	public void apagarSala(int idSala);
	
	public List<Sala> listarSala();
}
