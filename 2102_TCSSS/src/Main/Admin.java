package Main;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Admin extends javax.swing.JFrame {

    
    public Admin() {
        initComponents();    
        customertbl.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
    }
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        Brand = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Brand1 = new javax.swing.JLabel();
        Brand2 = new javax.swing.JLabel();
        homebtn = new javax.swing.JButton();
        customerbtn = new javax.swing.JButton();
        orderbtn = new javax.swing.JButton();
        itembtn = new javax.swing.JButton();
        paymentbtn = new javax.swing.JButton();
        userbtn = new javax.swing.JButton();
        staffredirectbtn = new javax.swing.JButton();
        logoutbtn = new javax.swing.JButton();
        admintabs = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        customertbl = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(111, 78, 55));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Brand.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        Brand.setForeground(new java.awt.Color(255, 255, 255));
        Brand.setText("l");
        Brand.setIconTextGap(0);
        jPanel4.add(Brand, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 20, 50));

        jLabel2.setFont(new java.awt.Font("Segoe Print", 0, 8)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tea and Coffee Shop");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 10));

        Brand1.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        Brand1.setForeground(new java.awt.Color(255, 255, 255));
        Brand1.setText("TCAF");
        Brand1.setIconTextGap(0);
        jPanel4.add(Brand1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 40));

        Brand2.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        Brand2.setForeground(new java.awt.Color(255, 255, 255));
        Brand2.setText("Admin");
        Brand2.setIconTextGap(0);
        jPanel4.add(Brand2, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 10, 50, 50));

        homebtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        homebtn.setForeground(new java.awt.Color(255, 255, 255));
        homebtn.setText("Home");
        homebtn.setBorderPainted(false);
        homebtn.setContentAreaFilled(false);
        homebtn.setFocusPainted(false);
        homebtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        homebtn.setRequestFocusEnabled(false);
        homebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homebtnActionPerformed(evt);
            }
        });
        jPanel4.add(homebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 200, -1));

        customerbtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        customerbtn.setForeground(new java.awt.Color(255, 255, 255));
        customerbtn.setText("Customers");
        customerbtn.setBorderPainted(false);
        customerbtn.setContentAreaFilled(false);
        customerbtn.setFocusPainted(false);
        customerbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        customerbtn.setRequestFocusEnabled(false);
        customerbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerbtnActionPerformed(evt);
            }
        });
        jPanel4.add(customerbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 200, -1));

        orderbtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        orderbtn.setForeground(new java.awt.Color(255, 255, 255));
        orderbtn.setText("Orders");
        orderbtn.setBorderPainted(false);
        orderbtn.setContentAreaFilled(false);
        orderbtn.setFocusPainted(false);
        orderbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        orderbtn.setRequestFocusEnabled(false);
        orderbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderbtnActionPerformed(evt);
            }
        });
        jPanel4.add(orderbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 200, -1));

        itembtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        itembtn.setForeground(new java.awt.Color(255, 255, 255));
        itembtn.setText("Items");
        itembtn.setBorderPainted(false);
        itembtn.setContentAreaFilled(false);
        itembtn.setFocusPainted(false);
        itembtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        itembtn.setRequestFocusEnabled(false);
        itembtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itembtnActionPerformed(evt);
            }
        });
        jPanel4.add(itembtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 200, -1));

        paymentbtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        paymentbtn.setForeground(new java.awt.Color(255, 255, 255));
        paymentbtn.setText("Payments");
        paymentbtn.setBorderPainted(false);
        paymentbtn.setContentAreaFilled(false);
        paymentbtn.setFocusPainted(false);
        paymentbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        paymentbtn.setRequestFocusEnabled(false);
        paymentbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentbtnActionPerformed(evt);
            }
        });
        jPanel4.add(paymentbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 200, -1));

        userbtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        userbtn.setForeground(new java.awt.Color(255, 255, 255));
        userbtn.setText("Users");
        userbtn.setBorderPainted(false);
        userbtn.setContentAreaFilled(false);
        userbtn.setFocusPainted(false);
        userbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        userbtn.setRequestFocusEnabled(false);
        userbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userbtnActionPerformed(evt);
            }
        });
        jPanel4.add(userbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 200, -1));

        staffredirectbtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        staffredirectbtn.setForeground(new java.awt.Color(255, 255, 255));
        staffredirectbtn.setText("Staff UI");
        staffredirectbtn.setBorderPainted(false);
        staffredirectbtn.setContentAreaFilled(false);
        staffredirectbtn.setFocusPainted(false);
        staffredirectbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        staffredirectbtn.setRequestFocusEnabled(false);
        staffredirectbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffredirectbtnActionPerformed(evt);
            }
        });
        jPanel4.add(staffredirectbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 200, -1));

        logoutbtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        logoutbtn.setForeground(new java.awt.Color(255, 255, 255));
        logoutbtn.setText("Logout");
        logoutbtn.setBorderPainted(false);
        logoutbtn.setContentAreaFilled(false);
        logoutbtn.setFocusPainted(false);
        logoutbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        logoutbtn.setRequestFocusEnabled(false);
        logoutbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutbtnActionPerformed(evt);
            }
        });
        jPanel4.add(logoutbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 200, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 640));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
        );

        admintabs.addTab("tab1", jPanel10);

        customertbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Customer ID", "Customer Name", "Contact Info"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(customertbl);

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        jButton3.setText("jButton3");

        jButton4.setText("jButton4");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        admintabs.addTab("tab2", jPanel11);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
        );

        admintabs.addTab("tab3", jPanel12);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
        );

        admintabs.addTab("tab4", jPanel13);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
        );

        admintabs.addTab("tab5", jPanel14);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
        );

        admintabs.addTab("tab6", jPanel15);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
        );

        admintabs.addTab("tab7", jPanel16);

        getContentPane().add(admintabs, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, -70, 780, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutbtnActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_logoutbtnActionPerformed

    private void homebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homebtnActionPerformed
        admintabs.setSelectedIndex(0);
    }//GEN-LAST:event_homebtnActionPerformed

    private void customerbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerbtnActionPerformed
        admintabs.setSelectedIndex(1);
        try {
            Statement st = dbcon.dbconnect().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM customers");
            
            DefaultTableModel model = (DefaultTableModel)customertbl.getModel();
            
            model.setRowCount(0);
            
            while(rs.next()){
                model.addRow(new String[]{rs.getString(1), rs.getString(2), rs.getString(3)});
            }
            
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(MainAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_customerbtnActionPerformed

    private void orderbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderbtnActionPerformed
        admintabs.setSelectedIndex(2);
    }//GEN-LAST:event_orderbtnActionPerformed

    private void itembtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itembtnActionPerformed
        admintabs.setSelectedIndex(3);
    }//GEN-LAST:event_itembtnActionPerformed

    private void paymentbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentbtnActionPerformed
        admintabs.setSelectedIndex(4);
    }//GEN-LAST:event_paymentbtnActionPerformed

    private void userbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userbtnActionPerformed
        admintabs.setSelectedIndex(5);
    }//GEN-LAST:event_userbtnActionPerformed

    private void staffredirectbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffredirectbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_staffredirectbtnActionPerformed

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Brand;
    private javax.swing.JLabel Brand1;
    private javax.swing.JLabel Brand2;
    private javax.swing.JTabbedPane admintabs;
    private javax.swing.JButton customerbtn;
    private javax.swing.JTable customertbl;
    private javax.swing.JButton homebtn;
    private javax.swing.JButton itembtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutbtn;
    private javax.swing.JButton orderbtn;
    private javax.swing.JButton paymentbtn;
    private javax.swing.JButton staffredirectbtn;
    private javax.swing.JButton userbtn;
    // End of variables declaration//GEN-END:variables
}
