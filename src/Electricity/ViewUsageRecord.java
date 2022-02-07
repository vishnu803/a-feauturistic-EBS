
package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import org.jfree.ui.RefineryUtilities;

public class ViewUsageRecord extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l11;
    
    JButton b1;
    Choice c1,c2,c3;
    JPanel p1;
    String meter;
    ViewUsageRecord(String meter){
        
        super("View Usage Record");
        this.meter=meter;
        setSize(730,400);
        setLayout(new GridLayout(2,2));
        
        p1 = new JPanel();
        l1 = new JLabel("                                                                                     Meter Id:  ");
        //l1.setBounds(300, 380, 20, 20);
        l11 = new JLabel(meter);
        l11.setText(meter);
        //l11.setBounds(300, 380, 20, 20);
        add(l1);
        add(l11);
        
        l2 = new JLabel("       Select Starting Month");
        l2.setBounds(300, 380, 200, 20);
        l3 = new JLabel("       Select Ending Month");
        l3.setBounds(300, 380, 200, 20);
        l4 = new JLabel("Note: Starting month and ending month cannot be the same.");
        l2.setBounds(300, 380, 200, 20);
        //l4=new JLabel("meter_no");
        l11=new JLabel();
        //c1 = new Choice();
        c2 = new Choice();
        c3 = new Choice();
        
        
        
        c2.add("January");
        c2.add("February");
        c2.add("March");
        c2.add("April");
        c2.add("May");
        c2.add("June");
        c2.add("July");
        c2.add("August");
        c2.add("September");
        c2.add("October");
        c2.add("November");
        c2.add("December");
        
        c3.add("January");
        c3.add("February");
        c3.add("March");
        c3.add("April");
        c3.add("May");
        c3.add("June");
        c3.add("July");
        c3.add("August");
        c3.add("September");
        c3.add("October");
        c3.add("November");
        c3.add("December");
        
        
        
        b1 = new JButton("View Past Usage");
        
        //p1.add(l1);
       // p1.add(l11);
        p1.add(l2);
        p1.add(c2);
        p1.add(l3);
        p1.add(c3);
        p1.add(l4);
        add(p1);
        add(b1);
        
        b1.addActionListener(this);
        
        setLocation(350,40);
        
}
    public void actionPerformed(ActionEvent ae){
        try{
            Conn c = new Conn();
            
            String meter_id1 = meter;
            String month = c2.getSelectedItem();
            String month2 = c3.getSelectedItem();
            int m =0;
            int m2=0;
            if(month.equals("January")){
                m=0;
            }else if(month=="February"){
                m=1;
            }else if(month=="March"){
                m=2;
            }else if(month=="April"){
                m=3;
            }else if(month=="May"){
                m=4;
            }else if(month=="June"){
                m=5;
            }else if(month=="July"){
                m=6;
            }else if(month=="August"){
                m=7;
            }else if(month=="September"){
                m=8;
            }else if(month=="October"){
                m=9;
            }else if(month=="November"){
                m=10;
            }else if(month=="December"){
                m=11;
            }
            
            if(month2.equals("January")){
                m2=0;
            }else if(month2=="February"){
                m2=1;
            }else if(month2=="March"){
                m2=2;
            }else if(month2=="April"){
                m2=3;
            }else if(month2=="May"){
                m2=4;
            }else if(month2=="June"){
                m2=5;
            }else if(month2=="July"){
                m2=6;
            }else if(month2=="August"){
                m2=7;
            }else if(month2=="September"){
                m2=8;
            }else if(month2=="October"){
                m2=9;
            }else if(month2=="November"){
                m2=10;
            }else if(month2=="December"){
                m2=11;
            }

            
            ResultSet rs = c.s.executeQuery("select * from record where meter_number="+meter_id1);
            
            int[][] units = new int[m2-m+1][2];
            
            String[] months=new String[12];
                months[0]="January";
                months[1]="February";
                months[2]="March";
                months[3]="April";
                months[4]="May";
                months[5]="June";
                months[6]="July";
                months[7]="August";
                months[8]="September";
                months[9]="October";
                months[10]="November";
                months[11]="December";
            
            if(rs.next()){
                units[0][1]=m2;
                units[1][1]=Integer.parseInt(meter_id1);
//                units[1][0]=Integer.parseInt(rs.getString(months[(m-1+12)%12]));
//                units[2][0]=Integer.parseInt(rs.getString(months[(m-2+12)%12]));
//                units[3][0]=Integer.parseInt(rs.getString(months[(m-3+12)%12]));
//                units[4][0]=Integer.parseInt(rs.getString(months[(m-4+12)%12]));
//                units[5][0]=Integer.parseInt(rs.getString(months[(m-5+12)%12]));
                for(int i=0;i<m2-m+1;i++){
                    units[i][0]=Integer.parseInt(rs.getString(months[(m2-i)]));
                }
            }
            
            
            
            Graphh chart = new Graphh("Graph","Past Usage Record",units);

            chart.pack( );
            RefineryUtilities.centerFrameOnScreen( chart );
            chart.setVisible( true );
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String args[]){
        new ViewUsageRecord("").setVisible(true);
    }
}