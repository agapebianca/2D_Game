package DarkForest.Tiles;

import DarkForest.Graphics.Assets;

public class Tree4 extends Tile {

    public Tree4(int id) {
        super(Assets.tree4, id);
    }
    @Override
    public boolean isSolid()
    {
        return true;
    }

}