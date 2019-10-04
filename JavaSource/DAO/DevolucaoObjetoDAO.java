package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import modelo.DevolucaoObjeto;

public class DevolucaoObjetoDAO {
	
	private static DevolucaoObjetoDAO instance;

	private DevolucaoObjetoDAO() {
	}

	public static DevolucaoObjetoDAO getInstance() {
		if (instance == null) {
			instance = new DevolucaoObjetoDAO();
		}

		return instance;
	}
	
	public void Devolucao(DevolucaoObjeto d) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO devolucaoObjeto (id, idObjeto, documentoDono, nomeDono, "
				+ "sobrenomeDono, telefoneDono01, telefoneDono02, turmaDono, dataDevolucao)VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {

			stmt = con.prepareStatement(sql);
					
			stmt.setInt(1, d.getId());
			stmt.setInt(2, d.getIdObjeto());
			stmt.setString(3, d.getDocumentoDono());
			stmt.setString(4, d.getNomeDono());
			stmt.setString(5, d.getSobrenomeDono());
			stmt.setString(6, d.getTelefoneDono01());
			stmt.setString(7, d.getTelefoneDono02());
			stmt.setString(8, d.getTurmaDono());
			stmt.setString(9, d.getDataDevolucao());
			stmt.executeUpdate();

			System.out.println("Salvo com sucesso");

		} catch (SQLException ex) {
			
			System.out.println("Erro ao salvar: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public List<DevolucaoObjeto> read() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<DevolucaoObjeto> DevolucaoObjetos = new ArrayList<>();
		String sql = "SELECT * FROM devolucaoObjeto";

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {

				DevolucaoObjeto dev = new DevolucaoObjeto();

				dev.setId(rs.getInt("id"));
				dev.setIdObjeto(rs.getInt("id"));
				dev.setDocumentoDono(rs.getString("DocumentoDono"));
				dev.setNomeDono(rs.getString("NomeDono"));
				dev.setSobrenomeDono(rs.getString("SobrenomeDono"));
				dev.setTelefoneDono01(rs.getString("TelefoneDono01"));
				dev.setTelefoneDono02(rs.getString("TelefoneDono02"));
				dev.setTurmaDono(rs.getString("TurmaDono"));
				dev.setDataDevolucao(rs.getString("DataDevolucao"));
				DevolucaoObjetos.add(dev);
			}

		} catch (SQLException ex) {
			System.out.println("Erro" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return DevolucaoObjetos;
	}
	
	
	public void update(DevolucaoObjeto d) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "UPDATE devolucaoObjeto SET nomeDono = ?, sobrenomeDono = ?, telefoneDono01 = ?,"
				+ " telefoneDono02 = ?, turmaDono = ?, dataDevolucao = ? WHERE id = ? and idObjeto = ?";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, d.getNomeDono());
			stmt.setString(2, d.getSobrenomeDono());
			stmt.setString(3, d.getTelefoneDono01());
			stmt.setString(4, d.getTelefoneDono01());
			stmt.setString(5, d.getTelefoneDono02());
			stmt.setString(6, d.getTurmaDono());
			stmt.setString(7, d.getDataDevolucao());
			stmt.setInt(8, d.getId());
			stmt.setInt(9, d.getIdObjeto());
			stmt.executeUpdate();
			System.out.println("Atualizado com sucesso");

		} catch (SQLException ex) {
			System.out.println("Erro ao atualizar: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

	}
}
