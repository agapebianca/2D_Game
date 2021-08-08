package DarkForest.UI;

import DarkForest.RefLinks;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UIManager {

    private RefLinks refLinks;
    private ArrayList<UIObject> objects;

    public UIManager(RefLinks refLinks)
    {
        this.refLinks=refLinks;
        this.objects= new ArrayList<UIObject>();
    }

    public void update()
    {
        for(UIObject o: objects)
            o.update();
    }

    public void draw(Graphics g)
    {
        for(UIObject o: objects)
            o.draw(g);
    }

    public void mouseMove(MouseEvent e)
    {
        for(UIObject o: objects)
            o.mouseMove(e);
    }

    public void mouseRelease(MouseEvent e)
    {
        for(UIObject o: objects)
            o.mouseRelease(e);
    }

    public void addObject(UIObject o)
    {
        objects.add(o);
    }

    public void removeObject(UIObject o)
    {
        objects.remove(o);
    }


}
