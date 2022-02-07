package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class view_all_issues extends JFrame implements ActionListener{
 
    JTable t1;
    JButton b1;
    String x[] = {"meter_no","issueID","issueType","issue"};
    String y[][] = new String[40][5];
    int i=0, j=0;
    view_all_issues(){
        super("Pending Issues");
        setSize(1200,650);
        setLocation(400,150);
        
        try{
            Conn c1  = new Conn();
            String s1 = "select * from issue";
            ResultSet rs  = c1.s.executeQuery(s1);
            while(rs.next()){
                y[i][j++]=rs.getString("meter_no");
                y[i][j++]=rs.getString("issueID");
                y[i][j++]=rs.getString("issueType");
                y[i][j++]=rs.getString("issue");
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
        new view_all_issues().setVisible(true);
    }
    
}



/*package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class view_all_issues extends JFrame implements ActionListener{
 
    JTable t1;
    JButton b1;
    String x[] = {"meter_no","issueType","issue"};
    String y[][] = new String[40][4];
    int i=0, j=0;
    view_all_issues(){
        super("Pending Issues");
        setSize(1200,650);
        setLocation(400,150);
        
        try{
            Conn c1  = new Conn();
            String s1 = "select * from issue";
            ResultSet rs  = c1.s.executeQuery(s1);
            while(rs.next()){
                y[i][j++]=rs.getString("meter_no");
                y[i][j++]=rs.getString("issueType");
                y[i][j++]=rs.getString("issue");
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
        new view_all_issues().setVisible(true);
    }
    
}*/
