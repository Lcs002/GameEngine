package handlers;
import handlers.primitives.GameObject;
import utils.Vector2;

import java.util.LinkedList;

// TODO REBUILD COLLISIONS FROM ZERO
public class CollisionHandler {
    LinkedList<Object> toCollide = new LinkedList<Object>();

    public void checkCollision() {
        LinkedList<GameObject> copy = (LinkedList) toCollide.clone();
        for (GameObject object : copy)
            for (GameObject other : copy) {
                //if (object != other)
                    //if (Vector2.directionTo(object.getPosition(), other.getPosition()).magnitude() <= object.radius + other.radius) {
                    //    object.onCollide(other);
                    //    other.onCollide(object);
                    //    toCollide.remove(object);
                    //    toCollide.remove(other);
                    //}
            }
    }
}
