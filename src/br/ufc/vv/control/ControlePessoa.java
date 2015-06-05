package br.ufc.vv.control;

import java.util.List;

import br.ufc.vv.exception.ErroParametros;
import br.ufc.vv.model.IFilme;

public class ControlePessoa implements IControlePessoa{
	private IPessoaDAO pessoaDAO;
	
	public ControlePessoa() {
		pessoaDAO = new PessoaDAO();
	}
	
	@Override
	public void cadastrarPessoa(IPessoa pessoa) throws ErroDAO, ErroParametros {
		if(pessoa!=null && (pessoa.getNome()!=null && pessoa.getIdade()!=null && pessoa.getRg()!=null && pessoa.getSalario()!=null && pessoa.getTipo()!=null))
			pessoaDAO.cadastrar(pessoa);
		else
			throw new ErroParametros();
	}

	@Override
	public void removerPessoa(IPessoa pessoa) throws ErroParametros, ErroDAO {
		if(pessoa!=null && (pessoa.getId()!=null))
			pessoaDAO.remover(pessoa);
		else
			throw new ErroParametros();
	}

	@Override
	public void alterarPessoa(IPessoa pessoa) throws ErroDAO, ErroParametros {
		if(pessoa!=null && (pessoa.getId()!=null && pessoa.getNome()!=null && pessoa.getIdade()!=null && pessoa.getRg()!=null && pessoa.getSalario()!=null && pessoa.getTipo()!=null))
			pessoaDAO.alterar(pessoa);
		else
			throw new ErroParametros();
	}

	@Override
	public List<IPessoa> buscarTodasPessoasDeUmFilme(IFilme filme) throws ErroDAO, ErroParametros{
		if(filme != null && filme.getId()!=null)
			return pessoaDAO.buscarTodasDeUmFilme(filme);
		else
			throw new ErroParametros();
	}

	@Override
	public IPessoa buscarPessoaPorId(Integer id) throws ErroDAO, ErroParametros{
		if(id!=null)
			return pessoaDAO.buscarPorId(id);
		else
			throw new ErroParametros();
			
	}

	@Override
	public List<IPessoa> buscarPessoaPorNome(IPessoa pessoa, IFilme filme) throws ErroDAO, ErroParametros{
		if(pessoa!=null && pessoa.getNome()!=null && filme!=null && filme.getId()!=null)
			return pessoaDAO.buscarPorNome(pessoa, filme);
		else
			throw new ErroParametros();
	}

	@Override
	public List<IPessoa> buscarTodasPessoas() throws ErroDAO {
		return pessoaDAO.buscarTodas();
	}

}
