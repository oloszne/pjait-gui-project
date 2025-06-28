package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class AppData implements Serializable {
    private HashMap<String, Contact> contacts = new HashMap<>();
    private ArrayList<Mail> mails = new ArrayList<>();


    //CONTACT DATA
    public boolean contactExists(String email) {
        return contacts.containsKey(email.toLowerCase());
    }

    public void addContact(Contact contact) {
        contacts.put(contact.getEmail().toLowerCase(), contact);
    }

    public HashMap<String, Contact> getAllContacts() {
        return new HashMap<>(contacts);
    }


    //MAIL DATA
    public void addMail(Mail mail) {
        mails.add(mail);
    }

    public ArrayList<Mail> getAllMails() {
        return new ArrayList<>(mails);
    }
}
