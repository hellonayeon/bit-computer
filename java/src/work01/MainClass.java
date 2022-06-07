package work1;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. 10진수 to 2진수");
            System.out.println("2. 2진수 to 10진수");
            System.out.println("3. 10진수 to 16진수");
            System.out.println("4. 16진수 to 10진수");
            System.out.println("0. 종료\n");
            System.out.println("어느 작업을 하시겠습니까?");

            int num = sc.nextInt();
            if (num == 0) {
                break;
            }


            String res = null;
            if (num == 1) {
                System.out.print("10진수를 입력하세요: ");
                int dec = sc.nextInt();

                res = decToDigit(dec);
            }
            else if (num == 2) {
                System.out.print("2진수를 입력하세요: ");
                String digit = sc.next();

                res = digitToDec(digit);
            }
            else if (num == 3) {
                System.out.print("10진수를 입력하세요: ");
                int dec = sc.nextInt();

                res = decToHex(dec);
            }
            else {
                System.out.print("2진수를 입력하세요: ");
                String digit = sc.next();

                res = hexToDec(digit);
            }

            System.out.println(res);
            System.out.println();
        }

        sc.close();


        /*
         * 입력받은 문자열이 모두 숫자로 되어 있는지 확인
         *
         * -> 숫자로 되어 있습니다.
         * -> 숫자가 아닙니다.
         *
         * */

        String input = "123124";
        boolean isNum = true;
        for (int i=0; i<input.length(); i++) {
            char ch = input.charAt(i);
            if (ch < '0' || ch > '9') {
                isNum = false;
                break;
            }
        }
        System.out.println( (isNum) ? "숫자로 되어있습니다." : "숫자가 아닙니다." );

    }

    private static String decToDigit(int dec) {
        StringBuilder sb = new StringBuilder();

        while (dec > 0) {
            sb.append(dec%2);
            dec/=2;
        }

        return sb.reverse().toString();
    }


    private static String digitToDec(String digit) {
        int res = 0, mul = 1;

        for (int i=digit.length()-1; i>=0; i--) {
            res += (digit.charAt(i) - '0') * mul;
            mul*=2;
        }

        return Integer.toString(res);
    }

    private static String decToHex(int dec) {
        StringBuilder sb = new StringBuilder();

        while (dec > 0) {
            int remain = dec%16;
            if (remain < 10) {
                sb.append(remain);
            }
            else {
                sb.append((char)(87 + remain));
            }
            dec/=16;
        }

        sb.append("x0");
        return sb.reverse().toString();
    }

    private static String hexToDec(String hex) {
        int res = 0, mul = 1;

        for (int i=hex.length()-1; i>=0; i--) {
            char ch = hex.charAt(i);
            int num = (ch >= 'a' && ch <= 'f') ? (int)ch - 87 : (ch - '0');
            res += num * mul;
            mul*=16;
        }

        return Integer.toString(res);
    }

}