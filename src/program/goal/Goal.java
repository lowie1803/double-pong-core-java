package program.goal;

import program.GameObject;
import program.Settings;
import program.ball.Ball;
import program.physics.BoxCollider;
import program.renderer.SingleImageRenderer;

public class Goal extends GameObject {

    public Goal(double x, double y){
        GameObject.midLayer.add(this);
        this.position.set(x,y);
        hitBox=new BoxCollider(this, Settings.NET_WIDTH,Settings.NET_HEIGHT-15);
        renderer=new SingleImageRenderer("images/goal/0.png");

    }







}
