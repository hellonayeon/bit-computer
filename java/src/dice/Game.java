package dice;

import java.util.Scanner;

public class Game {
    private final int[] money = { 6, 7, 9, 12, 18 };

    Scanner sc = new Scanner(System.in);

    private Dice dice1 = new Dice(); // composition 객체 안에서 객체 생성
    private Dice dice2 = new Dice();
    private int tCoin = 20;
    private int bCoin;
    private int userNumber;

    public void play() {

        while (true) {
            rollDice();
            inputBCoin();
            inputNumber();
            finding();
            result();

            System.out.print("계속 진행 (y/n): ");
            String run = sc.next();

            if (run.equals("n")) {
                break;
            }
        }
    }

    // 주사위 (1, 1) (6, 6) 경우 제외
    private void rollDice() {
        do {
            dice1.setNumber();
            dice2.setNumber();

        } while (!isPossibleDiceNumber());
        System.out.println("랜덤 주사위 번호 (" + dice1.getNumber() + ", " + dice2.getNumber() + ")");
    }

    private boolean isPossibleDiceNumber() {
        return !((dice1.getNumber() == 1 && dice2.getNumber() == 1)
                || (dice1.getNumber() == 6 && dice2.getNumber() == 6));
    }

    private void inputBCoin() {
        while (true) {
            System.out.print("배팅할 코인 수: ");
            bCoin = sc.nextInt();

            if (bCoin <= tCoin) {
                break;
            }

            System.out.println("코인이 부족합니다.");
        }

        tCoin -= bCoin;
    }

    private void inputNumber() {
        while (true) {
            System.out.print("예측한 두 주사위의 합: ");
            userNumber = sc.nextInt();

            if (userNumber == 2 || userNumber == 12) {
                System.out.println("2 또는 12는 불가능합니다.");
                continue;
            }

            if (userNumber < 3 || userNumber > 11) {
                System.out.println("3 ~ 11 까지의 수만 입력 가능합니다.");
                continue;
            }
            break;
        }
    }

    private void finding() {
        int diceSum = dice1.getNumber() + dice2.getNumber();

        if (diceSum == userNumber) {
            int mul = money[Math.abs(userNumber - 7)];
            int gCoin = mul*bCoin;

            tCoin += gCoin;

            System.out.println("예측 성공");
            System.out.println("배당금 " + mul + "배");
            System.out.println(gCoin + " 코인 획득 !");
        }
        else {
            System.out.println("예측 실패");
        }
    }

    private void result() {
        int diceNumber1 = dice1.getNumber();
        int diceNumber2 = dice2.getNumber();

        System.out.println("주사위 번호 (" + diceNumber1 + ", " + diceNumber2 + ")");
        System.out.println("두 주사위 합: " + (diceNumber1 + diceNumber2));

        System.out.println("예측한 주사위 합: " + userNumber);
        System.out.println("현재 코인: " + tCoin);
    }
}
