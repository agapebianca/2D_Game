package DarkForest.Tiles;
import DarkForest.Graphics.Assets;

public class GrassL2 extends Tile{

    public GrassL2(int id)
    {
        super(Assets.grass_L2,id);

    }
    @Override
    public boolean isSolid()
    {
        return true;
    }

}
