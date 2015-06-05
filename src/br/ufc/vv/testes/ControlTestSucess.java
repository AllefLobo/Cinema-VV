package br.ufc.vv.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.ufc.vv.control.CinemaControl;
import br.ufc.vv.control.ICinemaControl;
import br.ufc.vv.model.Cinema;
import br.ufc.vv.model.ICinema;

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
	
}
