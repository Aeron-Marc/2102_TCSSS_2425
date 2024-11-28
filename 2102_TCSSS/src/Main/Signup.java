/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author leand
 */
public class Signup extends javax.swing.JFrame {

    /**
     * Creates new form Signup
     */
    public Signup() {
        initComponents();
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
        namesignup = new javax.swing.JTextField();
        emailsignup = new javax.swing.JTextField();
        confirmpasssignup = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        createaccbtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        backloginbtn = new javax.swing.JButton();
        status = new javax.swing.JComboBox<>();
        statusbtn = new javax.swing.JLabel();
        passsignup1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 242, 225));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        namesignup.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        namesignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namesignupActionPerformed(evt);
            }
        });
        jPanel1.add(namesignup, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 241, 31));

        emailsignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailsignupActionPerformed(evt);
            }
        });
        jPanel1.add(emailsignup, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 241, 34));

        confirmpasssignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmpasssignupActionPerformed(evt);
            }
        });
        jPanel1.add(confirmpasssignup, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 241, 34));

        jLabel2.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jLabel2.setText("Username:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 85, -1));

        jLabel3.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jLabel3.setText("Email:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 57, -1));

        jLabel4.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jLabel4.setText("Confirm Password:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 140, -1));

        jLabel5.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel5.setText("Sign Up");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 18, -1, 36));

        createaccbtn.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        createaccbtn.setText("Create Account");
        createaccbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createaccbtnActionPerformed(evt);
            }
        });
        jPanel1.add(createaccbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, -1, -1));

        jLabel6.setText("I have an account");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, -1, -1));

        backloginbtn.setText("Log In");
        backloginbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backloginbtnActionPerformed(evt);
            }
        });
        jPanel1.add(backloginbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 320, -1, -1));

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Staff" }));
        status.setSelectedIndex(-1);
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });
        jPanel1.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 130, 30));

        statusbtn.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        statusbtn.setText("Status:");
        jPanel1.add(statusbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, -1, -1));

        passsignup1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passsignup1ActionPerformed(evt);
            }
        });
        jPanel1.add(passsignup1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 241, 34));

        jLabel7.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jLabel7.setText("Password:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 71, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 420, 370));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pics/wall2.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void namesignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namesignupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namesignupActionPerformed

    private void emailsignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailsignupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailsignupActionPerformed

    private void confirmpasssignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmpasssignupActionPerformed
        // TODO add your handling code here:
               
    }//GEN-LAST:event_confirmpasssignupActionPerformed

    private void createaccbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createaccbtnActionPerformed
        String usernameSignup = namesignup.getText().trim();
        String passwordSignup = passsignup1.getText().trim();
        String confirmPasswordSignup = confirmpasssignup.getText().trim();
        String emailSignup = emailsignup.getText().trim();
        String statusSignup = (String) status.getSelectedItem();

        // Input validation
        if (usernameSignup.isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "Username is required", "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (passwordSignup.isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "Password is required", "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (confirmPasswordSignup.isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "Confirm Password is required", "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!passwordSignup.equals(confirmPasswordSignup)) {
            JOptionPane.showMessageDialog(new JFrame(), "Passwords do not match", "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (emailSignup.isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "Email is required", "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (statusSignup == null) {
            JOptionPane.showMessageDialog(new JFrame(), "Status is required", "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection con = dbcon.dbconnect()) {
            if (con != null) {
                // Check if the username already exists
                String checkUser Query = "SELECT * FROM users WHERE Username = ?";
                try (PreparedStatement ps = con.prepareStatement(checkUser Query)) {
                    ps.setString(1, usernameSignup);
                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(new JFrame(), "Username already exists.", "Error!", JOptionPane.ERROR_MESSAGE);
                    } else {
                        // Insert new user into the database
                        String insertQuery = "INSERT INTO users (Username, Password, Email, Status) VALUES (?, ?, ?, ?)";
                        try (PreparedStatement insertPs = con.prepareStatement(insertQuery)) {
                            insertPs.setString(1, usernameSignup);
                            insertPs.setString(2, passwordSignup); // Consider hashing the password before storing
                            insertPs.setString(3, emailSignup);
                            insertPs.setString(4, statusSignup);
                            insertPs.executeUpdate();
                        }
                        JOptionPane.showMessageDialog(this, "Account created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        new Login().setVisible(true);
                        this.dispose();
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Database error: " + ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_createaccbtnActionPerformed

    private boolean validateInputs(String username, String password, String confirmPassword, String email, String status) {
        if (username.isEmpty()) {
            showError("Username is required.");
            return false;
        }
        if (password.isEmpty()) {
            showError("Password is required.");
            return false;
        }
        if (confirmPassword.isEmpty()) {
            showError("Confirm Password is required.");
            return false;
        }
        if (email.isEmpty()) {
            showError("Email is required.");
            return false;
        }
        if (status == null || status.isEmpty()) {
            showError("Status is required.");
            return false;
        }
        return true;
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error!", JOptionPane.ERROR_MESSAGE);
    }
    
    
    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusActionPerformed

    private void backloginbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backloginbtnActionPerformed
        // TODO add your handling code here:
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_backloginbtnActionPerformed

    private void passsignup1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passsignup1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passsignup1ActionPerformed

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
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backloginbtn;
    private javax.swing.JTextField confirmpasssignup;
    private javax.swing.JButton createaccbtn;
    private javax.swing.JTextField emailsignup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField namesignup;
    private javax.swing.JTextField passsignup1;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JLabel statusbtn;
    // End of variables declaration//GEN-END:variables
}
