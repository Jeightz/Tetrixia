/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserInterface.game  ;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
public class game {
private static JFrame frame = new JFrame("Tetris");
   
   
    public static void main(String[] args) {
        frame.setSize(640, 640);    
        frame.setMinimumSize(new Dimension(640, 426));
        gamePanel grd = new gamePanel(); 
        frame.add(grd);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                         grd.launchGame();

        frame.setVisible(true);
    }
 
   
}
