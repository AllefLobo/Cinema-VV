package br.ufc.vv.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;

import br.ufc.vv.modelo.Cinema;
import br.ufc.vv.modelo.Sala;
import br.ufc.vv.modelo.SalaDAO;

public class TextDAO {

	@Test
	public void testCriandoSala() {
		Sala sala = new Sala(5);
		assertNotEquals(null, sala);
	}

	@Test
	public void testCriandoSalaCapacidade() {
		Sala sala = new Sala(5);
		sala.setCapacidadeMaxima(10);
		assertEquals("testCapacidade", 10, sala.getCapacidadeMaxima());
	}
	
	@Test
	public void testCriandoSalaDAO() {
		SalaDAO salaDAO = new SalaDAO();
		assertNotEquals(null, salaDAO);
	}
	
	@Test
	public void testCriandoSalaCinemaPersistencia() {
		
		Sala sala = new Sala(10);
		SalaDAO salaDAO = new SalaDAO();
		assertEquals(true,salaDAO.adicionarSala(sala));
	}
	
	@Test
	public void testListandoSalas() {
		Sala sala = new Sala(10);
		SalaDAO salaDAO = new SalaDAO();
		
		List<Sala> salas = salaDAO.Listar();
		assertNotEquals(null, sala);
		
		for (Sala aux : salas) {
			assertNotEquals(null, aux);
		}
	}
	
	@Test
	public void testBuscandoSala() {
		Sala sala = new Sala(10);
		SalaDAO salaDAO = new SalaDAO();
		
		List<Sala> salas = salaDAO.Listar();
		
		for (Sala aux : salas) {
			Sala aux1 = salaDAO.buscar(aux.getId());
			assertEquals("testId", aux.getId(), aux1.getId());
			assertEquals("testCapacidadeMaxima", aux.getCapacidadeMaxima(), aux1.getCapacidadeMaxima());
		}
	}
	
	@Test
	public void testRemoverSala() {
		Cinema cinema = new Cinema(1);
		Sala sala = new Sala(10,cinema);
		SalaDAO salaDAO = new SalaDAO();
		
		List<Sala> salas = salaDAO.Listar();
		
		for (Sala aux : salas) {
			assertEquals(true,salaDAO.removerSala(aux));
		}
	}
}
