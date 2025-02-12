/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserInterface.game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import javax.swing.JPanel;

public class gameGrid extends JPanel implements Runnable {

    mino tetro = new mino(this);
    private final int grid_Width = 10;
    private final int grid_Height = 20;
    private final int cellSize = 8;
    private final int reSizeWin = 4;
    private final Random random = new Random();
    private boolean gameOver = false;
    private long dropCount = 0; // Tracks the last time the piece dropped
    private final long dropInterval = 60; // 0.5 seconds in nanoseconds
    

    public int getGrid_Width() {
        return grid_Width;
    }

    public int getGrid_Height() {
        return grid_Height;
    }

    public int getCellSize() {
        return cellSize;
    }

    public int getReSizeWin() {
        return reSizeWin;
    }

    public int[][] getGridBoard() {
        return gridBoard;
    }

    public void setGridBoard(int row, int col, int piece) {
        this.gridBoard[col][row] = piece;
    }

    int[][] gridBoard = new int[grid_Height][grid_Width];

    double delta = 0;
    int fps = 60;
    long drawInterval = 1000000000 / fps;
    long currentTime;
    long lastTime = System.nanoTime();
    Thread gameThread;

   
    int score = 0; // Moved to the top

    public gameGrid() {
        setBackground(Color.black);
        setFocusable(true);
        requestFocusInWindow();
        gridFillReset();
        tetro.setCurrentPiece(random.nextInt(7));
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run() {
        while (gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
                 
            if (delta >= 1) {
                dropCount++;
                repaint();
                delta--;
            }
            
            if(dropCount == dropInterval){
                dropCount = 0;
                 update();

            }

        }
    }
    public void update(){
        tetro.move(0, 1);
    }
    public void gridFillReset() {
        for (int row = 0; row < grid_Height; row++) { // Fixed loop
            for (int col = 0; col < grid_Width; col++) {
                gridBoard[row][col] = 0;
            }
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        drawGrid(g2d);
        tetro.drawPiece(g2d);
        drawNextPieceBox(g2d, tetro.getNextPiece());

    }

    public void drawGrid(Graphics2D g2d) {
    
    }


    private void drawNextPieceBox(Graphics2D g2d, int nextPiece) {
        
        
        if (nextPiece != -1) {
        }

    }

}
