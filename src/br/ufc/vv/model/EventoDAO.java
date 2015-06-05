package br.ufc.vv.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import br.ufc.vv.connection.ConnectionFactory;
import br.ufc.vv.control.FilmeControlador;
import br.ufc.vv.control.IFilmeController;


public class EventoDAO implements IEventoDAO {

	@Override
	public void salvar(IEvento evento){
		Connection conexao = new ConnectionFactory().getConnection();
		
		String sqlInsert = "insert into evento (data_inicio, id_cinema, id_sala, id_filme, data_fim) values (?,?,?,?,?);";
		try {
			PreparedStatement st = conexao.prepareStatement(sqlInsert);
			
			java.sql.Date dataInicio = new java.sql.Date(evento.consultarDataDeInicioDoEvento().getTime());
			java.sql.Date dataFim = new java.sql.Date(evento.consultarDataDeTerminoDoEvento().getTime());
			
			st.setDate(1, dataInicio);
			st.setInt(3, evento.consultarSalaDoEvento().getId());
			st.setInt(4, evento.consultarFilmeDoEvento().getId());
			st.setDate(5, dataFim);
			st.execute();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deletar(IEvento evento) {
		Connection connection = null;
		try {
			connection = new ConnectionFactory().getConnection();
			
			PreparedStatement query;
			String sqlDelete = "delete from evento where data_inicio=? and id_cinema=? and id_sala=?;";
			query = connection.prepareStatement(sqlDelete);
			
			java.sql.Date dataInicio = new java.sql.Date(evento.consultarDataDeInicioDoEvento().getTime());
			
			query.setDate(1, dataInicio);
			query.setInt(3, evento.consultarSalaDoEvento().getId());
			query.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	@Override
	public IEvento consultar(IEvento evento) {
		Connection connection = null;
		try {
			connection = new ConnectionFactory().getConnection();
			
			PreparedStatement query;
			String sqlSelect = "select * from evento where data_inicio=? and id_cinema=? and id_sala=?;";
			query = connection.prepareStatement(sqlSelect);
			
			java.sql.Date dataInicio = new java.sql.Date(evento.consultarDataDeInicioDoEvento().getTime());
			
			query.setDate(1, dataInicio);
			query.setInt(3, evento.consultarSalaDoEvento().getId());
			ResultSet rs = query.executeQuery();
			
			if (rs.next()) {
				return evento;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public Iterator<IEvento> listarTodos() {
		List<IEvento> eventos = null;
		
		String sqlSelect = "select * from evento;";
		
		try {
			Connection conexao = new ConnectionFactory().getConnection();
			PreparedStatement st = conexao.prepareStatement(sqlSelect);
			
			ResultSet rs = st.executeQuery();
			
			IFilmeController filmeControlador = new FilmeControlador();
			eventos = new ArrayList<IEvento>();
			while (rs.next()) {
				IEvento evento = new Evento();
				
				List<Sala> salas = new SalaDAO().buscarSalas();
				ISala sala = null;	
				for (ISala iSala : salas) {
					if(iSala.getId() == evento.consultarSalaDoEvento().getId()){
						sala = iSala;
					}
				}
				
				evento.definirSalaDoEvento(sala);
				
				IFilme filme = filmeControlador.buscarFilmePorId(rs.getInt("id_filme"));
				evento.definirFilmeDoEvento(filme);
				
				eventos.add(evento);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return eventos.iterator();
	}

	@Override
	public Iterator<IEvento> listarPorDataDeInicio(Date dataDeInicio){
		List<IEvento> eventos = null;
		
		String sqlSelect = "select * from evento where data_inicio=?;";
		
		try {
			Connection conexao = new ConnectionFactory().getConnection();
			PreparedStatement st = conexao.prepareStatement(sqlSelect);
			
			java.sql.Date dataInicioNovo = new java.sql.Date(dataDeInicio.getTime());
			st.setDate(1, dataInicioNovo);
			
			ResultSet rs = st.executeQuery();
			
			IFilmeController filmeControlador = new FilmeControlador();
			eventos = new ArrayList<IEvento>();
			while (rs.next()) {
				IEvento evento = new Evento();
				
				List<Sala> salas = new SalaDAO().buscarSalas();
				ISala sala = null;	
				for (ISala iSala : salas) {
					if(iSala.getId() == evento.consultarSalaDoEvento().getId()){
						sala = iSala;
					}
				}
				evento.definirSalaDoEvento(sala);
				
				IFilme filme = filmeControlador.buscarFilmePorId(rs.getInt("id_filme"));
				evento.definirFilmeDoEvento(filme);
				
				eventos.add(evento);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return eventos.iterator();
	}

	@Override
	public Iterator<IEvento> listarPorDataDeTermino(Date dataDeTermino){
		List<IEvento> eventos = null;
		
		String sqlSelect = "select * from evento where data_fim=?;";
		
		try {
			Connection conexao = new ConnectionFactory().getConnection();
			PreparedStatement st = conexao.prepareStatement(sqlSelect);
			
			java.sql.Date dataInicioNovo = new java.sql.Date(dataDeTermino.getTime());
			st.setDate(1, dataInicioNovo);
			
			ResultSet rs = st.executeQuery();
			
			IFilmeController filmeControlador = new FilmeControlador();
			eventos = new ArrayList<IEvento>();
			while (rs.next()) {
				IEvento evento = new Evento();
				

				List<Sala> salas = new SalaDAO().buscarSalas();
				ISala sala = null;	
				for (ISala iSala : salas) {
					if(iSala.getId() == evento.consultarSalaDoEvento().getId()){
						sala = iSala;
					}
				}
				evento.definirSalaDoEvento(sala);
				
				IFilme filme = filmeControlador.buscarFilmePorId(rs.getInt("id_filme"));
				evento.definirFilmeDoEvento(filme);
				
				eventos.add(evento);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return eventos.iterator();
	}

	@Override
	public Iterator<IEvento> listarPorFilme(IFilme filme){
		List<IEvento> eventos = null;
		
		String sqlSelect = "select * from evento where id_filme=?;";
		
		try {
			Connection conexao = new ConnectionFactory().getConnection();
			PreparedStatement st = conexao.prepareStatement(sqlSelect);
			
			st.setInt(1, filme.getId());
			
			ResultSet rs = st.executeQuery();
			
			eventos = new ArrayList<IEvento>();
			while (rs.next()) {
				IEvento evento = new Evento();
				
				List<Sala> salas = new SalaDAO().buscarSalas();
				ISala sala = null;	
				for (ISala iSala : salas) {
					if(iSala.getId() == evento.consultarSalaDoEvento().getId()){
						sala = iSala;
					}
				}
				evento.definirSalaDoEvento(sala);
				
				evento.definirFilmeDoEvento(filme);
				
				eventos.add(evento);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return eventos.iterator();
	}

	@Override
	public Iterator<IEvento> listarPorCinema(ICinema cinema) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualizar(IEvento antigo, IEvento novo) {
		String sqlUpdate = "update evento set data_inicio=?, id_sala=?, id_filme=?, data_fim=?"
				+ " where data_inicio=? and id_sala=?;";
		
		try {
			Connection conexao = new ConnectionFactory().getConnection();
			PreparedStatement query;
			query = conexao.prepareStatement(sqlUpdate);
			
			java.sql.Date dataInicioNovo = new java.sql.Date(novo.consultarDataDeInicioDoEvento().getTime());
			java.sql.Date dataInicioAntigo = new java.sql.Date(antigo.consultarDataDeInicioDoEvento().getTime());
			java.sql.Date dataFim = new java.sql.Date(novo.consultarDataDeTerminoDoEvento().getTime());
			
			query.setDate(1, dataInicioNovo);
			query.setInt(3, novo.consultarSalaDoEvento().getId());
			query.setInt(4, novo.consultarFilmeDoEvento().getId());
			query.setDate(5, dataFim);
			
			query.setDate(6, dataInicioAntigo);
			query.setInt(8, antigo.consultarSalaDoEvento().getId());
			query.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
