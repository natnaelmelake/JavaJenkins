package Task3.model;

import java.util.ArrayList;

public class ContactManager {
    private ArrayList<Contact> contacts;

    public ContactManager() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public Contact getContact(int index) {
        return contacts.get(index);
    }
}
