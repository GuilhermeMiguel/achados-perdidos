package controle;

import java.text.DateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAO.DashboardDAO;
import modelo.Dashboard;

@ManagedBean
@SessionScoped
public class DashboardController {

	Dashboard dashboard = new Dashboard();
	
	private  DashboardDAO dashDAO = DashboardDAO.getInstance();
	private String dtInicio;
	private String dtFim;
	
	
	public DashboardController() {
		pesquisaDashboard();
	}

	public Dashboard getDashboard() {
		return dashboard;
	}

	public void setDashboard(Dashboard dashboard) {
		this.dashboard = dashboard;
	}

	public void pesquisaDashboard() {
		dtInicio = dashboard.getDataInicio();
		dtFim = dashboard.getDataFim();
				
		String[] datasFormatadas = new String[2];
		datasFormatadas = formataDatas(dtInicio, dtFim);
		
		dtInicio = datasFormatadas[0];
		dtFim = datasFormatadas[1];
		
		dashboard.setQuantPerdidos(dashDAO.retornoPerdidos(dtInicio, dtFim));
		dashboard.setQuantDevolvidos(dashDAO.retornoDevolvidos(dtInicio, dtFim));
		dashboard.setQuantDoados(dashDAO.retornoDoados(dtInicio, dtFim));
		dashboard.setQuantReciclados(dashDAO.retornoReciclados(dtInicio, dtFim));
		
		dashboard.setQuantLocal((dashDAO.retornoLocal(dtInicio, dtFim)));
		
		dashboard.setQuantCategoria1(dashDAO.rankingCategorias(dtInicio, dtFim));
		
	}
	
	public String[] formataDatas(String dtIn, String dtFim) {
		String[] datas = new String[2];
		
		if(dtIn == null && dtFim == null || dtIn == "" && dtFim == "") {
			datas[0] = "";
			datas[1] = "";
			return datas;
		}
		
        datas[0] = dtIn.substring(6, 10) + "-" + dtIn.substring(3, 5) + "-"
                        + dtIn.substring(0, 2);

        datas[1] = dtFim.substring(6, 10) + "-" + dtFim.substring(3, 5) + "-"
                      + dtFim.substring(0, 2);
        return datas;
	}
}
