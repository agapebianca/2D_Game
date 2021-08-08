package DarkForest.Items;

import DarkForest.Items.Movable.Hero;
import DarkForest.RefLinks;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class ItemManager {

    private RefLinks refLinks;
    private Hero hero;
    private ArrayList<Item> items;

    private Comparator<Item> sort=new Comparator<Item>() {
        @Override
        public int compare(Item a, Item b) {
            if(a.getY()+a.getHeight() <b.getY()+ b.getHeight())
                return -1;
            else
                return 1;
        }
    };

    public ItemManager(RefLinks refLinks, Hero hero)
    {
        this.refLinks=refLinks;

        this.hero=hero;
        items=new ArrayList<Item>();

        items.add(hero);

    }

    public void update()
    {

        for(int i=0; i< items.size(); i++) {
            Item e = items.get(i);
            e.update();
            if(!e.isActive())
                items.remove(e);
        }
        items.sort(sort);
    }

    public void draw(Graphics g)
    {
        for(Item it: items)
        {
            it.draw(g);
        }
    }

    public void addItem(Item it)
    {
        items.add(it);
    }

    public RefLinks getRefLinks()
    {
        return refLinks;
    }

    public void setRefLinks(RefLinks refLinks) {
        this.refLinks = refLinks;
    }

    public Hero getHero()
    {
        return hero;
    }

    public ArrayList<Item> getItems()
    {
        return items;
    }
}
