//package Bank.management.system;
package bank.management.system;
import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.sql.*;
 
public class Login  extends JFrame implements ActionListener{
    
    JButton signUp, signIn, clear; 
    JTextField cardTextField; 
    JPasswordField pinTextField;  // IT WILL SHOW THE PASSWORD FORMAT.
    
    Login() {
        
        setTitle("AUTOMATED TELLER MACHINE");
        
        setLayout(null);     // this will let the setBounds to work if it is null;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/logo.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        
        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200, 40, 400, 40);
        add(text);
        
        JLabel cardNo = new JLabel("Card No: ");
        cardNo.setFont(new Font("Raleway",Font.BOLD,28));
        cardNo.setBounds(120, 150, 150, 30);
        add(cardNo);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Ariel", Font.BOLD, 14 ));
        cardTextField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(cardTextField);
        
        JLabel pin = new JLabel("Pin: ");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120, 220, 250, 30);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 30);
        pinTextField.setFont(new Font("Ariel", Font.BOLD, 14 ));
        pinTextField.setBorder(BorderFactory.createLineBorder(Color.GRAY));    // ADDITIONAL BORDER
        add(pinTextField);
        
        signIn = new JButton("Sign in");
        signIn.setBounds(300, 300, 100, 30);
        signIn.setBackground(Color.BLACK);
        signIn.setForeground(Color.WHITE);
        signIn.addActionListener(this);
        add(signIn);
        
        clear = new JButton("Clear");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signUp = new JButton("Sign up");
        signUp.setBounds(300, 350, 230, 30);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(this);
        add(signUp);
        
        getContentPane().setBackground(Color.WHITE);
        
       
        
        
        setSize(800,480);  // THIS WILL SET THE SIZE OF FRAME
        setVisible(true);
        setLocation(350,100);
    }
    
    public void actionPerformed(ActionEvent ae){      
        
        // OVERRIDING THE ABSTRACT METHOD actionPerformed PRESENTT IN ACTIONLISTENER CLASS.
                
        if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        }else if(ae.getSource() == signIn){
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();       // password area
            String query = "Select * from login where cardnumber = '"+cardnumber+"' and pin = '" + pinnumber + "'";
            try {
             ResultSet rs = conn.s.executeQuery(query);       // DDL COMMAND EXECUTE QUERY
                if (rs.next()) {
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card number or Pin");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }else if(ae.getSource()==signUp){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}

