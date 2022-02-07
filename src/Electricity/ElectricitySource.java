/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class ElectricitySource extends JFrame implements ActionListener{
    JLabel l1,l2;
    JLabel l11;
    Choice c1;
    JButton b1;
    String meter;
    String month;
    ElectricitySource(String meter,String month){
        this.meter=meter;
        this.month=month;
        setLocation(600,200);
        setSize(600,380);
        
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.WHITE);
        
        JLabel title = new JLabel("Choose Electricity Source");
        title.setFont(new Font("Tahoma", Font.BOLD, 24));
        title.setBounds(120, 5, 400, 30);
        add(title);
        p.add(title);
        
        l1 = new JLabel("Next month");
        l1.setBounds(35, 80, 200, 20);
        add(l1);
        p.add(l1);
        
        JLabel l11 = new JLabel();
            l11.setBounds(300, 80, 200, 20);
            add(l11);
            p.add(l11);
        if(month.equals("January")){
            l11.setText("February");
            
        }
        else if(month.equals("February")){
            l11.setText("March");
            
        }else if(month.equals("March")){
            l11.setText("April");
        }else if(month.equals("April")){
            l11.setText("May");
        }else if(month.equals("May")){
            l11.setText("June");
        }else if(month.equals("June")){
            l11.setText("July");
        }else if(month.equals("July")){
            l11.setText("August");
        }else if(month.equals("August")){
            l11.setText("September");
        }else if(month.equals("September")){
            l11.setText("October");
        }else if(month.equals("October")){
            l11.setText("November");
        }else if(month.equals("November")){
            l11.setText("December");
        }
        
        l2 = new JLabel("Electricity source");
        l2.setBounds(35, 160, 200, 20);
        add(l2);
        p.add(l2);
        
        
        c1 = new Choice();
        c1.setBounds(300, 160, 200, 20);
        c1.add("renewable");
        c1.add("non_renewable");
        add(c1);
        p.add(c1);
        
        b1 = new JButton("Update");
        b1.setBounds(200, 240, 100, 25);
        add(b1);
        p.add(b1);
        
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        add(p,"Center");
        
        getContentPane().setBackground(Color.WHITE); 
        b1.addActionListener(this);
        
        
    }
    public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==b1){
             try{
                 Conn con1 = new Conn();
                 
                 String s="";
                 if(month.equals("January")){
                     s="February";
            
        }
        else if(month.equals("February")){
            s="March";
            
        }else if(month.equals("March")){
            s="April";
        }else if(month.equals("April")){
             s="May";
        }else if(month.equals("May")){
             s="June";
        }else if(month.equals("June")){
             s="July";
        }else if(month.equals("July")){
             s="August";
        }else if(month.equals("August")){
             s="September";
        }else if(month.equals("September")){
             s="October";
        }else if(month.equals("October")){
             s="November";
        }else if(month.equals("November")){
             s="December";
        }
                 
                 
                 String q = "insert into bill values('"+meter+"','"+s+"','"+c1.getSelectedItem()+"','"+""+"','"+""+"', '"+"Not Paid"+"')";
                 con1.s.executeUpdate(q);
                 JOptionPane.showMessageDialog(null,"Electricity Source Updated Successfully for the next month");
                 
                        ResultSet rs1 = con1.s.executeQuery("select * from login where meter_no = '"+meter+"'");
                        String str="";
                        while(rs1.next()){
                            str=rs1.getString("accountstatus");
                        }
                        if(str.equals("block")){
                            JOptionPane.showMessageDialog(null,"Please logout and login again for a normal login after paying in blocked status");
                        }
                 con1.s.executeUpdate("UPDATE login SET accountstatus='"+"unblock"+"'"+ "WHERE meter_no='"+meter+"'");
                 this.setVisible(false);
             }catch(Exception e){System.out.println("wrong");}
         }
    }

    public static void main(String[] args){
        new ElectricitySource("","").setVisible(true);
    }
}