package DarkForest.Tiles;
import DarkForest.Graphics.Assets;

public class BushTile extends Tile{

    public BushTile(int id)
    {
        super(Assets.bush,id);
    }

    @Override
    public boolean isSolid()
    {
        return true;
    }
}

