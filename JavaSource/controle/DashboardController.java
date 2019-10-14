package controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAO.DashboardDAO;
import modelo.Dashboard;

@ManagedBean
@SessionScoped
public class DashboardController {

	Dashboard dash = new Dashboard();
	
	private  DashboardDAO dashDAO = DashboardDAO.getInstance();
	
	
	public void pesquisaDashboard() {
		dashDAO.retornoPerdidos();
		dashDAO.retornoDevolvidos();
		dashDAO.retornoDoados();
		dashDAO.retornoReciclados();
		
		dashDAO.rankingCategorias();
	}
}
