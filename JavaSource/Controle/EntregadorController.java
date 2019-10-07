package Service;

import DAO.EntregadorDAO;
import modelo.Entregador;

public class EntregadorService {

	private Entregador entregador;
	private EntregadorDAO entregadorDAO = EntregadorDAO.getInstance();

	public EntregadorService() {
		entregador = new Entregador();
	}
		
	
	public void pesquisaEntregador() {
		
	}
	
	public void cadastraEntregador() {
		entregadorDAO.create(entregador);
	}
	
	public void atualizaEntregador() {
		entregadorDAO.update(entregador);
	}
}
