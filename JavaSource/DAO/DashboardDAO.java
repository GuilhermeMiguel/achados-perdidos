package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public String retornoCategoria(String dataInicio, String dataFim) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		Dashboard dash = new Dashboard();
		String sql =  "SELECT categoria as quantCategoria FROM objeto GROUP BY categoria ORDER BY COUNT(*) DESC LIMIT 1";

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				dash.setQuantCategoria(rs.getString("quantCategoria"));
			}

		} catch (SQLException ex) {
			System.out.println("Erro" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return dash.getQuantCategoria();
	}
	
	//Para o gr�fico
	//
	public List<Integer> retornoGraficoPerdidos (String ano) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String anoEscolhido = ano;
		String sql;
		List<Integer> meses = new ArrayList<>();
		
		for(int i=1; i<=12; i++) {
			
		
		sql = "SELECT * FROM tabela WHERE MONTH(str_to_date (dataEncontro, '%d/%m/%Y')) = '" +i+ "' and "
					+ "YEAR(str_to_date (dataEncontro, '%d/%m/%Y')) = '" +anoEscolhido+ "'"
					+ "and statusObjeto = 'Aguardando'";
		
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				meses.add(rs.getInt("quantDoados"));
			}

			} catch (SQLException ex) {
			System.out.println("Erro" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
	}
	
		return meses;
	}
	
	
	public List<Integer> retornoGraficoDevolvidos (String ano) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String anoEscolhido = ano;
		String sql;
		List<Integer> meses = new ArrayList<>();;
		
		for(int i=1; i<=12; i++) {
			
		
		sql = "SELECT * FROM tabela WHERE MONTH(str_to_date (dataEncontro, '%d/%m/%Y')) = '" +i+ "' and "
					+ "YEAR(str_to_date (dataEncontro, '%d/%m/%Y')) = '" +anoEscolhido+ "'"
					+ "and statusObjeto = 'Devolvido'";
		
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				meses.add(rs.getInt("quantDoados"));
			}

			} catch (SQLException ex) {
			System.out.println("Erro" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
	}
	
		return meses;
	}
}
