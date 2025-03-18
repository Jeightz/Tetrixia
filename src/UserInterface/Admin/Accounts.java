/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.Admin;

import Function.CheckDate.CheckDate;
import Function.Image.FitImage;
import Function.SeeAndUnseePass.SeeAndUnseePass;
import Function.file.file;
import Function.password.checkPasswordField;
import Function.textField.txtField;
import Model.DataManager.DataManager;
import Model.UserData.UserData;
import UserInterface.DeletedDatas.DeletedData;
import UserInterface.Login.SignIn;
import UserInterface.LoginConformation.LoginConformation;
import UserInterface.ShowData.ShowedData;
import UserInterface.banAccount.banAccount;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Accounts extends javax.swing.JPanel {

    DataManager data = DataManager.getInstance();
    private checkPasswordField chckpass = new checkPasswordField();
    File profile = null;
    private final checkPasswordField pass = new checkPasswordField();
    private final txtField txt = new txtField();
    private  UserData user = new UserData();
    private final SeeAndUnseePass cbpass = new SeeAndUnseePass();
    private AdminFrame frame;

    private final UserData currentUserLogin = data.getCurrentUser();
    private UserData seletedUser;

    private static Accounts instants = null;

    public static Accounts getInstance() {
        if (instants == null) {
            instants = new Accounts();
        } else {

        }
        return instants;
    }

    public void updateData() {
        user.addDataAccountTable(data.getData(), myTable1);
    }

    private void componentVisibleEnable(boolean maincomponent, boolean actionComponent) {
        txtpassword.setEnabled(maincomponent);
        btnban.setEnabled(actionComponent);
        btnupdate.setEnabled(actionComponent);
        btndelete.setEnabled(actionComponent);
        btnshowdata.setEnabled(actionComponent);
        btnadd.setEnabled(maincomponent);
        btnOverWritePassword.setVisible(actionComponent);
        btncancel.setVisible(actionComponent);
    }

    private boolean checkIfItValid(String username, String pass, String firstname, String lastname, String bod, String gender) {

        if (pass.length() < 5) {
            JOptionPane.showMessageDialog(this, "Invalid SignUp! Please make the password 5 letter up.", "Invalid SignUp", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

        if (!isValidSignUpInput(username, firstname, lastname, gender, bod) || profile == null) {
            JOptionPane.showMessageDialog(null, "Invalid SignUp Fill Up EveryThing ", "Invalid SignUP", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

        if (!new CheckDate().isAtLeast10YearsOld(datePicker2.getText())) {
            JOptionPane.showMessageDialog(null, "The BOD is not applicable cause it is lower than 10 years old age or too high than 100", "NOT APPLICABLE BOD", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean isValidSignUpInput(String username, String firstName, String lastName, String gender, String birthDate) {
        return !(gender.equals("Gender") || firstName.isEmpty() || lastName.isEmpty() || username.isEmpty()
               || birthDate.isEmpty()
                || firstName.equalsIgnoreCase("FirstName") || lastName.equalsIgnoreCase("LastName")
                || username.equalsIgnoreCase("Username") );
    }

    private void resetInputData() {
        txtusername.setText("Username");
        txtfirstname.setText("FirstName");
        txtlastname.setText("LastName");
        datePicker2.getComponentDateTextField().setText("");
        cbgender.insertItemAt("Gender", 0);
        cbgender.setSelectedIndex(0);
        profile = null;
        lblpictureHolder.setIcon(null);
        txtpassword.setText("Password");
        txtpassword.setEchoChar((char) 0);
        chckseeUnsee.setVisible(false);
    }

    public Accounts() {
        initComponents();
        updateData();
        chckseeUnsee.setVisible(false);
        txtpassword.setEchoChar((char) 0);
        btnban.setEnabled(false);
        btndelete.setEnabled(false);
        btnupdate.setEnabled(false);
        btnshowdata.setEnabled(false);
        btncancel.setVisible(false);
        btnOverWritePassword.setVisible(false);
        this.datePicker2.getComponentDateTextField().setEnabled(false);
        checkDeletedUsers();

    }

    private void checkDeletedUsers() {
        if (data.getDeletedAccounts().size() <= 0) {
            btndeleteAccountRecords.setVisible(false);
            return;
        }
        btndeleteAccountRecords.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        myTable1 = new UserInterface.CustomComponents.MyTable();
        jPanel2 = new javax.swing.JPanel();
        txtpassword = new UserInterface.CustomComponents.MyPasswordField();
        txtlastname = new UserInterface.CustomComponents.MyTextField();
        cbgender = new javax.swing.JComboBox<>();
        datePicker2 = new com.github.lgooddatepicker.components.DatePicker();
        txtfirstname = new UserInterface.CustomComponents.MyTextField();
        txtusername = new UserInterface.CustomComponents.MyTextField();
        myButton1 = new UserInterface.CustomComponents.MyButton();
        lblpictureHolder = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        chckseeUnsee = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        btnadd = new UserInterface.CustomComponents.MyButton();
        btnupdate = new UserInterface.CustomComponents.MyButton();
        btndelete = new UserInterface.CustomComponents.MyButton();
        btnban = new UserInterface.CustomComponents.MyButton();
        btnshowdata = new UserInterface.CustomComponents.MyButton();
        btnOverWritePassword = new UserInterface.CustomComponents.MyButton();
        btncancel = new UserInterface.CustomComponents.MyButton();
        btndeleteAccountRecords = new UserInterface.CustomComponents.MyButton();
        txtsearch = new UserInterface.CustomComponents.MyTextField();

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

        txtpassword.setText("Password");
        txtpassword.setCornerRadius(50);
        txtpassword.setCustomIcon1(new javax.swing.ImageIcon(getClass().getResource("/image/password.png"))); // NOI18N
        txtpassword.setName("txtpassword"); // NOI18N
        txtpassword.setNextFocusableComponent(txtfirstname);
        txtpassword.setToolTipText("");
        txtpassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtpasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtpasswordFocusLost(evt);
            }
        });
        txtpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordActionPerformed(evt);
            }
        });
        txtpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpasswordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpasswordKeyReleased(evt);
            }
        });

        txtlastname.setText("LastName");
        txtlastname.setNextFocusableComponent(cbgender);
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

        cbgender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gender", "Male", "Female" }));
        cbgender.setNextFocusableComponent(datePicker2);
        cbgender.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbgenderItemStateChanged(evt);
            }
        });

        txtfirstname.setText("FirstName");
        txtfirstname.setNextFocusableComponent(txtlastname);
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
        txtusername.setNextFocusableComponent(txtpassword);
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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        chckseeUnsee.setText("ShowPassword");
        chckseeUnsee.setForeground(new java.awt.Color(0, 0, 0));
        chckseeUnsee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/see.png"))); // NOI18N
        chckseeUnsee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckseeUnseeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chckseeUnsee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(41, 41, 41))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chckseeUnsee, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

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
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtpassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(3, 3, 3))
                            .addComponent(txtlastname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(datePicker2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(7, 7, 7))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblpictureHolder, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtfirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(cbgender, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtlastname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
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
        btnban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbanActionPerformed(evt);
            }
        });
        jPanel3.add(btnban);

        btnshowdata.setText("Show UserData");
        btnshowdata.setColorClick(new java.awt.Color(51, 102, 255));
        btnshowdata.setColorOver(new java.awt.Color(102, 102, 255));
        btnshowdata.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnshowdata.setRadius(50);
        btnshowdata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnshowdataActionPerformed(evt);
            }
        });
        jPanel3.add(btnshowdata);

        btnOverWritePassword.setText("OverWrite Password");
        btnOverWritePassword.setColorClick(new java.awt.Color(51, 102, 255));
        btnOverWritePassword.setColorOver(new java.awt.Color(102, 102, 255));
        btnOverWritePassword.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnOverWritePassword.setRadius(50);
        btnOverWritePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOverWritePasswordActionPerformed(evt);
            }
        });
        jPanel3.add(btnOverWritePassword);

        btncancel.setText("Cancel");
        btncancel.setColorClick(new java.awt.Color(51, 102, 255));
        btncancel.setColorOver(new java.awt.Color(102, 102, 255));
        btncancel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btncancel.setRadius(50);
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });
        jPanel3.add(btncancel);

        btndeleteAccountRecords.setText("Deleted Account Records");
        btndeleteAccountRecords.setColorClick(new java.awt.Color(51, 102, 255));
        btndeleteAccountRecords.setColorOver(new java.awt.Color(102, 102, 255));
        btndeleteAccountRecords.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btndeleteAccountRecords.setRadius(50);
        btndeleteAccountRecords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteAccountRecordsActionPerformed(evt);
            }
        });
        jPanel3.add(btndeleteAccountRecords);

        txtsearch.setText("Search");
        txtsearch.setCustomIcon1(new javax.swing.ImageIcon(getClass().getResource("/image/3741750_bussiness_ecommerce_marketplace_onlinestore_search_icon (1).png"))); // NOI18N
        txtsearch.setRadius(40);
        txtsearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtsearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtsearchFocusLost(evt);
            }
        });
        txtsearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtsearchMouseClicked(evt);
            }
        });
        txtsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtsearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
        txt.checkTextField(txtfirstname, "FirstName");
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

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
        profile = new file().FilePictureFilter(profile);
        new FitImage().risizelabel(profile, lblpictureHolder);
    }//GEN-LAST:event_myButton1ActionPerformed

    private void chckseeUnseeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckseeUnseeActionPerformed
        cbpass.unseeAndseeIconChange(chckseeUnsee, txtpassword);
    }//GEN-LAST:event_chckseeUnseeActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        String pass = String.valueOf(txtpassword.getPassword()).trim();
        String username = txtusername.getText().trim();
        String lastname = txtlastname.getText().trim();
        String firstname = txtfirstname.getText().trim();
        String bod = datePicker2.getComponentDateTextField().getText().trim();
        String gender = cbgender.getSelectedItem().toString().trim();

        if (user.isUsernameDuplication(data.getData(), username)) {
            JOptionPane.showMessageDialog(null, "THE USERNAME YOU INPUT IS ALREADY EXCIST PLEASE ENTER AGAIN", "USERNAME DUPLICATION", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (checkIfItValid(username, pass, firstname, lastname, bod, gender)) {

            data.addUser(new UserData(data.getData(), username, pass, firstname, lastname, gender, profile, bod));
            JOptionPane.showMessageDialog(null, "SUCCESSFULLY ADD AN ACCOUNT", "ADD ACOOUNT", JOptionPane.INFORMATION_MESSAGE);
            resetInputData();
            new UserData().addDataAccountTable(data.getData(), myTable1);
            return;
        }
    }//GEN-LAST:event_btnaddActionPerformed

    private void checkUser(ArrayList<UserData> data) {
        for (UserData userData : data) {
            if (userData.equals(seletedUser)) {
                user = userData;
                break;
            }
        }
    }

    private void myTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myTable1MouseClicked
        int row = myTable1.getSelectedRow();
        int col = 1;//get the value in the index 1
        String selectedUsername = (String) myTable1.getValueAt(row, col);
        seletedUser = new UserData().findUser(data.getData(), selectedUsername);

        checkUser(data.getData());

        if (row != -1) {
            txtusername.setText(selectedUsername);
            txtfirstname.setText(user.getFirstName());
            txtlastname.setText(user.getLastName());
            datePicker2.setText(user.getBOD());
            cbgender.setSelectedItem(user.getGender());
            profile = user.getProfile();
            new FitImage().risizelabel(profile, lblpictureHolder);
            componentVisibleEnable(false, true);
            this.btnOverWritePassword.setVisible(true);
        }
    }//GEN-LAST:event_myTable1MouseClicked

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        String pass = new String(txtpassword.getPassword()).trim(); 
        String username = txtusername.getText();
        String lastname = txtlastname.getText();
        String firstname = txtfirstname.getText();
        String bod = datePicker2.getComponentDateTextField().getText();
        String gender = cbgender.getSelectedItem().toString();

        if (seletedUser == null) {
            JOptionPane.showMessageDialog(null, "NO DATA HAS FOUND TO UPDATE", "UPDATE NO DATA", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (!seletedUser.getUsername().equals(username) && user.isUsernameDuplication(data.getData(), username)) {
            JOptionPane.showMessageDialog(null, "THE USERNAME YOU INPUT IS ALREADY EXCIST PLEASE ENTER AGAIN", "USERNAME DUPLICATION", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (!checkIfItValid(username, pass, firstname, lastname, bod, gender)) {
            return;  
        }
        int choose = JOptionPane.showConfirmDialog(null, "ARE YOU SURE YOU WANT TO UPDATE THE DATA USERNAME:" + seletedUser.getUsername(),
                "UPDATE DATA?", JOptionPane.YES_NO_OPTION);

        if (choose == JOptionPane.YES_OPTION) {
            new UserData().updatePersonData(seletedUser, firstname, lastname, gender, bod);
            new UserData().updateProfile(seletedUser, profile);
            if (!seletedUser.getUsername().equals(username)) {
                new UserData().updateUsername(seletedUser,username);
            }
   resetInputData();
            JOptionPane.showMessageDialog(null, "Successfully update the Account", "SUCCESSFULLY UPDATED", JOptionPane.INFORMATION_MESSAGE);
            new UserData().addDataAccountTable(data.getData(), myTable1);
            this.componentVisibleEnable(true, false);
        }
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        int choose = JOptionPane.showConfirmDialog(null, "ARE YOU SURE YOU WANT TO DELETE THIS DATA", "DELETE DATA ?", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (choose == JOptionPane.YES_OPTION) {
            data.deleteUser(user);
            new UserData().deleteData(seletedUser);
            JOptionPane.showMessageDialog(null, "Successfully deleted the Account", "SUCCESSFULLY DELETED ACCOUNT", JOptionPane.INFORMATION_MESSAGE);
            resetInputData();
            new UserData().addDataAccountTable(data.getData(), myTable1);
            componentVisibleEnable(true, false);
            checkDeletedUsers();
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void cbgenderItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbgenderItemStateChanged
        if (!cbgender.equals("Gender")) {
            cbgender.removeItem("Gender");
        }
        if (profile == null) {
            profile = new file().FileCheckGender(profile, cbgender, lblpictureHolder);
        }
    }//GEN-LAST:event_cbgenderItemStateChanged

    private void btnshowdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnshowdataActionPerformed
        if (seletedUser != null) {
            new ShowedData(null, true, seletedUser).setVisible(true);
        }
    }//GEN-LAST:event_btnshowdataActionPerformed

    private void txtpasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpasswordFocusGained
        chckpass.HoverAndClickPassword(txtpassword, chckseeUnsee, "Password");
    }//GEN-LAST:event_txtpasswordFocusGained

    private void txtpasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpasswordFocusLost
        chckpass.FocusLostPass(txtpassword, "Password");
    }//GEN-LAST:event_txtpasswordFocusLost

    private void txtpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordActionPerformed
    }//GEN-LAST:event_txtpasswordActionPerformed

    private void txtpasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordKeyPressed
        chckpass.HoverAndClickPassword(txtpassword, chckseeUnsee, "Password");
    }//GEN-LAST:event_txtpasswordKeyPressed

    private void txtpasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordKeyReleased
        chckpass.HoverAndClickPassword(txtpassword, chckseeUnsee, "Password");
    }//GEN-LAST:event_txtpasswordKeyReleased

    private void btnbanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbanActionPerformed
        new banAccount(null, true,seletedUser).setVisible(true);
    }//GEN-LAST:event_btnbanActionPerformed

    private void txtsearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtsearchFocusGained
        txt.checkTextField(txtsearch, "Search");
    }//GEN-LAST:event_txtsearchFocusGained

    private void txtsearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtsearchFocusLost
        txt.checkTextFieldEmpty(txtsearch, "Search");
    }//GEN-LAST:event_txtsearchFocusLost

    private void txtsearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtsearchMouseClicked
        txt.checkTextField(txtsearch, "Search");
    }//GEN-LAST:event_txtsearchMouseClicked

    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed
        new UserData().filterAccount(data.getData(), myTable1, txtsearch.getText());
    }//GEN-LAST:event_txtsearchActionPerformed

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        componentVisibleEnable(true, false);
        resetInputData();
    }//GEN-LAST:event_btncancelActionPerformed

    private void btndeleteAccountRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteAccountRecordsActionPerformed
        DeletedData deletedData = DeletedData.getInstants();
        deletedData.setVisible(true);

    }//GEN-LAST:event_btndeleteAccountRecordsActionPerformed

    private void btnOverWritePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOverWritePasswordActionPerformed
        int choose = JOptionPane.showConfirmDialog(null, "ARE YOU REALLY SURE YOU WANT TO OVERWRITE THE USER PASSWORD (WARNING IT MAY CAUSE TROUBLE TO THE USER)", "OVERWRITE PASSWORD", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);

        if (choose == JOptionPane.YES_OPTION) {
            new LoginConformation(null, true, seletedUser, "OverWritePassword").setVisible(true);
        }
    }//GEN-LAST:event_btnOverWritePasswordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private UserInterface.CustomComponents.MyButton btnOverWritePassword;
    private UserInterface.CustomComponents.MyButton btnadd;
    private UserInterface.CustomComponents.MyButton btnban;
    private UserInterface.CustomComponents.MyButton btncancel;
    private UserInterface.CustomComponents.MyButton btndelete;
    private UserInterface.CustomComponents.MyButton btndeleteAccountRecords;
    private UserInterface.CustomComponents.MyButton btnshowdata;
    private UserInterface.CustomComponents.MyButton btnupdate;
    private javax.swing.JComboBox<String> cbgender;
    private javax.swing.JCheckBox chckseeUnsee;
    private com.github.lgooddatepicker.components.DatePicker datePicker2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblpictureHolder;
    private UserInterface.CustomComponents.MyButton myButton1;
    private UserInterface.CustomComponents.MyTable myTable1;
    private UserInterface.CustomComponents.MyTextField txtfirstname;
    private UserInterface.CustomComponents.MyTextField txtlastname;
    private UserInterface.CustomComponents.MyPasswordField txtpassword;
    private UserInterface.CustomComponents.MyTextField txtsearch;
    private UserInterface.CustomComponents.MyTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
