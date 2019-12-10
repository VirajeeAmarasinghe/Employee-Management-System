package userInterface;

import businessLogic.LoginInfo;
import databaseConnection.LoginDB;
import javax.swing.JOptionPane;

public class NewUserRegistration extends javax.swing.JFrame {

    private LoginDB log = null;

    public NewUserRegistration() {
        initComponents();
        setLocationRelativeTo(null);
        txt_userName.grabFocus();
        log = new LoginDB();
    }

    //this method is for refreshing the form
    private void clearFields() {
        txt_userName.setText("");
        pwd_password.setText("");
        pwd_confirmPass.setText("");
        combo_userLevel.setSelectedIndex(0);
    }

    //this method is for enforcing the password policy
    private boolean isMatchWithPasswordPolicy(String pass) {
        if (pass.length() < 8) {
            JOptionPane.showMessageDialog(btn_save, "Minimum Password length must be 8 characters!!!!");
            return false;
        } else {
            if (!pass.matches(".*[A-Z].*")) {
                JOptionPane.showMessageDialog(btn_save, "Password must contain uppercase letters");
                return false;
            }
            if (!pass.matches(".*[a-z].*")) {
                JOptionPane.showMessageDialog(btn_save, "Password must contain lowercase letters");
                return false;
            }
            if (!pass.matches(".*\\d.*")) {
                JOptionPane.showMessageDialog(btn_save, "Password must contain Digits");
                return false;
            }
            if (!pass.matches(".*[~!@#$%\\^&*()\\-_=+\\|\\[{\\]};:'\",<.>/?].*")) {
                JOptionPane.showMessageDialog(btn_save, "Password must contain special characters");
                return false;
            }
        }
        return true;
    }

    //this method is for validating the form
    private boolean isValidForm() {
        Validator v = new Validator();
        if (!v.isPresent(txt_userName, "User Name")) {
            return false;
        }
        if (!v.isPresent(pwd_password, "Password")) {
            return false;
        }
        if (!v.isPresent(pwd_confirmPass, "Confirm Password")) {
            return false;
        }
        return true;
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
        txt_userName = new javax.swing.JTextField();
        pwd_password = new javax.swing.JPasswordField();
        combo_userLevel = new javax.swing.JComboBox();
        pwd_confirmPass = new javax.swing.JPasswordField();
        btn_close = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();

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
        jLabel1.setText("User ID:");
        pnl_third.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password:");
        pnl_third.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("User Level:");
        pnl_third.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Confirm Password:");
        pnl_third.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        txt_userName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_userNameKeyPressed(evt);
            }
        });
        pnl_third.add(txt_userName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 180, -1));

        pwd_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pwd_passwordKeyPressed(evt);
            }
        });
        pnl_third.add(pwd_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 180, -1));

        combo_userLevel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Employee", "HR Manager", "Head of Department", "Administrator" }));
        pnl_third.add(combo_userLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 180, -1));

        pwd_confirmPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pwd_confirmPassKeyPressed(evt);
            }
        });
        pnl_third.add(pwd_confirmPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 180, -1));

        btn_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/exit.png"))); // NOI18N
        btn_close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });
        pnl_third.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 30, -1));

        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/floppy_disk_red.png"))); // NOI18N
        btn_save.setMnemonic('S');
        btn_save.setText("Save");
        btn_save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });
        pnl_third.add(btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/clear.png"))); // NOI18N
        btn_clear.setMnemonic('C');
        btn_clear.setText("Clear");
        btn_clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        pnl_third.add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        pnl_second.add(pnl_third, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 360, 260));

        pnl_main.add(pnl_second, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 280));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_main, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_main, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        clearFields();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void txt_userNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_userNameKeyPressed
        if (evt.getKeyCode() == 10) {
            pwd_password.grabFocus();
        }
        if (evt.getKeyCode() == 40) {
            pwd_password.grabFocus();
        }

    }//GEN-LAST:event_txt_userNameKeyPressed

    private void pwd_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pwd_passwordKeyPressed
        if (evt.getKeyCode() == 10) {
            pwd_confirmPass.grabFocus();
        }
        if (evt.getKeyCode() == 40) {
            pwd_confirmPass.grabFocus();
        }
        if (evt.getKeyCode() == 38) {
            txt_userName.grabFocus();
        }
    }//GEN-LAST:event_pwd_passwordKeyPressed

    private void pwd_confirmPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pwd_confirmPassKeyPressed

        if (evt.getKeyCode() == 38) {
            pwd_password.grabFocus();
        }
    }//GEN-LAST:event_pwd_confirmPassKeyPressed

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        Home h = new Home();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_closeActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        if (isValidForm()) {
            String pass = new String(pwd_password.getPassword());
            String confirmPass = new String(pwd_confirmPass.getPassword());
            if (pass.equals(confirmPass)) {   //in here it checks whether the enetered passwords in two fields are match each other or not
                if (isMatchWithPasswordPolicy(pass)) {  //in here it checks whether the entered password is match with the password policy or not
                    LoginInfo l = new LoginInfo(txt_userName.getText(), pass, combo_userLevel.getSelectedItem().toString());
                    int result = log.addLoginData(l);
                    if (result == 1) {
                        JOptionPane.showMessageDialog(btn_save, "New User Added Successfully");
                        clearFields();
                        txt_userName.grabFocus();
                    } else if (result == 0) {
                        JOptionPane.showMessageDialog(btn_save, "Some Error Occurred.New User not Added.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(btn_save, "Password Confirmation is failed");
                pwd_confirmPass.grabFocus();
            }
        }
    }//GEN-LAST:event_btn_saveActionPerformed

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
            java.util.logging.Logger.getLogger(NewUserRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewUserRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewUserRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewUserRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewUserRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_close;
    public static javax.swing.JButton btn_save;
    private javax.swing.JComboBox combo_userLevel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel pnl_main;
    private javax.swing.JPanel pnl_second;
    private javax.swing.JPanel pnl_third;
    private javax.swing.JPasswordField pwd_confirmPass;
    private javax.swing.JPasswordField pwd_password;
    private javax.swing.JTextField txt_userName;
    // End of variables declaration//GEN-END:variables
}
