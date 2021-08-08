package DarkForest.Tiles;

import DarkForest.Graphics.Assets;

public class Tree1L2 extends Tile {

    public Tree1L2(int id) {
        super(Assets.tree1_L2, id);
    }

    @Override
    public boolean isSolid()
    {
        return true;
    }

}