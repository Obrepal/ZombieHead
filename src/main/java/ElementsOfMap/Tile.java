package ElementsOfMap;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    //STATIC STUFF HERE
    public static Tile[] tiles = new Tile[256];
    public static Tile grasstile = new GrassTile(0);
    public static Tile dirttile = new DirtTile(1);
    public static Tile rocktile = new RockTile(2);


    //CLASS

    public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
    private BufferedImage texture;
    private final int id;

    Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;

        tiles[id] = this;//it sets index on this stuff
    }

    public void tick() {

    }

    public void render(Graphics graphics, int x, int y) {
        graphics.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }

    public boolean isSolid() {
        return false;
    }

}
