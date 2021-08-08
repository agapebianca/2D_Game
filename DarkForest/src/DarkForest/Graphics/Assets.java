package DarkForest.Graphics;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width=64;
    private static final int height=64;


    public static BufferedImage hero;
    public static BufferedImage heroRight;
    public static BufferedImage heroLeft;
    public static BufferedImage heroDead;

    public static BufferedImage wolfRight;
    public static BufferedImage wolfLeft;

    public static BufferedImage grass;
    public static BufferedImage stone;
    public static BufferedImage tree1;
    public static BufferedImage tree2;
    public static BufferedImage tree3;
    public static BufferedImage tree4;
    public static BufferedImage tree5;
    public static BufferedImage tree6;
    public static BufferedImage tree7;
    public static BufferedImage tree8;
    public static BufferedImage tree9;
    public static BufferedImage bush;
    public static BufferedImage flower;
    public static BufferedImage heart;

    public static BufferedImage grass_L2;
    public static BufferedImage stone_L2;
    public static BufferedImage tree1_L2;
    public static BufferedImage tree2_L2;
    public static BufferedImage tree3_L2;
    public static BufferedImage tree4_L2;
    public static BufferedImage tree5_L2;
    public static BufferedImage tree6_L2;
    public static BufferedImage tree7_L2;
    public static BufferedImage tree8_L2;
    public static BufferedImage tree9_L2;
    public static BufferedImage flower_L2;


    public static BufferedImage[] playButton;
    public static BufferedImage[] closeButton;
    public static BufferedImage[] helpButton;
    public static BufferedImage[] backButton;
    public static BufferedImage background;
    public static BufferedImage backgroundLose;
    public static BufferedImage backgroundHelp;


    public static void init()
    {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/Textures/sprites.png"));
        SpriteSheet sheet_buttons= new SpriteSheet(ImageLoader.LoadImage("/Textures/buttons.png"));

        playButton=new BufferedImage[2];
        playButton[0]=sheet_buttons.crop(1, 0, width*28, height*12);
        playButton[1]=sheet_buttons.crop(1, height*14, width*28, height*12);

        helpButton=new BufferedImage[2];
        helpButton[0]=sheet_buttons.crop(width*27, 0, width*28, height*12);
        helpButton[1]=sheet_buttons.crop(width*27, height*14, width*28, height*12);

        closeButton=new BufferedImage[2];
        closeButton[0]=sheet_buttons.crop(0, height*25, width*28, height*12);
        closeButton[1]=sheet_buttons.crop(0, height*37, width*28, height*12);

        backButton=new BufferedImage[2];
        backButton[0]=sheet_buttons.crop(width*27, height*25, width*28, height*12);
        backButton[1]=sheet_buttons.crop(width*27, height*37, width*28, height*12);


        background=ImageLoader.LoadImage("/Textures/background.png");
        backgroundLose=ImageLoader.LoadImage("/Textures/backgroundLose.png");
        backgroundHelp=ImageLoader.LoadImage("/Textures/backgroundHelp.png");



        grass = sheet.crop(0, 0, width,height);
        stone=sheet.crop(width,0,width,height);
        tree1 = sheet.crop(0, height, width,height);
        tree2 = sheet.crop(width, height, width,height);
        tree3 = sheet.crop(2*width, height, width,height);
        bush = sheet.crop(3*width,height, width,height);
        hero=sheet.crop(4*width,height, width,height);
        tree4 = sheet.crop(0, 2*height, width,height);
        tree5 = sheet.crop(width, 2*height, width,height);
        tree6 = sheet.crop(2*width, 2*height, width,height);
        tree7 = sheet.crop(0, 3*height, width,height);
        tree8 = sheet.crop(width, 3*height, width,height);
        tree9 = sheet.crop(2*width, 3*height, width,height);
        heroRight=sheet.crop(3*width,2*height, width,height);
        heroLeft=sheet.crop(4*width,2*height, width,height);
        wolfRight=sheet.crop(3*width,3*height, width,height);
        wolfLeft=sheet.crop(4*width,3*height, width,height);
        flower=sheet.crop(3*width,5*height, width,height);
        heart=sheet.crop(4*width,0, width,height);
        heroDead=sheet.crop(3*width,4*height,width,height);

        grass_L2=sheet.crop(4*width,6*height,width,height);
        stone_L2=sheet.crop(3*width,6*height,width,height);
        tree1_L2 = sheet.crop(0, 4*height, width,height);
        tree2_L2 = sheet.crop(width, 4*height, width,height);
        tree3_L2 = sheet.crop(2*width, 4*height, width,height);
        tree4_L2 = sheet.crop(0, 5*height, width,height);
        tree5_L2 = sheet.crop(width, 5*height, width,height);
        tree6_L2 = sheet.crop(2*width, 5*height, width,height);
        tree7_L2 = sheet.crop(0, 6*height, width,height);
        tree8_L2 = sheet.crop(width, 6*height, width,height);
        tree9_L2 = sheet.crop(2*width, 6*height, width,height);
        flower_L2=sheet.crop(4*width,5*height,width,height);

    }

}
