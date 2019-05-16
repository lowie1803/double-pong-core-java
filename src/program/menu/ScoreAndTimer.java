package program.menu;

import program.GameObject;
import program.Settings;
import program.goal.Goal;
import program.player.Score;
import program.scene.SceneManager;
import program.scene.game_over.SceneGameOver;

import java.awt.*;

public class ScoreAndTimer extends GameObject {
    private int time;
    private int minute;
    private int second;
    public ScoreAndTimer(){
        GameObject.topLayer.add(this);
        position.set(0,Settings.BACKGROUND_HEIGHT);
        time=0;
        minute=0;
        second=0;
    }
    @Override
    public void render(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect((int)this.position.x,
                    (int)this.position.y,
                Settings.BACKGROUND_WIDTH,
                Settings.GAME_HEIGHT-Settings.BACKGROUND_HEIGHT);
//Ty so
        g.setColor(Color.YELLOW);
        g.setFont(Settings.Fixedsys);
        g.drawString(Score.instance.getScoreLeft() + "-"+ Score.instance.getScoreRight(),
                    Settings.BACKGROUND_WIDTH/2-25,
                        Settings.GAME_HEIGHT-55 );
//        System.out.println((Settings.BACKGROUND_WIDTH/2-25)+" "+(Settings.GAME_HEIGHT-55));
//Thoi gian
        g.setColor(Color.RED);
        g.setFont(Settings.Fixedsys);
        minute=time/60;
        second=time%60;
        g.drawString(minute+":"+second,Settings.BACKGROUND_WIDTH*3/4,Settings.GAME_HEIGHT-55);
    }
    @Override
    public void run(){
        this.start();
        this.endGame();
    }
    int count=0;
    public void start(){
        count++;
//        if (time%10==0) Settings.BALL_VELOCITY_X++;
        if(count>Settings.FPS){
            time++;
            if (time%10==0)
            {
                Settings.BALL_VELOCITY_X+=Settings.BALLSPEED_INCREASER;
                Settings.PLAYER_SPEED+=Settings.PLAYERSPEED_INCREASER;
            }
            count=0;
        }

    }
    public void endGame(){
        if(time>Settings.MATCHTIME){
            SceneManager.signNewScene(new SceneGameOver());
            time=0;
            Settings.reset();
            scoreLeft=0;
            scoreRight=0;
        }
    }

    public  int getMatchTime()
    {
        return time;
    }

}
