package view;

import javax.swing.*;
import java.awt.*;

public class ContactView extends JDialog {

    private JLabel firstNameLabel = new JLabel("Name:");
    private JLabel lastNameLabel = new JLabel("Surname:");
    private JLabel emailLabel = new JLabel("Email:");

    private JTextField firstNameField = new JTextField(15);
    private JTextField lastNameField = new JTextField(15);
    private JTextField emailField = new JTextField(15);

    private JButton addButton = new JButton("Add");
    private JButton cancelButton = new JButton("Cancel");

    public ContactView(JFrame parent) {
        super(parent, "Add New Contact", true);
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(300, 200));
        setLocationRelativeTo(parent);

        //DATA ENTRY PANEL
        JPanel dataPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        //Name Label
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        dataPanel.add(firstNameLabel, gbc);
        //Name Field
        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.EAST;
        dataPanel.add(firstNameField, gbc);
        //Surname Label
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        dataPanel.add(lastNameLabel, gbc);
        //Surname Field
        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.EAST;
        dataPanel.add(lastNameField, gbc);
        //Email Label
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        dataPanel.add(emailLabel, gbc);
        //Email Field
        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.EAST;
        dataPanel.add(emailField, gbc);

        //BUTTON PANEL
        JPanel buttonPanel = new JPanel();
        //  Add Button
        addButton.setBackground(Color.WHITE);
        addButton.setFocusPainted(false);
        buttonPanel.add(addButton);
        //  Cancel Button
        cancelButton.setBackground(Color.WHITE);
        cancelButton.setFocusPainted(false);
        buttonPanel.add(cancelButton);
        //  Init
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.SOUTH;

        //INIT
        add(dataPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }

    //ACTIONS
    public void setAddAction(Runnable action) {
        addButton.addActionListener(e -> action.run());
    }
    public void setCancelAction(Runnable action) {
        cancelButton.addActionListener(e -> action.run());
    }

    //GETTERS
    public JTextField getFirstNameField() {
        return firstNameField;
    }
    public JTextField getLastNameField() {
        return lastNameField;
    }
    public JTextField getEmailField() {
        return emailField;
    }
}
