package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {

    public void start(){

        while(true){
            //랜덤 숫자 배열 생성
            int[] question = makeQuestion();

            //3스트라이크면 중단
            boolean result = false;
            while(!result){

                /*
                System.out.println("랜덤 숫자입니다:");
                for(int i = 0; i<3; i++){
                    System.out.print(question[i]);
                }
                */

                System.out.print("숫자를 입력해주세요 : ");
                // 예외처리 필요
                int[] inputNumbers = inputNumbers();

                // 스트라이크, 볼 체크
                String check = check(question, inputNumbers);

                // 결과처리
                result = printResult(check);
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String str = Console.readLine();
            if(str.equals("2")){
                break;
            }
        }



    }

    public int[] makeQuestion(){
        int[] question = new int[3];
        for(int i = 0; i<3; i++){
            int n = Randoms.pickNumberInRange(1, 9);
            question[i] = n;
        }

        // 중복체크 필요
        boolean flag = duplicateCheck(question);
        if(flag==true){
            return question;
        }else{
            return makeQuestion();
        }
    }

    public boolean duplicateCheck(int[]question){
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                if(question[i]==question[j]&&i!=j){
                    return false;
                }
            }
        }
        return true;
    }

    public int[] inputNumbers(){
        int[] arr = new int[3];
        String str = Console.readLine();

            if(str.length()==3){
                String[] split = str.split("");
                for(int i = 0; i<3; i++){
                    int temp = Integer.parseInt(split[i]);
                    arr[i] = temp;
                }
                return arr;
            }else{
                throw new IllegalArgumentException();
        }



    }

    public String check(int question[], int inputNumbers[]){

        int strike = 0;
        int ball = 0;

        // 존재여부 동일성, 위치 동일성 판별
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                if(question[i]==inputNumbers[j]&&i==j){
                    strike++;
                }
                else if(question[i]==inputNumbers[j]&&i!=j){
                    ball++;
                }
            }
        }

        // 결과를 어떻게 return 해줘야할까
        return Integer.toString(strike)+Integer.toString(ball);
    }

    public boolean printResult(String check){
        String[] split = check.split("");

        if(split[0].equals("3")){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        else if(split[0].equals("0")&&split[1].equals("0")){
            System.out.println("낫싱");
            return false;
        }else if(split[0].equals("0")){
            System.out.println(split[1]+"볼");
            return false;
        }else if(split[1].equals("0")){
            System.out.println(split[0]+"스트라이크");
            return false;
        }else{
            System.out.println(split[1]+"볼 "+split[0]+"스트라이크");
            return false;
        }
    }
}
