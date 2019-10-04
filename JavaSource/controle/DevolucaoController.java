package controle;

import Service.DevolucaoService;

public class DevolucaoController {

	DevolucaoService devService = new DevolucaoService();
	
	public void Devolucao() {
		devService.Devolucao();
	}
}
