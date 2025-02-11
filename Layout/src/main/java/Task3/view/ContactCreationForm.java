package Task3.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ContactCreationForm extends JPanel {
    private JTextField nameField;
    private JTextField phoneField;
    private JTextField emailField;
    private JButton saveButton;
    private JButton cancelButton;

    public ContactCreationForm() {
        setLayout(new GridLayout(4, 2));
        nameField = new JTextField();
        phoneField = new JTextField();
        emailField = new JTextField();
        saveButton = new JButton("Save Contact");
        cancelButton = new JButton("Cancel");

        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Phone:"));
        add(phoneField);
        add(new JLabel("Email:"));
        add(emailField);
        add(saveButton);
        add(cancelButton);
    }

    public String getName() {
        return nameField.getText();
    }

    public String getPhone() {
        return phoneField.getText();
    }

    public String getEmail() {
        return emailField.getText();
    }

    public void addSaveButtonListener(ActionListener listener) {
        saveButton.addActionListener(listener);
    }

    public void addCancelButtonListener(ActionListener listener) {
        cancelButton.addActionListener(listener);
    }


    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }

    public void setPhoneField(JTextField phoneField) {
        this.phoneField = phoneField;
    }

    public void setEmailField(JTextField emailField) {
        this.emailField = emailField;
    }

    public void setSaveButton(JButton saveButton) {
        this.saveButton = saveButton;
    }

    public void setCancelButton(JButton cancelButton) {
        this.cancelButton = cancelButton;
    }



}

