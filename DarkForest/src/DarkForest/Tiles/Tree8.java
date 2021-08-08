package DarkForest.Tiles;

import DarkForest.Graphics.Assets;

public class Tree8 extends Tile {

    public Tree8(int id) {
        super(Assets.tree8, id);
    }
    @Override
    public boolean isSolid()
    {
        return true;
    }

}