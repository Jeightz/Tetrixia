package UserInterface.CustomComponents;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class MyPasswordField extends JPasswordField {

    private boolean validation;
    private Icon CustomIcon1;
    private Icon CustomIcon2;
    private int cornerRadius = 10; // Default corner radius
    
 
    
    public MyPasswordField() {
        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setBackground(new Color(0, 0, 0, 0));
        
        setForeground(new Color(122, 140, 141));
        setFont(new java.awt.Font("Arial", 0, 13));
        setSelectionColor(new Color(0, 102, 204));
    }
    
   
    public boolean isValidation() {
        return validation;
    }

    public void setValidation(boolean validation) {
        this.validation = validation;
    }

    public Icon getCustomIcon1() {
        return CustomIcon1;
    }

    public void setCustomIcon1(Icon CustomIcon1) {
        this.CustomIcon1 = CustomIcon1;
        initBorder();
    }

    public Icon getCustomIcon2() {
        return CustomIcon2;
    }

    public void setCustomIcon2(Icon CustomIcon2) {
        this.CustomIcon2 = CustomIcon2;
        initBorder();
    }

    public int getCornerRadius() {
        return cornerRadius;
    }

    public void setCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        repaint(); // Trigger repaint to apply the updated radius
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(230, 245, 241)); // Background color
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
        super.paintComponent(g);
        paintIcon(g); // Draw icons
    }

    private void paintIcon(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (getCustomIcon1() != null) {
            Image Icon1 = ((ImageIcon) getCustomIcon1()).getImage();
            int height = (getHeight() - getCustomIcon1().getIconHeight()) / 2;
            g2.drawImage(Icon1, 0, height, this);
        }
        if (getCustomIcon2() != null) {
            Image icon2 = ((ImageIcon) getCustomIcon2()).getImage();
            int height = (getHeight() - getCustomIcon2().getIconHeight()) / 2;
            g2.drawImage(icon2, getWidth() - getCustomIcon2().getIconWidth(), height, this);
        }
    }

    private void initBorder() {
        int left = 5;
        int right = 5;

        if (getCustomIcon1() != null) {
            left = getCustomIcon1().getIconWidth();
        }
        if (getCustomIcon2() != null) {
            right = getCustomIcon2().getIconWidth();
        }

        setBorder(javax.swing.BorderFactory.createEmptyBorder(5, left, 5, right));
    }
}
