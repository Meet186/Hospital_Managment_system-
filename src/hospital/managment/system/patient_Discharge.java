package hospital.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class patient_Discharge extends JFrame {

    patient_Discharge(){
         JPanel panel = new JPanel();
         panel.setBounds(5,5,790,390);
         panel.setBackground(new Color(90,156,163));
         panel.setLayout(null);
         add(panel);

         JLabel label = new JLabel("CHECK-Out");
         label.setBounds(100,20,150,20);
         label.setFont(new Font("Tahoma",Font.BOLD,20));
         label.setForeground(Color.BLACK);
         panel.add(label);

        JLabel label1 = new JLabel("Customer Id");
        label1.setBounds(35,80,150,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        label1.setForeground(Color.BLACK);
        panel.add(label1);

        Choice choice = new Choice();
        choice.setFont(new Font("",Font.BOLD,14));
        choice.setBounds(200,80,150,25);
        panel.add(choice);

        try{
            conn c  = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
            while (resultSet.next()){
                choice.add(resultSet.getString("number"));
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        JLabel label2 = new JLabel("Room Number");
        label2.setBounds(30,130,150,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(Color.BLACK);
        panel.add(label2);

        JLabel RNo = new JLabel();
        RNo.setBounds(200,130,150,20);
        RNo.setFont(new Font("Tahoma",Font.BOLD,14));
        RNo.setForeground(Color.BLACK);
        panel.add(RNo);

        JLabel label3 = new JLabel("In Time");
        label3.setBounds(30,180,150,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.BLACK);
        panel.add(label3);

        JLabel INTime = new JLabel();
        INTime.setBounds(200,180,250,20);
        INTime.setFont(new Font("Tahoma",Font.BOLD,14));
        INTime.setForeground(Color.BLACK);
        panel.add(INTime);

        JLabel label4 = new JLabel("Out Time");
        label4.setBounds(30,230,150,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.BLACK);
        panel.add(label4);

        Date date = new Date();

        JLabel OUTime = new JLabel("" + date);
        OUTime.setBounds(200,230,250,20);
        OUTime.setFont(new Font("Tahoma",Font.BOLD,14));
        OUTime.setForeground(Color.BLACK);
        panel.add(OUTime);

        JButton discharge = new JButton("Discharge");
        discharge.setBounds(30,300,120,30);
        discharge.setBackground(Color.BLACK);
        discharge.setForeground(Color.WHITE);
        panel.add(discharge);

        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    conn c = new conn();
                    c.statement.executeUpdate("delete from patient_info where number = '"+choice.getSelectedItem()+"'");
                    c.statement.executeUpdate("update room set Availablity = 'Available' where room_no = '"+RNo.getText()+"'");
                    JOptionPane.showMessageDialog(null,"Done");
                    setVisible(false);
                } catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        JButton check = new JButton("Check");
        check.setBounds(170,300,120,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try{
                    ResultSet resultSet = c.statement.executeQuery("select * from patient_info where number = '"+choice.getSelectedItem()+"'");
                    while (resultSet.next()){
                        RNo.setText(resultSet.getString("Room_No"));
                        INTime.setText(resultSet.getString("Time"));
                    }
                } catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton Back = new JButton("Back");
        Back.setBounds(300,300,120,30);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        panel.add(Back);

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

         setUndecorated(true);
         setSize(800,400);
         setLocation(400,250);
         setVisible(true);
    }
    public static void main(String[] args) {
        new patient_Discharge();
    }
}
