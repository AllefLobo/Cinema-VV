package br.ufc.vv.control;

import java.util.Iterator;

import br.ufc.vv.exception.ErroDAO;
import br.ufc.vv.exception.ErroParametros;
import br.ufc.vv.model.IFilme;
import br.ufc.vv.model.IPessoa;

public interface IFilmeController {
	
	public void criarFilme(String titulo, String sinopse, String genero, 
			String anoFilmagem, String anoLancamento, String estudioFilmagem);
	
	public void editarFilme(int id,String titulo, String sinopse, String genero,
			String anoFilmagem, String anoLancamento, String estudioFilmagem) throws ErroDAO;
		
	public void removerFilme(int idFilme) throws ErroDAO;
	
	public void addAtoresDoFilme(int idFilme, Iterator<IPessoa> atores) throws ErroDAO, ErroParametros;
	
	public Iterator<IPessoa> getAtoresDoFilme(int idFilme) throws ErroDAO, ErroParametros;
	
	public void setDiretorDoFilme(int idFilme, IPessoa diretor) throws ErroDAO, ErroParametros;
	
	public IFilme buscarFilmePorId(int id) ;

	public IFilme buscarFilmePorTitulo(String titulo);
	
	public Iterator<IFilme> listarFilmes() ;
}
