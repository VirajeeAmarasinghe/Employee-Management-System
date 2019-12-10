package userInterface;

import businessLogic.DepartmentInfo;
import databaseConnection.DepartmentDB;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Department extends javax.swing.JFrame {

    private ArrayList<DepartmentInfo> arrayListDepartment;
    private DefaultTableModel dtm;
    private DepartmentDB deptDB;

    public Department() {
        initComponents();
        setLocationRelativeTo(null);

        arrayListDepartment = new ArrayList<>();
        deptDB = new DepartmentDB();

        dtm = new DefaultTableModel();
        tbl_dept.setModel(dtm);
        dtm.addColumn("Department ID");
        dtm.addColumn("Department Name");
        dtm.addColumn("Address-No:");
        dtm.addColumn("Address-Street");
        dtm.addColumn("Address-City");
        dtm.addColumn("Telephone");
        dtm.addColumn("E-mail");

        txt_deptID.setText(deptDB.getNextID() + "");
        txt_deptName.grabFocus();
        setAccessPrivileges();
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

    //this method is for establishing access privileges
    private void setAccessPrivileges() {
        if (UserLevel.userLevel.equals("normal user")) {
            btn_add.setEnabled(false);
            btn_del.setEnabled(false);
            btn_edit.setEnabled(false);
        }
    }

    //this method is for validating form
    private boolean isValidForm() {
        Validator v = new Validator();
        if (!v.isPresent(txt_deptID, "Department ID")) {
            return false;
        }
        if (!v.isPresent(txt_deptName, "Department Name")) {
            return false;
        }
        if (!v.isPresent(txt_addStreet, "Address-Street")) {  //Filling Address-No field is not compulsary
            return false;
        }
        if (!v.isPresent(txt_addCity, "Address-City")) {
            return false;
        }

        if (!v.isPresent(txt_tele, "Telephone No")) {
            return false;
        }

        if (!v.isPresent(txt_tele, "E-mail")) {
            return false;
        }

        if (!v.isValidTeleNo(txt_tele, "Telephone")) {
            return false;
        }
        if (!v.isInteger(txt_deptID, "Department ID")) {
            return false;
        }
        return true;
    }

    //this method is for clearing text fields
    private void clearFields() {
        txt_deptName.setText("");
        txt_addNo.setText("");
        txt_addStreet.setText("");
        txt_addCity.setText("");
        txt_tele.setText("");
        txt_email.setText("");
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
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_addNo = new javax.swing.JTextField();
        txt_addStreet = new javax.swing.JTextField();
        txt_addCity = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_deptID = new javax.swing.JTextField();
        txt_deptName = new javax.swing.JTextField();
        txt_tele = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_dept = new javax.swing.JTable();
        btn_add = new javax.swing.JButton();
        btn_del = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_findID = new javax.swing.JButton();
        btn_dis = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_close = new javax.swing.JButton();
        btn_findName = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
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
        jLabel1.setText("Department ID:");
        pnl_third.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Department Name:");
        pnl_third.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Address:");
        pnl_third.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Street:");
        pnl_third.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("No:");
        pnl_third.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        txt_addNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_addNoKeyPressed(evt);
            }
        });
        pnl_third.add(txt_addNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 170, -1));

        txt_addStreet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_addStreetKeyPressed(evt);
            }
        });
        pnl_third.add(txt_addStreet, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 170, -1));

        txt_addCity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_addCityKeyPressed(evt);
            }
        });
        pnl_third.add(txt_addCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 170, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("City:");
        pnl_third.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnl_third.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 250, 100));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Telephone:");
        pnl_third.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("E-mail:");
        pnl_third.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        txt_deptID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_deptIDKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_deptIDKeyTyped(evt);
            }
        });
        pnl_third.add(txt_deptID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 190, -1));

        txt_deptName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_deptNameKeyPressed(evt);
            }
        });
        pnl_third.add(txt_deptName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 190, -1));

        txt_tele.setToolTipText("Tele No Format:XXX-XXXXXXX");
        txt_tele.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_teleKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_teleKeyTyped(evt);
            }
        });
        pnl_third.add(txt_tele, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 180, -1));

        txt_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_emailKeyPressed(evt);
            }
        });
        pnl_third.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 180, -1));

        tbl_dept.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_dept.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_deptMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_dept);

        pnl_third.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 380, 90));

        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/floppy_disk_red.png"))); // NOI18N
        btn_add.setMnemonic('A');
        btn_add.setText("Add");
        btn_add.setToolTipText("");
        btn_add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        pnl_third.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 100, -1));

        btn_del.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/database_del.png"))); // NOI18N
        btn_del.setMnemonic('D');
        btn_del.setText("Delete");
        btn_del.setToolTipText("");
        btn_del.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delActionPerformed(evt);
            }
        });
        pnl_third.add(btn_del, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 100, -1));

        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit_but.gif"))); // NOI18N
        btn_edit.setMnemonic('E');
        btn_edit.setText("Edit");
        btn_edit.setToolTipText("");
        btn_edit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        pnl_third.add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 100, -1));

        btn_findID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/find-icon.png"))); // NOI18N
        btn_findID.setMnemonic('I');
        btn_findID.setText("ID");
        btn_findID.setToolTipText("");
        btn_findID.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_findID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_findIDActionPerformed(evt);
            }
        });
        pnl_third.add(btn_findID, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 80, -1));

        btn_dis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/display.jpg"))); // NOI18N
        btn_dis.setMnemonic('P');
        btn_dis.setText("Display");
        btn_dis.setToolTipText("");
        btn_dis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_dis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_disActionPerformed(evt);
            }
        });
        pnl_third.add(btn_dis, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 100, -1));

        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/clear.png"))); // NOI18N
        btn_clear.setMnemonic('C');
        btn_clear.setText("Clear");
        btn_clear.setToolTipText("");
        btn_clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        pnl_third.add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 100, 30));

        btn_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/exit.png"))); // NOI18N
        btn_close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });
        pnl_third.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 30, -1));

        btn_findName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/find-icon.png"))); // NOI18N
        btn_findName.setMnemonic('N');
        btn_findName.setText("Name");
        btn_findName.setToolTipText("");
        btn_findName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_findNameActionPerformed(evt);
            }
        });
        pnl_third.add(btn_findName, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, -1, -1));

        jLabel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Find", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        pnl_third.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 110, 90));

        btn_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/printer_red (1).png"))); // NOI18N
        btn_print.setMnemonic('R');
        btn_print.setText("Print");
        btn_print.setToolTipText("");
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });
        pnl_third.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        pnl_second.add(pnl_third, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 400, 440));

        pnl_main.add(pnl_second, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 420, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_main, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_main, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        if (isValidForm()) {
            DepartmentInfo dept = new DepartmentInfo(Integer.parseInt(txt_deptID.getText()), txt_deptName.getText(), txt_addNo.getText(), txt_addStreet.getText(), txt_addCity.getText(), txt_tele.getText(), txt_email.getText());
            int result = deptDB.addData(dept);
            if (result == 1) {
                JOptionPane.showMessageDialog(btn_add, "New Department added successfully");
                clearFields();
                txt_deptID.setText(deptDB.getNextID() + "");
                txt_deptName.grabFocus();
            } else if (result == 0) {
                JOptionPane.showMessageDialog(btn_add, "Some Error Occurred.New Department was not added");
            }
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_disActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_disActionPerformed
        dtm.setRowCount(0);
        ArrayList<DepartmentInfo> ar = deptDB.getAllData();
        if (ar != null) {
            for (DepartmentInfo d : ar) {
                int dId = d.getDeptID();
                String deptName = d.getDeptName();
                String addNo = d.getAddNo();
                String addStreet = d.getAddStreet();
                String addCity = d.getAddCity();
                String tel = d.getTele();
                String email = d.getEmail();

                dtm.addRow(new Object[]{dId, deptName, addNo, addStreet, addCity, tel, email});
            }
        }
    }//GEN-LAST:event_btn_disActionPerformed

    private void btn_findIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_findIDActionPerformed
        String input = JOptionPane.showInputDialog("Enter Valid Department ID");
        if (input != null) {
            int dID = Integer.parseInt(input);
            DepartmentInfo d = deptDB.getDataById(dID);
            if (d != null) {
                txt_deptID.setText(dID + "");
                txt_deptName.setText(d.getDeptName());
                txt_addNo.setText(d.getAddNo());
                txt_addStreet.setText(d.getAddStreet());
                txt_addCity.setText(d.getAddCity());
                txt_tele.setText(d.getTele());
                txt_email.setText(d.getEmail());
            } else {
                JOptionPane.showMessageDialog(btn_findID, "Entered Number is not available");
            }
        }
    }//GEN-LAST:event_btn_findIDActionPerformed

    private void btn_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delActionPerformed
        String input = JOptionPane.showInputDialog("Enter Valid Department ID");
        if (input != null) {
            int inputYesNo = JOptionPane.showConfirmDialog(btn_del, "Are U Sure U want to delete this Record?");
            if (inputYesNo == 0) {
                int dID = Integer.parseInt(input);
                int result = deptDB.deleteData(dID);
                if (result == 1) {
                    JOptionPane.showMessageDialog(btn_del, "Department deleted successfully");
                    clearFields();
                    txt_deptID.setText(deptDB.getNextID() + "");
                } else if (result == 0) {
                    JOptionPane.showMessageDialog(btn_del, "Department not deleted.Some Error Occurred.");
                }
            }
        }
    }//GEN-LAST:event_btn_delActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        if (isValidForm()) {
            DepartmentInfo dinfo;
            int dID = Integer.parseInt(txt_deptID.getText());
            String deptName = txt_deptName.getText();
            String addNo = txt_addNo.getText();
            String addStreet = txt_addStreet.getText();
            String addCity = txt_addCity.getText();
            String tele = txt_tele.getText();
            String mail = txt_email.getText();

            dinfo = new DepartmentInfo(dID, deptName, addNo, addStreet, addCity, tele, mail);

            int result = deptDB.editData(dinfo);
            if (result == 1) {
                JOptionPane.showMessageDialog(btn_edit, "Department edited successfully");
                clearFields();
                txt_deptID.setText(deptDB.getNextID() + "");
            } else if (result == 0) {
                JOptionPane.showMessageDialog(btn_edit, "Department not edited.Some error occurred.");
            }
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        clearFields();
        txt_deptID.setText(deptDB.getNextID() + "");
        int i = tbl_dept.getRowCount();
        for (int j = 0; j < i; j++) {  //removing rows in the table one by one
            dtm.removeRow(0);
        }
        txt_deptName.grabFocus();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        this.dispose();
        Home h = new Home();
        h.setVisible(true);
    }//GEN-LAST:event_btn_closeActionPerformed

    private void txt_teleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_teleKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && !(evt.getKeyChar() == '-')) {
            evt.consume();
        }
        if (txt_tele.getText().length() > 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_teleKeyTyped

    private void txt_deptIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_deptIDKeyPressed
        if (evt.getKeyCode() == 10) {
            txt_deptName.grabFocus();
        }
        if (evt.getKeyCode() == 40) {
            txt_deptName.grabFocus();
        }
    }//GEN-LAST:event_txt_deptIDKeyPressed

    private void txt_deptNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_deptNameKeyPressed
        if (evt.getKeyCode() == 10) {
            txt_addNo.grabFocus();
        }
        if (evt.getKeyCode() == 40) {
            txt_addNo.grabFocus();
        }
        if (evt.getKeyCode() == 38) {
            txt_deptID.grabFocus();
        }
    }//GEN-LAST:event_txt_deptNameKeyPressed

    private void txt_addNoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_addNoKeyPressed
        if (evt.getKeyCode() == 10) {
            txt_addStreet.grabFocus();
        }
        if (evt.getKeyCode() == 40) {
            txt_addStreet.grabFocus();
        }
        if (evt.getKeyCode() == 38) {
            txt_deptName.grabFocus();
        }
    }//GEN-LAST:event_txt_addNoKeyPressed

    private void txt_addStreetKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_addStreetKeyPressed
        if (evt.getKeyCode() == 10) {
            txt_addCity.grabFocus();
        }
        if (evt.getKeyCode() == 40) {
            txt_addCity.grabFocus();
        }
        if (evt.getKeyCode() == 38) {
            txt_addNo.grabFocus();
        }
    }//GEN-LAST:event_txt_addStreetKeyPressed

    private void txt_addCityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_addCityKeyPressed
        if (evt.getKeyCode() == 10) {
            txt_tele.grabFocus();
        }
        if (evt.getKeyCode() == 40) {
            txt_tele.grabFocus();
        }
        if (evt.getKeyCode() == 38) {
            txt_addStreet.grabFocus();
        }
    }//GEN-LAST:event_txt_addCityKeyPressed

    private void txt_teleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_teleKeyPressed
        if (evt.getKeyCode() == 10) {
            txt_email.grabFocus();
        }
        if (evt.getKeyCode() == 40) {
            txt_email.grabFocus();
        }
        if (evt.getKeyCode() == 38) {
            txt_addCity.grabFocus();
        }
    }//GEN-LAST:event_txt_teleKeyPressed

    private void txt_emailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_emailKeyPressed
        if (evt.getKeyCode() == 38) {
            txt_tele.grabFocus();
        }
    }//GEN-LAST:event_txt_emailKeyPressed

    private void tbl_deptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_deptMouseClicked
        int i = tbl_dept.getSelectedRow();
        int id = (int) dtm.getValueAt(i, 0);
        String deptName = (String) dtm.getValueAt(i, 1);
        String addNo = (String) dtm.getValueAt(i, 2);
        String addStreet = (String) dtm.getValueAt(i, 3);
        String addCity = (String) dtm.getValueAt(i, 4);
        String tele = (String) dtm.getValueAt(i, 5);
        String mail = (String) dtm.getValueAt(i, 6);

        txt_deptID.setText(id + "");
        txt_deptName.setText(deptName);
        txt_addNo.setText(addNo);
        txt_addStreet.setText(addStreet);
        txt_addCity.setText(addCity);
        txt_tele.setText(tele);
        txt_email.setText(mail);
    }//GEN-LAST:event_tbl_deptMouseClicked

    private void txt_deptIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_deptIDKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_deptIDKeyTyped

    private void btn_findNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_findNameActionPerformed
        String input = JOptionPane.showInputDialog("Enter Valid Department Name");
        dtm.setRowCount(0);
        if (input != null) {
            ArrayList<DepartmentInfo> ar = deptDB.getDataByName(input);
            if (ar != null) {
                for (DepartmentInfo d : ar) {
                    int dId = d.getDeptID();
                    String deptName = d.getDeptName();
                    String addNo = d.getAddNo();
                    String addStreet = d.getAddStreet();
                    String addCity = d.getAddCity();
                    String tel = d.getTele();
                    String email = d.getEmail();

                    dtm.addRow(new Object[]{dId, deptName, addNo, addStreet, addCity, tel, email});
                }
            }
        }

    }//GEN-LAST:event_btn_findNameActionPerformed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        MessageFormat header = new MessageFormat("Details of all the Departments");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}" + "                       " + setDate());
        try {
            tbl_dept.print(JTable.PrintMode.NORMAL, header, footer);
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
            java.util.logging.Logger.getLogger(Department.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Department.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Department.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Department.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Department().setVisible(true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnl_main;
    private javax.swing.JPanel pnl_second;
    private javax.swing.JPanel pnl_third;
    private javax.swing.JTable tbl_dept;
    private javax.swing.JTextField txt_addCity;
    private javax.swing.JTextField txt_addNo;
    private javax.swing.JTextField txt_addStreet;
    private javax.swing.JTextField txt_deptID;
    private javax.swing.JTextField txt_deptName;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_tele;
    // End of variables declaration//GEN-END:variables
}
