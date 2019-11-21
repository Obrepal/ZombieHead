package com.game.gfx;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 100, height = 100;
    public static BufferedImage player, dirt, grass, rock, enemy;


    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/Zombiehead2.png"));

        player = sheet.crop(0,0, width, height);
        dirt = sheet.crop( width,0, width, height);
        grass = sheet.crop(width*2,0, width, height);
        rock = sheet.crop(0, height, width, height);
        enemy = sheet.crop(width, height, width, height);







    }
}
