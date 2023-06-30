package baseball.game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Game {

    public void start(){

        while(true){
            //랜덤 숫자 배열 생성
            ArrayList<Integer> question = makeQuestion();

            //3스트라이크면 중단
            boolean result = false;
            while(!result){

                // input
                Input input = new Input();
                System.out.print("숫자를 입력해주세요 : ");
                ArrayList<Integer> inputNumbers = input.getInputNumbers();

                // 스트라이크, 볼 체크
                Check check = new Check();
                Count count = check.checkResult(question, inputNumbers);

                // 결과처리
                Print print = new Print();
                String printResult = print.printResult(count);
                System.out.println(printResult);

                // 종료조건 처리
                if(count.getStrike()==3){
                    result = true;
                }
            }

            // restart or not
            boolean gameResume = gameResume();
            if(gameResume){
                continue;
            }
            break;
        }
    }

    public boolean gameResume(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String resume = Console.readLine();
        if(resume.equals("2")){
            return false;
        }
        return true;
    }

    public ArrayList<Integer> makeQuestion(){
        ArrayList<Integer> question = new ArrayList<>();
        for(int i = 0; i<3; i++){
            int n = Randoms.pickNumberInRange(1, 9);
            question.add(n);
        }

        // 중복체크 필요
        Check check = new Check();
        boolean isDuplicated = check.duplicateCheck(question);
        if(isDuplicated){
            return question;
        }
        return makeQuestion();
    }

}