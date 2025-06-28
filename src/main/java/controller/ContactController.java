package controller;

import model.AppData;
import model.Contact;
import view.ContactView;
import view.FeedbackView;

import javax.swing.*;

public class ContactController implements Initializable {
    private final MainController parentController;
    private final ContactView contactView;
    private final AppData appData;

    public ContactController(MainController parentController,JFrame parentFrame, AppData appData) {
        this.parentController = parentController;
        this.contactView = new ContactView(parentFrame);
        this.appData = appData;
        initialize();
        contactView.setVisible(true);
    }

    @Override
    public void initialize() {
        //actions
        contactView.setAddAction(this::addContact);
        contactView.setCancelAction(this::closeContactView);
    }

    private void addContact() {
        String firstName = contactView.getFirstNameField().getText();
        String lastName = contactView.getLastNameField().getText();
        String email = contactView.getEmailField().getText();

        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
            new FeedbackView(contactView, "Error", "All fields must be filled!").setVisible(true);
            return;
        }

        if (!isValidMail(email)) {
            new FeedbackView(contactView, "Error", "Invalid email format!").setVisible(true);
            return;
        }

        if (appData.contactExists(email)) {
            new FeedbackView(contactView, "Error", "Contact with this email already exists!").setVisible(true);
            return;
        }

        new Thread(() -> {
            Contact newContact = new Contact(firstName, lastName, email);
            appData.addContact(newContact);
        }).start();
        new FeedbackView(contactView, "Success", "Contact added successfully!").setVisible(true);
        contactView.dispose();
    }

    public boolean isValidMail(String mail) {
        return mail.matches("^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    private void closeContactView() {
        contactView.dispose();
    }
}