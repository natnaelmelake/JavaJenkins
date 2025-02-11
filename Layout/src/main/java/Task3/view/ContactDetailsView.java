package Task3.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ContactDetailsView extends JPanel {
    private JLabel nameLabel;
    private JLabel phoneLabel;
    private JLabel emailLabel;
    private JButton backButton;

    public ContactDetailsView() {
        setLayout(new GridLayout(4, 1));
        nameLabel = new JLabel();
        phoneLabel = new JLabel();
        emailLabel = new JLabel();
        backButton = new JButton("Back to List");

        add(nameLabel);
        add(phoneLabel);
        add(emailLabel);
        add(backButton);
    }

    public void setContactDetails(String name, String phone, String email) {
        nameLabel.setText("Name: " + name);
        phoneLabel.setText("Phone: " + phone);
        emailLabel.setText("Email: " + email);
    }

    public void addBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }
}
