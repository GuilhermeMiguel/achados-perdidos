package controle;

import modelo.DevolucaoObjeto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAO.DevolucaoObjetoDAO;
import DAO.ObjetoDAO;

@ManagedBean
@SessionScoped
public class DevolucaoController {

	private DevolucaoObjeto objeto;
	private  DevolucaoObjetoDAO devObjetoDAO = DevolucaoObjetoDAO.getInstance();
	private  ObjetoDAO objDAO = ObjetoDAO.getInstance();

	
	public DevolucaoObjeto getObjeto() {
		return objeto;
	}

	public void setObjeto(DevolucaoObjeto objeto) {
		this.objeto = objeto;
	}

	public DevolucaoController() {
		objeto = new DevolucaoObjeto();
	}
	
	public void devolucaoObjeto() {
		devObjetoDAO.Devolucao(objeto);
		objDAO.alteraStatus(objeto.getStatus(), objeto.getId());
	}
	
	public void atualizaDevolucaoObjeto() {
		devObjetoDAO.update(objeto);
	}
	
	public void pesquisaDevolucaoObjeto() {

	}
}
