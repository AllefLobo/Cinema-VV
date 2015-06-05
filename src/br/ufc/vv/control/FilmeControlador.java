package br.ufc.vv.control;

import java.util.Iterator;

import br.ufc.vv.control.contract.IFilmeController;
import br.ufc.vv.control.excecoes.ErroParametros;
import br.ufc.vv.model.Filme;
import br.ufc.vv.model.FilmeDAO;
import br.ufc.vv.model.connection.excecoes.ErroNaConexao;
import br.ufc.vv.model.contract.IFilme;
import br.ufc.vv.model.contract.IFilmeDAO;
import br.ufc.vv.model.contract.IPessoa;
import br.ufc.vv.model.excecoes.ErroDAO;

public class FilmeControlador implements IFilmeController{
	
	private ControlePessoa controlePessoa;
	
	public FilmeControlador() {
		controlePessoa = new ControlePessoa();
	}
	
	@Override
	public void criarFilme(String titulo, String sinopse, String genero,
			String anoFilmagem, String anoLancamento, String estudioDeFilmagem) throws ErroNaConexao {
		
		IFilme filme = new Filme();
		filme.setTitulo(titulo);
		filme.setSinopse(sinopse);
		filme.setGenero(genero);
		filme.setAnoFilmagem(anoFilmagem);
		filme.setAnoLancamento(anoLancamento);
		filme.setEstudioDeFilmagem(estudioDeFilmagem);
		
		IFilmeDAO filmeDAO = new FilmeDAO();
		filmeDAO.salvar(filme);
	}

	@Override
	public void editarFilme(int id,String titulo, String sinopse, String genero,
			String anoFilmagem, String anoLancamento, String estudioFilmagem) throws ErroDAO, ErroNaConexao {
		
		IFilme filme = new Filme();
		filme.setId(id);
		filme.setTitulo(titulo);
		filme.setSinopse(sinopse);
		filme.setGenero(genero);
		filme.setAnoFilmagem(anoFilmagem);
		filme.setAnoLancamento(anoLancamento);
		filme.setEstudioDeFilmagem(estudioFilmagem);
		
		IFilmeDAO filmeDAO = new FilmeDAO();
		filmeDAO.editar(filme);
		
	}
	
	
	
	@Override
	public void removerFilme(int idFilme) throws ErroDAO, ErroNaConexao {
		IFilmeDAO filmeDAO = new FilmeDAO();
		filmeDAO.remover(idFilme);
	}

	@Override
	public IFilme buscarFilmePorId(int id) throws ErroNaConexao {
		IFilmeDAO filmeDAO = new FilmeDAO();
		Iterator<IFilme> filmes = filmeDAO.listar();
		
		while(filmes.hasNext()){
			IFilme aux = filmes.next();
			if(aux.getId() == id)
				return aux;
		}
		
		return null;
	}

	@Override
	public IFilme buscarFilmePorTitulo(String titulo) throws ErroNaConexao {
		IFilmeDAO filmeDAO = new FilmeDAO();
		Iterator<IFilme> filmesListados = filmeDAO.listar();
		
		while(filmesListados.hasNext()){
			IFilme aux = filmesListados.next();
			if(aux.getTitulo().equals(titulo))
				return aux;
		}
		return null;
	}

	@Override
	public Iterator<IFilme> listarFilmes() throws ErroNaConexao {
		IFilmeDAO filmeDAO = new FilmeDAO();
		Iterator<IFilme> filmes = filmeDAO.listar();
		return filmes;
	}

	@Override
	public void addAtoresDoFilme(int idFilme, Iterator<IPessoa> atores) throws ErroNaConexao, ErroDAO, ErroParametros {
		IFilmeDAO filmeDAO = new FilmeDAO();
		filmeDAO.addAtoresDoFilme(idFilme, atores);
	}

	@Override
	public Iterator<IPessoa> getAtoresDoFilme(int idFilme) throws ErroNaConexao, ErroDAO, ErroParametros {
		IFilme filme = new Filme();
		filme.setId(idFilme);
			return controlePessoa.buscarTodasPessoasDeUmFilme(filme).iterator();
	}

	@Override
	public void setDiretorDoFilme(int idFilme, IPessoa diretor) throws ErroNaConexao, ErroDAO, ErroParametros {
		controlePessoa.alterarPessoa(diretor);
	}
}
