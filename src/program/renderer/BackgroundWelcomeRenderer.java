package program.renderer;

import program.GameObject;
import program.Settings;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

import static java.awt.Color.PINK;

public class BackgroundWelcomeRenderer extends Renderer {
    BufferedImage image;

    public BackgroundWelcomeRenderer(BufferedImage image) {
        this.image = image;
    }

    public BackgroundWelcomeRenderer(String filePath) {
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
        g.setColor(PINK);
        g.setFont(Settings.Fixedsys);
        String text="PRESS ENTER TO START";

        g.drawString(text,(Settings.BACKGROUND_WIDTH/2- 175),Settings.BACKGROUND_HEIGHT/2);
    }
}
