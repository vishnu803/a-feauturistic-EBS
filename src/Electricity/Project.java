package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Project extends JFrame implements ActionListener{
    String meter;
    String Username;
    Project(String meter, String person, String Username){
        super("Electricity Billing System");
        this.meter = meter;
        this.Username=Username;
        setSize(1920,1030);
        
        /* Adding background image */
        ImageIcon ic =  new ImageIcon(ClassLoader.getSystemResource("icon/elect2.jpg"));
        Image i3 = ic.getImage().getScaledInstance(1290, 700,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        JLabel l1 = new JLabel(icc3);
        add(l1);
       
        /* First Column */
        JMenuBar mb  = new JMenuBar();
        JMenu master = new JMenu("Master");
        JMenuItem m1 = new JMenuItem("New Customer");
        JMenuItem m2 = new JMenuItem("Customer Details");
        JMenuItem m3 = new JMenuItem("Deposit Details");
        JMenuItem m4 = new JMenuItem("Enter Electricity Bill");
        JMenuItem m5 = new JMenuItem("Set Account status");
        JMenuItem m6 = new JMenuItem("view all issues");
        JMenuItem m7 = new JMenuItem("Send Notifications");
        JMenuItem m8 = new JMenuItem("view requests");
        JMenuItem m9 = new JMenuItem("Accept requests");
        JMenuItem m10 = new JMenuItem("Address issues");
        master.setForeground(Color.BLUE);
        
        
        /* ---- Customer Details ---- */
        m1.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image image1 = icon1.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        m1.setIcon(new ImageIcon(image1));
        m1.setMnemonic('D');
        m1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        m1.setBackground(Color.WHITE);
        
        /* ---- Meter Details ---- */
        m2.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
        Image image2 = icon2.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        m2.setIcon(new ImageIcon(image2));
        m2.setMnemonic('M');
        m2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        m2.setBackground(Color.WHITE);
        
         /* ---- Deposit Details  ----- */
        m3.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
        Image image3 = icon3.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        m3.setIcon(new ImageIcon(image3));
        m3.setMnemonic('N');
        m3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        m3.setBackground(Color.WHITE);
        
        m4.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        Image image5 = icon5.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        m4.setIcon(new ImageIcon(image5));
        m4.setMnemonic('B');
        m4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        m4.setBackground(Color.WHITE);
        
        m6.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon0 = new ImageIcon(ClassLoader.getSystemResource("icon/raise.png"));
        Image image0 = icon0.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        m6.setIcon(new ImageIcon(image0));
        m6.setMnemonic('I');
        m6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
        m6.setBackground(Color.WHITE);
        
        m5.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon14 = new ImageIcon(ClassLoader.getSystemResource("icon/status.png"));
        Image image14 = icon14.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        m5.setIcon(new ImageIcon(image14));
        m5.setMnemonic('A');
        m5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        m5.setBackground(Color.WHITE);
        
        m7.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon200 = new ImageIcon(ClassLoader.getSystemResource("icon/icon89.png"));
        Image image200 = icon200.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        m7.setIcon(new ImageIcon(image200));
        m7.setMnemonic('N');
        m7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        m7.setBackground(Color.WHITE);
        
        m8.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon300 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        Image image300 = icon300.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        m8.setIcon(new ImageIcon(image300));
        m8.setMnemonic('K');
        m8.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.CTRL_MASK));
        m8.setBackground(Color.WHITE);

        m9.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon301 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        Image image301 = icon301.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        m9.setIcon(new ImageIcon(image301));
        m9.setMnemonic('D');
        m9.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        m9.setBackground(Color.WHITE);
        
        m10.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon305 = new ImageIcon(ClassLoader.getSystemResource("icon/raise.png"));
        Image image305 = icon305.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        m10.setIcon(new ImageIcon(image305));
        m10.setMnemonic('O');
        m10.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        m10.setBackground(Color.WHITE);
        
        m1.addActionListener(this);
        m2.addActionListener(this);
        m3.addActionListener(this);
        m4.addActionListener(this);
        m6.addActionListener(this);
        m5.addActionListener(this);
        m7.addActionListener(this);
        m8.addActionListener(this);
        m9.addActionListener(this);
        m10.addActionListener(this);
        
        
        //-----------------------------
        
        /* Second Column */
        JMenu info = new JMenu("Information");
        JMenuItem info1 = new JMenuItem("Update Information");
        JMenuItem info2 = new JMenuItem("View Information");
        
        info.setForeground(Color.RED);
        
        /* ---- Pay Bill ---- */
        info1.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon41 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image image41 = icon41.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        info1.setIcon(new ImageIcon(image41));
        info1.setMnemonic('P');
        info1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        info1.setBackground(Color.WHITE);
        
        /* ---- Last Bill ----*/
        info2.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon42 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image42 = icon42.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        info2.setIcon(new ImageIcon(image42));
        info2.setMnemonic('L');
        info2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        info2.setBackground(Color.WHITE);
        
        info1.addActionListener(this);
        info2.addActionListener(this);
        
        
        
        
        
        // --------------------------------------------------------------------------------------------
        
        
        /* Second Column */
        JMenu user = new JMenu("User");
        JMenuItem u1 = new JMenuItem("Pay Bill");
        JMenuItem u2 =new JMenuItem("Delete Account");
        JMenuItem u3 = new JMenuItem("Bill Details");
        JMenuItem u4 = new JMenuItem("View Usage Record");
        JMenuItem u5 = new JMenuItem("View Notifications");
        user.setForeground(Color.RED);
        
        /* ---- Pay Bill ---- */
        u1.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image image4 = icon4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        u1.setIcon(new ImageIcon(image4));
        u1.setMnemonic('P');
        u1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        u1.setBackground(Color.WHITE);
        
        /* ---- Delete Account -----*/
        u2.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon100 = new ImageIcon(ClassLoader.getSystemResource("icon/icon24.png"));
        Image image100 = icon100.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        u2.setIcon(new ImageIcon(image100));
        u2.setMnemonic('A');
        u2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        u2.setBackground(Color.WHITE);
        
        /* ---- Last Bill ----*/
        u3.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image6 = icon6.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        u3.setIcon(new ImageIcon(image6));
        u3.setMnemonic('L');
        u3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        u3.setBackground(Color.WHITE);
        
        u4.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon99 = new ImageIcon(ClassLoader.getSystemResource("icon/icon90.png"));
        Image image99 = icon99.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        u4.setIcon(new ImageIcon(image99));
        u4.setMnemonic('Q');
        u4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,ActionEvent.CTRL_MASK));
        u4.setBackground(Color.WHITE);
        
        u5.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon101 = new ImageIcon(ClassLoader.getSystemResource("icon/icon89.png"));
        Image image101 = icon101.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        u5.setIcon(new ImageIcon(image101));
        u5.setMnemonic('H');
        u5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
        u5.setBackground(Color.WHITE);
        
        u1.addActionListener(this);
        u2.addActionListener(this);
        u3.addActionListener(this);
        u4.addActionListener(this);
        u5.addActionListener(this);
        
        
        // --------------------------------------------------------------------------------------------- 
        
        /* Third Column*/
        JMenu report = new JMenu("Report");
        JMenuItem r1 = new JMenuItem("Generate Bill");
        JMenuItem r2 = new JMenuItem("Raise Issue");
        report.setForeground(Color.BLUE);
        
        /* ---- Report ---- */
        r1.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        Image image7 = icon7.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        r1.setIcon(new ImageIcon(image7));
        r1.setMnemonic('R');
        r1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        r1.setBackground(Color.WHITE);
        
        r1.addActionListener(this);
        
        r2.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon12 = new ImageIcon(ClassLoader.getSystemResource("icon/raise.png"));
        Image image12 = icon12.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        r2.setIcon(new ImageIcon(image12));
        r2.setMnemonic('U');
        r2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
        r2.setBackground(Color.WHITE);
        
        r2.addActionListener(this);
        
        // -----------------------------------------------------------------------------------------------
        
        /* Fourth Column*/
        JMenu utility = new JMenu("Utility");
        JMenuItem ut1 = new JMenuItem("Notepad");
        JMenuItem ut2 = new JMenuItem("Calculator");
        JMenuItem ut3 = new JMenuItem("Web Browser");
        utility.setForeground(Color.RED); 
        
        /* ---- Calender ---- */
        ut1.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
        Image image8 = icon8.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ut1.setIcon(new ImageIcon(image8));
        ut1.setMnemonic('C');
        ut1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        ut1.setBackground(Color.WHITE);
        
        /* ---- Calculator ---- */
        ut2.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image image9 = icon9.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ut2.setIcon(new ImageIcon(image9));
        ut2.setMnemonic('X');
        ut2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        ut2.setBackground(Color.WHITE);
        
        /* ---- Web Browser ---- */
        ut3.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("icon/icon10.png"));
        Image image10 = icon10.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ut3.setIcon(new ImageIcon(image10));
        ut3.setMnemonic('W');
        ut3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        ut3.setBackground(Color.WHITE);
        
        
        ut1.addActionListener(this);
        ut2.addActionListener(this);
        ut3.addActionListener(this);
        
        // ---------------------------------------------------------------------------------------
        
        /*Fifth Column */
        JMenu exit0 = new JMenu("Logout");
        JMenuItem ex = new JMenuItem("Logout");
        JMenuItem ex1 = new JMenuItem("delete my account");
        exit0.setForeground(Color.BLUE);
        
        /* ---- Exit ---- */
        ex.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image image11 = icon11.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ex.setIcon(new ImageIcon(image11));
        ex.setMnemonic('Z');
        ex.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        ex.setBackground(Color.WHITE);
        
        ex.addActionListener(this);
        
        ex1.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon77 = new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image image77 = icon77.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ex1.setIcon(new ImageIcon(image11));
        ex1.setMnemonic('Y');
        ex1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
        ex1.setBackground(Color.WHITE);
        
        ex1.addActionListener(this);
        
        JMenu exit1 = new JMenu("Logout");
        JMenuItem cex = new JMenuItem("Logout");
        exit1.setForeground(Color.BLUE);
        
        /* ---- Exit ---- */
        cex.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon151 = new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image image151 = icon151.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        cex.setIcon(new ImageIcon(image11));
        cex.setMnemonic('Z');
        cex.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        cex.setBackground(Color.WHITE);
        
        cex.addActionListener(this);
        
        
        // ---------------------------------------------------------------------------------------------
               
        
        master.add(m1);
        master.add(m2);
        master.add(m3);
        master.add(m4);
        master.add(m6);
        master.add(m5);
        master.add(m7);
        master.add(m8);
        master.add(m9);
        master.add(m10);
        
        info.add(info1);
        info.add(info2);
        
        user.add(u1);
        user.add(u2);
        user.add(u3);
        user.add(u4);
        user.add(u5);
        
        report.add(r1);
        report.add(r2);
        
        utility.add(ut1);
        utility.add(ut2);
        utility.add(ut3);
        
        exit0.add(ex);
        exit0.add(ex1);
        
        exit1.add(cex);
        if(person.equals("Admin")){
            mb.add(master);
        }else{             
            mb.add(info);
            mb.add(user);
            mb.add(report);
        }
        mb.add(utility);
        if(person.equals("Admin")){
            mb.add(exit0);
        }else{             
            mb.add(exit1);
        }
        
        setJMenuBar(mb);
        
        
        setFont(new Font("Senserif",Font.BOLD,16));
        setLayout(new FlowLayout());
        setVisible(false);
    }
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if(msg.equals("Customer Details")){
            new CustomerDetails().setVisible(true);
            
        }else if(msg.equals("New Customer")){
            new NewCustomer().setVisible(true);
            
        }else if(msg.equals("Enter Electricity Bill")){
            new CalculateBill().setVisible(true);
            
        }else if(msg.equals("Pay Bill")){
            new PayBill(meter).setVisible(true);
           
        }else if(msg.equals("view all issues")){
            new view_all_issues().setVisible(true);
           
        }
        else if(msg.equals("view requests")){
            new view_requests().setVisible(true);
           
        }
        else if(msg.equals("Address issues")){
            new address_issue().setVisible(true);
        }
        else if(msg.equals("Accept requests")){
            new accept_requests().setVisible(true);
           
        }
        else if(msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){ }
        }else if(msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){ }
        }else if(msg.equals("Web Browser")){
            try{
                Runtime.getRuntime().exec("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
            }catch(Exception e){ }
        }else if(msg.equals("Logout")){
            this.setVisible(false);
            new Login().setVisible(true);
        }else if(msg.equals("Generate Bill")){
            new GenerateBill(meter).setVisible(true);
            
        }else if(msg.equals("View Usage Record")){
            new ViewUsageRecord(meter).setVisible(true);
        }else if(msg.equals("Raise Issue")){
            new raise_issue(meter).setVisible(true);
        }
        else if(msg.equals("Deposit Details")){
            new DepositDetails().setVisible(true);
        }else if(msg.equals("View Information")){
            new ViewInformation(meter).setVisible(true);
        }else if(msg.equals("View Notifications")){
            new viewNotifications(meter).setVisible(true);
        }
        else if(msg.equals("Send Notifications")){
            new Type_of_notification().setVisible(true);
        }
        else if(msg.equals("Update Information")){
            new UpdateInformation(meter).setVisible(true);
        }else if(msg.equals("Bill Details")){
            new BillDetails(meter).setVisible(true);
        }
        else if(msg.equals("Set Account status")){
            new blockcustomer().setVisible(true);
        }else if(msg.equals("Delete Account")){
            try{
            Conn c = new Conn();
            int temp = JOptionPane.showConfirmDialog(null,"Are you sure to delete your account?");
            if(temp==JOptionPane.YES_OPTION){
   
                c.s.executeUpdate("DELETE FROM login WHERE meter_no="+meter);
                c.s.executeUpdate("DELETE FROM bill WHERE meter="+meter);
                c.s.executeUpdate("DELETE FROM customer WHERE meter="+meter);
                c.s.executeUpdate("DELETE FROM meter_info WHERE meter_number="+meter);
                c.s.executeUpdate("DELETE FROM record WHERE meter_number="+meter);
                this.setVisible(false);
                new Login().setVisible(true);
            }
            
            }catch(Exception e){
            System.out.println(e);}
        }
        else if(msg.equals("delete my account")){
            try{
            Conn c = new Conn();
            int temp1= JOptionPane.showConfirmDialog(null,"Are you sure to delete your account?");
            if(temp1==JOptionPane.YES_OPTION){
   
                c.s.executeUpdate("DELETE FROM login WHERE username= '"+Username+"' ");
                this.setVisible(false);
                new Login().setVisible(true);
            }
            
            }catch(Exception e){
            System.out.println(e);}
        }
  
    }
    
    
    public static void main(String[] args){
        new Project("", "", "").setVisible(true);
    }
    
}
