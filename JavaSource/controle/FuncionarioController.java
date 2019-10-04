package controle;

import Service.FuncionarioService;

public class FuncionarioController {

	FuncionarioService funService = new FuncionarioService();
	
	public void cadastraUsuario() {
		funService.cadastraFuncionario();
	}
	
	public void atualizaUsuario() {
		funService.atualizaFuncionario();
	}
	
	public void desativaUsuario() {
		
	}
	
	public void pesquisaUsuario() {
		
	}
	
}
