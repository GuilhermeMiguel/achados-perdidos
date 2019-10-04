package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import enuns.StatusObjeto;
import modelo.CadastroObjeto;

public class CadastroObjetoDAO {

	private static CadastroObjetoDAO instance;

	private CadastroObjetoDAO() {
	}

	public static CadastroObjetoDAO getInstance() {
		if (instance == null) {
			instance = new CadastroObjetoDAO();
		}

		return instance;
	}
	
	public void create(CadastroObjeto c) {
	
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO cadastroObjeto (id, idEntregador, categoria, cor, tamanho, local, turno, infoComplementares ) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

		try {

			stmt = con.prepareStatement(sql);
			stmt.setInt(1, c.getId());
			stmt.setInt(2, c.getIdEntregador());
			stmt.setString(3, c.getCategoria());
			stmt.setString(4, c.getCor());
			stmt.setDouble(5, c.getTamanho());
			stmt.setString(6, c.getLocal());
			stmt.setString(7, c.getTurno());
			stmt.setString(8, c.getInfoComplementares());
			stmt.executeUpdate();

			System.out.println("Salvo com sucesso");

		} catch (SQLException ex) {
			
			System.out.println("Erro ao salvar: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public List<CadastroObjeto> read() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<CadastroObjeto> CadastroObjetos = new ArrayList<>();
		String sql = "SELECT * FROM cadastroObjeto";

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {

				CadastroObjeto CadObj = new CadastroObjeto();
				CadObj.setId(rs.getInt("id"));
				CadObj.setIdEntregador(rs.getInt("identregador"));
				CadObj.setCategoria(rs.getString("categoria"));
				CadObj.setCor(rs.getString("cor"));
				CadObj.setTamanho(rs.getDouble("tamanho"));
				CadObj.setLocal(rs.getString("local"));
				CadObj.setTurno(rs.getString("turno"));
				CadObj.setInfoComplementares(rs.getString("infoComplementares"));
				CadObj.setStatus(StatusObjeto.Aguardando.toString());
				CadastroObjetos.add(CadObj);
			}

		} catch (SQLException ex) {
			System.out.println("Erro" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return CadastroObjetos;
	}
	
	//O list e o pesquisa que nao recebe nada sao iguais
	
	public CadastroObjeto pesquisaCadastroObjeto() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		CadastroObjeto CadObj = new CadastroObjeto();
		String sql = "SELECT * FROM cadastroObjeto";

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {

				CadObj.setId(rs.getInt("id"));
				CadObj.setIdEntregador(rs.getInt("identregador"));
				CadObj.setCategoria(rs.getString("categoria"));
				CadObj.setCor(rs.getString("cor"));
				CadObj.setTamanho(rs.getDouble("tamanho"));
				CadObj.setLocal(rs.getString("local"));
				CadObj.setTurno(rs.getString("turno"));
				CadObj.setInfoComplementares(rs.getString("infoComplementares"));
				CadObj.setStatus(rs.getString("status"));
			}

		} catch (SQLException ex) {
			System.out.println("Erro" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return CadObj;
	}
	
	
	public CadastroObjeto pesquisaCadastroObjeto(int id, String opcaoSelecionada) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		CadastroObjeto CadObj = new CadastroObjeto();
		String campo = opcaoSelecionada;
		String sql = "SELECT * FROM cadastroObjeto where" +campo+ "= ?";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, Integer.toString(id));
			rs = stmt.executeQuery();

			while (rs.next()) {
				CadObj.setId(rs.getInt("id"));
				CadObj.setIdEntregador(rs.getInt("identregador"));
				CadObj.setCategoria(rs.getString("categoria"));
				CadObj.setCor(rs.getString("cor"));
				CadObj.setTamanho(rs.getDouble("tamanho"));
				CadObj.setLocal(rs.getString("local"));
				CadObj.setTurno(rs.getString("turno"));
				CadObj.setInfoComplementares(rs.getString("infoComplementares"));
				CadObj.setStatus(rs.getString("status"));
			}

		} catch (SQLException ex) {
			System.out.println("Erro" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return CadObj;
	}
	
	
	public CadastroObjeto pesquisaCadastroObjeto(String valor, String opcaoSelecionada) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		CadastroObjeto CadObj = new CadastroObjeto();
		String campo = opcaoSelecionada;
		String sql = "SELECT * FROM cadastroObjeto where" +campo+ "= ?";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, valor);
			rs = stmt.executeQuery();

			while (rs.next()) {
				CadObj.setId(rs.getInt("id"));
				CadObj.setIdEntregador(rs.getInt("identregador"));
				CadObj.setCategoria(rs.getString("categoria"));
				CadObj.setCor(rs.getString("cor"));
				CadObj.setTamanho(rs.getDouble("tamanho"));
				CadObj.setLocal(rs.getString("local"));
				CadObj.setTurno(rs.getString("turno"));
				CadObj.setInfoComplementares(rs.getString("infoComplementares"));
				CadObj.setStatus(rs.getString("status"));
			}

		} catch (SQLException ex) {
			System.out.println("Erro" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return CadObj;
	}
	
	
	public void update(CadastroObjeto c) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "UPDATE cadastroObjeto SET identregador = ?, categoria = ?, cor = ?, tamanho = ?,"
				+ "local = ?, turno = ?, infoComplementares = ?, status = ? WHERE id = ?";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, c.getIdEntregador());
			stmt.setString(2, c.getCategoria());
			stmt.setString(3, c.getCor());
			stmt.setDouble(4, c.getTamanho());
			stmt.setString(5, c.getLocal());
			stmt.setString(6, c.getTurno());
			stmt.setString(7, c.getInfoComplementares());
			stmt.setString(8, c.getStatus());
			stmt.setInt(9, c.getId());
			stmt.executeUpdate();
			System.out.println("Atualizado com sucesso");

		} catch (SQLException ex) {
			System.out.println("Erro ao atualizar: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	
	public void alteraStatus(CadastroObjeto c) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "UPDATE cadastroObjeto SET status = ? WHERE id = ?";

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
