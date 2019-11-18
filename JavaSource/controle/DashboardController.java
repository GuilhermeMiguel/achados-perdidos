package controle;

import java.util.ArrayList;
import java.util.List;

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
	List<Integer> mesesPerdidos = new ArrayList<>();
	List<Integer> mesesDevolvidos = new ArrayList<>();
	
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
		
		
		mesesPerdidos = dashDAO.retornoGraficoPerdidos(dtFim.substring(6, 10));
		
		mesesDevolvidos = dashDAO.retornoGraficoDevolvidos(dtFim.substring(6, 10));
		
		//String[] meses = new String[12];
		
		//meses = dashDAO.retornoGraficoPerdidos(dtFim.substring(6, 10));
		
		//dashDAO.retornoGraficoDevolvidos(dtFim.substring(6, 10));
		
		String[] datasFormatadas = new String[2];
		datasFormatadas = formataDatas(dtInicio, dtFim);
		
		dtInicio = datasFormatadas[0];
		dtFim = datasFormatadas[1];
		
		dashboard.setQuantPerdidos(dashDAO.retornoPerdidos(dtInicio, dtFim));
		dashboard.setQuantDevolvidos(dashDAO.retornoDevolvidos(dtInicio, dtFim));
		dashboard.setQuantDoados(dashDAO.retornoDoados(dtInicio, dtFim));
		dashboard.setQuantReciclados(dashDAO.retornoReciclados(dtInicio, dtFim));
		
		dashboard.setQuantLocal((dashDAO.retornoLocal(dtInicio, dtFim)));
		
		dashboard.setQuantCategoria(dashDAO.retornoCategoria(dtInicio, dtFim));
		
		
		//AGORA VER COMO EU PEGO NO FRONT END OS VALORES REFERETES A ESSE LIST QUE CRIEI 
		
		//DAR UMA OLHADA NESSE LINK:
		
		//https://stackoverflow.com/questions/8637285/get-specific-element-in-a-list-or-array-using-el
		
		//https://www.guj.com.br/t/pegar-atributo-de-list-que-esta-dentro-de-outro-list-no-jsf/162622/4
			
			
		//mesesGraficoDashboard dashboardGrafico = new mesesGraficoDashboard();
		
		//dashboardGrafico.setJaneiro(meses[12]);
		
		//dashboardGrafico.getMesesDevolvidos();
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
