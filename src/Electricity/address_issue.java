package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.Border;

public class address_issue extends JFrame implements ActionListener {
  
    JLabel l1,l2;
    JTextField t1;
    Choice c1, c3;
    JButton b1,b2;
  address_issue(){
       setLayout(null);
       setBounds(550, 220, 360, 300);
       
       JLabel title = new JLabel("Address Issue");
       title.setFont(new Font("Tahoma", Font.BOLD, 24));
       title.setBounds(100, 5, 400, 30);
       add(title);
       
       l1 = new JLabel("IssueID");
       l1.setBounds(35, 80, 100, 20);
       add(l1);
       
       c3 = new Choice();
       c3.setBounds(150, 80, 160, 20);
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from issue");
            while(rs.next()){
                c3.add(rs.getString("issueID"));
            }
        }catch(Exception e){}
        add(c3);
       
       l2 = new JLabel("issue Status");
       l2.setBounds(35, 140, 80, 20);
       add(l2);

        c1 = new Choice();
        c1.setBounds(150, 140, 200, 20);
        c1.add("Resolved");
        c1.add("Not Resolved");
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
            String issueID = c3.getSelectedItem();
            String q1 = "select * from issue where issueID = '"+issueID+"'";
            try{
                Conn c1 = new Conn();
                ResultSet rs = c1.s.executeQuery(q1);
                if(rs.next()){
                    c1.s.executeUpdate("DELETE FROM issue WHERE issueID="+issueID);
                    this.setVisible(false);

                }else{
                    JOptionPane.showMessageDialog(null, "Issue ID Invalid");
                    t1.setText("");
                }
               
            }
            catch(Exception ex){
                 ex.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args){
        new address_issue().setVisible(true);
    }
}

