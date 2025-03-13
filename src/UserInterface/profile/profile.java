/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.profile;

import Function.Image.FitImage;
import Model.DataManager.DataManager;
import Model.UserData.UserData;
import UserInterface.LogInAndOut.LogInAndOut;
import UserInterface.changedata.*;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Profile extends javax.swing.JPanel {

    private static Profile instance = null;
    private DataManager data = DataManager.getInstance();
    private static int userIndex;

    public void updateProfile() {
        UserData us = data.getData().get(userIndex);
        lblfirstName.setText(us.getFirstName());
        lbllastname.setText(us.getLastName());
        lblusername.setText(us.getUsername());
        System.out.println(us.getGender());
        lblgender.setText(us.getGender());
        lblbod.setText(us.getBOD());
        new FitImage().risizelabel(us.getProfile(), lblprofilepicture);

    }

    public static Profile getInstance(int userIndex) {
        if (instance == null) {
            instance = new Profile(userIndex);
        } else {
            Profile.userIndex = userIndex;
            instance.updateProfile();
        }
        return instance;
    }

    public Profile(int userIndex) {
        initComponents();
        lblprofilepicture.setSize(133, 126);//set the size to make the lblprofilepicture not a null

        this.userIndex = userIndex;
        updateProfile();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lable = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblusername = new javax.swing.JLabel();
        lbllastname = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lable2 = new javax.swing.JLabel();
        lblgender = new javax.swing.JLabel();
        lblbod = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnchangePassword = new UserInterface.CustomComponents.MyButton();
        btnchangeUsername = new UserInterface.CustomComponents.MyButton();
        btnchangePI = new UserInterface.CustomComponents.MyButton();
        btnchangeProfile = new UserInterface.CustomComponents.MyButton();
        btnchangeProfile1 = new UserInterface.CustomComponents.MyButton();
        lable1 = new javax.swing.JLabel();
        lblfirstName = new javax.swing.JLabel();
        lblprofilepicture = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));

        lable.setFont(new java.awt.Font("Retro Gaming", 1, 24)); // NOI18N
        lable.setForeground(new java.awt.Color(0, 0, 0));
        lable.setText("Username:");

        jLabel2.setFont(new java.awt.Font("Retro Gaming", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("LastName:");

        lblusername.setFont(new java.awt.Font("Retro Gaming", 1, 24)); // NOI18N
        lblusername.setForeground(new java.awt.Color(0, 0, 0));
        lblusername.setText("username");

        lbllastname.setFont(new java.awt.Font("Retro Gaming", 1, 24)); // NOI18N
        lbllastname.setForeground(new java.awt.Color(0, 0, 0));
        lbllastname.setText("LastName:");

        jLabel4.setFont(new java.awt.Font("Retro Gaming", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Gender:");

        lable2.setFont(new java.awt.Font("Retro Gaming", 1, 24)); // NOI18N
        lable2.setForeground(new java.awt.Color(0, 0, 0));
        lable2.setText("BOD:");

        lblgender.setFont(new java.awt.Font("Retro Gaming", 1, 24)); // NOI18N
        lblgender.setForeground(new java.awt.Color(0, 0, 0));
        lblgender.setText("LastName:");

        lblbod.setFont(new java.awt.Font("Retro Gaming", 1, 24)); // NOI18N
        lblbod.setForeground(new java.awt.Color(0, 0, 0));
        lblbod.setText("Age");

        jPanel2.setBackground(new java.awt.Color(0, 204, 0));

        btnchangePassword.setBackground(new java.awt.Color(0, 204, 0));
        btnchangePassword.setText("Change Password");
        btnchangePassword.setBorderColor(new java.awt.Color(0, 204, 0));
        btnchangePassword.setColor(new java.awt.Color(0, 204, 0));
        btnchangePassword.setColorClick(new java.awt.Color(51, 255, 51));
        btnchangePassword.setColorOver(new java.awt.Color(0, 255, 0));
        btnchangePassword.setFont(new java.awt.Font("Retro Gaming", 0, 14)); // NOI18N
        btnchangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchangePasswordActionPerformed(evt);
            }
        });

        btnchangeUsername.setBackground(new java.awt.Color(0, 204, 0));
        btnchangeUsername.setText("Change Username");
        btnchangeUsername.setBorderColor(new java.awt.Color(0, 204, 0));
        btnchangeUsername.setColor(new java.awt.Color(0, 204, 0));
        btnchangeUsername.setColorClick(new java.awt.Color(51, 255, 51));
        btnchangeUsername.setColorOver(new java.awt.Color(0, 255, 0));
        btnchangeUsername.setFont(new java.awt.Font("Retro Gaming", 0, 14)); // NOI18N
        btnchangeUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchangeUsernameActionPerformed(evt);
            }
        });

        btnchangePI.setText("Change PersonInfo");
        btnchangePI.setBorderColor(new java.awt.Color(0, 204, 0));
        btnchangePI.setColor(new java.awt.Color(0, 204, 0));
        btnchangePI.setColorClick(new java.awt.Color(51, 255, 51));
        btnchangePI.setColorOver(new java.awt.Color(0, 255, 0));
        btnchangePI.setFont(new java.awt.Font("Retro Gaming", 0, 12)); // NOI18N
        btnchangePI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchangePIActionPerformed(evt);
            }
        });

        btnchangeProfile.setBackground(new java.awt.Color(0, 204, 0));
        btnchangeProfile.setText("Change Profile");
        btnchangeProfile.setBorderColor(new java.awt.Color(0, 204, 0));
        btnchangeProfile.setColor(new java.awt.Color(0, 204, 0));
        btnchangeProfile.setColorClick(new java.awt.Color(51, 255, 51));
        btnchangeProfile.setColorOver(new java.awt.Color(0, 255, 0));
        btnchangeProfile.setFont(new java.awt.Font("Retro Gaming", 0, 14)); // NOI18N
        btnchangeProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchangeProfileActionPerformed(evt);
            }
        });

        btnchangeProfile1.setBackground(new java.awt.Color(0, 204, 0));
        btnchangeProfile1.setText("See In/Out");
        btnchangeProfile1.setBorderColor(new java.awt.Color(0, 204, 0));
        btnchangeProfile1.setColor(new java.awt.Color(0, 204, 0));
        btnchangeProfile1.setColorClick(new java.awt.Color(51, 255, 51));
        btnchangeProfile1.setColorOver(new java.awt.Color(0, 255, 0));
        btnchangeProfile1.setFont(new java.awt.Font("Retro Gaming", 0, 14)); // NOI18N
        btnchangeProfile1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchangeProfile1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnchangePassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnchangeUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnchangePI, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnchangeProfile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(btnchangeProfile1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(btnchangePI, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnchangeUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnchangePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnchangeProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnchangeProfile1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(187, Short.MAX_VALUE))
        );

        lable1.setFont(new java.awt.Font("Retro Gaming", 1, 24)); // NOI18N
        lable1.setForeground(new java.awt.Color(0, 0, 0));
        lable1.setText("FirstName:");

        lblfirstName.setFont(new java.awt.Font("Retro Gaming", 1, 24)); // NOI18N
        lblfirstName.setForeground(new java.awt.Color(0, 0, 0));
        lblfirstName.setText("FirstName:");

        lblprofilepicture.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblgender, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(310, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lable2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblbod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(123, 123, 123))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblprofilepicture, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbllastname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lable)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblusername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lable1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblfirstName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lable)
                            .addComponent(lblusername))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lable1)
                            .addComponent(lblfirstName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lbllastname)))
                    .addComponent(lblprofilepicture, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lable2)
                    .addComponent(lblbod))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblgender))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnchangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchangePasswordActionPerformed
        new ChangePass(null, true, userIndex).setVisible(true);
    }//GEN-LAST:event_btnchangePasswordActionPerformed

    private void btnchangeUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchangeUsernameActionPerformed
        new ChangeUser(null, false, userIndex).setVisible(true);
    }//GEN-LAST:event_btnchangeUsernameActionPerformed

    private void btnchangePIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchangePIActionPerformed
        new ChangeProfInfo(null, true, userIndex).setVisible(true);
    }//GEN-LAST:event_btnchangePIActionPerformed

    private void btnchangeProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchangeProfileActionPerformed
        new ChangeProf(null, true, userIndex).setVisible(true);
    }//GEN-LAST:event_btnchangeProfileActionPerformed

    private void btnchangeProfile1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchangeProfile1ActionPerformed
        new LogInAndOut(null, true, data.getData(), userIndex).setVisible(true);
    }//GEN-LAST:event_btnchangeProfile1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private UserInterface.CustomComponents.MyButton btnchangePI;
    private UserInterface.CustomComponents.MyButton btnchangePassword;
    private UserInterface.CustomComponents.MyButton btnchangeProfile;
    private UserInterface.CustomComponents.MyButton btnchangeProfile1;
    private UserInterface.CustomComponents.MyButton btnchangeUsername;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lable;
    private javax.swing.JLabel lable1;
    private javax.swing.JLabel lable2;
    private javax.swing.JLabel lblbod;
    private javax.swing.JLabel lblfirstName;
    private javax.swing.JLabel lblgender;
    private javax.swing.JLabel lbllastname;
    private javax.swing.JLabel lblprofilepicture;
    private javax.swing.JLabel lblusername;
    // End of variables declaration//GEN-END:variables

}
