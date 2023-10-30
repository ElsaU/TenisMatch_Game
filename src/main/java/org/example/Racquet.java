package org.example;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Racquet {
    private static final int WIDTH = 10;
    private static final int HEIGHT = 80;
    private int x;
    private int y = 180;
    private int yd = 0;
    Game game;

    public Racquet(Game game, int x){
        this.game = game;
        this.x = x;
    }
    public void paint(Graphics2D g){
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

    public void move(){
        if (y + yd + HEIGHT < game.getHeight() && y + yd > 0){
            y = y + yd;
        }
    }

    public void keyPressed(KeyEvent e, int n){
        if (n == 1) {
            if (e.getKeyCode() == KeyEvent.VK_W) {
                yd = -1;
            } else if (e.getKeyCode() == KeyEvent.VK_S) {
                yd = 1;
            }
        }else if (n == 2){
            if (e.getKeyCode() == KeyEvent.VK_UP){
                yd = -1;
            }else if (e.getKeyCode() == KeyEvent.VK_DOWN){
                yd = 1;
            }
        }
    }

    public void keyRelease(KeyEvent e, int n){
        if (n == 1) {
            if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S) {
                yd = 0;
            }
        }else if (n == 2){
            if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN){
                yd = 0;
            }
        }
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }
}
