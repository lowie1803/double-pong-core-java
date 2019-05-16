package program.renderer;

import program.GameObject;
import program.Settings;
import program.player.Score;
import program.scene.game_over.BackGroundGameOver;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BackgroundGameOverRenderer extends Renderer {
    BufferedImage image;

    public BackgroundGameOverRenderer(BufferedImage image) {
        this.image = image;
    }

    public BackgroundGameOverRenderer(String filePath) {
        this.image = SpriteUtils.loadImage(filePath);
    }

    @Override
    public void render(Graphics g, GameObject master) {
        g.drawImage(
                image,
                (int) (master.position.x - master.anchor.x * image.getWidth()),
                (int) (master.position.y - master.anchor.y * image.getHeight()),
                null
        );
        //Full time
        g.setColor(Color.CYAN);
        g.setFont(Settings.Fixedsys);
        String fulltime="FULL TIME";

        g.drawString(fulltime,
                (int) master.position.x-65,
                (int)master.position.y);

        g.setColor(Color.BLACK);
        g.setFont(Settings.Fixedsys);
        //tỷ số chung cuộc
        g.drawString(Score.instance.getScoreLeft() +":"+Score.instance.getScoreRight(),
                (int)master.position.x-15,
                (int)(master.position.y+200));
    }
}
