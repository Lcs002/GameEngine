package handlers;

import handlers.primitives.GameObject;
import utils.Console;

import java.awt.*;
import java.util.LinkedList;

public class GameObjectHandler {
    private final LinkedList<GameObject> GAME_OBJECTS = new LinkedList<GameObject>();
    private final LinkedList<GameObject> QUEUE_ADD_GAME_OBJECTS = new LinkedList<GameObject>();
    private final LinkedList<GameObject> QUEUE_REMOVE_GAME_OBJECTS = new LinkedList<GameObject>();

    public void init() {
        Console.getInstance().showMethodState(this.getClass(), "init", Console.METHOD_STATE.START);
        for (GameObject gameObject : GAME_OBJECTS)
            gameObject.init();
        Console.getInstance().showMethodState(this.getClass(), "init", Console.METHOD_STATE.END);
    }

    public void tick(double deltaTime) {
        for (GameObject gameObject : GAME_OBJECTS)
            gameObject.tick(deltaTime);
    }

    public void render(Graphics g) {
        for (GameObject gameObject : GAME_OBJECTS)
            gameObject.render(g);
    }

    public void debug() {
        for (GameObject gameObject : GAME_OBJECTS)
            gameObject.debug();
    }

    public boolean queueAdd(GameObject gameObject) {
        return QUEUE_ADD_GAME_OBJECTS.add(gameObject);
    }

    public boolean queueRemove(GameObject gameObject) {
        return QUEUE_REMOVE_GAME_OBJECTS.remove(gameObject);
    }

    private void queuedAdd() {

    }

    private void queuedRemove() {

    }
}
