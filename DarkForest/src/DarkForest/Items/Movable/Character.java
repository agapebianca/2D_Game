package DarkForest.Items.Movable;

import DarkForest.Items.Item;
import DarkForest.RefLinks;
import DarkForest.Tiles.Tile;

public abstract class Character extends Item {

    public static final float DEFAULT_SPEED = 3.0f;
    public static final float SPEED_JUMP=1.0f;
    public static final int DEFAULT_CREATURE_WIDTH  = 64;
    public static final int DEFAULT_CREATURE_HEIGHT = 64;


    protected float speed;
    protected float speed_jump;
    protected float xMove;
    protected float yMove;


    public Character(RefLinks refLink, float x, float y, int width, int height)
    {
        super(refLink,x,y,width,height);
        speed   = DEFAULT_SPEED;
        speed_jump=SPEED_JUMP;
        xMove   = 0;
        yMove   = 0;
    }

    public void moveX()
    {
        if(xMove>0)
        {
            int tx=(int)(x+xMove+bounds.x+bounds.width)/ Tile.TILE_WIDTH;
            if(!collisionsTile(tx,(int)(y+bounds.y)/ Tile.TILE_HEIGHT)&&
                    !collisionsTile(tx,(int)(y+bounds.y+bounds.height)/Tile.TILE_HEIGHT)){
                x=x+xMove;
            }
            else{
                x = tx * Tile.TILE_WIDTH - bounds.x - bounds.width - 1;
            }
        }
        else if(xMove<0)
        {
            int tx=(int)(x+xMove+bounds.x)/ Tile.TILE_WIDTH;
            if(!collisionsTile(tx,(int)(y+bounds.y)/Tile.TILE_HEIGHT)&&
                    !collisionsTile(tx,(int)(y+bounds.y+bounds.height)/Tile.TILE_HEIGHT)){
                x=x+xMove;
            }
            else{
                x = tx * Tile.TILE_WIDTH + Tile.TILE_WIDTH - bounds.x;
            }
        }
    }

    public void moveY()
    {
        if(yMove<0){
            int ty=(int)(y+yMove+bounds.y)/ Tile.TILE_HEIGHT;
            if(!collisionsTile((int)(x+bounds.x)/Tile.TILE_WIDTH,ty)&&
                    !collisionsTile((int)(x+bounds.x+bounds.width)/Tile.TILE_WIDTH,ty))
            {
                y=y+yMove;
            }else{
                y = ty * Tile.TILE_HEIGHT + Tile.TILE_HEIGHT - bounds.y;
            }
        }
        else if(yMove>0)
        {
            int ty=(int)(y+yMove+bounds.y+bounds.height)/ Tile.TILE_HEIGHT;
            if(!collisionsTile((int)(x+bounds.x)/Tile.TILE_WIDTH,ty)&&
                    !collisionsTile((int)(x+bounds.x+bounds.width)/Tile.TILE_WIDTH,ty))
            {
                y=y+yMove;
            }
            else{
                y = ty * Tile.TILE_HEIGHT - bounds.y - bounds.height - 1;
            }
        }
    }

    public void move()
    {
        if (!itemCollisions(xMove, 0f))
            moveX();
        if (!itemCollisions(0f, yMove))
            moveY();
    }

    public boolean collisionsTile(int x, int y)
    {
        return refLink.getMap().getTile(x,y).isSolid();
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }
}
