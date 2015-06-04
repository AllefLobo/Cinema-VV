package br.ufc.vv.testes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import br.ufc.vv.modelo.Cinema;
import br.ufc.vv.modelo.ICinema;
import br.ufc.vv.modelo.IEvento;
import br.ufc.vv.modelo.ProgramacaoImpl;

// Ja imprimi
public class ProgramacaoTeste extends TestCase {

	@Test
	public void testeAoSetarOCinemaNoConstrutor() {
		
		Mockery context = new JUnit4Mockery();
		
		final ICinema cinema = new Cinema("Teste", "Teste");
		Calendar data = Calendar.getInstance();

		ProgramacaoImpl programacao = new ProgramacaoImpl(cinema,data);
		
		assertEquals(cinema, programacao.getCinema());		
	}
	
	@Test
	public void testeAoSetarOCinemaForaConstrutor() {
		
		Mockery context = new JUnit4Mockery();
		
		final ICinema cinema = new Cinema("Teste", "Teste");

		ProgramacaoImpl programacao = new ProgramacaoImpl();
		programacao.setCinema(cinema);
		
		assertEquals(cinema, programacao.getCinema());		
	}
	
	@Test
	public void testeComCinemaNaoSetado() {
		ProgramacaoImpl programacao = new ProgramacaoImpl();
		assertEquals(null, programacao.getCinema());	
		
	}
	
	@Test
	public void testeVerificandoQuantidadeDeEventosAoAdicionar4EventosIndividuais() {
		
		Mockery context = new JUnit4Mockery();
		
		final IEvento evento1 = context.mock(IEvento.class, "Evento1");
		final IEvento evento2 = context.mock(IEvento.class, "Evento2");
		final IEvento evento3 = context.mock(IEvento.class, "Evento3");
		final IEvento evento4 = context.mock(IEvento.class, "Evento4");

		ProgramacaoImpl programacao = new ProgramacaoImpl();
		
		programacao.addEvento(evento1);
		programacao.addEvento(evento2);
		programacao.addEvento(evento3);
		programacao.addEvento(evento4);
		
		assertEquals(4, programacao.getQuantidadeDeEventos());		
	}
	
	@Test
	public void testeVerificandoQuantidadeDeEventosAoAdicionar4EventosUsandoLista() {
		
		Mockery context = new JUnit4Mockery();
		
		final IEvento evento1 = context.mock(IEvento.class, "Evento1");
		final IEvento evento2 = context.mock(IEvento.class, "Evento2");
		final IEvento evento3 = context.mock(IEvento.class, "Evento3");
		final IEvento evento4 = context.mock(IEvento.class, "Evento4");

		ProgramacaoImpl programacao = new ProgramacaoImpl();
		
		List<IEvento> eventos = new ArrayList<IEvento>();
		eventos.add(evento1);
		eventos.add(evento2);
		eventos.add(evento3);
		eventos.add(evento4);
		
		programacao.addListaDeEvento(eventos);
		
		assertEquals(4, programacao.getQuantidadeDeEventos());		
	}
	
	@Test
	public void testeVerificandoQuantidadeDeEventosAoAdicionar4EventosERemover2Individuais() {
		
		Mockery context = new JUnit4Mockery();
		
		final IEvento evento1 = context.mock(IEvento.class, "Evento1");
		final IEvento evento2 = context.mock(IEvento.class, "Evento2");
		final IEvento evento3 = context.mock(IEvento.class, "Evento3");
		final IEvento evento4 = context.mock(IEvento.class, "Evento4");

		ProgramacaoImpl programacao = new ProgramacaoImpl();
		
		programacao.addEvento(evento1);
		programacao.addEvento(evento2);
		programacao.addEvento(evento3);
		programacao.addEvento(evento4);
		
		programacao.removerEvento(evento3);
		programacao.removerEvento(evento1);
		
		assertEquals(2, programacao.getQuantidadeDeEventos());	
	}
	
	@Test
	public void testeVerificandoQuantidadeDeEventosAoAdicionar5EventosERemover2UsandoLista() {
		
		Mockery context = new JUnit4Mockery();
		
		final IEvento evento1 = context.mock(IEvento.class, "Evento1");
		final IEvento evento2 = context.mock(IEvento.class, "Evento2");
		final IEvento evento3 = context.mock(IEvento.class, "Evento3");
		final IEvento evento4 = context.mock(IEvento.class, "Evento4");
		final IEvento evento5 = context.mock(IEvento.class, "Evento5");

		ProgramacaoImpl programacao = new ProgramacaoImpl();
		
		programacao.addEvento(evento1);
		programacao.addEvento(evento2);
		programacao.addEvento(evento3);
		programacao.addEvento(evento4);
		programacao.addEvento(evento5);
		
		List<IEvento> eventos = new ArrayList<IEvento>();
		eventos.add(evento4);
		eventos.add(evento2);
		
		programacao.removerEventos(eventos);
		
		assertEquals(3, programacao.getQuantidadeDeEventos());	
	}
	
	@Test
	public void testePegandoTodosOsEventos() {
		
		Mockery context = new JUnit4Mockery();
		
		final IEvento evento1 = context.mock(IEvento.class, "Evento1");
		final IEvento evento2 = context.mock(IEvento.class, "Evento2");
		final IEvento evento3 = context.mock(IEvento.class, "Evento3");
		final IEvento evento4 = context.mock(IEvento.class, "Evento4");

		ProgramacaoImpl programacao = new ProgramacaoImpl();
		
		List<IEvento> eventos = new ArrayList<IEvento>();
		eventos.add(evento1);
		eventos.add(evento2);
		eventos.add(evento3);
		eventos.add(evento4);
		
		programacao.addListaDeEvento(eventos);
		
		Iterator<IEvento> it = programacao.getEventos();
		
		while(it.hasNext()){
			assertEquals(true, eventos.contains(it.next()));
		}	
	}
	
	@Test
	public void testSetandoODiaInicialDaProgramacaoUsandoConstrutor() {
		
		Mockery context = new JUnit4Mockery();
		
		final ICinema cinema = new Cinema("Teste", "Teste");
		
		Calendar data = Calendar.getInstance();
		data.set(2015, 05, 05);

		ProgramacaoImpl programacao = new ProgramacaoImpl(cinema,data);
		
		assertEquals(data, programacao.getDiaInicial());
	}
	
	
	@Test
	public void testSetandoODiaInicialDaProgramacaoSemConstrutor() {
		
		Calendar data = Calendar.getInstance();
		data.set(2015, 05, 05);

		ProgramacaoImpl programacao = new ProgramacaoImpl();
		programacao.setDiaInicial(data);
		
		assertEquals(data, programacao.getDiaInicial());
	}
}