import entities.EntityFriendly;

import java.awt.*;

public class Player extends GameObject implements EntityFriendly {

    private double velX = 0;
    private double velY = 0;
    private Textures tex;

    public Player(double x, double y, Textures tex){
        super(x, y);
        this.tex = tex;
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
