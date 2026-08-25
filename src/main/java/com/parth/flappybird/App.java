
/**
 * Hello world!
 *
 */
package com.parth.flappybird;

import javax.swing.JFrame;

public class App {

    public static void main(String[] args) {

        JFrame window = new JFrame("Flappy Bird");

        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
