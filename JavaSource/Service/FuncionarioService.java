package Service;

import DAO.FuncionarioDAO;
import modelo.Funcionario;

public class FuncionarioService {

	private Funcionario funcionario;
	private FuncionarioDAO funcionarioDAO = FuncionarioDAO.getInstance();
	
	public FuncionarioService() {
		funcionario = new Funcionario();
	}
	
	public void cadastraFuncionario() {
		funcionarioDAO.create(funcionario);
	}
	
	public void atualizaFuncionario() {
		funcionarioDAO.update(funcionario);
	}
	
	public void pesquisaFuncionario() {
	
	}
	
	public void desativaFuncionario() {
		
	}
	
}
