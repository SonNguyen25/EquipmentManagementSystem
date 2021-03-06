/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipment.management.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Bao Son
 */
public class ReturnEquipment extends javax.swing.JFrame {
    Connection connection = null;
    ResultSet resultSet;
    PreparedStatement preparedStatement;
    /**
     * Creates new form ReturnEquipment
     */
    public ReturnEquipment() {
        super("Return Equipment");
        initComponents();
        EquipmentIDTextField.setVisible(false);
        connection = new JavaConnectionDataBase().connectToDatabase();
    }
    
    public void DeleteBorrowEquipmentByUser() {
        String sqlDelete = "DELETE FROM Borrow WHERE Email = ? AND EquipmentID = ?";
        try {
            preparedStatement = connection.prepareStatement(sqlDelete);
            preparedStatement.setString(1, EmailTextField.getText());
            preparedStatement.setString(2, EquipmentIDTextField.getText());
            preparedStatement.execute();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void UpdateReturnEquipmentByUser() {
        String sqlUpdate = "INSERT INTO [Return] (Email, FullName, EquipmentID, BorrowDate, DateOfReturn)  VALUES (?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, EmailTextField.getText());
            preparedStatement.setString(2, FullNameTextField.getText());
            preparedStatement.setString(3, EquipmentIDTextField.getText());
            preparedStatement.setString(4, BorrowedDateTextField.getText());
            preparedStatement.setString(5, ReturnDateComboBox.getText());
            preparedStatement.execute();
            resultSet.close();
            preparedStatement.close();
            JOptionPane.showMessageDialog(null, "Equipment with Name: " + EquipmentNameTextField.getText() + " Returned");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void Search() {
        String sqlSearchStudentEmailBorrowEquipment = "SELECT * FROM Borrow \n" +
                                                "  INNER JOIN Equipment ON Borrow.EquipmentID = Equipment.EquipmentID\n" +
                                                "  WHERE Borrow.Email = ? ORDER BY Borrow.DateBorrow DESC";
        try {
            preparedStatement = connection.prepareStatement(sqlSearchStudentEmailBorrowEquipment);
            preparedStatement.setString(1, EmailTextField.getText());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next() == false) {
                EquipmentCodeTextField.setText("");
                EquipmentNameTextField.setText("");
                ReturnDateComboBox.setText("");
                BorrowedDateTextField.setText("");
                TimeReturnedTextField.setText("");
                resultSet.close();
                preparedStatement.close();
                JOptionPane.showMessageDialog(null, "Student with this email: " +  EmailTextField.getText() + " have not borrowed any equipment");
            }
        } catch (Exception e) {
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        ReturnEquipmentPanel = new javax.swing.JPanel();
        EquipmentNameLabel = new javax.swing.JLabel();
        BorrowedDateLabel = new javax.swing.JLabel();
        ClassLabel = new javax.swing.JLabel();
        ClassTextField = new javax.swing.JTextField();
        BorrowedDateTextField = new javax.swing.JTextField();
        EmailLabel = new javax.swing.JLabel();
        EquipmentCodeTextField = new javax.swing.JTextField();
        EmailTextField = new javax.swing.JTextField();
        FullNameTextField = new javax.swing.JTextField();
        EquipmentCodeLabel = new javax.swing.JLabel();
        FullNameLabel = new javax.swing.JLabel();
        EquipmentNameTextField = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        TimeReturnedLabel = new javax.swing.JLabel();
        TimeReturnedTextField = new javax.swing.JTextField();
        ReturnDateLabel = new javax.swing.JLabel();
        ReturnDateComboBox = new datechooser.beans.DateChooserCombo();
        ReturnButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();
        StudentIDTextField = new javax.swing.JTextField();
        EquipmentIDTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ReturnEquipmentPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)), "Return Equipment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 153, 204))); // NOI18N

        EquipmentNameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        EquipmentNameLabel.setText("Equipment Name");

        BorrowedDateLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BorrowedDateLabel.setText("Borrowed Date");

        ClassLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ClassLabel.setText("Class");

        ClassTextField.setEditable(false);
        ClassTextField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        BorrowedDateTextField.setEditable(false);
        BorrowedDateTextField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        EmailLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        EmailLabel.setText("Email");

        EquipmentCodeTextField.setEditable(false);
        EquipmentCodeTextField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        FullNameTextField.setEditable(false);
        FullNameTextField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        EquipmentCodeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        EquipmentCodeLabel.setText("Equipment Code");

        FullNameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        FullNameLabel.setText("Full Name");

        EquipmentNameTextField.setEditable(false);
        EquipmentNameTextField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        SearchButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SearchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search-icon.png"))); // NOI18N
        SearchButton.setText("Search");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        TimeReturnedLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TimeReturnedLabel.setText("Time Returned");

        TimeReturnedTextField.setEditable(false);
        TimeReturnedTextField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        ReturnDateLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ReturnDateLabel.setText("Return Date:");

        ReturnDateComboBox.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 14));

        ReturnButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ReturnButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/return-button-icon.png"))); // NOI18N
        ReturnButton.setText("Return");
        ReturnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnButtonActionPerformed(evt);
            }
        });

        BackButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        StudentIDTextField.setEditable(false);

        EquipmentIDTextField.setEditable(false);

        javax.swing.GroupLayout ReturnEquipmentPanelLayout = new javax.swing.GroupLayout(ReturnEquipmentPanel);
        ReturnEquipmentPanel.setLayout(ReturnEquipmentPanelLayout);
        ReturnEquipmentPanelLayout.setHorizontalGroup(
            ReturnEquipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReturnEquipmentPanelLayout.createSequentialGroup()
                .addGroup(ReturnEquipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReturnEquipmentPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SearchButton))
                    .addGroup(ReturnEquipmentPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(ReturnEquipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ReturnEquipmentPanelLayout.createSequentialGroup()
                                .addGroup(ReturnEquipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(EmailLabel)
                                    .addComponent(FullNameLabel)
                                    .addComponent(ClassLabel))
                                .addGap(77, 77, 77)
                                .addGroup(ReturnEquipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ClassTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                                    .addComponent(FullNameTextField)
                                    .addComponent(EmailTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))
                                .addGap(60, 60, 60)
                                .addGroup(ReturnEquipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(EquipmentCodeLabel)
                                    .addComponent(EquipmentNameLabel)
                                    .addComponent(BorrowedDateLabel)
                                    .addComponent(TimeReturnedLabel)))
                            .addGroup(ReturnEquipmentPanelLayout.createSequentialGroup()
                                .addComponent(StudentIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(EquipmentIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22)
                        .addGroup(ReturnEquipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(BorrowedDateTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EquipmentCodeTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EquipmentNameTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TimeReturnedTextField)
                            .addGroup(ReturnEquipmentPanelLayout.createSequentialGroup()
                                .addComponent(ReturnDateLabel)
                                .addGap(74, 74, 74)
                                .addGroup(ReturnEquipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ReturnEquipmentPanelLayout.createSequentialGroup()
                                        .addComponent(ReturnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28)
                                        .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(ReturnDateComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 27, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ReturnEquipmentPanelLayout.setVerticalGroup(
            ReturnEquipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReturnEquipmentPanelLayout.createSequentialGroup()
                .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ReturnEquipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReturnEquipmentPanelLayout.createSequentialGroup()
                        .addGroup(ReturnEquipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EquipmentCodeLabel)
                            .addComponent(EquipmentCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(ReturnEquipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EquipmentNameLabel)
                            .addComponent(EquipmentNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(160, 160, 160))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReturnEquipmentPanelLayout.createSequentialGroup()
                        .addComponent(EmailLabel)
                        .addGap(49, 49, 49)
                        .addGroup(ReturnEquipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FullNameLabel)
                            .addComponent(FullNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(ReturnEquipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BorrowedDateLabel)
                            .addComponent(BorrowedDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ClassLabel)
                            .addComponent(ClassTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(ReturnEquipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TimeReturnedLabel)
                            .addComponent(TimeReturnedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)))
                .addGroup(ReturnEquipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ReturnEquipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(ReturnDateLabel)
                        .addComponent(ReturnDateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ReturnEquipmentPanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(ReturnEquipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(StudentIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EquipmentIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(ReturnEquipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ReturnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(ReturnEquipmentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ReturnEquipmentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        String sqlSearchStudentEmailBorrowEquipment = "SELECT * FROM Borrow \n" +
                                                "  INNER JOIN Equipment ON Borrow.EquipmentID = Equipment.EquipmentID\n" +
                                                "  WHERE Borrow.Email = ? ORDER BY Borrow.DateBorrow DESC";
        try {
            preparedStatement = connection.prepareStatement(sqlSearchStudentEmailBorrowEquipment);
            preparedStatement.setString(1, EmailTextField.getText());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                EquipmentIDTextField.setText(resultSet.getString("EquipmentID"));
                FullNameTextField.setText(resultSet.getString("FullName"));
                ClassTextField.setText(resultSet.getString("Class"));
                EquipmentCodeTextField.setText(resultSet.getString("EquipmentCode"));
                EquipmentNameTextField.setText(resultSet.getString("EquipmentName"));
                ReturnDateComboBox.setText(resultSet.getString("ReturnDate"));
                BorrowedDateTextField.setText(resultSet.getString("DateBorrow").substring(0, 10));
                TimeReturnedTextField.setText(resultSet.getString("TimeReturned"));
                resultSet.close();
                preparedStatement.close();
            }
            else {
                JOptionPane.showMessageDialog(null, "Student with this email: " +  EmailTextField.getText() + " have not borrowed any equipment");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(ReturnEquipment.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        setVisible(false);
        DashBoard dashBoard = new DashBoard();
        dashBoard.setVisible(true);
    }//GEN-LAST:event_BackButtonActionPerformed

    private void ReturnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnButtonActionPerformed
        DeleteBorrowEquipmentByUser();
        UpdateReturnEquipmentByUser();
        Search();
    }//GEN-LAST:event_ReturnButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReturnEquipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnEquipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnEquipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnEquipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnEquipment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JLabel BorrowedDateLabel;
    private javax.swing.JTextField BorrowedDateTextField;
    private javax.swing.JLabel ClassLabel;
    private javax.swing.JTextField ClassTextField;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JTextField EmailTextField;
    private javax.swing.JLabel EquipmentCodeLabel;
    private javax.swing.JTextField EquipmentCodeTextField;
    private javax.swing.JTextField EquipmentIDTextField;
    private javax.swing.JLabel EquipmentNameLabel;
    private javax.swing.JTextField EquipmentNameTextField;
    private javax.swing.JLabel FullNameLabel;
    private javax.swing.JTextField FullNameTextField;
    private javax.swing.JButton ReturnButton;
    private datechooser.beans.DateChooserCombo ReturnDateComboBox;
    private javax.swing.JLabel ReturnDateLabel;
    private javax.swing.JPanel ReturnEquipmentPanel;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTextField StudentIDTextField;
    private javax.swing.JLabel TimeReturnedLabel;
    private javax.swing.JTextField TimeReturnedTextField;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
