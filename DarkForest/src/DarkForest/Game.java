package DarkForest;

import DarkForest.GameWindow.GameWindow;
import DarkForest.Graphics.Assets;
import DarkForest.Graphics.GameCamera;
import DarkForest.Input.KeyManager;
import DarkForest.Input.MouseManager;
import DarkForest.States.*;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{

    private int width, height;
    public String title;
    private float score=0;

    private boolean runState=false;

    private GameWindow wnd;
    private Thread gameThread;
    private BufferStrategy bs;
    private Graphics g;
    private RefLinks refLink;


    public State playState;
    public State menuState;
    public State helpState;


    private KeyManager keyManager;
    private MouseManager mouseManager;


    private GameCamera gc;

    public Game(String title, int width, int height)
    {
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager=new KeyManager();
        mouseManager=new MouseManager();
    }

    private void initGame()
    {
        wnd=new GameWindow(title, width, height);

        wnd.buildGameWindow();
        wnd.getWndFrame().addKeyListener(keyManager);
        wnd.getWndFrame().addMouseListener(mouseManager);
        wnd.getWndFrame().addMouseMotionListener(mouseManager);


        wnd.getCanvas().addMouseListener(mouseManager);
        wnd.getCanvas().addMouseMotionListener(mouseManager);


        Assets.init();
        refLink=new RefLinks(this);
        gc=new GameCamera(refLink,0,0);


        playState =new PlayState(refLink);
        menuState=new MenuState(refLink);
        helpState=new HelpState(refLink);


        State.setState(menuState);

    }

    public void run()
    {
        initGame();
        long oldTime=System.nanoTime();
        long curentTime;

        final int framesPerSecond   = 60;
        final double timeFrame      = 1000000000 / framesPerSecond;

        while(runState==true)
        {
            curentTime=System.nanoTime();
            if((curentTime-oldTime)> timeFrame)
            {
                update();
                draw();
                oldTime=curentTime;
            }
        }
    }

    public synchronized void startGame()
    {
        if(runState==false)
        {
            runState=true;
            gameThread=new Thread(this);
            gameThread.start();
        }
        else
        {
            return;
        }
    }

    public synchronized void stopGame()
    {
        if(runState==true)
        {
            runState=false;
            System.exit(0);
            try
            {
                gameThread.join();
            }
            catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
        }
        else
        {
            return;
        }
    }

    private void update()
    {
        keyManager.Update();

        if(State.getState()!=null)
        {
            State.getState().update();
        }
    }

    private void draw()
    {
        bs=wnd.getCanvas().getBufferStrategy();
        if(bs==null)
        {
            try
            {
                wnd.getCanvas().createBufferStrategy(3);
                return;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        g=bs.getDrawGraphics();
        //g.clearRect(0,0,width, height);

        if(State.getState()!=null)
        {
            State.getState().draw(g);
        }
        bs.show();
        g.dispose();

    }

    public GameCamera getGameCamera()
    {
        return gc;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public KeyManager getKeyManager()
    {
        return keyManager;
    }

    public MouseManager getMouseManager()
    {
        return mouseManager;
    }

    public Graphics getGraphics() {
        return g;
    }
}
