package DarkForest.Tiles;

import DarkForest.Graphics.Assets;

public class Tree6L2 extends Tile {

    public Tree6L2(int id) {
        super(Assets.tree6_L2, id);
    }

    @Override
    public boolean isSolid()
    {
        return true;
    }

}