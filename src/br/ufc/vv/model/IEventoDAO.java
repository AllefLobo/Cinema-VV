package br.ufc.vv.model;

import java.util.Date;
import java.util.Iterator;


public interface IEventoDAO {
	/**
	 * Este m�todo recebe um objeto do tipo {@link IEvento} e o insere na base de dados.
	 * @param evento a ser persistido na base de dados.
	 * @throws ErroNaConexao 
	 */
	public abstract void salvar(IEvento evento);
	/**
	 * Este m�todo recebe um um objeto do tipo {@link IEvento} e o remove da base de dados.
	 * @param evento a ser removido da base de dados.
	 */
	public abstract void deletar(IEvento evento);
	/**
	 * Este m�todo recebe um objeto do tipo {@link IEvento} e o busca na base de dados.
	 * @param evento aser buscado na base de dados.
	 * @return objeto {@link IEvento} procurado, Null caso n�o exista na base de dados.
	 */
	public abstract IEvento consultar(IEvento evento);
	/**
	 * Este m�todo retorna um objeto do tipo {@link Iterator} representando os evento na base de dados. 
	 * @return {@link Iterator} dos eventos na base de dados, Null caso n�o haja eventos na base de dados.
	 * @throws ErroNaConexao 
	 */
	public abstract Iterator<IEvento> listarTodos();
	/**
	 * Este m�todo recebe um objeto do tipo {@link Date} e retorna um objeto do tipo {@link Iterator} de {@link IEvento} 
	 * representando os evento na base de dados que come�am na data informada.
	 * @param dataInicio
	 * @return um {@link Iterator} de {@link IEvento}
	 * @throws ErroNaConexao 
	 */
	public abstract Iterator<IEvento> listarPorDataDeInicio(Date dataDeInicio);
	/**
	 * Este m�todo recebe um objeto do tipo {@link Date} e retorna um objeto do tipo {@link Iterator} de {@link IEvento} 
	 * representando os evento na base de dados que terminam na data informada.
	 * @param dataInicio
	 * @return um {@link Iterator} de {@link IEvento}
	 * @throws ErroNaConexao 
	 */
	public abstract Iterator<IEvento> listarPorDataDeTermino(Date dataDeTermino);
	/**
	 * Este m�todo recebe um objeto do tipo {@link IFilme} e retorna um objeto do tipo {@link Iterator} de {@link IEvento} 
	 * representando os evento na base de dados que ocorrem com o filme informado.
	 * @param filme
	 * @return um {@link Iterator} de {@link IEvento}
	 * @throws ErroNaConexao 
	 */
	public abstract Iterator<IEvento> listarPorFilme(IFilme filme);
	/**
	 * Este m�todo recebe um objeto do tipo {@link ICinema} e retorna um objeto do tipo {@link Iterator} de {@link IEvento} 
	 * representando os evento na base de dados que ocorrem no cinema informado.
	 * @param cinema
	 * @return um {@link Iterator} de {@link IEvento}
	 */
	public abstract Iterator<IEvento> listarPorCinema(ICinema cinema);
	/**
	 * Este m�todo recebe um objeto do tipo {@link IEvento} e o atualiza na base de dados.
	 * @param antigo a ser atualizado na base de dados.
	 * @param novo TODO
	 */
	public abstract void atualizar(IEvento antigo, IEvento novo);
}
