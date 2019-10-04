package controle;

import Service.CategoriaService;

public class CategoriaController {

	CategoriaService catService = new CategoriaService();
		
	public void cadastraCategoria() {
		catService.cadastraCategoria();
		
	}
	
	public void atualizaCategoria() {
		catService.atualizaCategoria();
	
	}
	
	public void desativaCategoria() {
		catService.desativaCategoria();
	}
	
	public void pesquisaCategoria() {
		catService.pesquisaCategoria();
	}
	
}
