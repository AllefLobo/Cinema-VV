package br.ufc.vv.control;

import java.util.Iterator;

import br.ufc.vv.control.contract.IEventoController;
import br.ufc.vv.control.excecoes.EventoInexistenteException;
import br.ufc.vv.model.EventoDAO;
import br.ufc.vv.model.connection.excecoes.ErroNaConexao;
import br.ufc.vv.model.contract.IEvento;
import br.ufc.vv.model.contract.IEventoDAO;

public class EventoController implements IEventoController {

	@Override
	public void adicionarNovoEvento(IEvento evento) {
		try {
			IEventoDAO dao = new EventoDAO();
			dao.salvar(evento);
		} catch (ErroNaConexao e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deletarEvento(IEvento evento) {
		new EventoDAO().deletar(evento);
	}

	@Override
	public Iterator<IEvento> listarEventos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualizarEvento(IEvento antigo, IEvento novo) throws EventoInexistenteException{
		IEventoDAO dao = new EventoDAO();
		
		if (dao.consultar(antigo) == null) {
			throw new EventoInexistenteException();
		}
		dao.atualizar(antigo, novo);
	};

	@Override
	public IEvento consultarEvento(IEvento evento) throws EventoInexistenteException{
		IEvento ev = new EventoDAO().consultar(evento);
		if (ev == null) {
			throw new EventoInexistenteException();
		}
		return ev;
	}

	@Override
	public int getQuantidadeEventos() {
		Iterator<IEvento> eventos;
		int qtd = 0;
		try {
			eventos = new EventoDAO().listarTodos();
			while (eventos.hasNext()) {
				qtd++;
				eventos.next();
			}
		} catch (ErroNaConexao e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return qtd;
	}

}
