package br.ufc.vv.controle;

import java.util.ArrayList;
import java.util.List;

import br.ufc.vv.modelo.Sala;
import br.ufc.vv.modelo.SalaDAO;


public class ControladorSala {

	SalaDAO dao = new SalaDAO();

	public void apagarSala(int idSala) {
		dao.removerSala(idSala);
	}

	public void inserirSala(int capacidadeMaxima) {
		Sala aux = new Sala(capacidadeMaxima);
		dao.adicionarSala(aux);
	}
	
	public List<Sala> listarSala(){
		List<Sala> salas = new ArrayList<Sala>();
		salas = dao.buscarSalas();
		return salas;
	}

}