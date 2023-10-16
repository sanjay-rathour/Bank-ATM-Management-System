//package Bank.management.system;
package bank.management.system;

import java.awt.*;
import javax.swing.*;          // SWING CONTAINS JFRAME CLASS.
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    
    Long random;
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pincodeTextField;
    JButton nextButton;
    JRadioButton male, female, other, married, unmarried;
    JDateChooser dateChooser;
    
    
    SignupOne() {
        
        Random ran = new Random();           // RANDOM CLASS IS INSIDE UTIL PACKAGE.
        random = Math.abs(ran.nextLong() % 4000L + 1000L);
        
        
        setLayout(null);
        
        JLabel formNo = new JLabel("APPLICATION FROM NO. " + random);
        formNo.setFont(new Font("Raleway", Font.BOLD, 38));
        formNo.setBounds(140, 10, 600, 40);
        add(formNo);
        
        JLabel personalDetail = new JLabel("Page 1: Personal Details");
        personalDetail.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetail.setBounds(290, 60, 400, 30);
        add(personalDetail);
        
        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 110, 200, 30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 110, 400, 30);
        nameTextField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(nameTextField);
        
        JLabel fname = new JLabel("Father's Name: ");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 160, 200, 30);
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(300, 160, 400, 30);
        fnameTextField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(fnameTextField);
        
        JLabel dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 210, 200, 30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 210, 400, 30);
        dateChooser.setForeground(new Color(105,105, 105));  // 
        dateChooser.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(dateChooser);
                
        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 260, 200, 30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300, 260, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBackground(Color.WHITE);
        female.setBounds(400, 260, 100, 30);
        add(female);
        
        ButtonGroup genderGroup = new ButtonGroup();   // MAKING RADIOBUTTON.
        genderGroup.add(male);
        genderGroup.add(female);
        
        JLabel email = new JLabel("Email Address: ");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 310, 200, 30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 310, 400, 30);
        emailTextField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(emailTextField);
        
        JLabel maritalStatus = new JLabel("Marital Status: ");
        maritalStatus.setFont(new Font("Raleway", Font.BOLD, 20));
        maritalStatus.setBounds(100, 360, 200, 30);
        add(maritalStatus);
        
        married = new JRadioButton("Married");
        married.setBounds(300, 360, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBackground(Color.WHITE);
        unmarried.setBounds(400, 360, 100, 30);
        add(unmarried);
        
        other = new JRadioButton("Other");
        other.setBackground(Color.WHITE);
        other.setBounds(500, 360, 100, 30);
        add(other);
        
        
        ButtonGroup maritalGroup = new ButtonGroup();   // RADIOBUTTON
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);
       
        
        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 410, 200, 30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300, 410, 400, 30);
        addressTextField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(addressTextField);
        
        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 460, 200, 30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 460, 400, 30);
        cityTextField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(cityTextField);
        
        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 510, 200, 30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300, 510, 400, 30);
        stateTextField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(stateTextField);
        
        JLabel pincode = new JLabel("Pincode: ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 560, 200, 30);
        add(pincode);
        
        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodeTextField.setBounds(300, 560, 300, 30);
        pincodeTextField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(pincodeTextField);
        
        
        nextButton = new JButton("Next");
        nextButton.setBounds(620, 560, 80, 30);
        nextButton.setBackground(Color.BLACK);
        nextButton.setForeground(Color.WHITE);
        nextButton.setFont(new Font("Raleway",Font.BOLD,14));
        nextButton.addActionListener(this);
        add(nextButton);
        
        getContentPane().setBackground(Color.WHITE);  // COLOR CLASS IS INSIDE AWT PACKAGE.
        
        setSize(850, 750);                  // CREATING THE FRAME.
        setLocation(350, 10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){      // overriding the method.
         String formno = "" + random; //Long
         String name = nameTextField.getText();
         String fname = fnameTextField.getText();
         String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
         String gender = null;
         if (male.isSelected()) {
             gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }
         String email = emailTextField.getText();
         String marital = null;
         if (married.isSelected()) {
            marital = "Married";
        }else if (unmarried.isSelected()) {
            marital = "Unmarried";
        }else if(other.isSelected()){
            marital = "other";
        }
         String address = addressTextField.getText();
         String city = cityTextField.getText();
         String state = stateTextField.getText();
         String pincode = pincodeTextField.getText();
         
         try {        // EXCEPTION HANDLING.
             if (name.equals("")) {
                 JOptionPane.showMessageDialog(null, "Name is required");   // popup
             }
             if (fname.equals("")) {
                 JOptionPane.showMessageDialog(null, "Father's Name is required");
             }if (email.equals("")) {
                 JOptionPane.showMessageDialog(null, "Email is required");
             }if (address.equals("")) {
                 JOptionPane.showMessageDialog(null, "Address is required");
             }if (city.equals("")) {
                 JOptionPane.showMessageDialog(null, "City is required");
             }if (state.equals("")) {
                 JOptionPane.showMessageDialog(null, "State is required");
             }if (pincode.equals("")) {
                 JOptionPane.showMessageDialog(null, "Pincode is required");
             }
             else{
                 Conn c = new Conn();
                 String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
                 c.s.executeUpdate(query);
                 
                   setVisible(false);
                   new SignupTwo(formno).setVisible(true);
             }
             
        } 
         catch (Exception e) {
             System.out.println(e);
        }
         
    }
    
    public static void main(String args[]) {
        new SignupOne();
    }
}