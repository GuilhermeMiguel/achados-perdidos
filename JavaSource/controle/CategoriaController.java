package controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAO.CategoriaDAO;
import modelo.Categoria;

@ManagedBean
@SessionScoped
public class CategoriaController {

	private List<Categoria> categoriaList;
	private Categoria categoria;
	private CategoriaDAO categoriaDAO = CategoriaDAO.getInstance();

	boolean categoriaExiste;
	
	
	public CategoriaController() {
		categoria = new Categoria();
		//exibeListaCategorias();
	}
	

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
		
	public List<Categoria> getCategoriaList() {
		return categoriaList;
	}


	public void setCategoriaList(List<Categoria> categoriaList) {
		this.categoriaList = categoriaList;
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
	
	//Criar um botao na tabela que chama o metodo de pesquisa, ai ele carrega os valores, caso exista, o botao salvar vai 
//atualizar, esse botao vai jogar os valores daquela linha dentro do input e vai chamar o metodo que verifica se categoria
//existe por java
	
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
		categoriaDAO.pesquisaCategoria(categoria.getId());
	}
	
	public void limpaCampos() {
		categoria.setId(0);
		categoria.setDescricao("");
	}
	
	public void exibeListaCategorias() {
		categoriaList = categoriaDAO.read();
	}

}
