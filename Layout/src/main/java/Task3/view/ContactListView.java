package Task3.view;

import Task3.model.Contact;
import Task3.model.ContactManager;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;



public class ContactListView extends JPanel {
    private JList<String> contactList;
    private JButton addButton;
    private JButton viewDetailsButton;

    public ContactListView() {
        setLayout(new BorderLayout());
        contactList = new JList<>();
        addButton = new JButton("Add New Contact");
        viewDetailsButton = new JButton("View Details");

        add(new JScrollPane(contactList), BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(viewDetailsButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void setContactListData(String[] contacts) {
        contactList.setListData(contacts);
    }

    public String getSelectedContact() {
        return contactList.getSelectedValue();
    }

    public void addAddButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }

    public void addViewDetailsButtonListener(ActionListener listener) {
        viewDetailsButton.addActionListener(listener);
    }
}
