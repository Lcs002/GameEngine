package handlers.primitives;

import handlers.GameObjectHandler;
import handlers.GameUIHandler;

import java.awt.*;

public class GameScene {
    private final GameObjectHandler GAME_OBJECT_HANDLER = new GameObjectHandler();
    private final GameUIHandler GAME_UI_HANDLER = new GameUIHandler();
    private String name = "Unnamed.scn";

    // =========================== Getters and Setters

    public void setName(String name) {
        this.name = name;
    }

    public String getName () {
        return this.name;
    }

    // =========================== Functionality and Overrideable

    public void init() {
        GAME_OBJECT_HANDLER.init();
        GAME_UI_HANDLER.init();
    }

    public void tick(double deltaTime) {
        GAME_OBJECT_HANDLER.tick(deltaTime);
        GAME_UI_HANDLER.tick(deltaTime);
    }

    public void render(Graphics g) {
        GAME_OBJECT_HANDLER.render(g);
        GAME_UI_HANDLER.render(g);
    }

    public void debug() {
        GAME_OBJECT_HANDLER.debug();
        GAME_UI_HANDLER.debug();
    }

    // =========================== GameElement Management in Scene

    protected boolean add(GameObject gameObject) {
        return this.GAME_OBJECT_HANDLER.queueAdd(gameObject);
    }

    protected boolean add(GameUI gameUI) {
        return this.GAME_UI_HANDLER.queueAdd(gameUI);
    }

    protected boolean remove(GameObject gameObject) {
        return this.GAME_OBJECT_HANDLER.queueRemove(gameObject);
    }

    protected boolean remove(GameUI gameUI) {
        return this.GAME_UI_HANDLER.queueRemove(gameUI);
    }

}
