package controle;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import DAO.FuncionarioDAO;
import email.EnviadorEmail;
import modelo.Funcionario;

@ManagedBean
@SessionScoped
public class LoginController {

	private Funcionario funcionario;
	private FuncionarioDAO funcionarioDAO = FuncionarioDAO.getInstance();
	
	private List<Funcionario> funcionarioList;
	
	FuncionarioController func = new FuncionarioController();
	
	//public String email;
	
	public LoginController() {
		funcionario = new Funcionario();
	}


	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public List<Funcionario> getFuncionarioList() {
		return funcionarioList;
	}

	public void setFuncionarioList(List<Funcionario> funcionarioList) {
		this.funcionarioList = funcionarioList;
	}
	
	public String efetuaLogin() {
		System.out.println("Fazendo Login do usuário " + funcionario.getEmail());

		boolean existe = false;
		
		String userPadrao = "f@zl";
		
		if(funcionario.getEmail().length() > 0 && verificaEmail(funcionario.getEmail())) {
			existe = funcionarioDAO.funcionarioExiste(funcionario.getEmail(), funcionario.getSenha(), "email");
			funcionarioDAO.emailLogado(funcionario.getEmail());
			//func.setEmail(funcionario.getEmail());	
		}
		else if(funcionario.getEmail().length() > 0 && funcionario.getEmail().matches(userPadrao)){
			existe = funcionarioDAO.funcionarioExiste(funcionario.getEmail(), funcionario.getSenha(), "usuario");
			funcionarioDAO.emailLogado(funcionario.getEmail());
			//func.setEmail(funcionario.getEmail());
		}
		else {
			//Retornar mensagem caso usuario não exista!!!
		}
		
		if(existe == true) {

			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getSessionMap().put("funcionarioLogado", this.funcionario);
			
			
			return "/dashboard?faces-redirect=true";
		}
		
		return "";
	}
	
	
	
	public String deslogar() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("funcionarioLogado"); //remove a referência do login 
	//	funcionarioDAO.limparEmail();
		return "index?faces-redirect=true";
	}
	
	public void recuperarSenha() {
		EnviadorEmail enviaEmail = new EnviadorEmail();
		String senha = 	funcionarioDAO.retornaSenha(funcionario.getEmail());
		enviaEmail.enviarEmailSenha("Nome", funcionario.getEmail(), senha);
	}
	
	public boolean verificaEmail(String email) {
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.find();
	}
}
