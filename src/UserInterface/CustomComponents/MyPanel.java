package UserInterface.CustomComponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyPanel extends JPanel {

    private BufferedImage img;
    private int mouseX, mouseY;

    // Individual corner radii
    private int topLeftRadius = 20;
    private int topRightRadius = 20;
    private int bottomLeftRadius = 20;
    private int bottomRightRadius = 20;

    private Color innerColor = Color.WHITE;
    private Color borderColor = Color.BLACK;

    public MyPanel() {
        setPreferredSize(new Dimension(300, 200));
    }

    public MyPanel(JFrame com) {
        com.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                mouseX = e.getXOnScreen();
                mouseY = e.getYOnScreen();
            }
        });
        com.addMouseMotionListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseDragged(java.awt.event.MouseEvent e) {
                int frameX = com.getLocation().x + e.getXOnScreen() - mouseX;
                int frameY = com.getLocation().y + e.getYOnScreen() - mouseY;
                com.setLocation(frameX, frameY);
                mouseX = e.getXOnScreen();
                mouseY = e.getYOnScreen();
            }
        });
    }

    public MyPanel(String imagename1) {
        try {
            img = ImageIO.read(new File(System.getProperty("user.dir") + "\\src\\image\\" + imagename1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Setters for each corner's radius
    public void setTopLeftRadius(int radius) {
        this.topLeftRadius = radius;
        repaint();
    }

    public void setTopRightRadius(int radius) {
        this.topRightRadius = radius;
        repaint();
    }

    public void setBottomLeftRadius(int radius) {
        this.bottomLeftRadius = radius;
        repaint();
    }

    public void setBottomRightRadius(int radius) {
        this.bottomRightRadius = radius;
        repaint();
    }

    // Setters for inner and border colors
    public void setInnerColor(Color color) {
        this.innerColor = color;
        repaint();
    }

    public void setBorderColor(Color color) {
        this.borderColor = color;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw inner panel with rounded corners
        g2.setColor(innerColor);
        g2.fill(createRoundedShape());

        // Draw the image, respecting rounded corners
        if (img != null) {
            g2.setClip(createRoundedShape());
            g2.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        }

        // Draw the border
        g2.setClip(null);
        g2.setColor(borderColor);
        g2.setStroke(new java.awt.BasicStroke(2));
        g2.draw(createRoundedShape());
    }

    // Create a custom rounded shape with separate corner radii
    private Path2D.Float createRoundedShape() {
        Path2D.Float path = new Path2D.Float();

        float width = getWidth();
        float height = getHeight();

        // Start at the top-left corner
        path.moveTo(0, topLeftRadius);
        path.quadTo(0, 0, topLeftRadius, 0); // Top-left corner
        
        path.lineTo(width - topRightRadius, 0);
        path.quadTo(width, 0, width, topRightRadius); // Top-right corner
        
        // Right edge
        path.lineTo(width, height - bottomRightRadius);
        path.quadTo(width, height, width - bottomRightRadius, height); // Bottom-right corner

        // Bottom edge
        path.lineTo(bottomLeftRadius, height);
        path.quadTo(0, height, 0, height - bottomLeftRadius); // Bottom-left corner

        // Left edge
        path.closePath();

        return path;
    }
}
