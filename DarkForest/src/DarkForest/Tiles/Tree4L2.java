package DarkForest.Tiles;

import DarkForest.Graphics.Assets;

public class Tree4L2 extends Tile {

    public Tree4L2(int id) {
        super(Assets.tree4_L2, id);
    }

    @Override
    public boolean isSolid()
    {
        return true;
    }

}