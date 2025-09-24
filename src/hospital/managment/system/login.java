package  hospital.managment.system;

import javax.swing.*;
import java.awt.*;

public class login extends JFrame {

    JTextField textField;
    JPasswordField passwordField;
    JButton b1,b2;


    login(){

        // username filed
        JLabel namelabel = new JLabel("Username");
        namelabel.setBounds(40,20,100,30);
        namelabel.setFont(new Font( "Tahoma",Font.BOLD,16));
        namelabel.setForeground(Color.BLACK);
        add(namelabel);

        // password filed
        JLabel passwordlabel = new JLabel("password");
        passwordlabel.setBounds(40,70,100,30);
        passwordlabel.setFont(new Font( "Tahoma",Font.BOLD,16));
        passwordlabel.setForeground(Color.BLACK);
        add(passwordlabel);

        // create a nameInput
        textField = new JTextField();
        textField.setBounds(150,20,150,30);
        textField.setFont(new Font("Tahoma",Font.PLAIN,15));
        textField.setBackground(new Color(255, 182, 5));
        add(textField);

        // create a passwordInput
        passwordField = new JPasswordField();
        passwordField.setBounds(150,70,150,30);
        passwordField.setFont(new Font("Tahoma",Font.PLAIN,15));
        passwordField.setBackground(new Color(255, 182, 5));
        add(passwordField);

        // upload a logo
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(320,-30,400,300);
        add(label);

        // creating a button
        b1 = new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);

        // content that create a frame
        getContentPane().setBackground(new Color(109, 164, 170));
        setSize(700,300);
        setLocation(400,250);
        setLayout(null);
        setVisible(true);

    }
    public static void main(String[] args) {
        new login();

    }

}
