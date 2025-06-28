package view;

import javax.swing.*;
import java.awt.*;

public class MailView extends JDialog {
    private JLabel recipientLabel = new JLabel("To:");
    private JTextField recipientField = new JTextField(20);
    private JButton selectButton = new JButton("Select");

    private JLabel subjectLabel = new JLabel("Subject:");
    private JTextField subjectField = new JTextField(20);

    private JTextArea bodyArea = new JTextArea(10, 30);
    private JScrollPane bodyScroll = new JScrollPane(bodyArea);

    private JButton sendButton = new JButton("Send");
    private JButton cancelButton = new JButton("Cancel");

    public MailView(JFrame parent) {
        super(parent, "Create New Mail", true);
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(400, 300));
        setLocationRelativeTo(parent);

        //NORTH
        JPanel northPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3, 3, 3, 3);
        gbc.anchor = GridBagConstraints.WEST;
        //  Recipient Label
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        northPanel.add(recipientLabel, gbc);
        //  Recipient Field
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        recipientField.setEditable(false);
        recipientField.setEnabled(false);
        northPanel.add(recipientField, gbc);
        //  Select Button
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        selectButton.setBackground(Color.WHITE);
        selectButton.setFocusPainted(false);
        northPanel.add(selectButton, gbc);
        //  Subject Label
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        northPanel.add(subjectLabel, gbc);
        //  Subject Field
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        northPanel.add(subjectField, gbc);

        //CENTER
        JPanel centerPanel = new JPanel(new BorderLayout());
        bodyArea.setLineWrap(true);
        bodyArea.setWrapStyleWord(true);
        centerPanel.add(bodyScroll, BorderLayout.CENTER);

        //SOUTH
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        //  Send Button
        sendButton.setBackground(Color.WHITE);
        sendButton.setFocusPainted(false);
        southPanel.add(sendButton);
        //  Cancel Button
        cancelButton.setBackground(Color.WHITE);
        cancelButton.setFocusPainted(false);
        southPanel.add(cancelButton);

        //INIT
        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
        pack();
    }

    //ACTIONS
    public void setSelectAction(Runnable action) {
        selectButton.addActionListener(e -> action.run());
    }
    public void setSendAction(Runnable action) {
        sendButton.addActionListener(e -> action.run());
    }
    public void setCancelAction(Runnable action) {
        cancelButton.addActionListener(e -> action.run());
    }

    //GETTERS
    public String getRecipient() {
        return recipientField.getText().trim();
    }
    public String getSubject() {
        return subjectField.getText().trim();
    }
    public String getBody() {
        return bodyArea.getText().trim();
    }

    //SETTERS
    public void setRecipient(String selectedContactEmail) {
        recipientField.setText(selectedContactEmail);
    }
}
