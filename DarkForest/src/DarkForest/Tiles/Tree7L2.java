package DarkForest.Tiles;

import DarkForest.Graphics.Assets;

public class Tree7L2 extends Tile {

    public Tree7L2(int id) {
        super(Assets.tree7_L2, id);
    }

    @Override
    public boolean isSolid()
    {
        return true;
    }

}