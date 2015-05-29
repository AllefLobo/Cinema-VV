package br.ufc.vv.modelo;
import java.util.Calendar;


public interface IEvento {

	public int getId();
	public void setId(int id);
	public IFilme getFilme();
	public void setFilme(IFilme filme);
	public Calendar getDataInicial();
	public void setDataInicial(Calendar dataInicial);
	public ISala getSala();
	public void setSala(ISala sala);
	
}
