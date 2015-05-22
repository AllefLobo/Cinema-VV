package br.ufc.vv.testes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import br.ufc.vv.modelo.Cinema;
import br.ufc.vv.modelo.ICinema;
import br.ufc.vv.modelo.ICinemaDAO;
import br.ufc.vv.modelo.IProgramacao;
import br.ufc.vv.modelo.ISala;

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
		ICinema cinema = new Cinema("Pinheiro","Rua do alfeneiros");
		
		final Mockery context = new Mockery();
		
		final ISala sala1 = context.mock( ISala.class,"Sala1" );
		final ISala sala2 = context.mock( ISala.class,"Sala2" );
		final ISala sala3 = context.mock( ISala.class,"Sala3" );
		final ISala sala4 = context.mock( ISala.class,"Sala4" );
		
		
		List<ISala> salas = new ArrayList<ISala>();
		
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