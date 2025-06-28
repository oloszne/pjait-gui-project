package view;

import model.Contact;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class ContactListView extends JDialog {
    private DefaultListModel<Contact> contactListModel = new DefaultListModel<>();
    private JList<Contact> contactList = new JList<>(contactListModel);
    private JButton selectButton = new JButton("Select");
    private JButton cancelButton = new JButton("Cancel");

    public ContactListView(JDialog parent) {
        super(parent, "Select Contact", true);
        setLayout(new BorderLayout());
        setSize(300, 200);
        setResizable(false);
        setLocationRelativeTo(getParent());

        //NORTH
        JScrollPane scrollPane = new JScrollPane(contactList);
        scrollPane.setBackground(Color.WHITE);

        //SOUTH
        JPanel southPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3, 3, 3, 3);
        gbc.fill = GridBagConstraints.NONE;
        // Select Button
        gbc.gridx = 0;
        gbc.gridy = 0;
        selectButton.setBackground(Color.WHITE);
        selectButton.setFocusPainted(false);
        southPanel.add(selectButton, gbc);
        // Cancel Button
        gbc.gridx = 1;
        gbc.gridy = 0;
        cancelButton.setBackground(Color.WHITE);
        cancelButton.setFocusPainted(false);
        southPanel.add(cancelButton, gbc);

        //INIT
        add(scrollPane, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    //ACTIONS
    public void setSelectAction(Runnable action) {
        selectButton.addActionListener(e -> action.run());
    }
    public void setCancelAction(Runnable action) {
        cancelButton.addActionListener(e -> action.run());
    }

    //GETTERS
    public String getSelectedContact() {
        Contact selectedContact = contactList.getSelectedValue();
        return selectedContact != null ? selectedContact.getEmail() : null;
    }

    //SETTERS
    public void setContactListData(HashMap<String, Contact> contactNames) {
        for (Contact contact : contactNames.values()) {
            contactListModel.addElement(contact);
        }
    }
}