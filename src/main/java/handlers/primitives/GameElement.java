package handlers.primitives;

import utils.Console;
import utils.Vector2;

import java.awt.*;
import java.util.LinkedList;

public class GameElement {

    // ================================== Variables

    private LinkedList<ID> ids = new LinkedList<ID>();
    private LinkedList<Component> components = new LinkedList<Component>();
    private LinkedList<GameElement> children = new LinkedList<GameElement>();
    private GameElement parent = null;
    private Vector2 position = new Vector2(0, 0);

    // ================================== Setters and Getters

    public boolean addID(ID id) {
        return this.ids.add(id);
    }

    public boolean removeID(ID id) {
        return this.ids.remove(id);
    }

    public LinkedList<ID> getIds() {
        return this.ids;
    }

    public boolean addComponent(Component component) {
        return this.components.add(component);
    }

    public boolean removeComponent(Component component) {
        return this.components.remove(component);
    }

    public boolean addChild(GameElement element) {
        return this.children.add(element);
    }

    public boolean removeChild(GameElement element) {
        return this.children.remove(children);
    }

    public LinkedList<GameElement> getChildren() {
        return this.children;
    }

    public void setParent(GameElement element) {
        this.parent = element;
    }

    public GameElement getParent(GameElement element) {
        return this.parent;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void setPosition(float x, float y) {
        this.position = new Vector2(x, y);
    }

    public Vector2 getPosition() {
        return this.position;
    }

    public Vector2 getRelativePosition() {
        if (this.parent != null)
            return Vector2.sum(this.parent.position, this.position.mult(-1));
        else return this.position;
    }

    // ================================== Overrideable

    public void init() {
        for (Component component : components)
            component.init();
        for (GameElement child : children)
            child.init();
    }

    public void tick(double deltaTime) {
        for (Component component : components)
            component.tick(deltaTime);
        for (GameElement child : children)
            child.tick(deltaTime);
    }

    public void render(Graphics g) {
        for (Component component : components)
            component.render(g);
        for (GameElement child : children)
            child.render(g);
    }

    public void debug() {
        for (Component component : components)
            component.debug();
        for (GameElement child : children)
            child.debug();
    }

    // ================================== Others

    public boolean hasID(ID id) {
        for (ID i : this.ids)
            if (i == id)
                return true;
        return false;
    }

    public <T extends Component> T getComponent(Class<T> component) {
        for (Component c : components) {
            if (component.isAssignableFrom(c.getClass())) {
                try { return component.cast(c); }
                catch (ClassCastException exception) {
                    exception.printStackTrace();
                    assert false : "Error :: Could not cast Component ( " + Component.class + " )";
                }
            }
        }
        return null;
    }

    // ================================== ID ENUM
    enum ID {
        DAMAGEABLE,
        STATIC
    }
}
