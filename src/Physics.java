import entities.EntityFriendly;
import entities.EntityEnemy;

import java.util.LinkedList;

public class Physics {

    public static boolean Collision(EntityFriendly entityFriendly, EntityEnemy entityEnemy){
        if(entityFriendly.getBounds().intersects(entityEnemy.getBounds()))
            return true;

        return false;
    }

    public static boolean Collision(EntityEnemy entityEnemy, EntityFriendly entityFriend){
        if(entityEnemy.getBounds().intersects(entityFriend.getBounds()))
            return true;

        return false;
    }
}
