/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Tetromino;

import java.awt.Color;

public class Tetromino {

    private Color color;
    private int tetromino[][];
    private int posX;
    private int posY;
    private int[][][] TetrominoRotatedState;
    private int CurrentRotation;

    public Tetromino(int shape[][], Color color) {
        tetromino = shape;
        this.color = color;
        this.posX = 0;
        this.posY = 0;
        GenerateAllRotationState(shape);
    }

    /**
     * generate all the rotation state of the current tetromino
     *
     * @param initialShape an 2d array that store the current tetromino shape
     *
     */
    private void GenerateAllRotationState(int[][] initialShape) {

        //for the box shape cause there no rotation on that shape
        if (initialShape.length == 2 && initialShape[0].length == 2
                && initialShape[0][0] == 1 && initialShape[0][1] == 1
                && initialShape[1][0] == 1 && initialShape[1][1] == 1) {

            TetrominoRotatedState = new int[1][][];
            TetrominoRotatedState[0] = CopyArray(initialShape);
            return;
        }
        if (initialShape.length == 1 && initialShape[0].length == 4) {
            TetrominoRotatedState = new int[2][][];
            TetrominoRotatedState[0] = CopyArray(initialShape);

            TetrominoRotatedState[1] = new int[4][1];
            for (int i = 0; i < 4; i++) {
                TetrominoRotatedState[1][i][0] = 1;
            }
            return;
        }

        TetrominoRotatedState = new int[4][][];
        TetrominoRotatedState[0] = CopyArray(initialShape);//original tetromino shape
        TetrominoRotatedState[1] = rotateTetromino90Degree(TetrominoRotatedState[0]);//90 degree tetromino shape
        TetrominoRotatedState[2] = rotateTetromino90Degree(TetrominoRotatedState[1]);//180
        TetrominoRotatedState[3] = rotateTetromino90Degree(TetrominoRotatedState[2]);//270
    }

    /**
     * rotate the tetromino to 90 degree of it
     *
     * @param Array an 2d array that store the current tetromino shape
     * @return it just return of 2d int array
     */
    private int[][] rotateTetromino90Degree(int[][] tetromino) {
        int col = tetromino[0].length;
        int row = tetromino.length;
        int RotatedTetromino[][] = new int[col][row];

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                RotatedTetromino[c][row - 1 - r] = tetromino[r][c];
            }
        }

        return RotatedTetromino;
    }

    /**
     * a function that will copy the original shape of the shape cause of son of
     * the bitch java is the default thing in the parameter on the function is a
     * freaking sons of a god damn reference type
     *
     * @param 2DArray an 2d array the store the tetromino shape
     * @return it just return of 2d int array
     */
    private int[][] CopyArray(int[][] original) {

        if (original == null) {
            return null;
        }

        int[][] copy = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = new int[original[i].length];

            //use a system.arraycopy to not use nested loop for the copy 
            System.arraycopy(original[i], 0, copy[i], 0, original[i].length);
        }
        return copy;
    }

    /**
     * return the Current Rotation of the Current Tetromino Shape
     *
     * @return
     */
    public int getCurrentRotation() {
        return CurrentRotation;
    }

    /**
     * return the Current Rotation of the Current Tetromino Shape
     *
     * @param CurrentRotation
     */
    public void setCurrentRotation(int CurrentRotation) {
        this.CurrentRotation = CurrentRotation;
    }

    /**
     * return the current X Position of the Tetromino
     *
     * @return
     */
    public int getPosX() {
        return posX;
    }

    /**
     * return the current X Position of the Tetromino
     *
     * @param posX
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * return the current Y Position of the Tetromino
     *
     * @return
     */
    public int getPosY() {
        return posY;
    }

    /**
     * rotate the tetromino shape
     */
    public void RotateTetromino() {
        CurrentRotation = (1 + CurrentRotation) % TetrominoRotatedState.length;
    }

    /**
     * return the current Y Position of the Tetromino
     *
     * @param posY
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }

    /**
     * get the Color of the Tetromino
     *
     * @return return the current Tetromino Color
     */
    public Color getColor() {
        return color;
    }

    /**
     * set the current Colot of the Tetromino
     *
     * @param color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * get the tetromino shape
     *
     * @return return the 2d array value of the current Tetromino
     */
    public int[][] getTetromino() {
        return TetrominoRotatedState[CurrentRotation];
    }

    public int[][] getNextRotationState() {
        int nextRotation = (CurrentRotation + 1) % TetrominoRotatedState.length;
        return TetrominoRotatedState[nextRotation];
    }

    public void setTetromino(int[][] tetromino) {
        this.tetromino = tetromino;
        GenerateAllRotationState(tetromino);
        this.CurrentRotation = 0; 
    }

    public void updatePos(int x, int y) {
        posX += x;
        posY += y;
    }

    public int getTetrominoLenght() {
        return tetromino.length;
    }

    public int getTetrominoWidth() {
        return tetromino[0].length;
    }

}
