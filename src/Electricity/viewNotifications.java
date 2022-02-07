package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class viewNotifications extends JFrame implements ActionListener{
 
    JTable t1;
    JButton b1;
    String x[] = {"date","notification"};
    String y[][] = new String[40][3];
    int i=0, j=0;
    String meter_no;
    viewNotifications(String meter_no){
        super("Notificatons");
        setSize(1200,650);
        setLocation(400,150);
        
        this.meter_no = meter_no;
        
        try{
            Conn c1  = new Conn();
            String meter = meter_no;
            String b = "all";
            String s1 = "select * from notificationtable where meter_no = '"+meter+"' or meter_no = '"+b+"'";
            ResultSet rs  = c1.s.executeQuery(s1);
            while(rs.next()){
                y[i][j++]=rs.getString("date");
                y[i][j++]=rs.getString("notification");
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
        new viewNotifications("").setVisible(true);
    }
    
}

