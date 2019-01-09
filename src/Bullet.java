import entities.EntityFriendly;

import java.awt.*;

public class Bullet extends GameObject implements EntityFriendly {

    private Textures tex;
    private Game game;

    public Bullet(double x, double y, Textures tex, Game game){
        super(x, y);
        this.tex = tex;
        this.game = game;
    }

    public void tick(){
        y -= 10;
    }

    public void render(Graphics g){
        g.drawImage(tex.missile, (int) x, (int) y, null);
    }

    public Rectangle getBounds(){
        return new Rectangle((int) x + 15, (int) y, 2, 32);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
