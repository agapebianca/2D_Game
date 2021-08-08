package DarkForest.Items;

import DarkForest.RefLinks;
import java.awt.*;


public abstract class Item {

    protected float x;
    protected float y;

    protected int width;
    protected int height;

    protected RefLinks refLink;
    protected Rectangle bounds;

    protected boolean active=true;
    protected int health;
    public static final int DEFAULT_HEALTH=3;

    public Item(RefLinks refLink, float x, float y, int width, int height)
    {
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.refLink=refLink;
        health=DEFAULT_HEALTH;

        bounds=new Rectangle(0,0,width, height);

    }

    public boolean itemCollisions(float xOffset, float yOffset)
    {
        for(Item it: refLink.getMap().getItemManager().getItems())
        {
            if(it.equals(this))
                continue;
            if(it.getCollisionItems(0f,0f).intersects(getCollisionItems(xOffset,yOffset)))
                return true;
        }
        return false;
    }
    public Rectangle getCollisionItems(float xOffset, float yOffset)
    {
        return new Rectangle((int)(x+bounds.x+xOffset), (int)(y+bounds.y+yOffset), bounds.width,bounds.height);
    }

    public void hurt(int amt)
    {
        this.health -= amt;
        if (this.health <= 0) {
            active = false;
            die();
        }
    }

    public abstract void update();

    public abstract void draw(Graphics g);

    public boolean isSolid(){return true;}

    public abstract void die();

    //
    public boolean isEnemy()
    {
        return false;
    }

    public boolean isHeart()
    {
        return false;
    }

    public boolean isFlower()
    {
        return false;
    }

    public boolean isWater(){return false;}
    //

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getX()
    {
        return x;
    }

    public float getY()
    {
        return y;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setX(float x)
    {
        this.x = x;
    }

    public void setY(float y)
    {
        this.y = y;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }



}
