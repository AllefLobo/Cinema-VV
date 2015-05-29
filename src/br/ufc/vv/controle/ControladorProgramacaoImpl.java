package br.ufc.vv.controle;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.ufc.vv.exception.DataInvalidaException;
import br.ufc.vv.modelo.ICinema;
import br.ufc.vv.modelo.IEvento;
import br.ufc.vv.modelo.IProgramacao;
import br.ufc.vv.modelo.ProgramacaoImpl;



public class ControladorProgramacaoImpl implements IControladorProgramacao{
	private IControladorEvento controladorEvento;
		
	public ControladorProgramacaoImpl(IControladorEvento controladorEvento) {
		this.controladorEvento = controladorEvento;
	}
	
	private List<IProgramacao> adicionarEventosAProgramacoes(List<IEvento> eventos){
		List<IProgramacao> programacoes = new ArrayList<IProgramacao>();
		for (IEvento evento : eventos) {
			boolean eventoFoiAdicionado = false;
			for(IProgramacao programacao: programacoes){
				int anoProgramacao = programacao.getDiaInicial().get(Calendar.YEAR);
				int anoEvento = evento.getDataInicial().get(Calendar.YEAR);
				int semanaDaProgramacao = programacao.getDiaInicial().get(Calendar.WEEK_OF_YEAR);
				int semanaDoEvento = evento.getDataInicial().get(Calendar.WEEK_OF_YEAR);
				if(semanaDaProgramacao == semanaDoEvento && anoEvento == anoProgramacao){
					programacao.addEvento(evento);
					eventoFoiAdicionado = true;
				}
			}
			if(!eventoFoiAdicionado){
				IProgramacao programacao = new ProgramacaoImpl();
				programacao.addEvento(evento);
				Calendar dataInicial = evento.getDataInicial();
				programacao.setDiaInicial(dataInicial);
				programacoes.add(programacao);
			}
		}
		return programacoes;
	}
	
	private boolean verificarSeIntervaloEValido(Calendar inicio, Calendar fim) {
		if(fim.get(Calendar.YEAR) < inicio.get(Calendar.YEAR)){
			return false;
		}else if(fim.get(Calendar.YEAR) == inicio.get(Calendar.YEAR)
				&& fim.get(Calendar.MONTH) < inicio.get(Calendar.MONTH)){
			return false;
		}else if(fim.get(Calendar.YEAR) == inicio.get(Calendar.YEAR)
				&& fim.get(Calendar.MONTH) == inicio.get(Calendar.MONTH)
				&& fim.get(Calendar.DAY_OF_MONTH) == inicio.get(Calendar.DAY_OF_MONTH)){
			return false;
		}
		
		return true;
	}
	
	private boolean verificarSeDataEValida(Calendar data){
		if(data != null){
			if(data.get(Calendar.MONTH) >= Calendar.JANUARY && data.get(Calendar.MONTH) <= Calendar.DECEMBER){
				if(data.get(Calendar.YEAR) >= 1970){
					if(data.get(Calendar.DAY_OF_MONTH) >= data.getActualMinimum(Calendar.DAY_OF_MONTH) && data.get(Calendar.DAY_OF_MONTH) <= data.getActualMaximum(Calendar.DAY_OF_MONTH)){
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public IProgramacao buscarProgramacaoDaSemana(ICinema cinema, Calendar data)
			throws DataInvalidaException {
		
		if(this.verificarSeDataEValida(data)){
			data.setFirstDayOfWeek(Calendar.SUNDAY);
			
			Calendar inicio = Calendar.getInstance();
			inicio.set(Calendar.YEAR, data.get(Calendar.YEAR));
			inicio.set(Calendar.MONTH, data.get(Calendar.MONTH));
			inicio.setFirstDayOfWeek(Calendar.SUNDAY);
			int primeiroDiaDaSemana = data.get(Calendar.DAY_OF_MONTH) - (data.get(Calendar.DAY_OF_WEEK)- data.getFirstDayOfWeek());
			inicio.set(Calendar.DAY_OF_MONTH, primeiroDiaDaSemana);
			inicio.set(Calendar.HOUR, 0);
			inicio.set(Calendar.MINUTE, 0);
			inicio.set(Calendar.MILLISECOND, 0);
			
			Calendar fim = Calendar.getInstance();
			fim.set(Calendar.YEAR, inicio.get(Calendar.YEAR));
			fim.set(Calendar.MONTH, inicio.get(Calendar.MONTH));
			fim.setFirstDayOfWeek(Calendar.SUNDAY);
			fim.set(Calendar.DAY_OF_MONTH, inicio.get(Calendar.DAY_OF_MONTH) + 6);
			fim.set(Calendar.HOUR, 0);
			fim.set(Calendar.MINUTE, 0);
			fim.set(Calendar.MILLISECOND, 0);
			
			List<IEvento> eventos = this.controladorEvento.buscarEventosPorIntervaloDeTempo(cinema, inicio, fim);
			
			IProgramacao programacao = new ProgramacaoImpl();
			programacao.setDiaInicial(inicio);
			programacao.addListaDeEvento(eventos);
			
			return programacao;
		}else{
			throw new DataInvalidaException();
		}
	}

	
	public List<IProgramacao> buscarProgramacoesPorIntervalo(ICinema cinema, Calendar inicio,
			Calendar fim) throws DataInvalidaException {
		
		if(this.verificarSeDataEValida(fim) && this.verificarSeDataEValida(inicio)
				&& this.verificarSeIntervaloEValido(inicio, fim)){
			List<IEvento> eventos = this.controladorEvento.buscarEventosPorIntervaloDeTempo(cinema, inicio, fim);
			
			List<IProgramacao> programacoes = this.adicionarEventosAProgramacoes(eventos);
			return programacoes;
		}else{
			throw new DataInvalidaException();
		}
	}
	
	public List<IProgramacao> buscarTodasAsProgramacoes(ICinema cinema) {
		List<IEvento> eventos = this.controladorEvento.buscarTodosOsEventos(cinema);
		List<IProgramacao> programacoes = this.adicionarEventosAProgramacoes(eventos);
		return programacoes;
	}
}
