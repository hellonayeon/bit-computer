package sample06;

public class MainClass {

    public static void main(String[] args) {
        /*
         * 제어문
         *
         * if ( 조건 ) { == true / false
         * 		처리
         * }
         *
         * > <= == >= <= !=
         * && || !
         *
         * */

        int number = 5;

        // 복합 처리 (블록문)
        if (number > 0) {
            System.out.println("number > 0");
        }

        // 단일 처리
        if (number > 0)
            System.out.println("number > 0");

        if (number > 0 && number < 10) {
            System.out.println("number > 0 && number < 10");
        }

        if (number < 0 || number > 10) {
            System.out.println("number < 0 || number > 10");
        }

        // else

        if (number < 0) {
            System.out.println("number < 0");
        }
        else {
            System.out.println("number >= 0");
        }

        String str = (number < 0) ? "number < 0" : "number >= 0";
        System.out.println("str = " + str);

        number = 90;

        if (number > 90) {
            System.out.println("number > 90");
        }
        else if (number > 80) {
            System.out.println("number > 80");
        }
        else if (number > 70) {
            System.out.println("number > 70");
        }
        else {
            System.out.println("number <= 70");
        }


        if (number > 70) {
            System.out.println("number > 70");
        }
        else if (number > 80) {
            System.out.println("number > 80");
        }
        else if (number > 90) {
            System.out.println("number > 90");
        }
        else {
            System.out.println("number <= 70");
        }


        number = 95; 	// 95 이상 A+
        // 95 미만 A

        if (number >= 90 && number <= 100) {
            if (number >= 95) {
                System.out.println("A+ 입니다");
            }
            else {
                System.out.println("A 입니다");
            }
        }

        boolean b = false;
        if (b == false) { // 권장
            System.out.println("b == false");
        }
        if (!b) {
            System.out.println("!b");
        }
        if (b) {

        }

        String _str = "hello";
        if (!_str.equals("world")) {
            System.out.println("_str은 hello가 아닙니다");
        }

        if (_str.contains("he")) {
            System.out.println("_str은 he를 포함하고 있습니다");
        }


        // switch
        /*
         * 조건문과 비슷하다.
         * 값이 명확해야 한다.
         * 범위를 지정할 수 없다.
         * 실수를 사용할 수 없다. (소수점 사용 불가)
         *
         * 조건문보다 switch문이 속도가 더 빠름
         *
         *
         * */

        int n = 2;

        switch ( n ) {
            case 1:	// if (n == 1)
                // 처리
                System.out.println("n은 1 입니다");
                break;
            case 2:
                System.out.println("n은 2 입니다");
                break;
            default:
                System.out.println("n은 1도 2도 아닙니다");
                break;

        }

        String str1 = "hello";
        switch (str) { // C언어에서는 불가능
            case "hello":
                System.out.println("str1은 hello");
                break;
        }

//		double d = 1.2;
//		switch (d) {
//			case 1.2:
//			break;
//		}
//
//		switch (n) {
//		case n > 1:
//			break;
//		}
    }

}