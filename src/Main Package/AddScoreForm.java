import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


public class AddScoreForm extends javax.swing.JFrame {

    course cr = new course();
    student std = new student();
    score sc = new score();
    
    DefaultTableModel model;
     
    public AddScoreForm(){
        initComponents();
        cr.fillCourseCombo(jComboBoxCourseID);
        std.fillStudentJtable(jTableScore, "");
             
        HideColumn(6);
        HideColumn(5);
        HideColumn(4);
        HideColumn(3);
        
        model = (DefaultTableModel) jTableScore.getModel();
        jTableScore.setRowHeight(30);
        jTableScore.setShowGrid(true);
        jTableScore.setGridColor(Color.getHSBColor(199, 238, 144));
        jTableScore.setSelectionBackground(Color.getHSBColor(152, 251, 152));
    }

    private void HideColumn(int collIndex){
        TableColumn col = jTableScore.getColumnModel().getColumn(collIndex);
        col.setMaxWidth(0);
        col.setMinWidth(0);
        col.setPreferredWidth(0);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldStudentID = new javax.swing.JTextField();
        jButtonAddScore = new javax.swing.JButton();
        jButtonCancel1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableScore = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxCourseID = new javax.swing.JComboBox<>();
        jTextField_Score = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField_Description = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setBackground(new java.awt.Color(204, 255, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 72)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 0));
        jLabel1.setText("Add Score");
        jLabel1.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("Student Id:");

        jLabel3.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 51));
        jLabel3.setText("Score:");

        jTextFieldStudentID.setForeground(new java.awt.Color(0, 51, 51));
        jTextFieldStudentID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextFieldStudentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldStudentIDActionPerformed(evt);
            }
        });

        jButtonAddScore.setBackground(new java.awt.Color(153, 153, 255));
        jButtonAddScore.setFont(new java.awt.Font("Raleway", 1, 24)); // NOI18N
        jButtonAddScore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/plus.png"))); // NOI18N
        jButtonAddScore.setText("Add");
        jButtonAddScore.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButtonAddScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddScoreActionPerformed(evt);
            }
        });

        jButtonCancel1.setBackground(new java.awt.Color(255, 153, 153));
        jButtonCancel1.setFont(new java.awt.Font("Raleway", 1, 24)); // NOI18N
        jButtonCancel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/minus.png"))); // NOI18N
        jButtonCancel1.setText("Cancel");
        jButtonCancel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButtonCancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancel1ActionPerformed(evt);
            }
        });

        jTableScore.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTableScore.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "First Name", " Last Name", "Sex", "BirthDate", "Phone", "Address"
            }
        ));
        jTableScore.setSelectionForeground(new java.awt.Color(204, 255, 204));
        jTableScore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableScoreMouseClicked(evt);
            }
        });
        jTableScore.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableScoreKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableScore);

        jLabel5.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 51));
        jLabel5.setText("Course Id: ");

        jComboBoxCourseID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxCourseID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCourseIDActionPerformed(evt);
            }
        });

        jTextField_Score.setForeground(new java.awt.Color(0, 51, 51));
        jTextField_Score.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField_Score.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_ScoreActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 51));
        jLabel6.setText("Decription:");

        jTextField_Description.setForeground(new java.awt.Color(0, 51, 51));
        jTextField_Description.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField_Description.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_DescriptionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldStudentID))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonCancel1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(jLabel5))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel6)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(115, 115, 115)
                                                .addComponent(jButtonAddScore, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField_Description))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jComboBoxCourseID, 0, 273, Short.MAX_VALUE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField_Score)))))))
                        .addGap(14, 14, 14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonAddScore, jButtonCancel1});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_Score, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField_Description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancel1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAddScore, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldStudentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldStudentIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldStudentIDActionPerformed

    private void jButtonAddScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddScoreActionPerformed
        // check if student_id and course_id existed
        // (Compare student_id & course_id from DB tables with student and course input id)
        // Check if Both student_id and course_id existed from score table (make over) -> slower cause' more process (2 tables)
        // or cr.isCourseExisted && std.isStudentExisted from course and student (already have course) -> faster, take date from 1 table
        String selected_course = jComboBoxCourseID.getSelectedItem().toString();

        // assign studentID and courseID to stdId & crsId
        int stdId = Integer.valueOf(jTextFieldStudentID.getText());
        int crsId = cr.getCourseId(selected_course);
        double score = Double.valueOf(jTextField_Score.getText());
        String description =  jTextField_Description.getText();
        
        // Check if student course score existed yet.
        if (!sc.isStdID_CrsID_Exist(stdId, crsId)){
           System.out.println(crsId);
           sc.insertUpdateDeleteScore('i', stdId, crsId, score, description);


           EditDeleteScore.jTableScoreDecr.setModel(new DefaultTableModel(null, new Object[]{"Student Id","Course Id","Score","Decription"}));
           sc.fillScoreJtable(EditDeleteScore.jTableScoreDecr, "");

           showScoreForm.jTableShowAll.setModel(new DefaultTableModel(null, new Object[]{"student_id","course_id","score","description"}));
           sc.showAllScores(showScoreForm.jTableShowAll, "");
        }
        else{
            JOptionPane.showMessageDialog(null, "Student course Score Already Exist", "Add Again", 2);

        }
        
       
    }//GEN-LAST:event_jButtonAddScoreActionPerformed

    private void jButtonCancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancel1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancel1ActionPerformed

    private void jTableScoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableScoreMouseClicked
        // get data from selected row
        int rowIndex = jTableScore.getSelectedRow();
        jTextFieldStudentID.setText(jTableScore.getValueAt(rowIndex, 0).toString());
        
        // get value from row at index ? and row ? to refer TextField
        // toString() because TextField is String type
              
        
        
        
    }//GEN-LAST:event_jTableScoreMouseClicked

    private void jTableScoreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableScoreKeyReleased
      // None
    }//GEN-LAST:event_jTableScoreKeyReleased

    private void jTextField_ScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_ScoreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_ScoreActionPerformed

    private void jTextField_DescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_DescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DescriptionActionPerformed

    private void jComboBoxCourseIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCourseIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCourseIDActionPerformed

    
    public static void main(String args[]) {
     
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddScoreForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddScoreForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddScoreForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddScoreForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddScoreForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddScore;
    private javax.swing.JButton jButtonCancel1;
    private javax.swing.JComboBox<String> jComboBoxCourseID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTableScore;
    private javax.swing.JTextField jTextFieldStudentID;
    private javax.swing.JTextField jTextField_Description;
    private javax.swing.JTextField jTextField_Score;
    // End of variables declaration//GEN-END:variables
}
