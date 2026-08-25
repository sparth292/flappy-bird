//package statements
package com.parth.flappybird;

//import statements
import javax.swing.JPanel;
import java.awt.Graphics;

public class GamePanel extends JPanel{
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawString("Flappy Bird" , 100 , 100);    
    }    
}
