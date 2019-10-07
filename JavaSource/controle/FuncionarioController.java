package Controle;

import DAO.FuncionarioDAO;
import modelo.Funcionario;

public class FuncionarioController {

	private Funcionario funcionario;
	private FuncionarioDAO funcionarioDAO = FuncionarioDAO.getInstance();
	
	public FuncionarioController() {
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
