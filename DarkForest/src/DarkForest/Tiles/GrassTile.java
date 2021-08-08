package DarkForest.Tiles;
import DarkForest.Graphics.Assets;

public class GrassTile extends Tile{

    public GrassTile(int id)
    {
        super(Assets.grass,id);

    }
    @Override
    public boolean isSolid()
    {
        return true;
    }

}
