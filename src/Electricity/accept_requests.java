package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.Border;

public class accept_requests extends JFrame implements ActionListener {
  
    JLabel l1,l2;
    JTextField t1;
    Choice c1;
    JButton b1,b2;
  accept_requests(){
       setLayout(null);
       setBounds(550, 220, 360, 300);
       
       JLabel title = new JLabel("Accept Request");
       title.setFont(new Font("Tahoma", Font.BOLD, 24));
       title.setBounds(90, 5, 400, 30);
       add(title);
       
       l1 = new JLabel("Username");
       l1.setBounds(35, 80, 200, 20);
       add(l1);
       
       t1 = new JTextField();
       t1.setBounds(150, 80, 160, 20);
       add(t1);
       
       l2 = new JLabel("Account Status");
       l2.setBounds(35, 140, 100, 20);
       add(l2);

        c1 = new Choice();
        c1.setBounds(150, 140, 200, 20);
        c1.add("Accept");
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
            String Username = t1.getText();
            String q1 = "select * from login where username = '"+Username+"'";
            try{
                Conn c1 = new Conn();
                ResultSet rs = c1.s.executeQuery(q1);
                if(rs.next()){
                    c1.s.executeUpdate("update login set  accountstatus = '"+"accepted"+"' where username = '"+Username+"'");
                    JOptionPane.showMessageDialog(null, "Successfully accepted the account request");
                    this.setVisible(false);

                }else{
                    JOptionPane.showMessageDialog(null, "Username Invalid");
                    t1.setText("");
                }
               
            }
            catch(Exception ex){
                 ex.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args){
        new accept_requests().setVisible(true);
    }
}
