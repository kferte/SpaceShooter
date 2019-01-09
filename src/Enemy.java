import entities.EntityEnemy;

import java.awt.*;
import java.util.Random;

public class Enemy extends GameObject implements EntityEnemy {

    private Textures tex;
    private Random rnd = new Random();

    private int speed = rnd.nextInt(3) + 1;

    public Enemy(double x, double y, Textures tex){
        super(x, y);
        this.tex = tex;
    }

    public void tick(){
        y += speed;
        if(y > Game.HEIGHT * Game.SCALE) {
            x = rnd.nextInt(960);
            y = -10;
        }
    }

    public void render(Graphics g){
        g.drawImage(tex.enemy, (int) x, (int) y, null);
    }

    public Rectangle getBounds(){
        return new Rectangle((int) x, (int) y, 32, 32);
    }

    @Override
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
