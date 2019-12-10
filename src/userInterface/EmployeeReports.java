package userInterface;

import businessLogic.DepartmentInfo;
import businessLogic.EmployeeInfo;
import businessLogic.ProjectInfo;
import databaseConnection.DepartmentDB;
import databaseConnection.EmployeeReportDB;
import databaseConnection.ProjectDB;
import java.awt.print.PrinterException;
import java.sql.Date;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EmployeeReports extends javax.swing.JFrame {

    private EmployeeReportDB erdb;
    private ArrayList<EmployeeInfo> ar;
    private DefaultTableModel dtm;
    private ArrayList<DepartmentInfo> ard;
    private ArrayList<ProjectInfo> arp;
    private DepartmentDB dDB;
    private ProjectDB pDB;

    public EmployeeReports() {
        initComponents();
        setLocationRelativeTo(null);

        erdb = new EmployeeReportDB();
        dDB = new DepartmentDB();
        pDB = new ProjectDB();
        ar = new ArrayList<>();

        dtm = new DefaultTableModel();
        tbl_employee.setModel(dtm);
        dtm.addColumn("Employee ID");
        dtm.addColumn("Employee First Name");
        dtm.addColumn("Employee Last Name");
        dtm.addColumn("NIC");
        dtm.addColumn("Gender");
        dtm.addColumn("Date of Birth");
        dtm.addColumn("Address-No");
        dtm.addColumn("Address-Street");
        dtm.addColumn("Address-City");
        dtm.addColumn("Telephone-Home");
        dtm.addColumn("Telephone-Mobile");
        dtm.addColumn("E-mail");
        dtm.addColumn("Position");
        dtm.addColumn("Department ID");

        ard = dDB.getAllData();
        arp = pDB.getAllDataFromDB();

        //loading department name to the combo box
        for (DepartmentInfo d : ard) {
            combo_dept.addItem(d.getDeptName());
        }

        //loading project title to the combo box
        for (ProjectInfo p : arp) {
            combo_project.addItem(p.getTitle());
        }
        combo_position.setEnabled(false);
        combo_dept.setEnabled(false);
        combo_project.setEnabled(false);
        spn_age.setEnabled(false);
        txt_city.setEnabled(false);

    }

    //this method is for refreshing the window
    private void clearFields() {
        txt_city.setText("");
        rbtn_age.setSelected(false);
        rbtn_city.setSelected(false);
        rbtn_dept.setSelected(false);
        rbtn_position.setSelected(false);
        rbtn_project.setSelected(false);
        combo_dept.setSelectedIndex(0);
        combo_position.setSelectedIndex(0);
        combo_project.setSelectedIndex(0);
        combo_dept.setEnabled(false);
        combo_position.setEnabled(false);
        combo_project.setEnabled(false);
        spn_age.setEnabled(false);
        txt_city.setEnabled(false);
        spn_age.setValue(0);
        int i = tbl_employee.getRowCount();
        for (int j = 0; j < i; j++) { //this for loop for removing rows from the table
            dtm.removeRow(0);
        }
    }

    //this method is for adding data to the table
    private void addDataToTable(ArrayList<EmployeeInfo> ar) {
        if (ar != null) {
            for (EmployeeInfo em : ar) {
                int eId = em.geteID();
                String fName = em.getfName();
                String lName = em.getlName();
                String nic = em.getNic();
                String gender = em.getGender();
                Date dob = em.getDob();
                String addNo = em.getAddNo();
                String addStreet = em.getAddStreet();
                String addCity = em.getAddCity();
                String teleHome = em.getTeleHome();
                String teleMobile = em.getTeleMobile();
                String email = em.getEmail();
                String pos = em.getPosition();
                int dID = em.getDeptID();
                dtm.addRow(new Object[]{eId, fName, lName, nic, gender, dob, addNo, addStreet, addCity, teleHome, teleMobile, email, pos, dID});
            }
        } else {
            JOptionPane.showMessageDialog(this, "No Data Can be Found");
        }
    }

    //this method is for getting system date and time
    private String setDate() {
        String d = new java.util.Date().toString();
        String day = d.split(" ")[2];
        String month = d.split(" ")[1];
        String year = d.split(" ")[5];
        String date = day + "/" + month + "/" + year;
        String time = d.split(" ")[3];
        return date + ":" + time;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        combo_position = new javax.swing.JComboBox();
        combo_dept = new javax.swing.JComboBox();
        spn_age = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_city = new javax.swing.JTextField();
        combo_project = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        rbtn_position = new javax.swing.JRadioButton();
        rbtn_dept = new javax.swing.JRadioButton();
        rbtn_age = new javax.swing.JRadioButton();
        rbtn_city = new javax.swing.JRadioButton();
        rbtn_project = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_employee = new javax.swing.JTable();
        btn_close = new javax.swing.JButton();
        btn_ok = new javax.swing.JButton();
        btn_print = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Employee Details");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 140, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Position:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Department:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, -1, -1));

        combo_position.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Manager", "HR Manager", "Accountant", "IS Coordinator", "Assistant Manager", "Project Manager", "Software Developer", "Tester", "Marketing Executive", "Network Administrator", "Office Assistant" }));
        jPanel1.add(combo_position, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 150, -1));

        jPanel1.add(combo_dept, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 150, -1));
        jPanel1.add(spn_age, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 150, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Age:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("City:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, -1, -1));
        jPanel1.add(txt_city, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 150, -1));

        jPanel1.add(combo_project, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 150, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Project:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, -1, -1));

        rbtn_position.setBackground(new java.awt.Color(0, 153, 255));
        rbtn_position.setForeground(new java.awt.Color(255, 255, 255));
        rbtn_position.setText("Position ");
        rbtn_position.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_positionActionPerformed(evt);
            }
        });
        jPanel1.add(rbtn_position, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        rbtn_dept.setBackground(new java.awt.Color(0, 153, 255));
        rbtn_dept.setForeground(new java.awt.Color(255, 255, 255));
        rbtn_dept.setText("Department");
        rbtn_dept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_deptActionPerformed(evt);
            }
        });
        jPanel1.add(rbtn_dept, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 90, -1));

        rbtn_age.setBackground(new java.awt.Color(0, 153, 255));
        rbtn_age.setForeground(new java.awt.Color(255, 255, 255));
        rbtn_age.setText("Age");
        rbtn_age.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_ageActionPerformed(evt);
            }
        });
        jPanel1.add(rbtn_age, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        rbtn_city.setBackground(new java.awt.Color(0, 153, 255));
        rbtn_city.setForeground(new java.awt.Color(255, 255, 255));
        rbtn_city.setText("City");
        rbtn_city.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_cityActionPerformed(evt);
            }
        });
        jPanel1.add(rbtn_city, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));

        rbtn_project.setBackground(new java.awt.Color(0, 153, 255));
        rbtn_project.setForeground(new java.awt.Color(255, 255, 255));
        rbtn_project.setText("Project");
        rbtn_project.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_projectActionPerformed(evt);
            }
        });
        jPanel1.add(rbtn_project, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Select Criteria", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 240, 130));

        jLabel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selection", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 260, 190));

        tbl_employee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_employee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_employeeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_employee);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 520, 170));

        btn_close.setMnemonic('E');
        btn_close.setText("Close");
        btn_close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });
        jPanel1.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 470, -1, -1));

        btn_ok.setMnemonic('K');
        btn_ok.setText("Ok");
        btn_ok.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_okActionPerformed(evt);
            }
        });
        jPanel1.add(btn_ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 60, -1));

        btn_print.setMnemonic('P');
        btn_print.setText("Print");
        btn_print.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });
        jPanel1.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, -1, -1));

        btn_clear.setMnemonic('C');
        btn_clear.setText("Clear");
        btn_clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        jPanel1.add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtn_positionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_positionActionPerformed
        if (rbtn_position.isSelected()) {
            combo_position.setEnabled(true);
        } else {
            combo_position.setEnabled(false);
        }

    }//GEN-LAST:event_rbtn_positionActionPerformed

    private void rbtn_deptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_deptActionPerformed
        if (rbtn_dept.isSelected()) {
            combo_dept.setEnabled(true);
        } else {
            combo_dept.setEnabled(false);
        }
    }//GEN-LAST:event_rbtn_deptActionPerformed

    private void rbtn_projectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_projectActionPerformed
        if (rbtn_project.isSelected()) {
            combo_project.setEnabled(true);
        } else {
            combo_project.setEnabled(false);
        }
    }//GEN-LAST:event_rbtn_projectActionPerformed

    private void rbtn_ageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_ageActionPerformed
        if (rbtn_age.isSelected()) {
            spn_age.setEnabled(true);
        } else {
            spn_age.setEnabled(false);
        }
    }//GEN-LAST:event_rbtn_ageActionPerformed

    private void rbtn_cityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_cityActionPerformed
        if (rbtn_city.isSelected()) {
            txt_city.setEnabled(true);
        } else {
            txt_city.setEnabled(false);
        }
    }//GEN-LAST:event_rbtn_cityActionPerformed

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        this.dispose();
        new Home().setVisible(true);
    }//GEN-LAST:event_btn_closeActionPerformed

    private void btn_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_okActionPerformed
        dtm.setRowCount(0);
        if (rbtn_dept.isSelected() && rbtn_position.isSelected() && rbtn_project.isSelected()) {
            ar = erdb.getAllDataFromDBAccordingToProjectAndDeptAndPos(combo_project.getSelectedItem().toString(), combo_dept.getSelectedItem().toString(), combo_position.getSelectedItem().toString());
        } else if (rbtn_position.isSelected() && rbtn_dept.isSelected()) {
            ar = erdb.getAllDataFromDBAccordingToPosAndDept(combo_position.getSelectedItem().toString(), combo_dept.getSelectedItem().toString());
        } else if (rbtn_age.isSelected() && rbtn_dept.isSelected()) {
            if (!spn_age.getValue().toString().equals("0")) {
                ar = erdb.getAllDataFromDBAccordingToDeptAndAge(combo_dept.getSelectedItem().toString(), Integer.parseInt(spn_age.getValue().toString()));
            } else {
                JOptionPane.showMessageDialog(this, "Set Value For The Age");
            }
        } else if (rbtn_dept.isSelected() && rbtn_city.isSelected()) {
            if (!txt_city.getText().equals("")) {
                ar = erdb.getAllDataFromDBAccordingToDeptAndCity(txt_city.getText(), combo_dept.getSelectedItem().toString());
            } else {
                JOptionPane.showMessageDialog(this, "Enter Value for City TextField");
                txt_city.grabFocus();
            }
        } else if (rbtn_dept.isSelected() && rbtn_project.isSelected()) {
            ar = erdb.getAllDataFromDBAccordingToProjectAndDept(combo_project.getSelectedItem().toString(), combo_dept.getSelectedItem().toString());
        } else if (rbtn_position.isSelected()) {
            ar = erdb.getAllDataFromDBAccordingToPos(combo_position.getSelectedItem().toString());
        } else if (rbtn_dept.isSelected()) {
            ar = erdb.getAllDataFromDBAccordingToDept(combo_dept.getSelectedItem().toString());
        } else if (rbtn_age.isSelected()) {
            if (!spn_age.getValue().toString().equals("0")) {
                ar = erdb.getAllDataFromDBAccordingToAge(Integer.parseInt(spn_age.getValue().toString()));
            } else {
                JOptionPane.showMessageDialog(this, "Set Value for Age");
            }

        } else if (rbtn_city.isSelected()) {
            if (!txt_city.getText().equals("")) {
                ar = erdb.getAllDataFromDBAccordingToCity(txt_city.getText());
            } else {
                JOptionPane.showMessageDialog(this, "Enter Value for City");
                txt_city.grabFocus();
            }
        } else if (rbtn_project.isSelected()) {
            ar = erdb.getAllDataFromDBAccordingToProject(combo_project.getSelectedItem().toString());
        } else {
            JOptionPane.showMessageDialog(this, "Select Valid Criteria");
            clearFields();
        }
        addDataToTable(ar);
    }//GEN-LAST:event_btn_okActionPerformed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        MessageFormat header = null;
        MessageFormat footer = new MessageFormat("Page{0,number,integer}" + "                       " + setDate());
        if (rbtn_dept.isSelected() && rbtn_position.isSelected() && rbtn_project.isSelected()) {
            header = new MessageFormat("Details of all the " + String.valueOf(combo_position.getSelectedItem()) + "s Working under " + String.valueOf(combo_project.getSelectedItem()) + " Project and " + String.valueOf(combo_dept.getSelectedItem()));
        } else if (rbtn_position.isSelected() && rbtn_dept.isSelected()) {
            header = new MessageFormat("Details of all the " + String.valueOf(combo_position.getSelectedItem() + "s Working under " + String.valueOf(combo_dept.getSelectedItem())));
        } else if (rbtn_age.isSelected() && rbtn_dept.isSelected()) {
            header = new MessageFormat("Employees whose age is " + spn_age.getValue() + " and working under " + String.valueOf(combo_dept.getSelectedItem()));
        } else if (rbtn_dept.isSelected() && rbtn_city.isSelected()) {
            header = new MessageFormat("Employees Who Are Working under " + String.valueOf(combo_dept.getSelectedItem() + " and Lives in " + txt_city.getText()));
        } else if (rbtn_dept.isSelected() && rbtn_project.isSelected()) {
            header = new MessageFormat("Employees Who Are Working under " + String.valueOf(combo_dept.getSelectedItem() + " and " + String.valueOf(combo_project.getSelectedItem())));
        } else if (rbtn_position.isSelected()) {
            header = new MessageFormat("Details of all the " + String.valueOf(dtm.getValueAt(0, 12)) + " in the Company");
        } else if (rbtn_dept.isSelected()) {
            header = new MessageFormat("Details of all the Employees Working in " + String.valueOf(combo_dept.getSelectedItem()) + " Department");
        } else if (rbtn_age.isSelected()) {
            header = new MessageFormat("Details of all the Employees who are " + spn_age.getValue().toString() + " Years Old.");
        } else if (rbtn_city.isSelected()) {
            header = new MessageFormat("Details of all the Employees who live in " + String.valueOf(dtm.getValueAt(0, 8)));
        } else if (rbtn_project.isSelected()) {
            header = new MessageFormat("Details of all the Employees working in " + String.valueOf(combo_project.getSelectedItem()) + " Project");
        }
        try {
            tbl_employee.print(JTable.PrintMode.NORMAL, header, footer);
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

    }//GEN-LAST:event_btn_printActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        clearFields();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void tbl_employeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_employeeMouseClicked
        int i = tbl_employee.getSelectedRow();
        int id = (int) dtm.getValueAt(i, 0);
        String fName = (String) dtm.getValueAt(i, 1);
        String lName = (String) dtm.getValueAt(i, 2);
        String nic = (String) dtm.getValueAt(i, 3);
        String gender = (String) dtm.getValueAt(i, 4);
        Date dob = (Date) dtm.getValueAt(i, 5);
        String addNo = (String) dtm.getValueAt(i, 6);
        String addStreet = (String) dtm.getValueAt(i, 7);
        String addCity = (String) dtm.getValueAt(i, 8);
        String teleHome = (String) dtm.getValueAt(i, 9);
        String teleMobile = (String) dtm.getValueAt(i, 10);
        String mail = (String) dtm.getValueAt(i, 11);
        String pos = (String) dtm.getValueAt(i, 12);
        int dID = Integer.valueOf(dtm.getValueAt(i, 13).toString());

        JOptionPane.showMessageDialog(tbl_employee, "ID:" + id + "\n" + "Name:" + fName + " " + lName + "\n" + "NIC:" + nic + "\n" + "Gender:" + gender + "\n" + "Date of Birth:" + dob + "\n" + "Address:" + addNo + "," + addStreet + "," + addCity + "\n" + "Tele(Home):" + teleHome + "\n" + "TeleMobile:" + teleMobile + "\n" + "E-mail:" + mail + "\n" + "Position:" + pos + "\n" + "Department ID:" + dID);
    }//GEN-LAST:event_tbl_employeeMouseClicked

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
            java.util.logging.Logger.getLogger(EmployeeReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EmployeeReports().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_ok;
    private javax.swing.JButton btn_print;
    private javax.swing.JComboBox combo_dept;
    private javax.swing.JComboBox combo_position;
    private javax.swing.JComboBox combo_project;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtn_age;
    private javax.swing.JRadioButton rbtn_city;
    private javax.swing.JRadioButton rbtn_dept;
    private javax.swing.JRadioButton rbtn_position;
    private javax.swing.JRadioButton rbtn_project;
    private javax.swing.JSpinner spn_age;
    private javax.swing.JTable tbl_employee;
    private javax.swing.JTextField txt_city;
    // End of variables declaration//GEN-END:variables
}
