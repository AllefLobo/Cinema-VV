package br.ufc.vv.control;

import java.util.Iterator;

import br.ufc.vv.control.excecoes.EventoInexistenteException;
import br.ufc.vv.model.contract.IEvento;


public interface IEventoController {
	
	/**
	 * Este m�todo adiciona um novo evento a base de dados.
	 * @param evento que deseja adicionar.
	 */
	public abstract void adicionarNovoEvento(IEvento evento);
	
	/**
	 * Este m�todo remove o evento da base de dados caso ele exista nela.
	 * @param evento que deseja remover. 
	 */
	public abstract void deletarEvento(IEvento evento);
	
	/**
	 * Este m�todo retorna um objeto do tipo {@link Iterator} representando a lista de eventos na base de dados.
	 * @return {@link Iterator} dos eventos na base de dados, null caso n�o haja nenhum.
	 */
	public abstract Iterator<IEvento> listarEventos();
	
	/**
	 * Este m�todo recebe um objeto do tipo {@link IEvento} representando o evento a ser atualizado na base de dados.
	 * @param antigo a ser atualizado caso exista na base de dados.
	 * @param novo evento com os dados atualizados.
	 */
	public abstract void atualizarEvento(IEvento antigo, IEvento novo);
	
	/**
	 * Este m�todo recebe um objeto do tipo {@link IEvento} e o busca na base de dados.
	 * @param evento que deseja buscar na base de dados.
	 * @return um objeto do tipo {@link IEvento} baseado no evento informado case ele exista na base de dados, Null caso contr�rio.
	 */
	public abstract IEvento consultarEvento(IEvento evento) throws EventoInexistenteException;
	/**
	 * Este m�todo informa a quantidade de eventos na base de dados.
	 * @return a quantidade de eventos amarzenados na base de dados.
	 */
	public abstract int getQuantidadeEventos();
}
