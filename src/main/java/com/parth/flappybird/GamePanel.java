//package statements
package com.parth.flappybird;

//import statements
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

//Timer Import
import javax.swing.Timer;

//Event Import
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

public class GamePanel extends JPanel implements KeyListener{
    private int birdX = 400;
    private double birdY = 300;
    private int birdWidth = 40;
    private int birdHeight = 40;
    private double birdVelocity = 0;
    private double gravity = 0.5;
    public boolean gameOver = false;
    // GamePanel Constructor
    public GamePanel(){

        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(this);
        Timer timer = new Timer(16 , e -> {
                
            
                birdVelocity += gravity;
                birdY += birdVelocity;

                System.out.println("Panel Height: " + getHeight() + " Bird Y: " + birdY);
                if (birdY + birdHeight >= getHeight()) {
                    if (gameOver) {
                        return;
                    }
                    birdY = getHeight() - birdHeight;
                    birdVelocity = 0;

                    

                    showGameOver();
                } // reaches ground
                if (birdY + birdHeight >= getHeight()) {
                    birdY = getHeight() - birdHeight;
                    birdVelocity = 0;
                }   
                if (birdY <= 0) {
                    birdY = 0;
                    birdVelocity = 0;
                }
                repaint();
        });
        timer.start();
    }

    // Bird's Rectangle
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK); 
        g.drawRect(birdX, (int)birdY, birdWidth, birdHeight);
          
    }    

    // Bird's Flap
    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            birdVelocity = -10;
        }
    }

    //Random Kid
    @Override
    public void keyReleased(KeyEvent arg0) {
    }

    //Random Kid
    @Override
    public void keyTyped(KeyEvent arg0) {
    }
    private void startNewGame() {
        birdX = 400;
        birdY = 300;
        birdVelocity = 0;
        gameOver = false;
    }
    private void showGameOver() {

    int choice = JOptionPane.showOptionDialog(
        this,
        "Game Over!",
        "Flappy Bird",
        JOptionPane.DEFAULT_OPTION,
        JOptionPane.INFORMATION_MESSAGE,
        null,
        new String[]{"Start New", "Exit"},
        "Start New"
    );

    if (choice == 0) {
        startNewGame();
    } else {
        System.exit(0);
    }
}
}
