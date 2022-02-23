package core;

import handlers.GameSceneHandler;
import handlers.InputHandler;
import handlers.MouseHandler;

import javax.swing.*;
import java.awt.*;

public class Display extends JFrame {

    public Display(int width, int height, String title, Game game) {
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
