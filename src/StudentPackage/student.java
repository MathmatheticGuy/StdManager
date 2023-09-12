import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class student {

    public void insertUpdateDeleteStudent(char operation, Integer id, String fName, String lName,
        String sex, String bdate, String phone, String address) {

        Connection con = MyConnection.getConnection();
        PreparedStatement ps;

        // i for insert
        // Caution: ' ' for char " " for String
        if (operation == 'i') {
            try {
                // if want to get data from DB table. Must goes use 'con' as a conenctor
                ps = con.prepareStatement("INSERT INTO student(firstName, lastName, sex, birth, phone, address) VALUES (?,?,?,?,?,?)");
                ps.setString(1, fName);
                ps.setString(2, lName);
                ps.setString(3, sex);
                ps.setString(4, bdate);
                ps.setString(5, phone);
                ps.setString(6, address);
                // id add automatic cally from the DB. so there no need to Insert Id
                
                // Message apeared after INSERT (if total update student > 0)
                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "New Student Address");
                }

            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        if (operation == 'u') {
            try {
                // if want to get data from DB table. Must goes use 'con' as a conenctor
                ps = con.prepareStatement("UPDATE `student` SET `firstName`= ?,`lastName`= ?,`sex`= ?,`birth`= ?,`phone`= ?,`address`= ? WHERE `id`= ?");

                ps.setString(1, fName);
                ps.setString(2, lName);
                ps.setString(3, sex);
                ps.setString(4, bdate);
                ps.setString(5, phone); 
                ps.setString(6, address); 
                ps.setInt(7, id); 
 
                // Message apeared after INSERT (if total update student > 0)
                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Student Data Update");
                }

            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (operation == 'd') {
            try {
                // if want to get data from DB table. Must goes use 'con' as a conenctor
                ps = con.prepareStatement("DELETE FROM `student` WHERE `id` = ?");
                ps.setInt(1, id);             
 
                // Message apeared after INSERT (if total update student > 0)
                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Student Data Deleted");
                }

            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

     
    
    
    public void fillStudentJtable(JTable table, String valueToSearch) {
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        try {
            // Get all data in refered column from student table that have %something% init
            ps = con.prepareStatement("SELECT * FROM `student` WHERE CONCAT(`firstName`, `lastName`,`sex`, `birth`, `phone`, `address`)LIKE  ?");
            //set ? from %valuetoSearch%
            ps.setString(1, "%" + valueToSearch + "%");

            // execute table with command above 
            ResultSet rs = ps.executeQuery();
            // assign Defualt table model 
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            // set each student Object data as row
            Object[] row;

            // get student info from data base (data present in row)
            while (rs.next()) {
                // innitialize array length
                row = new Object[7];
                // assigned data to row array
                row[0] = rs.getInt(1); // Id
                row[1] = rs.getString(2); // Fname
                row[2] = rs.getString(3); // Lname
                row[3] = rs.getString(4); // Sex
                row[4] = rs.getString(5); // Birthdate
                row[5] = rs.getString(6); // Phone
                row[6] = rs.getString(7); // Address

                // add row array to my table model
                model.addRow(row);
            }

        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
