package br.ufc.vv.controle;

import java.util.List;

import br.ufc.vv.modelo.Cinema;
import br.ufc.vv.modelo.CinemaDAO;
import br.ufc.vv.modelo.ICinema;
import br.ufc.vv.modelo.ICinemaDAO;
import br.ufc.vv.modelo.ISala;
import br.ufc.vv.modelo.Sala;
import br.ufc.vv.visao.IProgramacaoGUI;
import br.ufc.vv.visao.ProgramacaoGUIImpl;

public class CinemaControl implements ICinemaControl {

	@Override
	public void criarCinema(String nome, String endereco) {
		ICinema cinema = new Cinema(nome, endereco);
		ICinemaDAO dao = new CinemaDAO();
		
		dao.cadastrar(cinema);
	}

	@Override
	public void atualizarCinema( ICinema novoCinema) {
		ICinemaDAO dao = new CinemaDAO();
		dao.atualizar(dao.buscar(), novoCinema);
	}

	@Override
	public ICinema buscarCinema() {
		ICinemaDAO dao = new CinemaDAO();
		return dao.buscar();
	}

	@Override
	public void excluirCinema() {
		ICinemaDAO dao = new CinemaDAO();
		dao.excluir(dao.buscar());
	}

	
	@Override
	public void mostrarProgramacao() {
		ICinemaDAO dao = new CinemaDAO();
		IProgramacaoGUI gui = new ProgramacaoGUIImpl();
		gui.init();
	}

	@Override
	public void adicionarSalas(int capacidadeMaxima) {
		ControladorSala controlador = new ControladorSala();
		controlador.inserirSala(capacidadeMaxima);
	} 

	@Override
	public void removerSalas(ISala sala) {
		ControladorSala controlador = new ControladorSala();
		controlador.apagarSala(sala.getId());
	}

	@Override
	public List<Sala> buscarSalas() {
		ControladorSala controlador = new ControladorSala();
		return controlador.listarSala();
	}
}


