package br.ufc.vv.model;


public class Pessoa implements IPessoa{
	private String nome;
	private Double salario;
	private Integer idade;
	private Integer rg;
	private Integer id;
	private String tipo;
	
	public Pessoa(){}
	
	public Pessoa(String nome, Double salario, Integer idade, Integer rg,
			String tipo) {
		super();
		this.nome = nome;
		this.salario = salario;
		this.idade = idade;
		this.rg = rg;
		this.tipo = tipo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public Integer getRg() {
		return rg;
	}
	public void setRg(Integer rg) {
		this.rg = rg;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
