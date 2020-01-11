package ElementsOfMap;

import com.game.Graphics.Assets;

public class RockTile extends Tile {

    RockTile(int id) {
        super(Assets.rock, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
