package controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAO.ObjetoDAO;
import modelo.Objeto;

@ManagedBean
@SessionScoped
public class ObjetoController {

	private List<Objeto> objetoList;
	private Objeto objeto;
	private ObjetoDAO objDAO = ObjetoDAO.getInstance();
	
	
	public List<Objeto> getObjetoList() {
		return objetoList;
	}

	public void setObjetoList(List<Objeto> objetoList) {
		this.objetoList = objetoList;
	}

	public Objeto getObjeto() {
		return objeto;
	}

	public void setObjeto(Objeto objeto) {
		this.objeto = objeto;
	}

	public ObjetoController() {
		objeto = new Objeto();
		//objetoLista();
	}
	
	
	
	public void cadastraObjeto() {
		if(!objDAO.objetoExiste(objeto.getId())){
			objDAO.create(objeto);
			objetoLista();
		}
		else {
			atualizaObjeto();
		}
	}
	
	public void atualizaObjeto() {
		objDAO.update(objeto);
		objetoLista();
	}
	
	public void pesquisaObjeto() {
		objDAO.pesquisaCadastroObjeto();
	}
	
	public void objetoLista() {
		objetoList = objDAO.read();
	}
	
}
