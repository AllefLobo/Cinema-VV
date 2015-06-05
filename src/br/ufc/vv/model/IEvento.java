package br.ufc.vv.model;
import java.util.Date;


public interface IEvento {

	/**
	 * Este m�todo retorna um objeto do tipo {@link Date} representando a data de inicio do evento.
	 * @return {@link Date} a data de inicio do evento.
	 */
	public abstract Date consultarDataDeInicioDoEvento();
	/**
	 * Este m�todo retorna um objeto do tipo {@link Date} representando a data de termino do evento.
	 * @return {@link Date} a data de termino do evento.
	 */
	public abstract Date consultarDataDeTerminoDoEvento();
	/**
	 * Este m�todo retorna um double representando o valor da entrada no evento.
	 * @return o valor da entrada para o evento.
	 */
	public abstract double consultarValorDaEntradaNoEvento();
	/**
	 * Este m�todo retorna um objeto do tipo {@link IFilme} representando o filme do evento.
	 * @return o filme do evento.
	 */
	public abstract IFilme consultarFilmeDoEvento();
	/**
	 * Este m�todo retorna um objeto do tipo {@link ICinema} representando o cinema do evento.
	 * @return o cinema do evento.
	 */
	public abstract ICinema consultarCinemaDoEvento();
	/**
	 * Este m�todo retorna um objeto do tipo {@link ISala} representando a sala do evento.
	 * @return a sala onde ocorrer� o evento.
	 */
	public abstract ISala consultarSalaDoEvento();
	/**
	 * Este m�todo recebe um objeto do tipo {@link ICinema} e o define como o cinema do evento.
	 * @param cinema do evento.
	 */
	public abstract void definirCinemaDoEvento(ICinema cinema);
	/**
	 * Este m�todo recebe um objeto do tipo {@link IFilme} e o define como o filme do evento.
	 * @param filme do evento.
	 */
	public abstract void definirFilmeDoEvento(IFilme filme);
	/**
	 * Este m�todo recebe um objeto do tipo {@link ISala} e o define como a sala do evento.
	 * @param sala do evento.
	 */
	public abstract void definirSalaDoEvento(ISala sala);
	/**
	 * Este m�todo recebe um objeto do tipo {@link Date} e o define como a data em que come�a o evento.
	 * @param dataInicio do evento.
	 */
	public abstract void definirDataDeInicioDoEvento(Date dataInicio);
	/**
	 * Este m�todo recebe um objeto do tipo {@link Date}e o defini como a data em que termina o evento.
	 * @param dataTermino do evento.
	 */
	public void definirDataDeTerminoDoEvento(Date dataTermino);
}
