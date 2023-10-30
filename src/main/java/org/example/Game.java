package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JPanel {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 500;
    Ball ball = new Ball(this);
    Racquet racquet1 = new Racquet(this, 20);
    Racquet racquet2 = new Racquet(this, 950);

    public Game(){
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                racquet1.keyPressed(e, 1);
                racquet2.keyPressed(e, 2);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                racquet1.keyRelease(e, 1);
                racquet2.keyRelease(e, 2);
            }
        });
        setFocusable(true);
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame();
        Game game = new Game();
        frame.add(game);
        frame.setSize(WIDTH,HEIGHT);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true){
            game.move();
            game.repaint();
            Thread.sleep(5);
        }
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D graphics = (Graphics2D) g;

        ball.paint(graphics);
        racquet1.paint(graphics);
        racquet2.paint(graphics);
    }

    public void move(){
        ball.move();
        racquet1.move();
        racquet2.move();
    }
}