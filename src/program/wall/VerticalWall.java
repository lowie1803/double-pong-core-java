package program.wall;

import program.Settings;
import program.physics.BoxCollider;

public class VerticalWall extends Wall {
    public  VerticalWall(double x,double y){
        super("images/wall/vertical.png");
        position.set(x,y);
        hitBox=new BoxCollider(this, Settings.VERWALL_WIDTH, Settings.VERWALL_HEIGHT);
    }

    public VerticalWall()
    {
        position.set(0, 0);
    }

}
