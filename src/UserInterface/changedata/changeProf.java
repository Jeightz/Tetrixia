/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package UserInterface.changedata;

import Function.Image.FitImage;
import Function.file.file;
import Model.DataManager.DataManager;
import Model.UserData.UserData;
import UserInterface.profile.Profile;
import java.io.File;
import javax.swing.JOptionPane;

public class ChangeProf extends javax.swing.JDialog {
    private Profile pro ;
    private File profile = null;
    private DataManager data = DataManager.getInstance();
    private static int userIndex;

    public ChangeProf(java.awt.Frame parent, boolean modal, int userIndex) {
        super(parent, modal);
        initComponents();

        this.userIndex = userIndex;
       pro = Profile.getInstance( userIndex);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bodyPanel = new javax.swing.JPanel();
        btnChangeUsername = new UserInterface.CustomComponents.MyButton();
        myButton1 = new UserInterface.CustomComponents.MyButton();
        profilePic = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        headerPanel.setBackground(new java.awt.Color(0, 204, 0));

        jLabel1.setFont(new java.awt.Font("Retro Gaming", 0, 24)); // NOI18N
        jLabel1.setText("Change Profile");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(296, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(16, 16, 16))
        );

        bodyPanel.setBackground(new java.awt.Color(255, 255, 255));
        bodyPanel.setLayout(null);

        btnChangeUsername.setText("Change Profile");
        btnChangeUsername.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnChangeUsername.setRadius(50);
        btnChangeUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeUsernameActionPerformed(evt);
            }
        });
        bodyPanel.add(btnChangeUsername);
        btnChangeUsername.setBounds(352, 265, 174, 39);

        myButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pic.png"))); // NOI18N
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });
        bodyPanel.add(myButton1);
        myButton1.setBounds(190, 200, 40, 40);

        profilePic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bodyPanel.add(profilePic);
        profilePic.setBounds(20, 30, 210, 210);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 532, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bodyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(bodyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
        profile = new file().FilePictureFilter(profile);
        if (profile != null) {
            new FitImage().risizelabel(profile, profilePic);
        }
    }//GEN-LAST:event_myButton1ActionPerformed

    private void btnChangeUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeUsernameActionPerformed
        if (profile != null) {
            UserData us = data.getData().get(userIndex);
            us.updateProfile(data.getData(), userIndex, profile);
            JOptionPane.showMessageDialog(null, "THE PROFILE IS SUCCESSFULLY UPDATE", "SUCCESSFULLY UPDATED", JOptionPane.INFORMATION_MESSAGE);
            //reset the Profile to null
            profile = null;
            profilePic.setIcon(null);
            pro.updateProfile();
            return;
        }
        JOptionPane.showMessageDialog(null, "NO PICTURE DETECTED ", "NO PICTURE", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnChangeUsernameActionPerformed
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
            java.util.logging.Logger.getLogger(ChangeProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangeProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangeProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangeProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ChangeProf dialog = new ChangeProf(new javax.swing.JFrame(), true, userIndex);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bodyPanel;
    private UserInterface.CustomComponents.MyButton btnChangeUsername;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private UserInterface.CustomComponents.MyButton myButton1;
    private javax.swing.JLabel profilePic;
    // End of variables declaration//GEN-END:variables
}
