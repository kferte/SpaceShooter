import entities.EntityFriendly;
import entities.EntityEnemy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;

public class Game extends Canvas implements Runnable{

    private static final int WIDTH = 480;
    static final int HEIGHT = WIDTH / 12 * 9;
    static final int SCALE = 2;
    private final String TITLE = "Space Shooter";

    private boolean running = false;
    private Thread thread;

    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private BufferedImage spriteSheet = null;
    private BufferedImage background = null;

    private boolean isShooting = false;

    private int enemyCount = 1;
    private int enemyKilled = 0;

    private Player p;
    private Controller c;
    private Textures tex;
    private Menu menu;

    LinkedList<EntityFriendly> friends;
    LinkedList<EntityEnemy> enemies;

    static int health = 100;

    public enum STATE{
        MENU, GAME
    }

    static STATE state = STATE.MENU;

    private void init(){
        requestFocus();
        BufferedImageLoader loader = new BufferedImageLoader();
        try{
            spriteSheet = loader.loadImage("/sprite_sheet.png");
            background = loader.loadImage("/background.png");
        }catch (IOException e){
            e.printStackTrace();
        }
        addKeyListener(new KeyInput(this));
        addMouseListener(new MouseInput());
        tex = new Textures(this);
        c = new Controller(tex, this);
        p = new Player(WIDTH - 16, 600, tex, this, c);
        menu = new Menu();

        friends = c.getEntityFriendly();
        enemies = c.getEntityEnemy();
        c.createEnemy(enemyCount);
    }

    private synchronized void start(){
        if(running)
            return;

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    private synchronized void stop(){
        if(!running)
            return;

        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(1);
    }

    @Override
    public void run() {
        init();
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();

        while (running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if(delta >= 1){
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println(updates + " Ticks, FPS " + frames);
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        if(state == STATE.GAME) {
            p.tick();
            c.tick();
        }

        if(enemyKilled >= enemyCount){
            enemyCount++;
            enemyKilled = 0;
            c.createEnemy(enemyCount);
        }
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        g.drawImage(background, 0, 0, null);

        if(state == STATE.GAME) {
            p.render(g);
            c.render(g);
            g.setColor(Color.GRAY);
            g.fillRect(5, 5, 200, 20);
            g.setColor(Color.RED);
            g.fillRect(5, 5, health * 2, 20 );
            if(health <= 0){
                Font font = new Font("arial", Font.BOLD, 100);
                g.setFont(font);
                g.setColor(Color.WHITE);
                g.drawString("GAME OVER!", 150, 400);
                p.setX(1000000000);
                p.setY(1000000000);
            }
        }else if(state == STATE.MENU){
            menu.render(g);
        }

        g.dispose();
        bs.show();
    }

    BufferedImage getSpriteSheet(){
        return spriteSheet;
    }

    int getEnemyKilled() {
        return enemyKilled;
    }

    void setEnemyKilled(int enemyKilled) {
        this.enemyKilled = enemyKilled;
    }

    void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        if(state == STATE.GAME) {
            if (key == KeyEvent.VK_RIGHT) {
                p.setVelX(5);
            } else if (key == KeyEvent.VK_LEFT) {
                p.setVelX(-5);
            } else if (key == KeyEvent.VK_UP) {
                p.setVelY(-5);
            } else if (key == KeyEvent.VK_DOWN) {
                p.setVelY(5);
            } else if (key == KeyEvent.VK_SPACE && !isShooting) {
                isShooting = true;
                c.addEntity(new Bullet(p.getX(), p.getY(), tex));
            }
        }
    }

    void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_RIGHT){
            p.setVelX(0);
        } else if(key == KeyEvent.VK_LEFT){
            p.setVelX(0);
        } else if(key == KeyEvent.VK_UP){
            p.setVelY(0);
        } else if(key == KeyEvent.VK_DOWN){
            p.setVelY(0);
        } else if(key == KeyEvent.VK_SPACE){
            isShooting = false;
        }
    }

    public static void main(String[] args) {
        Game game = new Game();

        game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

        JFrame frame = new JFrame(game.TITLE);
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        game.start();
    }
}
