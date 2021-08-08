package DarkForest.UI;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class UIObject {

    protected float x,y;
    protected int width,height;
    protected Rectangle bounds;
    protected boolean hovering=false;

    public UIObject(float x, float y, int width, int height)
    {
        this.x=x;
        this.y=y;
        this.height=height;
        this.width=width;

        bounds=new Rectangle((int)x, (int)y, width,height);
    }

    public abstract void update();

    public abstract void draw(Graphics g);

    public abstract void onClick();

    public void mouseMove(MouseEvent e)
    {
        if(bounds.contains(e.getX(), e.getY()))
            hovering=true;
        else
            hovering=false;
    }


    public void mouseRelease(MouseEvent e)
    {
        if(hovering)
            onClick();
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isHovering() {
        return hovering;
    }

    public void setHovering(boolean hovering) {
        this.hovering = hovering;
    }


}
