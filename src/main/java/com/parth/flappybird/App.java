
package com.parth.flappybird;

import javax.swing.JFrame;

public class App {

    public static void main(String[] args) {
        JFrame gameWindow = new JFrame("Flappy Bird");

        gameWindow.setSize(900,700);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setVisible(true);
        
    }
}
