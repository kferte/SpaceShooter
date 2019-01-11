import java.awt.*;

class Menu {

    private Rectangle playBtn = new Rectangle(440, 300, 100, 50);
    private Rectangle helpBtn = new Rectangle(440, 400, 100, 50);
    private Rectangle quitBtn = new Rectangle(440, 500, 100, 50);

    void render(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        Font font = new Font("arial", Font.BOLD, 50);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString("Space Shooter", 320, 200);

        Font font1 = new Font("arial", Font.BOLD, 30);
        g.setFont(font1);
        g.drawString("Play", playBtn.x + 20, playBtn.y + 35);
        g.drawString("Help", helpBtn.x + 20, helpBtn.y + 35);
        g.drawString("Quit", quitBtn.x + 20, quitBtn.y + 35);
        g2d.draw(playBtn);
        g2d.draw(helpBtn);
        g2d.draw(quitBtn);
    }
}
