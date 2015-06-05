package br.ufc.vv.tests;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import br.ufc.vv.control.EventoController;
import br.ufc.vv.control.contract.IEventoController;
import br.ufc.vv.control.excecoes.EventoInexistenteException;
import br.ufc.vv.model.CinemaMock;
import br.ufc.vv.model.Evento;
import br.ufc.vv.model.Filme;
import br.ufc.vv.model.contract.ICinema;
import br.ufc.vv.model.contract.IEvento;
import br.ufc.vv.model.contract.IFilme;
import br.ufc.vv.model.contract.ISala;

public class EventoControllerTest {

	private IEventoController controlador;
	
	@Rule public JUnitRuleMockery contexto = new JUnitRuleMockery();
	
	@Before
	public void setUp() throws Exception {
		this.controlador = new EventoController();
	}

	@Test
	public void testAdicionarNovoEventoQuandoNaoHaEventosCadastrados() {
		IEvento evento = new Evento();
		
		Calendar c = Calendar.getInstance();
		c.set(2015, Calendar.MAY, 25, 15, 0, 0);
		Date dataInicio = c.getTime();
		evento.definirDataDeInicioDoEvento(dataInicio);
		
		c.set(2015, Calendar.MAY, 25, 17, 0, 0);
		Date dataTermino = c.getTime();
		evento.definirDataDeInicioDoEvento(dataInicio);
		evento.definirDataDeTerminoDoEvento(dataTermino);
		
		ICinema cinemaMock = new CinemaMock();
		cinemaMock.definirIdentificador(1);
		evento.definirCinemaDoEvento(cinemaMock);
		
		ISala salaMock = new SalaMock();
		salaMock.definirIdentificador(1);
		evento.definirSalaDoEvento(salaMock);
		
		IFilme filme = new Filme();
		filme.setId(1);
		evento.definirFilmeDoEvento(filme);
		
		controlador.adicionarNovoEvento(evento);
		
		assertEquals(1, controlador.getQuantidadeEventos());
	}
	
	@Test
	public void testAdicionarNovoEventoQuandoExisteAlgumEventoCadastrado() {
		IEvento evento1 = new Evento();
		IEvento evento2 = new Evento();
		int qtd = controlador.getQuantidadeEventos();
		
		Calendar c = Calendar.getInstance();
		c.set(2015, Calendar.MAY, 26, 15, 0, 0);
		Date dataInicio = c.getTime();
		evento1.definirDataDeInicioDoEvento(dataInicio);
		evento2.definirDataDeInicioDoEvento(dataInicio);
		
		c.set(2015, Calendar.MAY, 26, 17, 0, 0);
		Date dataTermino = c.getTime();
		evento1.definirDataDeTerminoDoEvento(dataTermino);
		evento2.definirDataDeTerminoDoEvento(dataTermino);
		
		ICinema cinemaMock1 = new CinemaMock();
		cinemaMock1.definirIdentificador(1);
		evento1.definirCinemaDoEvento(cinemaMock1);
		
		ICinema cinemaMock2 = new CinemaMock();
		cinemaMock2.definirIdentificador(2);
		evento2.definirCinemaDoEvento(cinemaMock2);
		
		ISala salaMock1 = new SalaMock();
		salaMock1.definirIdentificador(1);
		evento1.definirSalaDoEvento(salaMock1);
		evento2.definirSalaDoEvento(salaMock1);
		
		IFilme filme = new Filme();
		filme.setId(1);
		evento1.definirFilmeDoEvento(filme);
		evento2.definirFilmeDoEvento(filme);
		
		controlador.adicionarNovoEvento(evento1);
		controlador.adicionarNovoEvento(evento2);
		
		assertEquals(qtd + 2, controlador.getQuantidadeEventos());
	}
	
	
	@Test (expected = EventoInexistenteException.class)
	public void testRemoverEventoEventoCadastrado() {
		IEvento evento1 = new Evento();
		
		Calendar c = Calendar.getInstance();
		c.set(2015, Calendar.MAY, 26, 15, 0, 0);
		Date dataInicio = c.getTime();
		evento1.definirDataDeInicioDoEvento(dataInicio);
		
		c.set(2015, Calendar.MAY, 26, 17, 0, 0);
		Date dataTermino = c.getTime();
		evento1.definirDataDeTerminoDoEvento(dataTermino);
		
		ICinema cinemaMock1 = new CinemaMock();
		cinemaMock1.definirIdentificador(1);
		evento1.definirCinemaDoEvento(cinemaMock1);
		
		ISala salaMock1 = new SalaMock();
		salaMock1.definirIdentificador(1);
		evento1.definirSalaDoEvento(salaMock1);
		
		IFilme filme = new Filme();
		filme.setId(1);
		evento1.definirFilmeDoEvento(filme);
		
		controlador.deletarEvento(evento1);
		
		controlador.consultarEvento(evento1);
	}

	@Test
	public void testAtualizarEventoCadastrado() {
		IEvento evento1 = new Evento();
		IEvento evento2 = new Evento();
		
		Calendar c = Calendar.getInstance();
		c.set(2015, Calendar.MAY, 25, 15, 0, 0);
		Date dataInicio = c.getTime();
		evento1.definirDataDeInicioDoEvento(dataInicio);
		
		c.set(2015, Calendar.MAY, 25, 17, 0, 0);
		Date dataTermino = c.getTime();
		evento1.definirDataDeTerminoDoEvento(dataTermino);
		
		c.set(2015, Calendar.MAY, 25, 14, 0, 0);
		Date dataInicio2 = c.getTime();
		evento2.definirDataDeTerminoDoEvento(dataTermino);
		evento2.definirDataDeInicioDoEvento(dataInicio2);
		
		ICinema cinemaMock1 = new CinemaMock();
		cinemaMock1.definirIdentificador(1);
		evento1.definirCinemaDoEvento(cinemaMock1);
		evento2.definirCinemaDoEvento(cinemaMock1);
		
		ISala salaMock1 = new SalaMock();
		salaMock1.definirIdentificador(1);
		evento1.definirSalaDoEvento(salaMock1);
		evento2.definirSalaDoEvento(salaMock1);
		
		IFilme filme = new Filme();
		filme.setId(1);
		evento1.definirFilmeDoEvento(filme);
		evento2.definirFilmeDoEvento(filme);
		
		controlador.atualizarEvento(evento1, evento2);
		
		assertEquals(dataInicio2, controlador.consultarEvento(evento2).consultarDataDeInicioDoEvento());
	}
	
	@Test (expected = EventoInexistenteException.class)
	public void testAtualizarUmEventoNaoCadastrado() {
		IEvento evento1 = new Evento();
		IEvento evento2 = new Evento();
		
		Calendar c = Calendar.getInstance();
		c.set(2010, Calendar.MAY, 25, 15, 0, 0);
		Date dataInicio = c.getTime();
		evento1.definirDataDeInicioDoEvento(dataInicio);
		
		c.set(2015, Calendar.MAY, 25, 17, 0, 0);
		Date dataTermino = c.getTime();
		evento1.definirDataDeTerminoDoEvento(dataTermino);
		
		c.set(2015, Calendar.MAY, 25, 14, 0, 0);
		Date dataInicio2 = c.getTime();
		evento2.definirDataDeTerminoDoEvento(dataTermino);
		evento2.definirDataDeInicioDoEvento(dataInicio2);
		
		ICinema cinemaMock1 = new CinemaMock();
		cinemaMock1.definirIdentificador(1);
		evento1.definirCinemaDoEvento(cinemaMock1);
		evento2.definirCinemaDoEvento(cinemaMock1);
		
		ISala salaMock1 = new SalaMock();
		salaMock1.definirIdentificador(1);
		evento1.definirSalaDoEvento(salaMock1);
		evento2.definirSalaDoEvento(salaMock1);
		
		IFilme filme = new Filme();
		filme.setId(1);
		evento1.definirFilmeDoEvento(filme);
		evento2.definirFilmeDoEvento(filme);
		
		controlador.atualizarEvento(evento1, evento2);
	}
	/**
	
	@Test
	public void testDeletarEvento() {
		fail("Not yet implemented");
	}

	@Test
	public void testListarEventos() {
		fail("Not yet implemented");
	}

	@Test
	public void testAtualizarEvento() {
		fail("Not yet implemented");
	}

	@Test
	public void testConsultarEvento() {
		fail("Not yet implemented");
	}

	*/
}
