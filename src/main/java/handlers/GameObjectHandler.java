package handlers;

import handlers.primitives.GameObject;

import java.awt.*;
import java.util.LinkedList;

public class GameObjectHandler {
    private final LinkedList<GameObject> GameOBJECTS = new LinkedList<GameObject>();
    private final LinkedList<GameObject> QUEUE_ADD_Game_OBJECTS = new LinkedList<GameObject>();
    private final LinkedList<GameObject> QUEUE_REMOVE_Game_OBJECTS = new LinkedList<GameObject>();

    public void tick(double deltaTime) {

    }

    public void render(Graphics g) {

    }

    public void debug() {

    }

    public void queueAdd(GameObject gameObject) {
        QUEUE_ADD_Game_OBJECTS.add(gameObject);
    }

    private void queuedAdd() {

    }

    public void queueRemove(GameObject gameObject) {
        QUEUE_REMOVE_Game_OBJECTS.remove(gameObject);
    }

    private void queuedRemove() {

    }
}
