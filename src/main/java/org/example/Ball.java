package org.example;

import java.awt.*;

public class Ball {
    private static final int DIAMETER = 20;

    private int x = 0;
    private int y = 0;
    private int xd = 1;
    private int yd = -1;

    Game game;

    public Ball(Game game){
        this.game = game;
    }

    public void paint(Graphics2D g){
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }

    public void move(){
        x = x + xd;
        y = y + yd;

        if (y + DIAMETER > game.getHeight()){
            yd = -1;
        }else if (y < 0){
            yd = 1;
        }
        if (collision1()){
            xd = 1;
        }else if (collision2()){
            xd = -1;
        }
    }

    private Boolean collision1(){
        return game.racquet1.getBounds().intersects(getBounds());
    }

    private Boolean collision2(){
        return game.racquet2.getBounds().intersects(getBounds());
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
}
