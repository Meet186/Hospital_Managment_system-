package hospital.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class update_patient_deatils extends JFrame {

    update_patient_deatils(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);

        JLabel label1 = new JLabel("Update Patient Details");
        label1.setBounds(124,11,260,25);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));

        JLabel label2 = new JLabel("Name :");
        label2.setBounds(25,88,100,14);
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

       Choice choice = new Choice();
       choice.setBounds(248,85,120,30);
       panel.add(choice);

       try{
           conn c = new conn();
           ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
           while (resultSet.next()){
               choice.add(resultSet.getString("Name"));
           }

       } catch (Exception e){
           e.printStackTrace();
       }

        JLabel label3 = new JLabel("Room Number :");
        label3.setBounds(25,129,120,14);
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);

        JTextField textFieldR = new JTextField();
        textFieldR.setBounds(248,129,120,20);
        panel.add(textFieldR);

        JLabel label4 = new JLabel("In-Time :");
        label4.setBounds(25,174,120,14);
        label4.setForeground(Color.WHITE);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);

        JTextField textFieldINTime = new JTextField();
        textFieldINTime.setBounds(248,174,120,20);
        panel.add(textFieldINTime);

        JLabel label5 = new JLabel("Amount Paid (Rs) :");
        label5.setBounds(25,216,140,14);
        label5.setForeground(Color.WHITE);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label5);

        JTextField textFieldAmount = new JTextField();
        textFieldAmount.setBounds(248,216,120,20);
        panel.add(textFieldAmount);

        JLabel label6 = new JLabel("Pending Amount (Rs) :");
        label6.setBounds(25,261,170,14);
        label6.setForeground(Color.WHITE);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label6);

        JTextField textFieldPendingAmount = new JTextField();
        textFieldPendingAmount.setBounds(248,261,120,20);
        panel.add(textFieldPendingAmount);

        JButton check = new JButton("CHECK");
        check.setBounds(281,378,89,23);
        check.setForeground(Color.WHITE);
        check.setBackground(Color.BLACK);
        panel.add(check);

        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = choice.getSelectedItem();
                String q = "select * from patient_info Where Name = '"+id+"'";
                try {
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    while (resultSet.next()){
                        textFieldR.setText(resultSet.getString("Room_No"));
                        textFieldINTime.setText(resultSet.getString("Time"));
                        textFieldAmount.setText(resultSet.getString("Deposite"));
                    }
                    ResultSet resultSet1 = c.statement.executeQuery("select * from room Where room_no = '"+textFieldR.getText()+"'");
                    while (resultSet1.next()){
                        String price = resultSet1.getString("Price");
                        int amountPaid = Integer.parseInt(price) - Integer.parseInt(textFieldAmount.getText());
                        textFieldPendingAmount.setText(""+amountPaid);
                    }
                } catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton update = new JButton("UPDATE");
        update.setBounds(56,378,89,23);
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLACK);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    conn c  = new conn();
                    String q = choice.getSelectedItem();
                    String room = textFieldR.getText();
                    String time = textFieldINTime.getText();
                    String amount = textFieldAmount.getText();
                    c.statement.executeUpdate("UPDATE patient_info SET Room_No = '"+room+"' , Time ='"+time+"', Deposite = '"+amount+"' Where Name = '"+q+"'");
                    JOptionPane.showMessageDialog(null,"Update Successfullya");
                    setVisible(false);
                } catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        JButton back = new JButton("BACK");
        back.setBounds(56,415,89,23);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        panel.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(950,500);
        setLayout(null);
        setLocation(400,250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new update_patient_deatils();
    }
}
