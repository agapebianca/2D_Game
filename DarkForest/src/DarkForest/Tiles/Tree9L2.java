package DarkForest.Tiles;

import DarkForest.Graphics.Assets;

public class Tree9L2 extends Tile {

    public Tree9L2(int id) {
        super(Assets.tree9_L2, id);
    }

    @Override
    public boolean isSolid()
    {
        return true;
    }

}