package DarkForest.Tiles;

import DarkForest.Graphics.Assets;

public class Tree6 extends Tile {

    public Tree6(int id) {
        super(Assets.tree6, id);
    }
    @Override
    public boolean isSolid()
    {
        return true;
    }

}