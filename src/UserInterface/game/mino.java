/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserInterface.game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;
import java.util.function.BiPredicate;

public class mino {

    int currentRotation;
    grid grd;
    final Random random = new Random();

    public int getNextPiece() {
        return nextPiece;
    }

    public void setNextPiece(int nextPiece) {
        this.nextPiece = nextPiece;
    }

    public int getCurrentPiece() {
        return currentPiece;
    }

    public void setCurrentPiece(int currentPiece) {
        this.currentPiece = currentPiece;
    }
    int nextPiece;
    int currentPiece;
    int posX = 0;
    int posY = 0;
    int cellSize;
    int GhostPosY = 0;

    public Color tetroColors[] = {Color.yellow, Color.cyan, Color.magenta, new Color(255, 165, 0), Color.blue,
        Color.green, Color.red

    };

    public mino(grid gd) {
        grd = gd;
        currentRotation = 0;
        posX = grd.getGrid_Width() / 2;
        posY = 0;
        currentPiece = 0;
        nextPiece = 1;
        cellSize = grd.getCellSize();
    }

    // 4d array pieces[layer][row][col][depth]
    public final static int tetro[][][][] = {
        //layer 1(straight line block)
        {
            //squareBlock
            //row
            {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 2, 1, 0},
                {0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0}
            },
            {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 2, 1, 0},
                {0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0}
            },
            {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 2, 1, 0},
                {0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0}
            },
            {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 2, 1, 0},
                {0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0}
            },},
        //layer 2 (square shape Block)
        {
            //row
            {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 2, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
            },
            {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 2, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0}
            },
            {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 2, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}

            },
            {
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 2, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0}

            },},
        //layer 3(t shape block)
        {
            //row
            {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 2, 1, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0}

            },
            {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 2, 1, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0}

            },
            {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 1, 2, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0}

            },
            {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 1, 2, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}

            },},
        //layer 4 (L shape block )
        {
            //row
            {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 2, 0, 0},
                {0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0}

            },
            {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 2, 1, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}

            },
            {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 2, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0}

            },
            {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 1, 2, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}

            },},
        //layer 5 (J shape block)
        {
            //row
            {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 2, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0}

            },
            {
                {0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 1, 2, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}

            },
            {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0},
                {0, 0, 2, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0}

            },
            {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 2, 1, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0}

            },},
        //layer 6 (S shape block)
        {
            //row
            {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 2, 1, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0}

            },
            {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 2, 0, 0},
                {0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0}

            },
            {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 1, 2, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}

            },
            {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 2, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}

            },},
        //layer 7 (Z shape block)
        {
            //row
            {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 2, 1, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0}

            },
            {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 2, 1, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0}

            },
            {
                {0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 1, 2, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0}

            },
            {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0},
                {0, 1, 2, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}

            },},};

    public int[][] getCurrentTetro() {
        return tetro[currentPiece][currentRotation];
    }

    public int[][] getNextTetro() {
        return tetro[nextPiece][currentRotation];
    }

    public void drawPiece(Graphics2D g2d) {

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {

                if (getCurrentTetro()[row][col] != 0) {
                    int x = (posX + row - 2) * cellSize;
                    int y = (posY + col - 2) * cellSize;

                    g2d.setColor(tetroColors[currentPiece]);
                    g2d.fillRect(x, y, cellSize,
                            cellSize);
                    g2d.setColor(Color.black);
                    g2d.drawRect(x, y, cellSize,
                            cellSize);

                }
            }
        }

    }

    public void updateGhostPos() {
        GhostPosY = posY - 1;
        while (true) {
            GhostPosY++;
            if (checkPieceCollision(posX, GhostPosY) || isBottom(posX, GhostPosY) || GhostPosY >= grid.getGrid_Height()) {
                GhostPosY--;
                break;
            }
        }
    }

    public void drawGhostTetro(Graphics2D g2d) {
        g2d.setColor(new Color(64, 64, 64, 128));  // Semi-transparent gray for ghost piece
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (tetro[currentPiece][currentRotation][row][col] != 0) {
                    int x = (posX + row - 2) * cellSize;
                    int y = (GhostPosY + col - 2) * cellSize;
                    g2d.fillRect(x, y, cellSize, cellSize);
                    g2d.setColor(Color.BLACK);
                    g2d.drawRect(x, y, cellSize, cellSize);
                    g2d.setColor(new Color(64, 64, 64, 128));  // Semi-transparent gray for ghost piece

                }
            }
        }
    }

    // lambda function
    // BiPredicate is a type that get two data type and return it a boolean
    public boolean processTetromino(int x, int y, BiPredicate<Integer, Integer> func) {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (tetro[currentPiece][currentRotation][row][col] != 0) {
                    int gridX = x + col - 2;
                    int gridY = y + row - 2;

                    if (gridX < 0 || gridX >= grid.getGrid_Width() || gridY < 0 || gridY >= grid.getGrid_Height() || func.test(gridX, gridY)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void lockPiece() {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (tetro[currentPiece][currentRotation][row][col] != 0) {
                    int x = posX + row - 2; // Adjust for the center
                    int y = posY + col - 2; // Adjust for the center
                    if (x >= 0 && x < grid.getGrid_Width() && y >= 0 && y < grid.getGrid_Height()) {
                        grd.setGridBoard(y, x, currentPiece + 1); // Lock the current piece
                    }
                }
            }
        }
    }
//check the collision

    public boolean checkGridCollision(int x, int y) {
        return processTetromino(x, y, (gridX, gridY) -> (gridX < 0 || gridX >= grd.getGrid_Width() || gridY >= grid.getGrid_Height()
                || gridY < 0) && grid.getGridBoard()[gridY][gridX] != 0);
    }

    // Check for piece collision
    public boolean checkPieceCollision(int x, int y) {
        return processTetromino(x, y, (gridX, gridY) -> grid.getGridBoard()[gridY][gridX] != 0);
    }

    // Check if piece is at the bottom
    public boolean isBottom(int x, int y) {
        return processTetromino(x, y, (gridX, gridY) -> gridY >= grid.getGrid_Height());
    }

    public void move(int dx, int dy) {
        posX += dx;
        posY += dy;

        //check the the pos if it can move
        if (checkGridCollision(posX, posY)) {
            posX -= dx;
            posY -= dy;
        }
    }

    public void update() {
        updateGhostPos();
        if (!checkGridCollision(posX, posY)) {
            move(0, 1);
       } else {
            lockPiece();
        }
    }

}
