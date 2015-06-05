package br.ufc.vv.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufc.vv.connection.ConnectionFactory;
import br.ufc.vv.exception.ErroDAO;

public class PessoaDAO implements IPessoaDAO{

	private ConnectionFactory fabrica;

	public PessoaDAO(){
		fabrica = new ConnectionFactory();
	}
	
	@Override
	public boolean cadastrar(IPessoa pessoa) throws ErroDAO {
		try {
			Connection con = fabrica.getConnection();
			PreparedStatement pStatement = con.prepareStatement("insert into pessoa(nome, salario, idade, rg, tipo) values (?, ?, ?, ?, ?)");
			pStatement.setString(1,  pessoa.getNome());
			pStatement.setDouble(2, pessoa.getSalario());
			pStatement.setInt(3, pessoa.getIdade());
			pStatement.setInt(4, pessoa.getRg());
			pStatement.setString(5, pessoa.getTipo());
			pStatement.execute();
			con.close();
			return true;
		} catch (SQLException|ErroNaConexao e) {
			throw new ErroDAO(e.getMessage());
		}
	}

	@Override
	public boolean remover(IPessoa pessoa) throws ErroDAO {
		try {
			Connection con = fabrica.getConexao();;
			PreparedStatement pStatement = con.prepareStatement("delete from pessoa where id = ?");
			pStatement.setInt(1,  pessoa.getId());
			pStatement.execute();
			con.close();
			return true;
		} catch (SQLException|ErroNaConexao e) {
			throw new ErroDAO(e.getMessage());
		}
	}

	@Override
	public boolean alterar(IPessoa pessoa) throws ErroDAO {
		Connection connection = null;
		try {
			connection= fabrica.getConnection();
			PreparedStatement query = 
					connection.prepareStatement("update pessoa set nome=?, salario=?,rg=?,tipo=?,idade=?  where id = ?");
			
			query.setString(1,pessoa.getNome());
			query.setDouble(2, pessoa.getSalario());
			query.setLong(3,pessoa.getRg());
			query.setString(4, pessoa.getTipo());
			query.setInt(5, pessoa.getIdade());
			query.setLong(6, pessoa.getId());
			query.execute();
			connection.close();
			return true;
		} catch (SQLException | ErroNaConexao e) {
			throw new ErroDAO(e.getMessage());
		}
	}

	@Override
	public List<IPessoa> buscarTodasDeUmFilme(IFilme filme) throws ErroDAO {
		try {
			Connection con = fabrica.getConnection();
			PreparedStatement smt = 
					con.prepareStatement("select p.id,p.nome,p.rg,p.tipo,p.idade, p.salario from pessoa as p, pessoasDeFilme as pf where pf.idFilme = ? and p.id = pf.idPessoa");
			
			smt.setInt(1, filme.getId());
			ResultSet rs = smt.executeQuery();
			
			List<IPessoa> listPessoas = new ArrayList<IPessoa>();
			
			while(rs.next()){
				Pessoa pessoa = new Pessoa();
				pessoa.setId(rs.getInt("id"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setSalario(rs.getDouble("salario"));
				pessoa.setRg(rs.getInt("rg"));
				pessoa.setTipo(rs.getString("tipo"));
				pessoa.setIdade(rs.getInt("idade"));
				listPessoas.add(pessoa);
			}
			
			con.close();
			return listPessoas;
		} catch (ErroNaConexao | SQLException e) {
			throw new ErroDAO(e.getMessage());
		}
	}

	@Override
	public Pessoa buscarPorId(int id) throws ErroDAO {
		try {
			Connection con = fabrica.getConnection();
			PreparedStatement stm = con.prepareStatement("select *from pessoa where id=?");
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			rs.first();
			
			Pessoa pessoa = new Pessoa();
			pessoa.setId(rs.getInt("id"));
			pessoa.setNome(rs.getString("nome"));
			pessoa.setSalario(rs.getDouble("salario"));
			pessoa.setRg(rs.getInt("rg"));
			pessoa.setTipo(rs.getString("tipo"));
			pessoa.setIdade(rs.getInt("idade"));

			con.close();
			return pessoa;
			
		} catch (ErroNaConexao|SQLException e) {
			throw new ErroDAO(e.getMessage());
		}
	}

	@Override
	public List<IPessoa> buscarPorNome(IPessoa pessoa, IFilme filme) throws ErroDAO {
		try {
			Connection con = fabrica.getConnection();
			PreparedStatement stm = con.prepareStatement("select p.id,p.nome,p.rg,p.tipo,p.idade, p.salario  from pessoa as p, pessoasDeFilme as pf where pf.idFilme=? and p.id = pf.idPessoa and p.nome = ?");
			stm.setInt(1, filme.getId());
			stm.setString(2, pessoa.getNome());
			
			ResultSet rs = stm.executeQuery();
			
			List<IPessoa> listPessoa = new ArrayList<IPessoa>();
			
			while(rs.next()){
				Pessoa aPessoa = new Pessoa();
				aPessoa.setId(rs.getInt("id"));
				aPessoa.setNome(rs.getString("nome"));
				aPessoa.setSalario(rs.getDouble("salario"));
				aPessoa.setRg(rs.getInt("rg"));
				aPessoa.setTipo(rs.getString("tipo"));
				aPessoa.setIdade(rs.getInt("idade"));
				listPessoa.add(aPessoa);
			}
			
			return listPessoa;
		} catch (ErroNaConexao | SQLException e) {
			throw new ErroDAO(e.getMessage());
		}
	}

	@Override
	public List<IPessoa> buscarTodas() throws ErroDAO {
		try {
			Connection con = fabrica.getConnection();
			PreparedStatement stm = con.prepareStatement("select * from pessoa");

			ResultSet rs = stm.executeQuery();
			
			List<IPessoa> listPessoa = new ArrayList<IPessoa>();
			
			while(rs.next()){
				Pessoa aPessoa = new Pessoa();
				aPessoa.setId(rs.getInt("id"));
				aPessoa.setNome(rs.getString("nome"));
				aPessoa.setSalario(rs.getDouble("salario"));
				aPessoa.setRg(rs.getInt("rg"));
				aPessoa.setTipo(rs.getString("tipo"));
				aPessoa.setIdade(rs.getInt("idade"));
				listPessoa.add(aPessoa);
			}
			
			return listPessoa;
		} catch (ErroNaConexao | SQLException e) {
			throw new ErroDAO(e.getMessage());
		}
	}
}
