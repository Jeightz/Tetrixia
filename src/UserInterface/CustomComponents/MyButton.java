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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class MyButton extends JButton {

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
        initBorder();
    }
 

    public boolean isOver() {
        return over;
    
    }

    public void setOver(boolean over) {
        this.over = over;
        initBorder();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        setBackground(color);
        initBorder();
    }

    public Color getColorOver() {
        return colorOver;
    }

    public void setColorOver(Color colorOver) {
        this.colorOver = colorOver;
        initBorder();
    }

    public Color getColorClick() {
        return colorClick;
    }

    public void setColorClick(Color colorClick) {
        this.colorClick = colorClick;
        initBorder();
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        initBorder();
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
        initBorder();
    }

    public MyButton() {
        //  Init Color
//rgb(0,81,212)
        setColor(new Color(0,81,212));
        colorOver = new Color(8,102,255);
        colorClick = new Color(8, 164, 255);
        borderColor = new Color(0,81,212);
        setContentAreaFilled(false);
        //  Add event mouse
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                setBackground(colorOver);
              borderColor =colorOver;
                over = true;
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setBackground(color);
              borderColor = color;
                over = false;

            }

            @Override
            public void mousePressed(MouseEvent me) {
                borderColor= colorClick;
                setBackground(colorClick);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                if (over) {
                     borderColor = colorOver;
                    setBackground(colorOver);
                   
                } else {
                    borderColor = colorOver;
                    setBackground(colorOver);
                  
                }
            }
        });
    }
 private Icon CustomIcon1;
 private Icon CustomIcon2;
     private boolean over;
  private Color color;
   private Color colorOver;
   private Color colorClick;
   private Color borderColor;
  private  int radius = 0;
    

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //  Paint Border
        g2.setColor(borderColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        g2.setColor(getBackground());
        //  Border set 2 Pix
        g2.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, radius, radius);
        super.paintComponent(grphcs);
        paintIcon(grphcs);
    }
    
     
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