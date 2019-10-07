package controle;

import DAO.CategoriaDAO;
import modelo.Categoria;

public class CategoriaController {

	private Categoria categoria;
	private CategoriaDAO categoriaDAO = CategoriaDAO.getInstance();

	public CategoriaController() {
		categoria = new Categoria();
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public void cadastraCategoria() {
		categoriaDAO.create(categoria);
	}
	
	public void atualizaCategoria() {
		categoriaDAO.update(categoria);
	}
	
	public void desativaCategoria() {
		categoriaDAO.desabilitaCategoria(categoria);
	}
	
	public void pesquisaCategoria() {
		categoriaDAO.pesquisaCategoria(categoria.getId());
	}
}
