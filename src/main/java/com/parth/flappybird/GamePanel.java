//package statements
package com.parth.flappybird;

//import statements
import javax.swing.JPanel;
import java.awt.Graphics;

//Timer Import
import javax.swing.Timer;

//Event Import
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener{
    private int birdX = 400;
    private int birdY = 300;
    private int birdWidth = 40;
    private int birdHeight = 30;
    private double birdVelocity = 0;
    private double gravity = 0.5;

    public GamePanel(){

        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(this);
        Timer timer = new Timer(16 , e -> {
                birdVelocity += gravity;
                birdY += birdVelocity;

                repaint();
        });
        timer.start();
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawRect(birdX, birdY, birdWidth, birdHeight);    
    }    

    // Bird's Flap
    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            birdVelocity = -10;
        }
    }
    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }
}
