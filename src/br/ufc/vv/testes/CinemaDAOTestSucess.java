package br.ufc.vv.testes;

import static org.junit.Assert.*;

import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import br.ufc.vv.connection.ConnectionFactory;
import br.ufc.vv.modelo.Cinema;
import br.ufc.vv.modelo.CinemaDAO;
import br.ufc.vv.modelo.ICinema;
import br.ufc.vv.modelo.ICinemaDAO;

public class CinemaDAOTestSucess {

	@Before
	public void setUp() throws Exception {
		final Mockery context = new Mockery();
	}

	@Test
	public void testarQueOCinemaSerCadastradoEBuscadoComSucesso(){
		
		ICinema cinema = new Cinema("Pinheiro","Rua do alfeneiros");
		
		ICinemaDAO dao = new CinemaDAO();
		
		dao.cadastrar(cinema);
		ICinema antigoCinema = new Cinema("Pinheiro","Rua do alfeneiros");
		
		
		assertEquals( cinema.getNome(), dao.buscar().getNome());
			
	}
	
	@Test
	public void testarQueOCinemaAtualizadoComSucesso(){
		
		ICinema antigoCinema = new Cinema("Pinheiro","Rua do alfeneiros");
		
		ICinema novoCinema = new Cinema("IGUATEMI","Rua do bagre");
		
		ICinemaDAO dao = new CinemaDAO();
		
		dao.atualizar(antigoCinema, novoCinema);
		
		assertEquals( novoCinema.getNome(), dao.buscar().getNome());
			
	}
	
	@Test
	public void testarQueOCinemaSerExcluidoComSucesso(){
		
		ICinema cinema = new Cinema("IGUATEMI","Rua do bagre");
		
		ICinemaDAO dao = new CinemaDAO();
		
		
		dao.excluir(cinema);
		
		assertEquals( null, dao.buscar());
			
	}

}
