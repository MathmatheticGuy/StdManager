package StudentPackage;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyFunction {

    public static int countData(String tableName) {
        int total = 0;
        Connection con = MyConnection.getConnection();
        Statement st;

        try {
            st = con.createStatement(); // can be buggy sometime. Still don't know why it run?
            // Access to every element in the table
            ResultSet rs = st.executeQuery("SELECT COUNT(*) AS 'total' FROM " + tableName);

            // while there element in the table. Like count in an Array
            while (rs.next()) {
                total = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MyFunction.class.getName()).log(Level.SEVERE, null, ex);
        }

        return total;
    }
    
}
