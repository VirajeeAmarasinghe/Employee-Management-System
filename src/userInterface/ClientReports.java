package userInterface;

import businessLogic.ClientInfo;
import businessLogic.ProjectInfo;
import databaseConnection.ClientReportDB;
import databaseConnection.ProjectDB;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ClientReports extends javax.swing.JFrame {

    private ClientReportDB cdb;
    private ProjectDB pdb;
    private ArrayList<ProjectInfo> arProject;
    private ArrayList<ClientInfo> arClient;
    private DefaultTableModel dtm;
    private Validator v;

    public ClientReports() {
        initComponents();
        cdb = new ClientReportDB();
        pdb = new ProjectDB();
        arClient = new ArrayList<>();
        dtm = new DefaultTableModel();
        tbl_client.setModel(dtm);
        v = new Validator();
        dtm.addColumn("client_id");
        dtm.addColumn("client_name");
        dtm.addColumn("add_no");
        dtm.addColumn("add_street");
        dtm.addColumn("add_city");
        dtm.addColumn("nic");
        dtm.addColumn("tele");
        dtm.addColumn("email");

        arProject = pdb.getAllDataFromDB();

        for (ProjectInfo p : arProject) {
            combo_project.addItem(p.getTitle());
        }
        setLocationRelativeTo(null);
        txt_city.setEnabled(false);
        combo_project.setEnabled(false);
    }

    private void clearFileds() { //this method is for refreshing form
        txt_city.setText("");
        combo_project.setSelectedIndex(0);
        buttonGroup1.clearSelection();
        int i = tbl_client.getRowCount();
        for (int j = 0; j < i; j++) {
            dtm.removeRow(0);
        }
    }

    private void addDataToTable(ArrayList<ClientInfo> ar) { //this method is for add data to table
        if (ar != null) {
            for (ClientInfo p : ar) {
                int clID = p.getcId();
                String clName = p.getcName();
                String addNo = p.getAddNo();
                String addStreet = p.getAddStreet();
                String addCity = p.getAddCity();
                String nic = p.getNic();
                String tele = p.getTele();
                String email = p.getEmail();
                dtm.addRow(new Object[]{clID, clName, addNo, addStreet, addCity, nic, tele, email});
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rbtn_city = new javax.swing.JRadioButton();
        rbtn_project = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_client = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txt_city = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        combo_project = new javax.swing.JComboBox();
        btn_ok = new javax.swing.JButton();
        btn_clare = new javax.swing.JButton();
        btn_close = new javax.swing.JButton();
        btn_print = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Client Details");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));

        rbtn_city.setBackground(new java.awt.Color(0, 153, 255));
        buttonGroup1.add(rbtn_city);
        rbtn_city.setForeground(new java.awt.Color(255, 255, 255));
        rbtn_city.setText("Client Details According to Residantial City");
        rbtn_city.setBorder(null);
        rbtn_city.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_cityActionPerformed(evt);
            }
        });
        jPanel1.add(rbtn_city, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        rbtn_project.setBackground(new java.awt.Color(0, 153, 255));
        buttonGroup1.add(rbtn_project);
        rbtn_project.setForeground(new java.awt.Color(255, 255, 255));
        rbtn_project.setText("Client Details According to Project");
        rbtn_project.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_projectActionPerformed(evt);
            }
        });
        jPanel1.add(rbtn_project, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 230, -1));

        tbl_client.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_client.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_clientMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_client);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 560, 130));

        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Criteria", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 280, 90));
        jPanel1.add(txt_city, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 200, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("City:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Project:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, -1, -1));

        jPanel1.add(combo_project, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 200, -1));

        btn_ok.setMnemonic('K');
        btn_ok.setText("Ok");
        btn_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_okActionPerformed(evt);
            }
        });
        jPanel1.add(btn_ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 60, -1));

        btn_clare.setMnemonic('C');
        btn_clare.setText("Clear");
        btn_clare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clareActionPerformed(evt);
            }
        });
        jPanel1.add(btn_clare, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, -1, -1));

        btn_close.setMnemonic('E');
        btn_close.setText("Cancel");
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });
        jPanel1.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, -1, -1));

        btn_print.setMnemonic('P');
        btn_print.setText("Print");
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });
        jPanel1.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 60, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        MessageFormat header = null;
        MessageFormat footer = new MessageFormat("Page{0,number,integer}" + "                       " + setDate());
        if (rbtn_city.isSelected()) {
            header = new MessageFormat("Clients Who Lives in " + txt_city.getText());
        } else if (rbtn_project.isSelected()) {
            header = new MessageFormat("Clients Who is Working in " + String.valueOf(combo_project.getSelectedItem()));
        }

        try {
            tbl_client.print(JTable.PrintMode.NORMAL, header, footer);
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btn_printActionPerformed

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        this.dispose();
        new Home().setVisible(true);
    }//GEN-LAST:event_btn_closeActionPerformed

    private void rbtn_cityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_cityActionPerformed
        if (rbtn_city.isSelected()) {
            txt_city.setEnabled(true);
            combo_project.setEnabled(false);
            txt_city.grabFocus();
        }
    }//GEN-LAST:event_rbtn_cityActionPerformed

    private void rbtn_projectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_projectActionPerformed
        if (rbtn_project.isSelected()) {
            combo_project.setEnabled(true);
            txt_city.setEnabled(false);
        }
    }//GEN-LAST:event_rbtn_projectActionPerformed

    private void btn_clareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clareActionPerformed
        clearFileds();
    }//GEN-LAST:event_btn_clareActionPerformed

    private void btn_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_okActionPerformed
        dtm.setRowCount(0);
        if (rbtn_city.isSelected()) {
            if (v.isPresent(txt_city, "City")) {
                arClient = cdb.getAllDataFromDBAccordingToCity(txt_city.getText());
                addDataToTable(arClient);
            }
        } else if (rbtn_project.isSelected()) {
            arClient = cdb.getAllDataFromDBAccordingToProject(combo_project.getSelectedItem().toString());
            addDataToTable(arClient);
        } else {
            JOptionPane.showMessageDialog(this, "Select a Criteria");
        }
    }//GEN-LAST:event_btn_okActionPerformed

    private void tbl_clientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_clientMouseClicked
        int i = tbl_client.getSelectedRow();
        int id = Integer.parseInt(dtm.getValueAt(i, 0).toString());
        String name = dtm.getValueAt(i, 1).toString();
        String addNo = dtm.getValueAt(i, 2).toString();
        String addStreet = dtm.getValueAt(i, 3).toString();
        String addCity = dtm.getValueAt(i, 4).toString();
        String nic = dtm.getValueAt(i, 5).toString();
        String tele = dtm.getValueAt(i, 6).toString();
        String email = dtm.getValueAt(i, 7).toString();

        JOptionPane.showMessageDialog(tbl_client, "Client ID:" + id + "\n" + "Name:" + name + "\n" + "Address-No:" + addNo + "\n" + "Address-Street:" + addStreet + "\n" + "Address-City:" + addCity + "\n" + "NIC:" + nic + "\n" + "Telephone:" + tele + "\n" + "E-mail:" + email);
    }//GEN-LAST:event_tbl_clientMouseClicked

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
            java.util.logging.Logger.getLogger(ClientReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientReports().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clare;
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_ok;
    private javax.swing.JButton btn_print;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox combo_project;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtn_city;
    private javax.swing.JRadioButton rbtn_project;
    private javax.swing.JTable tbl_client;
    private javax.swing.JTextField txt_city;
    // End of variables declaration//GEN-END:variables
}
