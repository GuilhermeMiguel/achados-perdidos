package controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAO.CategoriaDAO;
import DAO.ObjetoDAO;
import modelo.Objeto;

@ManagedBean
@SessionScoped
public class pesquisaController {

	List<Objeto> objetoList;
	private Objeto objeto;
	private ObjetoDAO objDAO = ObjetoDAO.getInstance();
	private CategoriaDAO categoriaDAO = CategoriaDAO.getInstance();
	private List<String> categoriaList;
	
	public pesquisaController() {
		objeto = new Objeto();
		exibeListaObjetos();
		carregaCombo();
	}

	public Objeto getObjeto() {
		return objeto;
	}

	public void setObjeto(Objeto objeto) {
		this.objeto = objeto;
	}
	
	public List<String> getCategoriaList() {
		return categoriaList;
	}

	public void setCategoriaList(List<String> categoriaList) {
		this.categoriaList = categoriaList;
	}
	
	public void pesquisaObjeto() {
	
	}
	
	public void carregaCombo() {
		categoriaList = categoriaDAO.buscaCategoriaCombo();
	}
	
	public void exibeListaObjetos() {
		objetoList = objDAO.read();
	}
}
