package br.ufc.vv.testes;

import static org.junit.Assert.assertEquals;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import br.ufc.vv.connection.ConnectionFactory;
import br.ufc.vv.controle.CinemaControl;
import br.ufc.vv.controle.ICinemaControl;
import br.ufc.vv.controle.IProgramacaoControl;
import br.ufc.vv.modelo.Cinema;
import br.ufc.vv.modelo.ICinema;
import br.ufc.vv.modelo.IProgramacao;

public class ControlTestSucess {

	
	@Test
	public void testarQueUmCinemaSerCriadoEBuscadoComSucesso(){
		
		ICinemaControl controle = new CinemaControl();
		
		String nome = "Pinheiro";
		String endereco = "rua dos alfeneiros";
		
		controle.criarCinema(nome, endereco);
		
		
		
		assertEquals(nome, controle.buscarCinema().getNome());
		
	}
	
	@Test
	public void testarQueUmCinemaSerAtualizadoEBuscadoComSucesso(){
		
		ICinemaControl controle = new CinemaControl();
		
		
		String nome = "Iguatemi";
		String endereco = "rua dos bobos";
		
		ICinema novoCinema = new Cinema(nome, endereco);
		
			
		controle.atualizarCinema(novoCinema); 
		
		
		
		assertEquals(nome, controle.buscarCinema().getNome());
		
	}
	
	
	@Test
	public void testarQueUmCinemaSerExcluido(){
		
		ICinemaControl controle = new CinemaControl();
		
		controle.excluirCinema();
		
		assertEquals( null, controle.buscarCinema() );
		
		
	}
	
	@Test
	public void testarQueUmaProgramacaoSerAdicionado(){
				
		final Mockery context = new Mockery();
		
		final IProgramacao prog = context.mock(IProgramacao.class);
		
		context.checking(new Expectations() {{
			atLeast(1).of (prog).retornaEvento();
            will(returnValue("evento x"));
        }});
		
		
		ICinemaControl controle = new CinemaControl();
		
		controle.adicionarProgramacao(prog);
		
		
		assertEquals( prog.retornaEvento(), controle.buscarProgramacao() );
		
	}
	
	@Test
	public void testarQueUmaProgramacaoSerRemovido(){
				
		final Mockery context = new Mockery();
		
		final IProgramacao prog = context.mock(IProgramacao.class);
		
		context.checking(new Expectations() {{
			atLeast(1).of (prog).retornaEvento();
            will(returnValue("evento x"));
        }});
		
		
		ICinemaControl controle = new CinemaControl();
		
		controle.removerProgramacao(prog);
				
	}
	
}
