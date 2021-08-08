package DarkForest.Items.Movable;

import DarkForest.Graphics.Assets;
import java.awt.*;
import java.awt.image.BufferedImage;

import DarkForest.RefLinks;

public class Wolf extends Character {

    private BufferedImage image;

    private long lastAttackTimer, attackCooldown=2000, attackTimer=attackCooldown;

    public Wolf(RefLinks refLink, float x, float y)
    {
        super(refLink,x,y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);
        image= Assets.wolfLeft;

        bounds.x=10;
        bounds.y=20;

        bounds.width=62;
        bounds.height=62;

        speed=2.0f;
        health=3;

    }

    private void direction() {
        xMove = 0;
        yMove = 0;

        if (refLink.getMap().getItemManager().getHero().isActive() == false)
            return;

        int xP = (int) refLink.getMap().getItemManager().getHero().getX();
        int yP = (int) refLink.getMap().getItemManager().getHero().getY();


        if (xP >= this.getX()) {
            if (yP >= this.getY())
                if ((int) (xP - this.getX()) / 64 > 3 || (int) (yP - this.getY()) / 64 > 3) {
                    return;
                }
            if (yP <= this.getY())
                if ((int) (xP - this.getX()) / 64 > 3 || (int) (this.getY() - yP) / 64 > 3) {
                    return;
                }
        }
        if (this.getX() >= xP) {
            if (yP >= this.getY())
                if ((int) (this.getX() - xP) / 64 > 3 || (int) (yP - this.getY()) / 64 > 3) {
                    return;
                }
            if (yP <= this.getY())
                if ((int) (this.getX() - xP) / 64 > 3 || (int) (this.getY() - yP) / 64 > 3) {
                    return;
                }
        }

        if(xP<this.getX())
            xMove= -speed;
        if(xP>this.getX())
            xMove= speed;
        if(yP<this.getY())
            yMove= -speed;
        if(yP>this.getY())
            yMove=speed;
    }

    private void checkAttacks()
    {
        attackTimer+= System.currentTimeMillis()-lastAttackTimer;
        lastAttackTimer=System.currentTimeMillis();
        if(attackTimer<attackCooldown)
            return;

        Rectangle ar=new Rectangle();
        ar.width=120;
        ar.height=120;
        ar.x=(int)this.getX()+this.width/2-ar.width/2;
        ar.y=(int)this.getY()+this.height/2-ar.height/2;


        attackTimer=0;
        if(refLink.getMap().getItemManager().getHero().getCollisionItems(0,0).intersects(ar) && refLink.getMap().getItemManager().getHero().isActive()){
            refLink.getMap().getItemManager().getHero().hurt(1);
            return;
        }
    }

    @Override
        public void update() {

       move();

       if(getxMove()>0)
        {
            image=Assets.wolfRight;
        }
        if(getxMove()<0)
        {
            image=Assets.wolfLeft;
        }
        if(getyMove()>0 && getyMove()<0)
        {
            image=Assets.wolfLeft;
        }

        direction();
        checkAttacks();
    }

    @Override
    public boolean isEnemy()
    {
        return true;
    }

    @Override
    public void die()
    {
        x=this.getX();
        y=this.getY();
        refLink.getMap().getItemManager().getHero().score+=2;
    }

    @Override
    public void draw(Graphics g)
    {
        g.drawImage(image,(int)(x-refLink.getGame().getGameCamera().getxOffset()),
             (int)(y-refLink.getGame().getGameCamera().getyOffset()),width,height,null);

    }




}
