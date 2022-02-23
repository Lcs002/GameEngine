package handlers;

import utils.Vector2;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter {
    private Vector2 mousePosition = new Vector2(0, 0);

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.mousePosition.x = e.getX();
        this.mousePosition.y = e.getY();
    }

    // Returns the mouse position on the screen
    public Vector2 getMousePosition() {
        return this.mousePosition;
    }

}
