package Task3;

import javax.swing.*;
import java.awt.*;

public class ContactManagementSystem extends JFrame {

    ContactManagementSystem(){


        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);
        JPanel contactView = new JPanel();
        JPanel detailView = new JPanel();
        JPanel contactCreationForm = new JPanel();


        JButton next = new JButton("Next");
        contactView.add(next);


        mainPanel.add(contactView,"contactView");
        mainPanel.add(detailView,"detailView");
        mainPanel.add(contactCreationForm,"contactCreationForm");









        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,300);
        add(mainPanel);
    }
}
