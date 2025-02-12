/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Clic nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Function.SeeAndUnseePass;

import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

public class SeeAndUnseePass {
    
    
 public void unseeAndseeIconChange(JCheckBox box,JPasswordField pass){
          if(box.isSelected()){
                pass.setEchoChar((char)0);
                box.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/unsee.png")));
                return;
                }
        pass.setEchoChar('\u263A');
        box.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/see.png")));
    }

}
