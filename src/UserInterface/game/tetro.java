/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserInterface.game;

import java.awt.Color;

public class tetro {

    public int[][] getTetromino() {
        return tetromino;
    }

    public Color getColor() {
        return color;
    }
    public int getTetrominoLength(){
        return tetromino.length;
    }
    public int getTetrominoWidth(){
        return tetromino[0].length;
    }
    public int getPosX(){
        return posX;
    }
    public int getPosY(){
        return posY;
    }
    public int gotBottomGrid(){
        return posY + getTetrominoLength();
    }
    private int posX ;
    private int posY;
    private int tetromino[][];
    private Color color;
    
    public tetro(int [][] tetro,Color color) {
        this.tetromino = tetro;
        this.color = color;
        posX = 3;
        posY = 3;
    }
   
    
    
   
}
