package br.ufc.vv.modelo;

public interface ICinemaDAO {

	public void cadastrar( ICinema cinema );
	
	public void atualizar( ICinema cinema );
	
	public ICinema buscar( ICinema cinema );
	
	public void excluir( ICinema cinema );
	
}
