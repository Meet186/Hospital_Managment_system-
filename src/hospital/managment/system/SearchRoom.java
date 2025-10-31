package hospital.managment.system;

import javax.swing.*;
import java.awt.*;

public class SearchRoom extends JFrame {
    SearchRoom(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JLabel status = new JLabel("Status");
        status.setBounds(250,11,186,20);
        panel.add(status);


        setSize(700,500);
        setLayout(null);
        setLocation(450,250);
        setVisible(true);
    }
    public static void main(String[] args) {
        new SearchRoom();

    }
}
