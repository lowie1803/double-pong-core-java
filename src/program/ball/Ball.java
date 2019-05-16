package program.ball;

import program.*;
import program.goal.Goal;
import program.menu.ScoreAndTimer;
import program.physics.BoxCollider;
import program.player.Player;
import program.player.Player1;
import program.player.Player2;
import program.player.Score;
import program.renderer.SingleImageRenderer;
import program.scene.SceneManager;
import program.scene.game_over.SceneGameOver;
import tklibs.AudioUtils;

import javax.sound.sampled.Clip;
import java.util.Random;

import static java.lang.StrictMath.abs;

public class Ball extends GameObject {

    Random rdWidth=new Random();

    Random rdHeight=new Random();
    Clip padHit, wallHit;

    public Ball() {
        GameObject.midLayer.add(this);
        renderer = new SingleImageRenderer("images/ball/1.png");
        position.set(Settings.BACKGROUND_WIDTH/2, Settings.BACKGROUND_HEIGHT/2);
        velocity.set(Settings.BALL_VELOCITY_X, 0);
        velocity.setAngle(Math.PI );
        hitBox = new BoxCollider(this, Settings.BALL_WIDTH, Settings.BALL_HEIGHT);
        padHit = AudioUtils.loadSound("audio/ball-pad.wav");
        wallHit = AudioUtils.loadSound("audio/ball-wall.wav");
    }


    public void run() {
        super.run();
        this.move();
        this.paddleIntersect();

        this.Goal();
    }


    private void Goal() {
        Goal net=GameObject.findIntersects(Goal.class,this.hitBox);
        if(net!=null)
        {
            this.velocity.set(0,0);
//            for (GameObject gObject: )
//            for (int i = 0; i < objects.size(); i++) {
//                GameObject gObject=objects.get(i);
////                if (gObject.getClass().isAssignableFrom(Player.class)) gObject.resetPosition();
//            }
            if(net.position.x<Settings.BACKGROUND_WIDTH/2) {
                Score.instance.updateScoreRight();
                this.velocity.setAngle(-Math.PI);
            }
            else {
                    Score.instance.updateScoreLeft();
                    this.velocity.setAngle(0);
                }
                this.position.set(Settings.BACKGROUND_WIDTH/2, Settings.BACKGROUND_HEIGHT/2);
            }

    }



    public void move() {

        if(this.outBoundRight() && this.onGoingRight()) {
            this.reverseVelocityX();
            AudioUtils.replay(wallHit);
        }
        if(this.outBoundLeft() && this.onGoingLeft()) {
            this.reverseVelocityX();
            AudioUtils.replay(wallHit);

        }
        if(this.outBoundUp()&& this.onGoingTop()){
            this.reverseVelocityY();
            AudioUtils.replay(wallHit);
        }


        if(this.outBoundDown()&&this.onGoingDown()) {
            this.reverseVelocityY();
            AudioUtils.replay(wallHit);
        }

    }


    private boolean outBoundUp() {
        return this.position.y<=this.anchor.y* Settings.BALL_HEIGHT+Settings.HORIWALL_HEIGHT;
    }
    private boolean outBoundDown() {
        return this.position.y>=Settings.BACKGROUND_HEIGHT-this.anchor.y*Settings.BALL_HEIGHT-Settings.HORIWALL_HEIGHT;
    }
    private boolean outBoundRight() {
        return this.position.x >= Settings.BACKGROUND_WIDTH
                - this.anchor.x * Settings.BALL_WIDTH-Settings.VERWALL_WIDTH;
    }

    private boolean outBoundLeft() {
        return this.position.x <= this.anchor.x * Settings.BALL_WIDTH+Settings.VERWALL_WIDTH;
    }

    private boolean onGoingTop() {
        return this.velocity.y<0;
    }
    private boolean onGoingDown() {
        return this.velocity.y>0;
    }
    private boolean onGoingRight() {
        return this.velocity.x > 0;
    }

    private boolean onGoingLeft() {
        return this.velocity.x < 0;
    }

    public void reverseVelocityX() {
        this.velocity.setX(-this.velocity.x);
    }
    public void reverseVelocityY() {
        this.velocity.setY(-this.velocity.y);
    }
    public void reverseVelocity(){this.velocity.set(-this.velocity.x,-this.velocity.y);}

    private void reclampPosition(Player player)
    {
        //reclamp the position of the ball to 4 sides of the paddle
        Vector2D clampLeft = position.clone();
        Vector2D clampRight = position.clone();
        Vector2D clampUp = position.clone();
        Vector2D clampDown = position.clone();

        clampLeft.setX(player.position.x-Settings.PLAYER_WIDTH/2-Settings.BALL_WIDTH/2-1);
        clampRight.setX(player.position.x+Settings.PLAYER_WIDTH/2+Settings.BALL_WIDTH/2+1);
        clampUp.setY(player.position.y-Settings.PLAYER_HEIGHT/2-Settings.BALL_HEIGHT/2-1);
        clampDown.setY(player.position.y+Settings.PLAYER_HEIGHT/2+Settings.BALL_HEIGHT/2+1);

        if (position.manhattanDistance(clampRight)>position.manhattanDistance(clampLeft)) clampRight=clampLeft.clone();
//        if (velocity.x>0) clampRight=clampLeft.clone();
        if (position.manhattanDistance(clampDown)>position.manhattanDistance(clampUp)) clampDown=clampUp.clone();
//        if (velocity.y>0) clampDown=clampUp.clone();
        if (position.manhattanDistance(clampRight)>position.manhattanDistance(clampDown)) clampRight=clampDown.clone();
        position.set(clampRight);
    }


    public void paddleIntersect(){
        Player player=GameObject.findIntersects(Player.class,this.hitBox);

        if(player != null) {
            reclampPosition(player);

            Vector2D anchorDistance = new Vector2D(this.position.x-player.position.x, this.position.y-player.position.y);
            velocity=anchorDistance;
            velocity.setLength(Settings.BALL_VELOCITY_X);
            AudioUtils.replay(padHit);
        }
    }
}
