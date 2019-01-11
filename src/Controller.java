import entities.EntityFriendly;
import entities.EntityEnemy;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

class Controller {

    private LinkedList<EntityFriendly> friends = new LinkedList<>();
    private LinkedList<EntityEnemy> enemies = new LinkedList<>();

    private EntityFriendly entityFriendly;
    private EntityEnemy entityEnemy;
    private Textures tex;
    private Game game;
    private Random rnd = new Random();

    Controller(Textures tex, Game game){
        this.tex = tex;
        this.game = game;
    }

    void createEnemy(int enemyCount){
        for(int i = 0; i < enemyCount; i++){
            addEntity(new Enemy(rnd.nextInt(960), -10, tex, this, game));
        }
    }

    void tick(){
        for (EntityFriendly friend : friends) {
            entityFriendly = friend;
            entityFriendly.tick();
        }
        for (EntityEnemy enemy : enemies) {
            entityEnemy = enemy;
            entityEnemy.tick();
        }
    }

    void render(Graphics g){
        for (EntityFriendly friend : friends) {
            entityFriendly = friend;
            entityFriendly.render(g);
        }
        for (EntityEnemy enemy : enemies) {
            entityEnemy = enemy;
            entityEnemy.render(g);
        }
    }

    void addEntity(EntityFriendly temp){
        friends.add(temp);
    }

    void removeEntity(EntityFriendly temp){
        friends.remove(temp);
    }

    private void addEntity(EntityEnemy temp){
        enemies.add(temp);
    }

    void removeEntity(EntityEnemy temp){
        enemies.remove(temp);
    }

    LinkedList<EntityFriendly> getEntityFriendly(){
        return friends;
    }

    LinkedList<EntityEnemy> getEntityEnemy(){
        return enemies;
    }
}
