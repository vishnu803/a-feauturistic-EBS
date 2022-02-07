package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.Border;
import java.util.*;

public class raise_issue extends JFrame implements ActionListener{
    static String issueID;
    JLabel l1,l2,l3,l4,l5, l6, l7;
    JLabel l11, l12, l13, l14, l15;
    JTextArea t1;
    Choice c1,c2;
    JButton b1,b2;
    String meter;
    raise_issue(String meter){
        this.meter = meter;
        setLayout(null);
        
        setBounds(550, 220, 900, 600);
        
        JLabel title = new JLabel("Raise Issue");
        title.setFont(new Font("Tahoma", Font.BOLD, 24));
        title.setBounds(300, 5, 400, 30);
        add(title);
        
        l1 = new JLabel("Meter No");
        l1.setBounds(35, 80, 200, 20);
        add(l1);
        
        JLabel l11 = new JLabel();
        l11.setBounds(200, 80, 200, 20);
        add(l11);
        
        l5 = new JLabel("Issue ID");
        l5.setBounds(35, 110, 200, 20);
        add(l5);
        
        JLabel l15 = new JLabel();
        l15.setBounds(200, 110, 200, 20);
        add(l15);
        
        JLabel l2 = new JLabel("Name");
        l2.setBounds(35, 140, 200, 20);
        add(l2);
        
        JLabel l12 = new JLabel();
        l12.setBounds(200, 140, 200, 20);
        add(l12);
        
        l3 = new JLabel("Select Type of Issue");
        l3.setBounds(35, 200, 150, 20);
        add(l3);

        c1 = new Choice();
        c1.setBounds(200, 200, 200, 20);
        c1.add("Meter Issue");      //
        c1.add("Billing Issue");    //
        c1.add("Other Issue");      //
        add(c1);
        
        l4 = new JLabel("Enter Issue");
        l4.setBounds(35, 260, 150, 20);
        add(l4);
        
        t1 = new JTextArea();
        t1.setBounds(200, 260,300, 180);
        t1.setLineWrap (true);
        add(t1);
        
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        t1.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter = '"+meter+"'");
            while(rs.next()){
                l11.setText(rs.getString("meter"));
                l12.setText(rs.getString("name"));
            }
        }catch(Exception e){
        
        }
        
        b1 = new JButton("Submit");
        b1.setBounds(300, 480, 100, 25);
        add(b1);
        
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/raise.png"));
        Image i2 = i1.getImage().getScaledInstance(350, 300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l21 = new JLabel(i3);
        l21.setBounds(400, 120, 600, 300);
        add(l21);
        
        Random ran = new Random();
        long first = (ran.nextLong() % 1000000);
        l15.setText(""+Math.abs(first));
       issueID = l15.getText();
        
        b1.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE); 
        
        
    }
    
       public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String issueType = c1.getSelectedItem();
            String issue = t1.getText();
            String q1 = "insert into issue values('"+meter+"', '"+issueID+"', '"+issueType+"', '"+issue+"')";
            try{
                Conn c1 = new Conn();
                c1.s.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"your issue is registered succesfully");
                this.setVisible(false);
               
            }catch(Exception ex){
                 ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        new raise_issue("").setVisible(true);
    }
}
/*package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.Border;

public class raise_issue extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5, l6, l7;
    JLabel l11, l12, l13, l14, l15;
    JTextArea t1;
    Choice c1,c2;
    JButton b1,b2;
    String meter;
    raise_issue(String meter){
        this.meter = meter;
        setLayout(null);
        
        setBounds(550, 220, 900, 600);
        
        JLabel title = new JLabel("Raise Issue");
        title.setFont(new Font("Tahoma", Font.BOLD, 24));
        title.setBounds(300, 5, 400, 30);
        add(title);
        
        l1 = new JLabel("Meter No");
        l1.setBounds(35, 80, 200, 20);
        add(l1);
        
        JLabel l11 = new JLabel();
        l11.setBounds(200, 80, 200, 20);
        add(l11);
        
        JLabel l2 = new JLabel("Name");
        l2.setBounds(35, 140, 200, 20);
        add(l2);
        
        JLabel l12 = new JLabel();
        l12.setBounds(200, 140, 200, 20);
        add(l12);
        
        l3 = new JLabel("Select Type of Issue");
        l3.setBounds(35, 200, 150, 20);
        add(l3);

        c1 = new Choice();
        c1.setBounds(200, 200, 200, 20);
        c1.add("Meter Issue");
        c1.add("Billing Issue");
        c1.add("Other Issue");
        add(c1);
        
        l4 = new JLabel("Enter Issue");
        l4.setBounds(35, 260, 150, 20);
        add(l4);
        
        t1 = new JTextArea();
        t1.setBounds(200, 260,300, 180);
        t1.setLineWrap (true);
        add(t1);
        
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        t1.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter = '"+meter+"'");
            while(rs.next()){
                l11.setText(rs.getString("meter"));
                l12.setText(rs.getString("name"));
            }
        }catch(Exception e){
        
        }
        
        b1 = new JButton("Submit");
        b1.setBounds(300, 480, 100, 25);
        add(b1);
        
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/raise.png"));
        Image i2 = i1.getImage().getScaledInstance(350, 300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l21 = new JLabel(i3);
        l21.setBounds(400, 120, 600, 300);
        add(l21);
        
        b1.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);        
    }
    
       public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String issueType = c1.getSelectedItem();
            String issue = t1.getText();
            String q1 = "insert into issue values('"+meter+"', '"+issueType+"', '"+issue+"')";
            try{
                Conn c1 = new Conn();
                c1.s.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"your issue is registered succesfully");
                this.setVisible(false);
               
            }catch(Exception ex){
                 ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        new raise_issue("").setVisible(true);
    }
}*/