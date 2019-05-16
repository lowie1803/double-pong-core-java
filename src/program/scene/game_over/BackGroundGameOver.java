package program.scene.game_over;

import program.GameObject;
import program.GameWindow;
import program.Settings;
import program.renderer.BackgroundGameOverRenderer;
import program.scene.SceneManager;
import program.scene.in_game.SceneStage1;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class BackGroundGameOver extends GameObject {
    public BackGroundGameOver(){
        GameObject.botLayer.add(this);
        BufferedImage image= SpriteUtils.loadImage("images/background/1.png");
        renderer=new BackgroundGameOverRenderer(image);
        position.set(Settings.BACKGROUND_WIDTH/2,Settings.BACKGROUND_HEIGHT/2);

    }

    @Override
    public void run() {
        super.run();
        if(GameWindow.isBackSpacePress){
            SceneManager.signNewScene(new SceneStage1());
            Settings.reset();
            scoreLeft=0;
            scoreRight=0;

        }
    }
}
