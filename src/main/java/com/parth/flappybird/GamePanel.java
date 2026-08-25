//package statements
package com.parth.flappybird;

//import statements
import javax.swing.JPanel;
import java.awt.Graphics;

//Timer Import
import javax.swing.Timer;

public class GamePanel extends JPanel{
    private int birdX = 400;
    private int birdY = 300;
    private int birdWidth = 40;
    private int birdHeight = 30;
    private double birdVelocity = 0;
    private double gravity = 0.5;

    public GamePanel(){
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
}
