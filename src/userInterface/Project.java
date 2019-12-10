package userInterface;

import businessLogic.ProjectInfo;
import databaseConnection.ProjectDB;
import java.awt.print.PrinterException;
import java.sql.Date;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

public class Project extends javax.swing.JFrame {

    private ArrayList<ProjectInfo> arrayListProject;
    private DefaultTableModel dtm;
    private ProjectDB pdb = null;
    private SpinnerModel sp = null;

    public Project() {
        initComponents();
        setLocationRelativeTo(null);
        arrayListProject = new ArrayList<>();

        dtm = new DefaultTableModel();
        tbl_project.setModel(dtm);
        dtm.addColumn("Project ID");
        dtm.addColumn("Title");
        dtm.addColumn("Start Date");
        dtm.addColumn("Duration");
        dtm.addColumn("Client ID");

        txt_pTitle.grabFocus();
        pdb = new ProjectDB();
        txt_pID.setText(pdb.getNextID() + "");
        pdb.loadClientIDsFromDB();
        sp = new SpinnerNumberModel();
        spn_duration.setModel(sp);
        setAccessPrivileges();
    }

    //this method is for set access privileges
    private void setAccessPrivileges() {
        if (UserLevel.userLevel.equals("normal user")) {
            btn_add.setEnabled(false);
            btn_del.setEnabled(false);
            btn_edit.setEnabled(false);
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

    //this method is for validating the form
    private boolean isValidForm() {
        Validator v = new Validator();
        if (!v.isPresent(txt_pID, "Project ID")) {
            return false;
        }
        if (!v.isPresent(txt_pTitle, "Title")) {
            return false;
        }
        if (!v.isPresent(txt_sDate, "Start Date")) {
            return false;
        }
        if (!v.isInteger(txt_pID, "Project ID")) {
            return false;
        }
        if (!v.isDate(txt_sDate, "Start Date")) {
            return false;
        }
        return true;
    }

    //this method is for refreshing the window
    private void clearFields() {
        txt_pTitle.setText("");
        txt_sDate.setText("");
        sp.setValue(0);
        combo_cID.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_main = new javax.swing.JPanel();
        pnl_second = new javax.swing.JPanel();
        pnl_third = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_pID = new javax.swing.JTextField();
        txt_pTitle = new javax.swing.JTextField();
        txt_sDate = new javax.swing.JTextField();
        spn_duration = new javax.swing.JSpinner();
        combo_cID = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_project = new javax.swing.JTable();
        btn_add = new javax.swing.JButton();
        btn_del = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_findID = new javax.swing.JButton();
        btn_dis = new javax.swing.JButton();
        btn_close = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_findName = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btn_print = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        pnl_main.setBackground(new java.awt.Color(0, 153, 255));
        pnl_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_second.setBackground(new java.awt.Color(255, 255, 255));
        pnl_second.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_third.setBackground(new java.awt.Color(0, 153, 255));
        pnl_third.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Project ID:");
        pnl_third.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Title:");
        pnl_third.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Start Date:");
        pnl_third.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Duration:");
        pnl_third.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Client ID:");
        pnl_third.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        txt_pID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_pIDKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_pIDKeyTyped(evt);
            }
        });
        pnl_third.add(txt_pID, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 170, -1));

        txt_pTitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_pTitleKeyPressed(evt);
            }
        });
        pnl_third.add(txt_pTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 170, -1));

        txt_sDate.setToolTipText("Date Format:YYYY-MM-DD");
        txt_sDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_sDateKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_sDateKeyTyped(evt);
            }
        });
        pnl_third.add(txt_sDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 170, -1));
        pnl_third.add(spn_duration, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 170, -1));

        pnl_third.add(combo_cID, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 170, -1));

        tbl_project.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_project.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_projectMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_project);

        pnl_third.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 410, 130));

        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/floppy_disk_red.png"))); // NOI18N
        btn_add.setMnemonic('A');
        btn_add.setText("Add");
        btn_add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        pnl_third.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 90, -1));

        btn_del.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/database_del.png"))); // NOI18N
        btn_del.setMnemonic('D');
        btn_del.setText("Delete");
        btn_del.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delActionPerformed(evt);
            }
        });
        pnl_third.add(btn_del, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 90, -1));

        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit_but.gif"))); // NOI18N
        btn_edit.setMnemonic('E');
        btn_edit.setText("Edit");
        btn_edit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        pnl_third.add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 90, -1));

        btn_findID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/find-icon.png"))); // NOI18N
        btn_findID.setMnemonic('I');
        btn_findID.setText("ID");
        btn_findID.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_findID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_findIDActionPerformed(evt);
            }
        });
        pnl_third.add(btn_findID, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 90, -1));

        btn_dis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/display.jpg"))); // NOI18N
        btn_dis.setMnemonic('P');
        btn_dis.setText("Display");
        btn_dis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_dis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_disActionPerformed(evt);
            }
        });
        pnl_third.add(btn_dis, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        btn_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/exit.png"))); // NOI18N
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });
        pnl_third.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 30, -1));

        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/clear.png"))); // NOI18N
        btn_clear.setMnemonic('C');
        btn_clear.setText("Clear");
        btn_clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        pnl_third.add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 90, 30));

        btn_findName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/find-icon.png"))); // NOI18N
        btn_findName.setMnemonic('N');
        btn_findName.setText("Name");
        btn_findName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_findNameActionPerformed(evt);
            }
        });
        pnl_third.add(btn_findName, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 90, -1));

        jLabel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Find", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        pnl_third.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 110, 90));

        btn_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/printer_red (1).png"))); // NOI18N
        btn_print.setMnemonic('R');
        btn_print.setText("Print");
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });
        pnl_third.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, -1, 30));

        pnl_second.add(pnl_third, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 430, 380));

        pnl_main.add(pnl_second, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 450, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_main, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_main, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_pIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pIDKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_pIDKeyTyped

    private void txt_pIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pIDKeyPressed
        if (evt.getKeyCode() == 10) {
            txt_pTitle.grabFocus();
        }
        if (evt.getKeyCode() == 40) {
            txt_pTitle.grabFocus();
        }
    }//GEN-LAST:event_txt_pIDKeyPressed

    private void txt_pTitleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pTitleKeyPressed
        if (evt.getKeyCode() == 10) {
            txt_sDate.grabFocus();
        }
        if (evt.getKeyCode() == 40) {
            txt_sDate.grabFocus();
        }
        if (evt.getKeyCode() == 38) {
            txt_pID.grabFocus();
        }
    }//GEN-LAST:event_txt_pTitleKeyPressed

    private void txt_sDateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sDateKeyPressed
        if (evt.getKeyCode() == 38) {
            txt_pTitle.grabFocus();
        }
    }//GEN-LAST:event_txt_sDateKeyPressed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        clearFields();
        txt_pID.setText(pdb.getNextID() + "");
        int i = tbl_project.getRowCount();
        for (int j = 0; j < i; j++) {  //removing rows from table one by one
            dtm.removeRow(0);
        }
        txt_pTitle.grabFocus();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_disActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_disActionPerformed
        dtm.setRowCount(0);
        ArrayList<ProjectInfo> ar = pdb.getAllDataFromDB();
        if (ar != null) {
            for (ProjectInfo p : ar) {
                int pID = p.getpID();
                String title = p.getTitle();
                Date stDate = p.getStartD();
                int dur = p.getDuration();
                int clID = p.getClientId();
                dtm.addRow(new Object[]{pID, title, stDate, dur, clID});
            }
        }
    }//GEN-LAST:event_btn_disActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        if (isValidForm()) {
            ProjectInfo cl = new ProjectInfo(Integer.parseInt(txt_pID.getText()), txt_pTitle.getText(), Date.valueOf(txt_sDate.getText()), Integer.valueOf(spn_duration.getValue().toString()), Integer.valueOf(combo_cID.getSelectedItem().toString()));
            int result = pdb.addData(cl);
            if (result == 1) {
                JOptionPane.showMessageDialog(btn_add, "New Project added successfully");
                clearFields();
                txt_pID.setText(pdb.getNextID() + "");
            } else if (result == 0) {
                JOptionPane.showMessageDialog(btn_add, "Some Error Occurred.New Project was not added");
            }
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_findIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_findIDActionPerformed
        String input = JOptionPane.showInputDialog("Enter Valid Project ID");
        if (input != null) {
            int pID = Integer.parseInt(input);
            ProjectInfo pr = pdb.getData(pID);
            if (pr != null) {
                txt_pID.setText(pr.getpID() + "");
                txt_pTitle.setText(pr.getTitle());
                txt_sDate.setText(pr.getStartD() + "");
                spn_duration.setValue(pr.getDuration());
                combo_cID.setSelectedItem(pr.getClientId());
            } else {
                JOptionPane.showMessageDialog(btn_findID, "Entered Number is not available");
            }
        }
    }//GEN-LAST:event_btn_findIDActionPerformed

    private void btn_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delActionPerformed
        String input = JOptionPane.showInputDialog("Enter Valid Project ID");
        if (input != null) {
            int inputYesNo = JOptionPane.showConfirmDialog(btn_del, "Are U Sure U want to delete this Record?");
            if (inputYesNo == 0) {
                int cID = Integer.parseInt(input);
                int result = pdb.deleteData(cID);
                if (result == 1) {
                    JOptionPane.showMessageDialog(btn_del, "Project deleted successfully");
                    clearFields();
                    txt_pID.setText(pdb.getNextID() + "");
                } else if (result == 0) {
                    JOptionPane.showMessageDialog(btn_del, "Project not deleted.Enter Valid Client ID");
                }
            }
        }
    }//GEN-LAST:event_btn_delActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        if (isValidForm()) {
            ProjectInfo pinfo;
            int pID = Integer.parseInt(txt_pID.getText());
            String title = txt_pTitle.getText();
            Date stDate = Date.valueOf(txt_sDate.getText());
            int dur = Integer.parseInt(spn_duration.getValue().toString());
            int clID = Integer.parseInt(combo_cID.getSelectedItem().toString());

            pinfo = new ProjectInfo(pID, title, stDate, dur, clID);

            int result = pdb.editData(pinfo);
            if (result == 1) {
                JOptionPane.showMessageDialog(btn_edit, "Project edited successfully");
                clearFields();
                txt_pID.setText(pdb.getNextID() + "");
            } else if (result == 0) {
                JOptionPane.showMessageDialog(btn_edit, "Project not edited.Some Error Occurred.");
            }
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        this.dispose();
        Home h = new Home();
        h.setVisible(true);
    }//GEN-LAST:event_btn_closeActionPerformed

    private void tbl_projectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_projectMouseClicked
        int i = tbl_project.getSelectedRow();
        int id = Integer.parseInt(dtm.getValueAt(i, 0).toString());
        String title = dtm.getValueAt(i, 1).toString();
        Date stDate = Date.valueOf(dtm.getValueAt(i, 2).toString());
        int dur = Integer.parseInt(dtm.getValueAt(i, 3).toString());
        int clID = Integer.parseInt(dtm.getValueAt(i, 4).toString());

        txt_pID.setText(id + "");
        txt_pTitle.setText(title);
        txt_sDate.setText(stDate + "");
        spn_duration.setValue(dur);
        combo_cID.setSelectedItem(clID);
    }//GEN-LAST:event_tbl_projectMouseClicked

    private void txt_sDateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sDateKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && !(evt.getKeyChar() == '-')) {
            evt.consume();
        }
        if (txt_sDate.getText().length() > 9) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_sDateKeyTyped

    private void btn_findNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_findNameActionPerformed
        String input = JOptionPane.showInputDialog("Enter Valid Project Name");
        if (input != null) {
            dtm.setRowCount(0);
            ArrayList<ProjectInfo> ar = pdb.getDataByName(input);
            if (ar != null) {
                for (ProjectInfo p : ar) {
                    int pID = p.getpID();
                    String title = p.getTitle();
                    Date stDate = p.getStartD();
                    int dur = p.getDuration();
                    int clID = p.getClientId();
                    dtm.addRow(new Object[]{pID, title, stDate, dur, clID});
                }
            }
        }
    }//GEN-LAST:event_btn_findNameActionPerformed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        MessageFormat header = new MessageFormat("Details of all the Projects");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}" + "                       " + setDate());
        try {
            tbl_project.print(JTable.PrintMode.NORMAL, header, footer);
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
            java.util.logging.Logger.getLogger(Project.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Project.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Project.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Project.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Project().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_del;
    private javax.swing.JButton btn_dis;
    public static javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_findID;
    private javax.swing.JButton btn_findName;
    private javax.swing.JButton btn_print;
    public static javax.swing.JComboBox combo_cID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnl_main;
    private javax.swing.JPanel pnl_second;
    private javax.swing.JPanel pnl_third;
    private javax.swing.JSpinner spn_duration;
    private javax.swing.JTable tbl_project;
    private javax.swing.JTextField txt_pID;
    private javax.swing.JTextField txt_pTitle;
    private javax.swing.JTextField txt_sDate;
    // End of variables declaration//GEN-END:variables
}
