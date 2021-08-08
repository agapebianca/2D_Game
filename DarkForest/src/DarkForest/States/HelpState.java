package DarkForest.States;

import DarkForest.Graphics.Assets;
import DarkForest.RefLinks;

import java.awt.*;

public class HelpState extends State {

    public HelpState(RefLinks refLinks) {
        super(refLinks);

    }

    @Override
    public void update()
    {
        if(refLink.getKeyManager().esc)
        {
            State.setState(refLink.getGame().menuState);
        }
    }

    @Override
    public void draw(Graphics g)
    {
        g.drawImage(Assets.backgroundHelp,0,0,960,960,null);

    }

}
