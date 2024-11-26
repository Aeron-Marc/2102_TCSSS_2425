package Main;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Admin extends javax.swing.JFrame {

    
    public Admin() {
        initComponents();    
        customertbl.getTableHeader().setFont(new Font(" Segoe UI", Font.BOLD, 12));
         customertbl.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getClickCount() == 1) {
                int selectedRow = customertbl.rowAtPoint(e.getPoint());

                if (selectedRow >= 0 && selectedRow < customertbl.getRowCount()) {
                    DefaultTableModel model = (DefaultTableModel) customertbl.getModel();
                    String customerId = model.getValueAt(selectedRow, 0).toString();
                    String customerName = model.getValueAt(selectedRow, 1).toString();
                    String contactInfo = model.getValueAt(selectedRow, 2).toString();

                    custIDField.setText(customerId);
                    custNameField.setText(customerName);
                    contactInfoField.setText(contactInfo);
                    }
                }
            }
        });
    }
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        Brand = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Brand2 = new javax.swing.JLabel();
        homebtn = new javax.swing.JButton();
        customerbtn = new javax.swing.JButton();
        orderbtn = new javax.swing.JButton();
        itembtn = new javax.swing.JButton();
        paymentbtn = new javax.swing.JButton();
        userbtn = new javax.swing.JButton();
        staffredirectbtn = new javax.swing.JButton();
        logoutbtn = new javax.swing.JButton();
        Brand3 = new javax.swing.JLabel();
        admintabs = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        customertbl = new javax.swing.JTable();
        modifyPanel = new javax.swing.JPanel();
        addbtn = new javax.swing.JButton();
        updatebtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        custIDField = new javax.swing.JTextField();
        custNameField = new javax.swing.JTextField();
        contactInfoField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Head1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jTextField6 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        searchbtn = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ordertbl = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        Head = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        customertbl2 = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        customertbl3 = new javax.swing.JTable();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        customertbl4 = new javax.swing.JTable();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        customertbl5 = new javax.swing.JTable();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(111, 78, 55));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Brand.setFont(new java.awt.Font("MS PGothic", 0, 56)); // NOI18N
        Brand.setForeground(new java.awt.Color(255, 255, 255));
        Brand.setText("l");
        Brand.setIconTextGap(0);
        jPanel4.add(Brand, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 30, 70));

        jLabel2.setFont(new java.awt.Font("Segoe Print", 0, 8)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tea and Coffee Shop");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, 10));

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

        Brand3.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        Brand3.setForeground(new java.awt.Color(255, 255, 255));
        Brand3.setText("TCAF");
        Brand3.setIconTextGap(0);
        jPanel4.add(Brand3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 60, 40));

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

        customertbl.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, null));
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

        modifyPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, null));

        addbtn.setText("Add");
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });

        updatebtn.setText("Update");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });

        deletebtn.setText("Delete");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });

        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        jLabel3.setText("Customer Name:");

        jLabel4.setText("Contact Info:");

        jLabel5.setText("Customer ID:");

        javax.swing.GroupLayout modifyPanelLayout = new javax.swing.GroupLayout(modifyPanel);
        modifyPanel.setLayout(modifyPanelLayout);
        modifyPanelLayout.setHorizontalGroup(
            modifyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modifyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(modifyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, modifyPanelLayout.createSequentialGroup()
                        .addGroup(modifyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(modifyPanelLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(modifyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(contactInfoField, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(custNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, modifyPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(custIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(modifyPanelLayout.createSequentialGroup()
                        .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updatebtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        modifyPanelLayout.setVerticalGroup(
            modifyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, modifyPanelLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(modifyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(custIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(modifyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(custNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(modifyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contactInfoField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(modifyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addbtn)
                    .addComponent(updatebtn)
                    .addComponent(deletebtn)
                    .addComponent(clear))
                .addContainerGap())
        );

        Head1.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        Head1.setText("CUSTOMERS");
        Head1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Head1.setIconTextGap(0);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, null));

        jLabel1.setText("Search by ID:");

        searchbtn.setText("Search");
        searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchbtn)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(searchbtn)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(273, Short.MAX_VALUE)
                .addComponent(Head1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(233, 233, 233))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(modifyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(Head1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modifyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        admintabs.addTab("tab2", jPanel11);

        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ordertbl.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(ordertbl);

        jPanel12.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 111, 732, 359));

        jButton6.setText("jButton3");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel12.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 490, -1, -1));

        jButton7.setText("jButton2");
        jPanel12.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 540, -1, 73));

        jButton8.setText("jButton4");
        jPanel12.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 520, -1, 73));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton5.setText("Insert");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(119, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addContainerGap())
        );

        jPanel12.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 360, 160));

        Head.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        Head.setText("ORDERS");
        Head.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Head.setIconTextGap(0);
        jPanel12.add(Head, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 170, 40));

        admintabs.addTab("tab3", jPanel12);

        customertbl2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(customertbl2);

        jButton9.setText("jButton1");

        jButton10.setText("jButton3");

        jButton11.setText("jButton2");

        jButton12.setText("jButton4");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jButton11)
                        .addGap(18, 18, 18)
                        .addComponent(jButton12))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jButton9)
                        .addGap(18, 18, 18)
                        .addComponent(jButton10))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        admintabs.addTab("tab4", jPanel13);

        customertbl3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(customertbl3);

        jButton13.setText("jButton1");

        jButton14.setText("jButton3");

        jButton15.setText("jButton2");

        jButton16.setText("jButton4");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jButton15)
                        .addGap(18, 18, 18)
                        .addComponent(jButton16))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jButton13)
                        .addGap(18, 18, 18)
                        .addComponent(jButton14))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        admintabs.addTab("tab5", jPanel14);

        customertbl4.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(customertbl4);

        jButton17.setText("jButton1");

        jButton18.setText("jButton3");

        jButton19.setText("jButton2");

        jButton20.setText("jButton4");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jButton19)
                        .addGap(18, 18, 18)
                        .addComponent(jButton20))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jButton17)
                        .addGap(18, 18, 18)
                        .addComponent(jButton18))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton19, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(jButton20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        admintabs.addTab("tab6", jPanel15);

        customertbl5.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(customertbl5);

        jButton21.setText("jButton1");

        jButton22.setText("jButton3");

        jButton23.setText("jButton2");

        jButton24.setText("jButton4");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jButton23)
                        .addGap(18, 18, 18)
                        .addComponent(jButton24))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jButton21)
                        .addGap(18, 18, 18)
                        .addComponent(jButton22))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton23, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(jButton24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
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
        loadCustomer();
    }//GEN-LAST:event_customerbtnActionPerformed
    private void loadCustomer(){
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
    }
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

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
        String customerId = custIDField.getText();
        String customerName = custNameField.getText();
        String contactInfo = contactInfoField.getText();

        if (customerId.isEmpty() || customerName.isEmpty() || contactInfo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to add the following customer?\n\n" +
                "Customer ID: " + customerId + "\n" +
                "Customer Name: " + customerName + "\n" +
                "Contact Info: " + contactInfo,
                "Confirm Add",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Statement st = dbcon.dbconnect().createStatement();
                String checkSql = "SELECT COUNT(*) FROM customers WHERE CustomerID = '" + customerId + "'";
                ResultSet rs = st.executeQuery(checkSql);
                rs.next();
                int count = rs.getInt(1);

                if (count > 0) {
                    JOptionPane.showMessageDialog(this, "Customer ID already exists. Please use a different ID.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String sql = "INSERT INTO customers (CustomerID, Name, ContactInfo) VALUES ('"
                        + customerId + "', '" + customerName + "', '" + contactInfo + "')";
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(this, "Customer added successfully!");
                loadCustomer();
            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error adding customer: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
       
    }//GEN-LAST:event_addbtnActionPerformed

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
        String customerId = custIDField.getText();
        String customerName = custNameField.getText();
        String contactInfo = contactInfoField.getText();

        if (customerId.isEmpty() || customerName.isEmpty() || contactInfo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to update the following customer?\n\n" +
                "Customer ID: " + customerId + "\n" +
                "Customer Name: " + customerName + "\n" +
                "Contact Info: " + contactInfo,
                "Confirm Update",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Statement st = dbcon.dbconnect().createStatement();
                String sql = "UPDATE customers SET Name = '" + customerName + "', ContactInfo = '" + contactInfo + "' WHERE CustomerID = '" + customerId + "'";
                int rowsAffected = st.executeUpdate(sql);

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Customer updated successfully!");
                    loadCustomer(); // Refresh the customer table
                } else {
                    JOptionPane.showMessageDialog(this, "Customer ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error updating customer: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }                               
        
    }//GEN-LAST:event_updatebtnActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        custIDField.setText("");
        custNameField.setText("");
        contactInfoField.setText("");
    }//GEN-LAST:event_clearActionPerformed

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
        String customerId = custIDField.getText();
        String customerName = custNameField.getText();
        String contactInfo = contactInfoField.getText();

        if (customerId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a Customer ID to delete", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Show confirmation dialog
        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete the following customer?\n\n" +
                "Customer ID: " + customerId + "\n" +
                "Customer Name: " + customerName + "\n" +
                "Contact Info: " + contactInfo,
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Statement st = dbcon.dbconnect().createStatement();
                String sql = "DELETE FROM customers WHERE CustomerID = '" + customerId + "'";
                int rowsAffected = st.executeUpdate(sql);

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Customer deleted successfully!");
                    loadCustomer(); // Refresh the customer table
                } else {
                    JOptionPane.showMessageDialog(this, "Customer ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error deleting customer: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_deletebtnActionPerformed

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed
        String searchId = jTextField6.getText().trim();

        if (searchId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a Customer ID to search", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Statement st = dbcon.dbconnect().createStatement();
            String sql = "SELECT * FROM customers WHERE CustomerID = '" + searchId + "'";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                custIDField.setText(rs.getString("CustomerID"));
                custNameField.setText(rs.getString("Name"));
                contactInfoField.setText(rs.getString("ContactInfo"));
            } else {
                JOptionPane.showMessageDialog(this, "Customer ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error searching customer: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_searchbtnActionPerformed

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
    private javax.swing.JLabel Brand2;
    private javax.swing.JLabel Brand3;
    private javax.swing.JLabel Head;
    private javax.swing.JLabel Head1;
    private javax.swing.JButton addbtn;
    private javax.swing.JTabbedPane admintabs;
    private javax.swing.JButton clear;
    private javax.swing.JTextField contactInfoField;
    private javax.swing.JTextField custIDField;
    private javax.swing.JTextField custNameField;
    private javax.swing.JButton customerbtn;
    private javax.swing.JTable customertbl;
    private javax.swing.JTable customertbl2;
    private javax.swing.JTable customertbl3;
    private javax.swing.JTable customertbl4;
    private javax.swing.JTable customertbl5;
    private javax.swing.JButton deletebtn;
    private javax.swing.JButton homebtn;
    private javax.swing.JButton itembtn;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JButton logoutbtn;
    private javax.swing.JPanel modifyPanel;
    private javax.swing.JButton orderbtn;
    private javax.swing.JTable ordertbl;
    private javax.swing.JButton paymentbtn;
    private javax.swing.JButton searchbtn;
    private javax.swing.JButton staffredirectbtn;
    private javax.swing.JButton updatebtn;
    private javax.swing.JButton userbtn;
    // End of variables declaration//GEN-END:variables
}
