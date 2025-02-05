import javax.swing.*;
import java.awt.*;

public class LayoutApplication {

    JFrame BorderFrame;
    JButton button1,button2;
    public LayoutApplication()
    {
        this.prepareBorderFrame();
    }

    public JFrame prepareBorderFrame()
    {
        JFrame.setDefaultLookAndFeelDecorated(true);
        BorderFrame = new JFrame("BorderLayout");
        BorderFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        BorderFrame.setLayout(new GridLayout(1,2));

        BorderFrame.add(this.prepareButton1());
        BorderFrame.add(this.prepareButton2());
        BorderFrame.setVisible(true);
        return BorderFrame;
    }

    public JButton prepareButton1()
    {
        button1 = new JButton("Button1");
        return button1;
    }

    public JButton prepareButton2()
    {
        button2 = new JButton("Button2");
        return button2;
    }


}