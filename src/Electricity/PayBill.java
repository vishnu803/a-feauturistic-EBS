package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class PayBill extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5, l6, l7;
    JLabel l11, l12, l13, l14, l15;
    JTextField t1;
    Choice c1,c2;
    JButton b1,b2;
    String meter;
    PayBill(String meter){
        this.meter = meter;
        setLayout(null);
        
        setBounds(550, 220, 900, 600);
        
        JLabel title = new JLabel("Electricity Bill");
        title.setFont(new Font("Tahoma", Font.BOLD, 24));
        title.setBounds(120, 5, 400, 30);
        add(title);
        
        l1 = new JLabel("Meter No");
        l1.setBounds(35, 80, 200, 20);
        add(l1);
        
        JLabel l11 = new JLabel();
        l11.setBounds(300, 80, 200, 20);
        add(l11);
        
        JLabel l2 = new JLabel("Name");
        l2.setBounds(35, 140, 200, 20);
        add(l2);
        
        JLabel l12 = new JLabel();
        l12.setBounds(300, 140, 200, 20);
        add(l12);
        
        l3 = new JLabel("Month");
        l3.setBounds(35, 200, 200, 20);
        add(l3);
        
        
        
        c1 = new Choice();
        c1.setBounds(300, 200, 200, 20);
        c1.add("January");
        c1.add("February");
        c1.add("March");
        c1.add("April");
        c1.add("May");
        c1.add("June");
        c1.add("July");
        c1.add("August");
        c1.add("September");
        c1.add("October");
        c1.add("November");
        c1.add("December");
        add(c1);
        
        l3 = new JLabel("Payment Mode");
        l3.setBounds(35, 440, 200, 20);
        add(l3);
        
        c2 = new Choice();
        c2.setBounds(300, 440, 200, 20);
        c2.add("Debit card");
        c2.add("Credit card");
        c2.add("UPI");
        add(c2);
        
        l4 = new JLabel("Units");
        l4.setBounds(35, 260, 200, 20);
        add(l4);
        
        JLabel l13 = new JLabel();
        l13.setBounds(300, 260, 200, 20);
        add(l13);
        
        l5 = new JLabel("Total Bill");
        l5.setBounds(35, 320, 200, 20);
        add(l5);
        
        JLabel l14 = new JLabel();
        l14.setBounds(300, 320, 200, 20);
        add(l14);
        
        l6 = new JLabel("Status");
        l6.setBounds(35, 380, 200, 20);
        add(l6);
        
        JLabel l15 = new JLabel();
        l15.setBounds(300, 380, 200, 20);
        l15.setForeground(Color.RED);
        add(l15);
        
        
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter = '"+meter+"'");
            while(rs.next()){
                l11.setText(rs.getString("meter"));
                l12.setText(rs.getString("name"));
            }
            rs = c.s.executeQuery("select * from bill where meter = '"+meter+"' AND month = 'January' ");
            while(rs.next()){
                l13.setText(rs.getString("units"));
                l14.setText(rs.getString("total_bill"));
                l15.setText(rs.getString("status"));
            }
        }catch(Exception e){}
        
        c1.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent ae){
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from bill where meter = '"+meter+"' AND month = '"+c1.getSelectedItem()+"'");
                    int i=0;
                    while(rs.next()){
                        l13.setText(rs.getString("units"));
                        l14.setText(rs.getString("total_bill"));
                        l15.setText(rs.getString("status"));
                        i++;
                    }
                    if(i==0){
                        JOptionPane.showMessageDialog(null,"Chosen month is invalid");
                        l13.setText("");
                        l14.setText("");
                        l15.setText("");
                    }
                    
                    
                }catch(Exception e){
                
                }
            }
        });
        
        b1 = new JButton("Pay");
        b1.setBounds(100, 480, 100, 25);
        add(b1);
        b2 = new JButton("Back");
        b2.setBounds(230, 480, 100, 25);
        add(b2);
        
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l21 = new JLabel(i3);
        l21.setBounds(400, 120, 600, 300);
        add(l21);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            try{
                    Conn con = new Conn();
                    ResultSet rs1 = con.s.executeQuery("select * from bill where meter = '"+meter+"' AND month = '"+c1.getSelectedItem()+"'");
                    int i=0;
                    while(rs1.next()){
                        if(rs1.getString("units").equals("")){
                            JOptionPane.showMessageDialog(null,"Bill is under process");
                            
                        }else if(rs1.getString("status").equals("Paid")){
                            JOptionPane.showMessageDialog(null,"Bill is already paid");
                            
                        }
                        else{
                            this.setVisible(false);
                            if(c2.getSelectedItem().equals("Debit card")){
                                new DebitCard(meter,c1.getSelectedItem()).setVisible(true);
                
                            }
                            if(c2.getSelectedItem().equals("Credit card")){
                                new CreditCard(meter,c1.getSelectedItem()).setVisible(true);
                            }
                            if(c2.getSelectedItem().equals("UPI")){
                                new UPI(meter,c1.getSelectedItem()).setVisible(true);
                            }
                        }
                        i++;
                    }
                    if(i==0){
                        JOptionPane.showMessageDialog(null,"Payment for the chosen month is denied");
                    }
                    
                    
                }catch(Exception e){
                
                }
        }else if(ae.getSource()== b2){
            this.setVisible(false);
        }        
    }
    
       
    public static void main(String[] args){
        new PayBill("").setVisible(true);
    }
}
