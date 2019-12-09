package World;

import com.game.MAIN.Handler;
import com.game.enitity.Entity;
import com.game.enitity.EntityManager;
import com.game.enitity.creature.Enemy;
import com.game.enitity.creature.Player;
import com.game.utils.Utils;
import tiles.Tile;

import java.awt.*;

public class World {

    private Handler handler;
    private int width, height;
    private int [][] tiles;
    private int spawnx, spawny;

    //Entities
    private EntityManager entityManager;

    public World(Handler handler, String path){
        this.handler = handler;
        entityManager = new EntityManager(handler , new Player(handler, spawnx, spawny));
        entityManager.addEntity(new Enemy(handler, 600,250));
        entityManager.addEntity(new Enemy(handler, 800,850));
        entityManager.addEntity(new Enemy(handler, 200,850));
        entityManager.addEntity(new Enemy(handler, 250,850));
        entityManager.addEntity(new Enemy(handler, 400,850));


        loadWorld(path);

        entityManager.getPlayer().setX(spawnx);
        entityManager.getPlayer().setY(spawny);


    }
    public void tick(){
        entityManager.tick();
    }
    public void render(Graphics graphics){
        int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset()/ Tile.TILEWIDTH);
        int xEnd = (int) Math.min(width,(handler.getGameCamera().getxOffset()+ handler.getWidth())/ Tile.TILEWIDTH +1);
        int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset()/ Tile.TILEHEIGHT);
        int yEnd = (int) Math.min(height,(handler.getGameCamera().getyOffset()+ handler.getHeight())/ Tile.TILEHEIGHT +1);

        for(int y = yStart; y < yEnd;y++ ){
            for(int x =xStart; x < xEnd; x++){
                getTile(x, y).render(graphics, (int)(x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
                        (int)(y * Tile.TILEHEIGHT- handler.getGameCamera().getyOffset()));
            }
        }

        entityManager.render(graphics);
    }
    public Tile getTile(int x, int y){
        if( x < 0 || y < 0 || x >= width || y > height )
            return Tile.grasstile;

        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null)
            return Tile.dirttile;
        return t;

    }
 private void loadWorld(String path){ //acces can be private
        String file = Utils.loadFileAsString(path);
        String [] tokens = file.split("\\s+");
        width  = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnx = Utils.parseInt(tokens[2]);
        spawny = Utils.parseInt(tokens[3]);

        tiles = new int[width][height];
        for (int y = 0; y < height; y++ ){
            for (int x = 0; x < width; x++){
                tiles[x][y] = Utils.parseInt(tokens[x+y*width + 4]);// casue 4 ara smth diffenert
            }
        }
    }

    public int getWidth(){
        return  width;
    }

    public int getHeight(){
        return height;
    }

    public int getSpawnx() {
        return spawnx;
    }

    public int getSpawny() {
        return spawny;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}

