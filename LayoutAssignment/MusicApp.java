import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MusicApp extends JFrame{

    JTextField artistField;
    JTextField studioField;
    JComboBox<String> categoryBox;
    JCheckBox availableCheckBox;

    public MusicApp(){

        JLabel label = new JLabel();
        label.setText("My MUSIC CATALOGUE");

        String[] genreList = {"Reggae","Rap","R&B","Ballads"};
        JList<String> list = new JList<String>(genreList);
        list.setSelectedIndex(2);

        JButton submitButton = new JButton();
        submitButton.setBounds(50,50,50,50);
        submitButton.setText("Submit");
        JButton exitButton = new JButton();
        exitButton.setBounds(150,50,50,50);
        exitButton.setText("Exit");


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10,10));
        frame.setVisible(true);
        frame.setSize(500,500);



        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();

        panel1.setBackground(Color.blue);
        panel1.add(label);

        panel2.setBackground(Color.green);
        panel2.add(submitButton);
        panel2.add(exitButton);


        panel3.setBackground(Color.yellow);
        panel3.add(list);

        panel4.setBackground(Color.lightGray);
        panel4.setBounds(100,100,100,100);
        panel4.setLayout(new GridLayout(4,2,50,50));

        panel4.add(new JLabel("Artist Name:"));
        artistField = new JTextField();
        panel4.add(artistField);

        panel4.add(new JLabel("Recording Studio:"));
        studioField = new JTextField();
        panel4.add(studioField);

        panel4.add(new JLabel("Category:"));
        categoryBox = new JComboBox<>(genreList);
        panel4.add(categoryBox);

        availableCheckBox = new JCheckBox("Available");
        panel4.add(new JLabel("Song Available"));
        panel4.add(availableCheckBox);




        frame.add(panel1,BorderLayout.NORTH);
        frame.add(panel2,BorderLayout.SOUTH);
        frame.add(panel3,BorderLayout.WEST);
        frame.add(panel4,BorderLayout.CENTER);



        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSubmitButton();
            }
        });


        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleExitButton();
            }
        });

    }



    private void handleExitButton() {
        System.exit(0);
    }


    private void handleSubmitButton() {

        System.out.println("Artist: " + this.artistField.getText());
        System.out.println("Studio: " + this.studioField.getText());
        System.out.println("Category: " + this.categoryBox.getSelectedItem());
        if (this.availableCheckBox.isSelected()) {
            System.out.println("Available: Yes");
        } else {
            System.out.println("Available: No");
        }
    }




}
