package Controle;

import DAO.ObjetoDAO;
import modelo.Objeto;

public class ObjetoController {

	private Objeto cadObjeto;
	private ObjetoDAO objDAO = ObjetoDAO.getInstance();
	
	
	public ObjetoController() {
		cadObjeto = new Objeto();
	}
	
	public void cadastraObjeto() {
		objDAO.create(cadObjeto);
	}
	
	public void atualizaObjeto() {
		objDAO.update(cadObjeto);
	}
	
	public void pesquisaObjeto() {
		objDAO.pesquisaCadastroObjeto();
	}
	
}
