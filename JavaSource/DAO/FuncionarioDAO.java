package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import modelo.Funcionario;


public class FuncionarioDAO {

	private static FuncionarioDAO instance;

	private FuncionarioDAO() {
	}

	public static FuncionarioDAO getInstance() {
		if (instance == null) {
			instance = new FuncionarioDAO();
		}

		return instance;
	}
	
	public void create(Funcionario f) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO funcionario (nome, sexo, telefone, usuario, senha, email, cargo)VALUES(?,?,?,?,?,?,?)";

		try {

			stmt = con.prepareStatement(sql);
					
			stmt.setString(1, f.getNome());
			stmt.setString(2, f.getSexo());
			stmt.setString(3, f.getTelefone());
			stmt.setString(4, f.getUsuario());
			stmt.setString(5, f.getSenha());
			stmt.setString(6, f.getEmail());
			stmt.setString(7, f.getCargo());
			
			stmt.executeUpdate();

			System.out.println("Salvo com sucesso");

		} catch (SQLException ex) {
			
			System.out.println("Erro ao salvar: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public List<Funcionario> pesquisaFuncionario(String opcao) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Funcionario> PesquisaFuncionarios = new ArrayList<>();

		String sql;
		Funcionario funcionario = new Funcionario();
		if(opcao.matches("f@zl")) {
			sql = "SELECT * FROM funcionario where usuario = ?";
		}
		else {
			sql = "SELECT * FROM funcionario where email = ?";
		}

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, opcao);
			rs = stmt.executeQuery();

			while (rs.next()) {
		
				funcionario.setId(rs.getInt("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setTelefone(rs.getString("telefone"));
				funcionario.setSexo(rs.getString("sexo"));
				funcionario.setUsuario(rs.getString("usuario"));
				funcionario.setSenhaAntiga(rs.getString("senha"));
				funcionario.setEmail(rs.getString("email"));
				funcionario.setCargo(rs.getString("cargo"));
				PesquisaFuncionarios.add(funcionario);
			}

		} catch (SQLException ex) {
			System.out.println("Erro" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return PesquisaFuncionarios;
	}
	
	public void update(Funcionario f) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "UPDATE funcionario SET nome = ?, sexo = ?, telefone = ?, usuario = ?, email = ?, cargo = ? WHERE id = ?";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, f.getNome());
			stmt.setString(2, f.getSexo());
			stmt.setString(3, f.getTelefone());
			stmt.setString(4, f.getUsuario());
			stmt.setString(5, f.getEmail());
			stmt.setString(6, f.getCargo());
			stmt.setInt(7, 1);//Alterar para pegar o id do usuario
			stmt.executeUpdate();
			System.out.println("Atualizado com sucesso");

		} catch (SQLException ex) {
			System.out.println("Erro ao atualizar: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public void updateSenha(String  senha, int id) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "UPDATE funcionario SET senha = ? WHERE id = ?";

		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, senha);
			stmt.setInt(2, 1);
			stmt.executeUpdate();
			System.out.println("Atualizado com sucesso");

		} catch (SQLException ex) {
			System.out.println("Erro ao atualizar: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	//usar na LoginController
	public boolean funcionarioExiste(String emailorusuario, String senha, String opcao) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean resultado = false;
		String opcaoUsuario = opcao; 
		
		String sql = "SELECT email, senha FROM funcionario WHERE " +opcaoUsuario+ " = ? and senha = ? ";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, emailorusuario);
			stmt.setString(2, senha);
		    rs = stmt.executeQuery();
			while (rs.next()) {
				resultado = true;
			}

		} catch (SQLException ex) {
			System.out.println("Erro" + ex);
			
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return resultado;
	}

	public String retornaSenha(String email) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String retornaSenha = "";
		
		String sql = "SELECT senha FROM funcionario where email = ?";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, email);
			rs = stmt.executeQuery();

			while (rs.next()) {
				retornaSenha = rs.getString("senha");
			}

		} catch (SQLException ex) {
			System.out.println("Erro" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return retornaSenha;
	}

	public boolean emailExiste(String email) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean resultado = false;
		Funcionario funcionario = new Funcionario();
		
		String sql = "SELECT email FROM funcionario WHERE email = ? ";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, email);
		    rs = stmt.executeQuery();
			while (rs.next()) {
				funcionario.setEmail(rs.getString("email"));
				resultado = true;
			}

		} catch (SQLException ex) {
			System.out.println("Erro" + ex);
			
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return resultado;
	}

	public int retornaId(String email) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int idRetornado = 0;
		
		String sql = "SELECT id FROM funcionario WHERE email = ? ";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, email);
		    rs = stmt.executeQuery();
			while (rs.next()) {
				idRetornado = rs.getInt("id");
			}

		} catch (SQLException ex) {
			System.out.println("Erro" + ex);
			
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return idRetornado;
	}

	public void emailLogado(String email) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO emailLogado (email) VALUES(?)";

		try {

			stmt = con.prepareStatement(sql);
					
			stmt.setString(1, email);
			
			stmt.executeUpdate();

			System.out.println("Salvo com sucesso");

		} catch (SQLException ex) {
			
			System.out.println("Erro ao salvar: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public String retornaEmail () {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String emailRetornado = "";
		
		//Funcionario funcionario = new Funcionario();
		String sql = "SELECT email FROM emailLogado where id = (select max(id) from emailLogado)";

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				emailRetornado = rs.getString("email");
			}

		} catch (SQLException ex) {
			System.out.println("Erro" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return emailRetornado;
	}

	public void limparEmail() {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "delete tabela where id = (select max(id) from emailLogado)";

		try {
			stmt = con.prepareStatement(sql);
			stmt.executeUpdate();

			System.out.println("Salvo com sucesso");

		} catch (SQLException ex) {
			
			System.out.println("Erro ao salvar: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
	}
}
