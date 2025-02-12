/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserInterface.CustomComponents;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import javax.swing.JTextField;
/**
 *
 * @author Admin
 */
public class MyTextField extends JTextField{

  
    
    //focus gained event for textfield
    public void focuseGained(JTextField text,String name){
        if(text.getText().equalsIgnoreCase(name)){
            text.setText(null);
        }
            
    }
    
    //focus lost event for textfield
    public void focusLost(JTextField text ,String name){
        if(text.getText().isEmpty()){
            text.setText(name);
        }
    }
    
 
    
    
    public Color getBorderColor() {
        return BorderColor;
    }
    
   

    /**
     * @param BorderColor the BorderColor to set
     */
    public void setBorderColor(Color BorderColor) {
        this.BorderColor = BorderColor;
    }

    /**
     * @return the radius
     */
    public int getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    /**
     * @return the CustomIcon1
     */
    public Icon getCustomIcon1() {
        return CustomIcon1;
    }

    /**
     * @param CustomIcon1 the CustomIcon1 to set
     */
    public void setCustomIcon1(Icon CustomIcon1) {
        this.CustomIcon1 = CustomIcon1;
        initBorder();
    }

    /**
     * @return the CustomIcon2
     */
    public Icon getCustomIcon2() {
        return CustomIcon2;
    }

    /**
     * @param CustomIcon2 the CustomIcon2 to set
     */
    public void setCustomIcon2(Icon CustomIcon2) {
        this.CustomIcon2 = CustomIcon2;
        initBorder ();
    }

    private Icon CustomIcon1;
    private Icon CustomIcon2;
   private int radius ;

   private Color BorderColor;
    
   
   //custom gui for TextField
    public MyTextField() {
      
        setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setBackground(new Color(0,0,0,0));
        setForeground(new Color(122, 140, 141));
        setFont(new java.awt.Font("Arial", 0, 13));
        setSelectionColor(new Color(0,102,204));
        
        
     
    }



    /**
     *
     * @param g
     */
    
    //renders of the custom gui for textfield
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(230, 245, 241)); // Background color
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);;
        super.paintComponent(g);
        paintIcon(g);
    }
    
    //custom icon image placement
    private void paintIcon(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        if (getCustomIcon1() != null){
            Image Icon1=((ImageIcon) getCustomIcon1()).getImage();
            int hieght =(getHeight() - getCustomIcon1().getIconHeight()) / 2;
            g2.drawImage(Icon1,0,hieght, this);
            
        } 
        if(getCustomIcon2() != null){
            Image icon2=((ImageIcon) getCustomIcon2()).getImage();
            int hieght =(getHeight() - getCustomIcon2().getIconHeight()) / 2 ;
            g2.drawImage(icon2,getWidth() - getCustomIcon2().getIconWidth(), hieght, this);
            
            
        }
    
}   
    
  //code for the icons so that dont overlap with the text
    private void initBorder(){
        int left = 5;
        int right = 5;
        
        if(getCustomIcon1() != null){
            left = getCustomIcon1().getIconWidth();
        }
        if(getCustomIcon2() != null){
            right = getCustomIcon2().getIconWidth();
            
        }
        
        setBorder(javax.swing.BorderFactory.createEmptyBorder(5,left,5,right));
    }


}
