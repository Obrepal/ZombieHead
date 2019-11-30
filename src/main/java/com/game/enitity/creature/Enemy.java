package com.game.enitity.creature;

import com.game.MAIN.Handler;
import com.game.gfx.Assets;
import tiles.Tile;

import java.awt.*;

public class Enemy extends Creature {

    public Enemy(Handler handler ,float x, float y){
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        bounds.x= 16; //coordinate of player
        bounds.y =32;
        bounds.width = 32;
        bounds. height = 32;
    }

    @Override
    public void tick(){
        getInput();
        move();
    }

    @Override
    public void die(){
    }

    //TIMER!???????????? fix bug when it is going down etc like 1st and 2nd
    private void getInput(){
        xMove = 0;
        yMove = 0;

        if (( y < Player.getYP() && checkDown() && x >= Player.getXP() ) || ( x >= Player.getXP() && !checkLeft() )) //up
            yMove = ( speed -1 );

        if(( y > Player.getYP() && checkUP() && x <= Player.getXP() ) || ( x <= Player.getXP() && !checkRight() )) // down
            yMove = ( -speed+1 );

        if( (x > Player.getXP() && checkLeft() && y >= Player.getYP() ) || ( y >= Player.getYP() && !checkUP() )) // left
            xMove = ( -speed + 1 );

       if(( x < Player.getXP() && checkRight() && y <= Player.getYP() ) || ( y <= Player.getYP() && !checkDown() )) //right
            xMove = ( speed-1 );
    }

    //CHECKING BOUNDINGBOX
    private boolean checkUP(){
        int ty = (int) (y - 3 + bounds.y) / Tile.TILEHEIGHT;
         return (!collisionWithTile2((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
                !collisionWithTile2((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty));
    }
    private boolean checkDown(){
        int ty = (int) (y + 3 + bounds.y + bounds.height) / Tile.TILEHEIGHT;
        return (!collisionWithTile2((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
                !collisionWithTile2((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty));
    }
    private   boolean checkLeft(){
        int tx = (int) (x - 3 + bounds.x) / Tile.TILEWIDTH;
        return (!collisionWithTile2(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
                !collisionWithTile2(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT));
    }
    private boolean checkRight(){
        int tx = (int) (x + 3 + bounds.x + bounds.width) / Tile.TILEWIDTH;
        return (!collisionWithTile2(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
                !collisionWithTile2(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT));
    }

    protected boolean collisionWithTile2(int x, int y) {
        return handler.getWorld().getTile(x,y).isSolid();
    }

    @Override
    public void render(Graphics graph){

        graph.drawImage(Assets.enemy,(int)( x-handler.getGameCamera().getxOffset() ), (int) ( y - handler.getGameCamera().getyOffset() ), width , height, null);
        graph.setColor( Color.RED );
        graph.fillRect((int)( x + bounds.x - handler.getGameCamera().getxOffset() ),
                (int)( y + bounds.y-handler.getGameCamera().getyOffset() ),
                bounds.width,bounds.height );
    }

}

