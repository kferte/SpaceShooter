import entities.EntityFriendly;
import entities.EntityEnemy;

class Physics {

    static boolean Collision(EntityFriendly entityFriendly, EntityEnemy entityEnemy){
        return entityFriendly.getBounds().intersects(entityEnemy.getBounds());
    }

    static boolean Collision(EntityEnemy entityEnemy, EntityFriendly entityFriend){
        return entityEnemy.getBounds().intersects(entityFriend.getBounds());
    }
}
