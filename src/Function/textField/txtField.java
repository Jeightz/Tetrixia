/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Function.textField;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class txtField {
    
    
 public void checkTextFieldEmpty(JTextField txt,String text){
       if(txt.getText().isEmpty()){
           txt.setText(text);
       }
   }
    
    public  void checkTextField(JTextField txt,String text){

        if(!txt.getText().equals(text)){
           return;
        }
        txt.setText("");

    }
    
    
    public void getTheKeyText(JTextField txtField){

        txtField.setEditable(false);
        txtField.addKeyListener(new KeyListener(){
         public void keyPressed(KeyEvent e) {
               txtField.setText(KeyEvent.getKeyText(e.getKeyCode()));
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        
        });
    }
    
    
    public boolean checkBothTextFieldEquals(JTextField field1,JTextField field2){
        return field1.equals(field2);
    }
    
    
    
}
