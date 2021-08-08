package DarkForest.Tiles;

import DarkForest.Graphics.Assets;

public class Tree3 extends Tile {

    public Tree3(int id) {
        super(Assets.tree3, id);
    }
    @Override
    public boolean isSolid()
    {
        return true;
    }

}