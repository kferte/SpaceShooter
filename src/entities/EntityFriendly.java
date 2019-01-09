package entities;

import java.awt.*;

public interface EntityFriendly {

    public void tick();
    public void render(Graphics g);
    public Rectangle getBounds();

    public double getX();
    public double getY();
}
