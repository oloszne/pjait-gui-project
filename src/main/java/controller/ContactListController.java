package controller;

import model.AppData;
import view.ContactListView;

import javax.swing.*;

public class ContactListController implements Initializable {

    private final MailController parentController;
    private final ContactListView contactListView;
    private final AppData appData;

    public ContactListController(MailController parentController, JDialog parentDialog, AppData appData) {
        this.parentController = parentController;
        this.contactListView = new ContactListView(parentDialog);
        this.appData = appData;
        initialize();
        contactListView.setVisible(true);
    }

    @Override
    public void initialize() {
        //contact list
        contactListView.setContactListData(appData.getAllContacts());
        //actions
        contactListView.setSelectAction(this::selectContact);
        contactListView.setCancelAction(this::closeContactListView);
    }

    private void selectContact() {
        parentController.setSelectedContactEmail(contactListView.getSelectedContact());
        closeContactListView();
    }

    private void closeContactListView() {
        contactListView.dispose();
    }
}