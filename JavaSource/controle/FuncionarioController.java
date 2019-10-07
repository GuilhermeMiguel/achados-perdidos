package controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAO.FuncionarioDAO;
import modelo.Funcionario;

@ManagedBean
@SessionScoped
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
