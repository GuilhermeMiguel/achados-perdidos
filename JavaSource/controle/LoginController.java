package controle;

import javax.faces.context.FacesContext;

import DAO.FuncionarioDAO;
import modelo.Funcionario;

public class LoginController {

	private Funcionario funcionario;
	private FuncionarioDAO funcionarioDAO = FuncionarioDAO.getInstance();
	
	
	public LoginController() {
		funcionario = new Funcionario();
	}


	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
	public String efetuaLogin() {
		System.out.println("Fazendo Login do usuário " + funcionario.getEmail());

		StringBuilder regexEmail = new StringBuilder("/[a-z0-9!#$%&'*+/=?^_`{|}~-]");
		regexEmail.append("+(?:\\\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*");
		regexEmail.append("@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)");
		regexEmail.append("+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/");
		
		boolean existe = false;
		
		if(funcionario.getEmail().length() > 0 && funcionario.getEmail().matches(regexEmail.toString())) {
			existe = funcionarioDAO.funcionarioExiste(funcionario.getEmail(), funcionario.getSenha(), "email");
			
		}
		else if(funcionario.getEmail().length() > 0 && funcionario.getEmail().matches(regexEmail.toString())){
			existe = funcionarioDAO.funcionarioExiste(funcionario.getEmail(), funcionario.getSenha(), "user");
		}
		else {
			//Retornar mensagem caso usuario não exista!!!
		}
		
		if(existe == true) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getSessionMap().put("usuarioLogado", this.funcionario);
			return "dashboard.xhtml";
		}
		
		return "";
	}
	
	
	public String deslogar() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("usuarioLogado"); //remove a referência do login 
		return "index?faces-redirect=true";
	}
}
