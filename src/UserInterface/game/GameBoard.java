/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserInterface.game;

import Model.UserData.UserData;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.BiPredicate;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameBoard extends JPanel implements Runnable {

    private final int cellSize = 8;
    private final int gridHeight = 20;
    private final int gridWidth = 10;
    private ArrayList<Tetromino> tetro = new ArrayList<>();
    private Tetromino CurrentTetromino;
    private Tetromino NextTetromino;
    private boolean isLineFull = false;

    private boolean isGameOver = false;
    private boolean isGamePause = false;
    private int score = 0;
    private Color gridTetroLockColor[][] = new Color[gridHeight][gridWidth];
    private int grid[][] = new int[gridHeight][gridWidth];

    private final int previewBoxSize = 4;
    private final int previewBoxX = gridWidth * cellSize + 20;
    private final int previewBoxY = 10;

    private int Fps = 60;
    private Thread gameThread;
    private long lastTime = System.nanoTime();
    private long CurrentTime;
    private double delta = 0;
    private long drawInterval = 1000000000;

    public boolean isIsGameOver() {
        return isGameOver;
    }

    public void setIsGameOver(boolean isGameOver) {
        this.isGameOver = isGameOver;
    }

    public boolean isIsGamePause() {
        return isGamePause;
    }

    public void setIsGamePause(boolean isGamePause) {
        this.isGamePause = isGamePause;
    }

    public GameBoard(JFrame frame) {
        this.setBounds(frame.getBounds());
        this.setBackground(Color.red);
        addTetromino();
        initializeGame();
        this.setFocusable(true);
        this.requestFocusInWindow();
        addKeyListener(new UserKeyAdapter());
    }

    private void initializeGame() {
        clearGrid();
        spawnPiece();
        startGameThread();
    }

    private void startGameThread() {
        if (gameThread == null || !gameThread.isAlive()) {
            gameThread = new Thread(this);
            gameThread.start();
        }
    }

    private void clearGrid() {
        for (int row = 0; row < gridHeight; row++) {
            for (int col = 0; col < gridWidth; col++) {
                grid[row][col] = 0;
                gridTetroLockColor[row][col] = Color.BLACK;
            }
        }
    }

    private void generateNextTetromino() {
        Random rand = new Random();
        int nextTetromino = rand.nextInt(7);
        NextTetromino = new Tetromino(tetro.get(nextTetromino).getTetromino(), tetro.get(nextTetromino).getColor());

    }

    private boolean processTetromino(int offSetX, int offSetY, int tetromino[][], BiPredicate<Integer, Integer> func) {
        for (int col = 0; col < tetromino.length; col++) {
            for (int row = 0; row < tetromino[col].length; row++) {
                if (tetromino[col][row] != 0) {

                    int x = CurrentTetromino.getPosX() + row + offSetX;
                    int y = CurrentTetromino.getPosY() + col + offSetY;
                    //check boundary
                    if (func.test(x, y)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkBoundary(int offSetX, int offSetY, int tetromino[][]) {
        return processTetromino(offSetX, offSetY, tetromino, (x, y) -> x < 0 || x >= gridWidth || y < 0 || y >= gridHeight);
    }

    private boolean checkPieceCollision(int offSetX, int offSetY, int tetromino[][]) {
        return processTetromino(offSetX, offSetY, tetromino, (x, y) -> y >= 0 && y < gridHeight && x >= 0 && x < gridWidth && grid[y][x] != 0);
    }

    private boolean checkIsPieceBottom(int offSetX, int offSetY, int tetromino[][]) {
        return processTetromino(offSetX, offSetY, tetromino, (x, y) -> y >= gridHeight);
    }

    /*
    private boolean checkPartTetrominoValid(int offSetX, int offSetY, int tetromino[][]) {
        return processTetromino(offSetX, offSetY, tetromino, (x, y) -> y >= 0 && y < gridHeight && x >= 0 && x < gridWidth && grid[y][x] != 0);
    }
     */
    public void RotateTetromino() {
        int[][] nextTetrominoRotationState = CurrentTetromino.getNextRotationState();

        if (!checkPieceCollision(0, 0, nextTetrominoRotationState) && !checkBoundary(0, 0, nextTetrominoRotationState)) {
            CurrentTetromino.RotateTetromino();
            repaint();
            return;
        }

        //found it in fandom wiki of tetris all the wall kick using the SRS(Super Rotation Sysetem)
        //https://tetris.fandom.com/wiki/SRS
        int[][] wallKicks = {
            {-1, 0}, {1, 0}, {0, -1}, // Left, Right, Up
            {-1, -1}, {1, -1}, // Left+Up, Right+Up
            {-2, 0}, {2, 0} // Far Left, Far Right
        };

        for (int[] kicks : wallKicks) {
            if (!checkPieceCollision(kicks[0], kicks[1], nextTetrominoRotationState) && !checkBoundary(kicks[0], kicks[1], nextTetrominoRotationState)) {
                CurrentTetromino.RotateTetromino();
                CurrentTetromino.updatePos(kicks[0], kicks[1]);
                repaint();
                return;
            }

        }
    }

    private void lockPiece() {
        int[][] piece = CurrentTetromino.getTetromino();
        for (int row = 0; row < piece.length; row++) {
            for (int col = 0; col < piece[row].length; col++) {
                if (piece[row][col] != 0) {
                    int x = CurrentTetromino.getPosX() + col;
                    int y = CurrentTetromino.getPosY() + row;

                    if (y >= 0 && y < gridHeight && x >= 0 && x < gridWidth) {
                        grid[y][x] = 1;
                        gridTetroLockColor[y][x] = CurrentTetromino.getColor();
                    }
                }
            }
        }
    }

    private int CheckLines() {
        int lineRemove = 0;
        for (int col = gridHeight - 1; col >= 0; col--) {
            isLineFull = true;

            for (int row = 0; row < gridWidth; row++) {
                if (grid[col][row] == 0) {
                    isLineFull = false;
                    break;
                }

            }

            if (isLineFull) {
                removeLine(col);
                lineRemove++;
                col++;
            }
        }
        return lineRemove;
    }

    private void removeLine(int coltoRemove) {
        //move all row above this one down
        for (int col = coltoRemove; col > 0; col--) {
            for (int row = 0; row < gridWidth; row++) {
                grid[col][row] = grid[col - 1][row];
                gridTetroLockColor[col][row] = gridTetroLockColor[col - 1][row];
            }
        }

        // Clear the top row
        for (int col = 0; col < gridWidth; col++) {
            grid[0][col] = 0;
            gridTetroLockColor[0][col] = Color.BLACK;
        }
    }

    private void updateScoreUser(int lineRemove) {
        int[] pointsPerLine = {0, 40, 100, 300, 1200};
        if (lineRemove >= 0 && lineRemove < pointsPerLine.length) {
            score += pointsPerLine[lineRemove];
        }
    }

    private void spawnPiece() {
        if (NextTetromino == null) {
            Random rand = new Random();
            int currentPiece = rand.nextInt(7);
            CurrentTetromino = new Tetromino(tetro.get(currentPiece).getTetromino(), tetro.get(currentPiece).getColor());
        } else {
            CurrentTetromino = NextTetromino;
        }
        generateNextTetromino();

        CurrentTetromino.setPosX(gridWidth / 2 - CurrentTetromino.getTetrominoWidth());
        CurrentTetromino.setPosY(0 - CurrentTetromino.getTetrominoLenght());

    }

    private void addTetromino() {
        tetro.add(new Tetromino(new int[][]{{1, 1, 1, 1}}, Color.CYAN));//line shape
        tetro.add(new Tetromino(new int[][]{{1, 1}, {1, 1}}, Color.yellow));//box shaoe
        tetro.add(new Tetromino(new int[][]{{0, 1, 0}, {1, 1, 1}}, new Color(128, 0, 128)));//T shape
        tetro.add(new Tetromino(new int[][]{{0, 1, 1}, {1, 1, 0}}, Color.green));//S shape
        tetro.add(new Tetromino(new int[][]{{1, 1, 0}, {0, 1, 1}}, Color.red));// z shape
        tetro.add(new Tetromino(new int[][]{{1, 0, 0}, {1, 1, 1}}, Color.blue));// J shape
        tetro.add(new Tetromino(new int[][]{{0, 0, 1}, {1, 1, 1}}, Color.orange));//L shape
    }

    private void drawGrid(Graphics2D g2d) {
        g2d.setColor(new Color(211, 211, 211));
        for (int row = 0; row < gridHeight; row++) {
            for (int col = 0; col < gridWidth; col++) {
                g2d.drawRect(col * cellSize, row * cellSize, cellSize, cellSize);
            }
        }

        for (int row = 0; row < gridHeight; row++) {
            for (int col = 0; col < gridWidth; col++) {
                if (grid[row][col] != 0) {
                    g2d.setColor(gridTetroLockColor[row][col]);
                    g2d.fillRect(col * cellSize, row * cellSize, cellSize, cellSize);
                    g2d.setColor(Color.BLACK);
                    g2d.drawRect(col * cellSize, row * cellSize, cellSize, cellSize);
                }
            }
        }
    }

    private void drawNextPiecePreview(Graphics2D g2d) {
        if (NextTetromino == null || isGameOver) {
            return;
        }
        g2d.setColor(new Color(30, 30, 30));
        g2d.fillRect(previewBoxX, previewBoxY, previewBoxSize * cellSize, previewBoxSize * cellSize);
        g2d.setColor(Color.WHITE);
        g2d.drawRect(previewBoxX, previewBoxY, previewBoxSize * cellSize, previewBoxSize * cellSize);

        g2d.drawString("SCORE: " + score, previewBoxX, previewBoxY + 50);

        int[][] shape = NextTetromino.getTetromino();
        int tetrominoWidth = shape[0].length;
        int tetrominoHeight = shape.length;

        // Calculate position to center the tetromino in the preview box
        int startX = previewBoxX + (previewBoxSize * cellSize - tetrominoWidth * cellSize) / 2;
        int startY = previewBoxY + (previewBoxSize * cellSize - tetrominoHeight * cellSize) / 2;

        g2d.setColor(NextTetromino.getColor());
        for (int row = 0; row < tetrominoHeight; row++) {
            for (int col = 0; col < tetrominoWidth; col++) {
                if (shape[row][col] != 0) {
                    int x = startX + col * cellSize;
                    int y = startY + row * cellSize;
                    g2d.fillRect(x, y, cellSize, cellSize);
                    g2d.setColor(Color.BLACK);
                    g2d.drawRect(x, y, cellSize, cellSize);
                    g2d.setColor(NextTetromino.getColor());
                }
            }
        }
    }

    private void drawTetromino(Graphics2D g2d) {
        if (CurrentTetromino == null || isGameOver) {
            return;
        }

        int shape[][] = CurrentTetromino.getTetromino();
        g2d.setColor(CurrentTetromino.getColor());

        for (int row = 0; row < shape.length; row++) {
            for (int col = 0; col < shape[row].length; col++) {
                if (shape[row][col] != 0) {
                    int x = (CurrentTetromino.getPosX() + col) * cellSize;
                    int y = (CurrentTetromino.getPosY() + row) * cellSize;
                    g2d.fillRect(x, y, cellSize, cellSize);
                    g2d.setColor(Color.BLACK);
                    g2d.drawRect(x, y, cellSize, cellSize);
                    g2d.setColor(CurrentTetromino.getColor());
                }

            }
        }
    }

    private void drawGameOver(Graphics2D g2d) {
        if (isGameOver) {
            g2d.setColor(new Color(0, 0, 0, 150));
            g2d.fillRect(0, 0, gridWidth * cellSize, gridHeight * cellSize);
            g2d.setColor(Color.WHITE);
            g2d.drawString("GAME OVER", gridWidth * cellSize / 2 - 40, gridHeight * cellSize / 2);
            g2d.drawString("Score: " + score, gridWidth * cellSize / 2 - 30, gridHeight * cellSize / 2 + 20);
            g2d.drawString("Press R to restart", gridWidth * cellSize / 2 - 50, gridHeight * cellSize / 2 + 40);
        }
    }

    private void drawPaused(Graphics2D g2d) {
        if (isGamePause && !isGameOver) {
            g2d.setColor(new Color(0, 0, 0, 150));
            g2d.fillRect(0, 0, gridWidth * cellSize, gridHeight * cellSize);
            g2d.setColor(Color.WHITE);
            g2d.drawString("PAUSED", gridWidth * cellSize / 2 - 30, gridHeight * cellSize / 2);
            g2d.drawString("Press P to resume", gridWidth * cellSize / 2 - 50, gridHeight * cellSize / 2 + 20);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        drawGrid(g2d);
        drawTetromino(g2d);
        drawGameOver(g2d);
        drawPaused(g2d);
        drawNextPiecePreview(g2d);
    }

    private void moveLeft() {
        int[][] shape = CurrentTetromino.getTetromino();
        if (!checkPieceCollision(-1, 0, shape) && !checkBoundary(-1, 0, shape)) {
            CurrentTetromino.updatePos(-1, 0);
            repaint();
        }
    }

    private void moveRight() {
        int[][] shape = CurrentTetromino.getTetromino();
        if (!checkPieceCollision(1, 0, shape) && !checkBoundary(1, 0, shape)) {
            CurrentTetromino.updatePos(1, 0);
            repaint();
        }
    }

    private void moveDown() {
        int[][] shape = CurrentTetromino.getTetromino();
        if (checkPieceCollision(0, 1, shape) || checkIsPieceBottom(0, 1, shape)) {
            lockPiece();
            int lineremove = CheckLines();
            if (lineremove > 0) {
                updateScoreUser(lineremove);
            }
            spawnPiece();

        } else {
            CurrentTetromino.updatePos(0, 1);
            repaint();
        }
    }

    private void hardDrop() {
        while (true) {
            int[][] shape = CurrentTetromino.getTetromino();
            if (checkPieceCollision(0, 1, shape) || checkIsPieceBottom(0, 1, shape)) {
                score += 2;
                break;
            }
            CurrentTetromino.updatePos(0, 1);

        }
        moveDown();
    }

    private void restartgame() {
        if (gameThread != null && gameThread.isAlive()) {
            gameThread.interrupt();
            try {
                gameThread.join(1000); // Wait for thread to finish
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isGameOver = false;
        isGamePause = false;
        score = 0;
        clearGrid();
        spawnPiece();
        startGameThread();
        repaint();
    }

    private void togglePause() {
        isGamePause = !isGamePause;
        repaint();
    }

    @Override
    public void run() {
        while (!isGameOver) {
            if (!isGamePause) {
                CurrentTime = System.nanoTime();
                delta += (CurrentTime - lastTime) / (double) drawInterval;
                lastTime = CurrentTime;

                while (delta >= 1) {
                    moveDown();
                    delta--;
                }
                repaint();
            }

            try {
                Thread.sleep(1000 / Fps);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class UserKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            if (isIsGameOver()) {
                if (e.getKeyCode() == KeyEvent.VK_R) {
                    restartgame();
                }
                return;
            }

            if (isIsGamePause()) {
                if (e.getKeyCode() == KeyEvent.VK_P) {
                    togglePause();
                }
                return;
            }

            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    moveLeft();
                    break;
                case KeyEvent.VK_RIGHT:
                    moveRight();
                    break;
                case KeyEvent.VK_DOWN:
                    moveDown();
                    break;
                case KeyEvent.VK_UP:
                    RotateTetromino();
                    break;
                case KeyEvent.VK_SPACE:
                    hardDrop();
                    break;
                case KeyEvent.VK_P:
                    togglePause();
                    break;
            }
        }
    }

}
