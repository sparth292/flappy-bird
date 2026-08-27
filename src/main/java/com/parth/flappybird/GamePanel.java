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
    private Pipe pipe;
    private Pipe bottomPipe;
    public boolean gameOver = false;
    
    // GamePanel Constructor
    public GamePanel() {

    setFocusable(true);
    requestFocusInWindow();
    addKeyListener(this);

    pipe = new Pipe(700, 0, 200, 100);
    bottomPipe = new Pipe(700, 450, 400, 100);
    
    Timer timer = new Timer(16, e -> {

        if (gameOver) {
            return;
        }

        birdVelocity += gravity;
        birdY += birdVelocity;

        pipe.x -= 5;
        bottomPipe.x -= 5;
        // Reached ground
        if (birdY + birdHeight >= getHeight()) {

            birdY = getHeight() - birdHeight;
            birdVelocity = 0;

            gameOver = true;

            showGameOver();
        }

        // Reached ceiling
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
        
        //Bird's Color
        g.setColor(Color.BLACK); 
        g.drawRect(birdX, (int)birdY, birdWidth, birdHeight);

        //Pipe ka color
        g.setColor(Color.GREEN);
        g.fillRect(pipe.x, pipe.y, pipe.width, pipe.height);

        //Bottom Pipe Color
        g.setColor(Color.GREEN);
        g.fillRect(bottomPipe.x, bottomPipe.y, bottomPipe.width, bottomPipe.height);  
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
