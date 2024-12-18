/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author leand
 */
public class Login extends javax.swing.JFrame {

    
    public Login() {
        initComponents();
        username.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            loginbtnActionPerformed(evt); 
            }
        });

        password.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            loginbtnActionPerformed(evt); 
            }
        });
        
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Brand = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Wall = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Tag1 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        Tag2 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        Tag3 = new javax.swing.JLabel();
        loginbtn = new javax.swing.JButton();
        clearbtn = new javax.swing.JButton();
        loginbtn1 = new javax.swing.JButton();
        Tag4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Brand.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        Brand.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pics/logo.png"))); // NOI18N
        Brand.setText("TCAF");
        Brand.setIconTextGap(0);
        getContentPane().add(Brand, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, 40));

        jLabel2.setFont(new java.awt.Font("Segoe Print", 0, 8)); // NOI18N
        jLabel2.setText("Tea and Coffee Shop");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, -1, 10));

        Wall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pics/wall.png"))); // NOI18N
        getContentPane().add(Wall, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 242, 225));

        Tag1.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        Tag1.setText("Login");

        username.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        username.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 10, 2, 10));
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        Tag2.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        Tag2.setText("Username:");

        password.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        password.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 10, 2, 10));
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });

        Tag3.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        Tag3.setText("Password:");

        loginbtn.setBackground(new java.awt.Color(255, 254, 255));
        loginbtn.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        loginbtn.setText("Login");
        loginbtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        loginbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbtnActionPerformed(evt);
            }
        });

        clearbtn.setBackground(new java.awt.Color(255, 254, 255));
        clearbtn.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        clearbtn.setText("Clear");
        clearbtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtnActionPerformed(evt);
            }
        });

        loginbtn1.setBackground(new java.awt.Color(255, 254, 255));
        loginbtn1.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        loginbtn1.setText("Sign Up");
        loginbtn1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        loginbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbtn1ActionPerformed(evt);
            }
        });

        Tag4.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        Tag4.setText("No account?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Tag3)
                    .addComponent(Tag2)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(password, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(loginbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(clearbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(73, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Tag1)
                        .addGap(136, 136, 136))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Tag4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loginbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(Tag1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(Tag2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(Tag3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Tag4)
                    .addComponent(loginbtn1))
                .addGap(31, 31, 31))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 370, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private boolean isPassVisible = false;
    private String loggedInUser;
    
    private void loginbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbtnActionPerformed
        String userName, passWord, userDB = null, passDB = null, usertypeDB = null;
        boolean found = false;
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tcsss_oop","root", "");
            Statement st = con.createStatement();
            
            if(username.getText().equals("")){
                JOptionPane.showMessageDialog(new JFrame(), "Username is required", "Error!", JOptionPane.ERROR_MESSAGE);
            } 
            else if (password.getText().equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Password is required", "Error!", JOptionPane.ERROR_MESSAGE);     
            }
            else {
                userName    = username.getText();
                passWord = password.getText();  
                
                ResultSet rs = st.executeQuery("SELECT * FROM users WHERE Username = '" + userName + "'");
                while(rs.next()){
                userDB = rs.getString("Username");
                passDB = rs.getString("Password");
                usertypeDB = rs.getString("User_type");
                found = true;
                }
                
                if (found && passWord.equals(passDB) && "Admin".equals(usertypeDB)){
                    loggedInUser = userDB;    
                    new Admin(loggedInUser).setVisible(true);
                        this.dispose();
                    }
                else if (found && passWord.equals(passDB) && "Staff".equals(usertypeDB)){
                        new MainStaff().setVisible(true);
                        this.dispose();
                    }
                else {
                    JOptionPane.showMessageDialog(new JFrame(), "Incorrect email or password", "Error!", JOptionPane.ERROR_MESSAGE);
                    password.setText("");
                    }
                    
            }
            
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
    }//GEN-LAST:event_loginbtnActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        
    }//GEN-LAST:event_usernameActionPerformed

    private void clearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtnActionPerformed
        
        username.setText("");
        password.setText("");     
    }//GEN-LAST:event_clearbtnActionPerformed

    private void loginbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbtn1ActionPerformed
        // TODO add your handling code here:
        Signup signup = new Signup();
        signup.setVisible(true);
        dispose();
    }//GEN-LAST:event_loginbtn1ActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed
    
    public String getLoggedInUser() {
        return loggedInUser;
    }
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Brand;
    private javax.swing.JLabel Tag1;
    private javax.swing.JLabel Tag2;
    private javax.swing.JLabel Tag3;
    private javax.swing.JLabel Tag4;
    private javax.swing.JLabel Wall;
    private javax.swing.JButton clearbtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginbtn;
    private javax.swing.JButton loginbtn1;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
