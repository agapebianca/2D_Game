package DarkForest.Tiles;

import DarkForest.Graphics.Assets;

public class StoneL2 extends Tile {

    public StoneL2(int id)
    {
        super(Assets.stone_L2, id);
    }

    @Override
    public boolean isSolid()
    {
        return false;
    }

}