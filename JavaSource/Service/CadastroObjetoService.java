package Service;

import DAO.CadastroObjetoDAO;
import modelo.CadastroObjeto;

public class CadastroObjetoService {

	CadastroObjeto cadObjeto;
	CadastroObjetoDAO ObjetoDAO = CadastroObjetoDAO.getInstance();
	
	
	public CadastroObjetoService() {
		cadObjeto = new CadastroObjeto();
	}
	
	public void cadastraObjeto() {
		ObjetoDAO.create(cadObjeto);
	}
	
	public void atualizaObjeto() {
		ObjetoDAO.update(cadObjeto);
	}
	
	public void pesquisaObjeto() {
		ObjetoDAO.pesquisaCadastroObjeto();
	}
	
	public void alteraStatusObjeto() {
		ObjetoDAO.alteraStatus(cadObjeto);
	}
}
