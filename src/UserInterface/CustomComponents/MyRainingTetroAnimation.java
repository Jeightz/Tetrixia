package UserInterface.CustomComponents;

import UserInterface.game.tetromino;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyRainingTetroAnimation extends JPanel {

    private tetromino currentTetro;
    private int posX;
    private int posY;
    private final Random random = new Random();
    private final Timer timer;
    private final int cellSize = 30; // Block size of each Tetromino cell
    private int panelWidth = 300;
    private int panelHeight = 600;

    // Grid properties
    private final int gridWidth = panelWidth / cellSize;
    private final int gridHeight = panelHeight / cellSize;

    public MyRainingTetroAnimation(JFrame frame) {
        panelHeight = frame.getHeight();
        setSize(panelWidth, panelHeight);
        setBackground(Color.BLACK);

        spawnTetromino();

        timer = new Timer(10, e -> updateTetro());
        timer.start();
    }

    public MyRainingTetroAnimation() {
        setSize(panelWidth, panelHeight);
        setBackground(Color.BLACK);

        spawnTetromino();

        timer = new Timer(10, e -> updateTetro());
        timer.start();
    }

    // Spawn a new Tetromino at a random X position
    private void spawnTetromino() {
        int randomPiece = random.nextInt(7);
        posX = random.nextInt(gridWidth - 4);
        posY = 0;

        currentTetro = new tetromino(null, randomPiece);
        currentTetro.setCurrentPiece(randomPiece);
    }

    private void updateTetro() {
        posY++;
        if ((posY + getPieceHeight()) * cellSize >= panelHeight) {
            spawnTetromino();
        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        drawGrid(g2d);

        drawTetromino(g2d);
    }

    private void drawGrid(Graphics2D g2d) {
        g2d.setColor(new Color(211, 211, 211));
        g2d.setStroke(new java.awt.BasicStroke(0.5f));

        for (int row = 0; row < gridHeight; row++) {
            for (int col = 0; col < gridWidth; col++) {
                int drawX = col * cellSize;
                int drawY = row * cellSize;

                // Draw the grid cell
                g2d.setColor(new Color(128, 128, 128)); // Gray for empty cells
                g2d.fillRect(drawX, drawY, cellSize, cellSize);
                g2d.setColor(new Color(211, 211, 211)); // Light gray grid lines
                g2d.drawRect(drawX, drawY, cellSize, cellSize); // Draw the cell border
            }
        }
    }

    // Method to draw the current Tetromino
    private void drawTetromino(Graphics2D g2d) {
        int[][] piece = currentTetro.getCurrentTetrominoShape(); // Get the current Tetromino shape

        for (int row = 0; row < piece.length; row++) {
            for (int col = 0; col < piece[row].length; col++) {
                if (piece[row][col] != 0) { // Check if there's a block to draw
                    int drawX = (posX + col) * cellSize;
                    int drawY = (posY + row) * cellSize;
                    // Draw the block
                    g2d.setColor(currentTetro.tetroColors[currentTetro.getCurrentPiece()]);
                    g2d.fillRect(drawX, drawY, cellSize, cellSize);

                    // Draw the block's border
                    g2d.setColor(Color.BLACK);
                    g2d.drawRect(drawX, drawY, cellSize, cellSize);
                }
            }
        }
    }

    private int getPieceHeight() {
        int[][] piece = currentTetro.getCurrentTetrominoShape();
        return piece.length;
    }
}
