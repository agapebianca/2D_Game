package DarkForest.Maps;

import DarkForest.Items.*;
import DarkForest.Items.Movable.Hero;
import DarkForest.Items.Movable.Wolf;
import DarkForest.Items.Statics.FlowerLevel1;
import DarkForest.Items.Statics.FlowerLevel2;
import DarkForest.Items.Statics.Heart;
import DarkForest.RefLinks;
import DarkForest.States.State;
import DarkForest.Tiles.Tile;

import java.awt.*;

import static DarkForest.Tiles.Tile.TILE_HEIGHT;
import static DarkForest.Tiles.Tile.TILE_WIDTH;

public class Map {

    private RefLinks refLink;

    private int width;
    private int height;
    private int [][] tiles;
    private int level;
    private int tempscore;
    private boolean playerdead=false;

    private ItemManager itemManager;

    public Map(RefLinks refLink)
    {
        this.refLink=refLink;

        loadLevel1();
    }

    public void update() {
        itemManager.update();

        if (level == 1) {
            tempscore = itemManager.getHero().score;
            if (tempscore >= 10) {
                loadLevel2();
            }
        }
        if (level == 2) {
            tempscore = itemManager.getHero().score;
            if (tempscore >=10 ) {
                State.setState(refLink.getGame().menuState);
            }

        }
        if (!itemManager.getHero().isActive()) {
            playerdead = true;
            if (refLink.getKeyManager().stop) {
                refLink.getGame().stopGame();
            }
            if (refLink.getKeyManager().restart) {
                playerdead = false;
                loadLevel1();
            }
        }
    }


    public void draw(Graphics g)
    {
        for(int y = 0; y<height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                getTile(x, y).draw(g, (int)(x * TILE_WIDTH-refLink.getGame().getGameCamera().getxOffset()),
                        (int)(y * TILE_HEIGHT-refLink.getGame().getGameCamera().getyOffset()));
            }
        }

        itemManager.draw(g);
    }

    public Tile getTile(int x, int y)
    {
        if(x < 0 || y < 0 || x >= width || y >= height)
        {
            return Tile.grassTile;
        }
        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null)
        {
            return Tile.grassTile;
        }
        return t;
    }

    public void loadWorld(String path) {

        String file = LoadMap.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = LoadMap.parseInt(tokens[0]);
        height = LoadMap.parseInt(tokens[1]);

        tiles = new int[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x][y] = LoadMap.parseInt(tokens[(x + y * width)+2]);
            }
        }
    }

    public void loadLevel1()
    {
        level=1;
        loadWorld("res/Maps/map1.txt");

        itemManager=new ItemManager(refLink,new Hero(refLink,0,0));

        itemManager.getHero().setX(10);
        itemManager.getHero().setY(45);

        itemManager.addItem(new Wolf(refLink,1150,730));
        itemManager.addItem(new Wolf(refLink,440,898));
        itemManager.addItem(new Wolf(refLink,380,380));
        itemManager.addItem(new Wolf(refLink,1200,1150));


        itemManager.addItem(new FlowerLevel1(refLink,800,380) );
        itemManager.addItem(new FlowerLevel1(refLink,130,510) );
        itemManager.addItem(new FlowerLevel1(refLink,1150,770) );
        itemManager.addItem(new FlowerLevel1(refLink,700,1150) );
        itemManager.addItem(new FlowerLevel1(refLink,160,1150) );
        itemManager.addItem(new FlowerLevel1(refLink,650,60) );
        itemManager.addItem(new FlowerLevel1(refLink,750,770) );

        itemManager.addItem(new Heart(refLink,200,60) );
        itemManager.addItem(new Heart(refLink,130,800) );
        itemManager.addItem(new Heart(refLink,900,898) );
        itemManager.addItem(new Heart(refLink,400,1150) );


    }

    public void loadLevel2()
    {
        level=2;
        loadWorld("res/Maps/map2.txt");

        itemManager=new ItemManager(refLink,new Hero(refLink,0,0));
        itemManager.getHero().setX(10);
        itemManager.getHero().setY(1150);

        itemManager.addItem(new Wolf(refLink, 60,1150));
        itemManager.addItem(new Wolf(refLink, 400,575));


        itemManager.addItem(new FlowerLevel2(refLink,30,1150));
        itemManager.addItem(new FlowerLevel2(refLink,200,575));
        itemManager.addItem(new FlowerLevel2(refLink,350,00));
        itemManager.addItem(new FlowerLevel2(refLink,800,380) );
        itemManager.addItem(new FlowerLevel2(refLink,130,510) );
        itemManager.addItem(new FlowerLevel2(refLink,1150,770) );


        itemManager.addItem(new Heart(refLink,200,60) );
        itemManager.addItem(new Heart(refLink,130,800) );
        itemManager.addItem(new Heart(refLink,900,898) );
        itemManager.addItem(new Heart(refLink,400,1150) );

    }


    public boolean isHerodead() {
        return playerdead;
    }
    public int getWidth()
    {
        return width;
    }
    public  int getHeight()
    {
        return height;
    }

    public ItemManager getItemManager()
    {
        return itemManager;
    }

    public RefLinks getRefLink() {
        return refLink;
    }

    public void setRefLink(RefLinks refLink) {
        this.refLink = refLink;
    }
}
