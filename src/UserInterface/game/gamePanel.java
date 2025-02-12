/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserInterface.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class gamePanel extends JPanel implements Runnable {

    Thread gameThread;
    long lastTime = System.nanoTime();
    long currentTime;
    double delta = 0;
    int fps = 60;
    long drawInterval = 1000000000 / fps;
    private grid grd = new grid();
    private  mino mn = new mino(grd); ;
    float offSetY = 0;
    float offSetX = 0;
    float panelWidth;
    float panelHeight;
    private long lastDropTime = System.nanoTime();
    private final long dropInterval = 1000000000;
    private float scale = 1.0f;

    public gamePanel() {
        setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);

    }

    public void updateScale() {
        panelWidth = getWidth();
        panelHeight = getHeight();

        if (panelWidth == 0 || panelHeight == 0) {
            return;
        }

        float scaleX = panelWidth / (grid.getGrid_Width() * grd.getCellSize());
        float scaleY = panelHeight / (grid.getGrid_Height() * grd.getCellSize());

        scale = Math.min(scaleX, scaleY);

    }

    public void launchGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run() {
        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / (double) drawInterval;
            lastTime = currentTime;

            while (delta >= 1) {
                update();
                repaint(); 

           
                delta--;
            }
                    try {
                Thread.sleep(1000/fps); // Small sleep to prevent CPU overuse
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    
        }
    }

    public void update() {
        currentTime = System.nanoTime();
        if (currentTime - lastDropTime >= dropInterval) {
            mn.updateGhostPos();
            mn.update();
            lastDropTime = currentTime;
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        updateScale();
        AffineTransform originalTransform = g2d.getTransform();
        g2d.scale(scale, scale);
        g2d.translate(offSetX, offSetY);

        grd.draw(g2d);
        mn.drawPiece(g2d);
        mn.drawGhostTetro(g2d);
        grd.drawLockTetro(g2d);
        g2d.setTransform(originalTransform);
        g2d.dispose();
    }
}
