package program.player;

import program.GameObject;
import program.GameWindow;
import program.Settings;
import tklibs.Mathx;

public class Player2 extends Player {
    public Player2() {

        // program.renderer = new SingleImageRenderer("");

        super(Settings.BACKGROUND_WIDTH/4,"images/paddle/chelsea.png");

    }

    @Override
    public void move(){
        double spd = Settings.PLAYER_SPEED;
        double vx = 0;
        double vy = 0;
        //Player1
        if(GameWindow.isUpPress2) {
            vy -= spd;
        }
        if(GameWindow.isRightPress2) {
            vx += spd;
        }
        if(GameWindow.isDownPress2) {
            vy += spd;
        }
        if(GameWindow.isLeftPress2) {
            vx -= spd;
        }

        if(vx != 0 && vy != 0) {
            double v = spd / Math.sqrt(2);
            vx = Math.signum(vx) * v; // 1 * 5 * sqrt(2)
            vy = Math.signum(vy) * v; // -1 * 5 * sqrt(2)
        }
        Player p3 = GameObject.findIntersects(Player3.class, this.hitBox.shift(vx*10,vy*10));

        if (p3!=null)
        {
            vx=0;vy=0;
        }
//        position.add(vx, vy);
        velocity.set(vx, vy);


    }

    @Override
    public void limitPosition() {
        double minX=Settings.PLAYER_WIDTH/2+Settings.VERWALL_WIDTH+Settings.GAP+Settings.GK_GAP;
        double minY=Settings.PLAYER_HEIGHT/2+Settings.HORIWALL_HEIGHT+Settings.GAP;
        double maxX=Settings.BACKGROUND_WIDTH -Settings.PLAYER_WIDTH/2-Settings.VERWALL_WIDTH-Settings.GAP-Settings.GK_GAP;
        double maxY=Settings.BACKGROUND_HEIGHT-Settings.PLAYER_HEIGHT/2 -Settings.HORIWALL_HEIGHT-Settings.GAP;
        position.setX(Mathx.clamp(position.x, minX, maxX));
        position.setY(Mathx.clamp(position.y, minY, maxY));
    }
}
