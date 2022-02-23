package handlers;

import core.Game;
import handlers.primitives.GameScene;

import java.awt.*;
import java.util.LinkedList;

public class GameSceneHandler {
    private final LinkedList<GameScene> GAME_SCENES = new LinkedList<GameScene>();
    private GameScene currentScene = null;
    public GameScene startingScene = null;

    public void init() {
        currentScene = startingScene;
    }

    public void tick(double deltaTime) {
        if (currentScene != null)
            currentScene.tick(deltaTime);
    }

    public void render(Graphics g) {
        if (currentScene != null)
            currentScene.render(g);
    }

    public void debug() {
        if (currentScene != null)
            currentScene.debug();
    }

    public GameScene getCurrentScene() {
        return this.currentScene;
    }

    // Must be called from Main, else errors will problably ocurr
    public void setStartingScene(GameScene scene) {
        startingScene = scene;
    }
}
