package DarkForest.Graphics;

import DarkForest.Items.Item;
import DarkForest.RefLinks;
import DarkForest.Tiles.Tile;

public class GameCamera {

    private RefLinks refLinks;
    private float xOffset, yOffset;

    public GameCamera(RefLinks refLinks, float xOffset, float yOffset)
    {
        this.refLinks=refLinks;
        this.xOffset=xOffset;
        this.yOffset=yOffset;
    }

    public void followEntity(Item i)
    {
        xOffset=i.getX()-refLinks.getGame().getWidth()/2+i.getWidth()/2;
        yOffset=i.getY()-refLinks.getGame().getHeight()/2+i.getHeight()/2;
        limits();
    }


    public void limits(){
        if(xOffset<0)
        {
            xOffset=0;
        }
        else if(xOffset>refLinks.getMap().getWidth()* Tile.TILE_WIDTH-refLinks.getGame().getWidth()){
            xOffset=refLinks.getMap().getWidth()* Tile.TILE_WIDTH-refLinks.getGame().getWidth();
        }
        if(yOffset<0)
        {
            yOffset=0;
        }
        else if(yOffset> refLinks.getMap().getHeight()*Tile.TILE_HEIGHT-refLinks.getGame().getHeight()){
            yOffset=refLinks.getMap().getHeight()*Tile.TILE_HEIGHT-refLinks.getGame().getHeight();
        }
    }

    public void move(float xm, float ym)
    {
        xOffset+=xm;
        yOffset+=ym;
        limits();
    }

    public float getxOffset()
    {
        return xOffset;
    }
    public void setxOffset()
    {
        this.xOffset=xOffset;
    }
    public float getyOffset()
    {
        return yOffset;
    }
    public void setyOffset()
    {
        this.yOffset=yOffset;
    }
}
