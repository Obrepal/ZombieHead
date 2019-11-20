package com.game.gfx;


import com.game.MAIN.Handler;
import com.game.enitity.Entity;
import tiles.Tile;

public class GameCamera {

    private float xOffset, yOffset;
    private Handler handler;

    public GameCamera(Handler handler,float xOffset, float yOffset){
        this.xOffset = xOffset; //from orginal postioin
        this.yOffset = yOffset;
        this.handler = handler;
    }

    public void move(Handler handler, float xAmt, float yAmt){
        xOffset += xAmt;
        yOffset += yAmt;
        checkBlankSpace();

    }

    public void checkBlankSpace(){
        if(xOffset < 0){
            xOffset = 0;
        } else if(xOffset > handler.getWorld().getWidth()* Tile.TILEWIDTH -handler.getWidth() ){
            xOffset = handler.getWorld().getWidth()* Tile.TILEWIDTH-handler.getWidth();
        }

        if(yOffset < 0){
            yOffset = 0;
        }else if(yOffset> handler.getWorld().getHeight()*Tile.TILEHEIGHT-handler.getHeight()){
            yOffset = handler.getWorld().getHeight()*Tile.TILEHEIGHT-handler.getHeight();
        }
    }


    public void centeronEntity(Entity e){
        xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth()/2; //centers on x
        yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight()/2; //centers on y
        checkBlankSpace();
    }

    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }
}
