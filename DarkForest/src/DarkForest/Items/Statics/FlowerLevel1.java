package DarkForest.Items.Statics;

import DarkForest.Graphics.Assets;
import DarkForest.RefLinks;
import DarkForest.Tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FlowerLevel1 extends StaticItem {

    private BufferedImage image;

    public FlowerLevel1(RefLinks refLinks, float x, float y) {

        super(refLinks,x,y,Tile.TILE_WIDTH, Tile.TILE_HEIGHT);


        image=Assets.flower;
        bounds.x=10;
        bounds.y=(int)(height/2f);
        bounds.width=width-10;
        bounds.width=(int)(height-height/3f);

        this.health=1;
    }

    @Override
    public void update() {
        collected();
    }

    @Override
    public void die()
    {
        this.active=false;
    }

    public void collected() {
        Rectangle ar = new Rectangle();
        ar.width = this.width;
        ar.height = this.height;
        ar.x = (int) this.getX();
        ar.y = (int) this.getY();

        if (refLink.getMap().getItemManager().getHero().getCollisionItems(0, 0).intersects(ar)) {
            this.die();
            refLink.getMap().getItemManager().getHero().score+=1;
        }
    }

    @Override
    public boolean isEnemy()
    {
        return false;
    }

    @Override
    public boolean isSolid(){return false;}


    @Override
    public void draw(Graphics g) {
       g.drawImage(image,(int)(x-refLink.getGame().getGameCamera().getxOffset()),
               (int)(y-refLink.getGame().getGameCamera().getyOffset()),width,height,null);
    }
}
