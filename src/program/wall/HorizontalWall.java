package program.wall;

import program.Settings;
import program.physics.BoxCollider;

public class HorizontalWall extends Wall {
    public HorizontalWall(double x,double y){
        super("images/wall/horizontal.png");
        position.set(x,y);
        hitBox=new BoxCollider(this, Settings.HORIWALL_WIDTH,Settings.HORIWALL_HEIGHT);
    }
    public HorizontalWall(){
        position.set(0,0);
    }
}
