package program.player;

import program.GameWindow;
import program.Settings;
import tklibs.Mathx;

public class Player4 extends Player{
    public Player4(){
        super(Settings.BACKGROUND_WIDTH-Settings.PLAYER_WIDTH/2,"images/paddle/arsenal.png");
    }
    @Override
    public void move(){
        double spd = Settings.PLAYER_SPEED*1.5;
        double vx = 0;
        double vy = 0;
        //Player1
        if(GameWindow.isUpPress4) {
            vy -= spd;
        }

        if(GameWindow.isDownPress4) {
            vy += spd;
        }



        velocity.set(vx, vy);
    }
    @Override
    public void limitPosition() {
        double minX=Settings.PLAYER_WIDTH/2+Settings.VERWALL_WIDTH+Settings.GAP;
        double minY=Settings.PLAYER_HEIGHT/2+Settings.HORIWALL_HEIGHT+Settings.GK_GAP;
        double maxX=Settings.BACKGROUND_WIDTH -Settings.PLAYER_WIDTH/2-Settings.VERWALL_WIDTH-Settings.GAP;
        double maxY=Settings.BACKGROUND_HEIGHT-Settings.PLAYER_HEIGHT/2 -Settings.HORIWALL_HEIGHT-Settings.GK_GAP;
        position.setX(Mathx.clamp(position.x, minX, maxX));
        position.setY(Mathx.clamp(position.y, minY, maxY));
    }
}
