package Service;

import modelo.DevolucaoObjeto;
import DAO.DevolucaoObjetoDAO;

public class DevolucaoService {

	private DevolucaoObjeto objeto;
	private  DevolucaoObjetoDAO devObjetoDAO = DevolucaoObjetoDAO.getInstance();

	
	public DevolucaoObjeto getObjeto() {
		return objeto;
	}

	public void setObjeto(DevolucaoObjeto objeto) {
		this.objeto = objeto;
	}

	public DevolucaoService() {
		objeto = new DevolucaoObjeto();
	}
	
	public void Devolucao() {
		devObjetoDAO.Devolucao(objeto);
	}
}
