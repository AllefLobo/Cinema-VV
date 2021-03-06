package br.ufc.vv.testes;

import static org.junit.Assert.assertEquals;

import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import br.ufc.vv.model.Cinema;
import br.ufc.vv.model.CinemaDAO;
import br.ufc.vv.model.ICinema;
import br.ufc.vv.model.ICinemaDAO;

public class CinemaDAOTestSucess {

	@Before
	public void setUp() throws Exception {
		final Mockery context = new Mockery();
	}
	
	@Test
	public void testarQueOCinemaSerExcluidoComSucesso(){
		
		ICinemaDAO dao = new CinemaDAO();
		
		
		dao.excluir(dao.buscar());
		
		assertEquals( null, dao.buscar());
			
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
	public void testarQueOCinemaSerAtualizadoComSucesso(){
		
		ICinemaDAO dao = new CinemaDAO();
		ICinema novoCinema = new Cinema("IGUATEMI","Rua do 13");
		ICinema cinemaAtual = dao.buscar();
						
		dao.atualizar( cinemaAtual, novoCinema );
		cinemaAtual = dao.buscar();
	
		//System.out.println(novoCinema.getNome());
		System.out.println(cinemaAtual.getNome());
		
		assertEquals( novoCinema.getNome(), cinemaAtual.getNome() );
	}
	


}
