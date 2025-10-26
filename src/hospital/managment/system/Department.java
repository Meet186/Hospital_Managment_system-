package hospital.managment.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {
    Department(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        panel.setBackground(new Color(90,156,163));
        add(panel);

        JTable tabel = new JTable();
        tabel.setBounds(0,40,700,350);
        tabel.setBackground(new Color(90,156,163));
        tabel.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(tabel);

        try{
            conn c = new conn();
            String q = "select * from department";
            ResultSet resultSet = c.statement.executeQuery(q);
            tabel.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e ){
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Department");
        label1.setForeground(Color.YELLOW);
        label1.setBounds(10,11,105,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2 = new JLabel("Phone Number");
        label2.setForeground(Color.YELLOW);
        label2.setBounds(351,11,150,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

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
        setSize(700,500);
        setLayout(null);
        setLocation(350,250);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Department();
    }
}
