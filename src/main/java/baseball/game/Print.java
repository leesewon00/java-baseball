package baseball.game;

public class Print {
    public String printResult(Count count){
        int ball = count.getBall();
        int strike = count.getStrike();
        String result = "";

        if(strike==0&&ball==0){
            result += "낫싱";
        }
        if(ball>0) {
            result += ball + "볼 ";
        }
        if(strike>0){
            result += strike + "스트라이크";
        }
        if(strike==3){
            result += "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }
        return result;
    }
}
