package sample05;

import java.util.Iterator;

public class MainClass {

    public static void main(String[] args) {

        /**
         *	Array: 배열. 같은 자료형의 묶음. (변수들)
         * 		   목적: 데이터 관리
         * 				class, struct (다른 자료형의 묶음) - Data Transfer Object, Value Object
         *
         * 		   자료형	 변수명[] = new 자료형[배열의 총 수];
         *
         * 		   정적, 동적
         * 		   static, dynamic
         * 		   (메모리는 '동적'으로 할당받지만, 사용은 '정적'으로)
         *
         * 		   메모리 영역
         * 		   stack  heap  static  sys
         * 		   array  [5]
         *
         * 		   가변 배열 = List
         *
         * 		   int array[] = new int[5];
         * 		   delete[] array; - Garbage Collector
         */

        int[] Array = new int[5]; // 동적으로 할당을 해놓고 정적으로 사용

        System.out.println(Array); // 배열 변수는 4Byte (heap 영역의 주소값)
        System.out.println(Array[0]); // 번지, index (0 ~ 4)
        System.out.println(Array.length);

        int[] Array1 = { 2, 3, 5, 7, 9 };

        System.out.println(Array1[0]);
        System.out.println(Array1[1]);
        System.out.println(Array1[2]);

        // 배열은 인덱스로 관리, 문자로 관리되는 것 Map
        for (int i=0; i<Array.length; i++) {
            System.out.println(Array1[i]);
        }

        // 배열 복사
        int[] Array2 = Array1; // 얕은 복사, 복사가 된 매개체는 변경하게 되면 원본이 변경, alias(별명 - 별명이 아니라 본인 자신)
//		for (int i=0; i<Array2.length; i++) {
//			System.out.println(Array2[i]);
//		}

        Array2[2] = 6;
        System.out.println("Array1[2] = " + Array1[2]);


        int[] number1 = { 1, 2, 3 };
        int[] number2 = { 7, 8, 9 };

//		for(int i=0; i<number2.length; i++) {
//			int tmp = number1[i];
//			number1[i] = number2[i];
//			number2[i] = tmp;
//		}

        // 4Byte 짜리 한 번만 바꾸는 작업
        // 4Byte 크기를 한 번 스왑하는 걸로 배열 바꾸기 가능
        int[] num1 = number1;
        int[] num2 = number2;
        int[] tmp;
        tmp = num1;
        num1 = num2;
        num2 = tmp;

        for (int i=0; i<num2.length; i++) {
            System.out.println("num2[" + i + "] = " + num2[i]);
            System.out.println("number2[" + i + "] = " + number2[i]);
        }

        int[] numberArrayPosition = {1, 2, 3};
        int[] numArrPos = numberArrayPosition;

        /* 2차원 배열 */
//		int Arr2[][] = new int[3][4];
//		int []Arr2[] = new int[3][4];
//		int [][]Arr2 = new int[3][4];
//		int[][] Arr2 = new int[3][4];

        int[][] Arr2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        /*
         *
         * int **Array2 = Arr2;
         *
         * int seven = *(*(Array2 + 1) + 2);
         *
         * */

        System.out.println(Arr2[1][2]);

        int ArrNum[][] = null; // #define NULL (0) - 메모리 주소를 다 0으로 세팅한다는 의미
        ArrNum = new int[3][];

        int a1[] = {1, 2, 3};
        ArrNum[0] = a1;

        int a2[] = {4, 5, 6, 7};
        ArrNum[1] = a2;

        int a3[] = {8, 9};
        ArrNum[2] = a3;

        for (int i=0; i<ArrNum.length; i++) {
            for (int j=0; j<ArrNum[i].length; j++) {
                System.out.print(ArrNum[i][j] + "\t");
            }
            System.out.println();
        }
    }

}