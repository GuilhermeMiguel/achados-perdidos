package email;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EnviadorEmail {

	public void enviarEmailSenha(String nome, String emailFuncionario, String senha) {
		
		 try {
	            Email email = new SimpleEmail();
	            email.setHostName("smtp.googlemail.com");
	            email.setSmtpPort(465);
	            email.setAuthenticator(new DefaultAuthenticator("gui.miguel99@gmail.com", "gui.nando1802"));
	            email.setSSLOnConnect(true);

	            email.setFrom("gui.miguel99@gmail.com");
	            email.setSubject("Recuperação da Senha - SysLF");
	            email.setMsg("Olá " + nome+ " esta mensgem é da equipe do SysLF a sua senha é: " +senha );
	            email.addTo(emailFuncionario);
	            email.send();

	        } catch (EmailException e) {
	            e.printStackTrace();
	        }
	}
	
	
	public void enviarEmailSecretaria(String nome, String objeto) {
		
		 try {
	            Email email = new SimpleEmail();
	            email.setHostName("smtp.googlemail.com");
	            email.setSmtpPort(465);
	            email.setAuthenticator(new DefaultAuthenticator("springbootalura@gmail.com.br", "springboot"));
	            email.setSSLOnConnect(true);

	            email.setFrom("springbootalura@gmail.com.br");
	            email.setSubject("Recuperação da Senha");
	            email.setMsg("Olá sou" +nome+ "meu objeto está na secretária de serviços!");
	            email.addTo("fateczlsolicitacaodedocumento@gmail.com");
	            email.send();

	        } catch (EmailException e) {
	            e.printStackTrace();
	        }
	}
}
