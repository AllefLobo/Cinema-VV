package br.ufc.vv.control;

import java.util.List;

import br.ufc.vv.model.Sala;

public interface IControladorSala {
	
	public void inserirSala(int capacidadeMaxima);
	
	public void apagarSala(int idSala);
	
	public List<Sala> listarSala();
}
