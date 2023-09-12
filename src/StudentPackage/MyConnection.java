import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

// using phpMyAdmin
public class MyConnection {
    public static Connection getConnection(){
        Connection con = null;
        
        try {
            // change deprecated path "com.mysql.jdbc.Driver" to "com.mysql.cj.jdbc.Driver" 
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/stdmgdb", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return con;
    }
}
