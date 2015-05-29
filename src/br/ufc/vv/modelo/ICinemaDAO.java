package br.ufc.vv.modelo;

public interface ICinemaDAO {

	public void cadastrar( ICinema cinema );
	
	public void atualizar( ICinema antigoCinema, ICinema novoCinema );
	
	public ICinema buscar( );
	
	public void excluir( ICinema cinema );
	
	
	public String buscaProgramacao( );

}
