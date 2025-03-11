/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Function.Image;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Admin
 */
public class FitImage {

    //put an image on the label and fit it in 
    public void risizelabel(File f, JLabel com) {

        try {
            BufferedImage img = ImageIO.read(f.getAbsoluteFile());
            Image img1 = img.getScaledInstance(com.getWidth(), com.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon format = new ImageIcon(img1);
            com.setIcon(format);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void resizeimagelabel(ByteArrayInputStream bais, JLabel com) {
        try {
            BufferedImage img = ImageIO.read(bais);
            Image img1 = img.getScaledInstance(com.getWidth(), com.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon format = new ImageIcon(img1);
            com.setIcon(format);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
