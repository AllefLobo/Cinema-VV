package br.ufc.vv.modelo;

public interface ICinemaDAO {

	public void cadastrar( ICinema cinema );
	
	public void atualizar( ICinema antigoCinema, ICinema novoCinema );
	
	public ICinema buscar( );
	
	public void excluir( ICinema cinema );
	
	public void adicionarProgramacao( String evento );
	
	public void removerProgramacao( String evento );
	
	public String buscaProgramacao( );
	
	public void adicionarSala( ISala sala );
	
	public void removerSala( ISala sala );
	
	public int buscaSala(  );
	
}
