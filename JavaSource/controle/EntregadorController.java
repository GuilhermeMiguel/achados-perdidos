package Controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAO.EntregadorDAO;
import modelo.Entregador;

@ManagedBean
@SessionScoped
public class EntregadorController {

	private Entregador entregador;
	private EntregadorDAO entregadorDAO = EntregadorDAO.getInstance();

	public EntregadorController() {
		entregador = new Entregador();
	}
		
	
	public Entregador getEntregador() {
		return entregador;
	}


	public void setEntregador(Entregador entregador) {
		this.entregador = entregador;
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
