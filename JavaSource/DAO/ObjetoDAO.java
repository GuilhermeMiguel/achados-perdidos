package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import enuns.StatusObjeto;
import modelo.Objeto;

public class ObjetoDAO {

	private static ObjetoDAO instance;

	private ObjetoDAO() {
	}

	public static ObjetoDAO getInstance() {
		if (instance == null) {
			instance = new ObjetoDAO();
		}

		return instance;
	}
	
	public void create(Objeto c) {
	
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO objeto (docEntregador, categoria, cor, tamanho, infoComplementares, localEncontro, dataEncontro, turnoEncontro, statusObjeto) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {

			stmt = con.prepareStatement(sql);
			stmt.setString(1, c.getDocEntregador());
			stmt.setString(2, c.getCategoria());
			stmt.setString(3, c.getCor());
			stmt.setDouble(4, c.getTamanho());
			stmt.setString(5, c.getInfoComplementares());
			stmt.setString(6, c.getLocal());
			stmt.setString(7, c.getDataEncontro());
			stmt.setString(8, c.getTurno());
			stmt.setString(9, StatusObjeto.Aguardando.toString());
			stmt.executeUpdate();

			System.out.println("Salvo com sucesso");

		} catch (SQLException ex) {
			
			System.out.println("Erro ao salvar: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public List<Objeto> read() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Objeto> CadastroObjetos = new ArrayList<>();
		String sql = "SELECT * FROM objeto";

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {

				Objeto CadObj = new Objeto();
				CadObj.setId(rs.getInt("id"));
				CadObj.setDocEntregador(rs.getString("docEntregador"));
				CadObj.setCategoria(rs.getString("categoria"));
				CadObj.setCor(rs.getString("cor"));
				CadObj.setTamanho(rs.getDouble("tamanho"));
				CadObj.setLocal(rs.getString("localEncontro"));
				CadObj.setTurno(rs.getString("turnoEncontro"));
				CadObj.setDataEncontro(rs.getString("dataEncontro"));
				CadObj.setInfoComplementares(rs.getString("infoComplementares"));
				CadObj.setStatus(rs.getString("statusObjeto"));
				CadastroObjetos.add(CadObj);
			}

		} catch (SQLException ex) {
			System.out.println("Erro" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return CadastroObjetos;
	}
	
	
	
	public List<Objeto> pesquisaObjeto(String campo, String valor) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Objeto> CadastroObjetos = new ArrayList<>();
		String campoSelecionado = campo;
		String sql = "SELECT * FROM objeto where " +campoSelecionado+ "= ?";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, valor);
			rs = stmt.executeQuery();
			while (rs.next()) {

				Objeto CadObj = new Objeto();
				CadObj.setId(rs.getInt("id"));
				CadObj.setDocEntregador(rs.getString("docEntregador"));
				CadObj.setCategoria(rs.getString("categoria"));
				CadObj.setCor(rs.getString("cor"));
				CadObj.setTamanho(rs.getDouble("tamanho"));
				CadObj.setLocal(rs.getString("localEncontro"));
				CadObj.setTurno(rs.getString("turnoEncontro"));
				CadObj.setDataEncontro(rs.getString("dataEncontro"));
				CadObj.setInfoComplementares(rs.getString("infoComplementares"));
				CadObj.setStatus(rs.getString("statusObjeto"));
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
	
	
		
	public void update(Objeto c) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "UPDATE Objeto SET identregador = ?, categoria = ?, cor = ?, tamanho = ?,"
				+ "local = ?, turno = ?, infoComplementares = ?, status = ? WHERE id = ?";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, c.getDocEntregador());
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
	
	
	public void alteraStatus(String Status, int id) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "UPDATE cadastroObjeto SET status = ? WHERE id = ?";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, Status);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			System.out.println("Atualizado com sucesso");

		} catch (SQLException ex) {
			System.out.println("Erro ao atualizar: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public boolean objetoExiste(int id) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean resultado = false;
		
		String sql = "SELECT infoComplementares FROM cadastroObjeto WHERE id = ? ";

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

	public List<Objeto> pesquisaObjeto(String cor, String categoria, String dtInicio, String dtFim) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Objeto> CadastroObjetos = new ArrayList<>();
		String sql = "SELECT * FROM objeto where cor = ? categoria = ? and \"\r\n" 
		+	 "str_to_date (dataEncontro, '%d/%m/%Y') BETWEEN '" + dtInicio + "' AND '" + dtFim + "' AND "
				+ "statusObjeto = 'Aguardando'";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, cor);
			stmt.setString(1, categoria);
			rs = stmt.executeQuery();
			while (rs.next()) {

				Objeto CadObj = new Objeto();
				CadObj.setId(rs.getInt("id"));
				CadObj.setDocEntregador(rs.getString("docEntregador"));
				CadObj.setCategoria(rs.getString("categoria"));
				CadObj.setCor(rs.getString("cor"));
				CadObj.setTamanho(rs.getDouble("tamanho"));
				CadObj.setLocal(rs.getString("localEncontro"));
				CadObj.setTurno(rs.getString("turnoEncontro"));
				CadObj.setDataEncontro(rs.getString("dataEncontro"));
				CadObj.setInfoComplementares(rs.getString("infoComplementares"));
				CadObj.setStatus(rs.getString("statusObjeto"));
				CadastroObjetos.add(CadObj);
			}

		} catch (SQLException ex) {
			System.out.println("Erro" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return CadastroObjetos;
	}
	
	
	public List<Objeto> pesquisaObjeto(String documento) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Objeto> CadastroObjetos = new ArrayList<>();
		String sql = "SELECT * FROM objeto where numDocumento = ? AND statusObjeto = 'Aguardando'";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, documento);
			rs = stmt.executeQuery();
			while (rs.next()) {

				Objeto CadObj = new Objeto();
				CadObj.setId(rs.getInt("id"));
				CadObj.setDocEntregador(rs.getString("docEntregador"));
				CadObj.setCategoria(rs.getString("categoria"));
				CadObj.setCor(rs.getString("cor"));
				CadObj.setTamanho(rs.getDouble("tamanho"));
				CadObj.setLocal(rs.getString("localEncontro"));
				CadObj.setTurno(rs.getString("turnoEncontro"));
				CadObj.setDataEncontro(rs.getString("dataEncontro"));
				CadObj.setInfoComplementares(rs.getString("infoComplementares"));
				CadObj.setStatus(rs.getString("statusObjeto"));
				CadastroObjetos.add(CadObj);
			}

		} catch (SQLException ex) {
			System.out.println("Erro" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return CadastroObjetos;
	}
}
