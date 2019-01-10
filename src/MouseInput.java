import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getX() >= 440 && e.getX() <= 540 ) {
            if (e.getY() >= 300 && e.getY() <= 350)
                Game.state = Game.STATE.GAME;
            if (e.getY() >= 400 && e.getY() <= 450)
                System.out.println("HELP!");
            if (e.getY() >= 500 && e.getY() <= 550)
                System.exit(0);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
