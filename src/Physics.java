import entities.EntityFriendly;
import entities.EntityEnemy;

import java.util.LinkedList;

public class Physics {

    public static boolean Collision(EntityFriendly entityFriendly, LinkedList<EntityEnemy> entityEnemyList){
        for(int i = 0; i < entityEnemyList.size(); i++){
            if(entityFriendly.getBounds().intersects(entityEnemyList.get(i).getBounds()))
                return true;
        }

        return false;
    }
}
