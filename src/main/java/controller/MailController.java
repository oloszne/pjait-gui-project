package controller;

import model.AppData;
import model.Mail;
import model.MailSender;
import view.FeedbackView;
import view.MailView;

import javax.swing.*;

public class MailController implements Initializable {
    private final MainController parentController;
    private final MailView mailView;
    private final AppData appData;
    private final MailSender mailSender;

    public MailController(MainController parentController, JFrame parentFrame, AppData appData) {
        this.parentController = parentController;
        this.mailView = new MailView(parentFrame);
        this.appData = appData;
        this.mailSender = new MailSender();
        initialize();
        mailView.setVisible(true);
    }

    @Override
    public void initialize() {
        //actions
        mailView.setSelectAction(this::selectContact);
        mailView.setSendAction(this::sendEmail);
        mailView.setCancelAction(this::closeMailView);
    }

    private void selectContact() {
        new ContactListController(this, mailView, appData);
    }

    private void sendEmail() {
        if (mailView.getSubject().isEmpty() || mailView.getBody().isEmpty() || mailView.getRecipient().isEmpty()) {
            new FeedbackView(mailView, "Error", "All fields must be filled!").setVisible(true);
            return;
        }

        Mail mail = new Mail(
                mailView.getRecipient(),
                mailView.getSubject(),
                mailView.getBody()
        );

        System.out.println("Sending email to: " + mail.getRecipient());
        new Thread(() -> {
            appData.addMail(mail);
            System.out.println("Mail added to app data: " + mail);
            mailSender.send(mail);
            System.out.println("Mail sent successfully to: " + mail.getRecipient());
        }).start();
        parentController.addLatestMailData(mail);
        mailView.dispose();
    }

    private void closeMailView() {
        mailView.dispose();
    }

    public void setSelectedContactEmail(String selectedContactEmail) {
        mailView.setRecipient(selectedContactEmail);
    }
}