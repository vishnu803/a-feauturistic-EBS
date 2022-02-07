package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class window_after_block extends JFrame implements ActionListener{
    String meter;
    window_after_block(String meter, String person){
        super("Electricity Billing System");
        this.meter = meter;
        
        setBounds(500, 200, 600,525);
        
        /* Adding background image */
        ImageIcon ic =  new ImageIcon(ClassLoader.getSystemResource("icon/Image3.jpeg.png"));
        Image i3 = ic.getImage().getScaledInstance(570, 460,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        JLabel l1 = new JLabel(icc3);
        add(l1);
        
        JMenuBar mb  = new JMenuBar();
        JMenu Bill = new JMenu("Bill");
        JMenuItem m1 = new JMenuItem("Pay Bill");
        Bill.setForeground(Color.BLUE);
        
        m1.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image image1 = icon1.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        m1.setIcon(new ImageIcon(image1));
        m1.setMnemonic('P');
        m1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        m1.setBackground(Color.WHITE);
        
        JMenu issue = new JMenu("issue");
        JMenuItem u1 = new JMenuItem("Raise Issue");
        issue.setForeground(Color.BLUE);
         
        u1.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icon/raise.png"));
        Image image2 = icon2.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        u1.setIcon(new ImageIcon(image1));
        u1.setMnemonic('U');
        u1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
        u1.setBackground(Color.WHITE);
        
        u1.addActionListener(this);
        m1.addActionListener(this);
        
        JMenu exit = new JMenu("exit");
        JMenuItem ex = new JMenuItem("Logout");
        JMenuItem d = new JMenuItem("Delete Account");
        exit.setForeground(Color.RED);
        
        /* ---- Exit ---- */
        ex.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image image11 = icon11.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ex.setIcon(new ImageIcon(image11));
        ex.setMnemonic('Z');
        ex.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        ex.setBackground(Color.WHITE);
        
        ex.addActionListener(this);
        
        d.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon22 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image image22 = icon22.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        d.setIcon(new ImageIcon(image22));
        d.setMnemonic('A');
        d.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        d.setBackground(Color.WHITE);
        
        d.addActionListener(this);
        
        Bill.add(m1);
        issue.add(u1);
        exit.add(ex);
        exit.add(d);
        
        mb.add(Bill);
        mb.add(issue);
        mb.add(exit);
        
        setJMenuBar(mb);
        setFont(new Font("Senserif",Font.BOLD,16));
        setLayout(new FlowLayout());
    }
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if(msg.equals("Pay Bill")){
            new PayBill(meter).setVisible(true);
           
        }else if(msg.equals("Logout")){
            this.setVisible(false);
            new Login().setVisible(true);
        }
        else if(msg.equals("Raise Issue")){
            new raise_issue(meter).setVisible(true);
        }
        else if(msg.equals("Delete Account")){
            try{
            Conn c = new Conn();
            int temp = JOptionPane.showConfirmDialog(null,"Are you sure to delete your account?");
            if(temp==JOptionPane.YES_OPTION){
   
                c.s.executeUpdate("DELETE FROM login WHERE meter_no="+meter);
                c.s.executeUpdate("DELETE FROM bill WHERE meter="+meter);
                c.s.executeUpdate("DELETE FROM customer WHERE meter="+meter);
                c.s.executeUpdate("DELETE FROM meter_info WHERE meter_number="+meter);
                this.setVisible(false);
                new Login().setVisible(true);
            }
            
            }catch(Exception e){
            System.out.println("wrong");}
        }
  
    }
    
    
    public static void main(String[] args){
        new window_after_block("", "").setVisible(true);
    }
    
}
