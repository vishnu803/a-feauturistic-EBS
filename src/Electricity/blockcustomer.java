package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.Border;

public class blockcustomer extends JFrame implements ActionListener {
  
    JLabel l1,l2;
    JTextField t1;
    Choice c1;
    JButton b1,b2;
  blockcustomer(){
       setLayout(null);
       setBounds(550, 220, 360, 300);
       
       JLabel title = new JLabel("Manage Customer Account");
       title.setFont(new Font("Tahoma", Font.BOLD, 24));
       title.setBounds(15, 5, 420, 30);
       add(title);
       
       l1 = new JLabel("Meter No");
       l1.setBounds(35, 80, 200, 20);
       add(l1);
       
       t1 = new JTextField();
       t1.setBounds(150, 80, 160, 20);
       add(t1);
       
       l2 = new JLabel("Account Status");
       l2.setBounds(35, 140, 80, 20);
       add(l2);

        c1 = new Choice();
        c1.setBounds(150, 140, 200, 20);
        c1.add("block");
        c1.add("unblock");
        add(c1);
        
        b1 = new JButton("Submit");
        b1.setBounds(120, 200, 100, 25);
        add(b1);
        
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        getContentPane().setBackground(Color.WHITE);
        
        b1.addActionListener(this);
  }  
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String meter_no = t1.getText();
            String s1 = c1.getSelectedItem();
            String q1 = "select * from login where meter_no = '"+meter_no+"'";
            try{
                Conn c2 = new Conn();
                ResultSet rs = c2.s.executeQuery(q1);
                if(rs.next()){
                c2.s.executeUpdate("update login set  accountstatus = '"+s1+"' where meter_no = '"+meter_no+"'");
                    this.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Customer Account"+" "+s1+"ed " +"Succesfully");

                }else{
                    JOptionPane.showMessageDialog(null, "Meter number Invalid");
                    t1.setText("");
                }
               
            }
            catch(Exception ex){
                 ex.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args){
        new blockcustomer().setVisible(true);
    }
}
