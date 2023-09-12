import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class course {
   
    public void insertUpdateDeleteCourse(char operation, Integer id, String label, Integer hours) {

        Connection con = MyConnection.getConnection();
        PreparedStatement ps;

        // i for insert
        // Caution: ' ' for char " " for String
        if (operation == 'i') {
            try {
                // if want to get data from DB table. Must goes use 'con' as a conenctor
                ps = con.prepareStatement("INSERT INTO `course`(`label`, `hours`) VALUES (?,?)");
//                ps.setInt(0, id); 
                ps.setString(1, label);
                ps.setInt(2, hours);
 
                
                // id add automatic cally from the DB. so there no need to Insert Id
                // Message apeared after INSERT (if total update student > 0)
                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "New Course Added");
                }

            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
        
        if (operation == 'u') {
            try {
                // if want to get data from DB table. Must goes use 'con' as a conenctor
                ps = con.prepareStatement("UPDATE `course` SET `label`= ?,`hours`= ? WHERE `id` = ?");
                ps.setString(1, label);
                ps.setInt(2, hours);
                ps.setInt(3, id);

                // Message apeared after INSERT (if total update student > 0)
                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Course Updated");
                }
            }
            catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (operation == 'd') {
            try {
                    // if want to get data from DB table. Must goes use 'con' as a conenctor
                    ps = con.prepareStatement("DELETE FROM `course` WHERE `id` = ?");
                    ps.setInt(1, id);

                    // id add automatic cally from the DB. so there no need to Insert Id
                    // Message apeared after INSERT (if total update student > 0)
                    if (ps.executeUpdate() > 0) {
                        JOptionPane.showMessageDialog(null, "Course Deleted");
                }
            }
            catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    // get course name and check if it exist
    // False By default -> Then we make it true When
    public boolean isCourseExist(String courseName){
     
        boolean isExist = false;
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        try {
      
            ps = con.prepareStatement("SELECT * FROM `course` WHERE `label` = ?");
            //set ? from %valuetoSearch%
            ps.setString(1, courseName);

            // execute table with command above 
            ResultSet rs = ps.executeQuery();
     

            // scan if the next element existed then Return true 
            if (rs.next()) {
                return true;  
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return isExist;
    }
    
    public void fillCourseJtable(JTable table, String valueToSearch) {
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        try {
            // Get all data in refered column from student table that have %something% init
            ps = con.prepareStatement("SELECT * FROM `course`");

            // execute table with command above 
            ResultSet rs = ps.executeQuery();
            // assign Defualt table model 
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            // set each student Object data as row
            Object[] row;

            // get student info from data base (data present in row)
            while (rs.next()) {
                // innitialize array length
                row = new Object[3];
                // assigned data to row array
                row[0] = rs.getInt(1); // Id
                row[1] = rs.getString(2); // Label
                row[2] = rs.getInt(3); // hours
                
                // add row array to my table model
                model.addRow(row);
            }

        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // return course_Id with corresponding label (take Label as string, return Id as Integer)
    public int getCourseId(String courseLabel){
        int courseId = 0;
        
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        try {
      
            ps = con.prepareStatement("SELECT * FROM `course` WHERE `label` = ?");
            //set ? from %valuetoSearch%
            ps.setString(1, courseLabel);

            // execute table with command above 
            ResultSet rs = ps.executeQuery();
     

            // scan if the next element existed then Return true 
            if (rs.next()) {
                courseId = rs.getInt("id");
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return courseId;
    }
    
    // fill combo option with choice (the line that have multiple choices)
    public void fillCourseCombo(JComboBox Combo) {
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        Combo.removeAllItems(); // remove all default items from ComboBox
        
        try {
            // Get all data in refered column from student table that have %something% init
            ps = con.prepareStatement("SELECT * FROM `course`");
            ResultSet rs = ps.executeQuery();
           

            // get student info from data base (data present in row)
            while (rs.next()) {
                Combo.addItem(rs.getString(2)); // get items label column in DB table
            }

        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    
   




