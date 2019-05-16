package program;

import program.ball.Ball;
import program.goal.Goal;
import program.menu.ScoreAndTimer;
import program.player.*;
import program.scene.SceneManager;
import program.scene.welcome.SceneWelcome;
import program.wall.HorizontalWall;
import program.wall.VerticalWall;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    Background background;
    Player leftGoalkeeper;
    Player leftMidfielder;
    Player rightMidfielder;
    Player rightGoalkeeper;
    Goal leftGoal;
    Goal rightGoal;
    Ball ball;
    VerticalWall leftVerticalWall;
    VerticalWall rightVerticalWall;
    HorizontalWall upHorizontalWall;
    HorizontalWall downHorizontalWall;

    public GamePanel() {
        SceneManager.signNewScene(new SceneWelcome());
//        background = new Background();
//
//        leftVerticalWall = new VerticalWall(0, 0);
//        rightVerticalWall = new VerticalWall(Settings.GAME_WIDTH-10, 0);
//        upHorizontalWall= new HorizontalWall(0,0);
//        downHorizontalWall=new HorizontalWall(Settings.GAME_HEIGHT-10,0);
//
//        leftGoal =new Goal(Settings.NET_WIDTH/2+1,Settings.GAME_HEIGHT/2);
//        rightGoal =new Goal(Settings.GAME_WIDTH-Settings.NET_WIDTH/2-1,Settings.GAME_HEIGHT/2);
//
//        leftGoalkeeper =new Player1();
//        leftMidfielder =new Player2();
//        rightMidfielder =new Player3();
//        rightGoalkeeper =new Player4();
//
//        ball=new Ball();

    }



    @Override
    public void paint(Graphics g) {
//        g.setColor(Color.BLACK);
//        g.fillRect(0, 0, Settings.GAME_WIDTH, Settings.GAME_HEIGHT);

        for(int i=0;i< GameObject.botLayer.size();i++){
            GameObject object=GameObject.botLayer.get(i);
            if(object.active)object.render(g);
        }

        for(int i=0;i< GameObject.midLayer.size();i++){
            GameObject object=GameObject.midLayer.get(i);
            if(object.active)object.render(g);
        }

        for(int i=0;i< GameObject.topLayer.size();i++){
            GameObject object=GameObject.topLayer.get(i);
            if(object.active)object.render(g);
        }

    }

    public void runAll() {
        for (int i = 0; i < GameObject.objects.size(); i++) {
            GameObject object = GameObject.objects.get(i);
            if (object.active)
                object.run();
        }
    }

    public void gameLoop() {
        long lastTime = 0;

        while(true) {
            long currentTime = System.currentTimeMillis();
            if(currentTime - lastTime >= 1000 / Settings.FPS) {
                this.repaint(); // render anh
                this.runAll(); // chay logic
                lastTime = currentTime;
            }
        }
    }
}
