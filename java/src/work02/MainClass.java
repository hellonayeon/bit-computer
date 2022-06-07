package work02;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        /*
         * Baseball
         *
         * random 3개
         *
         * 1 ~ 10 -> 3개 뽑기
         * 3 7 2 -> r1 != r2 != r3
         *
         * user input -> 3개 입력		최대 10회
         * 4 5 2 -> 1 strike
         * 1 9 3 -> 1 ball
         *
         * */

        // 사용자 입력과 baseball 같은 인덱스 확인
        // 1. 내용물이 같다면 strike
        // 2. 내용물이 다르다면, 이전에 그 값이 나왔는지 확인
        //	  이전에 나왔다면 ball 안나왔다면 아무 처리 X
        // 입력 받을 때 boolean[] chk - 이전에 나왔는지 체크

        Scanner sc = new Scanner(System.in);

        int[] baseball = new int[3];
        int bIdx = 0;
        boolean[] before = new boolean[11];
        int[] user;

        // 랜덤 숫자 3개 뽑기

        while (bIdx < 3) {
            int random = (int) (Math.random() * 10 + 1);
            if (before[random]) {
                continue;
            }
            baseball[bIdx++] = random;
            before[random] = true;
        }

        int cnt = 10;
        while (cnt-- > 0) {
            // 사용자로부터 3개 입력받기
            int uIdx = 0;
            user = new int[3];
            while (uIdx < 3) {
                int input = sc.nextInt();
                if (input < 1 || input > 10) {
                    System.out.println("range 1 ~ 10. retry.");
                    continue;
                }
                user[uIdx++] = input;
            }

            int strike = 0, ball = 0;
            for (int i=0; i<3; i++) {
                if (baseball[i] == user[i]) {
                    strike++;
                }
                else {
                    if (before[user[i]]) {
                        ball++;
                    }
                }
            }

            if (strike == 3) {
                System.out.println("3 strike !!");
                break;
            }
            else {
                System.out.println("strike = " + strike + "\t" + "ball = " + ball);
            }
        }

        if (cnt == -1) {
            System.out.println("Fail :(");
        }

        System.out.print("[baseball] ");
        for (int i=0; i<3; i++) {
            System.out.print(baseball[i] + " ");
        }
    }
}