package core;

import handlers.GameSceneHandler;
import handlers.InputHandler;
import handlers.MouseHandler;
import utils.Console;

import javax.swing.*;
import java.awt.*;

public class Display extends JFrame {

    public Display(int width, int height, String title, Game game) {
        Console.getInstance().showMethodState(this.getClass(), "Display", Console.METHOD_STATE.CREATED);
        this.setTitle(title);
        this.setSize(width, height);
        this.setBackground(Color.BLACK);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(game);
        this.setVisible(true);
        game.start();
    }

}
