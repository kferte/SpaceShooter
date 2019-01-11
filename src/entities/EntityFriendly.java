package entities;

import java.awt.*;

public interface EntityFriendly {

    void tick();
    void render(Graphics g);
    Rectangle getBounds();

    double getX();
    double getY();
}
