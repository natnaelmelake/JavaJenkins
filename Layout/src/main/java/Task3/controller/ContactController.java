package Task3.controller;
//
//
import Task3.model.Contact;
import Task3.model.ContactManager;
import Task3.view.ContactCreationForm;
import Task3.view.ContactDetailsView;
import Task3.view.ContactListView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.CardLayout;


public class ContactController {
    private ContactManager contactManager;
    private ContactListView contactListView;
    private ContactDetailsView contactDetailsView;
    private ContactCreationForm contactCreationForm;
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public ContactController(ContactManager contactManager,
                             ContactListView contactListView,
                             ContactDetailsView contactDetailsView,
                             ContactCreationForm contactCreationForm,
                             JPanel mainPanel,
                             CardLayout cardLayout) {
        this.contactManager = contactManager;
        this.contactListView = contactListView;
        this.contactDetailsView = contactDetailsView;
        this.contactCreationForm = contactCreationForm;
        this.mainPanel = mainPanel;
        this.cardLayout = cardLayout;

        // Set up action listeners
        setupListeners();
        updateContactList();
    }

    private void setupListeners() {
        contactListView.addAddButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAddButtonClick();
            }
        });

        contactListView.addViewDetailsButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleViewDetailsButton();
            }
        });

        contactDetailsView.addBackButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleBackButtonClick();
            }
        });

        contactCreationForm.addSaveButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSaveButtonClick();
            }
        });

        contactCreationForm.addCancelButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleCancelButtonClick();
            }
        });
    }

    private void handleCancelButtonClick() {
        contactCreationForm.setName("");
        contactCreationForm.setPhoneField(null);
        contactCreationForm.setEmailField(null);
        cardLayout.show(mainPanel, "ContactListView");
    }

    private void handleSaveButtonClick() {
        String name = contactCreationForm.getName();
        String phone = contactCreationForm.getPhone();
        String email = contactCreationForm.getEmail();

        if (name.isEmpty() || phone.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields must be filled out.");
        } else {
            contactManager.addContact(new Contact(name, phone, email));
            contactCreationForm.setNameField(null);
            contactCreationForm.setPhoneField(null);
            contactCreationForm.setEmailField(null);
            updateContactList();
            cardLayout.show(mainPanel, "ContactListView");
        }
    }

    private void handleBackButtonClick() {
        cardLayout.show(mainPanel, "ContactListView");
    }

    private void handleViewDetailsButton() {
        String selectedContactName = contactListView.getSelectedContact();
        if (selectedContactName != null) {
            int index = getContactIndexByName(selectedContactName);
            if (index != -1) {
                Contact contact = contactManager.getContact(index);
                contactDetailsView.setContactDetails(contact.getName(), contact.getPhoneNumber(), contact.getEmail());
                cardLayout.show(mainPanel, "ContactDetailsView");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a contact to view details.");
        }
    }

    private void handleAddButtonClick() {
        cardLayout.show(mainPanel, "ContactCreationForm");
    }

    private void updateContactList() {
        String[] contactNames = contactManager.getContacts().stream()
                .map(Contact::getName)
                .toArray(String[]::new);
        contactListView.setContactListData(contactNames);
    }

    private int getContactIndexByName(String name) {
        for (int i = 0; i < contactManager.getContacts().size(); i++) {
            if (contactManager.getContacts().get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1; // Not found
    }
}
