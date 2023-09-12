
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class score {
   
    public void insertUpdateDeleteScore(char operation, Integer student_id, Integer course_id, double score, String description) {

        Connection con = MyConnection.getConnection();
        PreparedStatement ps;

        // i for insert
        // Caution: ' ' for char " " for String
        if (operation == 'i') {
            try {
                // if want to get data from DB table. Must goes use 'con' as a conenctor
                ps = con.prepareStatement("INSERT INTO `score`(`student_id`, `course_id`, `student_score`, `description`) VALUES (?,?,?,?)");
                ps.setInt(1, student_id);
                ps.setInt(2, course_id);
                ps.setDouble(3, score);
                ps.setString(4, description);
                
                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "New Score Added");
                }

            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
    
    
        if (operation == 'u') {
            try {
                ps = con.prepareStatement("UPDATE `score` SET `student_score`= ?, `description`= ? WHERE `student_id`= ?");
                ps.setDouble(1, score);
                ps.setString(2, description);
                ps.setInt(3, student_id);
                

                // Message apeared after INSERT (if total update student > 0)
                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Student Score Updated");
                }
            }
            catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    
        if (operation == 'd') {
            try {
                    // if want to get data from DB table. Must goes use 'con' as a conenctor
                    ps = con.prepareStatement("DELETE FROM `score` WHERE `student_id` = ?");
                    ps.setInt(1, student_id);

                    // id add automatic cally from the DB. so there no need to Insert Id
                    // Message apeared after INSERT (if total update student > 0)
                    if (ps.executeUpdate() > 0) {
                        JOptionPane.showMessageDialog(null, "Student Score Deleted");
                }
            }
            catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
   public boolean isStdID_CrsID_Exist(int student_id, int course_id){
       
        boolean isExist = false;
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        
        try {
      
            ps = con.prepareStatement("SELECT * FROM `score` WHERE `student_id`= ? AND `course_id`= ?");
            //set ? from %valuetoSearch%
            ps.setInt(1, student_id);
            ps.setInt(2, course_id);

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
    
        
    public void fillScoreJtable(JTable table, String valueToSearch) {
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        try {
            // Get all data in refered column from student table that have %something% init
            ps = con.prepareStatement("SELECT * FROM `score`");

            // execute table with command above 
            ResultSet rs = ps.executeQuery();
            // assign Defualt table model 
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            // set each student Object data as row
            Object[] row;

            // get student info from data base (data present in row)
            while (rs.next()) {
                // innitialize array length
                row = new Object[4];
                // assigned data to row array
                row[0] = rs.getInt(1); // Student Id                   
                row[1] = rs.getInt(2); // Course Id                    
                row[2] = rs.getDouble(3); // Score                
                row[3] = rs.getString(4); // Decription     
                
                // add row array to my table model
                model.addRow(row);
            }

        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public void showAllScores(JTable table, String valueToSearch) {
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        
        try {
            // Select data from `score` table then (remember to breakline)
            // join student_id cloumn in student table, (remember to breakline)
            // join course_id cloumn in course table. (end. no breakline)
            ps = con.prepareStatement("SELECT `student_id`, firstName, lastName, label, student_score\n"
                    + "FROM `score`\n"
                    + "INNER JOIN student as stab on stab.id = `student_id`\n"
                    + "INNER JOIN course as ctab on ctab.id = `course_id`");

            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            
            Object[] row;
            
            // add each row in table to row array.
            while (rs.next()) {
                // Declare array length
                row = new Object[5];
                // assigned data to row array
                row[0] = rs.getInt(1); // student_id
                row[1] = rs.getString(2); // firstName
                row[2] = rs.getString(3); // lastName
                row[3] = rs.getString(4); // label
                row[4] = rs.getDouble(5); // student_score

                // add row array to my table model
                model.addRow(row);
            }

        }
        catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
}