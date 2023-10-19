package bank.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
 
public class Conn {           // JDBC CONNECTIVITY
    
      
    Statement s;
    Connection c;
    public Conn(){
        
        try {
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Sanjay99@.com");
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
