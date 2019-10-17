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
	
	public void pesquisaDashboard() {
		if(dashboard.getDataInicio() == "" && dashboard.getDataFim() == "") {
			java.util.Date diaHoje = new Date();
			String dataAtual = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(diaHoje);
			dtInicio = dataAtual;
			dtFim = dataAtual;
		}
		else {
			dtInicio = dashboard.getDataInicio();
			dtFim = dashboard.getDataFim();
		}
		
		String[] datasFormatadas = new String[2];
		datasFormatadas = formataDatas(dtInicio, dtFim);
		
		dtInicio = datasFormatadas[0];
		dtFim = datasFormatadas[1];
		
		dashDAO.retornoPerdidos(dtInicio, dtFim);
		dashDAO.retornoDevolvidos(dtInicio, dtFim);
		dashDAO.retornoDoados(dtInicio, dtFim);
		dashDAO.retornoReciclados(dtInicio, dtFim);
		
		dashDAO.rankingCategorias(dtInicio, dtFim);
		
	}
	
	public String[] formataDatas(String dtIn, String dtFim) {
		String[] datas = new String[2];
        datas[0] = dtIn.substring(6, 4) + "-" + dtIn.substring(3, 2) + "-"
                        + dtIn.substring(0, 2);

        datas[1] = dtFim.substring(6, 4) + "-" + dtFim.substring(3, 2) + "-"
                      + dtFim.substring(0, 2);
        return datas;
	}
}
