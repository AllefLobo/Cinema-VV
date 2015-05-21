package br.ufc.vv.testes;

import static org.junit.Assert.*;

import java.util.List;

import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import br.ufc.vv.modelo.Cinema;
import br.ufc.vv.modelo.IProgramacao;
import br.ufc.vv.modelo.ISala;

public class CinemaTest {

	@Before
	public void setUp() throws Exception {
		final Mockery context = new Mockery();
	}

	@Test
	public void testarOsGetsESetsDoObjetoCinema() {
		Cinema cinema = new Cinema( "Pinheiro", "rua maria do bairro" );
		IProgramacao programacao = null;
		List<ISala> salas = null;
		
		cinema.setNome("Iguatemi");
		assertEquals("Iguatemi", cinema.getNome() );
		
		cinema.setEndereco( "rua do bagre pereira" );
		assertEquals("rua do bagre pereira", cinema.getEndereco() );
		
		cinema.setProgramacao(programacao);
		assertEquals( programacao, cinema.getProgramacao() );
		
		cinema.setSala(salas);
		assertEquals( salas, cinema.getSala() );
		
		
		
	}
	

}
