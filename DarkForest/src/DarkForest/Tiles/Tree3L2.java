package DarkForest.Tiles;

import DarkForest.Graphics.Assets;

public class Tree3L2 extends Tile {

    public Tree3L2(int id) {
        super(Assets.tree3_L2, id);
    }

    @Override
    public boolean isSolid()
    {
        return true;
    }

}