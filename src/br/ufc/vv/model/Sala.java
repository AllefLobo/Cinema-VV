package br.ufc.vv.model;

public class Sala implements ISala {

	private int id;
	private int capacidadeMaxima;
	
	public Sala(int capacidadeMaxima){
		this.id = id;
		this.capacidadeMaxima = capacidadeMaxima;
	}	
	

	public int getId(){
		return this.id;
	}
	
	public int getCapacidadeMaxima(){
		return this.capacidadeMaxima;
	}
	
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setCapacidadeMaxima(int capacidadeMaxima){
		this.capacidadeMaxima = capacidadeMaxima;
	}
	
}
