package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.Border;

public class Type_of_notification extends JFrame implements ActionListener {
  
    JLabel l1,l2;
    JTextField t1;
    Choice c1;
    JButton b1,b2;
    JRadioButton jRadioButton1, jRadioButton2;
    ButtonGroup G1;
  Type_of_notification(){
       setLayout(null);
       setBounds(550, 220, 410, 300);
       
       JLabel title = new JLabel("Select Type of Communication");
       title.setFont(new Font("Tahoma", Font.BOLD, 24));
       title.setBounds(15, 5, 420, 30);
       add(title);
       
       jRadioButton1 = new JRadioButton();
       jRadioButton2 = new JRadioButton(); 

        G1 = new ButtonGroup();
        
        jRadioButton1.setText("One to One");
        jRadioButton1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        jRadioButton2.setText("One to All");
        jRadioButton2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        
        jRadioButton1.setBounds(150, 85, 200, 20);
        jRadioButton2.setBounds(150, 140, 200, 20);
        
        jRadioButton1.setBackground(Color.WHITE);
        jRadioButton2.setBackground(Color.WHITE);
                
        add(jRadioButton1);
        add(jRadioButton2);
        
        G1.add(jRadioButton1);
        G1.add(jRadioButton2);

        b1 = new JButton("Next");
        b1.setBounds(150, 200, 100, 25);
        add(b1);
        
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        getContentPane().setBackground(Color.WHITE);
        
        b1.addActionListener(this);
  }  
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            if(jRadioButton1.isSelected()){    
                new SendNotifications().setVisible(true);
                this.setVisible(false);
                    } 
            if(jRadioButton2.isSelected()){    
                 new notify_all().setVisible(true);
                this.setVisible(false);      
                    } 
        }
    }
    
    public static void main(String[] args){
        new Type_of_notification().setVisible(true);
    }
}
