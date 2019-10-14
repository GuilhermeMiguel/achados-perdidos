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
		
		String sql = "INSERT INTO funcionario (nome, sexo, nascimento, usuario, senha, email, cargo)VALUES(?,?,?,?,?,?,?)";

		try {

			stmt = con.prepareStatement(sql);
					
			stmt.setString(1, f.getNome());
			stmt.setString(2, f.getSexo());
			stmt.setString(3, f.getNascimento());
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
	
	public List<Funcionario> read() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Funcionario> funcionarios = new ArrayList<>();
		String sql = "SELECT * FROM funcionario";

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {

				Funcionario fun = new Funcionario();

				fun.setId(rs.getInt("id"));
				fun.setNome(rs.getString("nome"));
				fun.setNascimento(rs.getString("nascimento"));
				fun.setSexo(rs.getString("sexo"));
				fun.setUsuario(rs.getString("usuario"));
				fun.setSenhaAntiga(rs.getString("senha"));
				fun.setEmail(rs.getString("email"));
				fun.setCargo(rs.getString("cargo"));
				funcionarios.add(fun);
			}

		} catch (SQLException ex) {
			System.out.println("Erro" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return funcionarios;
	}
	
	public Funcionario pesquisaFuncionario() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		Funcionario funcionario = new Funcionario();
		String sql = "SELECT * FROM funcionario";

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
		
				funcionario.setId(rs.getInt("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setNascimento(rs.getString("nascimento"));
				funcionario.setSexo(rs.getString("sexo"));
				funcionario.setUsuario(rs.getString("usuario"));
				funcionario.setSenhaAntiga(rs.getString("senha"));
				funcionario.setEmail(rs.getString("email"));
				funcionario.setCargo(rs.getString("cargo"));
				
			}

		} catch (SQLException ex) {
			System.out.println("Erro" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return funcionario;
	}
	
	public Funcionario pesquisaFuncionario(String opcaoSelecionada, String valor) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		Funcionario funcionario = new Funcionario();
		String campoPesquisa = opcaoSelecionada;
		String sql = "SELECT * FROM funcionario where" +campoPesquisa+ "= ?";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, valor);
			rs = stmt.executeQuery();

			while (rs.next()) {
		
				funcionario.setId(rs.getInt("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setNascimento(rs.getString("nascimento"));
				funcionario.setSexo(rs.getString("sexo"));
				funcionario.setUsuario(rs.getString("usuario"));
				funcionario.setSenhaAntiga(rs.getString("senha"));
				funcionario.setEmail(rs.getString("email"));
				funcionario.setCargo(rs.getString("cargo"));
			}

		} catch (SQLException ex) {
			System.out.println("Erro" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return funcionario;
	}
	
	public void update(Funcionario f) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "UPDATE funcionario SET nome = ?, sexo = ?, nascimento = ?, usuario = ?, senha = ?, email = ?, cargo = ? WHERE id = ?";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, f.getNome());
			stmt.setString(2, f.getSexo());
			stmt.setString(3, f.getNascimento());
			stmt.setString(4, f.getUsuario());
			stmt.setString(5, f.getSenha());
			stmt.setString(6, f.getEmail());
			stmt.setString(7, f.getCargo());
			stmt.setInt(8, f.getId());
			stmt.executeUpdate();
			System.out.println("Atualizado com sucesso");

		} catch (SQLException ex) {
			System.out.println("Erro ao atualizar: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	//usar na LoginController
	public boolean funcionarioExiste(String email, String senha) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean resultado = false;
		Funcionario funcionario = new Funcionario();
		
		String sql = "SELECT email, senha FROM funcionario WHERE email = ? and senha = ? ";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, email);
			stmt.setString(2, senha);
		    rs = stmt.executeQuery();
			while (rs.next()) {
				funcionario.setSenha(rs.getString("senha"));				
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
}
