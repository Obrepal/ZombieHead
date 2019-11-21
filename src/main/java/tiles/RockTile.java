package tiles;

import com.game.gfx.Assets;

public class RockTile extends Tile {

    RockTile(int id){
        super(Assets.rock, id);
    }
    @Override
    public boolean isSolid(){
        return true;
    }
}
