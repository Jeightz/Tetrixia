/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Function.GameBoard;

import Model.Tetromino.Tetromino;
import Function.GameAudio.GameBackGroundMusic;
import Model.DataManager.DataManager;
import Model.UserData.UserData;
import java.awt.Color;
import java.awt.Font;
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

    private DataManager data = DataManager.getInstance();

    private int cellSize = 8;
    private final int gridHeight = 20;
    private final int gridWidth = 10;

    private ArrayList<Tetromino> tetro = new ArrayList<>();
    private Tetromino CurrentTetromino;
    private Tetromino NextTetromino;
    private Tetromino HoldTetromino;
    private boolean isLineFull = false;
    private boolean isGamePause = false;
    private boolean isGameOver = false;
    private int score = 0;
    private Color gridTetroLockColor[][] = new Color[gridHeight][gridWidth];
    private int grid[][] = new int[gridHeight][gridWidth];

    //box next piece preview
    private int previewBoxSize = 4;
    private int previewBoxX = gridWidth * cellSize + 20;
    private int previewBoxY = 40;

    private int holdBoxSize = 4;
    private int holdBoxX = gridWidth * cellSize + 20;
    private int holdBoxY = gridHeight * cellSize + 20;
    private boolean canHold = true; //  prevent continuous holds

    //game loop
    private int Fps = 60;
    private Thread gameThread;
    private long lastTime = System.nanoTime();
    private long CurrentTime;
    private double delta = 0;
    private long drawInterval = 1000000000;

    private GameBackGroundMusic music;

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

    public GameBoard(JFrame frame, GameBackGroundMusic music) {
        this.setBounds(frame.getBounds());
        this.setBackground(Color.black);
        addTetromino();
        initializeGame();
        this.setFocusable(true);
        this.requestFocusInWindow();
        addKeyListener(new UserKeyAdapter());
        resizeGame(frame.getWidth(), frame.getHeight());
        this.music = music;
        music.loadMusic();
        music.toggleMusic(this.data.getCurrentUser().isIsMusicOn());
    }

    public void resizeGame(int frameWidth, int frameHeight) {
        int maxCellWidth = frameWidth / (gridWidth + 8);
        int maxCellHeight = (frameHeight / gridHeight) - 1;
        cellSize = Math.min(maxCellWidth, maxCellHeight);
        cellSize = Math.max(cellSize, 8);
        this.setBounds(0, 0, frameWidth, frameHeight);

        previewBoxX = gridWidth * cellSize + 20;
        holdBoxX = gridWidth * cellSize + 20;

        holdBoxY = gridWidth * cellSize + 20;

        // Ensure grid arrays match dimensions
        if (grid.length != gridHeight || grid[0].length != gridWidth) {
            resizeGridArrays();
        }

        repaint();
    }

    private void resizeGridArrays() {
        int[][] newGrid = new int[gridHeight][gridWidth];
        Color[][] newColors = new Color[gridHeight][gridWidth];

        // Copy existing data
        for (int row = 0; row < Math.min(grid.length, gridHeight); row++) {
            for (int col = 0; col < Math.min(grid[0].length, gridWidth); col++) {
                newGrid[row][col] = grid[row][col];
                newColors[row][col] = gridTetroLockColor[row][col];
            }
        }

        // Initialize new cells
        for (int row = 0; row < gridHeight; row++) {
            for (int col = 0; col < gridWidth; col++) {
                if (row >= grid.length || col >= grid[0].length) {
                    newGrid[row][col] = 0;
                    newColors[row][col] = Color.BLACK;
                }
            }
        }

        grid = newGrid;
        gridTetroLockColor = newColors;
    }

    private void HoldTheTetromino() {
        if (!canHold) {
            return;
        }
        if (HoldTetromino == null) {
            HoldTetromino = CurrentTetromino;
            CurrentTetromino = NextTetromino;
            generateNextTetromino();
        } else {
            Tetromino temp = CurrentTetromino;
            CurrentTetromino = HoldTetromino;
            HoldTetromino = temp;
        }

        CurrentTetromino.setPosX(gridWidth / 2 - CurrentTetromino.getTetrominoWidth() / 2);
        CurrentTetromino.setPosY(0 - CurrentTetromino.getTetrominoLenght() + 1);
        HoldTetromino.setCurrentRotation(0);
        canHold = false;

        repaint();
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
        NextTetromino.setCurrentRotation(0);

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
        return processTetromino(offSetX, offSetY, tetromino, (x, y) -> x < 0 || x >= gridWidth || y >= gridHeight);
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
        if (isGameOver || isGamePause) {
            return;
        }

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
        boolean lockAboveGrid = false;

        for (int row = 0; row < piece.length; row++) {
            for (int col = 0; col < piece[row].length; col++) {
                if (piece[row][col] != 0) {
                    int x = CurrentTetromino.getPosX() + col;
                    int y = CurrentTetromino.getPosY() + row;

                    if (y < 0) {
                        lockAboveGrid = true;
                    } else if (y >= 0 && y < gridHeight && x >= 0 && x < gridWidth) {
                        grid[y][x] = 1;
                        gridTetroLockColor[y][x] = CurrentTetromino.getColor();
                    }
                }
            }
        }

        canHold = true;

        // If any part of the locked piece is above the grid, it's game over
        if (lockAboveGrid) {
            isGameOver = true;
            repaint();
            return;
        }

        if (!isGameOver) {
            spawnPiece();
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

    public void recordScore() {
        int DataScore = data.getCurrentUser().getPlayerScore();
        if (DataScore < score) {
            for (UserData da : data.getData()) {
                if (da == data.getCurrentUser()) {
                    da.setPlayerScore(score);
                    break;
                }
            }
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
        CurrentTetromino.setPosY(1 - CurrentTetromino.getTetrominoLenght());

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

        g2d.drawString("SCORE: " + score, previewBoxX, previewBoxY - 10);

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

    private void drawHoldPieceBox(Graphics2D g2d) {
        if (CurrentTetromino == null || isGameOver) {
            return;
        }

        // Box title
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.BOLD, 14));
        g2d.drawString("HOLD", holdBoxX, holdBoxY - 5);

        // Box background and border
        g2d.setColor(new Color(30, 30, 30));
        g2d.fillRect(holdBoxX, holdBoxY, holdBoxSize * cellSize, holdBoxSize * cellSize);
        g2d.setColor(Color.WHITE);
        g2d.drawRect(holdBoxX, holdBoxY, holdBoxSize * cellSize, holdBoxSize * cellSize);

        // If there's a held piece, draw it
        if (HoldTetromino != null) {
            int[][] shape = HoldTetromino.getTetromino();
            int tetrominoWidth = shape[0].length;
            int tetrominoHeight = shape.length;

            // Calculate position to center the tetromino in the hold box
            int startX = holdBoxX + (holdBoxSize * cellSize - tetrominoWidth * cellSize) / 2;
            int startY = holdBoxY + (holdBoxSize * cellSize - tetrominoHeight * cellSize) / 2;

            // Darken color if can't hold
            g2d.setColor(canHold ? HoldTetromino.getColor()
                    : new Color(HoldTetromino.getColor().getRed() / 2,
                            HoldTetromino.getColor().getGreen() / 2,
                            HoldTetromino.getColor().getBlue() / 2));

            for (int row = 0; row < tetrominoHeight; row++) {
                for (int col = 0; col < tetrominoWidth; col++) {
                    if (shape[row][col] != 0) {
                        int x = startX + col * cellSize;
                        int y = startY + row * cellSize;
                        g2d.fillRect(x, y, cellSize, cellSize);
                        g2d.setColor(Color.BLACK);
                        g2d.drawRect(x, y, cellSize, cellSize);
                        g2d.setColor(canHold ? HoldTetromino.getColor()
                                : new Color(HoldTetromino.getColor().getRed() / 2,
                                        HoldTetromino.getColor().getGreen() / 2,
                                        HoldTetromino.getColor().getBlue() / 2));
                    }
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
        drawGhostPiece(g2d);

    }

    private void drawGhostPiece(Graphics2D g2d) {
        if (CurrentTetromino == null || isGameOver) {
            return;//prevent crashes
        }
        int ghostY = CurrentTetromino.getPosY();
        int dropDistance = 0;//to make sure that i will not check everframe to potential slowing down the rendering of the game
        while (!checkPieceCollision(0, dropDistance + 1, CurrentTetromino.getTetromino())
                && !checkIsPieceBottom(0, dropDistance + 1, CurrentTetromino.getTetromino())) {
            dropDistance++;
        }

        if (dropDistance > 0) {
            int shape[][] = CurrentTetromino.getTetromino();
            ghostY += dropDistance;
            //set the  color and make it 128 opacity
            Color ghostColor = new Color(
                    CurrentTetromino.getColor().getRed(),
                    CurrentTetromino.getColor().getGreen(),
                    CurrentTetromino.getColor().getBlue(),
                    128
            );
            g2d.setColor(ghostColor);

            for (int row = 0; row < shape.length; row++) {
                for (int col = 0; col < shape[row].length; col++) {
                    if (shape[row][col] != 0) {
                        int x = (CurrentTetromino.getPosX() + col) * cellSize;
                        int y = (ghostY + row) * cellSize;
                        g2d.fillRect(x, y, cellSize, cellSize);
                        g2d.setColor(Color.BLACK);
                        g2d.drawRect(x, y, cellSize, cellSize);
                        g2d.setColor(ghostColor);
                    }
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
            recordScore();
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
        drawHoldPieceBox(g2d);
    }

    private void moveLeft() {
        if (isGameOver || isGamePause) {
            return;
        }

        int[][] shape = CurrentTetromino.getTetromino();
        if (!checkPieceCollision(-1, 0, shape) && !checkBoundary(-1, 0, shape)) {
            CurrentTetromino.updatePos(-1, 0);
            repaint();
        }
    }

    private void moveRight() {
        if (isGameOver || isGamePause) {
            return;
        }
        int[][] shape = CurrentTetromino.getTetromino();
        if (!checkPieceCollision(1, 0, shape) && !checkBoundary(1, 0, shape)) {
            CurrentTetromino.updatePos(1, 0);
            repaint();
        }
    }

    private void moveDown() {
        if (isGameOver || isGamePause) {
            return;
        }
        int[][] shape = CurrentTetromino.getTetromino();
        if (checkPieceCollision(0, 1, shape) || checkIsPieceBottom(0, 1, shape)) {
            lockPiece();
            int lineremove = CheckLines();
            if (lineremove > 0) {
                updateScoreUser(lineremove);
            }

        } else {
            CurrentTetromino.updatePos(0, 1);
            repaint();
        }
    }

    private void hardDrop() {
        if (isGameOver || isGamePause) {    
            return;
        }

        while (true) {
            int[][] shape = CurrentTetromino.getTetromino();
            if (checkPieceCollision(0, 1, shape) || checkIsPieceBottom(0, 1, shape)) {
                break;
            }
            CurrentTetromino.updatePos(0, 1);

        }
        moveDown();
    }

    private void restartgame() {
        if (gameThread != null && gameThread.isAlive()) {
            gameThread.interrupt();
            gameThread = null;
        }

        isGameOver = false;
        isGamePause = false;
        score = 0;
        clearGrid();
        HoldTetromino = null;
        NextTetromino = null;
        spawnPiece();
        startGameThread();
        repaint();
    }

    public void togglePause() {
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
                    if (!isGameOver) {
                        moveDown();
                    }
                    delta--;
                }
                repaint();
            }
            lastTime = System.nanoTime();
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
            UserData da = data.getCurrentUser();
            int keyCode = e.getKeyCode();
            int moveLeftKey = da.getUserKeyBinds("MOVE_LEFT");
            int moveRightKey = da.getUserKeyBinds("MOVE_RIGHT");
            int moveDownKey = da.getUserKeyBinds("MOVE_DOWN");
            int rotateKey = da.getUserKeyBinds("ROTATE");
            int hardDropKey = da.getUserKeyBinds("HARD_DROP");
            int holdKey = da.getUserKeyBinds("HOLD");

            if (keyCode == moveLeftKey) {
                moveLeft();
            } else if (keyCode == moveRightKey) {
                moveRight();
            } else if (keyCode == moveDownKey) {
                moveDown();
            } else if (keyCode == rotateKey) {
                RotateTetromino();
            } else if (keyCode == hardDropKey) {
                hardDrop();
            } else if (keyCode == KeyEvent.VK_P) {
                togglePause();
            } else if (keyCode == holdKey) {
                HoldTheTetromino();
            }

        }
    }

}
