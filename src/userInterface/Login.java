package userInterface;

import businessLogic.LoginInfo;
import databaseConnection.LoginDB;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    private String reverseword = "";  //this variable is for storing reverse user user id and password
    private LoginInfo l = null;
    private LoginDB ldb;
    private static int countRound = 1; //this variable is to count rounds

    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        ldb = new LoginDB();
        txt_userID.grabFocus();
    }

    //this method is for validating the Form
    private boolean isValidForm() {
        Validator v = new Validator();
        if (!v.isPresent(txt_userID, "User ID")) {
            return false;
        }
        if (!v.isPresent(pwd_pass, "Password")) {
            return false;
        }
        return true;
    }

    
    //this method is for implementing encryption technique
    private String reverseuser_pass(String user_pass) {

        if (user_pass.length() == 1) {
            return user_pass;
        } else {
            reverseword += user_pass.charAt(user_pass.length() - 1) + reverseuser_pass(user_pass.substring(0, user_pass.length() - 1));
            return reverseword;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_main = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_userID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pwd_pass = new javax.swing.JPasswordField();
        jLabel23 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_close = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btn_log = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        pnl_main.setBackground(new java.awt.Color(0, 153, 255));
        pnl_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(0, 153, 255));
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnl_main.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 20, 20));

        jLabel6.setBackground(new java.awt.Color(0, 153, 255));
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnl_main.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 20, 20));

        jLabel7.setBackground(new java.awt.Color(0, 153, 255));
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnl_main.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 20, 20));

        jLabel8.setBackground(new java.awt.Color(0, 153, 255));
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnl_main.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 20, 20));

        jLabel9.setBackground(new java.awt.Color(0, 153, 255));
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnl_main.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, 20));

        jLabel10.setBackground(new java.awt.Color(0, 153, 255));
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnl_main.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 20, 20));

        jLabel11.setBackground(new java.awt.Color(0, 153, 255));
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnl_main.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 20, 20));

        jLabel12.setBackground(new java.awt.Color(0, 153, 255));
        jLabel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnl_main.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 20, 20));

        jLabel14.setBackground(new java.awt.Color(0, 153, 255));
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnl_main.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 20, 20));

        jLabel15.setBackground(new java.awt.Color(0, 153, 255));
        jLabel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnl_main.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 20, 20));

        jLabel17.setBackground(new java.awt.Color(0, 153, 255));
        jLabel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnl_main.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 20, 20));

        jLabel18.setBackground(new java.awt.Color(0, 153, 255));
        jLabel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnl_main.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 20, 20));

        jLabel19.setBackground(new java.awt.Color(0, 153, 255));
        jLabel19.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnl_main.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 20, 20));

        jLabel20.setBackground(new java.awt.Color(0, 153, 255));
        jLabel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnl_main.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 20, 20));

        jLabel21.setBackground(new java.awt.Color(0, 153, 255));
        jLabel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnl_main.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 20, 20));

        jLabel22.setBackground(new java.awt.Color(0, 153, 255));
        jLabel22.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnl_main.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 20, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("User ID");
        pnl_main.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, -1, -1));

        txt_userID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_userIDKeyPressed(evt);
            }
        });
        pnl_main.add(txt_userID, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 180, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");
        pnl_main.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, -1, -1));

        pwd_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pwd_passKeyPressed(evt);
            }
        });
        pnl_main.add(pwd_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 190, -1));

        jLabel23.setBackground(new java.awt.Color(0, 153, 255));
        jLabel23.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnl_main.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 20, 20));

        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnl_main.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 410, 80));

        btn_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/close.gif"))); // NOI18N
        btn_close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });
        pnl_main.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, 50, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/lock_image.gif"))); // NOI18N
        pnl_main.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 110, 100));

        jLabel24.setBackground(new java.awt.Color(0, 153, 255));
        jLabel24.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnl_main.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 70, 70));

        btn_log.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/log_key.gif"))); // NOI18N
        btn_log.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logActionPerformed(evt);
            }
        });
        pnl_main.add(btn_log, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 50, 50));

        jLabel25.setBackground(new java.awt.Color(0, 153, 255));
        jLabel25.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnl_main.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 70, 70));

        jLabel28.setBackground(new java.awt.Color(0, 153, 255));
        jLabel28.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnl_main.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 20, 20));

        jLabel29.setBackground(new java.awt.Color(0, 153, 255));
        jLabel29.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnl_main.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 20, 20));

        jLabel30.setBackground(new java.awt.Color(0, 153, 255));
        jLabel30.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnl_main.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 20, 20));

        jLabel31.setBackground(new java.awt.Color(0, 153, 255));
        jLabel31.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnl_main.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 230, 20, 20));

        jLabel32.setBackground(new java.awt.Color(0, 153, 255));
        jLabel32.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnl_main.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 20, 20));

        jLabel33.setBackground(new java.awt.Color(0, 153, 255));
        jLabel33.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnl_main.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, 20, 20));

        jLabel34.setBackground(new java.awt.Color(0, 153, 255));
        jLabel34.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnl_main.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 20, 20));

        jLabel35.setBackground(new java.awt.Color(0, 153, 255));
        jLabel35.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnl_main.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 20, 20));

        jLabel36.setBackground(new java.awt.Color(0, 153, 255));
        jLabel36.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnl_main.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, 20, 20));

        jLabel37.setBackground(new java.awt.Color(0, 153, 255));
        jLabel37.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnl_main.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, 20, 20));

        jLabel38.setBackground(new java.awt.Color(0, 153, 255));
        jLabel38.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnl_main.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 20, 20));

        jLabel39.setBackground(new java.awt.Color(0, 153, 255));
        jLabel39.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnl_main.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 230, 20, 20));

        jLabel40.setBackground(new java.awt.Color(0, 153, 255));
        jLabel40.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnl_main.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 20, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_main, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_logActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logActionPerformed
        if (isValidForm()) {
            String username = reverseuser_pass(txt_userID.getText());
            reverseword = "";
            String pass = reverseuser_pass(new String(pwd_pass.getPassword()));
            reverseword = "";
            l = ldb.getLogin(username);
            if (countRound < 3) {     //1.In here it checks whether the user exceeds the attempts or not
                if (l != null) {    //2.In here it checks whther entered user id is valid or not.
                    if (l.getPassword().equals(pass)) {  //3.in here it checks whether the enterd password is math with the user id
                        UserLevel.userLevel = l.getUserLevel();
                        Home mv = new Home();
                        mv.setVisible(true);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(btn_log, "Incorrect Password.You have " + (3 - countRound) + " Attempts More.");
                        countRound++;
                        pwd_pass.grabFocus();
                    }
                } else {
                    JOptionPane.showMessageDialog(btn_log, "Incorrect User ID.You have " + (3 - countRound) + " Attempts More.");
                    countRound++;
                    txt_userID.grabFocus();
                }
            } else {
                JOptionPane.showMessageDialog(btn_log, "Your Attempts exceed the Limits");
                System.exit(0);
            }
        }
    }//GEN-LAST:event_btn_logActionPerformed

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_closeActionPerformed

    private void txt_userIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_userIDKeyPressed
        if (evt.getKeyCode() == 10) {
            pwd_pass.grabFocus();
        }
        if (evt.getKeyCode() == 39) {
            pwd_pass.grabFocus();
        }

    }//GEN-LAST:event_txt_userIDKeyPressed

    private void pwd_passKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pwd_passKeyPressed
        if (evt.getKeyCode() == 37) {
            txt_userID.grabFocus();
        }
    }//GEN-LAST:event_pwd_passKeyPressed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_log;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel pnl_main;
    private javax.swing.JPasswordField pwd_pass;
    private javax.swing.JTextField txt_userID;
    // End of variables declaration//GEN-END:variables
}
