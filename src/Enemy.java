import entities.EntityEnemy;

import java.awt.*;
import java.util.Random;

public class Enemy extends GameObject implements EntityEnemy {

    private Textures tex;
    private Game game;
    private Controller c;
    private Random rnd = new Random();

    private int speed = rnd.nextInt(3) + 1;

    public Enemy(double x, double y, Textures tex, Controller c, Game game){
        super(x, y);
        this.tex = tex;
        this.c = c;
        this.game = game;
    }

    public void tick(){
        y += speed;
        if(y > Game.HEIGHT * Game.SCALE) {
            x = rnd.nextInt(960);
            y = -10;
        }

        if(Physics.Collision(this, game.friends)){
            c.removeEntity(this);
            game.setEnemyKilled(game.getEnemyKilled() + 1);
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
