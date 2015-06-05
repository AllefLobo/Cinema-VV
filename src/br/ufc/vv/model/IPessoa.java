package br.ufc.vv.model;

public interface IPessoa {
	public String getTipo();

	public void setTipo(String tipo);
	
	public String getNome(); //nome

	public void setNome(String nome);

	public Double getSalario(); //salario

	public void setSalario(Double salario);

	public Integer getIdade(); //idade
	
	public void setIdade(Integer idade);
	
	public Integer getRg(); //Rg
	
	public void setRg(Integer rg);
	
	public Integer getId();
	
	public void setId(Integer id);
}
