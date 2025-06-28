package model;

import java.io.Serializable;

public class Mail implements Serializable {
    private String recipient;
    private String subject;
    private String body;

    public Mail(String recipient, String subject, String body) {
        this.recipient = recipient;
        this.subject = subject;
        this.body = body;
    }

    //GETTERS
    public String getRecipient() {
        return recipient;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return getSubject();
    }
}
