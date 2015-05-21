package br.ufc.vv.modelo;

import java.util.List;

public interface ICinema {

	public String getNome();
	
	public void setNome( String novoNome );
	
	public String getEndereco();
	
	public void setEndereco( String novoEndereco );
	
	public List<ISala> getSala();
	
	public void setSala( List<ISala> salas );
	
	public IProgramacao getProgramacao();
	
	public void setProgramacao( IProgramacao programacao );
	
}
