package controle;

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
		if(entregador.getCampo().equals("ID")) {
			entregadorDAO.pesquisaEntregador("id", entregador.getValor());
		}
		else if(entregador.getCampo().equals("Sobrenome")){
			entregadorDAO.pesquisaEntregador("sobrenome", entregador.getValor());
		}
		else if(entregador.getCampo().equals("Documento")){
			entregadorDAO.pesquisaEntregador("documento", entregador.getValor());
		}
	}
	
	//Estou utilizando o mesmo botao para cadastrar ou atualizar o entregador, caso ele já exista eu pego
//e redireciono para o metodo de atualizar
	public void cadastraEntregador() {
		if(!entregadorDAO.entregadorExiste(entregador.getDocumento())) {
			entregadorDAO.create(entregador);
		}
		else {
			atualizaEntregador();
		}
	}
	
	public void atualizaEntregador() {
		entregadorDAO.update(entregador);
	}
}
