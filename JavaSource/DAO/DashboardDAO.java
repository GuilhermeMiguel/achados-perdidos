package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionFactory;
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
	
	public int retornoPerdidos (String dataInicio, String dataFim) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String dtInicio = dataInicio;
		String dtFim = dataFim;
		
		Dashboard dash = new Dashboard();
		
		String sql = "SELECT COUNT(id) as quantPerdidos FROM objeto where statusObjeto = 'Aguardando' and "
				+ "str_to_date (dataEncontro, '%d/%m/%Y') BETWEEN '" + dtInicio + "' AND '" + dtFim + "';";
		
		if(dtInicio == "" && dtFim == "") {
			sql = "SELECT COUNT(id) as quantPerdidos FROM objeto where statusObjeto = 'Aguardando';";
		}

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
	
	public int retornoDevolvidos (String dataInicio, String dataFim) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String dtInicio = dataInicio;
		String dtFim = dataFim;
		
		Dashboard dash = new Dashboard();
		
		String sql = "SELECT COUNT(id) as quantDevolvidos FROM objeto where statusObjeto = 'Devolvido' and "
				+ "str_to_date (dataEncontro, '%d/%m/%Y') BETWEEN '" + dtInicio + "' AND '" + dtFim + "';";
		
		if(dtInicio == "" && dtFim == "") {
			sql = "SELECT COUNT(id) as quantDevolvidos FROM objeto where statusObjeto = 'Devolvido';";
		}
		
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
	
	public int retornoReciclados (String dataInicio, String dataFim) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		Dashboard dash = new Dashboard();
		
		String dtInicio = dataInicio;
		String dtFim = dataFim;
		
		String sql = "SELECT COUNT(id) as quantReciclados FROM objeto where statusObjeto = 'Reciclado' and "
				+ "str_to_date (dataEncontro, '%d/%m/%Y') BETWEEN '" + dtInicio + "' AND '" + dtFim + "';";
		
		if(dtInicio == "" && dtFim == "") {
			sql = "SELECT COUNT(id) as quantReciclados FROM objeto where statusObjeto = 'Reciclado';";
		}

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
	
	public int retornoDoados (String dataInicio, String dataFim) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String dtInicio = dataInicio;
		String dtFim = dataFim;
		
		Dashboard dash = new Dashboard();
		
		String sql = "SELECT COUNT(id) as quantDoados FROM objeto where statusObjeto = 'Doado' and "
				+ "str_to_date (dataEncontro, '%d/%m/%Y') BETWEEN '" + dtInicio + "' AND '" + dtFim + "';";
		
		if(dtInicio == "" && dtFim == "") {
			sql = "SELECT COUNT(id)  as quantDoados FROM objeto where statusObjeto = 'Doado';";
		}
		
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
	public String retornoLocal (String dataInicio, String dataFim) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		Dashboard dash = new Dashboard();
		String sql =  "SELECT localEncontro as quantLocal FROM objeto GROUP BY localEncontro ORDER BY COUNT(*) DESC LIMIT 1";

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

	public String rankingCategorias(String dataInicio, String dataFim) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		Dashboard dash = new Dashboard();
		String sql = "SELECT categoria, COUNT(categoria) as quantCategoria1 FROM objeto GROUP BY categoria ORDER BY COUNT(*) DESC LIMIT 1;";

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				dash.setQuantCategoria1(rs.getString("quantCategoria1"));
			}

		} catch (SQLException ex) {
			System.out.println("Erro" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return dash.getQuantCategoria1();
	}
	
}
