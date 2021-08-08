package DarkForest.Items.Movable;

import DarkForest.Graphics.Assets;
import java.awt.*;
import java.awt.image.BufferedImage;

import DarkForest.Items.Item;
import DarkForest.RefLinks;


public class Hero extends Character {

    private BufferedImage image;
    private long lastAttackTimer, attackCooldown=800, attackTimer=attackCooldown;
    public int score=0;
    private boolean dead=false;


    public Hero(RefLinks refLink, float x, float y)
    {
        super(refLink,x,y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);
        image= Assets.hero;

        bounds.x=15;
        bounds.y=20;

        bounds.width=35;
        bounds.height=45;
        this.setHealth(3);
        this.speed=3f;

    }

    @Override
    public void update()
    {
        getInput();
        move();

        refLink.getGame().getGameCamera().followEntity(this);

        checkAttacks();

        if(refLink.getKeyManager().left==false && refLink.getKeyManager().right==false)
        {
            image=Assets.hero;
        }
        if(refLink.getKeyManager().left==true)
        {
            image=Assets.heroLeft;
        }
        if(refLink.getKeyManager().right==true)
        {
            image=Assets.heroRight;
        }
        if(dead==true)
        {
            image=Assets.heroDead;
             }

    }

    private void checkAttacks()
    {
        attackTimer+= System.currentTimeMillis()-lastAttackTimer;
        lastAttackTimer=System.currentTimeMillis();
        if(attackTimer<attackCooldown)
            return;

        Rectangle cb=getCollisionItems(0f,0f);
        Rectangle ar=new Rectangle();
        int arSize=20;
        ar.width=arSize;
        ar.height=arSize;

        if(refLink.getKeyManager().attack && refLink.getKeyManager().up){
            ar.x=cb.x+cb.width/2-arSize/2;
            ar.y=cb.y-arSize;
        } else if(refLink.getKeyManager().attack && refLink.getKeyManager().down) {
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y + cb.height;
        }else if(refLink.getKeyManager().attack && refLink.getKeyManager().left) {
            ar.x = cb.x -arSize;
            ar.y = cb.y +cb.height/2-arSize/2;
        }else if(refLink.getKeyManager().attack && refLink.getKeyManager().right) {
            ar.x = cb.x +cb.width;
            ar.y = cb.y +cb.height/2-arSize/2;
        }else{
            return;
        }

        attackTimer=0;

        for(Item e: refLink.getMap().getItemManager().getItems())
        {
            if(e.equals(this))
                continue;
            if(e.getCollisionItems(0,0).intersects(ar)){
                e.hurt(1);
                return;
            }
        }

    }

    private void getInput()
    {
       xMove=0;
       yMove=0;

        if(refLink.getKeyManager().up)
        {
                yMove =-speed;
        }
        if(refLink.getKeyManager().down)
        {

                yMove =speed;
        }
        if(refLink.getKeyManager().left)
        {
                xMove=-speed;
        }
        if(refLink.getKeyManager().right)
        {
                xMove=speed;
        }

    }

    @Override
    public void die()
    {

    }

    @Override
    public void hurt(int amt) {
        health -= amt;
        if (health <= 0) {
            active = false;
            dead=true;
            die();
        }
    }

    public int getScore() {
        return score;
    }

    public boolean isDead() {
        return dead;
    }

    @Override
    public boolean isEnemy() {
        return false;
    }

    public int getCurrentHealth(){return health;}
    public void plusHealth(int x){health+=x;}

    @Override
    public void draw(Graphics g)
    {
        g.drawImage(image, (int)(x-refLink.getGame().getGameCamera().getxOffset()), (int)(y-refLink.getGame().getGameCamera().getyOffset()), width, height, null);

        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.BOLD,30));
        g.drawString("Score: "+score,780,40);
        g.drawImage(Assets.flower_L2,890,-1,64,64,null);
        g.drawImage(Assets.flower,899,-1,64,64,null);

        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.BOLD,30));
        g.drawString(""+health,880,80);
        g.drawImage(Assets.heart,893,38,64,64,null);

        //g.setColor(Color.blue);
        //g.fillRect((int)(x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height);
    }

}
