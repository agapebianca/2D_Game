package DarkForest.GameWindow;

import javax.swing.*;
import java.awt.*;

public class GameWindow {

    private JFrame wndFrame;

    private Canvas canvas;

    private String wndTitle;
    private int wndWidth;
    private int wndHeight;

    public GameWindow(String title, int width, int height)
    {
        this.wndTitle=title;
        this.wndWidth=width;
        this.wndHeight=height;

        buildGameWindow();

    }


    public void buildGameWindow()
    {
        if(wndFrame!=null) return;
        wndFrame=new JFrame(wndTitle);
        wndFrame.setSize(wndWidth, wndHeight);
        wndFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wndFrame.setResizable(false);
        wndFrame.setLocationRelativeTo(null);
        wndFrame.setVisible(true);

        canvas=new Canvas();
        canvas.setPreferredSize(new Dimension(wndWidth,wndHeight));

        canvas.setMaximumSize(new Dimension(wndWidth,wndHeight));
        canvas.setMinimumSize(new Dimension(wndWidth,wndHeight));
        canvas.setFocusable(false);

        wndFrame.add(canvas);
        wndFrame.pack();

    }

    public Canvas getCanvas()
    {
        return canvas;
    }

    public JFrame getWndFrame()
    {
        return wndFrame;
    }

}
