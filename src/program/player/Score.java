package program.player;

public class Score  {
    public static Score instance = new Score();

    int scoreRight;
    int scoreLeft;
    public Score(){
        scoreLeft=0;
        scoreRight=0;
    }

    public void updateScoreLeft() {
        this.scoreLeft++;
    }
    public void updateScoreRight(){
        this.scoreRight++;
    }

    public int getScoreRight() {
        return scoreRight;
    }

    public int getScoreLeft() {
        return scoreLeft;
    }

    public void reset() {
        this.scoreLeft =0;
        this.scoreRight = 0;
    }
}
