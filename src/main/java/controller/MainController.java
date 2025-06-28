package controller;

import model.*;
import view.*;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainController implements Initializable, ClockObserver {
    private final MainView mainView;
    private Clock clock;
    private AppData appData;

    public MainController(AppData appData) {
        this.appData = appData;
        this.mainView = new MainView();
        initialize();
        mainView.setVisible(true);
        mainView.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                AppDataLoader.save(appData);
                System.exit(0);
            }
        });
    }

    @Override
    public void initialize() {
        //icon
        ImageIcon icon = new ImageIcon(getClass().getResource("/icon.png"));
        mainView.setIconImage(icon.getImage());
        //actions
        mainView.setCreateEmailAction(this::openMailView);
        mainView.setCreateContactAction(this::openContactView);
        mainView.setSentListSelectionAction(this::showMailDetails);
        //clock
        this.clock = new Clock();
        clock.addObserver(this);
        Thread clockThread = new Thread(clock);
        clockThread.start();
        //sent mails list
        initializeSentListData();
    }

    //BUTTON ACTIONS
    // Create email button
    private void openMailView() {
        new MailController(this, mainView, appData);
    }
    // Add contact button
    private void openContactView() {
        new ContactController(this, mainView, appData);
    }

    //SENT MAILS LIST
    // Initialize
    private void initializeSentListData() {
        mainView.setSentListData(appData.getAllMails());
    }
    // Add latest mail
    void addLatestMailData(Mail mail) {
        mainView.addSentListData(mail);
    }
    // Show mail details
    void showMailDetails() {
        Mail selectedMail = mainView.getSelectedMail();
        if (selectedMail != null) {
            mainView.setRecipient(selectedMail.getRecipient());
            mainView.setSubject(selectedMail.getSubject());
            mainView.setMessage(selectedMail.getBody());
        }
    }

    //CLOCK
    @Override
    public void onTimeUpdate(String time) {
        mainView.updateClock(time);
    }
}
