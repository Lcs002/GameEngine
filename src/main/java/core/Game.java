package core;

import handlers.GameSceneHandler;
import handlers.InputHandler;
import handlers.MouseHandler;
import utils.Console;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 900;
    public static Display display;

    private Thread mainThread;
    private boolean isRunning = false;

    public Game() {
        this.display = new Display(WIDTH, HEIGHT, "TEST", this);
        this.addKeyListener(InputHandler.getInstance());
        this.addMouseListener(MouseHandler.getInstance());
        // Set Main Scene Here
        GameSceneHandler.getInstance().init();
    }

    public synchronized void start() {
        Console.getInstance().showMethodState(this.getClass(), "start");
        mainThread = new Thread(this);
        mainThread.start();
        isRunning = true;
    }

    public synchronized void stop() {
        try {
            Console.getInstance().showMethodState(this.getClass(), "stop");
            mainThread.join();
            isRunning = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0; // MAX TICKS
        double ticksNs = 1000000000/amountOfTicks;
        double ticksDelta = 0;
        long timer = System.currentTimeMillis();
        long renderLastTime = System.nanoTime();
        double amountOfRenders = 60; // MAX FPS
        double rendersNs = 1000000000/amountOfRenders;
        double rendersDelta = 0;
        int frames = 0;
        int ticks = 0;

        while(isRunning)
        {
            long now = System.nanoTime();
            ticksDelta += (now - lastTime) / ticksNs;
            lastTime = now;

            while(ticksDelta >= 1)
            {
                tick(ticksDelta);
                ticksDelta--;
                ticks++;
            }

            now = System.nanoTime();
            rendersDelta += (now - renderLastTime) / rendersNs;
            renderLastTime = now;

            while (isRunning && rendersDelta >= 1) {
                render();
                rendersDelta--;
                frames++;
            }

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                if (GameSceneHandler.getInstance().isInDebug()) {
                    System.out.printf("\n\n");
                    System.out.println("TPS: " + ticks);
                    System.out.println("FPS: " + frames);
                }
                debug();
                frames = 0;
                ticks = 0;
            }
        }
        stop();
    }

    private void tick(double ticksDelta) {
        GameSceneHandler.getInstance().tick(ticksDelta);
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        GameSceneHandler.getInstance().render(g);
        g.dispose();
        bs.show();
    }

    private void debug() {
        GameSceneHandler.getInstance().debug();
    }
}
