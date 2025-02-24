/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserInterface.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.function.BiPredicate;
import javax.swing.JPanel;

public class gameGrid extends JPanel {

    private final int gridHeight = 20;
    private final int gridWidth = 10;
    private int gridCell;
    private tetro tetromino;

    private void spawnTetromino() {
        int tetro[][] = {{1, 0}, {1, 0}, {1, 1}};
        tetromino = new tetro(tetro, Color.red);
    }

    public gameGrid(JPanel panelHolder, int col) {
        panelHolder.setVisible(false);
        setBounds(panelHolder.getBounds());
        setBackground(Color.BLACK);
        gridCell = getBounds().width / gridHeight;
        spawnTetromino();
    }

    private boolean processTetro(int x, int y, BiPredicate<Integer, Integer> func) {
        for (int row = 0; row < tetromino.getTetrominoWidth(); row++) {
            for (int col = 0; col < tetromino.getTetrominoLength(); col++) {
                int gridX = x + row - 2;
                int gridY = y + col - 2;

                if (func.test(gridX, gridY)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isBottom() {
        int x = tetromino.getPosX();
        int y = tetromino.getPosY();
        return processTetro(x, y, (gridX, gridY) -> gridX == gridHeight);

    }

    private void drawTetromino(Graphics2D g2d) {

        g2d.setColor(new Color(211, 211, 211));

        for (int row = 0; row < tetromino.getTetrominoWidth(); row++) {
            for (int col = 0; col < tetromino.getTetrominoLength(); col++) {
                if (tetromino.getTetromino()[row][col] != 0) {
                    int x = (tetromino.getPosX() + row) * gridCell;
                    int y = (tetromino.getPosY() + col) * gridCell;
                    g2d.drawRect(x , y, gridCell, gridCell);
                    g2d.setColor(tetromino.getColor());
                    g2d.fillRect(x , y, gridCell, gridCell);
                }

            }
        }
    }

    private void drawGrid(Graphics2D g2d) {
        g2d.setColor(new Color(128, 128, 128));
        for (int row = 0; row < gridWidth; row++) {
            for (int col = 0; col < gridHeight; col++) {
                g2d.drawRect(row * gridCell, col * gridCell, gridCell, gridCell);
            }
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        drawGrid(g2d);
        drawTetromino(g2d);
    }
}
