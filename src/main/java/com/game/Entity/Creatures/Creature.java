package com.game.Entity.Creatures;

import com.game.Bridge.Handler;
import com.game.Entity.Entity;
import ElementsOfMap.Tile;

import java.awt.*;

public abstract class Creature extends Entity {


    private static final float DEFAULT_SPEED = 3.0f;
    static final int DEFAULT_CREATURE_WIDTH = 64,
            DEFAULT_CREATURE_HEIGHT = 64;

    float speed;
    float xMove, yMove;

    Creature(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);

        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics graph) {
    }

    void move() {
        if (!checkEntityCollisions(xMove, 0f))
            moveX();
        if (!checkEntityCollisions(0f, yMove))
            moveY();
    }

    private void moveX() {

        if (xMove > 0) {
            int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
            if (collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
                    collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT))
                x += xMove;

            else {
                x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
            }

        } else if (xMove < 0) {
            int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;

            if (collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
                    collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT))
                x += xMove;

            else {
                x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
            }
        }
    }

    private void moveY() {

        if (yMove < 0) {//Up
            int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;


            if (collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
                    collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty))
                y += yMove;


            else {
                y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
            }

        } else if (yMove > 0) {                                                                                 //Down
            int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;

            if (collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
                    collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty))
                y += yMove;
            else {
                y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
            }
        }
    }

    private boolean collisionWithTile(int x, int y) {
        return !handler.getWorld().getTile(x, y).isSolid();
    }


}

