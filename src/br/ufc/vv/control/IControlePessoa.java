package br.ufc.vv.control;

import java.util.List;

import br.ufc.vv.exception.ErroParametros;
import br.ufc.vv.model.IFilme;

public interface IControlePessoa {
	public void cadastrarPessoa(IPessoa pessoa) throws ErroDAO, ErroParametros;
	public void removerPessoa(IPessoa pessoa) throws ErroDAO, ErroParametros;
	public void alterarPessoa(IPessoa pessoa) throws ErroDAO, ErroParametros;
	public List<IPessoa> buscarTodasPessoasDeUmFilme(IFilme filme) throws ErroDAO, ErroParametros;
	public List<IPessoa> buscarTodasPessoas() throws ErroDAO;
	public IPessoa buscarPessoaPorId(Integer id) throws ErroDAO, ErroParametros;
	public List<IPessoa> buscarPessoaPorNome(IPessoa pessoa, IFilme filme) throws ErroDAO, ErroParametros;
}
