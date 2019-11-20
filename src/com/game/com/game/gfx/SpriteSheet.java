package com.game.com.game.gfx;

import java.awt.image.BufferedImage;

class SpriteSheet {

    private BufferedImage sheet;

    SpriteSheet(BufferedImage sheet){
        this.sheet = sheet;
    }

        BufferedImage crop(int x, int y, int widrh, int height){
        return sheet.getSubimage(x, y, widrh, height);


        }
}
