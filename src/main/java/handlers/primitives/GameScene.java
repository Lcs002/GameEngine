package handlers.primitives;

import handlers.GameObjectHandler;
import handlers.GameUIHandler;

import java.awt.*;

public class GameScene {
    private final GameObjectHandler GAME_OBJECT_HANDLER = new GameObjectHandler();
    private final GameUIHandler UI_HANDLER = new GameUIHandler();

    public void tick(double deltaTime) {
        GAME_OBJECT_HANDLER.tick(deltaTime);
        UI_HANDLER.tick(deltaTime);
    }

    public void render(Graphics g) {
        GAME_OBJECT_HANDLER.render(g);
        UI_HANDLER.render(g);
    }

    public void debug() {
        GAME_OBJECT_HANDLER.debug();
        UI_HANDLER.debug();
    }
}
