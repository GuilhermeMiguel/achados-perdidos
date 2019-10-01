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
		
		String sql = "INSERT INTO entregador (id, documento, nome, sobrenome, telefone01, telefone02, turma, turno) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, e.getId());
			stmt.setString(2, e.getDocumento());
			stmt.setString(3, e.getNome());
			stmt.setString(4, e.getSobrenome());
			stmt.setString(5, e.getTelefone01());
			stmt.setString(6, e.getTelefone02());
			stmt.setString(7, e.getTurma());
			stmt.setString(8, e.getTurno());
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
				Ent.setSobrenome(rs.getString("sobrenome"));
				Ent.setTelefone01(rs.getString("telefone01"));
				Ent.setTelefone02(rs.getString("telefone02"));
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
		
		String sql = "UPDATE entregador SET documento = ?, nome = ?, cor = ?, sobrenome = ?,"
				+ "telefone01 = ?, telefone02 = ?, turma = ?, turno = ? WHERE id = ?";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, e.getNome());
			stmt.setString(2, e.getSobrenome());
			stmt.setString(3, e.getTelefone01());
			stmt.setString(4, e.getTelefone02());
			stmt.setString(5, e.getTurma());
			stmt.setString(6, e.getTurno());
			stmt.setInt(7, e.getId());
			stmt.executeUpdate();
			System.out.println("Atualizado com sucesso");

		} catch (SQLException ex) {
			System.out.println("Erro ao atualizar: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

	}
}
