package program;

import program.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.*;

import static java.awt.Color.*;

public class Background extends GameObject {
    public Background() {
            GameObject.botLayer.add(this);
        //program.renderer = new SingleImageRenderer("");
            renderer=new SingleImageRenderer("images/background/1.png");
            anchor.set(0,0);

    }

//    @Override
//    public void render(Graphics g){
//
//        g.setColor(GREEN);
//        g.fillRect(0,0,Settings.GAME_WIDTH,Settings.GAME_HEIGHT);
//        g.setColor(WHITE);
//        g.drawOval((int)(Settings.GAME_WIDTH/2-this.anchor.x*300),(int)(Settings.GAME_HEIGHT/2-this.anchor.y*300),300,300);
//
//    }


}
