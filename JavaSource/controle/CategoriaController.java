package controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAO.CategoriaDAO;
import modelo.Categoria;

@ManagedBean
@SessionScoped
public class CategoriaController {

	private Categoria categoria;
	private CategoriaDAO categoriaDAO = CategoriaDAO.getInstance();

	boolean categoriaExiste;
	public CategoriaController() {
		categoria = new Categoria();
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
	}
	
	//Funciona
	public void desabilitaCategoria() {
		categoriaDAO.desabilitaCategoria(categoria.getId());
	}
	
	//Funciona
	public void pesquisaCategoria() {
		categoriaDAO.pesquisaCategoria(categoria.getId());
	}
	
	public void limpaCampos() {
		categoria.setId(0);
		categoria.setDescricao("");
	}
}
