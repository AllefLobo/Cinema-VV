package br.ufc.vv.controle;


import java.util.Calendar;
import java.util.List;

import br.ufc.vv.exception.DataInvalidaException;
import br.ufc.vv.modelo.ICinema;
import br.ufc.vv.modelo.IProgramacao;



public interface IControladorProgramacao {
	
	/**
	 * Esse m&eacute;todo &eacute; responsavel por retornar uma programacao de uma determinada semana da data 
	 * passada como parametro.
	 * 
	 * @throws DataInvalidaException Excecao &eacute; lancada quando uma data invalida ou nula &eacute; recebida
	 * @param data uma data contendo a semana que se deseja obter a programacao
	 * @return retorna a programacao referente a semana da data passada como parametro
	 */
	public IProgramacao buscarProgramacaoDaSemana(ICinema cinema, Calendar data) throws DataInvalidaException;
	
	
	/**
	 * Esse m&eacute;todo &eacute; responsavel por retonar uma lista de programacoes de um determinado intervalo 
	 * de tempo passado por parametro 
	 * 
	 * @throws DataInvalidaException Excecao &eacute; lancada quando uma data invalida ou nula &eacute; recebida
	 * @param cinema o cinema para o qual se deseja obter a programacao
	 * @param inicio uma data contendo o mes inicial do intervalo que se deseja obter as programacoes
	 * @param fim uma data contendo o mes final do intervalo que se deseja obter as programacoes
	 * @return retorna uma lista de programacoes referente aos intervalos e ao cinema passados como parametro
	 */
	public List<IProgramacao> buscarProgramacoesPorIntervalo(ICinema cinema, Calendar inicio, Calendar fim) throws DataInvalidaException;
	
	/**
	 * Esse m&eacute;todo &eacute; responsavel por retonar todas programacoes ja cadastradas no cinema. 
	 * 
	 * @return retorna uma lista com todas as programacoes ja cadastradas daquele cinema
	 */
	public List<IProgramacao> buscarTodasAsProgramacoes(ICinema cinema);
}
