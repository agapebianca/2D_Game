package DarkForest.Tiles;

import DarkForest.Graphics.Assets;

public class Tree5 extends Tile {

    public Tree5(int id) {
        super(Assets.tree5, id);
    }
    @Override
    public boolean isSolid()
    {
        return true;
    }

}