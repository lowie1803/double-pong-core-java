package program.player;

import program.GameObject;
import program.GameWindow;
import program.Settings;
import tklibs.Mathx;

public class Player3 extends Player {
    public Player3(){
        super(Settings.BACKGROUND_WIDTH*3/4,"images/paddle/arsenal.png");
    }
    @Override
    public void move(){
        double spd = Settings.PLAYER_SPEED;
        double vx = 0;
        double vy = 0;

        if(GameWindow.isUpPress3) {
            vy -= spd;
        }
        if(GameWindow.isRightPress3) {
            vx += spd;
        }
        if(GameWindow.isDownPress3) {
            vy += spd;
        }
        if(GameWindow.isLeftPress3) {
            vx -= spd;
        }

        if(vx != 0 && vy != 0) {
            double v = spd / Math.sqrt(2);
            vx = Math.signum(vx) * v; // 1 * 5 * sqrt(2)
            vy = Math.signum(vy) * v; // -1 * 5 * sqrt(2)
        }
        Player p2 = GameObject.findIntersects(Player2.class, this.hitBox.shift(vx*10,vy*10));

        if (p2!=null)
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
