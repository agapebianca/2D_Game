package DarkForest.Tiles;

import DarkForest.Graphics.Assets;

public class Tree7 extends Tile {

    public Tree7(int id) {
        super(Assets.tree7, id);
    }
    @Override
    public boolean isSolid()
    {
        return true;
    }

}