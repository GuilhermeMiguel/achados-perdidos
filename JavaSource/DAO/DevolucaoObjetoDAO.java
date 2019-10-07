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
				+ "telefoneDono, celularDono, turmaDono, turnoDono, dataDevolucao)VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {

			stmt = con.prepareStatement(sql);
					
			stmt.setInt(1, d.getId());
			stmt.setInt(2, d.getIdObjeto());
			stmt.setString(3, d.getDocumentoDono());
			stmt.setString(4, d.getNomeDono());
			stmt.setString(5, d.getTelefoneDono());
			stmt.setString(6, d.getCelularDono());
			stmt.setString(7, d.getTurmaDono());
			stmt.setString(8, d.getTurnoDono());
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
				dev.setIdObjeto(rs.getInt("idObjeto"));
				dev.setDocumentoDono(rs.getString("DocumentoDono"));
				dev.setNomeDono(rs.getString("NomeDono"));
				dev.setTelefoneDono(rs.getString("TelefoneDono"));
				dev.setCelularDono(rs.getString("CelularDono02"));
				dev.setTurmaDono(rs.getString("TurmaDono"));
				dev.setTurnoDono(rs.getString("TurnoDono"));
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
		
		String sql = "UPDATE devolucaoObjeto SET nomeDono = ?, documentoDono = ?, telefoneDono = ?,"
				+ " celularDono = ?, turmaDono = ?, turnoDono = ?, dataDevolucao = ? WHERE id = ? and idObjeto = ?";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, d.getNomeDono());
			stmt.setString(2, d.getDocumentoDono());
			stmt.setString(3, d.getTelefoneDono());
			stmt.setString(4, d.getCelularDono());
			stmt.setString(5, d.getTurmaDono());
			stmt.setString(6, d.getTurnoDono());
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
