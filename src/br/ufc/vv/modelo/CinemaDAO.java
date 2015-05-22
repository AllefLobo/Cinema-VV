package br.ufc.vv.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
Connection connection = factory.getConnection();
		
		String sql = "select * from cinema ";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			
			ResultSet rs = stmt.executeQuery();
	
			
			if(rs.first() != false){
					ICinema  cinema = new Cinema( "","");
					cinema.setNome(rs.getString("nome"));
					cinema.setEndereco(rs.getString("endereco"));
					
					stmt.close();
					return cinema;
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
		
		return null;
		
		
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
	public void adicionarProgramacao(String evento) {
		Connection connection = factory.getConnection();
		if( evento != null && buscar() != null ){
			String sql = "insert into programacao(evento) values (?)";
			
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, evento);
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
	public void removerProgramacao(String evento) {
		Connection connection = factory.getConnection();
		if( evento != null && buscar() != null ){
			String sql = "delete from programacao where wvento = ?";
			
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, evento);
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

	@Override
	public void adicionarSala(ISala sala) {
		Connection connection = factory.getConnection();
		if( sala != null && buscar() != null ){
			String sql = "insert into sala(capacidade) values (?)";
			
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setInt(1, sala.retornaCapacidade());
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
	public void removerSala(ISala sala) {
		Connection connection = factory.getConnection();
		if( sala != null && buscar() != null ){
			String sql = "delete from sala where capacidade = ? ";
			
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setInt(1, sala.retornaCapacidade());
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
	public int buscaSala() {
		Connection connection = factory.getConnection();
		if( buscar() != null ){
			String sql = "select * from programacao";
			
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				
				List<ISala> salas = new ArrayList<ISala>();
				
				if(rs.first() != false){ 
						int result = rs.getInt("capacidade");
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
		return 0;
	}


	

}
