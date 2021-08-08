package DarkForest.Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    private static final int NO_TILES=30;

    public static Tile[] tiles          = new Tile[NO_TILES];


    //Level 1
    public static Tile grassTile            = new GrassTile(0);
    public static Tile stone        = new StoneTile(1);
    public static Tile bush        = new BushTile(2);
    public static Tile tree1        = new Tree1(5);
    public static Tile tree2        = new Tree2(6);
    public static Tile tree3        = new Tree3(7);
    public static Tile tree4        = new Tree4(8);
    public static Tile tree5        = new Tree5(9);
    public static Tile tree6        = new Tree6(10);
    public static Tile tree7        = new Tree7(11);
    public static Tile tree8        = new Tree8(12);
    public static Tile tree9        = new Tree9(13);

    //Level2
    public static Tile grassL2            = new GrassL2(14);
    public static Tile stoneL2        = new StoneL2(15);
    public static Tile tree1L2        = new Tree1L2(16);
    public static Tile tree2L2       = new Tree2L2(17);
    public static Tile tree3L2       = new Tree3L2(18);
    public static Tile tree4L2       = new Tree4L2(19);
    public static Tile tree5L2        = new Tree5L2(20);
    public static Tile tree6L2        = new Tree6L2(21);
    public static Tile tree7L2        = new Tree7L2(22);
    public static Tile tree8L2        = new Tree8L2(23);
    public static Tile tree9L2        = new Tree9L2(24);



    public static final int TILE_WIDTH  = 64;
    public static final int TILE_HEIGHT = 64;

    protected BufferedImage img;
    protected final int id;

    public Tile(BufferedImage image, int idd)
    {
        this.img = image;
        this.id = idd;

        tiles[id] = this;
    }

    public void draw(Graphics g, int x, int y)
    {
        g.drawImage(img, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }

    public boolean isSolid()
    {
        return false;
    }

    public int getId()
    {
        return id;
    }

    public Tile[] getTile()
    {
        return tiles;
    }

}
