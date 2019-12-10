package userInterface;

import businessLogic.EmployeeInfo;
import businessLogic.EmployeeProjectRegiInfo;
import businessLogic.ProjectInfo;
import databaseConnection.EmployeeDB;
import databaseConnection.EmployeeProjectRegiDB;
import databaseConnection.ProjectDB;
import java.awt.print.PrinterException;
import java.sql.Date;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EmployeeProjectRegistration extends javax.swing.JFrame {

    private ArrayList<EmployeeProjectRegiInfo> arrayListProEm;
    private DefaultTableModel dtm;
    private EmployeeProjectRegiDB epr;
    private ProjectDB p;
    private EmployeeDB e;
    private ArrayList<ProjectInfo> arrayListPro;
    private ArrayList<EmployeeInfo> arrayListEmp;

    public EmployeeProjectRegistration() {
        initComponents();
        setLocationRelativeTo(null);

        arrayListProEm = new ArrayList<>();

        dtm = new DefaultTableModel();
        tbl_regi.setModel(dtm);
        dtm.addColumn("Registration ID");
        dtm.addColumn("Employee ID");
        dtm.addColumn("Project ID");
        dtm.addColumn("Start Date");
        dtm.addColumn("Finish Date");

        epr = new EmployeeProjectRegiDB();
        p = new ProjectDB();
        e = new EmployeeDB();
        txt_regID.setText(epr.getNextID() + "");
        txt_startDate.grabFocus();

        //loading employee ids to combo box
        arrayListEmp = e.getAllDataFromDB();
        for (EmployeeInfo e : arrayListEmp) {
            combo_eID.addItem(e.geteID());
        }

        //loading project ids to combo box
        arrayListPro = p.getAllDataFromDB();
        for (ProjectInfo p : arrayListPro) {
            combo_pID.addItem(p.getpID());
        }
        setAccessPrivileges();
    }

    //set access priviles
    private void setAccessPrivileges() {
        if (UserLevel.userLevel.equals("normal user")) {
            btn_add.setEnabled(false);
            btn_del.setEnabled(false);
            btn_edit.setEnabled(false);
        }
    }

    //getiing system date and time
    private String setDate() {
        String d = new java.util.Date().toString();
        String day = d.split(" ")[2];
        String month = d.split(" ")[1];
        String year = d.split(" ")[5];
        String date = day + "/" + month + "/" + year;
        String time = d.split(" ")[3];
        return date + ":" + time;
    }

    //validating form
    private boolean isValidForm() {
        Validator v = new Validator();
        if (!v.isPresent(txt_regID, "Registration ID")) {
            return false;
        }
        if (!v.isPresent(txt_startDate, "Start Date")) {
            return false;
        }
        if (!v.isPresent(txt_finishDate, "Finish Date")) {
            return false;
        }
        if (!v.isInteger(txt_regID, "Registration ID")) {
            return false;
        }
        if (!v.isDate(txt_startDate, "Start Date")) {
            return false;
        }
        if (!v.isDate(txt_finishDate, "Finish Date")) {
            return false;
        }
        return true;
    }

    //refreshing the window
    private void clearFields() {
        txt_regID.setText("");
        txt_startDate.setText("");
        txt_finishDate.setText("");
        combo_eID.setSelectedIndex(0);
        combo_pID.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btn_close = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_regID = new javax.swing.JTextField();
        combo_eID = new javax.swing.JComboBox();
        combo_pID = new javax.swing.JComboBox();
        txt_startDate = new javax.swing.JTextField();
        txt_finishDate = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        btn_del = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_find = new javax.swing.JButton();
        btn_display = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_regi = new javax.swing.JTable();
        btn_print = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 153, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/exit.png"))); // NOI18N
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });
        jPanel3.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 30, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registration ID:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Employee ID:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Project ID:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Start Date:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Finish Date:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        txt_regID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_regIDKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_regIDKeyTyped(evt);
            }
        });
        jPanel3.add(txt_regID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 200, -1));

        jPanel3.add(combo_eID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 200, -1));

        jPanel3.add(combo_pID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 200, -1));

        txt_startDate.setToolTipText("Date Format:YYYY-MM-DD");
        txt_startDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_startDateKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_startDateKeyTyped(evt);
            }
        });
        jPanel3.add(txt_startDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 200, -1));

        txt_finishDate.setToolTipText("Date Format:YYYY-MM-DD");
        txt_finishDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_finishDateKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_finishDateKeyTyped(evt);
            }
        });
        jPanel3.add(txt_finishDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 200, -1));

        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/floppy_disk_red.png"))); // NOI18N
        btn_add.setMnemonic('A');
        btn_add.setText("Add");
        btn_add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        jPanel3.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 80, -1));

        btn_del.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/database_del.png"))); // NOI18N
        btn_del.setMnemonic('D');
        btn_del.setText("Delete");
        btn_del.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delActionPerformed(evt);
            }
        });
        jPanel3.add(btn_del, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, -1, -1));

        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit_but.gif"))); // NOI18N
        btn_edit.setMnemonic('E');
        btn_edit.setText("Edit");
        btn_edit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        jPanel3.add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 80, -1));

        btn_find.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/find-icon.png"))); // NOI18N
        btn_find.setMnemonic('F');
        btn_find.setText("Find");
        btn_find.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_findActionPerformed(evt);
            }
        });
        jPanel3.add(btn_find, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 80, -1));

        btn_display.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/display.jpg"))); // NOI18N
        btn_display.setMnemonic('P');
        btn_display.setText("Display");
        btn_display.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_display.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_displayActionPerformed(evt);
            }
        });
        jPanel3.add(btn_display, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/clear.png"))); // NOI18N
        btn_clear.setMnemonic('C');
        btn_clear.setText("Clear");
        btn_clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        jPanel3.add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 80, 30));

        tbl_regi.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_regi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_regiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_regi);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 420, 110));

        btn_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/printer_red (1).png"))); // NOI18N
        btn_print.setMnemonic('R');
        btn_print.setText("Print");
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });
        jPanel3.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 80, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 440, 360));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 460, 380));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        clearFields();
        txt_regID.setText(epr.getNextID() + "");
        int i = tbl_regi.getRowCount();
        for (int j = 0; j < i; j++) { //removing table rows one by one.
            dtm.removeRow(0);
        }
        txt_startDate.grabFocus();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        if (isValidForm()) {
            int regiID = Integer.parseInt(txt_regID.getText());
            int eId = Integer.parseInt(combo_eID.getSelectedItem().toString());
            int pId = Integer.parseInt(combo_pID.getSelectedItem().toString());
            Date stDate = Date.valueOf(txt_startDate.getText());
            Date fnDate = Date.valueOf(txt_finishDate.getText());
            EmployeeProjectRegiInfo em = new EmployeeProjectRegiInfo(regiID, eId, pId, stDate, fnDate);
            int result = epr.addData(em);
            if (result == 1) {
                JOptionPane.showMessageDialog(btn_add, "New Registration added successfully");
                clearFields();
                txt_regID.setText(epr.getNextID() + "");  //set next registration id in the text field
            } else if (result == 0) {
                JOptionPane.showMessageDialog(btn_add, "Some Error Occurred.New Registration was not added");
            }
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delActionPerformed
        String input = JOptionPane.showInputDialog("Enter Valid Registration ID");
        if (input != null) {
            int inputYesNo = JOptionPane.showConfirmDialog(btn_del, "Are U Sure U want to delete this Record?");
            if (inputYesNo == 0) {
                int rID = Integer.parseInt(input);
                int result = epr.deleteData(rID);
                if (result == 1) {
                    JOptionPane.showMessageDialog(btn_del, "Registration deleted successfully");
                    clearFields();
                    txt_regID.setText(epr.getNextID() + "");
                } else if (result == 0) {
                    JOptionPane.showMessageDialog(btn_del, "Registration not deleted.Some Error Occurred.");
                }
            }

        }
    }//GEN-LAST:event_btn_delActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        if (isValidForm()) {
            EmployeeProjectRegiInfo einfo;
            int regId = Integer.parseInt(txt_regID.getText());
            int eId = Integer.parseInt(combo_eID.getSelectedItem().toString());
            int pId = Integer.parseInt(combo_pID.getSelectedItem().toString());
            Date stDate = Date.valueOf(txt_startDate.getText());
            Date fnDate = Date.valueOf(txt_finishDate.getText());

            einfo = new EmployeeProjectRegiInfo(regId, eId, pId, stDate, fnDate);

            int result = epr.editData(einfo);
            if (result == 1) {
                JOptionPane.showMessageDialog(btn_edit, "Registration edited successfully");
                clearFields();
                txt_regID.setText(epr.getNextID() + "");
            } else if (result == 0) {
                JOptionPane.showMessageDialog(btn_edit, "Registration not edited.Some Error Occurred.");
            }
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        this.dispose();
        Home h = new Home();
        h.setVisible(true);
    }//GEN-LAST:event_btn_closeActionPerformed

    private void tbl_regiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_regiMouseClicked
        int i = tbl_regi.getSelectedRow();
        int regId = (int) dtm.getValueAt(i, 0);
        int eID = (int) dtm.getValueAt(i, 1);
        int pId = (int) dtm.getValueAt(i, 2);
        Date stDate = (Date) dtm.getValueAt(i, 3);
        Date fnDate = (Date) dtm.getValueAt(i, 4);

        txt_regID.setText(regId + "");
        combo_eID.setSelectedItem(eID);
        combo_pID.setSelectedItem(pId);
        txt_startDate.setText(stDate + "");
        txt_finishDate.setText(fnDate + "");
    }//GEN-LAST:event_tbl_regiMouseClicked

    private void btn_findActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_findActionPerformed
        String input = JOptionPane.showInputDialog("Enter Valid Registration ID");
        if (input != null) {
            int regID = Integer.parseInt(input);
            EmployeeProjectRegiInfo e = epr.getData(regID);
            if (e != null) {
                txt_regID.setText(e.getRegId() + "");
                combo_eID.setSelectedItem(e.geteID());
                combo_pID.setSelectedItem(e.getpID());
                txt_startDate.setText(e.getStDate() + "");
                txt_finishDate.setText(e.getfDate() + "");
            } else {
                JOptionPane.showMessageDialog(btn_find, "Entered Number is not available");
            }
        }
    }//GEN-LAST:event_btn_findActionPerformed

    private void btn_displayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_displayActionPerformed
        dtm.setRowCount(0);
        ArrayList<EmployeeProjectRegiInfo> ar = epr.getAllDataFromDB();
        if (ar != null) {
            for (EmployeeProjectRegiInfo e : ar) {
                int regId = e.getRegId();
                int eId = e.geteID();
                int pId = e.getpID();
                Date stdate = e.getStDate();
                Date fnDate = e.getfDate();
                dtm.addRow(new Object[]{regId, eId, pId, stdate, fnDate});
            }
        }
    }//GEN-LAST:event_btn_displayActionPerformed

    private void txt_regIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_regIDKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_regIDKeyTyped

    private void txt_startDateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_startDateKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && !(evt.getKeyChar() == '-')) {
            evt.consume();
        }
        if (txt_startDate.getText().length() > 9) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_startDateKeyTyped

    private void txt_finishDateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_finishDateKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && !(evt.getKeyChar() == '-')) {
            evt.consume();
        }
        if (txt_finishDate.getText().length() > 9) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_finishDateKeyTyped

    private void txt_regIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_regIDKeyPressed
        if (evt.getKeyCode() == 10) {
            txt_startDate.grabFocus();
        }
        if (evt.getKeyCode() == 40) {
            txt_startDate.grabFocus();
        }
    }//GEN-LAST:event_txt_regIDKeyPressed

    private void txt_startDateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_startDateKeyPressed
        if (evt.getKeyCode() == 10) {
            txt_finishDate.grabFocus();
        }
        if (evt.getKeyCode() == 40) {
            txt_finishDate.grabFocus();
        }
        if (evt.getKeyCode() == 38) {
            txt_regID.grabFocus();
        }
    }//GEN-LAST:event_txt_startDateKeyPressed

    private void txt_finishDateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_finishDateKeyPressed
        if (evt.getKeyCode() == 38) {
            txt_startDate.grabFocus();
        }
    }//GEN-LAST:event_txt_finishDateKeyPressed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        MessageFormat header = new MessageFormat("Details of all the Employee-Project Registration Details");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}" + "                       " + setDate());
        try {
            tbl_regi.print(JTable.PrintMode.NORMAL, header, footer);
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btn_printActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeProjectRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeProjectRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeProjectRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeProjectRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EmployeeProjectRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_del;
    private javax.swing.JButton btn_display;
    public static javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_find;
    private javax.swing.JButton btn_print;
    private javax.swing.JComboBox combo_eID;
    private javax.swing.JComboBox combo_pID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_regi;
    private javax.swing.JTextField txt_finishDate;
    private javax.swing.JTextField txt_regID;
    private javax.swing.JTextField txt_startDate;
    // End of variables declaration//GEN-END:variables
}
