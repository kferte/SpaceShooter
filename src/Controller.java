import entities.EntityFriendly;
import entities.EntityEnemy;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class Controller {

    private LinkedList<EntityFriendly> friends = new LinkedList<EntityFriendly>();
    private LinkedList<EntityEnemy> enemies = new LinkedList<EntityEnemy>();

    EntityFriendly entityFriendly;
    EntityEnemy entityEnemy;
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
        //A Class
        for(int i = 0; i < friends.size(); i++){
            entityFriendly = friends.get(i);
            entityFriendly.tick();
        }
        //B Class
        for(int i = 0; i < enemies.size(); i++){
            entityEnemy = enemies.get(i);
            entityEnemy.tick();
        }
    }

    public void render(Graphics g){
        //A Class
        for(int i = 0; i < friends.size(); i++){
            entityFriendly = friends.get(i);
            entityFriendly.render(g);
        }
        //B Class
        for(int i = 0; i < enemies.size(); i++){
            entityEnemy = enemies.get(i);
            entityEnemy.render(g);
        }
    }

    public void addEntity(EntityFriendly temp){
        friends.add(temp);
    }

    public void removeEntity(EntityFriendly temp){
        friends.remove(temp);
    }

    public void addEntity(EntityEnemy temp){
        enemies.add(temp);
    }

    public void removeEntity(EntityEnemy temp){
        enemies.remove(temp);
    }

    public LinkedList<EntityFriendly> getEntityFriendly(){
        return friends;
    }

    public LinkedList<EntityEnemy> getEntityEnemy(){
        return enemies;
    }
}
