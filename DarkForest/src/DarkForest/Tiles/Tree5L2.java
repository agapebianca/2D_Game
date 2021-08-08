package DarkForest.Tiles;

import DarkForest.Graphics.Assets;

public class Tree5L2 extends Tile {

    public Tree5L2(int id) {
        super(Assets.tree5_L2, id);
    }

    @Override
    public boolean isSolid()
    {
        return true;
    }

}