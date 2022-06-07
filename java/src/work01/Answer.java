package work01;

public class Answer {

    public static void main(String[] args) {
        /* [1] 10진수 to 2진수 */
        int number = 256;
        int oldNumber = number;
        int tag; // 나눈 나머지를 구할 변수
        String numStr = ""; // 2진수를 출력할 변수

        while (true) {
            tag = number % 2;
            numStr = tag + numStr; // 자동 형변환 (int + String)
            if (number / 2 == 0) {
                break;
            }
            number = number / 2;
        }

//		numStr = Integer.toBinaryString(oldNumber);
        System.out.println(oldNumber + "의 2진수는 " + numStr + "입니다");


        /* [2] 2진수 to 10진수 */
        numStr = "10101100";
        int len = numStr.length();
        char cNum; // 한 글자 한 글자를 가져오기 위한 변수
        int n, n1; // n: 숫자, n1: 승수
        int number10 = 0;

        int oldLen = len;
        for (int i = 0; i < oldLen; i++) {
            cNum = numStr.charAt(i);

            n = Integer.parseInt(cNum + "");
            n1 = (int) Math.pow(2, len-1);
            n = n * n1;

            len--;
            number10 = number10 + n;
        }

//		number10 = Integer.parseInt(numStr, 2);
        System.out.println(numStr + "의 10진수는 " + number10 + "입니다");


        /* [3] 10진수 to 16진수 */
        number = 58;
        String numStr16 = "";
        String strInt = ""; // 0 ~ 9  or  A ~ F ?
        int tag16;

        oldNumber = number;

        while (true) {
            tag16 = number % 16;

            switch (tag16) {
                case 10:
                    strInt = "A";
                    break;
                case 11:
                    strInt = "B";
                    break;
                case 12:
                    strInt = "C";
                    break;
                case 13:
                    strInt = "D";
                    break;
                case 14:
                    strInt = "E";
                    break;
                case 15:
                    strInt = "F";
                    break;
                default:
                    strInt = Integer.toString(tag16);
            }

            numStr16 = strInt + numStr16;
            if (number / 16 == 0) {
                break;
            }
            number = number / 16;
        }

//		numStr16 = Integer.toHexString(number); ** TODO: 제대로된 결과 안나옴 **
        System.out.println(oldNumber + "의 16진수는 0x" + numStr16 + "입니다");


        /* [4] 16진수 to 10진수 */
        String str = "3A";
        int len16 = str.length();

        String n16; // 0 ~ 9 A ~ F
        int oldLen16 = len16;
        int powNum;
        int number16 = 0;
        int num16;

        for (int i = 0; i < oldLen16; i++) {

            n16 = str.charAt(i) + "";
            if (n16.equals("A")) {
                n16 = "10";
            }
            else if (n16.equals("B")) {
                n16 = "11";
            }
            else if (n16.equals("C")) {
                n16 = "12";
            }
            else if (n16.equals("D")) {
                n16 = "13";
            }
            else if (n16.equals("E")) {
                n16 = "14";
            }
            else if (n16.equals("F")) {
                n16 = "15";
            }

            powNum = (int) Math.pow(16, len16 - 1);
            num16 = Integer.parseInt(n16) * powNum;

            number16 = number16 + num16;
            len16--;
        }

        number10 = Integer.parseInt(numStr, 16);
        System.out.println("0x" + str + "의 10진수는 " + number16 + "입니다");


        /*
         * 입력받은 문자열이 모두 숫자로 되어 있는지 확인
         *
         * -> 숫자로 되어 있습니다.
         * -> 숫자가 아닙니다.
         *
         * */


        String strNum = "1234";
        boolean numTrue = true;

        for (int i=0; i<strNum.length(); i++) {
            char c = strNum.charAt(i);

            int asc = (int)c;
            if (asc < 48 || asc > 57) {
                numTrue = false;
                break;
            }
        }

        if (numTrue) {
            System.out.println("숫자로 되어있습니다.");
        }
        else {
            System.out.println("숫자가 아닙니다.");
        }
    }
}