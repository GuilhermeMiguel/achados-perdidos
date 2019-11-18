package controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAO.CategoriaDAO;
import modelo.Categoria;

@ManagedBean
@SessionScoped
public class CategoriaController {

	List<Categoria> categoriaList;
	private Categoria categoria;
	private CategoriaDAO categoriaDAO = CategoriaDAO.getInstance();

	boolean categoriaExiste;
	
	
	public CategoriaController() {
		categoria = new Categoria();
		exibeListaCategorias();
	}
	

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
		
	//Funciona
	public void cadastraCategoria() {
		
		if(!categoriaDAO.categoriaExiste(categoria.getId())){
			categoriaDAO.create(categoria);
			exibeListaCategorias();
		}
		else {
			atualizaCategoria();
		}
	}
		
	public void atualizaCategoria() {
		categoriaDAO.update(categoria);
		exibeListaCategorias();
	}
	
	//Funciona
	public void desabilitaCategoria() {
		categoriaDAO.desabilitaCategoria(categoria.getId());
		exibeListaCategorias();
	}
	
	//Funciona
	public void pesquisaCategoria() {
		if(categoria.getCampo().equals("ID")) {
			categoriaList = categoriaDAO.pesquisaCategoria("id", categoria.getValor());
		}
		else if(categoria.getCampo().equals("Descrição"))  {
			categoriaList = categoriaDAO.pesquisaCategoria("descricao", categoria.getValor());
		}
		else {
			exibeListaCategorias();
		}
	}
	
	public void limpaCampos() {
		categoria.setId(0);
		categoria.setDescricao("");
	}
	
	public void exibeListaCategorias() {
		categoriaList = categoriaDAO.read();
	}

}
