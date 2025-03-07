/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UserInterface.User;

import Model.UserData.UserData;
import UserInterface.Login.SignIn;
import UserInterface.leaderboards.Leaderboards;
import UserInterface.profile.Profile;
import UserInterface.settings.Settings;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class UserFrame extends javax.swing.JFrame {

    static int profileIndex = -1;
    static ArrayList<UserData> data;

    public void labelHover(JLabel lbl) {
        lbl.setForeground(Color.black);
        lbl.setFont(new java.awt.Font("Retro Gaming", 1, 32)); // NOI18N
    }

    public void labelHoverOut(JLabel lbl) {
        lbl.setForeground(Color.white);
        lbl.setFont(new java.awt.Font("Retro Gaming", 0, 30)); // NOI18N
    }

    public UserFrame(ArrayList<UserData> data, int userIndex) {
        initComponents();
        viewPanel.setViewportView(new Leaderboards(data));
        this.data = data;
        profileIndex = userIndex;
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
        viewPanel = new javax.swing.JScrollPane();

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblleaderboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(lblprofile))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(lblplay))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(lblsettings))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(lbllogout)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(lblplay, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblprofile)
                .addGap(37, 37, 37)
                .addComponent(lblsettings)
                .addGap(37, 37, 37)
                .addComponent(lblleaderboard)
                .addGap(35, 35, 35)
                .addComponent(lbllogout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        viewPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(viewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblplayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblplayMouseClicked
        labelHoverOut(lblplay);

    }//GEN-LAST:event_lblplayMouseClicked

    private void lblplayMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblplayMouseEntered
        labelHover(lblplay);
    }//GEN-LAST:event_lblplayMouseEntered

    private void lblplayMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblplayMouseExited
        labelHoverOut(lblplay);
    }//GEN-LAST:event_lblplayMouseExited

    private void lblprofileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblprofileMouseClicked
        viewPanel.setViewportView(new Profile(data, profileIndex));
        labelHoverOut(lblprofile);

    }//GEN-LAST:event_lblprofileMouseClicked

    private void lblprofileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblprofileMouseEntered
        labelHover(lblprofile);
    }//GEN-LAST:event_lblprofileMouseEntered

    private void lblprofileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblprofileMouseExited
        labelHoverOut(lblprofile);
    }//GEN-LAST:event_lblprofileMouseExited

    private void lblsettingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblsettingsMouseClicked

        labelHoverOut(lblsettings);
        viewPanel.setViewportView(new Settings(data,profileIndex));
    }//GEN-LAST:event_lblsettingsMouseClicked

    private void lblsettingsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblsettingsMouseEntered
        labelHover(lblsettings);
    }//GEN-LAST:event_lblsettingsMouseEntered

    private void lblsettingsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblsettingsMouseExited
        labelHoverOut(lblsettings);
    }//GEN-LAST:event_lblsettingsMouseExited

    private void lbllogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbllogoutMouseClicked
        labelHoverOut(lbllogout);
        new UserData().userLogout(data,profileIndex);
        this.dispose();
        JOptionPane.showMessageDialog(null,"SUCCESSFULLY LOGOUT(RECORDED)","LOGOUT!",JOptionPane.INFORMATION_MESSAGE);
        new SignIn(data).setVisible(true);
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
        labelHoverOut(lblleaderboard);
        viewPanel.setViewportView(new Leaderboards(data));
    }//GEN-LAST:event_lblleaderboardMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int choose = JOptionPane.showConfirmDialog(null, "ARE YOU SURE YOU WANT TO LOGOUT?", "LOGOUT?", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (choose == JOptionPane.YES_OPTION) {
            dispose();
            new UserData().userLogout(data, profileIndex);
            new SignIn(data).setVisible(true);

        }
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
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserFrame(data, profileIndex).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblleaderboard;
    private javax.swing.JLabel lbllogout;
    private javax.swing.JLabel lblplay;
    private javax.swing.JLabel lblprofile;
    private javax.swing.JLabel lblsettings;
    private javax.swing.JScrollPane viewPanel;
    // End of variables declaration//GEN-END:variables
}
