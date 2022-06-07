package sample07;

public class MainClass {

    public static void main(String[] args) {

        // for loop 반복문, 순환문, 루프문
        // for
        // foreach (요즘 많이 사용)

        int n;
        for (n = 0; n < 10; n++) {
            System.out.println("n = " + n);
        }

        for (int i = 0; i < 10; i++) { // 반복문 끝나면 바로 stack 영역에서 해방
            System.out.println("i = " + i);
        }

        // ArrayIndexOutOfBoundsException
        for (int i = 1; i <= 100; i++) {
        }

        for (int i=0; i<10; i++) {
            for (int j=0; j<5; j++) {
                System.out.print(i + ":" + j + " ");
            }
            System.out.println();
        }

        int Array[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12}
        };

        for (int i = 0; i < Array.length; i++) {
            for (int j = 0; j < Array[i].length; j++) {
                System.out.print("Array[" + i + "][" + j + "] = " + Array[i][j] + "\t");
            }
            System.out.println();
        }

        int[] Arr = { 1, 2, 3};
        for (int num : Arr) { // javascript - for (let num in Arr) : return index
            System.out.println(num);
        }


        /*
         * 초기화
         * while (조건식) {
         * 		처리
         * 		연산식
         * }
         *
         * do {
         * 		처리
         * 		연산식
         * } while (조건식)
         *
         *
         * */

        int w;
        w = 0;
        while (w < 10) {
            System.out.println("while loop " + w);
            w++;
        }

        // initialize - 초기화

        // loop - 실제 처리

        // release - 해방

        int w1, w2;

        w1 = w2 = 0;

        while (w1 < 5) {
            System.out.println("w1 = " + w1);
            w2 = 0; // 초기화
            while (w2 < 3) {
                System.out.println("\tw2 = " + w2);
                w2++;
            }
            w1++;
        }


        int w3 = 0;
        do {
            System.out.println("w3:" + w3);
            w3++;
        } while (w3 < 5);
    }

}