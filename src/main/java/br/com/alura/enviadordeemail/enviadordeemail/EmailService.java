package br.com.alura.enviadordeemail.enviadordeemail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	public void enviar(String nome, String emailDestinatario) {
		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("testemichael85@gmail.com", "senha"));
			email.setSSLOnConnect(true);
			
			email.setFrom("testemichael85@gmail.com");
			email.setSubject("Você foi convidado pelo ListaVip");
			email.setMsg("Olá " + nome + ", você acaba de ser convidado pelo ListaVip");
			email.addTo(emailDestinatario);
			email.send();
			
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}
}
