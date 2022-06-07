package sample10;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        /*
        * function: 함수                C 언어
        * method: class 에 소속된 함수     Java
        *
        * return 값의 자료형 함수명 ( 인수, 인자, parameter ) {
        *       // 처리
        *       // return 돌려주는 값
        * }
        *
        * parameter: num 가인수
        * argument: 123 실인수
        *
        * func( 123 );
        *
        * void func(int num) {}
        * */

//        int n = 1;
//        char c = 'A';
//        int[] arr = { 1, 2, 3 };
//
//        func(n, c, arr);
//
//        System.out.println("n = " + n);
//        System.out.println("arr[1] = " + arr[1]);
//
//        /* TODO WORK */
//        // 문자열 -> 모두 숫자로 되어 있는지?
//        //      -> 정수 또는 소수인지 판별
//
//        // boolean isNumber
//        // String isDouble (소수점의 유무만 확인하면 되는가)
//        // Exception 처리
//
        Scanner sc = new Scanner(System.in);
//        System.out.print("[숫자 판별] 문자열 입력: ");
//        String num = sc.next();
//
//        boolean isNumber = isNumber(num);
//        String msg = isDouble(num + "");
//        System.out.println(msg);
//
//        // 문자열에 소문자가 포함되어 있는지?
//        String word = sc.next();
//        if (isContainLowerLetter(word)) {
//            System.out.println("소문자가 포함되어 있습니다.");
//        }
//        else {
//            System.out.println("소문자가 포함되지 않았습니다.");
//        }

        // 두 수를 나눈 몫과 나머지를 구하는 함수 => 1개의 함수
        int num1, num2;
        int tag[] = new int[1];

        num1 = sc.nextInt();
        num2 = sc.nextInt();

        // buffer problem
//        while (true) {
//            num2 = sc.nextInt();
//            if (num2 == 0) {
//                System.out.println("0 으로 나눌 수 없습니다.");
//                continue;
//            }
//            break;
//        }

        double[] res = divide(num1, num2);
        System.out.println("몫 = " + res[0] + ", 나머지 = " + res[1]);

    }

    static void func() {
        System.out.println("func() 호출");
    }

    static void func(int i) {
        System.out.println("func(int i) i = " + i);
    }
    //               [ value 의 할당 ] [ address 의 할당 ]
    static void func(int i, char c, int[] arr) {
        System.out.println("func(int i, char c, int[] arr)");
        System.out.println("i = " + i);

        arr[1] = 22;
    }

    static boolean isNumber(String str) {
        for (int i=0; i<str.length(); i++) {
            int ch = str.charAt(i);
            if (ch < 48 || ch > 57) {
                return false;
            }
        }
        return true;
    }

    static String isDouble(String snum) {
        String msg = "정수";

        for (int i=0; i<snum.length(); i++) {
            char c = snum.charAt(i);
            if (c == '.') {
                msg = "소수";
                break;
            }
        }
        return msg;
    }

    static boolean isContainLowerLetter(String word) {
        for (int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                return true;
            }
        }
        return false;
    }

    static double[] divide(int n1, int n2) {
        return new double[]{(n1/(double) n2), (n1 % n2)};
    }

    static int div(int n1, int n2, int[] t) {
        int val = n1 / n2;
        t[0] = n1 % n2;

        return val;
    }
}
