package work02;

import java.util.Arrays;
import java.util.Scanner;

public class Answer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r_num[] = new int[3];
        int u_num[] = new int[3];
        boolean clear = false;
        String nextGame = "";

        while (true) {
            boolean swit[] = new boolean[10];
            for (int i = 0; i < swit.length; i++) {
                swit[i] = false;
            }

            int w = 0;
            while (w < 3) {
                int r = (int) (Math.random() * 10); // 0 ~ 9
                if (swit[r] == false) {
                    swit[r] = true;
                    r_num[0] = r + 1;
                    w++;
                }
            }

            System.out.println(Arrays.toString(r_num));

            // 판정
            w = 0;
            while (w < 10) {
                for (int i = 0; i < u_num.length; i++) {
                    System.out.print((i + 1) + "번째 수 = ");
                    u_num[i] = sc.nextInt();
                }

                int strike = 0;
                int ball = 0;

                // ball
                for (int i = 0; i < u_num.length; i++) {
                    for (int j = 0; j < u_num.length; j++) {
                        if (u_num[i] == r_num[j] && i != j) {
                            ball++;
                        }
                    }
                }

                // strike
                for (int i = 0; i < u_num.length; i++) {
                    if (u_num[i] == r_num[i]) {
                        strike++;
                    }
                }

                if (strike > 2) {
                    clear = true;
                    break;
                }

                System.out.println(strike + "스트라이크 " + ball + "볼 입니다");

                w++;
            }

            if (clear) {
                System.out.println("Game Clear !");
            } else {
                System.out.println("Game Over ~");
                break;
            }

            System.out.println("play again(y/n) = ");
            nextGame = sc.next();

            if (!nextGame.equals("y")) {
                System.out.println("Next Game Start!!");
            }
        }
    }
}
