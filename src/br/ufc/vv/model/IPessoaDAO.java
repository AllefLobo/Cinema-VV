package br.ufc.vv.model;

import java.util.List;

import br.ufc.vv.exception.ErroDAO;

public interface IPessoaDAO {
	public boolean cadastrar(IPessoa pessoa) throws ErroDAO;
	public boolean remover(IPessoa pessoa) throws ErroDAO;
	public boolean alterar(IPessoa pessoa) throws ErroDAO;
	public List<IPessoa> buscarTodasDeUmFilme(IFilme filme) throws ErroDAO;
	public List<IPessoa> buscarTodas() throws ErroDAO;
	public IPessoa buscarPorId(int id) throws ErroDAO;
	public List<IPessoa> buscarPorNome(IPessoa pessoa, IFilme filme) throws ErroDAO;
}
