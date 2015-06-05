package br.ufc.vv.model;
import java.util.Iterator;

import br.ufc.vv.exception.ErroDAO;

/**
 * Interface responsável por disponibilizar CRUD no módulo Filmes.
 */
public interface IFilmeDAO {
	
	/**
	 * Método responsável por inserir um filme no banco de dados.
	 * 
	 */
	public void salvar(IFilme filme);
	
	/**
	 * Método responsável por alterar informações de um filme do banco de dados.
	 * 
	 */
	public void editar(IFilme filme) throws ErroDAO;
	
	/**
	 * Método responsável por remover um filme do banco de dados.
	 * 
	 */
	public void remover(int idFilme) throws ErroDAO; //Modificado de IFilme filme para int idFilme.
	
	/**
	 * Método responsável por retornar a lista de todos os filmes do banco de dados. 
	 * 
	 */
	public Iterator<IFilme> listar();
	
	
	
	public void addAtoresDoFilme(int id, Iterator<IPessoa> atores);
	
}
