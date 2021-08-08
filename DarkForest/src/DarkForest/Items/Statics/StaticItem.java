package DarkForest.Items.Statics;

import DarkForest.Items.Item;
import DarkForest.RefLinks;


public abstract class StaticItem extends Item {

    public StaticItem(RefLinks refLinks, float x, float y, int width, int height)
    {
        super(refLinks,x,y,width,height);

    }

    public void die(){};

    @Override
    public boolean isSolid(){
        return false;
    }


}
