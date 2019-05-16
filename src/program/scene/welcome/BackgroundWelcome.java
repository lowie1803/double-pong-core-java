package program.scene.welcome;

import program.GameObject;
import program.GameWindow;
import program.Settings;
import program.renderer.BackgroundWelcomeRenderer;
import program.renderer.SingleImageRenderer;
import program.scene.SceneManager;
import program.scene.in_game.SceneStage1;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

import static java.awt.Color.PINK;

public class BackgroundWelcome extends GameObject {
    public BackgroundWelcome(){
        GameObject.botLayer.add(this);
        BufferedImage image= SpriteUtils.loadImage("images/background/1.png");
        this.renderer=new BackgroundWelcomeRenderer(image);
        this.position.set(Settings.BACKGROUND_WIDTH/2,Settings.BACKGROUND_HEIGHT/2);

    }

//    @Override
//    public void render(Graphics g){
//
//        g.setColor(PINK);
//        g.setFont(Settings.Fixedsys);
//        String text="PRESS ENTER TO START";
//
//        g.drawString(text,(Settings.BACKGROUND_WIDTH/2- 175),Settings.BACKGROUND_HEIGHT/2);
//    }

    @Override
    public void run() {
        super.run();
        if (GameWindow.isEnterPress) {
            SceneManager.signNewScene(new SceneStage1());
        }
    }
}
