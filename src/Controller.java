import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class Controller {

    private LinkedList<Entity> e = new LinkedList<Entity>();

    Entity entity;
    private Textures tex;
    Random rnd = new Random();

    public Controller(Textures tex){
        this.tex = tex;
    }

    public void createEnemy(int enemyCount){
        for(int i = 0; i < enemyCount; i++){
            addEntity(new Enemy(rnd.nextInt(960), -10, tex));
        }
    }

    public void tick(){
        for(int i = 0; i < e.size(); i++){
            entity = e.get(i);
            entity.tick();
        }
    }

    public void render(Graphics g){
        for(int i = 0; i < e.size(); i++){
            entity = e.get(i);
            entity.render(g);
        }
    }

    public void addEntity(Entity temp){
        e.add(temp);
    }

    public void removeEntity(Entity temp){
        e.remove(temp);
    }
}
