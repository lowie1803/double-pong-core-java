package program.scene.welcome;

import program.Background;
import program.GameObject;
import program.scene.Scene;
import program.scene.welcome.BackgroundWelcome;

public class SceneWelcome extends Scene {
    @Override
    public void init(){
    GameObject.recycle(BackgroundWelcome.class);

    }
    @Override
    public void clear(){
        GameObject.clearAll();
        //GameObject.clearAll(BackgroundWelcome.class);
    }
}
