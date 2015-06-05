package br.ufc.vv.tests;

import java.util.List;
import junit.framework.TestCase;
import org.junit.Test;
import br.ufc.vv.model.Filme;
import br.ufc.vv.model.Pessoa;
import br.ufc.vv.model.PessoaDAO;
import br.ufc.vv.model.contract.IFilme;
import br.ufc.vv.model.contract.IPessoa;
import br.ufc.vv.model.excecoes.ErroDAO;

public class PessoaDAOTest extends TestCase{
	
	@Test
	public void testeParaVerificarSeAPessoaEstaSendoCadastradoCorretamente() throws ErroDAO{
		PessoaDAO p = new PessoaDAO();
		Pessoa a = new Pessoa();
		a.setNome("nome");
		a.setIdade(20);
		a.setRg(123456);
		a.setSalario(120.0);
		a.setTipo("Ator");
		assertEquals(true, p.cadastrar(a));
	}
	
	@Test
	public void testeParaVerificarSeAPessoaEstaSendoRemovidaCorretamente() throws ErroDAO{
		PessoaDAO dao = new PessoaDAO();
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("nome");
		pessoa.setId(1);
		pessoa.setIdade(20);
		pessoa.setRg(123456);
		pessoa.setSalario(120.0);
		pessoa.setTipo("Ator");
		assertEquals(true, dao.remover(pessoa));
	}
	@Test
	public void testeBuscarUmaPessoaPorID() throws ErroDAO{
		PessoaDAO dao = new PessoaDAO();
		assertNotNull(dao.buscarPorId(3));
	}
	
	@Test
	public void testeVerificarTodasAsPessoasDeUmFilmeCom3PessoasAdicionadasParaOFilmeSTUBComId1() throws ErroDAO{
		IFilme filme = new Filme();
		PessoaDAO pDAO = new PessoaDAO();
		
		List<IPessoa> listPessoa = pDAO.buscarTodasDeUmFilme(filme);
		
		assertEquals(3, listPessoa.size());
		assertEquals(true, 
				(3 == listPessoa.get(0).getId().intValue() || 4 == listPessoa.get(0).getId().intValue()) || 5 == listPessoa.get(0).getId().intValue());
		assertEquals(true, 
				(3 == listPessoa.get(1).getId().intValue() || 4 == listPessoa.get(1).getId().intValue()) || 5 == listPessoa.get(1).getId().intValue());
		assertEquals(true, 
				(3 == listPessoa.get(2).getId().intValue() || 4 == listPessoa.get(2).getId().intValue()) || 5 == listPessoa.get(2).getId().intValue());
	}
	
	@Test
	public void testeParaVerificarSeAPessoaEstaSendoAlteradas() throws ErroDAO{
		PessoaDAO dao = new PessoaDAO();
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Joao");
		pessoa.setIdade(28);
		pessoa.setRg(1234567);
		pessoa.setSalario(100.0);
		pessoa.setTipo("Ator");
		pessoa.setId(3);
		
		dao.alterar(pessoa);
		
		Pessoa p = dao.buscarPorId(pessoa.getId());
		
		assertEquals("Joao", p.getNome());
		assertEquals("Ator", p.getTipo());
		assertEquals(28, p.getIdade().intValue());
		assertEquals(3, p.getId().intValue());
		assertEquals(1234567,p.getRg().intValue());
		assertEquals(100.0, p.getSalario());
		
	}
	
	@Test
	public void testeParaBuscarPessoaPorNomeCom5PessoasAdicionadasNoBanco() throws ErroDAO{
		PessoaDAO pDAO = new PessoaDAO();
		IFilme filme = new Filme();
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("nome");
		List<IPessoa> listPessoa = pDAO.buscarPorNome(pessoa, filme); 
		assertEquals(5, listPessoa.size());
		assertEquals(true, 
				(6 == listPessoa.get(0).getId().intValue() || 7 == listPessoa.get(0).getId().intValue()) || 8 == listPessoa.get(0).getId().intValue()
						|| 9 == listPessoa.get(0).getId().intValue() || 10 == listPessoa.get(0).getId().intValue());
		assertEquals(true, 
				(6 == listPessoa.get(1).getId().intValue() || 7 == listPessoa.get(1).getId().intValue()) || 8 == listPessoa.get(1).getId().intValue()
						|| 9 == listPessoa.get(1).getId().intValue() || 10 == listPessoa.get(1).getId().intValue());
		assertEquals(true, 
				(6 == listPessoa.get(2).getId().intValue() || 7 == listPessoa.get(2).getId().intValue()) || 8 == listPessoa.get(2).getId().intValue()
						|| 9 == listPessoa.get(2).getId().intValue() || 10 == listPessoa.get(2).getId().intValue());
		assertEquals(true, 
				(6 == listPessoa.get(3).getId().intValue() || 7 == listPessoa.get(3).getId().intValue()) || 8 == listPessoa.get(3).getId().intValue()
						|| 9 == listPessoa.get(3).getId().intValue() || 10 == listPessoa.get(3).getId().intValue());
		assertEquals(true, 
				(6 == listPessoa.get(4).getId().intValue() || 7 == listPessoa.get(4).getId().intValue()) || 8 == listPessoa.get(4).getId().intValue()
				|| 9 == listPessoa.get(4).getId().intValue() || 10 == listPessoa.get(4).getId().intValue());
		
	}
}
