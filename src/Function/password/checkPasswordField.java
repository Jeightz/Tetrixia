/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Function.password;

import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

/**
 *
 * @author Admin
 */
public class checkPasswordField {

    public void FocusLostPass(JPasswordField pass, String txt) {
        if (pass.getPassword().length == 0) {
            pass.setText(txt);
        }
    }

    public void HoverAndClickPassword(JPasswordField txtpass, JCheckBox chck, String txt) {
        if (txtpass.getPassword().length != 0 && !new String(txtpass.getPassword()).equals(txt)) {
            chck.setVisible(true);
            txtpass.setEchoChar('\u263A');
            return;
        }

        txtpass.setText("");
        txtpass.setEchoChar((char) 0);
        chck.setVisible(false);
    }

    public boolean isConfirmPassAndPassSame(String pass, String confirmpass) {
        if (pass.equals(confirmpass)) {
            return true;
        }
        return false;
    }
}
