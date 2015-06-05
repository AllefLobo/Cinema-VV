package br.ufc.vv.testes;

import static org.junit.Assert.assertEquals;

import org.jmock.Mockery;
import org.junit.Test;

import br.ufc.vv.model.Cinema;
import br.ufc.vv.model.ICinema;
import br.ufc.vv.model.IProgramacao;
import br.ufc.vv.model.ISala;
import br.ufc.vv.model.Sala;

public class CinemaTestSucess {



	@Test
	public void testarSeSetaOsParametrosDoConstrutor() {
		ICinema cinema = new Cinema("Pinheiro","Rua do alfeneiros");

		final Mockery context = new Mockery();

		assertEquals( "Pinheiro", cinema.getNome() );

		assertEquals( "Rua do alfeneiros", cinema.getEndereco() );


	}


	@Test
	public void testarSeSetaAsSalasNoCinema() {
		
		ICinema cinema = new Cinema("test","12312");

		final ISala sala1 = new Sala(5);
		final ISala sala2 = new Sala(5);
		final ISala sala3 = new Sala(5);
		final ISala sala4 = new Sala(5);
		

		cinema.setSala(sala1);
		cinema.setSala(sala2);
		cinema.setSala(sala3);
		cinema.setSala(sala4);
		
		
		assertEquals(4, cinema.getSala().size());



	}

	@Test
	public void testarSeSetaAProgramacaoNoCinema() {
		ICinema cinema = new Cinema("Pinheiro","Rua do alfeneiros");

		final Mockery context = new Mockery();

		final IProgramacao programacao = context.mock( IProgramacao.class,"Programacao" );




		cinema.setProgramacao(programacao);

		assertEquals( programacao, cinema.getProgramacao() );


	}


}
