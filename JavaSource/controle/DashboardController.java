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

	Dashboard dash = new Dashboard();
	
	private  DashboardDAO dashDAO = DashboardDAO.getInstance();
	private String dataInicio;
	private String dataFim;
	
	public void pesquisaDashboard() {
		if(dash.getDataInicio() == "" && dash.getDataFim() == "") {
			java.util.Date diaHoje = new Date();
			String dataAtual = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(diaHoje);
			dataInicio = dataAtual;
			dataFim = dataAtual;
		}
		else {
			dataInicio = dash.getDataInicio();
			dataFim = dash.getDataFim();
		}
		
		dashDAO.retornoPerdidos(dataInicio, dataFim);
		dashDAO.retornoDevolvidos(dataInicio, dataFim);
		dashDAO.retornoDoados(dataInicio, dataFim);
		dashDAO.retornoReciclados(dataInicio, dataFim);
		
		dashDAO.rankingCategorias(dataInicio, dataFim);
		
	}
}
