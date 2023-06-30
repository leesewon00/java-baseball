package baseball.game;

public class Count {
    private int strike;
    private int ball;

    Count(){
        strike = 0;
        ball = 0;
    }

    public int getStrike(){
        return strike;
    }
    public int getBall(){
        return ball;
    }
    public void countUpStrike(){
        this.strike++;
    }
    public void countUpBall(){
        this.ball++;
    }
}
