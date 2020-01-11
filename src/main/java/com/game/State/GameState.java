package com.game.State;

import World.World;
import com.game.Bridge.Handler;

import java.awt.Graphics;

public class GameState extends State {


    private World world;


    public GameState(Handler handler) {
        super(handler);
        world = new World(handler, "res/textures/world1.txt");
        handler.setWorld(world);
    }

    @Override
    public void tick() {
        world.tick();
    }

    @Override
    public void render(Graphics graphics) {
        world.render(graphics);
    }

}
