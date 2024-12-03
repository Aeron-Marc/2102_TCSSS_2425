package Main;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Admin extends javax.swing.JFrame {

    private final String username;
    
    public Admin(String username) {
        this.username = username;
        
        initComponents(); 
        welcomemsg.setText("Welcome " + username + "!");
        customertbl.getTableHeader().setFont(new Font(" Segoe UI", Font.BOLD, 12));
        ordertbl.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        itemtbl.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        paymenttbl.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        usertbl.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        orderdetailstbl.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        
        customertbl.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getClickCount() == 1) {
                int selectedRow = customertbl.rowAtPoint(e.getPoint());

                if (selectedRow >= 0 && selectedRow < customertbl.getRowCount()) {
                    DefaultTableModel model = (DefaultTableModel) customertbl.getModel();
                    String customerId = model.getValueAt(selectedRow, 0).toString();
                    String customerName = model.getValueAt(selectedRow, 1).toString();

                    custIDField.setText(customerId);
                    custNameField.setText(customerName);
                    }
                }
            }
        });
        
        ordertbl.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getClickCount() == 1) {
                int selectedRow = ordertbl.rowAtPoint(e.getPoint());
                if (selectedRow >= 0 && selectedRow < ordertbl.getRowCount()) {
                    DefaultTableModel model = (DefaultTableModel) ordertbl.getModel();
                    String orderId = model.getValueAt(selectedRow, 0).toString();
                    String customerId = model.getValueAt(selectedRow, 1).toString();
                    String orderDate = model.getValueAt(selectedRow, 2).toString();
                    String totalAmount = model.getValueAt(selectedRow, 3).toString();
                   
                    orderIDField.setText(orderId);
                    customerIDField.setText(customerId);
                    orderDateField.setText(orderDate);
                    totalAmountField.setText(totalAmount);
                    
                    loadOrderDetails(orderId);
                    }
                }
            }
        });
        
        orderdetailstbl.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getClickCount() == 1) {
                int selectedRow = orderdetailstbl.rowAtPoint(e.getPoint());
                if (selectedRow >= 0 && selectedRow < orderdetailstbl.getRowCount()) {
                    DefaultTableModel model = (DefaultTableModel) orderdetailstbl.getModel();

                    String itemId = model.getValueAt(selectedRow, 0).toString();
                    String itemName = model.getValueAt(selectedRow, 1).toString();
                    String price = model.getValueAt(selectedRow, 2).toString();
                    String quantity = model.getValueAt(selectedRow, 3).toString();
   
                    oditemID.setText(itemId);
                    oditemname.setText(itemName);
                    odprice.setText(price);
                       odquantity.setText(quantity);
                    }
                }
            }
        });
        
        itemtbl.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getClickCount() == 1) {
                int selectedRow = itemtbl.rowAtPoint(e.getPoint());
                if (selectedRow >= 0 && selectedRow < itemtbl.getRowCount()) {
                    DefaultTableModel model = (DefaultTableModel) itemtbl.getModel();
                    String itemId = model.getValueAt(selectedRow, 0).toString();
                    String itemName = model.getValueAt(selectedRow, 1).toString();
                    String price = model.getValueAt(selectedRow, 2).toString();
                    String category = model.getValueAt(selectedRow, 3).toString();
                    String description = model.getValueAt(selectedRow, 4).toString();
                    String stock = model.getValueAt(selectedRow, 5).toString();

                    itemIDField.setText(itemId);
                    itemNameField.setText(itemName);
                    priceField.setText(price);
                    descriptionField.setText(description);
                    stockField.setText(stock);

 
                    categoryfield.setSelectedItem(category);
                    }
                }
            }
        });
        
        paymenttbl.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getClickCount() == 1) {
                int selectedRow = paymenttbl.rowAtPoint(e.getPoint());
                if (selectedRow >= 0 && selectedRow < paymenttbl.getRowCount()) {
                    DefaultTableModel model = (DefaultTableModel) paymenttbl.getModel();
                    String paymentId = model.getValueAt(selectedRow, 0).toString();
                    String orderId = model.getValueAt(selectedRow, 1).toString();
                    String amount = model.getValueAt(selectedRow, 2).toString();
                    String paymentMethod = model.getValueAt(selectedRow, 3).toString();

                    paymentIDField.setText(paymentId);
                    orderIDField1.setText(orderId);
                    amountField.setText(amount);
                    paymentMethodField.setSelectedItem(paymentMethod); 
                    paymentStatusField.setSelectedItem(model.getValueAt(selectedRow, 4).toString()); 
                    }
                }
            }
        });
        
        usertbl.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getClickCount() == 1) {
                int selectedRow = usertbl.rowAtPoint(e.getPoint());
                if (selectedRow >= 0 && selectedRow < usertbl.getRowCount()) {
                    DefaultTableModel model = (DefaultTableModel) usertbl.getModel();
                    String userId = model.getValueAt(selectedRow, 0).toString();
                    String userName = model.getValueAt(selectedRow, 1).toString();
                    String email = model.getValueAt(selectedRow, 2).toString();
                    String password = model.getValueAt(selectedRow, 3).toString();
                    String usertype = model.getValueAt(selectedRow, 4).toString();

                    
                    userIDField.setText(userId);
                    userNameField.setText(userName);
                    emailField.setText(email);
                    passwordField.setText(password);
                    usertypeField.setSelectedItem(usertype); 
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
        sales = new javax.swing.JButton();
        logoutbtn = new javax.swing.JButton();
        Brand3 = new javax.swing.JLabel();
        admintabs = new javax.swing.JTabbedPane();
        homepanel = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        welcomemsg = new javax.swing.JLabel();
        customerPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        customertbl = new javax.swing.JTable();
        modifyPanel = new javax.swing.JPanel();
        customeraddbtn = new javax.swing.JButton();
        customerupdatebtn = new javax.swing.JButton();
        customerdeletebtn = new javax.swing.JButton();
        clearbtn1 = new javax.swing.JButton();
        custIDField = new javax.swing.JTextField();
        custNameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Head1 = new javax.swing.JLabel();
        searchpanel1 = new javax.swing.JPanel();
        jTextField6 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        customersearchbtn = new javax.swing.JButton();
        orderpanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ordertbl = new javax.swing.JTable();
        Head = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jTextField5 = new javax.swing.JTextField();
        ordersearchbtn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        orderIDField = new javax.swing.JTextField();
        customerIDField = new javax.swing.JTextField();
        orderDateField = new javax.swing.JTextField();
        totalAmountField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        orderaddbtn = new javax.swing.JButton();
        orderupdatebtn = new javax.swing.JButton();
        orderdeletebtn = new javax.swing.JButton();
        clearbtn2 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        orderdetailstbl = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        oditemID = new javax.swing.JTextField();
        oditemname = new javax.swing.JTextField();
        odprice = new javax.swing.JTextField();
        odquantity = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        odupdate = new javax.swing.JButton();
        odclear = new javax.swing.JButton();
        itempanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        itemtbl = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        itemIDField = new javax.swing.JTextField();
        itemNameField = new javax.swing.JTextField();
        priceField = new javax.swing.JTextField();
        descriptionField = new javax.swing.JTextField();
        stockField = new javax.swing.JTextField();
        itemaddbtn = new javax.swing.JButton();
        itemupdatebtn = new javax.swing.JButton();
        itemdeletebtn = new javax.swing.JButton();
        clearbtn3 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        categoryfield = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        itemsearchbtn = new javax.swing.JButton();
        jTextField17 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        paymentpanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        paymenttbl = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        paymentIDField = new javax.swing.JTextField();
        orderIDField1 = new javax.swing.JTextField();
        amountField = new javax.swing.JTextField();
        paymentMethodField = new javax.swing.JComboBox<>();
        paymentStatusField = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        payaddbtn = new javax.swing.JButton();
        payupdatebtn = new javax.swing.JButton();
        clearbtn4 = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jTextField20 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        paymentsearchbtn = new javax.swing.JButton();
        userspanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        usertbl = new javax.swing.JTable();
        jLabel29 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        userIDField = new javax.swing.JTextField();
        userNameField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        passwordField = new javax.swing.JTextField();
        usertypeField = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        useraddbtn = new javax.swing.JButton();
        userupdatebtn = new javax.swing.JButton();
        userdeletebtn = new javax.swing.JButton();
        clearbtn5 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        usersearchbtn = new javax.swing.JButton();
        salespanel = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        timeframe = new javax.swing.JComboBox<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        salestbl = new javax.swing.JTable();

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
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, 10));

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

        sales.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        sales.setForeground(new java.awt.Color(255, 255, 255));
        sales.setText("Sales");
        sales.setBorderPainted(false);
        sales.setContentAreaFilled(false);
        sales.setFocusPainted(false);
        sales.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sales.setRequestFocusEnabled(false);
        sales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesActionPerformed(evt);
            }
        });
        jPanel4.add(sales, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 200, -1));

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
        Brand3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pics/logowhite.png"))); // NOI18N
        Brand3.setText("TCAF");
        Brand3.setIconTextGap(1);
        jPanel4.add(Brand3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 110, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 640));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pics/home1.png"))); // NOI18N

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pics/home2.png"))); // NOI18N

        welcomemsg.setFont(new java.awt.Font("Segoe Script", 0, 48)); // NOI18N
        welcomemsg.setText("SAMPLE TEXT");
        welcomemsg.setToolTipText("");

        javax.swing.GroupLayout homepanelLayout = new javax.swing.GroupLayout(homepanel);
        homepanel.setLayout(homepanelLayout);
        homepanelLayout.setHorizontalGroup(
            homepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homepanelLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel39)
                .addGap(61, 61, 61))
            .addGroup(homepanelLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(welcomemsg, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );
        homepanelLayout.setVerticalGroup(
            homepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homepanelLayout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(welcomemsg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                .addGroup(homepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40))
                .addGap(62, 62, 62))
        );

        admintabs.addTab("hm", homepanel);

        customertbl.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, null));
        customertbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer ID", "Customer Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(customertbl);

        modifyPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, null));

        customeraddbtn.setText("Add");
        customeraddbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customeraddbtnActionPerformed(evt);
            }
        });

        customerupdatebtn.setText("Update");
        customerupdatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerupdatebtnActionPerformed(evt);
            }
        });

        customerdeletebtn.setText("Delete");
        customerdeletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerdeletebtnActionPerformed(evt);
            }
        });

        clearbtn1.setText("Clear");
        clearbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtn1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Customer Name:");

        jLabel5.setText("Customer ID:");

        javax.swing.GroupLayout modifyPanelLayout = new javax.swing.GroupLayout(modifyPanel);
        modifyPanel.setLayout(modifyPanelLayout);
        modifyPanelLayout.setHorizontalGroup(
            modifyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modifyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(modifyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, modifyPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(custNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, modifyPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(custIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(modifyPanelLayout.createSequentialGroup()
                        .addComponent(customeraddbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(customerupdatebtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(customerdeletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearbtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addGap(31, 31, 31)
                .addGroup(modifyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customeraddbtn)
                    .addComponent(customerupdatebtn)
                    .addComponent(customerdeletebtn)
                    .addComponent(clearbtn1))
                .addGap(35, 35, 35))
        );

        Head1.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        Head1.setText("CUSTOMERS");
        Head1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Head1.setIconTextGap(0);

        searchpanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, null));

        jLabel1.setText("Search by ID:");

        customersearchbtn.setText("Search");
        customersearchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customersearchbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchpanel1Layout = new javax.swing.GroupLayout(searchpanel1);
        searchpanel1.setLayout(searchpanel1Layout);
        searchpanel1Layout.setHorizontalGroup(
            searchpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchpanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(searchpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(customersearchbtn)
                    .addGroup(searchpanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        searchpanel1Layout.setVerticalGroup(
            searchpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchpanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(customersearchbtn)
                .addContainerGap())
        );

        javax.swing.GroupLayout customerPanelLayout = new javax.swing.GroupLayout(customerPanel);
        customerPanel.setLayout(customerPanelLayout);
        customerPanelLayout.setHorizontalGroup(
            customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerPanelLayout.createSequentialGroup()
                .addContainerGap(273, Short.MAX_VALUE)
                .addComponent(Head1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(233, 233, 233))
            .addGroup(customerPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(customerPanelLayout.createSequentialGroup()
                        .addComponent(modifyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchpanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        customerPanelLayout.setVerticalGroup(
            customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerPanelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(Head1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modifyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchpanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        admintabs.addTab("cust", customerPanel);

        orderpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ordertbl.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, null));
        ordertbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Customer ID", "Order Date", "Total Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(ordertbl);

        orderpanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 430, 310));

        Head.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        Head.setText("ORDERS");
        Head.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Head.setIconTextGap(0);
        orderpanel.add(Head, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 170, 40));

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, null));

        ordersearchbtn.setText("Search");
        ordersearchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordersearchbtnActionPerformed(evt);
            }
        });

        jLabel10.setText("Search by ID:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ordersearchbtn))
                        .addGap(61, 61, 61))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(120, 120, 120))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ordersearchbtn)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        orderpanel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 440, 170, 110));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, null));

        jLabel6.setText("Order ID:");

        jLabel7.setText("Customer ID:");

        jLabel8.setText("Order Date:");

        jLabel9.setText("Total Amount:");

        orderaddbtn.setText("Add");
        orderaddbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderaddbtnActionPerformed(evt);
            }
        });

        orderupdatebtn.setText("Update");
        orderupdatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderupdatebtnActionPerformed(evt);
            }
        });

        orderdeletebtn.setText("Delete");
        orderdeletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderdeletebtnActionPerformed(evt);
            }
        });

        clearbtn2.setText("Clear");
        clearbtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(customerIDField)
                            .addComponent(orderDateField)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(orderIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(totalAmountField)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(orderaddbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(orderupdatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(orderdeletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearbtn2)))
                .addGap(64, 64, 64))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orderIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orderDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orderaddbtn)
                    .addComponent(orderupdatebtn)
                    .addComponent(orderdeletebtn)
                    .addComponent(clearbtn2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        orderpanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 320, 210));

        orderdetailstbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Item Name", "Price (Each)", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(orderdetailstbl);

        orderpanel.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 300, 310));

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, null));

        odquantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odquantityActionPerformed(evt);
            }
        });

        jLabel11.setText("Item ID:");

        jLabel12.setText("Item Name:");

        jLabel13.setText("Price (Each):");

        jLabel14.setText("Quantity:");

        odupdate.setText("Update");
        odupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odupdateActionPerformed(evt);
            }
        });

        odclear.setText("Clear");
        odclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odclearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(odupdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel14))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(oditemID, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(oditemname)
                    .addComponent(odclear)
                    .addComponent(odprice)
                    .addComponent(odquantity))
                .addGap(92, 92, 92))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oditemID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oditemname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(odprice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(odquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(odupdate)
                    .addComponent(odclear))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        orderpanel.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 440, 230, 210));

        admintabs.addTab("order", orderpanel);

        itempanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        itemtbl.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, null));
        itemtbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Item Name", "Price", "Category", "Description", "Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(itemtbl);

        itempanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 720, 270));

        jLabel15.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        jLabel15.setText("Items");
        itempanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, null));

        itemNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNameFieldActionPerformed(evt);
            }
        });

        descriptionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriptionFieldActionPerformed(evt);
            }
        });

        itemaddbtn.setText("Add");
        itemaddbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemaddbtnActionPerformed(evt);
            }
        });

        itemupdatebtn.setText("Update");
        itemupdatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemupdatebtnActionPerformed(evt);
            }
        });

        itemdeletebtn.setText("Delete");
        itemdeletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemdeletebtnActionPerformed(evt);
            }
        });

        clearbtn3.setText("Clear");
        clearbtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtn3ActionPerformed(evt);
            }
        });

        jLabel16.setText("Item ID:");

        jLabel17.setText("Item Name:");

        jLabel18.setText("Price:");

        jLabel19.setText("Category:");

        jLabel20.setText("Description:");

        jLabel21.setText("Stock:");

        categoryfield.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Coffee", "Tea", "Pastries" }));
        categoryfield.setSelectedIndex(-1);
        categoryfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryfieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(itemNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(itemupdatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(itemdeletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(itemIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(itemaddbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(categoryfield, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(stockField, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                            .addComponent(descriptionField, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clearbtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemaddbtn)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemupdatebtn)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemdeletebtn)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(clearbtn3)
                        .addComponent(jLabel19))
                    .addComponent(categoryfield, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stockField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        itempanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 460, 260));

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, null));

        itemsearchbtn.setText("Search");
        itemsearchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemsearchbtnActionPerformed(evt);
            }
        });

        jLabel22.setText("Search by ID:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(itemsearchbtn))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField17)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 89, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(itemsearchbtn)
                .addContainerGap())
        );

        itempanel.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 400, 220, 120));

        admintabs.addTab("item", itempanel);

        paymenttbl.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, null));
        paymenttbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Payment ID", "Order ID", "Amount", "Payment Method", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(paymenttbl);

        jLabel23.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        jLabel23.setText("Payments");

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, null));

        paymentMethodField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Check", "Credit" }));
        paymentMethodField.setSelectedIndex(-1);

        paymentStatusField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unpaid", "Paid" }));
        paymentStatusField.setSelectedIndex(-1);

        jLabel24.setText("Payment ID:");

        jLabel25.setText("Order ID:");

        jLabel26.setText("Amount");

        jLabel27.setText("Payment Method:");

        payaddbtn.setText("Add");
        payaddbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payaddbtnActionPerformed(evt);
            }
        });

        payupdatebtn.setText("Update");
        payupdatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payupdatebtnActionPerformed(evt);
            }
        });

        clearbtn4.setText("Clear");
        clearbtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtn4ActionPerformed(evt);
            }
        });

        jLabel38.setText("Status:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(payaddbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(payupdatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearbtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(paymentMethodField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(amountField, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                            .addComponent(orderIDField1, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                            .addComponent(paymentIDField)
                            .addComponent(paymentStatusField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paymentIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orderIDField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amountField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paymentMethodField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paymentStatusField)
                    .addComponent(jLabel38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(payaddbtn)
                    .addComponent(payupdatebtn)
                    .addComponent(clearbtn4))
                .addGap(22, 22, 22))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, null));

        jTextField20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField20ActionPerformed(evt);
            }
        });

        jLabel28.setText("Search by ID:");

        paymentsearchbtn.setText("Search");
        paymentsearchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentsearchbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(paymentsearchbtn)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(paymentsearchbtn)
                .addContainerGap())
        );

        javax.swing.GroupLayout paymentpanelLayout = new javax.swing.GroupLayout(paymentpanel);
        paymentpanel.setLayout(paymentpanelLayout);
        paymentpanelLayout.setHorizontalGroup(
            paymentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentpanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(paymentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(paymentpanelLayout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paymentpanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addGap(283, 283, 283))
        );
        paymentpanelLayout.setVerticalGroup(
            paymentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentpanelLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(paymentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paymentpanelLayout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        admintabs.addTab("pymnt", paymentpanel);

        userspanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usertbl.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, null));
        usertbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User ID", "User Name", "Email", "Password", "User type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(usertbl);

        userspanel.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 732, 312));

        jLabel29.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        jLabel29.setText("Users");
        userspanel.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, -1, -1));

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, null));

        usertypeField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Staff", "Admin" }));
        usertypeField.setSelectedIndex(-1);

        jLabel30.setText("User ID:");

        jLabel31.setText("User Name:");

        jLabel32.setText("Email:");

        jLabel33.setText("Password:");

        jLabel34.setText("User type:");

        useraddbtn.setText("Add");
        useraddbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useraddbtnActionPerformed(evt);
            }
        });

        userupdatebtn.setText("Update");
        userupdatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userupdatebtnActionPerformed(evt);
            }
        });

        userdeletebtn.setText("Delete");
        userdeletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userdeletebtnActionPerformed(evt);
            }
        });

        clearbtn5.setText("Clear");
        clearbtn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtn5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(useraddbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(userupdatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(userdeletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clearbtn5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(usertypeField, 0, 264, Short.MAX_VALUE)
                        .addComponent(passwordField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(emailField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(userNameField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(userIDField, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(25, 25, 25))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usertypeField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(useraddbtn)
                    .addComponent(userupdatebtn)
                    .addComponent(userdeletebtn)
                    .addComponent(clearbtn5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        userspanel.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 380, 240));

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, null));

        jLabel35.setText("Search by ID:");

        usersearchbtn.setText("Search");
        usersearchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersearchbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField25, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(usersearchbtn)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(usersearchbtn)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        userspanel.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 430, 310, 100));

        admintabs.addTab("user", userspanel);

        jLabel36.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        jLabel36.setText("Sales");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel37.setText("Total Sales:");

        timeframe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Daily", "Monthly", "Yearly" }));
        timeframe.setSelectedIndex(-1);
        timeframe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeframeActionPerformed(evt);
            }
        });

        salestbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Period", "Total Sales"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(salestbl);

        javax.swing.GroupLayout salespanelLayout = new javax.swing.GroupLayout(salespanel);
        salespanel.setLayout(salespanelLayout);
        salespanelLayout.setHorizontalGroup(
            salespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, salespanelLayout.createSequentialGroup()
                .addContainerGap(353, Short.MAX_VALUE)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(331, 331, 331))
            .addGroup(salespanelLayout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(salespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(salespanelLayout.createSequentialGroup()
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timeframe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        salespanelLayout.setVerticalGroup(
            salespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salespanelLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(salespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(timeframe))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(173, 173, 173))
        );

        admintabs.addTab("sales", salespanel);

        getContentPane().add(admintabs, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, -70, 780, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    private void logUpdate(String message) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("updatelogs.txt", true))) {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            writer.write(timestamp + " - " + username + ": " + message);
            writer.newLine();
        } catch (IOException e) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Error logging update: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }  
    
    private void logDeletion(String username, String customerId, String customerName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("deletelogs.txt", true))) {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            writer.write(timestamp + " - " + username + ": Deleted Customer ID: " + customerId + ", Name: " + customerName);
            writer.newLine();
        } catch (IOException e) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Error logging deletion: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void logoutbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutbtnActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to log out?",
                "Confirm Logout",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            dispose();
            new Login().setVisible(true);  
        }    
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
                model.addRow(new String[]{rs.getString(1), rs.getString(2)});
            }
            
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void orderbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderbtnActionPerformed
        admintabs.setSelectedIndex(2);
        loadOrders();    
    }//GEN-LAST:event_orderbtnActionPerformed
    private void loadOrders() {
        try {
            Statement st = dbcon.dbconnect().createStatement();
            ResultSet rs = st.executeQuery("SELECT OrderID, CustomerID, OrderDate, TotalAmount FROM orders");

            DefaultTableModel model = (DefaultTableModel) ordertbl.getModel();
            model.setRowCount(0); 

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("OrderID"),
                    rs.getString("CustomerID"),
                    rs.getDate("OrderDate"),
                    rs.getDouble("TotalAmount")
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error loading orders data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void loadOrderDetails(String orderId) {
        try {
            Statement st = dbcon.dbconnect().createStatement();
            String query = "SELECT od.ItemID, i.ItemName, i.Price, od.Quantity " +
                           "FROM orderdetails od " +
                           "JOIN items i ON od.ItemID = i.ItemID " +
                           "WHERE od.OrderID = '" + orderId + "'";

            ResultSet rs = st.executeQuery(query);

            DefaultTableModel model = (DefaultTableModel) orderdetailstbl.getModel();
            model.setRowCount(0); 

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("ItemID"),
                    rs.getString("ItemName"),
                    rs.getDouble("Price"), 
                    rs.getInt("Quantity")
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error loading order details: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void itembtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itembtnActionPerformed
        admintabs.setSelectedIndex(3);
        loadItems();
    }//GEN-LAST:event_itembtnActionPerformed
    private void populateCategoryComboBox() {
        categoryfield.removeAllItems(); 
        categoryfield.addItem("Coffee");
        categoryfield.addItem("Tea");
        categoryfield.addItem("Pastries");
    
    }
    private void loadItems() {
        try {
            Statement st = dbcon.dbconnect().createStatement();
            ResultSet rs = st.executeQuery("SELECT ItemID, ItemName, Price, Category, Description, Stock FROM items");

            DefaultTableModel model = (DefaultTableModel) itemtbl.getModel();
            model.setRowCount(0); 

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("ItemID"),
                    rs.getString("ItemName"),
                    rs.getDouble("Price"),
                    rs.getString("Category"),
                    rs.getString("Description"),
                    rs.getInt("Stock")
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error loading items data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void paymentbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentbtnActionPerformed
        admintabs.setSelectedIndex(4);
        loadPayments();
    }//GEN-LAST:event_paymentbtnActionPerformed
    private void loadPayments() {
        try {
            Statement st = dbcon.dbconnect().createStatement();
            ResultSet rs = st.executeQuery("SELECT PaymentID, OrderID, Amount, PaymentMethod, Status FROM payments");

            DefaultTableModel model = (DefaultTableModel) paymenttbl.getModel();
            model.setRowCount(0); 

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("PaymentID"),
                    rs.getString("OrderID"),
                    rs.getDouble("Amount"),
                    rs.getString("PaymentMethod"),
                    rs.getString("Status")
                });
            }

            populatePaymentComboBoxes();
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error loading payments data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void populatePaymentComboBoxes() {
        paymentMethodField.removeAllItems();
        paymentMethodField.addItem("Cash");
        paymentMethodField.addItem("Check");
        paymentMethodField.addItem("Credit");
        paymentStatusField.removeAllItems();
        paymentStatusField.addItem("Unpaid");
        paymentStatusField.addItem("Paid");
    }
    
    private void userbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userbtnActionPerformed
        admintabs.setSelectedIndex(5);
        loadUsers();
    }//GEN-LAST:event_userbtnActionPerformed
    private void loadUsers() {
        try {
            Statement st = dbcon.dbconnect().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users");

            DefaultTableModel model = (DefaultTableModel) usertbl.getModel();
            model.setRowCount(0); 

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("UserID"),
                    rs.getString("UserName"),
                    rs.getString("Email"),
                    rs.getString("Password"),
                    rs.getString("User_type")
                });
            }

            populateUserComboBox();
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error loading users data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void populateUserComboBox() {
        usertypeField.removeAllItems();
        usertypeField.addItem("Staff");
        usertypeField.addItem("Admin");
    }
    private void salesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesActionPerformed
        admintabs.setSelectedIndex(6);
    }//GEN-LAST:event_salesActionPerformed

    private void customeraddbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customeraddbtnActionPerformed
        String customerId = custIDField.getText();
        String customerName = custNameField.getText();

       
        if (customerId.isEmpty() || customerName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to add the following customer?\n\n" +
                "Customer ID: " + customerId + "\n" +
                "Customer Name: " + customerName,
                "Confirm Add",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Statement st = dbcon.dbconnect().createStatement();
                String sql = "INSERT INTO customers (CustomerID, Name) VALUES ('" 
                             + customerId + "', '" + customerName + "')";

                st.executeUpdate(sql); 

                JOptionPane.showMessageDialog(this, "Customer added successfully!");

                loadCustomer(); 

                
                st.close();
            } catch (SQLException ex) {
                
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error adding customer: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
       
    }//GEN-LAST:event_customeraddbtnActionPerformed

    private void customerupdatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerupdatebtnActionPerformed
        String customerId = custIDField.getText();
        String customerName = custNameField.getText();

        if (customerId.isEmpty() || customerName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String existingCustomerName = "";

        try {
            Statement st = dbcon.dbconnect().createStatement();
            String sql = "SELECT * FROM customers WHERE CustomerID = '" + customerId + "'";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                existingCustomerName = rs.getString("Name");
            } else {
                JOptionPane.showMessageDialog(this, "Customer ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error retrieving customer data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to update the following customer?\n\n" +
                "Customer ID: " + customerId + "\n\n" +
                "Old Values:\n" +
                "  Name: " + existingCustomerName + "\n" +
                "New Values:\n" +
                "  Name: " + customerName,
                "Confirm Update",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Statement st = dbcon.dbconnect().createStatement();
                String sql = "UPDATE customers SET Name = '" + customerName + "' WHERE CustomerID = '" + customerId + "'";
                st.executeUpdate(sql); 

                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String timestamp = now.format(formatter);

                String logMessage = String.format("Update Action: CustomerID: %s, Timestamp: %s, User: %s, Changes: [Name: '%s' to '%s', Contact Info: '%s' to '%s']",
                        customerId, timestamp, username, existingCustomerName, customerName);
                logUpdate(logMessage); 

                JOptionPane.showMessageDialog(this, "Customer updated successfully!");
                loadCustomer(); 

                st.close(); 
            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error updating customer: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_customerupdatebtnActionPerformed

    private void clearbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtn1ActionPerformed
        custIDField.setText("");
        custNameField.setText("");
    }//GEN-LAST:event_clearbtn1ActionPerformed

    private void customersearchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customersearchbtnActionPerformed
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
            } else {
                JOptionPane.showMessageDialog(this, "Customer ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error searching customer: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_customersearchbtnActionPerformed

    private void ordersearchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersearchbtnActionPerformed
        String searchId = jTextField5.getText().trim();

        if (searchId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter an Order ID to search", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Statement st = dbcon.dbconnect().createStatement();
            String sql = "SELECT * FROM orders WHERE OrderID = '" + searchId + "'";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                orderIDField.setText(rs.getString("OrderID"));
                customerIDField.setText(rs.getString("CustomerID"));
                orderDateField.setText(rs.getString("OrderDate"));  
                totalAmountField.setText(String.valueOf(rs.getDouble("TotalAmount")));
                loadOrderDetails(searchId); 
            } else {
                JOptionPane.showMessageDialog(this, "Order ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error searching order: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ordersearchbtnActionPerformed

    private void odquantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odquantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_odquantityActionPerformed

    private void itemNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemNameFieldActionPerformed

    private void descriptionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriptionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descriptionFieldActionPerformed

    private void categoryfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryfieldActionPerformed

    private void jTextField20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField20ActionPerformed

    private void loadSalesData(String period) {
        try {
            Statement st = dbcon.dbconnect().createStatement();
            ResultSet rs;

            switch (period) {
                case "Daily":
                    rs = st.executeQuery(
                        "SELECT DATE(OrderDate) AS sale_date, SUM(TotalAmount) AS total_sales FROM (" +
                        "   SELECT OrderDate, TotalAmount FROM orders " +
                        "   UNION ALL " +
                        "   SELECT DeletedAt AS OrderDate, TotalAmount FROM deleted_orders" +
                        ") AS combined_table " +
                        "GROUP BY DATE(sale_date)"
                    );
                    break;
                case "Monthly":
                    rs = st.executeQuery(
                        "SELECT DATE_FORMAT(sale_date, '%Y-%m') AS sale_month, SUM(total_sales) AS total_sales FROM (" +
                        "   SELECT OrderDate AS sale_date, TotalAmount AS total_sales FROM orders " +
                        "   UNION ALL " +
                        "   SELECT DeletedAt AS sale_date, TotalAmount AS total_sales FROM deleted_orders" +
                        ") AS combined_table " +
                        "GROUP BY sale_month"
                    );
                    break;
                case "Yearly":
                    rs = st.executeQuery(
                        "SELECT YEAR(sale_date) AS sale_year, SUM(total_sales) AS total_sales FROM (" +
                        "   SELECT OrderDate AS sale_date, TotalAmount AS total_sales FROM orders " +
                        "   UNION ALL " +
                        "   SELECT DeletedAt AS sale_date, TotalAmount AS total_sales FROM deleted_orders" +
                        ") AS combined_table " +
                        "GROUP BY sale_year"
                    );
                    break;
                default:
                    return;
            }

            DefaultTableModel model = (DefaultTableModel) salestbl.getModel();
            model.setRowCount(0); 

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1), rs.getDouble(2)});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error loading sales data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void timeframeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeframeActionPerformed
            String selectedTimeframe = (String) timeframe.getSelectedItem();
        if (selectedTimeframe != null) {
            loadSalesData(selectedTimeframe); 
        }
    }//GEN-LAST:event_timeframeActionPerformed

    private void orderaddbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderaddbtnActionPerformed
        String orderId = orderIDField.getText();
        String customerId = customerIDField.getText();
        String orderDateStr = orderDateField.getText();
        String totalAmountStr = totalAmountField.getText();

        if (orderId.isEmpty() || customerId.isEmpty() || orderDateStr.isEmpty() || totalAmountStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double totalAmount;
        try {
            totalAmount = Double.parseDouble(totalAmountStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid total amount", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to add the following order?\n\n" +
                "Order ID: " + orderId + "\n" +
                "Customer ID: " + customerId + "\n" +
                "Order Date: " + orderDateStr + "\n" +
                "Total Amount: " + totalAmount,
                "Confirm Add",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Statement st = dbcon.dbconnect().createStatement();
                String sql = "INSERT INTO orders (OrderID, CustomerID, OrderDate, TotalAmount) VALUES ('" 
                             + orderId + "', '" + customerId + "', STR_TO_DATE('" + orderDateStr + "', '%Y-%m-%d'), " + totalAmount + ")";
                st.executeUpdate(sql); 

                JOptionPane.showMessageDialog(this, "Order added successfully!");
                loadOrders(); 
                st.close(); 

            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error adding order: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_orderaddbtnActionPerformed

    private void itemaddbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemaddbtnActionPerformed
        String itemId = itemIDField.getText();
        String itemName = itemNameField.getText();
        String priceStr = priceField.getText();
        String category = (String) categoryfield.getSelectedItem();
        String description = descriptionField.getText();
        String stockStr = stockField.getText();

        if (itemId.isEmpty() || itemName.isEmpty() || priceStr.isEmpty() || category == null || description.isEmpty() || stockStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double price;
        int stock;
        try {
            price = Double.parseDouble(priceStr);
            stock = Integer.parseInt(stockStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid price and stock", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to add the following item?\n\n" +
                "Item ID: " + itemId + "\n" +
                "Item Name: " + itemName + "\n" +
                "Price: " + price + "\n" +
                "Category: " + category + "\n" +
                "Description: " + description + "\n" +
                "Stock: " + stock,
                "Confirm Add",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Statement st = dbcon.dbconnect().createStatement();
                String sql = "INSERT INTO items (ItemID, ItemName, Price, Category, Description, Stock) VALUES ('" 
                             + itemId + "', '" + itemName + "', " + price + ", '" + category + "', '" + description + "', " + stock + ")";
                st.executeUpdate(sql); 

                JOptionPane.showMessageDialog(this, "Item added successfully!");
                loadItems(); 
                st.close(); 

            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error adding item: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_itemaddbtnActionPerformed

    private void payaddbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payaddbtnActionPerformed
        String paymentId = paymentIDField.getText();
        String orderId = orderIDField1.getText();
        String amountStr = amountField.getText();
        String paymentMethod = (String) paymentMethodField.getSelectedItem();
        String status = (String) paymentStatusField.getSelectedItem();

        if (paymentId.isEmpty() || orderId.isEmpty() || amountStr.isEmpty() || paymentMethod == null || status == null) {
            JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double amount;
        try {
            amount = Double.parseDouble(amountStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid amount", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to add the following payment?\n\n" +
                "Payment ID: " + paymentId + "\n" +
                "Order ID: " + orderId + "\n" +
                "Amount: " + amount + "\n" +
                "Payment Method: " + paymentMethod + "\n" +
                "Status: " + status,
                "Confirm Add",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Statement st = dbcon.dbconnect().createStatement();
                String sql = "INSERT INTO payments (PaymentID, OrderID, Amount, PaymentMethod, Status) VALUES ('" 
                             + paymentId + "', '" + orderId + "', " + amount + ", '" + paymentMethod + "', '" + status + "')";
                st.executeUpdate(sql); 

                JOptionPane.showMessageDialog(this, "Payment added successfully!");
                loadPayments(); 
                st.close(); 

            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error adding payment: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_payaddbtnActionPerformed

    private void useraddbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useraddbtnActionPerformed
        String userId = userIDField.getText();
        String userName = userNameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String usertype = (String) usertypeField.getSelectedItem();

        
        if (userId.isEmpty() || userName.isEmpty() || email.isEmpty() || password.isEmpty() || usertype == null) {
            JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to add the following user?\n\n" +
                "User ID: " + userId + "\n" +
                "User Name: " + userName + "\n" +
                "Email: " + email + "\n" +
                "Status: " + usertype,
                "Confirm Add",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Statement st = dbcon.dbconnect().createStatement();
                String sql = "INSERT INTO users (UserID, UserName, Email, Password, User type) VALUES ('" 
                             + userId + "', '" + userName + "', '" + email + "', '" + password + "', '" + usertype + "')";
                st.executeUpdate(sql); 

                JOptionPane.showMessageDialog(this, "User added successfully!");
                loadUsers(); 

                st.close(); 
            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error adding user: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_useraddbtnActionPerformed

    private void orderupdatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderupdatebtnActionPerformed
        String orderId = orderIDField.getText();
        String customerId = customerIDField.getText();
        String orderDateStr = orderDateField.getText();
        String totalAmountStr = totalAmountField.getText();

        if (orderId.isEmpty() || customerId.isEmpty() || orderDateStr.isEmpty() || totalAmountStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String existingCustomerId = "";
        String existingOrderDate = "";
        double existingTotalAmount = 0;

        try {
            Statement st = dbcon.dbconnect().createStatement();
            String sql = "SELECT * FROM orders WHERE OrderID = '" + orderId + "'";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                existingCustomerId = rs.getString("CustomerID");
                existingOrderDate = rs.getString("OrderDate");
                existingTotalAmount = rs.getDouble("TotalAmount");
            } else {
                JOptionPane.showMessageDialog(this, "Order ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error retrieving order data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to update the following order?\n\n" +
                "Order ID: " + orderId + "\n\n" +
                "Old Values:\n" +
                "  Customer ID: " + existingCustomerId + "\n" +
                "  Order Date: " + existingOrderDate + "\n" +
                "  Total Amount: " + existingTotalAmount + "\n\n" +
                "New Values:\n" +
                "  Customer ID: " + customerId + "\n" +
                "  Order Date: " + orderDateStr + "\n" +
                "  Total Amount: " + totalAmountStr,
                "Confirm Update",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Statement st = dbcon.dbconnect().createStatement();
                String sql = "UPDATE orders SET CustomerID = '" + customerId + "', OrderDate = STR_TO_DATE('" + orderDateStr + "', '%Y-%m-%d'), TotalAmount = " + totalAmountStr + " WHERE OrderID = '" + orderId + "'";
                st.executeUpdate(sql);


                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String timestamp = now.format(formatter);


                String logMessage = String.format("Update Action: OrderID: %s, Timestamp: %s, User: %s, Changes: [Customer ID: '%s' to '%s', Order Date: '%s' to '%s', Total Amount: '%.2f' to '%.2f']",
                        orderId, timestamp, username, existingCustomerId, customerId, existingOrderDate, orderDateStr, existingTotalAmount, Double.parseDouble(totalAmountStr));
                logUpdate(logMessage);

                JOptionPane.showMessageDialog(this, "Order updated successfully!");
                loadOrders();
                st.close(); 
            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error updating order: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_orderupdatebtnActionPerformed

    private void itemupdatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemupdatebtnActionPerformed
        String itemId = itemIDField.getText();
        String itemName = itemNameField.getText();
        String priceStr = priceField.getText();
        String category = (String) categoryfield.getSelectedItem();
        String stockStr = stockField.getText();
        String description = descriptionField.getText();

        if (itemId.isEmpty() || itemName.isEmpty() || priceStr.isEmpty() || category == null || stockStr.isEmpty() || description.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String existingItemName = "";
        double existingPrice = 0;
        int existingStock = 0;

        try {
            Statement st = dbcon.dbconnect().createStatement();
            String sql = "SELECT * FROM items WHERE ItemID = '" + itemId + "'";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                existingItemName = rs.getString("ItemName");
                existingPrice = rs.getDouble("Price");
                existingStock = rs.getInt("Stock");
            } else {
                JOptionPane.showMessageDialog(this, "Item ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error retrieving item data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to update the following item?\n\n" +
                "Item ID: " + itemId + "\n\n" +
                "Old Values:\n" +
                "  Item Name: " + existingItemName + "\n" +
                "  Price: " + existingPrice + "\n" +
                "  Stock: " + existingStock + "\n\n" +
                "New Values:\n" +
                "  Item Name: " + itemName + "\n" +
                "  Price: " + priceStr + "\n" +
                "  Stock: " + stockStr,
                "Confirm Update",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Statement st = dbcon.dbconnect().createStatement();
                String sql = "UPDATE items SET ItemName = '" + itemName + "', Price = " + priceStr + ", Category = '" + category + "', Description = '" + description + "', Stock = " + stockStr + " WHERE ItemID = '" + itemId + "'";
                st.executeUpdate(sql);

                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String timestamp = now.format(formatter);
                String logMessage = String.format("Update Action: ItemID: %s, Timestamp: %s, User: %s, Changes: [Item Name: '%s' to '%s', Price: '%.2f' to '%.2f', Stock: %d to %d]",
                        itemId, timestamp, username, existingItemName, itemName, existingPrice, Double.parseDouble(priceStr), existingStock, Integer.parseInt(stockStr));
                logUpdate(logMessage);

                JOptionPane.showMessageDialog(this, "Item updated successfully!");
                loadItems(); 
                st.close(); 
            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error updating item: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_itemupdatebtnActionPerformed

    private void payupdatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payupdatebtnActionPerformed
        String paymentId = paymentIDField.getText();
        String orderId = orderIDField1.getText();
        String amountStr = amountField.getText();
        String paymentMethod = (String) paymentMethodField.getSelectedItem();
        String status = (String) paymentStatusField.getSelectedItem();

        if (paymentId.isEmpty() || orderId.isEmpty() || amountStr.isEmpty() || paymentMethod == null || status == null) {
            JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double existingAmount;
        String existingPaymentMethod = "";
        String existingStatus = "";

        try {
            Statement st = dbcon.dbconnect().createStatement();
            String sql = "SELECT * FROM payments WHERE PaymentID = '" + paymentId + "'";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                existingAmount = rs.getDouble("Amount");
                existingPaymentMethod = rs.getString("PaymentMethod");
                existingStatus = rs.getString("Status");
            } else {
                JOptionPane.showMessageDialog(this, "Payment ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error retrieving payment data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to update the following payment?\n\n" +
                "Payment ID: " + paymentId + "\n\n" +
                "Old Values:\n" +
                "  Amount: " + existingAmount + "\n" +
                "  Payment Method: " + existingPaymentMethod + "\n" +
                "  Status: " + existingStatus + "\n\n" +
                "New Values:\n" +
                "  Amount: " + amountStr + "\n" +
                "  Payment Method: " + paymentMethod + "\n" +
                "  Status: " + status,
                "Confirm Update",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Statement st = dbcon.dbconnect().createStatement();
                String sql = "UPDATE payments SET OrderID = '" + orderId + "', Amount = " + amountStr + ", PaymentMethod = '" + paymentMethod + "', Status = '" + status + "' WHERE PaymentID = '" + paymentId + "'";
                st.executeUpdate(sql); 

                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String timestamp = now.format(formatter);
                String logMessage = String.format("Update Action: PaymentID: %s, Timestamp: %s, User: %s, Changes: [Amount: %.2f to %.2f, Payment Method: '%s' to '%s', Status: '%s' to '%s']",
                        paymentId, timestamp, username, existingAmount, Double.parseDouble(amountStr), existingPaymentMethod, paymentMethod, existingStatus, status);
                logUpdate(logMessage);

                JOptionPane.showMessageDialog(this, "Payment updated successfully!");
                loadPayments(); 
                st.close(); 
            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error updating payment: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_payupdatebtnActionPerformed

    private void userupdatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userupdatebtnActionPerformed
        String userId = userIDField.getText();
        String userName = userNameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String status = (String) usertypeField.getSelectedItem();

        if (userId.isEmpty() || userName.isEmpty() || email.isEmpty() || password.isEmpty() || status == null) {
            JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String existingUserName = "";
        String existingEmail = "";
        String existingStatus = "";

        try {
            Statement st = dbcon.dbconnect().createStatement();
            String sql = "SELECT * FROM users WHERE UserID = '" + userId + "'";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                existingUserName = rs.getString("UserName");
                existingEmail = rs.getString("Email");
                existingStatus = rs.getString("Status");
            } else {
                JOptionPane.showMessageDialog(this, "User ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error retrieving user data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to update the following user?\n\n" +
                "User ID: " + userId + "\n\n" +
                "Old Values:\n" +
                "  User Name: " + existingUserName + "\n" +
                "  Email: " + existingEmail + "\n" +
                "  Status: " + existingStatus + "\n\n" +
                "New Values:\n" +
                "  User Name: " + userName + "\n" +
                "  Email: " + email + "\n" +
                "  Status: " + status,
                "Confirm Update",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Statement st = dbcon.dbconnect().createStatement();
                String sql = "UPDATE users SET UserName = '" + userName + "', Email = '" + email + "', Password = '" + password + "', Status = '" + status + "' WHERE UserID = '" + userId + "'";
                st.executeUpdate(sql);


                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String timestamp = now.format(formatter);
                String logMessage = String.format("Update Action: UserID: %s, Timestamp: %s, User: %s, Changes: [User Name: '%s' to '%s', Email: '%s' to '%s', Status: '%s' to '%s']",
                        userId, timestamp, username, existingUserName, userName, existingEmail, email, existingStatus, status);
                logUpdate(logMessage);

                JOptionPane.showMessageDialog(this, "User updated successfully!");
                loadUsers(); 
                st.close(); 
            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error updating user: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_userupdatebtnActionPerformed

    private void orderdeletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderdeletebtnActionPerformed
        String orderId = orderIDField.getText();
        String existingCustomerId = "";
        String existingCustomerName = "";
        LocalDate orderDate = null;
        double totalAmount = 0;

        if (orderId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter an Order ID to delete", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete Order ID: " + orderId + "?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try (Connection conn = dbcon.dbconnect()) {
                conn.setAutoCommit(false);
                Statement stmt = conn.createStatement();

                String query = "SELECT CustomerID, OrderDate, TotalAmount FROM orders WHERE OrderID = '" + orderId + "'";
                ResultSet rs = stmt.executeQuery(query);

                if (rs.next()) {
                    existingCustomerId = rs.getString("CustomerID");
                    orderDate = rs.getDate("OrderDate").toLocalDate();
                    totalAmount = rs.getDouble("TotalAmount");

                    String customerQuery = "SELECT Name FROM customers WHERE CustomerID = '" + existingCustomerId + "'";
                    ResultSet customerRs = stmt.executeQuery(customerQuery);
                    if (customerRs.next()) {
                        existingCustomerName = customerRs.getString("Name");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Order ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String insertDeletedPaymentsSQL = "INSERT INTO deleted_payments (PaymentID, OrderID, Amount, PaymentMethod, Status, DeletedAt) " +
                                                   "SELECT PaymentID, OrderID, Amount, PaymentMethod, Status, CURRENT_TIMESTAMP FROM payments WHERE OrderID = ?";
                String insertDeletedOrderSQL = "INSERT INTO deleted_orders (OrderID, CustomerID, OrderDate, TotalAmount, DeletedAt) " +
                                                "SELECT OrderID, CustomerID, OrderDate, TotalAmount, CURRENT_TIMESTAMP FROM orders WHERE OrderID = ?";
                String deleteOrderDetailsSQL = "DELETE FROM orderdetails WHERE OrderID = ?";
                String deletePaymentsSQL = "DELETE FROM payments WHERE OrderID = ?";
                String deleteOrderSQL = "DELETE FROM orders WHERE OrderID = ?";

                try (PreparedStatement insertDeletedPaymentsStmt = conn.prepareStatement(insertDeletedPaymentsSQL);
                     PreparedStatement insertDeletedOrderStmt = conn.prepareStatement(insertDeletedOrderSQL);
                     PreparedStatement deleteOrderDetailsStmt = conn.prepareStatement(deleteOrderDetailsSQL);
                     PreparedStatement deletePaymentsStmt = conn.prepareStatement(deletePaymentsSQL);
                     PreparedStatement deleteOrderStmt = conn.prepareStatement(deleteOrderSQL)) {

                    insertDeletedPaymentsStmt.setString(1, orderId);
                    insertDeletedPaymentsStmt.executeUpdate();

                    insertDeletedOrderStmt.setString(1, orderId);
                    insertDeletedOrderStmt.executeUpdate();

                    deleteOrderDetailsStmt.setString(1, orderId);
                    deleteOrderDetailsStmt.executeUpdate();

                    deletePaymentsStmt.setString(1, orderId);
                    deletePaymentsStmt.executeUpdate();

                    deleteOrderStmt.setString(1, orderId);
                    deleteOrderStmt.executeUpdate();

                    conn.commit();

                    logDeletion(username, orderId, existingCustomerId + ": " + existingCustomerName);

                    JOptionPane.showMessageDialog(this, "Order and related records (payments) deleted successfully!");
                    loadOrders();
                } catch (SQLException ex) {
                    conn.rollback();
                    Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "Error deleting order: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Database connection error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_orderdeletebtnActionPerformed

    private void itemdeletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemdeletebtnActionPerformed
        String itemId = itemIDField.getText();
        String itemName = itemNameField.getText(); 
        String price = priceField.getText(); 

        if (itemId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter an Item ID to delete", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete the following item?\n\n" +
                "Item ID: " + itemId + "\n" +
                "Item Name: " + itemName + "\n" +
                "Price: " + price,
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Statement st = dbcon.dbconnect().createStatement();

                String orderDetailCheckQuery = "SELECT COUNT(*) AS DetailCount FROM orderdetails WHERE ItemID = '" + itemId + "'";
                ResultSet orderDetailsCountResult = st.executeQuery(orderDetailCheckQuery);
                orderDetailsCountResult.next();
                int orderDetailCount = orderDetailsCountResult.getInt("DetailCount");

                if (orderDetailCount > 0) {
                    JOptionPane.showMessageDialog(this, "Cannot delete item. There are existing order details related to it.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String insertSQL = "INSERT INTO deleted_items (ItemID, ItemName, Price, Category, Description, Stock, DeletedAt) " +
                                       "VALUES ('" + itemId + "', '" + itemName + "', " + price + ", '" + categoryfield.getSelectedItem() + "', '" + descriptionField.getText() + "', " + stockField.getText() + ", CURRENT_TIMESTAMP)";
                    st.executeUpdate(insertSQL);

                    String deleteSQL = "DELETE FROM items WHERE ItemID = '" + itemId + "'";
                    st.executeUpdate(deleteSQL);

                    JOptionPane.showMessageDialog(this, "Item deleted successfully!");

                    logDeletion(username, itemId, itemName);

                    loadItems(); 
                }
            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error deleting item: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_itemdeletebtnActionPerformed

    private void userdeletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userdeletebtnActionPerformed
        String userId = userIDField.getText();
        String userName = userNameField.getText(); 
        String email = emailField.getText(); 

        if (userId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a User ID to delete", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete the following user?\n\n" +
                "User ID: " + userId + "\n" +
                "User Name: " + userName + "\n" +
                "Email: " + email,
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Statement st = dbcon.dbconnect().createStatement();

                String insertSQL = "INSERT INTO deleted_users (UserID, UserName, Email, Password, Status, DeletedAt) " +
                                   "VALUES ('" + userId + "', '" + userName + "', '" + email + "', '" + passwordField.getText() + "', '" + usertypeField.getSelectedItem() + "', CURRENT_TIMESTAMP)";
                st.executeUpdate(insertSQL);

                String deleteSQL = "DELETE FROM users WHERE UserID = '" + userId + "'";
                st.executeUpdate(deleteSQL);

                JOptionPane.showMessageDialog(this, "User deleted successfully!");
                loadUsers(); 
            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error deleting user: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_userdeletebtnActionPerformed

    private void clearbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtn2ActionPerformed
        orderIDField.setText("");
        customerIDField.setText("");
        orderDateField.setText("");
        totalAmountField.setText("");
    }//GEN-LAST:event_clearbtn2ActionPerformed

    private void clearbtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtn3ActionPerformed
        itemIDField.setText("");
        itemNameField.setText("");
        priceField.setText("");
        descriptionField.setText("");
        stockField.setText("");
        categoryfield.setSelectedIndex(-1);
    }//GEN-LAST:event_clearbtn3ActionPerformed

    private void clearbtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtn4ActionPerformed
        paymentIDField.setText("");
        orderIDField1.setText("");
        amountField.setText("");
        paymentMethodField.setSelectedIndex(-1);
        paymentStatusField.setSelectedIndex(-1);
    }//GEN-LAST:event_clearbtn4ActionPerformed

    private void clearbtn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtn5ActionPerformed
        userIDField.setText("");
        userNameField.setText("");
        emailField.setText("");
        passwordField.setText("");
        usertypeField.setSelectedIndex(-1);
    }//GEN-LAST:event_clearbtn5ActionPerformed

    private void usersearchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersearchbtnActionPerformed
        String searchId = jTextField25.getText().trim();

        if (searchId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a User ID to search", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Statement st = dbcon.dbconnect().createStatement();
            String sql = "SELECT * FROM users WHERE UserID = '" + searchId + "'";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                userIDField.setText(rs.getString("UserID"));
                userNameField.setText(rs.getString("UserName"));
                emailField.setText(rs.getString("Email"));
                passwordField.setText(rs.getString("Password")); 
                usertypeField.setSelectedItem(rs.getString("Status"));
            } else {
                JOptionPane.showMessageDialog(this, "User ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error searching user: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_usersearchbtnActionPerformed

    private void itemsearchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemsearchbtnActionPerformed
        String searchId = jTextField17.getText().trim();

        if (searchId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter an Item ID to search", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Statement st = dbcon.dbconnect().createStatement();
            String sql = "SELECT * FROM items WHERE ItemID = '" + searchId + "'";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                itemIDField.setText(rs.getString("ItemID"));
                itemNameField.setText(rs.getString("ItemName"));
                priceField.setText(String.valueOf(rs.getDouble("Price")));
                categoryfield.setSelectedItem(rs.getString("Category"));
                descriptionField.setText(rs.getString("Description"));
                stockField.setText(String.valueOf(rs.getInt("Stock")));
            } else {
                JOptionPane.showMessageDialog(this, "Item ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error searching item: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_itemsearchbtnActionPerformed

    private void paymentsearchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentsearchbtnActionPerformed
        String searchId = jTextField20.getText().trim();

        if (searchId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a Payment ID to search", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Statement st = dbcon.dbconnect().createStatement();
            String sql = "SELECT * FROM payments WHERE PaymentID = '" + searchId + "'";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                paymentIDField.setText(rs.getString("PaymentID"));
                orderIDField1.setText(rs.getString("OrderID"));
                amountField.setText(String.valueOf(rs.getDouble("Amount")));
                paymentMethodField.setSelectedItem(rs.getString("PaymentMethod"));
                paymentStatusField.setSelectedItem(rs.getString("Status"));
            } else {
                JOptionPane.showMessageDialog(this, "Payment ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error searching payment: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_paymentsearchbtnActionPerformed

    private void odclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odclearActionPerformed
        oditemID.setText("");
        oditemname.setText("");
        odprice.setText("");
        odquantity.setText("");
    }//GEN-LAST:event_odclearActionPerformed

    private void odupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odupdateActionPerformed
        String itemId = oditemID.getText();
        String quantityStr = odquantity.getText();

        if (itemId.isEmpty() || quantityStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int quantity;
        try {
            quantity = Integer.parseInt(quantityStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid quantity", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String existingItemName = "";
        double existingPrice = 0;
        int existingQuantity = 0;
        String orderId = orderIDField.getText();  

        try {
            Statement st = dbcon.dbconnect().createStatement();

            String sql = "SELECT i.ItemName, i.Price, od.Quantity " +
                         "FROM orderdetails od " +
                         "JOIN items i ON od.ItemID = i.ItemID " +
                         "WHERE od.ItemID = '" + itemId + "' AND od.OrderID = '" + orderId + "'";

            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                existingItemName = rs.getString("ItemName");
                existingPrice = rs.getDouble("Price");
                existingQuantity = rs.getInt("Quantity");
            } else {
                JOptionPane.showMessageDialog(this, "Item ID not found in order details.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error retrieving item data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to update the quantity for the following item?\n\n" +
                "Item ID: " + itemId + "\n" +
                "Item Name: " + existingItemName + "\n" +
                "Old Quantity: " + existingQuantity + "\n" +
                "New Quantity: " + quantity,
                "Confirm Update",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Statement st = dbcon.dbconnect().createStatement();
                String updateQuantitySql = "UPDATE orderdetails SET Quantity = " + quantity + 
                                           " WHERE ItemID = '" + itemId + "' AND OrderID = '" + orderId + "'";
                st.executeUpdate(updateQuantitySql); 

               
                String updateTotalSql = "UPDATE orders o " +
                                         "SET o.TotalAmount = ( " +
                                         "  SELECT SUM(od.Quantity * i.Price) " +
                                         "  FROM orderdetails od " +
                                         "  JOIN items i ON od.ItemID = i.ItemID " +
                                         "  WHERE od.OrderID = o.OrderID " +
                                         ") " +
                                         "WHERE EXISTS ( " +
                                         "  SELECT 1 " +
                                         "  FROM orderdetails od " +
                                         "  WHERE od.OrderID = o.OrderID " +
                                         ")";
                st.executeUpdate(updateTotalSql); 

               
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String timestamp = now.format(formatter);
                String logMessage = String.format("Update Action: ItemID: %s, Timestamp: %s, User: %s, Changes: [Quantity: %d to %d]",
                        itemId, timestamp, username, existingQuantity, quantity);
                logUpdate(logMessage); 

                loadOrders();
                
                JOptionPane.showMessageDialog(this, "Quantity updated successfully and total amount recalculated!");
                loadOrderDetails(orderId); 
                st.close(); 
            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error updating quantity: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_odupdateActionPerformed

    private void customerdeletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerdeletebtnActionPerformed
        String customerId = custIDField.getText();
        String customerName = custNameField.getText(); 

        if (customerId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a Customer ID to delete", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete Customer ID: " + customerId + "?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try (Connection conn = dbcon.dbconnect()) {
                Statement stmt = conn.createStatement();

                // Check if there are existing orders related to the customer
                String orderCheckQuery = "SELECT COUNT(*) AS OrderCount FROM orders WHERE CustomerID = '" + customerId + "'";
                ResultSet orderResultSet = stmt.executeQuery(orderCheckQuery);
                orderResultSet.next();
                int orderCount = orderResultSet.getInt("OrderCount");

                // Check if there are existing payments related to the customer
                String paymentCheckQuery = "SELECT COUNT(*) AS PaymentCount FROM payments WHERE OrderID IN (SELECT OrderID FROM orders WHERE CustomerID = '" + customerId + "')";
                ResultSet paymentResultSet = stmt.executeQuery(paymentCheckQuery);
                paymentResultSet.next();
                int paymentCount = paymentResultSet.getInt("PaymentCount");

                if (orderCount > 0 || paymentCount > 0) {
                    JOptionPane.showMessageDialog(this, "Cannot delete customer. There are existing related data (orders/payments).", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String deleteSQL = "DELETE FROM customers WHERE CustomerID = '" + customerId + "'";
                    stmt.executeUpdate(deleteSQL);
                    logDeletion(username, customerId, customerName);
                    JOptionPane.showMessageDialog(this, "Customer deleted successfully!");
                    loadCustomer(); 
                }
            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error deleting customer: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_customerdeletebtnActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin("adminUsername").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Brand;
    private javax.swing.JLabel Brand2;
    private javax.swing.JLabel Brand3;
    private javax.swing.JLabel Head;
    private javax.swing.JLabel Head1;
    private javax.swing.JTabbedPane admintabs;
    private javax.swing.JTextField amountField;
    private javax.swing.JComboBox<String> categoryfield;
    private javax.swing.JButton clearbtn1;
    private javax.swing.JButton clearbtn2;
    private javax.swing.JButton clearbtn3;
    private javax.swing.JButton clearbtn4;
    private javax.swing.JButton clearbtn5;
    private javax.swing.JTextField custIDField;
    private javax.swing.JTextField custNameField;
    private javax.swing.JTextField customerIDField;
    private javax.swing.JPanel customerPanel;
    private javax.swing.JButton customeraddbtn;
    private javax.swing.JButton customerbtn;
    private javax.swing.JButton customerdeletebtn;
    private javax.swing.JButton customersearchbtn;
    private javax.swing.JTable customertbl;
    private javax.swing.JButton customerupdatebtn;
    private javax.swing.JTextField descriptionField;
    private javax.swing.JTextField emailField;
    private javax.swing.JButton homebtn;
    private javax.swing.JPanel homepanel;
    private javax.swing.JTextField itemIDField;
    private javax.swing.JTextField itemNameField;
    private javax.swing.JButton itemaddbtn;
    private javax.swing.JButton itembtn;
    private javax.swing.JButton itemdeletebtn;
    private javax.swing.JPanel itempanel;
    private javax.swing.JButton itemsearchbtn;
    private javax.swing.JTable itemtbl;
    private javax.swing.JButton itemupdatebtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JButton logoutbtn;
    private javax.swing.JPanel modifyPanel;
    private javax.swing.JButton odclear;
    private javax.swing.JTextField oditemID;
    private javax.swing.JTextField oditemname;
    private javax.swing.JTextField odprice;
    private javax.swing.JTextField odquantity;
    private javax.swing.JButton odupdate;
    private javax.swing.JTextField orderDateField;
    private javax.swing.JTextField orderIDField;
    private javax.swing.JTextField orderIDField1;
    private javax.swing.JButton orderaddbtn;
    private javax.swing.JButton orderbtn;
    private javax.swing.JButton orderdeletebtn;
    private javax.swing.JTable orderdetailstbl;
    private javax.swing.JPanel orderpanel;
    private javax.swing.JButton ordersearchbtn;
    private javax.swing.JTable ordertbl;
    private javax.swing.JButton orderupdatebtn;
    private javax.swing.JTextField passwordField;
    private javax.swing.JButton payaddbtn;
    private javax.swing.JTextField paymentIDField;
    private javax.swing.JComboBox<String> paymentMethodField;
    private javax.swing.JComboBox<String> paymentStatusField;
    private javax.swing.JButton paymentbtn;
    private javax.swing.JPanel paymentpanel;
    private javax.swing.JButton paymentsearchbtn;
    private javax.swing.JTable paymenttbl;
    private javax.swing.JButton payupdatebtn;
    private javax.swing.JTextField priceField;
    private javax.swing.JButton sales;
    private javax.swing.JPanel salespanel;
    private javax.swing.JTable salestbl;
    private javax.swing.JPanel searchpanel1;
    private javax.swing.JTextField stockField;
    private javax.swing.JComboBox<String> timeframe;
    private javax.swing.JTextField totalAmountField;
    private javax.swing.JTextField userIDField;
    private javax.swing.JTextField userNameField;
    private javax.swing.JButton useraddbtn;
    private javax.swing.JButton userbtn;
    private javax.swing.JButton userdeletebtn;
    private javax.swing.JButton usersearchbtn;
    private javax.swing.JPanel userspanel;
    private javax.swing.JTable usertbl;
    private javax.swing.JComboBox<String> usertypeField;
    private javax.swing.JButton userupdatebtn;
    private javax.swing.JLabel welcomemsg;
    // End of variables declaration//GEN-END:variables
}
