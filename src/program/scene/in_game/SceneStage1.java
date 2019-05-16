package program.scene.in_game;

import program.*;
import program.ball.Ball;
import program.goal.Goal;
import program.menu.ScoreAndTimer;
import program.player.*;
import program.scene.Scene;

public class SceneStage1 extends Scene {
    @Override
    public void init() {
//goi ra player,background,ball,net
        GameObject.recycle(Player.class);
        GameObject.recycle(Background.class);
        GameObject.recycle(Ball.class);
        GameObject.recycle(Goal.class);
        GameObject.recycle(ScoreAndTimer.class);

        Player leftGoalkeeper = new Player1();
        Player leftMidfielder = new Player2();
        Player rightMidfielder = new Player3();
        Player rightGoalkeeper = new Player4();
        Goal leftGoal = new Goal(Settings.NET_WIDTH/2+1,Settings.BACKGROUND_HEIGHT/2);
        Goal rightGoal =new Goal(Settings.BACKGROUND_WIDTH-Settings.NET_WIDTH/2-1,Settings.BACKGROUND_HEIGHT/2);
        ScoreAndTimer menu=new ScoreAndTimer();

    }

    @Override
    public void clear() {
        GameObject.clearAll();


    }

}
