package email;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EnviadorEmail {

	public void enviar(String nome, String emailDestinatario) {
		
		 try {
	            Email email = new SimpleEmail();
	            email.setHostName("smtp.googlemail.com");
	            email.setSmtpPort(465);
	            email.setAuthenticator(new DefaultAuthenticator("springbootalura@gmail.com.br", "springboot"));
	            email.setSSLOnConnect(true);

	            email.setFrom("springbootalura@gmail.com.br");
	            email.setSubject("Você foi convidado pelo ListaVIP");
	            email.setMsg("Olá " + nome + ". Você acaba de ser convidado pelo ListaVIP.");
	            email.addTo(emailDestinatario);
	            email.send();

	        } catch (EmailException e) {
	            e.printStackTrace();
	        }
	}
}
