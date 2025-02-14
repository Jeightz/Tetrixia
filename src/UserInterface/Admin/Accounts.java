/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.Admin;

import Function.Image.FitImage;
import Function.SeeAndUnseePass.SeeAndUnseePass;
import Function.file.file;
import Function.password.checkPasswordField;
import Function.textField.txtField;
import Model.UserData.UserData;
import UserInterface.Login.SignIn;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Accounts extends javax.swing.JPanel {

    private ArrayList<UserData> data = new ArrayList<>();
    File profile = null;
    private final checkPasswordField pass = new checkPasswordField();
    private final txtField txt = new txtField();
    private final SeeAndUnseePass cbpass = new SeeAndUnseePass();
    int userIndex = -1;

    private boolean isValidSignUpInput(String username, String firstName, String lastName, String gender, String birthDate, String password) {
        return !(gender.equals("Gender") || firstName.isEmpty() || lastName.isEmpty() || username.isEmpty()
                || password.isEmpty() || birthDate.isEmpty()
                || firstName.equalsIgnoreCase("FirstName") || lastName.equalsIgnoreCase("LastName")
                || username.equalsIgnoreCase("Username") || password.equalsIgnoreCase("Password"));
    }

    private void resetInputData() {
        txtusername.setText("Username");
        txtfirstname.setText("FirstName");
        txtlastname.setText("LastName");
        datePicker2.getComponentDateTextField().setText("");
        cbgender.insertItemAt("Gender", 0);
        cbgender.setSelectedIndex(0);
        profile = null;
        txtpassword.setText("Password");
    }

    public Accounts() {
        initComponents();
        new UserData().addDataAccountTable(data, myTable1);
        chckseeUnsee.setVisible(false);
        txtpassword.setEchoChar((char) 0);
        btnban.setEnabled(false);
        btndelete.setEnabled(false);
        btnupdate.setEnabled(false);
        this.datePicker2.getComponentDateTextField().setEnabled(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        myTable1 = new UserInterface.CustomComponents.MyTable();
        jPanel2 = new javax.swing.JPanel();
        txtlastname = new UserInterface.CustomComponents.MyTextField();
        chckseeUnsee = new javax.swing.JCheckBox();
        cbgender = new javax.swing.JComboBox<>();
        datePicker2 = new com.github.lgooddatepicker.components.DatePicker();
        txtfirstname = new UserInterface.CustomComponents.MyTextField();
        txtusername = new UserInterface.CustomComponents.MyTextField();
        myButton1 = new UserInterface.CustomComponents.MyButton();
        lblpictureHolder = new javax.swing.JLabel();
        txtpassword = new UserInterface.CustomComponents.MyPasswordField();
        jPanel3 = new javax.swing.JPanel();
        btnadd = new UserInterface.CustomComponents.MyButton();
        btnupdate = new UserInterface.CustomComponents.MyButton();
        btndelete = new UserInterface.CustomComponents.MyButton();
        btnban = new UserInterface.CustomComponents.MyButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(621, 570));

        myTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID#", "Username", "Name", "Score"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        myTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(myTable1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        txtlastname.setText("LastName");
        txtlastname.setRadius(50);
        txtlastname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtlastnameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtlastnameFocusLost(evt);
            }
        });
        txtlastname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtlastnameMouseClicked(evt);
            }
        });

        chckseeUnsee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/see.png"))); // NOI18N
        chckseeUnsee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckseeUnseeActionPerformed(evt);
            }
        });

        cbgender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gender", "Male", "Female" }));
        cbgender.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbgenderItemStateChanged(evt);
            }
        });

        txtfirstname.setText("FirstName");
        txtfirstname.setRadius(50);
        txtfirstname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfirstnameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtfirstnameFocusLost(evt);
            }
        });
        txtfirstname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtfirstnameMouseClicked(evt);
            }
        });

        txtusername.setText("Username");
        txtusername.setRadius(50);
        txtusername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtusernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtusernameFocusLost(evt);
            }
        });
        txtusername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtusernameMouseClicked(evt);
            }
        });
        txtusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusernameActionPerformed(evt);
            }
        });

        myButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pic.png"))); // NOI18N
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });

        lblpictureHolder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtpassword.setText("Password");
        txtpassword.setCornerRadius(50);
        txtpassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtpasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtpasswordFocusLost(evt);
            }
        });
        txtpassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtpasswordMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblpictureHolder, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtusername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtfirstname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbgender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(datePicker2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtpassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chckseeUnsee))
                    .addComponent(txtlastname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblpictureHolder, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txtfirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(cbgender, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(chckseeUnsee, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(txtlastname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(datePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 30));

        btnadd.setText("Add Account");
        btnadd.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnadd.setRadius(50);
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });
        jPanel3.add(btnadd);

        btnupdate.setText("Update Account");
        btnupdate.setBorderColor(new java.awt.Color(102, 204, 0));
        btnupdate.setColor(new java.awt.Color(102, 204, 0));
        btnupdate.setColorClick(new java.awt.Color(153, 255, 51));
        btnupdate.setColorOver(new java.awt.Color(153, 255, 102));
        btnupdate.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnupdate.setRadius(50);
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        jPanel3.add(btnupdate);

        btndelete.setText("Delete Account");
        btndelete.setBorderColor(new java.awt.Color(255, 0, 0));
        btndelete.setColor(new java.awt.Color(255, 0, 0));
        btndelete.setColorClick(new java.awt.Color(255, 51, 51));
        btndelete.setColorOver(new java.awt.Color(255, 102, 102));
        btndelete.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btndelete.setRadius(50);
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        jPanel3.add(btndelete);

        btnban.setText("Ban Account");
        btnban.setBorderColor(new java.awt.Color(255, 102, 0));
        btnban.setColor(new java.awt.Color(255, 102, 0));
        btnban.setColorClick(new java.awt.Color(255, 204, 51));
        btnban.setColorOver(new java.awt.Color(255, 204, 102));
        btnban.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnban.setRadius(50);
        jPanel3.add(btnban);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusernameActionPerformed

    private void txtusernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtusernameFocusGained
        txt.checkTextField(txtusername, "Username");
    }//GEN-LAST:event_txtusernameFocusGained

    private void txtusernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtusernameFocusLost
        txt.checkTextFieldEmpty(txtusername, "Username");
    }//GEN-LAST:event_txtusernameFocusLost

    private void txtusernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtusernameMouseClicked
        txt.checkTextField(txtusername, "Username");
    }//GEN-LAST:event_txtusernameMouseClicked

    private void txtfirstnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfirstnameFocusGained
        txt.checkTextField(txtfirstname, "FIrstName");
    }//GEN-LAST:event_txtfirstnameFocusGained

    private void txtfirstnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfirstnameFocusLost
        txt.checkTextFieldEmpty(txtfirstname, "FirstName");
    }//GEN-LAST:event_txtfirstnameFocusLost

    private void txtfirstnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtfirstnameMouseClicked
        txt.checkTextField(txtfirstname, "FirstName");
    }//GEN-LAST:event_txtfirstnameMouseClicked

    private void txtlastnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtlastnameFocusGained
        txt.checkTextField(txtlastname, "LastName");
    }//GEN-LAST:event_txtlastnameFocusGained

    private void txtlastnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtlastnameFocusLost
        txt.checkTextFieldEmpty(txtlastname, "LastName");
    }//GEN-LAST:event_txtlastnameFocusLost

    private void txtlastnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtlastnameMouseClicked
        txt.checkTextField(txtlastname, "LastName");
    }//GEN-LAST:event_txtlastnameMouseClicked

    private void txtpasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpasswordFocusGained
        pass.HoverAndClickPassword(txtpassword, chckseeUnsee, "Password");
    }//GEN-LAST:event_txtpasswordFocusGained

    private void txtpasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpasswordFocusLost
        pass.FocusLostPass(txtpassword, "Password");
    }//GEN-LAST:event_txtpasswordFocusLost

    private void txtpasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtpasswordMouseClicked
        pass.HoverAndClickPassword(txtpassword, chckseeUnsee, "Password");
    }//GEN-LAST:event_txtpasswordMouseClicked

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
        profile = new file().FilePictureFilter(profile);
        new FitImage().risizelabel(profile, lblpictureHolder);
    }//GEN-LAST:event_myButton1ActionPerformed

    private void chckseeUnseeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckseeUnseeActionPerformed
        cbpass.unseeAndseeIconChange(chckseeUnsee, txtpassword);
    }//GEN-LAST:event_chckseeUnseeActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        String pass = txtpassword.getPassword().toString();
        String username = txtusername.getText();
        String lastname = txtlastname.getText();
        String firstname = txtfirstname.getText();
        String bod = datePicker2.getComponentDateTextField().getText();
        String gender = cbgender.getSelectedItem().toString();
        if (!isValidSignUpInput(username, firstname, lastname, gender, bod, pass)|| profile == null) {
            JOptionPane.showMessageDialog(new AdminFrame(), "Invalid SignUp Fill Up EveryThing ", "Invalid SignUP", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        data.add(new UserData(data, username, pass, firstname, bod, gender, profile, bod));
        JOptionPane.showMessageDialog(new SignIn(), "SUCCESSFULLY ADD AN ACCOUNT", "ADD ACOOUNT", JOptionPane.INFORMATION_MESSAGE);
        resetInputData();
        new UserData().addDataAccountTable(data, myTable1);

    }//GEN-LAST:event_btnaddActionPerformed


    private void myTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myTable1MouseClicked
        int row = myTable1.getSelectedRow();
        int col = 1;//get the value in the index 1
        String selectedUsername = (String) myTable1.getValueAt(row, col);
        userIndex = new UserData().findUserIndex(data, selectedUsername);
        UserData us = data.get(userIndex);
        if (row != -1) {
            txtusername.setText(selectedUsername);
            txtfirstname.setText(us.getFirstName());
            txtlastname.setText(us.getLastName());
            datePicker2.setText(us.getBOD());
            cbgender.setSelectedItem(us.getGender());
            profile = us.getProfile();
            new FitImage().risizelabel(profile, lblpictureHolder);
            txtpassword.setEnabled(false);
            btnban.setEnabled(true);
            btnupdate.setEnabled(true);
            btndelete.setEnabled(true);
            btnadd.setEnabled(false);
        }
    }//GEN-LAST:event_myTable1MouseClicked

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        String pass = txtpassword.getPassword().toString();
        String username = txtusername.getText();
        String lastname = txtlastname.getText();
        String firstname = txtfirstname.getText();
        String bod = datePicker2.getComponentDateTextField().getText();
        String gender = cbgender.getSelectedItem().toString();
        if (userIndex == -1) {
            JOptionPane.showMessageDialog(new AdminFrame(), "NO DATA HAS FOUND TO UPDATE", "UPDATE NO DATA", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (!isValidSignUpInput(username, firstname, lastname, gender, bod, pass) || profile == null) {
            JOptionPane.showMessageDialog(new AdminFrame(), "Invalid Update Fill Up EveryThing Or Please dont Leave Empty", "Invalid SignUP", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        new UserData().updatePersonData(data, userIndex, firstname, lastname, gender, bod);
        new UserData().updateProfile(data, userIndex, profile);
        new UserData().updateUsername(data, userIndex, username);
        resetInputData();

        JOptionPane.showMessageDialog(new AdminFrame(), "Successfully update the Account", "SUCCESSFULLY UPDATED", JOptionPane.INFORMATION_MESSAGE);
        new UserData().addDataAccountTable(data, myTable1);
      componentEnanbleAfterOperation();
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        new UserData().deleteData(data, userIndex);
        JOptionPane.showMessageDialog(new AdminFrame(), "Successfully deleted the Account", "SUCCESSFULLY DELETED ACCOUNT", JOptionPane.INFORMATION_MESSAGE);
        resetInputData();
        new UserData().addDataAccountTable(data, myTable1);
        componentEnanbleAfterOperation();
    }//GEN-LAST:event_btndeleteActionPerformed
    private void componentEnanbleAfterOperation(){
        txtpassword.setEnabled(true);
        btnban.setEnabled(false);
        btnupdate.setEnabled(false);
        btndelete.setEnabled(false);
        btnadd.setEnabled(true);
    }
    private void cbgenderItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbgenderItemStateChanged
        if (!cbgender.equals("Gender")) {
            cbgender.removeItem("Gender");
        }
        if(profile == null){
        profile = new file().FileCheckGender(profile, cbgender, lblpictureHolder);
        }
    }//GEN-LAST:event_cbgenderItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private UserInterface.CustomComponents.MyButton btnadd;
    private UserInterface.CustomComponents.MyButton btnban;
    private UserInterface.CustomComponents.MyButton btndelete;
    private UserInterface.CustomComponents.MyButton btnupdate;
    private javax.swing.JComboBox<String> cbgender;
    private javax.swing.JCheckBox chckseeUnsee;
    private com.github.lgooddatepicker.components.DatePicker datePicker2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblpictureHolder;
    private UserInterface.CustomComponents.MyButton myButton1;
    private UserInterface.CustomComponents.MyTable myTable1;
    private UserInterface.CustomComponents.MyTextField txtfirstname;
    private UserInterface.CustomComponents.MyTextField txtlastname;
    private UserInterface.CustomComponents.MyPasswordField txtpassword;
    private UserInterface.CustomComponents.MyTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
