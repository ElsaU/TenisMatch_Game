package org.example;

import java.awt.*;

public class Ball {
    private static final int DIAMETER = 20;

    private int x = 0;
    private int y = 0;
    private int xd = 1;
    private int yd = -1;
    private int nCollisions = 0;

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
            yd = -1 * game.getSpeed();
        }else if (y < 0){
            yd = 1 * game.getSpeed();
        }
        if (collision1()){
            nCollisions++;
            if (nCollisions%5 == 0){
                game.upgradeSpeed();
            }
            xd = 1 * game.getSpeed();
        }else if (collision2()){
            nCollisions++;
            if (nCollisions%5 == 0){
                game.upgradeSpeed();
            }
            xd = -1 * game.getSpeed();
        }

        if (x >= game.getWidth()){
            game.setScore(1);
            restart();
        }else if (x <= 0){
            game.setScore(2);
            restart();
        }

        if (game.getScore(1) == 10){
            game.gameOver(1);
        }else if (game.getScore(2) == 10){
            game.gameOver(2);
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

    public void restart(){
        x = game.getWidth()/2;
        y = (int) (Math.random()*game.getHeight())+1;

        int array[] = {-1, 1};
        int randomX = (int) (Math.random()*2);
        int randomY = (int) (Math.random()*2);
        xd = array[randomX];
        yd = array[randomY];

        nCollisions = 0;
        game.restartSpeed();
    }
}
