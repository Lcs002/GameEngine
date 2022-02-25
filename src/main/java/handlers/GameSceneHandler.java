package handlers;

import core.Game;
import handlers.primitives.GameScene;

import java.awt.*;
import java.util.LinkedList;

public class GameSceneHandler {
    private static GameSceneHandler gameSceneHandler = null;
    private final LinkedList<GameScene> GAME_SCENES = new LinkedList<GameScene>();
    private GameScene currentScene = null;
    public GameScene startingScene = null;
    private boolean inDebug = true;

    public static GameSceneHandler getInstance() {
        if (gameSceneHandler == null)
            gameSceneHandler = new GameSceneHandler();
        return gameSceneHandler;
    }

    public void init() {
        currentScene = startingScene;
        currentScene.init();
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
        if (currentScene != null) {
            currentScene.debug();
            if (inDebug) {
                System.out.printf("\nCurrent Scene is : " + currentScene.getName());
            }
        } else if (inDebug){
            System.out.printf("\nCurrent Scene is 'null' :: ");
            if (startingScene == null) {
                System.out.printf("'startingScene' not initialized");
            } else {
                System.out.printf("Scene error");
            }
        }
    }

    public GameScene getCurrentScene() {
        return this.currentScene;
    }

    // Must be called from Main, else errors will problably ocurr
    public void setStartingScene(GameScene scene) {
        startingScene = scene;
    }

    public boolean isInDebug() {
        return inDebug;
    }

    public void setInDebug(boolean inDebug) {
        this.inDebug = inDebug;
    }
}
