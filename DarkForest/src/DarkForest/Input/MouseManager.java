package DarkForest.Input;

import DarkForest.UI.UIManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener {

    private boolean leftPress, rightPress;
    private int mouseX, mouseY;
    private UIManager uiManager;


    public MouseManager() { }

    public void setUIManager(UIManager uiManager)
    {
        this.uiManager=uiManager;
    }

    public boolean isLeftPress()
    {
        return leftPress;
    }

    public boolean isRightPress()
    {
        return rightPress;
    }

    public int getMouseX()
    {
        return mouseX;
    }

    public int getMouseY()
    {
        return mouseY;
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        if(e.getButton()==MouseEvent.BUTTON1)
            leftPress=true;
        else if(e.getButton()==MouseEvent.BUTTON3)
            rightPress=true;
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        if(e.getButton()==MouseEvent.BUTTON1)
            leftPress=false;
        else if(e.getButton()==MouseEvent.BUTTON3)
            rightPress=false;

        if(uiManager!=null)
            uiManager.mouseRelease(e);
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        mouseX=e.getX();
        mouseY=e.getY();

        if(uiManager!=null)
        uiManager.mouseMove(e);
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        //TODO
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        //TODO
    }

    @Override
    public void mouseEntered(MouseEvent arg0)
    {
        //TODO
    }

    @Override
    public void mouseExited(MouseEvent arg0)
    {
        //TODO
    }


}
