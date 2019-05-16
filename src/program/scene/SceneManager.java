package program.scene;

public class SceneManager {
    public static Scene currentScene;

    /**
     * Ham dung de dua 1 scene moi vao game
     * 2 nhiem vu chinh:init scene moi va clear scene cu
     * @param newScene:scene moi can dua vao
     */
    public static void signNewScene(Scene newScene){
        if(currentScene!=null){
            currentScene.clear();
        }
        newScene.init();
        currentScene = newScene;
    }
}
