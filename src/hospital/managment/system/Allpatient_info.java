package hospital.managment.system;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Allpatient_info extends JFrame {

    Allpatient_info(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,1000,690);
        panel.setLayout(null);
        panel.setBackground(new Color(90,156,163));
        add(panel);

        JTable table = new JTable();
        table.setBounds(0,40,990,590);
        table.setBackground(new Color(90,156,163));
        table.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(table);


        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10,34,980,400);
        panel.add(scrollPane);

        try{
            String q = "select * from patient_info;";
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery(q);

            table.setModel(DbUtils.resultSetToTableModel(resultSet));
            TableColumnModel columnModel = table.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(110); // ID
            columnModel.getColumn(1).setPreferredWidth(100);  // NUMBER
            columnModel.getColumn(2).setPreferredWidth(110); // NAME
            columnModel.getColumn(3).setPreferredWidth(80);  // GENDER
            columnModel.getColumn(4).setPreferredWidth(200); // DISEASE
            columnModel.getColumn(5).setPreferredWidth(80); // ROOM NO
            columnModel.getColumn(6).setPreferredWidth(250); // DATE
            columnModel.getColumn(7).setPreferredWidth(80); // DEPOSITE

        } catch (Exception e ){
            e.printStackTrace();

        }
        JButton button = new JButton("Back");
        button.setBounds(200,480,120,30);
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
        setSize(1010,700);
        setLayout(null);
        setLocation(350,250);
        setVisible(true);
    }


    public static void main(String[] args) {
        new Allpatient_info();
    }
}
