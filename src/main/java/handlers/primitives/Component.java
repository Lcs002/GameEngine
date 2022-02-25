package handlers.primitives;

import java.awt.*;

public class Component {
    private GameElement owner = null;

    // ======================= Getters and Setters

    public void setOwner(GameElement owner) {
        this.owner = owner;
    }

    public GameElement getOwner() {
        return owner;
    }

    // ======================= Overrideable

    public void init() {

    }

    public void tick(double deltaTime) {

    }

    public void render(Graphics g) {

    }

    public void debug() {

    }
}
