package work05;

import java.util.Scanner;

public class MainClass {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int num1, num2, res;
        String op;

        // 숫자가 입력이 안되면 다시 입력
        num1 = inputNumber();
        num2 = inputNumber();

        // 연산자 정상 입력
        op = inputOperator();

        res = calc(num1, num2, op);

        System.out.println("결과: " + res);
    }

    private static int inputNumber() {
        String str;
        while (true) {
            System.out.print("숫자 입력: ");
            str = sc.next();
            if (isNumber(str)) {
                break;
            }

            System.out.println("0~9 숫자만 입력 가능합니다.");
        }

        return Integer.parseInt(str);
    }

    private static boolean isNumber(String number) {
        for (int i=0; i<number.length(); i++) {
            int ch = number.charAt(i);

            if (ch < 48 || ch > 57) {
                return false;
            }
        }
        return true;
    }

    private static String inputOperator() {
        String str;
        while (true) {
            System.out.print("연산자 입력: ");
            str = sc.next();
            if (isOperator(str)) {
                break;
            }

            System.out.println("+, -, *, / 입력 가능합니다.");
        }

        return str;
    }

    private static boolean isOperator(String op) {
        return (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/"));
    }

    private static int calc(int num1, int num2, String op) {
        if (op.equals("+")) {
            return num1 + num2;
        }
        else if (op.equals("-")) {
            return num1 - num2;
        }
        else if (op.equals("*")) {
            return num1*num2;
        }
        else {
            try {
                return num1 / num2;
            } catch (ArithmeticException e) {
                System.out.println("0으로 나눌 수 없습니다.");
                return -1;
            }
        }
    }
}
