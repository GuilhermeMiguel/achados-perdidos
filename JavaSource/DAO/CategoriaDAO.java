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
	
	
	public List<Categoria> pesquisaCategoria(String campo, String valor) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String campoPesquisado = campo;
		List<Categoria> categorias = new ArrayList<>();
		String sql = "SELECT id, descricao FROM categoria WHERE "+campoPesquisado+"  = ?";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, valor);
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
	
		
	public void update(Categoria c) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "UPDATE categoria SET descricao = ? WHERE id = ?;";

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
	
	public void desabilitaCategoria(int id) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "UPDATE categoria SET status = ? WHERE id = ?";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, StatusCategoria.Desabiliada.toString());
			stmt.setInt(2, id);
			stmt.executeUpdate();
			System.out.println("Categoria desabilitada");

		} catch (SQLException ex) {
			System.out.println("Erro ao atualizar: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public boolean categoriaExiste(int id) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean resultado = false;
		
		String sql = "SELECT descricao FROM categoria WHERE id = ? ";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
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

	public List<String> buscaCategoriaCombo() {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<String> categorias = new ArrayList<>();
		String sql = "SELECT descricao FROM categoria";

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Categoria cat = new Categoria();
				cat.setDescricao(rs.getString("descricao"));
				categorias.add(cat.getDescricao());
			}

		} catch (SQLException ex) {
			System.out.println("Erro" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return categorias;
	}
}

