package DarkForest.Tiles;

import DarkForest.Graphics.Assets;

public class Tree1 extends Tile {

    public Tree1(int id) {
        super(Assets.tree1, id);
    }

    @Override
    public boolean isSolid()
    {
        return true;
    }

}