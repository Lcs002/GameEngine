package handlers;

import handlers.primitives.GameObject;
import handlers.primitives.GameUI;

import java.awt.*;
import java.util.LinkedList;

public class GameUIHandler {
    private final LinkedList<GameUI> GAME_UI = new LinkedList<GameUI>();
    private final LinkedList<GameUI> QUEUE_ADD_GAME_UI = new LinkedList<GameUI>();
    private final LinkedList<GameUI> QUEUE_REMOVE_GAME_UI = new LinkedList<GameUI>();

    public void init() {
        for (GameUI gameUi : GAME_UI)
            gameUi.init();
    }

    public void tick(double deltaTime) {
        for (GameUI gameUi : GAME_UI)
            gameUi.tick(deltaTime);
    }

    public void render(Graphics g) {
        for (GameUI gameUi : GAME_UI)
            gameUi.render(g);
    }

    public void debug() {
        for (GameUI gameUi : GAME_UI)
            gameUi.debug();
    }

    public boolean queueAdd(GameUI gameUI) {
        return QUEUE_ADD_GAME_UI.add(gameUI);
    }

    public boolean queueRemove(GameUI gameUI) {
        return QUEUE_REMOVE_GAME_UI.remove(gameUI);
    }

    private void queuedAdd() {

    }

    private void queuedRemove() {

    }
}
