package DarkForest.Tiles;

import DarkForest.Graphics.Assets;

public class Tree2 extends Tile {

    public Tree2(int id) {
        super(Assets.tree2, id);
    }
    @Override
    public boolean isSolid()
    {
        return true;
    }

}