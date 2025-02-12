package UserInterface.game;

import java.util.Random;
import java.awt.Color;
import java.awt.Graphics2D;

import java.util.function.BiPredicate;

public class tetromino {

    public int getNextPiece() {
        return nextPiece;
    }

    public void setNextPiece(int nextPiece) {
        this.nextPiece = nextPiece;
    }

    public int getCurrentPiece() {
        return currentPiece;
    }

    private final Random random = new Random();
    private int nextPiece;
    private int currentPiece;
    private int currentRotation;
    private int posX = 0;
    private int posY = 0;
    private int holderOriginalPosX;
    private int holderOriginalPosY;
    private int GhostPosX = 0;
    private int GhostPosY = 0;

    public Color tetroColors[] = {Color.yellow, Color.cyan, Color.magenta, new Color(255, 165, 0), Color.blue,
        Color.green, Color.red

    };
    private grid grd;

    // 4d array pieces[layer][row][col][depth]
    private final static int tetro[][][][] = {
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

    public tetromino(grid gd, int piece) {
        this.grd = gd;
        this.currentRotation = 0;
        this.currentPiece = piece;
        this.posX = grd.getGrid_Width() / 2;
        this.posY = 0;
    }

    public void setCurrentPiece(int currentPiece) {
        this.currentPiece = currentPiece;
    }

    public void drawGhostPiece(Graphics2D g2d){
  
    
    }

  

    public void rotate() {
        currentRotation = (1 + currentRotation) % 4;
    }

    public int[][] getCurrentTetrominoShape() {
        return tetro[getCurrentPiece()][currentRotation];
    }

    public void setRandomNextPiece() {
        currentPiece = nextPiece;
        int randomPiece = random.nextInt(7);
        nextPiece = randomPiece;
    }

}
