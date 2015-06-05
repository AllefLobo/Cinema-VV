package br.ufc.vv.testes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import junit.framework.TestCase;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;

import br.ufc.vv.control.ControladorProgramacaoImpl;
import br.ufc.vv.control.IControladorEvento;
import br.ufc.vv.exception.DataInvalidaException;
import br.ufc.vv.model.IEvento;
import br.ufc.vv.model.IProgramacao;

// Ja imprimi
public class ControladorProgramacaoTeste extends TestCase{
	
	@Test
	public void testeBuscarProgramacaoDaSemanaEVerificarSeOsEventosEstaoSendoAdicionadosCorretamenteAProgramacao(){
		Mockery context = new JUnit4Mockery();
		
		final IControladorEvento controladorEvento = context.mock(IControladorEvento.class);
		
		final List<IEvento> eventos = new ArrayList<IEvento>();
		

		final IEvento evento1 = context.mock(IEvento.class, "Evento1");
		final IEvento evento2 = context.mock(IEvento.class, "Evento2");
		
		final Calendar evento1Data = Calendar.getInstance();
		evento1Data.set(2015, Calendar.DECEMBER, 4);
		
		final Calendar evento2Data = Calendar.getInstance();
		evento2Data.set(2015, Calendar.DECEMBER, 5);
		
		eventos.add(evento2);
		eventos.add(evento1);
		
		context.checking(new Expectations() {{
			atLeast(1).of (evento1).getDataInicial();
            will(returnValue(evento1Data));
        }});
		
		context.checking(new Expectations() {{
			atLeast(1).of (evento2).getDataInicial();
            will(returnValue(evento2Data));
        }});
		
		Calendar data = Calendar.getInstance();
		data.set(2015, 11, 1);
		
		
		final Calendar inicio = Calendar.getInstance();
		inicio.set(Calendar.YEAR, data.get(Calendar.YEAR));
		inicio.set(Calendar.MONTH, data.get(Calendar.MONTH)-1);
		inicio.set(Calendar.DAY_OF_MONTH, 29);
		inicio.set(Calendar.HOUR, 0);
		inicio.set(Calendar.MINUTE, 0);
		inicio.set(Calendar.MILLISECOND, 0);
		
		final Calendar fim = Calendar.getInstance();
		fim.set(Calendar.YEAR, data.get(Calendar.YEAR));
		fim.set(Calendar.MONTH, data.get(Calendar.MONTH));
		fim.set(Calendar.DAY_OF_MONTH, 5);
		fim.set(Calendar.HOUR, 0);
		fim.set(Calendar.MINUTE, 0);
		fim.set(Calendar.MILLISECOND, 0);
		

		context.checking(new Expectations() {{
			atLeast(1).of (controladorEvento).buscarEventosPorIntervaloDeTempo(inicio, fim);
            will(returnValue(eventos));
        }});
		
		ControladorProgramacaoImpl controladorProgramacao = new ControladorProgramacaoImpl(controladorEvento);
		IProgramacao programacao = null;
		try {
			programacao = controladorProgramacao.buscarProgramacaoDaSemana(data);
		} catch (DataInvalidaException e) {
			e.printStackTrace();
		}
		
		assertEquals(2, programacao.getQuantidadeDeEventos());
	}
	
	@Test
	public void testeBuscarProgramacaoPorIntervaloEVerificarSeOsEventosEstaoSendoAdicionadosCorretamenteAProgramacao(){
		Mockery context = new JUnit4Mockery();
		
		final IControladorEvento controladorEvento = context.mock(IControladorEvento.class);
		
		final List<IEvento> eventos = new ArrayList<IEvento>();
		

		final IEvento evento1 = context.mock(IEvento.class, "Evento1");
		final IEvento evento2 = context.mock(IEvento.class, "Evento2");
		
		final Calendar evento1Data = Calendar.getInstance();
		evento1Data.set(2010, Calendar.DECEMBER, 4);
	
		final Calendar evento2Data = Calendar.getInstance();
		evento2Data.set(2012, Calendar.DECEMBER, 5);
		
		eventos.add(evento2);
		eventos.add(evento1);
		
		context.checking(new Expectations() {{
			atLeast(1).of (evento1).getDataInicial();
            will(returnValue(evento1Data));
        }});
		
		context.checking(new Expectations() {{
			atLeast(1).of (evento2).getDataInicial();
            will(returnValue(evento2Data));
        }});
		
		final Calendar inicio = Calendar.getInstance();
		inicio.set(Calendar.YEAR, 2000);
		inicio.set(Calendar.MONTH, 11);
		inicio.set(Calendar.DAY_OF_MONTH, 29);
		
		final Calendar fim = Calendar.getInstance();
		fim.set(Calendar.YEAR, 2015);
		fim.set(Calendar.MONTH, 11);
		fim.set(Calendar.DAY_OF_MONTH, 5);
		

		context.checking(new Expectations() {{
			atLeast(1).of (controladorEvento).buscarEventosPorIntervaloDeTempo(inicio, fim);
            will(returnValue(eventos));
        }});
		
		ControladorProgramacaoImpl controladorProgramacao = new ControladorProgramacaoImpl(controladorEvento);
		List<IProgramacao> programacoes = null;
		try {
			programacoes = controladorProgramacao.buscarProgramacoesPorIntervalo(inicio, fim);
		} catch (DataInvalidaException e) {
			e.printStackTrace();
		}
		
		assertEquals(2, programacoes.size());
	}
	
	@Test
	public void testeBuscarProgramacaoDaSemanaPassandoUmaDataNula(){
		Mockery context = new JUnit4Mockery();
		
		final IControladorEvento controladorEvento = context.mock(IControladorEvento.class);
		
		Calendar data = null;
		
		
		ControladorProgramacaoImpl controladorProgramacao = new ControladorProgramacaoImpl(controladorEvento);
		
		try {
			controladorProgramacao.buscarProgramacaoDaSemana(data);
			fail();
		} catch (DataInvalidaException e) {
			
		}
	}
	
	@Test
	public void testeBuscarProgramacaoPorIntervaloPassandoUmaDataNula() {
		Mockery context = new JUnit4Mockery();
		
		final IControladorEvento controladorEvento = context.mock(IControladorEvento.class);
		
		Calendar inicio = null;
		Calendar fim = null;
		
		
		ControladorProgramacaoImpl controladorProgramacao = new ControladorProgramacaoImpl(controladorEvento);
		
		try {
			controladorProgramacao.buscarProgramacoesPorIntervalo(inicio, fim);
			fail();
		} catch (DataInvalidaException e) {
			
		}
	}
	
	@Test
	public void testeBuscarProgramacaoPorIntervaloPassandoUmFimAnteriorAoInicio() {
		Mockery context = new JUnit4Mockery();
		
		final IControladorEvento controladorEvento = context.mock(IControladorEvento.class);
		
		Calendar inicio = Calendar.getInstance();
		inicio.set(2015, Calendar.JUNE, 28);
		
		
		Calendar fim = Calendar.getInstance();
		fim.set(2014, Calendar.JUNE, 28);
		
		ControladorProgramacaoImpl controladorProgramacao = new ControladorProgramacaoImpl(controladorEvento);
		
		try {
			controladorProgramacao.buscarProgramacoesPorIntervalo(inicio, fim);
			fail();
		} catch (DataInvalidaException e) {
			
		}
	}
}
