package handlers.primitives;

import utils.Vector2;

import java.awt.*;
import java.util.LinkedList;

// TODO REFACTOR EVERYTHING BELOW
public class GameObject {
    protected LinkedList<ID> id = new LinkedList<ID>();
    public Vector2 pos = new Vector2(0, 0);
    public int radius = 10;

    public GameObject(){}

    public GameObject(int x, int y) {
        this.pos.x = x;
        this.pos.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void tick() {

    }

    public void render(Graphics g) {

    }

    public void onCollide(GameObject gameObject) {

    }

    public boolean hasID(ID id) {
        for (ID i : this.id)
            if (i == id)
                return true;
        return false;
    }

    enum ID {
        Damageable,
        Static,
        Enemy,
        Ghost
    }
}
