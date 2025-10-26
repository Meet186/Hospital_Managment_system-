package hospital.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.util.Date;

public class NEW_PATIENT extends JFrame implements ActionListener {

    JComboBox comboBox;
    JTextField textFieldNumber = new JTextField();

    JTextField textName = new JTextField();

    JTextField textFieldDisease = new JTextField();

    JTextField textFieldDeposite = new JTextField();

    JLabel date;
    JRadioButton r1, r2;
    Choice c1;
    JButton b1, b2;

    NEW_PATIENT() {

        // CREATE A PANEL
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 540);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        // IMAGE
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/patient.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i1 = new ImageIcon(image);
        JLabel label = new JLabel(i1);
        label.setBounds(550, 150, 200, 200);
        panel.add(label);

        JLabel labelName = new JLabel("NEW PATIENT FORM");
        labelName.setBounds(118, 11, 260, 53);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(labelName);


        // ID FIELD
        JLabel labelID = new JLabel("ID : ");
        labelID.setBounds(35, 76, 200, 14);
        labelID.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelID.setForeground(Color.WHITE);
        panel.add(labelID);

        comboBox = new JComboBox<>(new String[]{"AdharCard", "Voter ID", "Driving License", "PAN Card", "Office ID"});
        comboBox.setBounds(271, 73, 150, 20);
        comboBox.setBackground(Color.GRAY);
        comboBox.setForeground(Color.WHITE);
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(comboBox);


        // NUMBER FIELD
        JLabel labelNumber = new JLabel("Number :  ");
        labelNumber.setBounds(35, 111, 200, 14);
        labelNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelNumber.setForeground(Color.WHITE);
        panel.add(labelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271, 111, 150, 20);
        textFieldNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
        textFieldNumber.setForeground(Color.BLACK);
        panel.add(textFieldNumber);

        // PATIENT_NAME FIELD
        JLabel labelName1 = new JLabel("PATIENT_Name :  ");
        labelName1.setBounds(35, 150, 200, 14);
        labelName1.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelName1.setForeground(Color.WHITE);
        panel.add(labelName1);

        textName = new JTextField();
        textName.setBounds(271, 150, 150, 20);
        textName.setFont(new Font("Tahoma", Font.BOLD, 14));
        textName.setForeground(Color.BLACK);
        panel.add(textName);

        //  GENDER FIELD
        JLabel labelGender = new JLabel("GENDER :  ");
        labelGender.setBounds(35, 200, 200, 14);
        labelGender.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelGender.setForeground(Color.WHITE);
        panel.add(labelGender);

        r1 = new JRadioButton("MALE");
        r1.setFont(new Font("Tahoma", Font.BOLD, 14));
        r1.setForeground(Color.BLACK);
        r1.setBackground(new Color(90, 156, 163));
        r1.setBounds(271, 200, 80, 15);
        panel.add(r1);

        r2 = new JRadioButton("FEMALE");
        r2.setFont(new Font("Tahoma", Font.BOLD, 14));
        r2.setForeground(Color.BLACK);
        r2.setBackground(new Color(90, 156, 163));
        r2.setBounds(350, 200, 95, 15);
        panel.add(r2);

        // DISEASE FIELD
        JLabel labelDisease = new JLabel("DISEASE :  ");
        labelDisease.setBounds(35, 250, 200, 14);
        labelDisease.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelDisease.setForeground(Color.WHITE);
        panel.add(labelDisease);

        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(271, 250, 150, 20);
        textFieldDisease.setFont(new Font("Tahoma", Font.BOLD, 14));
        textFieldDisease.setForeground(Color.BLACK);
        panel.add(textFieldDisease);


        // ROOM
        JLabel labelRoom = new JLabel("ROOM :  ");
        labelRoom.setBounds(35, 300, 200, 14);
        labelRoom.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelRoom.setForeground(Color.WHITE);
        panel.add(labelRoom);

        // ROOMS OPTIONS
        c1 = new Choice();
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from Room");
            while (resultSet.next()) {
                c1.add(resultSet.getString("room_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        c1.setBounds(271, 300, 150, 20);
        c1.setFont(new Font("Tahoma", Font.BOLD, 14));
        c1.setForeground(Color.BLACK);
        c1.setBackground(Color.LIGHT_GRAY);
        panel.add(c1);


        // DATE&TIME

        JLabel labelDate = new JLabel("TIME :  ");
        labelDate.setBounds(35, 350, 200, 14);
        labelDate.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelDate.setForeground(Color.WHITE);
        panel.add(labelDate);

        Date date1 = new Date();
        date = new JLabel("" + date1);
        date.setBounds(271, 350, 250, 14);
        date.setForeground(Color.BLACK);
        date.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(date);

        // DEPOSITE FIELD
        JLabel labelDeposite = new JLabel("DEPOSITE :  ");
        labelDeposite.setBounds(35, 400, 200, 14);
        labelDeposite.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelDeposite.setForeground(Color.WHITE);
        panel.add(labelDeposite);

        textFieldDeposite = new JTextField();
        textFieldDeposite.setBounds(271, 400, 150, 20);
        textFieldDeposite.setFont(new Font("Tahoma", Font.BOLD, 14));
        textFieldDeposite.setForeground(Color.BLACK);
        panel.add(textFieldDeposite);

        // ADD BUTTONS {ADD & BACK}
        b1 = new JButton("ADD");
        b1.setBounds(260, 450, 120, 30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        panel.add(b1);
        b1.addActionListener(this);

        b2 = new JButton("BACK");
        b2.setBounds(400, 450, 120, 30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        panel.add(b2);
        b2.addActionListener(this);


        // create  a boundary layout
        setUndecorated(true);
        setSize(850, 550);
        setLayout(null);
        setLocation(300, 250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new NEW_PATIENT();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            conn c = new conn();
            String radioBTN = null;
            if (r1.isSelected()) {
                radioBTN = "Male";
            } else if (r2.isSelected()) {
                radioBTN = "Female";
            }
            String s1 = (String) comboBox.getSelectedItem();
            String s2 = textFieldNumber.getText();
            String s3 = textName.getText();
            String s4 = radioBTN;
            String s5 = textFieldDisease.getText();
            String s6 = c1.getSelectedItem();
            String s7 = date.getText();
            String s8 = textFieldDeposite.getText();

            try {
                if (s1 == null ||
                        s2 == null ||
                        s3 == null ||
                        s4 == null ||
                        s5 == null ||
                        s6 == null ||
                        s7 == null ||
                        s8 == null
                ) {
                    JOptionPane.showMessageDialog(null,"Field is empty");
                } else {
                    String q  = "INSERT INTO patient_info VALUES ('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
                    String q1 = "update room set Availablity = 'Booked' where room_no = " +s6;
                    c.statement.executeUpdate(q);
                    c.statement.executeUpdate(q1);
                    JOptionPane.showMessageDialog(null,"Added Sucessfully");
                    setVisible(false);
                }
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
        }

    }
}
