/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class CreditCard extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4;
    JTextField t1,t2,t3;
    Choice c1;
    JButton b1,b2;
    String meter;
    String month;
    CreditCard(String meter,String month){
        this.meter=meter;
        this.month=month;
        setLayout(null);

        setBounds(500, 100, 600, 600);

        JLabel title = new JLabel("Credit Card");
        title.setFont(new Font("Tahoma", Font.BOLD, 24));
        title.setBounds(120, 5, 400, 30);
        add(title);

        l1 = new JLabel("Bank Name");
        l1.setBounds(35, 80, 200, 20);
        add(l1);

        c1=new Choice();
        c1.setBounds(300, 80, 200, 20);
        c1.add("State Bank of India");
        c1.add("Central Bank of India");
        c1.add("HDFC Bank");
        c1.add("ICICI Bank");
        c1.add("Axis Bank");
        add(c1);

        l2 = new JLabel("Card Number");
        l2.setBounds(35, 180, 200, 20);
        add(l2);

        t1 = new JTextField();
        t1.setBounds(300, 180, 200, 20);
        add(t1);
        
        l3 = new JLabel("CVC");
        l3.setBounds(35, 280, 200, 20);
        add(l3);
        
        t2 = new JTextField();
        t2.setBounds(300, 280, 200, 20);
        add(t2);
        
        l4 = new JLabel("Cardholder Name");
        l4.setBounds(35, 380, 200, 20);
        add(l4);
        
        t3 = new JTextField();
        t3.setBounds(300, 380, 200, 20);
        add(t3);


        b1 = new JButton("Pay bill");
        b1.setBounds(100, 450, 100, 25);
        add(b1);

        b2 = new JButton("Back");
        b2.setBounds(350, 450, 100, 25);
        add(b2);

        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        getContentPane().setBackground(Color.WHITE); 
        b1.addActionListener(this);
        b2.addActionListener(this);


    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            if(t1.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Missing details");
            }
            else
                {
                    int error=0;
                    
                    try{
                        long cardnumber=Long.parseLong(t1.getText());
                        if(t1.getText().length()!=16){
                            JOptionPane.showMessageDialog(null,"card number is invalid");
                            error=1;
                        }
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null,"card number is invalid");
                        error=1;
                    }
                    try{
                        long cvc=Long.parseLong(t2.getText());
                        if(t2.getText().length()!=3){
                            JOptionPane.showMessageDialog(null,"cvc is invalid");
                            error=1;
                        }
                       
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null,"cvc is invalid");
                        error=1;
                    }
                    
                    if(error==0){
                    try{
                        Conn c = new Conn();
                        
                        c.s.executeUpdate("UPDATE bill SET status='"+"Paid"+"'"+ "WHERE meter='"+meter+"' AND month='"+month+"'");
                        JOptionPane.showMessageDialog(null,"Payment is successfull");
                        
                       
                        this.setVisible(false);
                        new ElectricitySource(meter,month).setVisible(true);
                        
                        }catch(Exception e){System.out.println("wrong");}
                    }else{
                        t1.setText("");
                        t2.setText("");
                        t3.setText("");
                    }
                }
        }
        if(ae.getSource() == b2){
            this.setVisible(false);
            new PayBill("").setVisible(true);
        }
    }
    public static void main(String[] args){
        new CreditCard("","").setVisible(true);
    }
}