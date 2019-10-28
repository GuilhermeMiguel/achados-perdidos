package controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAO.FuncionarioDAO;
import email.EnviadorEmail;
import modelo.Funcionario;

@ManagedBean
@SessionScoped
public class FuncionarioController {

	private Funcionario funcionario;
	private FuncionarioDAO funcionarioDAO = FuncionarioDAO.getInstance();
	
	public FuncionarioController() {
		funcionario = new Funcionario();
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public void cadastraFuncionario() {
		
		if (funcionarioDAO.emailExiste(funcionario.getEmail())) {
			if(verificaEmail(funcionario.getEmail()) && funcionario.getUsuario().contains("f@2@")) {
				funcionarioDAO.create(funcionario);
			}
		}
		else {
			//Retornar mensagem dizendo que há algo errado com email ou usuario
		}
	}
	
	public void atualizaFuncionario() {
		if (verificaEmail(funcionario.getEmail())) {
			if(funcionario.getUsuario().contains("f@2@")) {
				funcionarioDAO.update(funcionario);
			}
		}
	}
	
	public void atualizaSenha() {
		funcionarioDAO.updateSenha(funcionario.getSenha(), funcionario.getId());
	}
	
	public void pesquisaFuncionario() {
		if(funcionario.getEmail() != null ) {
			funcionarioDAO.pesquisaFuncionario(funcionario.getEmail());
		}
		else {
			funcionarioDAO.pesquisaFuncionario(funcionario.getUsuario());
		}
	}
	
	public void desativaFuncionario() {
		
	}
	
	public void recuperarSenha() {
		EnviadorEmail enviaEmail = new EnviadorEmail();
		String senha = 	funcionarioDAO.retornaSenha(funcionario.getEmail());
		enviaEmail.enviarEmailSenha(funcionario.getNome(), funcionario.getEmail(), senha);
	}
	
	public boolean verificaEmail(String email) {
		StringBuilder regexEmail = new StringBuilder("/[a-z0-9!#$%&'*+/=?^_`{|}~-]");
		regexEmail.append("+(?:\\\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*");
		regexEmail.append("@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)");
		regexEmail.append("+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/");
		
		if(funcionario.getEmail().matches(regexEmail.toString())) {
			return true;
		}
		return false;
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
