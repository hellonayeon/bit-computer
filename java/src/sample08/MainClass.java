package sample08;

public class MainClass {

    public static void main(String[] args) {
        /*
         * break == 탈출
         * switch, for, while
         *
         *
         * continue == skip (생략)
         *
         * */

        for (int i=0; i<100; i++) {
            System.out.println("i = " + i);
            if (i == 49) {
                break;
            }
        }

        char array[] = { 'a', 'b', 'c', 'd', 'e' };
        for (int i = 0; i < array.length; i++) {
            System.out.print("array[" + i + "] = " + array[i]);

            if (array[i] == 'c') {
                break;
            }
        }

        // 2중 for문을 탈출
        // 1. loop 수에 break 설정
        boolean b = false;
        for (int i=0; i<10; i++) {
            System.out.println("i = " + i);
            for (int j=0; j<6; j++) {
                System.out.println("   j = " + j);

                if (i == 3 && j == 2) {
                    b = true;
                    break;
                }
            }
            if (b == true) {
                break;
            }
        }

        // 2. break 설정
        out: for (int i=0; i<10; i++) {
            System.out.println("i = " + i);
            for (int j=0; j<6; j++) {
                System.out.println("   j = " + j);

                if (i == 4 && j == 3) {
                    break out;
                }
            }
        }

        /*
         * continue: for, while
         *
         * */

        for (int i=0; i<10; i++) {
            System.out.println("for i = " + i);

            if (i > 5) {
                continue;
            }

            System.out.println("for end process");
        }
    }

}