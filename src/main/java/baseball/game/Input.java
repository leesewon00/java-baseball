package baseball.game;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

import static java.lang.Integer.*;

public class Input {
    public ArrayList<Integer> getInputNumbers(){
        String str = Console.readLine();
        String[] split = str.split("");

        // input check
        if(str.length()!=3){
            throw new IllegalArgumentException();
        }
        if(str.contains("0")){
            throw new IllegalArgumentException();
        }

        // arraylist 로 변환
        ArrayList<Integer> arr = new ArrayList<>(); // return 해줄 것
        for(int i = 0; i<3; i++){
            int temp = parseInt(split[i]);
            arr.add(temp);
        }

        // 중복 check
        Check check = new Check();
        boolean isDuplicate = check.duplicateCheck(arr);

        if(!isDuplicate){
            throw new IllegalArgumentException();
        }

        return arr;
    }

}
