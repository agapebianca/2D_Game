package DarkForest.States;

import DarkForest.Graphics.Assets;
import DarkForest.RefLinks;
import DarkForest.UI.Button;
import DarkForest.UI.ClickListener;
import DarkForest.UI.UIManager;

import java.awt.*;

public class MenuState extends State
{
    private UIManager uiManager;


    public MenuState(RefLinks refLink)
    {
        super(refLink);
        uiManager=new UIManager(refLink);
        refLink.getMouseManager().setUIManager(uiManager);

        uiManager.addObject(new Button(320, 500, 300, 100, Assets.playButton, new ClickListener() {
            @Override
            public void onClick() {
                refLink.getMouseManager().setUIManager(uiManager);
                State.setState(refLink.getGame().playState);
            }
        }));

        uiManager.addObject(new Button(320, 650, 300, 100, Assets.helpButton, new ClickListener() {
        @Override
        public void onClick() {
            refLink.getMouseManager().setUIManager(uiManager);
            State.setState(refLink.getGame().helpState);
        }
        }));

        uiManager.addObject(new Button(320, 800, 300, 100, Assets.closeButton, new ClickListener() {
            @Override
            public void onClick() {
                refLink.getMouseManager().setUIManager(uiManager);
                refLink.getGame().stopGame();
            }
        }));



    }

    @Override
    public void update()
    {
    }

    @Override
    public void draw(Graphics g)
    {
        g.drawImage(Assets.background,0,0,960,960,null);

        g.setColor(Color.red);
        g.fillRect(refLink.getMouseManager().getMouseX(),refLink.getMouseManager().getMouseY(), 8, 8);
        uiManager.draw(g);
    }

    public UIManager getUiManager() {
        return uiManager;
    }

    public void setUiManager(UIManager uiManager) {
        this.uiManager = uiManager;
    }
}

