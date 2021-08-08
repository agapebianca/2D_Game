package DarkForest.Tiles;

import DarkForest.Graphics.Assets;

public class Tree8L2 extends Tile {

    public Tree8L2(int id) {
        super(Assets.tree8_L2, id);
    }

    @Override
    public boolean isSolid()
    {
        return true;
    }

}