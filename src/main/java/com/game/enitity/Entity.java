package com.game.enitity;

import com.game.MAIN.Game;
import com.game.MAIN.Handler;

import java.awt.*;

public abstract class Entity {

    private static  final int DEFAULT_HEALTH = 1;
    protected Handler handler;
    protected float x,y; //position
    protected int width, height;
    private int health;
    private boolean active = true;
    protected Rectangle bounds;


    public Entity(Handler handler, float x, float y, int width, int height) {

        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        health = DEFAULT_HEALTH;

        bounds = new Rectangle(0,0,width,height);
    }

    public abstract void tick();

    public abstract  void render(Graphics graph);

    public abstract void die();

    public abstract void getInput();

    public void hurt(int amt){
        health -= amt;
        if(health <= 0){
            active = false;
            die();
        }
    }

    protected boolean checkEntityCollisions(float xOffset, float yOffset){
        for(Entity e : handler.getWorld().getEntityManager().getEntities()) {
            if(e.equals(this))
                continue;
            if (e.getCollisionBounds(0f, 0f).intersects( getCollisionBounds(xOffset, yOffset) )) //rectangel
                return true;
            }
        return false;
        }

    public Rectangle getCollisionBounds(float xOffset, float yOffset){
        return new Rectangle((int) ( x + bounds.x + xOffset), (int)( y + bounds. y + yOffset),
                bounds.width, bounds.height);
    }

    boolean isActive() {
        return active;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;//
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
