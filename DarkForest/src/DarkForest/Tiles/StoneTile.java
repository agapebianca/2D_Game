package DarkForest.Tiles;

import DarkForest.Graphics.Assets;

public class StoneTile extends Tile {

    public StoneTile(int id)
    {
        super(Assets.stone, id);
    }

    @Override
    public boolean isSolid()
    {
        return false;
    }

}