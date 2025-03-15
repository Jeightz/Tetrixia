/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UserInterface.Admin;

import Model.DataManager.DataManager;
import Model.UserData.UserData;
import UserInterface.Login.SignIn;
import UserInterface.game.Game;
import UserInterface.leaderboards.Leaderboards;
import UserInterface.profile.Profile;
import UserInterface.settings.Settings;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class AdminFrame extends javax.swing.JFrame {

    private DataManager data = DataManager.getInstance();
    private Accounts Acc;

    private Profile pro;


    public void labelHover(JLabel lbl) {
        lbl.setForeground(Color.black);
        lbl.setFont(new java.awt.Font("Retro Gaming", 1, 32)); // NOI18N
    }

    public void labelHoverOut(JLabel lbl) {
        lbl.setForeground(Color.white);
        lbl.setFont(new java.awt.Font("Retro Gaming", 0, 30)); // NOI18N
    }

    public AdminFrame() {
        initComponents();
        Acc = Accounts.getInstance();
        ViewPanel.setViewportView(Acc);
        pro = Profile.getInstance();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblplay = new javax.swing.JLabel();
        lblprofile = new javax.swing.JLabel();
        lblsettings = new javax.swing.JLabel();
        lblleaderboard = new javax.swing.JLabel();
        lbllogout = new javax.swing.JLabel();
        lblaccount = new javax.swing.JLabel();
        ViewPanel = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 0));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));

        lblplay.setFont(new java.awt.Font("Retro Gaming", 0, 30)); // NOI18N
        lblplay.setForeground(new java.awt.Color(255, 255, 255));
        lblplay.setText("PLAY");
        lblplay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblplay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblplayMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblplayMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblplayMouseExited(evt);
            }
        });

        lblprofile.setFont(new java.awt.Font("Retro Gaming", 0, 30)); // NOI18N
        lblprofile.setForeground(new java.awt.Color(255, 255, 255));
        lblprofile.setText("PROFILE");
        lblprofile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblprofile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblprofileMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblprofileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblprofileMouseExited(evt);
            }
        });

        lblsettings.setFont(new java.awt.Font("Retro Gaming", 0, 30)); // NOI18N
        lblsettings.setForeground(new java.awt.Color(255, 255, 255));
        lblsettings.setText("SETTINGS");
        lblsettings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblsettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblsettingsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblsettingsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblsettingsMouseExited(evt);
            }
        });

        lblleaderboard.setFont(new java.awt.Font("Retro Gaming", 0, 30)); // NOI18N
        lblleaderboard.setForeground(new java.awt.Color(255, 255, 255));
        lblleaderboard.setText("LEADERBOARDS");
        lblleaderboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblleaderboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblleaderboardMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblleaderboardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblleaderboardMouseExited(evt);
            }
        });

        lbllogout.setFont(new java.awt.Font("Retro Gaming", 0, 30)); // NOI18N
        lbllogout.setForeground(new java.awt.Color(255, 255, 255));
        lbllogout.setText("LOGOUT");
        lbllogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbllogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbllogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbllogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbllogoutMouseExited(evt);
            }
        });

        lblaccount.setFont(new java.awt.Font("Retro Gaming", 0, 30)); // NOI18N
        lblaccount.setForeground(new java.awt.Color(255, 255, 255));
        lblaccount.setText("ACCOUNTS");
        lblaccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblaccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblaccountMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblaccountMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblaccountMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lblleaderboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(lblplay))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(lblsettings))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(lblprofile))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(lbllogout))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(lblaccount, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(lblplay, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addGap(35, 35, 35)
                .addComponent(lblprofile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(48, 48, 48)
                .addComponent(lblsettings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(42, 42, 42)
                .addComponent(lblaccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(38, 38, 38)
                .addComponent(lblleaderboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40)
                .addComponent(lbllogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(33, 33, 33))
        );

        ViewPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(ViewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ViewPanel)
                .addGap(1, 1, 1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblplayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblplayMouseClicked
        labelHoverOut(lblplay);
        new Game().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblplayMouseClicked

    private void lblplayMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblplayMouseEntered
        labelHover(lblplay);
    }//GEN-LAST:event_lblplayMouseEntered

    private void lblplayMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblplayMouseExited
        labelHoverOut(lblplay);
    }//GEN-LAST:event_lblplayMouseExited

    private void lblprofileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblprofileMouseClicked
        labelHoverOut(lblprofile);
        ViewPanel.setViewportView(pro);
    }//GEN-LAST:event_lblprofileMouseClicked

    private void lblprofileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblprofileMouseEntered
        labelHover(lblprofile);
    }//GEN-LAST:event_lblprofileMouseEntered

    private void lblprofileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblprofileMouseExited
        labelHoverOut(lblprofile);
    }//GEN-LAST:event_lblprofileMouseExited

    private void lblsettingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblsettingsMouseClicked
        labelHoverOut(lblsettings);
        ViewPanel.setViewportView(new Settings());
    }//GEN-LAST:event_lblsettingsMouseClicked

    private void lblsettingsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblsettingsMouseEntered
        labelHover(lblsettings);
    }//GEN-LAST:event_lblsettingsMouseEntered

    private void lblsettingsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblsettingsMouseExited
        labelHoverOut(lblsettings);
    }//GEN-LAST:event_lblsettingsMouseExited

    private void lbllogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbllogoutMouseClicked
        labelHoverOut(lbllogout);
        new UserData().userLogout(this.data.getCurrentUser());

        this.dispose();
        JOptionPane.showMessageDialog(null, "SUCCESSFULLY LOGOUT(RECORDED)", "LOGOUT!", JOptionPane.INFORMATION_MESSAGE);

        new SignIn(null, false).setVisible(true);
    }//GEN-LAST:event_lbllogoutMouseClicked

    private void lbllogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbllogoutMouseEntered
        labelHover(lbllogout);
    }//GEN-LAST:event_lbllogoutMouseEntered

    private void lbllogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbllogoutMouseExited
        labelHoverOut(lbllogout);
    }//GEN-LAST:event_lbllogoutMouseExited

    private void lblleaderboardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblleaderboardMouseExited
        labelHoverOut(lblleaderboard);
    }//GEN-LAST:event_lblleaderboardMouseExited

    private void lblleaderboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblleaderboardMouseEntered
        labelHover(lblleaderboard);
    }//GEN-LAST:event_lblleaderboardMouseEntered

    private void lblleaderboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblleaderboardMouseClicked
        ViewPanel.setViewportView(new Leaderboards(data.getData()));
        labelHoverOut(lblleaderboard);
    }//GEN-LAST:event_lblleaderboardMouseClicked

    private void lblaccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblaccountMouseClicked
        ViewPanel.setViewportView(Acc);
    }//GEN-LAST:event_lblaccountMouseClicked

    private void lblaccountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblaccountMouseEntered
        labelHover(lblaccount);
    }//GEN-LAST:event_lblaccountMouseEntered

    private void lblaccountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblaccountMouseExited
        labelHoverOut(lblaccount);
    }//GEN-LAST:event_lblaccountMouseExited

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int choose = JOptionPane.showConfirmDialog(null, "ARE YOU SURE YOU WANT TO LOGOUT?", "LOGOUT?", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (choose == JOptionPane.YES_OPTION) {
            dispose();
            new UserData().userLogout(data.getCurrentUser());
            new SignIn(null, false).setVisible(true);
        }
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ViewPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblaccount;
    private javax.swing.JLabel lblleaderboard;
    private javax.swing.JLabel lbllogout;
    private javax.swing.JLabel lblplay;
    private javax.swing.JLabel lblprofile;
    private javax.swing.JLabel lblsettings;
    // End of variables declaration//GEN-END:variables
}
