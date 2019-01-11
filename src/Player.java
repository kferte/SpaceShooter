import entities.EntityEnemy;
import entities.EntityFriendly;

import java.awt.*;

public class Player extends GameObject implements EntityFriendly {

    private double velX = 0;
    private double velY = 0;
    private Textures tex;
    private Game game;
    private Controller c;

    public Player(double x, double y, Textures tex, Game game, Controller c){
        super(x, y);
        this.tex = tex;
        this.game = game;
        this.c = c;
    }

    public void tick(){
        x += velX;
        y += velY;

        if(x <= 0)
            x = 0;
        if(x >= 960 - 22)
            x = 960 - 22;
        if(y <= 0)
            y = 0;
        if(y >= 720 - 25)
            y = 720 - 25;

        for(int i = 0; i < game.enemies.size(); i++){
            EntityEnemy tempEnt = game.enemies.get(i);
            if(Physics.Collision(this, tempEnt)){
                c.removeEntity(tempEnt);
                game.setEnemyKilled(game.getEnemyKilled() + 1);
                game.health -= 10;
            }
        }
    }

    public void render(Graphics g){
        g.drawImage(tex.player, (int)x, (int)y, null);
    }

    public Rectangle getBounds(){
        return new Rectangle((int) x, (int) y, 32, 32);
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public void setVelX(double velX){
        this.velX = velX;
    }

    public void setVelY(double velY){
        this.velY = velY;
    }
}
