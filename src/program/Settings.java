package program;

import java.awt.*;

public class Settings {
    public static int GAP=20;
    public static int GK_GAP=80;
    public static int FPS=80;
    // game
    public static int GAME_WIDTH = 1024;
    public static int GAME_HEIGHT = 768;

    // background
    public static int BACKGROUND_WIDTH=1024;
    public static int BACKGROUND_HEIGHT = 576;

    // program.player
    public static int PLAYER_WIDTH = 50;
    public static int PLAYER_HEIGHT = 160;
    public static double PLAYER_SPEED = 2;
//    public static int PLAYER_START_X = 300;
//    public static int PLAYER_START_Y = 300;


    // program.ball
    public static int BALL_WIDTH = 15;
    public static int BALL_HEIGHT = 15;
    public static double BALL_VELOCITY_X=3;

    //program.goal
    public static int NET_WIDTH=10;
    public static int NET_HEIGHT=288;

    //Wall
    public static int VERWALL_WIDTH=10;
    public static int VERWALL_HEIGHT=556;
    public static int HORIWALL_WIDTH=1004;
    public static int HORIWALL_HEIGHT=10;

    //
    public static Font BIGSIZE=new Font("Verdana",Font.BOLD,28);
    public static Font Fixedsys=new Font("Fixedsys",Font.BOLD,28);
    public static int MATCHTIME = 120;

    public static double BALLSPEED_INCREASER=0.5;
    public static double PLAYERSPEED_INCREASER=0.2;

    public static void reset()
    {
        PLAYER_SPEED = 2;
        BALL_VELOCITY_X=3;


    }
}
