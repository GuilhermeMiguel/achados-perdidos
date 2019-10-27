package controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAO.CategoriaDAO;
import DAO.ObjetoDAO;
import modelo.Categoria;
import modelo.Objeto;

@ManagedBean
@SessionScoped
public class ObjetoController {

	private List<Objeto> objetoList;
	private Objeto objeto;
	private ObjetoDAO objDAO = ObjetoDAO.getInstance();
	private CategoriaDAO categoriaDAO = CategoriaDAO.getInstance();
	private List<String> categoriaList;
	
	
	public ObjetoController() {
		objeto = new Objeto();
		exibeListaObjetos();
		 carregaCombo();
	}
	
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
	
	public List<String> getCategoriaList() {
		return categoriaList;
	}

	public void setCategoriaList(List<String> categoriaList) {
		this.categoriaList = categoriaList;
	}

	public void cadastraObjeto() {
		if(!objDAO.objetoExiste(objeto.getId())){
			objDAO.create(objeto);
			exibeListaObjetos();
		}
		else {
			atualizaObjeto();
		}
	}
	
	public void atualizaObjeto() {
		objDAO.update(objeto);
		exibeListaObjetos();
	}
	
	public void pesquisaObjeto() {
		if(objeto.getCampo().equals("ID")) {
			objetoList = objDAO.pesquisaObjeto("id", objeto.getValor());
		}
		else if(objeto.getCampo().equals("Doc Entregador"))  {
			objetoList = objDAO.pesquisaObjeto("descricao", objeto.getValor());
		}
		else if(objeto.getCampo().equals("Categoria"))  {
			objetoList = objDAO.pesquisaObjeto("categoria", objeto.getValor());
		}
		else if(objeto.getCampo().equals("Cor"))  {
			objetoList = objDAO.pesquisaObjeto("cor", objeto.getValor());
		}
		else if(objeto.getCampo().equals("Tamanho"))  {
			objetoList = objDAO.pesquisaObjeto("tamanho", objeto.getValor());
		}
		else if(objeto.getCampo().equals("Local"))  {
			objetoList = objDAO.pesquisaObjeto("localEncontro", objeto.getValor());
		}
		else if(objeto.getCampo().equals("Turno"))  {
			objetoList = objDAO.pesquisaObjeto("turnoEncontro", objeto.getValor());
		}
		else if(objeto.getCampo().equals("Data"))  {
			objetoList = objDAO.pesquisaObjeto("dataEncontro", objeto.getValor());
		}
		else {
			exibeListaObjetos();
		}
	}
	
	public void exibeListaObjetos() {
		objetoList = objDAO.read();
	}
	
	public void carregaCombo() {
		categoriaList = categoriaDAO.buscaCategoriaCombo();
	}
}
