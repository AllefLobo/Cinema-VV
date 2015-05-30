package br.ufc.vv.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.ufc.vv.connection.ConnectionFactory;



public class CinemaDAO implements ICinemaDAO {

	private ConnectionFactory factory ;
	
	public CinemaDAO(){
		factory = new ConnectionFactory();
	}
	
	@Override
	public void cadastrar(ICinema cinema) {
		
		Connection connection = factory.getConnection();
		if( cinema!= null && buscar() == null ){
			String sql = "insert into cinema(nome,endereco) values (?,?)";
			
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, cinema.getNome());
				stmt.setString(2, cinema.getEndereco());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public ICinema buscar(  ) {
		ICinema  cinema = null;
		Connection connection = factory.getConnection();
		
		String sql = "select nome, endereco from cinema";
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
					cinema = new Cinema( "","");
					cinema.setNome(rs.getString("nome"));
					cinema.setEndereco(rs.getString("endereco"));
			}
			
			rs.close();
			
			stmt.close();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return cinema;
	}
	
	@Override
	public void atualizar(ICinema antigo, ICinema novo) {
	 
		
		Connection connection = factory.getConnection();
		if( antigo!= null && novo!= null  ){
			String sql = "update cinema set nome = ?, endereco = ? where nome = ? ";
			
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, novo.getNome());
				stmt.setString(2, novo.getEndereco());
				stmt.setString(3, antigo.getNome());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void excluir(ICinema cinema) {
		Connection connection = factory.getConnection();
		if( cinema!= null && buscar() != null ){
			String sql = "delete from cinema where nome = ?";
			
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, cinema.getNome());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
	}

	@Override
	public String buscaProgramacao( ) {
		Connection connection = factory.getConnection();
		if( buscar() != null ){
			String sql = "select * from programacao";
			
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				
				
				if(rs.first() != false){ 
						String result = rs.getString("evento");
						stmt.close();
						return result;
						
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}

}
