package handlers;

import handlers.primitives.GameUI;

import java.awt.*;
import java.util.LinkedList;

public class GameUIHandler {
    private final LinkedList<GameUI> GameUI = new LinkedList<GameUI>();

    public void tick(double deltaTime) {
        for (GameUI gameUi : GameUI)
            gameUi.tick(deltaTime);

    }

    public void render(Graphics g) {
        for (GameUI gameUi : GameUI)
            gameUi.render(g);
    }

    public void debug() {
        for (GameUI gameUi : GameUI)
            gameUi.debug();
    }
}
