package program.player;

import program.GameObject;
import program.Settings;
import program.Vector2D;
import program.physics.BoxCollider;
import program.renderer.SingleImageRenderer;
import tklibs.Mathx;

import java.awt.*;

public class Player extends GameObject {



    public Player(double x,String filepath) {

       // program.renderer = new SingleImageRenderer("");
        GameObject.midLayer.add(this);
        position.setX(x);
        position.setY(Settings.BACKGROUND_HEIGHT/2);
        renderer=new SingleImageRenderer(filepath);
        hitBox= new BoxCollider(this,Settings.PLAYER_WIDTH,Settings.PLAYER_HEIGHT);
//        defaultPosition.set(x, Settings.BACKGROUND_WIDTH/2);
    }




    public void run() {
        super.run(); // position.add(velocity)
        this.move();
       this.limitPosition();


    }



    public void move() {

    }

    public void limitPosition() {
        double minX=Settings.PLAYER_WIDTH/2+Settings.VERWALL_WIDTH+Settings.GAP;
        double minY=Settings.PLAYER_HEIGHT/2+Settings.HORIWALL_HEIGHT+Settings.GAP;
        double maxX=Settings.BACKGROUND_WIDTH -Settings.PLAYER_WIDTH/2-Settings.VERWALL_WIDTH-Settings.GAP;
        double maxY=Settings.BACKGROUND_HEIGHT-Settings.PLAYER_HEIGHT/2 -Settings.HORIWALL_HEIGHT-Settings.GAP;
        position.setX(Mathx.clamp(position.x, minX, maxX));
        position.setY(Mathx.clamp(position.y, minY, maxY));
    }



}
