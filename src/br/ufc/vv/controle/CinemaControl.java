package br.ufc.vv.controle;

import java.util.List;

import br.ufc.vv.modelo.Cinema;
import br.ufc.vv.modelo.CinemaDAO;
import br.ufc.vv.modelo.ICinema;
import br.ufc.vv.modelo.ICinemaDAO;
import br.ufc.vv.modelo.IProgramacao;
import br.ufc.vv.modelo.ISala;

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
	public void adicionarProgramacao(IProgramacao programacao) {
		ICinemaDAO dao = new CinemaDAO();
		
		dao.adicionarProgramacao(programacao.retornaEvento());
	}

	@Override
	public void removerProgramacao(IProgramacao programacao) {
		ICinemaDAO dao = new CinemaDAO();
		
		dao.removerProgramacao(programacao.retornaEvento());
	}

	@Override
	public String buscarProgramacao() {
		ICinemaDAO dao = new CinemaDAO();
		return dao.buscaProgramacao();
	}

	@Override
	public void adicionarSalas(ISala sala) {
		ICinemaDAO dao = new CinemaDAO();
		dao.adicionarSala(sala);
	}

	@Override
	public void removerSalas(ISala sala) {
		ICinemaDAO dao = new CinemaDAO();
		
		dao.removerSala(sala);
	}

	@Override
	public int buscarSalas() {
		ICinemaDAO dao = new CinemaDAO();
		return dao.buscaSala();
	}
	}


