package br.ufc.vv.modelo;

import br.ufc.vv.modelo.Cinema;

public interface ISala {
	
	public int getId();
	
	public int getCapacidadeMaxima();
	
	public void setId(int id);
	
	public void setCapacidadeMaxima(int capacidadeMaxima);
		
}

