package userInterface;

import businessLogic.DepartmentInfo;
import businessLogic.ProjectInfo;
import databaseConnection.DepartmentDB;
import databaseConnection.ProjectReportDB;
import java.awt.print.PrinterException;
import java.sql.Date;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProjectReports extends javax.swing.JFrame {

    private ProjectReportDB prdb;
    private ArrayList<ProjectInfo> pr;
    private ArrayList<DepartmentInfo> de;
    private DepartmentDB d;
    private DepartmentDB deDB;
    private DefaultTableModel dtm;
    private Validator v;

    public ProjectReports() {
        initComponents();
        setLocationRelativeTo(null);
        prdb = new ProjectReportDB();
        pr = new ArrayList<>();
        d = new DepartmentDB();
        deDB = new DepartmentDB();

        dtm = new DefaultTableModel();
        tbl_Project.setModel(dtm);
        dtm.addColumn("Project ID");
        dtm.addColumn("Title");
        dtm.addColumn("Start Date");
        dtm.addColumn("Duration");
        dtm.addColumn("Client ID");

        //loading department name to the combo box
        de = d.getAllData();
        for (DepartmentInfo d : de) {
            combo_dept.addItem(d.getDeptName());
        }
        txt_clientName.setEnabled(false);
        txt_empName.setEnabled(false);
        txt_fnDate.setEnabled(false);
        txt_stDate.setEnabled(false);
        combo_dept.setEnabled(false);

        tbl_employeeCount.setVisible(false);
        v = new Validator();
    }

    //this method is for refreashing window
    private void clearFields() {
        txt_clientName.setText("");
        txt_empName.setText("");
        txt_fnDate.setText("");
        txt_stDate.setText("");
        combo_dept.addItem(0);
        buttonGroup1.clearSelection();
        int i = tbl_Project.getRowCount();
        for (int j = 0; j < i; j++) {
            dtm.removeRow(0);
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

    //this method is for adding data to the table
    private void addDataToTable(ArrayList<ProjectInfo> ar) {
        if (ar != null) {
            for (ProjectInfo p : ar) {
                int pID = p.getpID();
                String title = p.getTitle();
                Date stDate = p.getStartD();
                int dur = p.getDuration();
                int clID = p.getClientId();
                dtm.addRow(new Object[]{pID, title, stDate, dur, clID});
            }
        } else {
            JOptionPane.showMessageDialog(this, "No Data Can be Found");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rbtn_employee = new javax.swing.JRadioButton();
        rbtn_dept = new javax.swing.JRadioButton();
        rbtn_client = new javax.swing.JRadioButton();
        rbtn_stDate = new javax.swing.JRadioButton();
        rbtn_fnDate = new javax.swing.JRadioButton();
        rbtn_employeeCount = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        txt_empName = new javax.swing.JTextField();
        lb_empName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        combo_dept = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        txt_clientName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_stDate = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_fnDate = new javax.swing.JTextField();
        btn_ok = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Project = new javax.swing.JTable();
        btn_print = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_close = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_employeeCount = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Project Details");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));

        rbtn_employee.setBackground(new java.awt.Color(0, 153, 255));
        buttonGroup1.add(rbtn_employee);
        rbtn_employee.setForeground(new java.awt.Color(255, 255, 255));
        rbtn_employee.setText("Project Details according to given employee name");
        rbtn_employee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_employeeActionPerformed(evt);
            }
        });
        jPanel1.add(rbtn_employee, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        rbtn_dept.setBackground(new java.awt.Color(0, 153, 255));
        buttonGroup1.add(rbtn_dept);
        rbtn_dept.setForeground(new java.awt.Color(255, 255, 255));
        rbtn_dept.setText("Project Details according to given department name");
        rbtn_dept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_deptActionPerformed(evt);
            }
        });
        jPanel1.add(rbtn_dept, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        rbtn_client.setBackground(new java.awt.Color(0, 153, 255));
        buttonGroup1.add(rbtn_client);
        rbtn_client.setForeground(new java.awt.Color(255, 255, 255));
        rbtn_client.setText("Project Details according to given client name");
        rbtn_client.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_clientActionPerformed(evt);
            }
        });
        jPanel1.add(rbtn_client, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        rbtn_stDate.setBackground(new java.awt.Color(0, 153, 255));
        buttonGroup1.add(rbtn_stDate);
        rbtn_stDate.setForeground(new java.awt.Color(255, 255, 255));
        rbtn_stDate.setText("Project Details according to given started year");
        rbtn_stDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_stDateActionPerformed(evt);
            }
        });
        jPanel1.add(rbtn_stDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        rbtn_fnDate.setBackground(new java.awt.Color(0, 153, 255));
        buttonGroup1.add(rbtn_fnDate);
        rbtn_fnDate.setForeground(new java.awt.Color(255, 255, 255));
        rbtn_fnDate.setText("Project Details according to given finished year");
        rbtn_fnDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_fnDateActionPerformed(evt);
            }
        });
        jPanel1.add(rbtn_fnDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        rbtn_employeeCount.setBackground(new java.awt.Color(0, 153, 255));
        buttonGroup1.add(rbtn_employeeCount);
        rbtn_employeeCount.setForeground(new java.awt.Color(255, 255, 255));
        rbtn_employeeCount.setText("Number of Employees in Each Project");
        rbtn_employeeCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_employeeCountActionPerformed(evt);
            }
        });
        jPanel1.add(rbtn_employeeCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 270, -1));

        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Criteria", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 330, 200));

        txt_empName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_empNameKeyTyped(evt);
            }
        });
        jPanel1.add(txt_empName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 210, -1));

        lb_empName.setForeground(new java.awt.Color(255, 255, 255));
        lb_empName.setText("Type Employee Name Here:");
        jPanel1.add(lb_empName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Select Department Here:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        jPanel1.add(combo_dept, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 210, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Type Client Name Here:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, -1));
        jPanel1.add(txt_clientName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 210, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Type Started Year:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, -1));
        jPanel1.add(txt_stDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 210, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Type Finished Year:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, -1));
        jPanel1.add(txt_fnDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, 210, -1));

        btn_ok.setMnemonic('K');
        btn_ok.setText("Ok");
        btn_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_okActionPerformed(evt);
            }
        });
        jPanel1.add(btn_ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 70, -1));

        tbl_Project.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_Project.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ProjectMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Project);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 460, 90));

        btn_print.setMnemonic('P');
        btn_print.setText("Print");
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });
        jPanel1.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 70, -1));

        btn_clear.setMnemonic('C');
        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        jPanel1.add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 70, -1));

        btn_close.setMnemonic('E');
        btn_close.setText("Close");
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });
        jPanel1.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 70, -1));

        tbl_employeeCount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane2.setViewportView(tbl_employeeCount);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 460, 90));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtn_employeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_employeeActionPerformed
        if (rbtn_employee.isSelected()) {
            txt_empName.setEnabled(true);
            txt_clientName.setEnabled(false);
            txt_fnDate.setEnabled(false);
            txt_stDate.setEnabled(false);
            combo_dept.setEnabled(false);
            txt_empName.grabFocus();
        }
    }//GEN-LAST:event_rbtn_employeeActionPerformed

    private void rbtn_clientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_clientActionPerformed
        if (rbtn_client.isSelected()) {
            txt_clientName.setEnabled(true);
            txt_empName.setEnabled(false);
            txt_fnDate.setEnabled(false);
            txt_stDate.setEnabled(false);
            combo_dept.setEnabled(false);
            txt_clientName.grabFocus();
        }
    }//GEN-LAST:event_rbtn_clientActionPerformed

    private void rbtn_deptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_deptActionPerformed
        if (rbtn_dept.isSelected()) {
            combo_dept.setEnabled(true);
            txt_clientName.setEnabled(false);
            txt_empName.setEnabled(false);
            txt_fnDate.setEnabled(false);
            txt_stDate.setEnabled(false);
        }
    }//GEN-LAST:event_rbtn_deptActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        clearFields();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        this.dispose();
        new Home().setVisible(true);
    }//GEN-LAST:event_btn_closeActionPerformed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        MessageFormat header = null;
        MessageFormat footer = new MessageFormat("Page{0,number,integer}" + "                       " + setDate());
        if (rbtn_employee.isSelected()) {
            header = new MessageFormat("Project Details of " + txt_empName.getText() + " is Working on");
        } else if (rbtn_dept.isSelected()) {
            header = new MessageFormat("Project Details of " + combo_dept.getSelectedItem() + " handles");
        } else if (rbtn_client.isSelected()) {
            header = new MessageFormat("Project Details of " + txt_clientName.getText() + " owns");
        } else if (rbtn_stDate.isSelected()) {
            header = new MessageFormat("Project Details which Started in " + txt_stDate.getText());
        } else if (rbtn_fnDate.isSelected()) {
            header = new MessageFormat("Project Details which Finished in " + txt_fnDate.getText());
        } else if (rbtn_employeeCount.isSelected()) {
            header = new MessageFormat("Number of Employees in Each Project");
        }
        try {
            tbl_Project.print(JTable.PrintMode.NORMAL, header, footer);
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btn_printActionPerformed

    private void btn_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_okActionPerformed
        dtm.setRowCount(0);
        if (rbtn_employeeCount.isSelected()) {
            pr = prdb.getCount();
            DefaultTableModel d = new DefaultTableModel();
            tbl_employeeCount.setModel(d);
            d.addColumn("Title");
            d.addColumn("Number of Employees");
            tbl_employeeCount.setVisible(true);
            tbl_Project.setVisible(false);
            d.setRowCount(0);
            if (pr != null) {
                for (ProjectInfo p : pr) {
                    String title = p.getTitle();
                    int count = p.getCount();
                    d.addRow(new Object[]{title, count});
                }
            } else {
                JOptionPane.showMessageDialog(this, "No Data Can be Found");
            }
        } else if (rbtn_employee.isSelected()) {
            if (v.isPresent(txt_empName, "Employee Name")) {
                String firstName = "";
                String lastName = "";
                if (txt_empName.getText().contains(" ")) {
                    firstName = txt_empName.getText().split(" ")[0];
                    lastName = txt_empName.getText().split(" ")[1];
                } else {
                    firstName = txt_empName.getText();
                    lastName = "";
                }
                pr = prdb.getAllDataFromDBAccordingToEmployee(firstName, lastName);
                addDataToTable(pr);
            }
        } else if (rbtn_dept.isSelected()) {
            pr = prdb.getAllDataFromDBAccordingToDepartment(String.valueOf(combo_dept.getSelectedItem()));
            addDataToTable(pr);
        } else if (rbtn_client.isSelected()) {
            if (v.isPresent(txt_clientName, "Client Name")) {
                pr = prdb.getAllDataFromDBAccordingToClient(txt_clientName.getText());
                addDataToTable(pr);
            }
        } else if (rbtn_stDate.isSelected()) {
            if (v.isPresent(txt_stDate, "Start Date")) {
                pr = prdb.getAllDataFromDBAccordingToStartDate(txt_stDate.getText());
                addDataToTable(pr);
            }
        } else if (rbtn_fnDate.isSelected()) {
            if (v.isPresent(txt_fnDate, "Finish Date")) {
                pr = prdb.getAllDataFromDBAccordingToFinishDate(txt_fnDate.getText());
                addDataToTable(pr);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select a Criteria");
        }
    }//GEN-LAST:event_btn_okActionPerformed

    private void rbtn_stDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_stDateActionPerformed
        if (rbtn_stDate.isSelected()) {
            txt_stDate.setEnabled(true);
            txt_clientName.setEnabled(false);
            txt_empName.setEnabled(false);
            txt_fnDate.setEnabled(false);
            combo_dept.setEnabled(false);
            txt_stDate.grabFocus();
        }
    }//GEN-LAST:event_rbtn_stDateActionPerformed

    private void rbtn_fnDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_fnDateActionPerformed
        if (rbtn_fnDate.isSelected()) {
            txt_fnDate.setEnabled(true);
            txt_clientName.setEnabled(false);
            txt_empName.setEnabled(false);
            txt_stDate.setEnabled(false);
            combo_dept.setEnabled(false);
            txt_fnDate.grabFocus();
        }
    }//GEN-LAST:event_rbtn_fnDateActionPerformed

    private void rbtn_employeeCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_employeeCountActionPerformed
        txt_clientName.setEnabled(false);
        txt_empName.setEnabled(false);
        txt_fnDate.setEnabled(false);
        txt_stDate.setEnabled(false);
        combo_dept.setEnabled(false);
    }//GEN-LAST:event_rbtn_employeeCountActionPerformed

    private void tbl_ProjectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ProjectMouseClicked
        int i = tbl_Project.getSelectedRow();
        int id = Integer.parseInt(dtm.getValueAt(i, 0).toString());
        String title = dtm.getValueAt(i, 1).toString();
        Date stDate = Date.valueOf(dtm.getValueAt(i, 2).toString());
        int dur = Integer.parseInt(dtm.getValueAt(i, 3).toString());
        int clID = Integer.parseInt(dtm.getValueAt(i, 4).toString());

        JOptionPane.showMessageDialog(tbl_Project, "Project ID:" + id + "\n" + "Title:" + title + "\n" + "Start Date:" + stDate + "\n" + "Duration:" + dur + "\n" + "Client ID:" + clID);
    }//GEN-LAST:event_tbl_ProjectMouseClicked

    private void txt_empNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_empNameKeyTyped

    }//GEN-LAST:event_txt_empNameKeyTyped

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
            java.util.logging.Logger.getLogger(ProjectReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProjectReports().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_ok;
    private javax.swing.JButton btn_print;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox combo_dept;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_empName;
    private javax.swing.JRadioButton rbtn_client;
    private javax.swing.JRadioButton rbtn_dept;
    private javax.swing.JRadioButton rbtn_employee;
    private javax.swing.JRadioButton rbtn_employeeCount;
    private javax.swing.JRadioButton rbtn_fnDate;
    private javax.swing.JRadioButton rbtn_stDate;
    private javax.swing.JTable tbl_Project;
    private javax.swing.JTable tbl_employeeCount;
    private javax.swing.JTextField txt_clientName;
    private javax.swing.JTextField txt_empName;
    private javax.swing.JTextField txt_fnDate;
    private javax.swing.JTextField txt_stDate;
    // End of variables declaration//GEN-END:variables
}
