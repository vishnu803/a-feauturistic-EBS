package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.Border;

public class notify_all extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5, l6, l7;
    JLabel l12, l13, l14, l15;
    JTextArea t1;
    JTextField c1,c2,c3;
    JButton b1,b2;
    String meter;
    notify_all(){
        
        setLayout(null);
        
        setBounds(200, 50, 900, 480);
        JLabel title = new JLabel("Send Notification");
        title.setFont(new Font("Tahoma", Font.BOLD, 24));
        title.setBounds(300, 5, 400, 30);
        add(title);
 
        l3 = new JLabel("Enter Date");
        l3.setBounds(35, 80, 200, 20);     //35, 150, 150, 20
        add(l3);

        c1 = new JTextField();
        c1.setBounds(200, 80, 200, 20);    //200, 150, 200, 20
        add(c1);
        
        l4 = new JLabel("Enter Message");
        l4.setBounds(35, 150, 150, 20);
        add(l4);
        
        l5 = new JLabel("enter date in DD/MM/YYYY format");
        l5.setBounds(215, 100, 200, 20);
        l5.setFont(new Font("Tahoma", Font.PLAIN, 11));
        l5.setForeground(Color.BLUE);
        add(l5);
        
        t1 = new JTextArea();
        t1.setBounds(200, 150,300, 180);
        t1.setLineWrap (true);
        add(t1);
        
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        t1.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        
        
        b1 = new JButton("Send");
        b1.setBounds(300, 380, 100, 25);
        add(b1);
        
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/notification.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(350, 300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l21 = new JLabel(i3);
        l21.setBounds(517, 80, 350, 300);
        add(l21);
        
        b1.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);        
    }
    
       public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String meter = "all";
            String date = c1.getText();
            String notification = t1.getText();
            String q1 = "insert into notificationtable values('"+meter+"', '"+date+"', '"+notification+"')";
            try{
                Conn c1 = new Conn();
                c1.s.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"your message is sent succesfully to all");
                this.setVisible(false);
               
            }catch(Exception ex){
                 ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        new notify_all().setVisible(true);
    }
}
