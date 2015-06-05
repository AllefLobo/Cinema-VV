package br.ufc.vv.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import br.ufc.vv.control.FilmeControlador;
import br.ufc.vv.control.contract.IFilmeController;
import br.ufc.vv.model.connection.excecoes.ErroNaConexao;

public class CadastrarListener implements ActionListener{

	private String titulo;
	private String sinopse;
	private String genero;
	private String estudioDeFilmagem;
	private String anoLancamento;
	private String anoFilmagem;
	
	
	public CadastrarListener(String titulo, String sinopse, String genero, String estudioDeFilmagem, String anoLancamento, String anoFilmagem) {
		this.titulo = titulo;
		this.sinopse = sinopse;
		this.genero = genero;
		this.estudioDeFilmagem = estudioDeFilmagem;
		this.anoFilmagem = anoFilmagem;
		this.anoLancamento = anoLancamento;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		IFilmeController controlador = new FilmeControlador();
		System.out.println(titulo);
		try {
			controlador.criarFilme(titulo, sinopse, genero, anoFilmagem, anoLancamento, estudioDeFilmagem);
		} catch (ErroNaConexao e1) {
			e1.printStackTrace();
		}
	}

}
