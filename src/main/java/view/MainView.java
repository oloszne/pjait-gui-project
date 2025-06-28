package view;

import model.Mail;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainView extends JFrame {
    private JButton createEmailButton = new JButton("New email");
    private JButton createContactButton = new JButton("Add contact");
    private JLabel clockLabel = new JLabel("00:00:00");

    private DefaultListModel<Mail> sentListModel = new DefaultListModel<>();
    private JList<Mail> sentList = new JList<>(sentListModel);

    private JLabel recipientLabel = new JLabel("TO: ");
    private JTextField recipientField = new JTextField();
    private JLabel subjectLabel = new JLabel("SUBJECT: ");
    private JTextField subjectField = new JTextField();
    private JScrollPane messageScrollPane = new JScrollPane();
    private JTextArea messageArea = new JTextArea();

    public MainView() {
        super("PJAIT MAIL");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 500);
        setMinimumSize(new Dimension(700, 500));
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        //NORTH
        JPanel topPanel = new JPanel(new BorderLayout());
        //  Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        //  Mail Button
        createEmailButton.setBackground(Color.WHITE);
        createEmailButton.setFocusPainted(false);
        createEmailButton.setIcon(new ImageIcon(getClass().getResource("/mail-plus.png")));
        buttonPanel.add(createEmailButton);
        //  Contact Button
        createContactButton.setBackground(Color.WHITE);
        createContactButton.setFocusPainted(false);
        createContactButton.setIcon(new ImageIcon(getClass().getResource("/user-plus.png")));
        buttonPanel.add(createContactButton);
        //  Init
        topPanel.add(buttonPanel, BorderLayout.WEST);
        topPanel.add(clockLabel, BorderLayout.EAST);

        //WEST
        JPanel westPanel = new JPanel(new BorderLayout());
        //  Sent emails label
        JLabel sentLabel = new JLabel("Sent Emails:");
        westPanel.add(sentLabel, BorderLayout.NORTH);
        //  Sent emails list
        JScrollPane listScroll = new JScrollPane(sentList);
        sentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //  Init
        westPanel.setPreferredSize(new Dimension(205, getHeight()));
        westPanel.add(listScroll, BorderLayout.CENTER);

        //CENTER
        JPanel centerPanel = new JPanel(new BorderLayout());
        JPanel infoPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        //  Info panel
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        //  Labels
        gbc.gridx = 0;
        gbc.gridy = 0;
        infoPanel.add(recipientLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        infoPanel.add(subjectLabel, gbc);
        //  Text fields
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(3, 25, 3, 3);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 0.5;
        recipientField.setEditable(false);
        recipientField.setEnabled(false);
        infoPanel.add(recipientField, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 0.5;
        subjectField.setEditable(false);
        subjectField.setEnabled(false);
        infoPanel.add(subjectField, gbc);
        //  Text area
        messageArea.setEditable(false);
        messageScrollPane.setViewportView(messageArea);
        //  Init
        centerPanel.add(infoPanel, BorderLayout.NORTH);
        centerPanel.add(messageScrollPane, BorderLayout.CENTER);

        //INIT
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(westPanel, BorderLayout.WEST);
    }

    //ACTIONS
    //  Create email button
    public void setCreateEmailAction(Runnable action) {
        createEmailButton.addActionListener(e -> action.run());
    }
    //  Add contact button
    public void setCreateContactAction(Runnable action) {
        createContactButton.addActionListener(e -> action.run());
    }
    //  Selection in sent list
    public void setSentListSelectionAction(Runnable action) {
        sentList.addListSelectionListener(e -> {
                action.run();
        });
    }

    //CLOCK
    public void updateClock(String time) {
        clockLabel.setText(time);
    }

    //SENT LIST
    public void setSentListData(ArrayList<Mail> sentEmails) {
        for (Mail mail : sentEmails) {
            sentListModel.add(0, mail);
        }
    }
    public void addSentListData(Mail mail) {
        sentListModel.add(0, mail);
    }
    public Mail getSelectedMail() {
        return sentList.getSelectedValue();
    }

    //SETTERS FOR INFO PANEL
    public void setRecipient(String recipient) {
        recipientField.setText(recipient);
    }
    public void setSubject(String subject) {
        subjectField.setText(subject);
    }
    public void setMessage(String message) {
        messageArea.setText(message);
    }

}