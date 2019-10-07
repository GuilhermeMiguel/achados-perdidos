package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionFactory;
import modelo.Categoria;
import modelo.Dashboard;

public class DashboardDAO {

	private static DashboardDAO instance;

	private DashboardDAO() {
	}

	public static DashboardDAO getInstance() {
		if (instance == null) {
			instance = new DashboardDAO();
		}

		return instance;
	}
	
	public int retornoPerdidos () {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		Dashboard dash = new Dashboard();
		String sql = "SELECT COUNT(id) FROM objeto where statusObjeto = 'Aguardando'";

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				dash.setQuantPerdidos(rs.getInt("quantPerdidos"));
			}

		} catch (SQLException ex) {
			System.out.println("Erro" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return dash.getQuantPerdidos();
	}
	
	
	public int retornoDevolvidos () {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		Dashboard dash = new Dashboard();
		String sql = "SELECT COUNT(id) FROM objeto where statusObjeto = 'Devolvido'";

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				dash.setQuantDevolvidos(rs.getInt("quantDevolvidos"));
			}

		} catch (SQLException ex) {
			System.out.println("Erro" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return dash.getQuantDevolvidos();
	}
	
	public int retornoReciclados () {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		Dashboard dash = new Dashboard();
		String sql = "SELECT COUNT(id) FROM objeto where statusObjeto = 'Reciclado'";

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				dash.setQuantReciclados(rs.getInt("quantReciclados"));
			}

		} catch (SQLException ex) {
			System.out.println("Erro" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return dash.getQuantReciclados();
	}
	
	public int retornoDoados () {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		Dashboard dash = new Dashboard();
		String sql = "SELECT COUNT(id) FROM objeto where statusObjeto = 'Doado'";

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				dash.setQuantDoados(rs.getInt("quantDoados"));
			}

		} catch (SQLException ex) {
			System.out.println("Erro" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return dash.getQuantDoados();
	}
	
	
	//Arrumar todos esses selects para agregar a data e testar esse retornoLocal
	public String retornoLocal () {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		Dashboard dash = new Dashboard();
		String sql = "SELECT local, SUM( local ) FROM objeto WHERE objeto = "
				+ "( SELECT local FROM objeto GROUP BY objeto ORDER BY COUNT(id) DESC LIMIT 1 )";

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				dash.setQuantLocal(rs.getString("quantLocal"));
			}

		} catch (SQLException ex) {
			System.out.println("Erro" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return dash.getQuantLocal();
	}
	
}
