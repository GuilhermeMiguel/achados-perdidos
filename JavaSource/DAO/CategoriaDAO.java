package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import enuns.StatusCategoria;
import modelo.Categoria;



public class CategoriaDAO {
	
	private static CategoriaDAO instance;

	private CategoriaDAO() {
	}

	public static CategoriaDAO getInstance() {
		if (instance == null) {
			instance = new CategoriaDAO();
		}

		return instance;
	}
	
	public void create(Categoria c) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO categoria (descricao, status) VALUES(?, ?)";

		try {

			stmt = con.prepareStatement(sql);
			stmt.setString(1, c.getDescricao());
			stmt.setString(2, StatusCategoria.Habilitada.toString());
			stmt.executeUpdate();

			System.out.println("Salvo com sucesso");

		} catch (SQLException ex) {
			
			System.out.println("Erro ao salvar: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public List<Categoria> read() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Categoria> categorias = new ArrayList<>();
		String sql = "SELECT * FROM categoria";

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {

				Categoria cat = new Categoria();

				cat.setId(rs.getInt("id"));
				cat.setDescricao(rs.getString("descricao"));
				categorias.add(cat);
			}

		} catch (SQLException ex) {
			System.out.println("Erro" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return categorias;
	}
	
	public Categoria pesquisaCategoria() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		Categoria categoria = new Categoria();
		String sql = "SELECT * FROM categoria";

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {

				categoria.setId(rs.getInt("id"));
				categoria.setDescricao(rs.getString("descricao"));
				
			}

		} catch (SQLException ex) {
			System.out.println("Erro" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return categoria;
	}
	
	public Categoria pesquisaCategoria(String descricao) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		Categoria categoria = new Categoria();
		String sql = "SELECT id, descricao FROM categoria WHERE descricao = ?";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, descricao);
			rs = stmt.executeQuery();

			while (rs.next()) {

				categoria.setId(rs.getInt("id"));
				categoria.setDescricao(rs.getString("descricao"));
				
			}

		} catch (SQLException ex) {
			System.out.println("Erro" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return categoria;
	}
	
	public Categoria pesquisaCategoria(int id) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		Categoria categoria = new Categoria();
		String sql = "SELECT id, descricao FROM categoria WHERE id = ?";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, Integer.toString(id));
			rs = stmt.executeQuery();

			while (rs.next()) {

				//Aluguel aluguel = new Aluguel();

				categoria.setId(rs.getInt("id"));
				categoria.setDescricao(rs.getString("descricao"));
			}

		} catch (SQLException ex) {
			System.out.println("Erro" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return categoria;
	}
	
	public void update(Categoria c) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "UPDATE categoria SET descricao = ? WHERE id = ?";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, c.getDescricao());
			stmt.setInt(2, c.getId());
			stmt.executeUpdate();
			System.out.println("Atualizado com sucesso");

		} catch (SQLException ex) {
			System.out.println("Erro ao atualizar: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

	}
	
	public void desabilitaCategoria(Categoria c) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "UPDATE categoria SET status = ? WHERE id = ?";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, c.getStatus());
			stmt.setInt(2, c.getId());
			stmt.executeUpdate();
			System.out.println("Atualizado com sucesso");

		} catch (SQLException ex) {
			System.out.println("Erro ao atualizar: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
}

