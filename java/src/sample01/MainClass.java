package sample01;

public class MainClass {

    public static void main(String[] args) {
		/*

		 	숫자(상수):
	 				2진수: 0, 1
	 				8진수: 0 ~ 7, 9 -> 011
	 				10진수: 0 ~ 9
	 				16진수: 0~ 9, A B ~ F(15)
	 					ff = 15 15 = 1111 1111
	 					1010 1100 = 10 12 = 0xAC
	 					0xE4 = 14 4 = 1110 0100

		 	변수: 크기가 다른 빈 통. 데이터를 담는다.
		 */

        int num;
        String str; // instance, object == class의 변수

        // int *number; * -> 포인터

        // 그릇의 종류
        // 숫자
        byte by;  // 1byte = 8bit = 1111 1111

        short sh;  // 2byte
        int i;  // 4byte
        long l;  // 8byte

        l = 2132132132332432L;

        float f;  // 4byte
        f = 1234.56f;

        double d;  // 8byte
        d = 1234.56;

        // 문자
        char c;  // 2byte
        c = '한';

        char arrC[] = { 'a', 'b', 'c' };

        String str1;  // wrapper class (일반 자료형을 객체화시킨 것)
        // Integer, Double
        str1 = "hello";

        // 논리형
        boolean b;  // 1 byte
        // C는 BOOL = 4byte, 0 아니면 다 참 , bool = 1byte, 0 또는 1
        b = true;  // 1
        b = false;  // 0
    }
}
