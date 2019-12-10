package userInterface;

import businessLogic.LoginInfo;
import databaseConnection.LoginDB;
import javax.swing.JOptionPane;

public class ChangePassword extends javax.swing.JFrame {

    private LoginDB lo = null;
    private LoginInfo l = null;

    public ChangePassword() {
        initComponents();
        setLocationRelativeTo(null);
        txt_userName.grabFocus();
        lo = new LoginDB();
    }

    private void clearFields() {  //this method is for clearing text fields
        txt_userName.setText("");
        pwd_pass.setText("");
        pwd_confirmPass.setText("");
    }

    private boolean isValidForm() { //this method is for validation
        Validator v = new Validator();
        if (!v.isPresent(txt_userName, "User Name")) {
            return false;
        }
        if (!v.isPresent(pwd_pass, "Password")) {
            return false;
        }
        if (!v.isPresent(pwd_confirmPass, "Confirm Password")) {
            return false;
        }
        return true;
    }

    private boolean isMatchWithPasswordPolicy(String pass) {  //this method is for enforcing password policy
        if (pass.length() < 8) {
            JOptionPane.showMessageDialog(btn_ok, "Minimum Password length must be 8 characters!!!!");
            return false;
        } else {
            if (!pass.matches(".*[A-Z].*")) {
                JOptionPane.showMessageDialog(btn_ok, "Password must contain uppercase letters");
                return false;
            }
            if (!pass.matches(".*[a-z].*")) {
                JOptionPane.showMessageDialog(btn_ok, "Password must contain lowercase letters");
                return false;
            }
            if (!pass.matches(".*\\d.*")) {
                JOptionPane.showMessageDialog(btn_ok, "Password must contain Digits");
                return false;
            }
            if (!pass.matches(".*[~!@#$%\\^&*()\\-_=+\\|\\[{\\]};:'\",<.>/?].*")) {
                JOptionPane.showMessageDialog(btn_ok, "Password must contain special characters");
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_close = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_userName = new javax.swing.JTextField();
        pwd_pass = new javax.swing.JPasswordField();
        pwd_confirmPass = new javax.swing.JPasswordField();
        btn_ok = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 153, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("User ID:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        btn_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/exit.png"))); // NOI18N
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });
        jPanel3.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 30, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Confirm Password:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        txt_userName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_userNameKeyPressed(evt);
            }
        });
        jPanel3.add(txt_userName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 170, -1));

        pwd_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pwd_passKeyPressed(evt);
            }
        });
        jPanel3.add(pwd_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 170, -1));

        pwd_confirmPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pwd_confirmPassKeyPressed(evt);
            }
        });
        jPanel3.add(pwd_confirmPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 170, -1));

        btn_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/floppy_disk_red.png"))); // NOI18N
        btn_ok.setMnemonic('K');
        btn_ok.setText("Ok");
        btn_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_okActionPerformed(evt);
            }
        });
        jPanel3.add(btn_ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 90, 30));

        btn_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/close_but.gif"))); // NOI18N
        btn_cancel.setMnemonic('A');
        btn_cancel.setText("Cancel");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });
        jPanel3.add(btn_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, -1, -1));

        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/clear.png"))); // NOI18N
        btn_clear.setMnemonic('C');
        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        jPanel3.add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 90, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 350, 210));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 370, 230));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_userNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_userNameKeyPressed
        if (evt.getKeyCode() == 10) {
            pwd_pass.grabFocus();
        }
        if (evt.getKeyCode() == 40) {
            pwd_pass.grabFocus();
        }
    }//GEN-LAST:event_txt_userNameKeyPressed

    private void pwd_passKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pwd_passKeyPressed
        if (evt.getKeyCode() == 10) {
            pwd_confirmPass.grabFocus();
        }
        if (evt.getKeyCode() == 40) {
            pwd_confirmPass.grabFocus();
        }
        if (evt.getKeyCode() == 38) {
            txt_userName.grabFocus();
        }
    }//GEN-LAST:event_pwd_passKeyPressed

    private void pwd_confirmPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pwd_confirmPassKeyPressed
        if (evt.getKeyCode() == 38) {
            pwd_pass.grabFocus();
        }
    }//GEN-LAST:event_pwd_confirmPassKeyPressed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        clearFields();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        Home h = new Home();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        Home h = new Home();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_closeActionPerformed

    private void btn_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_okActionPerformed
        if (isValidForm()) {
            String pass1 = new String(pwd_pass.getPassword());
            String pass2 = new String(pwd_confirmPass.getPassword());
            if (pass1.equals(pass2)) {
                if (isMatchWithPasswordPolicy(pass1)) {
                    String userId = txt_userName.getText();
                    String pass = new String(pwd_pass.getPassword());
                    l = new LoginInfo(userId, pass);
                    int result = lo.updatePassword(l);
                    if (result == 1) {
                        JOptionPane.showMessageDialog(btn_ok, "Password is Changed.");
                    } else if (result == 0) {
                        JOptionPane.showMessageDialog(btn_ok, "Password is not updated.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(btn_ok, "Password Confirmation is failed");
            }
        }
    }//GEN-LAST:event_btn_okActionPerformed

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
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChangePassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_close;
    public static javax.swing.JButton btn_ok;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField pwd_confirmPass;
    private javax.swing.JPasswordField pwd_pass;
    private javax.swing.JTextField txt_userName;
    // End of variables declaration//GEN-END:variables
}
