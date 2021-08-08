package DarkForest.Tiles;

import DarkForest.Graphics.Assets;

public class Tree9 extends Tile {

    public Tree9(int id) {
        super(Assets.tree9, id);
    }
    @Override
    public boolean isSolid()
    {
        return true;
    }

}