package DarkForest.Tiles;

import DarkForest.Graphics.Assets;

public class Tree2L2 extends Tile {

    public Tree2L2(int id) {
        super(Assets.tree2_L2, id);
    }

    @Override
    public boolean isSolid()
    {
        return true;
    }

}