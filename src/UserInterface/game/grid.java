package UserInterface.game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.io.IOException;
import java.io.InputStream;

public class grid {

    public static int getGrid_Width() {
        return grid_Width;
    }

    public static int getGrid_Height() {
        return grid_Height;
    }

    public static int[][] getGridBoard() {
        return gridBoard;
    }

    public int getCellSize() {
        return cellSize;
    }

    public int getReSizeWin() {
        return reSizeWin;
    }

    public static void setGridBoard(int row ,int col ,int piece) {
        gridBoard [row][col] = piece;
    }
    private static final int grid_Width = 10;
    private static final int grid_Height = 20;
    private static int[][] gridBoard = new int[grid_Height][grid_Width];
    private mino tetro = new mino(this);
    private final int cellSize = 8;
    private final int reSizeWin = 4;
    private int score = 0;

    public grid() {
       this.gridFillReset();
    }

    public void update() {
        checkLines();
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(new Color(211, 211, 211));
        g2d.setStroke(new BasicStroke(0.5f));
        int boxX = grid_Width * cellSize + 20;
        int boxY = 20;
        int size = 4 * cellSize;
        int boxHeight = cellSize * reSizeWin + 20;

        for (int row = 0; row < grid_Width; row++) { // Fixed order
            for (int col = 0; col < grid_Height; col++) {

                int posX = row * cellSize;
                int posY = col * cellSize;

                if (gridBoard[col][row] != 0) {
                    g2d.setColor(tetro.tetroColors[gridBoard[col][row] - 1]);
                } else {
                    g2d.setColor(new Color(128, 128, 128));
                }

                g2d.fillRect(posX, posY, cellSize, cellSize);
                g2d.setColor(new Color(211, 211, 211));
                g2d.drawRect(posX, posY, cellSize, cellSize);
                g2d.setColor(Color.WHITE);
                g2d.drawRect(boxX, boxY, size, size);
                if (tetro.getNextPiece() != -1) {
                    //draw the next box inside the piece 
                    drawNextPiece(g2d, boxX, boxY, tetro.getNextPiece());

                }
                        //draw the box to store the next piece
                g2d.setColor(Color.WHITE);
                drawScore(g2d, boxX, boxY + boxHeight);
            }
        }

    }
    
    public void printallGrid(){
                   System.out.print("---------------------");

        for(int row = 0 ; row < grid_Height ; row++){
            System.out.println("\n");
            for(int col = 0 ; col < grid_Width ; col++){
                System.out.print("||" +gridBoard[row][col] + "||");
            }
            System.out.println("\n");
        }
                   System.out.print("---------------------");

    }

    private void drawNextPiece(Graphics2D g2d, int boxX, int boxY, int nextPiece) {
        if (tetro == null) {
            return;
        }
        int[][] nextPieceShape = tetro.getNextTetro();
        if (nextPieceShape == null) {
            return;
        }
        Color pieceColor = tetro.tetroColors[nextPiece];

        g2d.setColor(pieceColor);
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (nextPieceShape[col][row] != 0) {
                    int x = boxX + (col * cellSize) -8;
                    int y = boxY + (row * cellSize) -8 ;
                    g2d.fillRect(x, y, cellSize, cellSize);
                    g2d.setColor(Color.BLACK);
                    g2d.drawRect(x, y, cellSize, cellSize);
                    g2d.setColor(pieceColor);
                }
            }
        }
    }

    private void drawScore(Graphics2D g2d, int x, int y) {
        try {
            InputStream is = getClass().getResourceAsStream("/Font/Retro Gaming.ttf");
            Font retroFont = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(14f);//load a font from a file and use TTF type font(trueType font) size 14
            g2d.setFont(retroFont);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            g2d.setFont(new Font("Arial", Font.BOLD, 14));
        }

        g2d.setColor(Color.WHITE);

        String label = "SCORE:";
        int labelWidth = g2d.getFontMetrics().stringWidth(label);

        g2d.drawString(label, x + (cellSize * reSizeWin - labelWidth) / 2 + 5 + 1, y);

        String scoreStr = String.valueOf(score);
        int scoreWidth = g2d.getFontMetrics().stringWidth(scoreStr);

        g2d.drawString(scoreStr, x + (cellSize * reSizeWin - scoreWidth) / 2 + 1, y + 20);
    }

    public void checkLines() {
        int linesCleared = 0;
        for (int row = grid_Height - 1; row >= 0; row--) {
            boolean full = true;
            for (int col = 0; col < grid_Width; col++) {
                if (gridBoard[row][col] == 0) {
                    full = false;
                    break;
                }
            }
            if (full) {
                linesCleared++;
                for (int r = row; r > 0; r--) {
                    for (int c = 0; c < grid_Width; c++) {
                        gridBoard[r][c] = gridBoard[r][c - 1];
                    }
                }
                row++;
            }
        }
        if (linesCleared > 0) {
            score += linesCleared * 100;
        }
    }
    public static void gridFillReset() {
    	
        for (int row = 0; row != (grid_Height  ) ; row++) { // Fixed loop
            for (int col = 0; col !=(grid_Width ) ; col++) {
              
                gridBoard[row ][col ] = 0;
            }
        }
    }

    public void drawLockTetro(Graphics2D g2d) {
        for (int row = 0; row <= grid_Width -1 ; row++) {
            for (int col = 0; col <= grid_Height - 1; col++) {
                if (gridBoard[col][row] != 0) {
                    g2d.setColor(Color.BLUE);
                    g2d.fillRect(col * cellSize, row * cellSize, cellSize,
                            cellSize);
                    g2d.setColor(Color.BLACK);
                    g2d.drawRect(col * cellSize, row * cellSize, cellSize,
                            cellSize);
                }
            }
        }
    }

}
