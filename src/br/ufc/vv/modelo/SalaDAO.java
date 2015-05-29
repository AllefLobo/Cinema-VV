package br.ufc.vv.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufc.vv.connection.ConnectionFactory;


public class SalaDAO implements ISalaDAO{

	private Connection connection;

	public SalaDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public boolean adicionarSala(Sala sala) {
		String sql = "insert into sala (CapacidadeMaxima) values(?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, sala.getCapacidadeMaxima());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	public boolean removerSala(int id) {
		String sql = "delete from sala where id = ?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			return false;
		}
		return true;

	}
	
	public List<Sala> buscarSalas() {
		String sql = "Select * from sala";
		List<Sala> salas = new ArrayList<Sala>();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.execute();
			ResultSet dados = stmt.getResultSet();
			Sala aux;
			while(dados.next()) {
				aux = new Sala(dados.getInt("CapacidadeMaxima"));
				aux.setId(dados.getInt("Id"));
				salas.add(aux);
			}
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return salas;
	}

}
