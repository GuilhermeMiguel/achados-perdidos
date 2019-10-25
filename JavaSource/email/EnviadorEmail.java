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
	            email.setAuthenticator(new DefaultAuthenticator("springbootalura@gmail.com.br", "springboot"));
	            email.setSSLOnConnect(true);

	            email.setFrom("springbootalura@gmail.com.br");
	            email.setSubject("Recuperação da Senha");
	            email.setMsg("Olá " + nome+ "a sua senha é:" +senha );
	            email.addTo(emailFuncionario);
	            email.send();

	        } catch (EmailException e) {
	            e.printStackTrace();
	        }
	}
}
