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
	
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public FuncionarioController() {
		funcionario = new Funcionario();
	}
	
	public void cadastraFuncionario() {
		funcionarioDAO.create(funcionario);
	}
	
	public void atualizaFuncionario() {
		funcionarioDAO.update(funcionario);
	}
	
	public void atualizaSenha() {
		funcionarioDAO.updateSenha(funcionario.getSenha(), funcionario.getId());
	}
	
	public void pesquisaFuncionario() {
		
	}
	
	public void desativaFuncionario() {
		
	}
	
	public void limpaCampos() {
		funcionario.setCargo("");
		funcionario.setTelefone("");
		funcionario.setSexo("");
		funcionario.setNome("");
		funcionario.setEmail("");
		funcionario.setUsuario("");
	}
	
	public void limpaSenha() {
		funcionario.setSenhaAntiga("");
		funcionario.setSenha("");
	}
}
