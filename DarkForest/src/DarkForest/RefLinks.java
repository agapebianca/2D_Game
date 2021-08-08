package DarkForest;

import DarkForest.Input.KeyManager;
import DarkForest.Input.MouseManager;
import DarkForest.Items.Item;
import DarkForest.Maps.Map;

public class RefLinks {

    private Game game;
    private Map map;

    public RefLinks(Game game)
    {
        this.game=game;
    }

    public KeyManager getKeyManager()
    {
        return game.getKeyManager();
    }

    public MouseManager getMouseManager()
    {
        return game.getMouseManager();
    }

    public void removeItem(Item item)
    {
        removeItem(item);
    }

    public Game getGame()
    {
        return game;
    }


    public Map getMap()
    {
        return map;
    }


    public void setMap(Map map)
    {
        this.map = map;
    }

}
