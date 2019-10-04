package controle;

import Service.CadastroObjetoService;

public class CadastroObjetoController {

	CadastroObjetoService cadObjetoService = new CadastroObjetoService();
	
	public void cadastroObjeto() {
		cadObjetoService.cadastraObjeto();
	}

	public void atualizaObjeto() {
		cadObjetoService.atualizaObjeto();
	}
	
	
	public void pesquisaObjeto() {
		
	}
	
	public void alteraStatusObjeto() {
		cadObjetoService.alteraStatusObjeto();
	}

}
