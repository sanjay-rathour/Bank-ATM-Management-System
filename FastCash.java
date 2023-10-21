package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FastCash extends JFrame implements ActionListener{
    
    JButton deposit, withdrawel ,fastCash, miniStatement, balEnquiry, exit, pinchange;
    String pinnumber;
            
    FastCash(String pinnumber)  {
        
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 700);
        add(image);
        
        JLabel text = new JLabel("Please Select your Transactions");
        text.setBounds(215, 190, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);   // ADD TEXT OVER THE IMAGE
        
        deposit = new JButton("Rs 100");
        deposit.setBounds(170, 315, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawel = new JButton("Rs 500");
        withdrawel.setBounds(355, 350, 150, 30);
        withdrawel.addActionListener(this);
        image.add(withdrawel);
        
        fastCash = new JButton("Rs 1000");
        fastCash.setBounds(170, 385, 150, 30);
        fastCash.addActionListener(this);
        image.add(fastCash);
        
        miniStatement = new JButton("Rs 2000");
        miniStatement.setBounds(355, 315, 150, 30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);
        
        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(170, 350, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balEnquiry = new JButton("Rs 10000");
        balEnquiry.setBounds(355, 385, 150, 30);
        balEnquiry.addActionListener(this);
        image.add(balEnquiry);
        
        exit = new JButton("Back");
        exit.setBounds(355, 420, 150, 30);
        exit.addActionListener(this);
        image.add(exit);
        
        
        setSize(900, 900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if (ae.getSource() == exit) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else {
            String amount = ((JButton)ae.getSource()).getText().substring(3); // For removing Rs_ from Rs 100 and others
            Conn conn = new Conn();
            try {
                ResultSet rs = conn.s.executeQuery("Select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (ae.getSource() != exit && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient balance");
                    return;
                }
                
                Date date = new Date();
                conn.s.executeUpdate("insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs "+amount+ " Debited Successfully");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    

    public static void main(String args[]) {
        
        new FastCash("");
        
    }
}
