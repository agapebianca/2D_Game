package DarkForest.States;

import DarkForest.RefLinks;

import java.awt.*;

public abstract class State {

    private static State currentState   = null;
    protected RefLinks refLink;

    public State(RefLinks refLink)
    {
        this.refLink = refLink;
    }

    public static void setState(State state)
    {
        currentState = state;
    }

    public static State getState()
    {
        return currentState;
    }

    public abstract void update();
    public abstract void draw(Graphics g);
}
