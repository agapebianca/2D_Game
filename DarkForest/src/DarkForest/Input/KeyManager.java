package DarkForest.Input;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    private boolean[] keys;
    public boolean up;
    public boolean down;
    public boolean left;
    public boolean right;
    public boolean attack;
    public boolean esc;
    public boolean stop;
    public boolean restart;

    public KeyManager()
    {
        keys=new boolean[256];
    }

    public void Update()
    {
        up    = keys[KeyEvent.VK_UP];
        down  = keys[KeyEvent.VK_DOWN];
        left  = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];

        esc=keys[KeyEvent.VK_ESCAPE];
        stop=keys[KeyEvent.VK_Q];
        restart=keys[KeyEvent.VK_R];
        attack=keys[KeyEvent.VK_SPACE];
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        keys[e.getKeyCode()]=true;
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        keys[e.getKeyCode()]=false;
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }
}
