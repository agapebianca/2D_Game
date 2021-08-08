package DarkForest.Graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {

    private BufferedImage spriteSheet;
    private static final int tileWidth=64;
    private static final int tileHeight=64;

    public SpriteSheet(BufferedImage buffImg)
    {
        this.spriteSheet=buffImg;
    }

    public BufferedImage crop(int x, int y, int tileWidth, int tileHeight)
    {
        return spriteSheet.getSubimage(x, y, tileWidth, tileHeight);
    }

}
