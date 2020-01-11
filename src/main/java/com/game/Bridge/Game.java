package com.game.Bridge;


import com.game.Graphics.Assets;
import com.game.Graphics.GameCamera;
import com.game.Display.Display;
import com.game.State.GameState;
import com.game.State.State;
import KeyboardInput.KeyManager;

import java.awt.*;
import java.awt.image.BufferStrategy;


public class Game implements Runnable {

    private Display display;
    private int width, height;
    public String title;


    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics graphics;

    //States
    private State gameState;
    private State menuState;

    //INPUT
    private KeyManager keyManager;

    //Camera
    private GameCamera gameCamera;

    //HANDLER
    private Handler handler;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
    }

    private void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);

        Assets.init();

        handler = new Handler(this);
        gameCamera = new GameCamera(handler, 0, 0);//normal postiotion


        gameState = new GameState(handler);
        State.setState(gameState);
    }

    private void tick() {
        keyManager.tick();//he must know what if going on
        if (State.getState() != null)//State exists
            State.getState().tick();
    }


    private void render() {
        bs = display.getCanvas().getBufferStrategy();

        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        graphics = bs.getDrawGraphics();//paintbrush
        //CLEAR screen
        graphics.clearRect(0, 0, width, height);


        //Draw HERE!

        if (State.getState() != null)//State exists
            State.getState().render(graphics);

        //END
        bs.show();
        graphics.dispose();

    }

    public void run() {

        init();

        int fps = 60; // how many time call tick and render
        double timePertick = 1000000000 / fps; // maximum time of time to excute methods
        double delta = 0; // amount of time we have to call again
        long now; // beginnig of loop
        long lastTime = System.nanoTime();//
        long timer = 0;//one second how many times
        int ticks = 0;//


        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePertick;//when to call methods below
            timer += now - lastTime;
            lastTime = now;
            if (delta >= 1) { // we have to tick and render
                tick();
                render();
                ticks++;
                delta--;
            }
            if (timer >= 1000000000) {
                // System.out.println("ticks and frames " + ticks);
                ticks = 0;
                timer = 0;
            }
        }
        stop();
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    GameCamera getGameCamera() {
        return gameCamera;
    }

    int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    synchronized void start() {
        if (running)
            return; //in order to avoid mess
        running = true;
        thread = new Thread(this);//gam class
        thread.start();//starts run mettohd
    }

    private synchronized void stop() {
        if (!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
