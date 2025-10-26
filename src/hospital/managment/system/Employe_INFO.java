package hospital.managment.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.cert.Extension;
import java.sql.ResultSet;

public class Employe_INFO extends JFrame {

    Employe_INFO(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(109,164,170));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,34,980,450);
        table.setBackground(new Color(109,164,170));
        table.setFont(new Font("Tahoma",Font.BOLD,14));
        table.setRowHeight(30);

        panel.add(table);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10,34,980,450);
        panel.add(scrollPane);

        try{
            String q = "select * from EMP_INFO";
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
            // Adjust column widths
            TableColumnModel columnModel = table.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(120); // Name
            columnModel.getColumn(1).setPreferredWidth(50);  // Age
            columnModel.getColumn(2).setPreferredWidth(120); // Phone
            columnModel.getColumn(3).setPreferredWidth(80);  // Salary
            columnModel.getColumn(4).setPreferredWidth(250); // Gmail (wider!)
            columnModel.getColumn(5).setPreferredWidth(150); // Aadhar
        } catch (Exception e){
            e.printStackTrace();

        }




        JButton button = new JButton("Back");
        button.setBounds(200,500,120,30);
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
        setSize(1000,600);
        setLayout(null);
        setLocation(350,250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Employe_INFO();

    }
}
