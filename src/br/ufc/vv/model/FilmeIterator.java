package br.ufc.vv.model;

import java.util.Iterator;
import java.util.List;

public class FilmeIterator implements Iterator<IFilme>{

private List<IFilme> filmes; 
	
	private int iterator;
	
	public FilmeIterator(List<IFilme> filmes) {
		this.filmes = filmes;
		iterator = 0;
	}
	
	@Override
	public boolean hasNext() {
		if(iterator < filmes.size())
			return true;
		else 
			return false;
	}

	@Override
	public IFilme next() {
		return filmes.get(iterator++);
	}

	@Override
	public void remove() {
		this.filmes.remove(iterator);
	}
	
	
}
