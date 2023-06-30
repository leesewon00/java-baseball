package baseball.game;

import java.util.ArrayList;
import java.util.Objects;

public class Check {
    public boolean duplicateCheck(ArrayList<Integer> question){
        for(int i = 0; i<question.size(); i++){
            for(int j = 0; j<question.size(); j++){
                // 중복 o
                if(Objects.equals(question.get(i), question.get(j)) &&i!=j){
                    return false;
                }
            }
        }
        // 중복 x
        return true;
    }

    public Count checkResult(ArrayList<Integer> question, ArrayList<Integer> inputNumbers){
        // strike ball check
        Count count = new Count();

        // 존재여부 동일성, 위치 동일성 판별
        for(int i = 0; i<question.size(); i++){
            for(int j = 0; j<question.size(); j++){
                if(Objects.equals(question.get(i), inputNumbers.get(j))){
                    if(i==j){
                        count.countUpStrike();
                    }
                    if(i!=j){
                        count.countUpBall();
                    }
                }
            }
        }

        // count 객체를 return
        return count;
    }
}
