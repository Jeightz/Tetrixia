/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package UserInterface.Login;

import Function.CheckDate.CheckDate;
import Function.Image.FitImage;
import Function.SeeAndUnseePass.SeeAndUnseePass;
import Function.file.file;
import Function.password.checkPasswordField;
import Function.textField.txtField;
import Model.DataManager.DataManager;
import Model.UserData.UserData;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class SignIn extends javax.swing.JDialog {

    DataManager dataManager = DataManager.getInstance();
    private File profile = null;
    private static final txtField txtfield = new txtField();
    private static final checkPasswordField chckpass = new checkPasswordField();
    private static final SeeAndUnseePass chckbox = new SeeAndUnseePass();
    private UserData user = new UserData();

    private void login() {

        String pass = String.valueOf(txtpassword.getPassword());
        if (pass.equals("Password") || txtusername.getText().equals("Username")) {
            JOptionPane.showMessageDialog(this, "Invalid Username and PAssword ", "NO Data Found", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        UserData loggedInUser = user.userLogin(txtusername.getText(), pass);

        if (loggedInUser != null) {
            this.dispose();
        }
    }

    private void defaultAdminAccount() {
        ArrayList<UserData> data = dataManager.getData();

        if (!user.isUsernameDuplication(data, "admin")) {
            File pictureprof = new File(System.getProperty("user.dir") + "\\src\\image\\boyprofile.jpg");
            user = new UserData(data, "admin", "admin", "System", "Administrator", "Other", pictureprof, "January 1, 2000");
            user.setUserType("Admin");
            dataManager.addUser(user);
        }

    }

    private void SignUp() {
        ArrayList<UserData> data = dataManager.getData();

        String password = String.valueOf(txtpasswordSignup1.getPassword()).trim();
        String confirmPassword = String.valueOf(txtconfirmpasswordSignup.getPassword()).trim();
        String username = txtusernameSignUp.getText().trim();
        String lastName = txtlastname.getText().trim();
        String firstName = txtfirstname.getText().trim();
        String gender = cbgender.getSelectedItem().toString();
        String birthDate = datePicker2.getText().trim();
        if (!isValidSignUpInput(username, firstName, lastName, gender, birthDate, password, confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Invalid SignUp! Please fill in all fields correctly.", "Invalid SignUp", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (user.isUsernameDuplication(dataManager.getDeletedAccounts(), username)) {
            JOptionPane.showMessageDialog(null, "THE USERNAME YOU INPUT IS ALREADY EXCIST PLEASE ENTER AGAIN", "USERNAME DUPLICATION", JOptionPane.INFORMATION_MESSAGE);
            return;

        }

        if (user.isUsernameDuplication(dataManager.getData(), username)) {
            JOptionPane.showMessageDialog(null, "THE USERNAME YOU INPUT IS ALREADY EXCIST PLEASE ENTER AGAIN", "USERNAME DUPLICATION", JOptionPane.INFORMATION_MESSAGE);
            return;

        }

        if (!chckpass.isConfirmPassAndPassSame(password, confirmPassword)) {
            JOptionPane.showMessageDialog(null, "THE PASSWORD YOU INPUP IS NOT MATCH TO CONFIRM PASSWORD", "PASSWORD NOT MATCH", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (password.length() < 5) {
            JOptionPane.showMessageDialog(this, "Invalid SignUp! Please make the password 5 letter up.", "Invalid SignUp", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (!new CheckDate().isAtLeast10YearsOld(datePicker2.getText())) {
            JOptionPane.showMessageDialog(null, "The BOD is not applicable cause it is lower than 10 years old age or too high than 100", "NOT APPLICABLE BOD", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        dataManager.addUser(new UserData(data, username, password, firstName, lastName, gender, profile, birthDate));

        JOptionPane.showMessageDialog(this, "User Successfully Registered", "Register", JOptionPane.INFORMATION_MESSAGE);

        resetSignUpForm();
    }

    private boolean isValidSignUpInput(String username, String firstName, String lastName, String gender, String birthDate, String password, String confirmPassword) {
        return !(gender.equals("Gender") || firstName.isEmpty() || lastName.isEmpty() || username.isEmpty()
                || password.isEmpty() || confirmPassword.isEmpty() || birthDate.isEmpty()
                || firstName.equalsIgnoreCase("FirstName") || lastName.equalsIgnoreCase("LastName")
                || username.equalsIgnoreCase("Username") || password.equalsIgnoreCase("Password")
                || confirmPassword.equalsIgnoreCase("Confirm Password"));
    }

    private void resetSignUpForm() {
        txtusernameSignUp.setText("Username");
        txtpasswordSignup1.setText("Password");
        txtconfirmpasswordSignup.setText("Confirm Password");
        txtlastname.setText("LastName");
        this.lblPictureHolder.setIcon(null);

        txtfirstname.setText("FirstName");
        chckseeUnseeConfirmPassSignup.setVisible(false);
        chckseeUnseeSignup1.setVisible(false);
        datePicker2.setText("");
        txtpasswordSignup1.setEchoChar((char) 0);
        txtconfirmpasswordSignup.setEchoChar((char) 0);
        profile = null;

    }

    public SignIn(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        defaultAdminAccount();
        txtpassword.setEchoChar((char) 0);
        chckseeUnsee.setVisible(false);
        txtpasswordSignup1.setEchoChar((char) 0);
        txtconfirmpasswordSignup.setEchoChar((char) 0);
        chckseeUnseeConfirmPassSignup.setVisible(false);
        chckseeUnseeSignup1.setVisible(false);
        datePicker2.getComponentDateTextField().setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tabLogInOut = new javax.swing.JTabbedPane();
        signIn = new UserInterface.CustomComponents.MyPanel();
        btnsignIn = new UserInterface.CustomComponents.MyButton();
        chckseeUnsee = new javax.swing.JCheckBox();
        txtpassword = new UserInterface.CustomComponents.MyPasswordField();
        txtusername = new UserInterface.CustomComponents.MyTextField();
        jLabel1 = new javax.swing.JLabel();
        signUp = new UserInterface.CustomComponents.MyPanel();
        txtlastname = new UserInterface.CustomComponents.MyTextField();
        txtfirstname = new UserInterface.CustomComponents.MyTextField();
        chckseeUnseeConfirmPassSignup = new javax.swing.JCheckBox();
        chckseeUnseeSignup1 = new javax.swing.JCheckBox();
        txtusernameSignUp = new UserInterface.CustomComponents.MyTextField();
        txtconfirmpasswordSignup = new UserInterface.CustomComponents.MyPasswordField();
        txtpasswordSignup1 = new UserInterface.CustomComponents.MyPasswordField();
        datePicker2 = new com.github.lgooddatepicker.components.DatePicker();
        btnSignUp = new UserInterface.CustomComponents.MyButton();
        myButton1 = new UserInterface.CustomComponents.MyButton();
        lblPictureHolder = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbgender = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 0));
        jPanel1.setLayout(null);

        signIn.setBackground(new java.awt.Color(0, 153, 0));
        signIn.setBottomLeftRadius(150);
        signIn.setBottomRightRadius(0);
        signIn.setInnerColor(new java.awt.Color(255, 255, 255));
        signIn.setName("SignInPanel"); // NOI18N
        signIn.setTopLeftRadius(150);
        signIn.setTopRightRadius(0);
        signIn.setLayout(null);

        btnsignIn.setText("SignIn");
        btnsignIn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnsignIn.setName("btnSignUp"); // NOI18N
        btnsignIn.setNextFocusableComponent(jLabel1);
        btnsignIn.setRadius(50);
        btnsignIn.setToolTipText("");
        btnsignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsignInActionPerformed(evt);
            }
        });
        signIn.add(btnsignIn);
        btnsignIn.setBounds(70, 352, 235, 46);

        chckseeUnsee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/see.png"))); // NOI18N
        chckseeUnsee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckseeUnseeActionPerformed(evt);
            }
        });
        signIn.add(chckseeUnsee);
        chckseeUnsee.setBounds(260, 270, 24, 20);

        txtpassword.setText("Password");
        txtpassword.setCornerRadius(50);
        txtpassword.setCustomIcon1(new javax.swing.ImageIcon(getClass().getResource("/image/password.png"))); // NOI18N
        txtpassword.setName("txtpassword"); // NOI18N
        txtpassword.setNextFocusableComponent(btnsignIn);
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
        signIn.add(txtpassword);
        txtpassword.setBounds(70, 249, 235, 54);

        txtusername.setText("Username");
        txtusername.setCustomIcon1(new javax.swing.ImageIcon(getClass().getResource("/image/username.png"))); // NOI18N
        txtusername.setName("txtusername"); // NOI18N
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
        signIn.add(txtusername);
        txtusername.setBounds(70, 146, 235, 54);

        jLabel1.setText("Havent Had AccountYet?");
        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 255));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });
        signIn.add(jLabel1);
        jLabel1.setBounds(109, 404, 157, 17);

        tabLogInOut.addTab("tab1", signIn);

        signUp.setBackground(new java.awt.Color(0, 153, 0));
        signUp.setBottomLeftRadius(150);
        signUp.setBottomRightRadius(0);
        signUp.setName("SignUpPanel"); // NOI18N
        signUp.setTopLeftRadius(150);
        signUp.setTopRightRadius(0);
        signUp.setLayout(null);

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
        txtlastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlastnameActionPerformed(evt);
            }
        });
        signUp.add(txtlastname);
        txtlastname.setBounds(180, 310, 140, 50);

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
        txtfirstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfirstnameActionPerformed(evt);
            }
        });
        signUp.add(txtfirstname);
        txtfirstname.setBounds(40, 310, 130, 50);

        chckseeUnseeConfirmPassSignup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/see.png"))); // NOI18N
        chckseeUnseeConfirmPassSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckseeUnseeConfirmPassSignupActionPerformed(evt);
            }
        });
        signUp.add(chckseeUnseeConfirmPassSignup);
        chckseeUnseeConfirmPassSignup.setBounds(290, 270, 24, 20);

        chckseeUnseeSignup1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/see.png"))); // NOI18N
        chckseeUnseeSignup1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckseeUnseeSignup1ActionPerformed(evt);
            }
        });
        signUp.add(chckseeUnseeSignup1);
        chckseeUnseeSignup1.setBounds(290, 210, 24, 20);

        txtusernameSignUp.setText("Username");
        txtusernameSignUp.setCustomIcon1(new javax.swing.ImageIcon(getClass().getResource("/image/username.png"))); // NOI18N
        txtusernameSignUp.setName("txtusername"); // NOI18N
        txtusernameSignUp.setNextFocusableComponent(txtpasswordSignup1);
        txtusernameSignUp.setRadius(50);
        txtusernameSignUp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtusernameSignUpFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtusernameSignUpFocusLost(evt);
            }
        });
        txtusernameSignUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtusernameSignUpMouseClicked(evt);
            }
        });
        txtusernameSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusernameSignUpActionPerformed(evt);
            }
        });
        signUp.add(txtusernameSignUp);
        txtusernameSignUp.setBounds(40, 120, 290, 54);

        txtconfirmpasswordSignup.setText("Confirm Password");
        txtconfirmpasswordSignup.setCornerRadius(50);
        txtconfirmpasswordSignup.setCustomIcon1(new javax.swing.ImageIcon(getClass().getResource("/image/password.png"))); // NOI18N
        txtconfirmpasswordSignup.setName("txtpassword"); // NOI18N
        txtconfirmpasswordSignup.setNextFocusableComponent(txtfirstname);
        txtconfirmpasswordSignup.setToolTipText("");
        txtconfirmpasswordSignup.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtconfirmpasswordSignupFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtconfirmpasswordSignupFocusLost(evt);
            }
        });
        txtconfirmpasswordSignup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtconfirmpasswordSignupMouseClicked(evt);
            }
        });
        txtconfirmpasswordSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtconfirmpasswordSignupActionPerformed(evt);
            }
        });
        txtconfirmpasswordSignup.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtconfirmpasswordSignupKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtconfirmpasswordSignupKeyReleased(evt);
            }
        });
        signUp.add(txtconfirmpasswordSignup);
        txtconfirmpasswordSignup.setBounds(40, 250, 290, 54);

        txtpasswordSignup1.setText("Password");
        txtpasswordSignup1.setCornerRadius(50);
        txtpasswordSignup1.setCustomIcon1(new javax.swing.ImageIcon(getClass().getResource("/image/password.png"))); // NOI18N
        txtpasswordSignup1.setName("txtpassword"); // NOI18N
        txtpasswordSignup1.setNextFocusableComponent(txtconfirmpasswordSignup);
        txtpasswordSignup1.setToolTipText("");
        txtpasswordSignup1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtpasswordSignup1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtpasswordSignup1FocusLost(evt);
            }
        });
        txtpasswordSignup1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtpasswordSignup1MouseClicked(evt);
            }
        });
        txtpasswordSignup1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordSignup1ActionPerformed(evt);
            }
        });
        txtpasswordSignup1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpasswordSignup1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpasswordSignup1KeyReleased(evt);
            }
        });
        signUp.add(txtpasswordSignup1);
        txtpasswordSignup1.setBounds(40, 190, 290, 54);

        datePicker2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        signUp.add(datePicker2);
        datePicker2.setBounds(130, 390, 200, 50);

        btnSignUp.setText("SignUp");
        btnSignUp.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSignUp.setRadius(50);
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });
        signUp.add(btnSignUp);
        btnSignUp.setBounds(110, 460, 200, 50);

        myButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pic.png"))); // NOI18N
        myButton1.setBorderColor(new java.awt.Color(0, 0, 255));
        myButton1.setIconTextGap(0);
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });
        signUp.add(myButton1);
        myButton1.setBounds(200, 70, 42, 42);

        lblPictureHolder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        signUp.add(lblPictureHolder);
        lblPictureHolder.setBounds(140, 20, 100, 90);

        jLabel2.setText("Already Have Account?");
        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 255));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });
        signUp.add(jLabel2);
        jLabel2.setBounds(140, 510, 147, 20);

        cbgender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gender", "Male", "Female" }));
        cbgender.setNextFocusableComponent(datePicker2);
        cbgender.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbgenderItemStateChanged(evt);
            }
        });
        cbgender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbgenderActionPerformed(evt);
            }
        });
        signUp.add(cbgender);
        cbgender.setBounds(40, 390, 80, 50);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("BOD(BIRTH OF DATE):");
        signUp.add(jLabel3);
        jLabel3.setBounds(130, 370, 200, 17);

        tabLogInOut.addTab("tab1", signUp);

        jPanel1.add(tabLogInOut);
        tabLogInOut.setBounds(430, -40, 350, 610);

        jLabel4.setText("Tetrixia");
        jLabel4.setFont(new java.awt.Font("Retro Gaming", 1, 48)); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(70, 40, 350, 70);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsignInActionPerformed
        login();
    }//GEN-LAST:event_btnsignInActionPerformed

    private void chckseeUnseeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckseeUnseeActionPerformed
        chckbox.unseeAndseeIconChange(chckseeUnsee, txtpassword);
    }//GEN-LAST:event_chckseeUnseeActionPerformed

    private void txtpasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpasswordFocusGained
        chckpass.HoverAndClickPassword(txtpassword, chckseeUnsee, "Password");
    }//GEN-LAST:event_txtpasswordFocusGained

    private void txtpasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpasswordFocusLost
        chckpass.FocusLostPass(txtpassword, "Password");
    }//GEN-LAST:event_txtpasswordFocusLost

    private void txtpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordActionPerformed
        login();
    }//GEN-LAST:event_txtpasswordActionPerformed

    private void txtpasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordKeyPressed
        chckpass.HoverAndClickPassword(txtpassword, chckseeUnsee, "Password");
    }//GEN-LAST:event_txtpasswordKeyPressed

    private void txtpasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordKeyReleased
        chckpass.HoverAndClickPassword(txtpassword, chckseeUnsee, "Password");
    }//GEN-LAST:event_txtpasswordKeyReleased

    private void txtusernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtusernameFocusGained
        txtfield.checkTextField(txtusername, "Username");
    }//GEN-LAST:event_txtusernameFocusGained

    private void txtusernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtusernameFocusLost
        txtfield.checkTextFieldEmpty(txtusername, "Username");
    }//GEN-LAST:event_txtusernameFocusLost

    private void txtusernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtusernameMouseClicked
        txtfield.checkTextField(txtusername, "Username");
    }//GEN-LAST:event_txtusernameMouseClicked

    private void txtusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusernameActionPerformed
        login();
    }//GEN-LAST:event_txtusernameActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        tabLogInOut.setSelectedIndex(1);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        jLabel1.setForeground(new Color(0, 153, 255));
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        jLabel2.setForeground(new Color(51, 0, 255));
    }//GEN-LAST:event_jLabel1MouseExited

    private void cbgenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbgenderActionPerformed

    }//GEN-LAST:event_cbgenderActionPerformed

    private void cbgenderItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbgenderItemStateChanged
        if (!cbgender.equals("Gender")) {
            cbgender.removeItem("Gender");
        }

        if (profile == null) {
            profile = new file().FileCheckGender(profile, cbgender, lblPictureHolder);
            return;
        }

    }//GEN-LAST:event_cbgenderItemStateChanged

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        jLabel2.setForeground(new Color(0, 51, 255));
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        jLabel2.setForeground(new Color(0, 153, 255));
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.tabLogInOut.setSelectedIndex(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
        profile = new file().FilePictureFilter(profile);
        if (profile != null) {
            new FitImage().risizelabel(profile, lblPictureHolder);
        }
    }//GEN-LAST:event_myButton1ActionPerformed

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        SignUp();
    }//GEN-LAST:event_btnSignUpActionPerformed

    private void txtpasswordSignup1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordSignup1KeyReleased
        chckpass.HoverAndClickPassword(txtpasswordSignup1, chckseeUnseeSignup1, "Password");
    }//GEN-LAST:event_txtpasswordSignup1KeyReleased

    private void txtpasswordSignup1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordSignup1KeyPressed
        chckpass.HoverAndClickPassword(txtpasswordSignup1, chckseeUnseeSignup1, "Password");
    }//GEN-LAST:event_txtpasswordSignup1KeyPressed

    private void txtpasswordSignup1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordSignup1ActionPerformed
        SignUp();
    }//GEN-LAST:event_txtpasswordSignup1ActionPerformed

    private void txtpasswordSignup1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtpasswordSignup1MouseClicked
        chckpass.HoverAndClickPassword(txtpasswordSignup1, chckseeUnseeSignup1, "Password");
    }//GEN-LAST:event_txtpasswordSignup1MouseClicked

    private void txtpasswordSignup1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpasswordSignup1FocusLost
        chckpass.FocusLostPass(txtpasswordSignup1, "Password");
    }//GEN-LAST:event_txtpasswordSignup1FocusLost

    private void txtpasswordSignup1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpasswordSignup1FocusGained
        chckpass.HoverAndClickPassword(txtpasswordSignup1, chckseeUnseeSignup1, "Password");
    }//GEN-LAST:event_txtpasswordSignup1FocusGained

    private void txtconfirmpasswordSignupKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtconfirmpasswordSignupKeyReleased
        chckpass.HoverAndClickPassword(txtconfirmpasswordSignup, this.chckseeUnseeConfirmPassSignup, "Confirm Password");
    }//GEN-LAST:event_txtconfirmpasswordSignupKeyReleased

    private void txtconfirmpasswordSignupKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtconfirmpasswordSignupKeyPressed
        chckpass.HoverAndClickPassword(txtconfirmpasswordSignup, this.chckseeUnseeConfirmPassSignup, "Confirm Password");
    }//GEN-LAST:event_txtconfirmpasswordSignupKeyPressed

    private void txtconfirmpasswordSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtconfirmpasswordSignupActionPerformed
        SignUp();
    }//GEN-LAST:event_txtconfirmpasswordSignupActionPerformed

    private void txtconfirmpasswordSignupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtconfirmpasswordSignupMouseClicked
        chckpass.HoverAndClickPassword(txtconfirmpasswordSignup, chckseeUnseeConfirmPassSignup, "Confirm Password");
    }//GEN-LAST:event_txtconfirmpasswordSignupMouseClicked

    private void txtconfirmpasswordSignupFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtconfirmpasswordSignupFocusLost
        chckpass.FocusLostPass(txtconfirmpasswordSignup, "Confirm Password");
    }//GEN-LAST:event_txtconfirmpasswordSignupFocusLost

    private void txtconfirmpasswordSignupFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtconfirmpasswordSignupFocusGained
        chckpass.HoverAndClickPassword(txtconfirmpasswordSignup, chckseeUnseeConfirmPassSignup, "Confirm Password");
    }//GEN-LAST:event_txtconfirmpasswordSignupFocusGained

    private void chckseeUnseeSignup1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckseeUnseeSignup1ActionPerformed
        chckbox.unseeAndseeIconChange(chckseeUnseeSignup1, txtpasswordSignup1);
    }//GEN-LAST:event_chckseeUnseeSignup1ActionPerformed

    private void chckseeUnseeConfirmPassSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckseeUnseeConfirmPassSignupActionPerformed
        chckbox.unseeAndseeIconChange(chckseeUnseeConfirmPassSignup, txtconfirmpasswordSignup);
    }//GEN-LAST:event_chckseeUnseeConfirmPassSignupActionPerformed

    private void txtfirstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfirstnameActionPerformed
        SignUp();
    }//GEN-LAST:event_txtfirstnameActionPerformed

    private void txtfirstnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtfirstnameMouseClicked
        txtfield.checkTextField(txtfirstname, "FirstName");
    }//GEN-LAST:event_txtfirstnameMouseClicked

    private void txtfirstnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfirstnameFocusLost
        txtfield.checkTextFieldEmpty(txtfirstname, "FirstName");
    }//GEN-LAST:event_txtfirstnameFocusLost

    private void txtfirstnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfirstnameFocusGained
        txtfield.checkTextField(txtfirstname, "FirstName");
    }//GEN-LAST:event_txtfirstnameFocusGained

    private void txtlastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlastnameActionPerformed
        SignUp();
    }//GEN-LAST:event_txtlastnameActionPerformed

    private void txtlastnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtlastnameMouseClicked
        txtfield.checkTextField(txtlastname, "LastName");
    }//GEN-LAST:event_txtlastnameMouseClicked

    private void txtlastnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtlastnameFocusLost
        txtfield.checkTextFieldEmpty(txtlastname, "LastName");
    }//GEN-LAST:event_txtlastnameFocusLost

    private void txtlastnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtlastnameFocusGained
        txtfield.checkTextField(txtlastname, "LastName");
    }//GEN-LAST:event_txtlastnameFocusGained

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        System.exit(0);//stop the jvm
    }//GEN-LAST:event_formWindowClosing

    private void txtusernameSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusernameSignUpActionPerformed
        SignUp();
    }//GEN-LAST:event_txtusernameSignUpActionPerformed

    private void txtusernameSignUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtusernameSignUpMouseClicked
        txtfield.checkTextField(txtusernameSignUp, "Username");
    }//GEN-LAST:event_txtusernameSignUpMouseClicked

    private void txtusernameSignUpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtusernameSignUpFocusLost
        txtfield.checkTextFieldEmpty(txtusernameSignUp, "Username");
    }//GEN-LAST:event_txtusernameSignUpFocusLost

    private void txtusernameSignUpFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtusernameSignUpFocusGained
        txtfield.checkTextField(txtusernameSignUp, "Username");
    }//GEN-LAST:event_txtusernameSignUpFocusGained

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
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SignIn dialog = new SignIn(new javax.swing.JFrame(), true);
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
    private UserInterface.CustomComponents.MyButton btnSignUp;
    private UserInterface.CustomComponents.MyButton btnsignIn;
    private javax.swing.JComboBox<String> cbgender;
    private javax.swing.JCheckBox chckseeUnsee;
    private javax.swing.JCheckBox chckseeUnseeConfirmPassSignup;
    private javax.swing.JCheckBox chckseeUnseeSignup1;
    private com.github.lgooddatepicker.components.DatePicker datePicker2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblPictureHolder;
    private UserInterface.CustomComponents.MyButton myButton1;
    private UserInterface.CustomComponents.MyPanel signIn;
    private UserInterface.CustomComponents.MyPanel signUp;
    private javax.swing.JTabbedPane tabLogInOut;
    private UserInterface.CustomComponents.MyPasswordField txtconfirmpasswordSignup;
    private UserInterface.CustomComponents.MyTextField txtfirstname;
    private UserInterface.CustomComponents.MyTextField txtlastname;
    private UserInterface.CustomComponents.MyPasswordField txtpassword;
    private UserInterface.CustomComponents.MyPasswordField txtpasswordSignup1;
    private UserInterface.CustomComponents.MyTextField txtusername;
    private UserInterface.CustomComponents.MyTextField txtusernameSignUp;
    // End of variables declaration//GEN-END:variables
}
