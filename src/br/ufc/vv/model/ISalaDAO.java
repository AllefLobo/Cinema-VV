package br.ufc.vv.model;

import java.util.List;

public interface ISalaDAO {
	
	public boolean adicionarSala(Sala sala);
	
	public boolean removerSala(int id);
	
	public List<Sala> buscarSalas();
}
