package program.scene.game_over;

import program.GameObject;
import program.player.Score;
import program.scene.Scene;

public class SceneGameOver extends Scene {
    @Override
    public void init(){
        GameObject.recycle(BackGroundGameOver.class);
    }
    @Override
    public void clear(){
        GameObject.clearAll();
        Score.instance.reset();

        //GameObject.clearAll(BackGroundGameOver.class);
    }
}
