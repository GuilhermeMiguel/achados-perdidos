package controle;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import DAO.FuncionarioDAO;
import modelo.Funcionario;

@ManagedBean
@SessionScoped
public class FuncionarioController {

	private Funcionario funcionario;
	private FuncionarioDAO funcionarioDAO = FuncionarioDAO.getInstance();

	private String email;

	List<Funcionario> funcionarioList = new ArrayList<>();

	public FuncionarioController() {
		funcionario = new Funcionario();
		pesquisaFuncionario();
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void pesquisaFuncionario() {
		try {
			// Estou levando em consideração que o cookie foi criado e está tudo certo
			Cookie[] cookie = capturaCookie();
			String email = cookie[0].getValue().replace("%40", "@");
			funcionarioList = funcionarioDAO.pesquisaFuncionario(email);
			funcionario.setCargo(funcionarioList.get(0).getCargo());
			funcionario.setEmail(funcionarioList.get(0).getEmail());
			funcionario.setNome(funcionarioList.get(0).getNome());
			funcionario.setSenhaAntiga(funcionarioList.get(0).getSenhaAntiga());
			funcionario.setSexo(funcionarioList.get(0).getSexo());
			funcionario.setTelefone(funcionarioList.get(0).getTelefone());
			funcionario.setUsuario(funcionarioList.get(0).getUsuario());
			System.out.println("Esta passando aqui!!!!!!!!!!!!");
		} catch (Exception e) {

		}

	}

	public Cookie[] capturaCookie() {
		FacesContext facesContext = FacesContext.getCurrentInstance();

		HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();

		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("email-usuario")) {
					cookie.getValue();
				}
			}
		}
		return cookies;
	}
	
	
	public void cadastraFuncionario() {

		if (!funcionarioDAO.emailExiste(funcionario.getEmail())) {
			if (verificaEmail(funcionario.getEmail()) && funcionario.getUsuario().contains("f@2@")) {
				funcionarioDAO.create(funcionario);
			}
		} else {
			// Retornar mensagem dizendo que há algo errado com email ou usuario
		}
	}

	public void atualizaFuncionario() {
		if (verificaEmail(funcionario.getEmail())) {
			if (funcionario.getUsuario().contains("f@2@")) {
				funcionarioDAO.update(funcionario);
			}
		}
	}

	public void atualizaSenha() {
		funcionarioDAO.updateSenha(funcionario.getSenha(), funcionario.getId());
	}

	public boolean verificaEmail(String email) {
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.find();
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
