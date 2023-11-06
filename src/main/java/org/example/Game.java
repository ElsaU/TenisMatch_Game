package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JPanel {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 500;
    Ball ball = new Ball(this);
    Racquet racquet1 = new Racquet(this, 20);
    Racquet racquet2 = new Racquet(this, 750);

    private int score1 = 0;
    private int score2 = 0;
    private int speed = 1;

    public Game(){
        JOptionPane.showMessageDialog(this, "¿Preparados?");

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
        frame.setLocationRelativeTo(null);
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

        graphics.setFont(new Font("Verdana", Font.BOLD, 30));
        graphics.drawString(String.valueOf(score1), 10, 30);

        graphics.setFont(new Font("Verdana", Font.BOLD, 30));
        graphics.drawString(String.valueOf(score2), this.getWidth()-30, 30);
    }

    public void move(){
        ball.move();
        racquet1.move();
        racquet2.move();
    }

    public void setScore(int player){
        if (player == 1){
            score1++;
        }else if (player == 2){
            score2++;
        }
    }

    public int getScore(int player){
        int score = 0;
        if (player == 1){
            score = score1;
        }else if(player == 2){
            score = score2;
        }
        return score;
    }

    public void upgradeSpeed(){
        speed++;
    }

    public int getSpeed(){
        return speed;
    }

    public void restartSpeed(){
        speed = 1;
    }

    public void gameOver(int player) {
        int n;
        if (player == 1){
            n = 1;
        }else {
            n = 2;
        }
        JOptionPane.showMessageDialog(this, "¡Fin de la partida! Ha ganado el jugador " + n);
        System.exit(ABORT);
    }
}