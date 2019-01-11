package entities;

import java.awt.*;

public interface EntityEnemy {

    void tick();
    void render(Graphics g);
    Rectangle getBounds();
}
