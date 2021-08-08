package DarkForest.States;
import DarkForest.Graphics.Assets;
import DarkForest.Maps.Map;
import DarkForest.RefLinks;

import java.awt.*;

public class PlayState extends State {

    private Map map;

    public PlayState(RefLinks refLink) {
        super(refLink);

        map = new Map(refLink);
        refLink.setMap(map);
        refLink.getGame().getGameCamera().move(0, 0);

    }

    @Override
    public void update() {
        map.update();
        if (refLink.getKeyManager().esc)
            State.setState(refLink.getGame().menuState);

    }

    @Override
    public void draw(Graphics g) {
        map.draw(g);
        if(map.isHerodead())
        {
            g.drawImage(Assets.backgroundLose,0,0,960,960,null);

        }

    }
}
