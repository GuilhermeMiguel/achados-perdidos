package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionFactory;
import modelo.Entregador;

public class EntregadorDAO {

	private static EntregadorDAO instance;

	private EntregadorDAO() {
	}

	public static EntregadorDAO getInstance() {
		if (instance == null) {
			instance = new EntregadorDAO();
		}

		return instance;
	}
	
	public void create(Entregador e) {
	
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO entregador (documento, nome, telefone, turma, turno) VALUES(?, ?, ?, ?, ?)";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, e.getDocumento());
			stmt.setString(2, e.getNome());
			stmt.setString(4, e.getTelefone());
			stmt.setString(6, e.getTurma());
			stmt.setString(7, e.getTurno());
			stmt.executeUpdate();

			System.out.println("Salvo com sucesso");

		} catch (SQLException ex) {
			
			System.out.println("Erro ao salvar: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	
	
	public Entregador pesquisaEntregador(String valor) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		Entregador Ent = new Entregador();
		String sql = "SELECT * FROM entregador where sobrenome = ?";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, valor);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Ent.setId(rs.getInt("id"));
				Ent.setDocumento(rs.getString("documento"));
				Ent.setNome(rs.getString("nome"));
				Ent.setTelefone(rs.getString("telefone01"));
				Ent.setTurma(rs.getString("turma"));
				Ent.setTurno(rs.getString("turno"));
			}

		} catch (SQLException ex) {
			System.out.println("Erro" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return Ent;
	}
	
	
	public void update(Entregador e) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "UPDATE entregador SET documento = ?, nome = ?"
				+ "telefone = ?, turma = ?, turno = ? WHERE id = ?";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, e.getDocumento());
			stmt.setString(2, e.getNome());
			stmt.setString(4, e.getTelefone());
			stmt.setString(6, e.getTurma());
			stmt.setString(7, e.getTurno());
			stmt.setInt(8, e.getId());
			stmt.executeUpdate();
			System.out.println("Atualizado com sucesso");

		} catch (SQLException ex) {
			System.out.println("Erro ao atualizar: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

	}

	public boolean entregadorExiste(String documento) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean resultado = false;
		
		String sql = "SELECT documento, nome FROM entregador WHERE documento = ? ";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, documento);
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
}
