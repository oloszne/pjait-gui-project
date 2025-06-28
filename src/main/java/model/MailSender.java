package model;

import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;

public class MailSender {
    private Mailer mailer;

    public MailSender() {
        this.mailer = MailerBuilder
                .withSMTPServer("smtp.gmail.com", 587, "", "")
                .buildMailer();
    }

    public void send(Mail mail) {
        Email email = EmailBuilder.startingBlank()
                .from("")
                .to(mail.getRecipient())
                .withSubject(mail.getSubject())
                .withPlainText(mail.getBody())
                .buildEmail();

        mailer.sendMail(email);
    }

}
