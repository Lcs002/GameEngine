package handlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

public class InputHandler implements KeyListener {
    private LinkedList<Integer> keyPressed = new LinkedList<Integer>();

    // Not sure how keyTyped works
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!inList(keyPressed, e.getKeyCode()))
            keyPressed.add(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (inList(keyPressed, e.getKeyCode()))
            keyPressed.remove(getId(keyPressed, e.getKeyCode()));
    }

    private boolean inList(LinkedList<Integer> list, int value) {
        for (Integer integer : list) {
            if (integer == value)
                return true;
        }
        return false;
    }

    private int getId(LinkedList<Integer> list, int value) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == value)
                return i;
        }
        return -1;
    }

    // Checks for a key in the buffer and return whether it is pressed or not
    public boolean isKeyPressed(int key) {
        return this.inList(this.keyPressed, key);
    }

}
