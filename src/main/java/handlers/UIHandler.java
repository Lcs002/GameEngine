package handlers;

import handlers.primitives.UI;

import java.awt.*;
import java.util.LinkedList;

public class UIHandler {
    private final LinkedList<UI> UI = new LinkedList<UI>();

    public void tick(double deltaTime) {
        for (UI ui : UI)
            ui.tick(deltaTime);

    }

    public void render(Graphics g) {
        for (UI ui : UI)
            ui.render(g);
    }

    public void debug() {
        for (UI ui : UI)
            ui.debug();
    }
}
