package Task3;

import Task3.controller.ContactController;
import Task3.model.ContactManager;
import Task3.view.ContactCreationForm;
import Task3.view.ContactDetailsView;
import Task3.view.ContactListView;

import javax.swing.*;



import java.awt.*;

public class ContactManagementApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Contact Management System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            CardLayout cardLayout = new CardLayout();
            JPanel mainPanel = new JPanel(cardLayout);

            // Create the model
            ContactManager contactManager = new ContactManager();

            // Create the views
            ContactListView contactListView = new ContactListView();
            ContactDetailsView contactDetailsView = new ContactDetailsView();
            ContactCreationForm contactCreationForm = new ContactCreationForm();

            // Add views to the main panel
            mainPanel.add(contactListView, "ContactListView");
            mainPanel.add(contactDetailsView, "ContactDetailsView");
            mainPanel.add(contactCreationForm, "ContactCreationForm");

            // Create the controller
            new ContactController(contactManager, contactListView, contactDetailsView, contactCreationForm, mainPanel, cardLayout);

            // Add the main panel to the frame
            frame.add(mainPanel);
            frame.setVisible(true);
        });
    }
}
