package br.ufc.vv.teste;

import static org.junit.Assert.assertEquals;

import java.util.List;

import br.ufc.vv.modelo.Sala;
import br.ufc.vv.modelo.SalaDAO;
import br.ufc.vv.view.Cinema;

public class Main {

	public static void main(String[] args) {
		Cinema cinema = new Cinema(1);
		Sala sala = new Sala(10,cinema);
		SalaDAO salaDAO = new SalaDAO();
		
		List<Sala> salas = salaDAO.Listar();
		
		for (Sala aux : salas) {
			Sala aux1 = salaDAO.buscar(aux.getId());
			assertEquals("testId", aux.getId(), aux1.getId());
			assertEquals("testCapacidadeMaxima", aux.getCapacidadeMaxima(), aux1.getCapacidadeMaxima());
			assertEquals("testIdCinema", aux.getIdCinema(),aux1.getIdCinema());
		}

	}

}
