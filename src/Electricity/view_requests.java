package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class view_requests extends JFrame implements ActionListener{
 
    JTable t1;
    JButton b1;
    String x[] = {"accountstatus","username","name", "password"};
    String y[][] = new String[40][5];
    int i=0, j=0;
    view_requests(){
        super("requests for new account");
        setSize(1200,650);
        setLocation(400,150);
        
        try{
            Conn c1  = new Conn();
            String s1 = "select * from login  where accountstatus = '"+"not accepted"+"'";
            ResultSet rs  = c1.s.executeQuery(s1);
            while(rs.next()){
                y[i][j++]=rs.getString("accountstatus");
                y[i][j++]=rs.getString("username");
                y[i][j++]=rs.getString("name");
                y[i][j++]=rs.getString("password");
                i++;
                j=0;
            }
            t1 = new JTable(y,x);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        b1 = new JButton("Print");
        add(b1,"South");
        JScrollPane sp1 = new JScrollPane(t1);
        add(sp1);
        JScrollPane sp2 = new JScrollPane(t1);
        sp2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        add(sp2);
        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            t1.print();
        }catch(Exception e){}
    }
    
    public static void main(String[] args){
        new view_requests().setVisible(true);
    }
    
}
