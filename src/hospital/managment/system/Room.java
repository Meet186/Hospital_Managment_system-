package hospital.managment.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Room extends JFrame {

    JTable tabel;


    Room(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/roomm.png"));
        Image image  = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i1 = new ImageIcon(image);

        JLabel label  = new JLabel(i1);
        label.setBounds(600,200,200,200);
        panel.add(label);

        tabel = new JTable();
        tabel.setBounds(10,40,500,400);
        tabel.setFont(new Font("Tahoma",Font.BOLD,14));
        tabel.setBackground(new Color(90,156,163));
        panel.add(tabel);

        try {
            conn c = new conn();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            tabel.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e ){
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Room No");
        label1.setForeground(Color.DARK_GRAY);
        label1.setBounds(12,15,80,15);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2 = new JLabel("Availablity");
        label2.setForeground(Color.DARK_GRAY);
        label2.setBounds(138,15,80,15);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JLabel label3 = new JLabel("Price");
        label3.setForeground(Color.DARK_GRAY);
        label3.setBounds(261,15,80,15);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);

        JLabel label4 = new JLabel("Type");
        label4.setForeground(Color.DARK_GRAY);
        label4.setBounds(385,15,80,15);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);

        JButton button = new JButton("Back");
        button.setBounds(200,450,120,30);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        panel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(900,600);
        setLayout(null);
        setLocation(300,230);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Room();
    }
}

