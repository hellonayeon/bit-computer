package sample03;

public class MainClass {

    public static void main(String[] args) {
        int num1, num2;
        num1 = 3;
        num2 = 2;

        int result = num1 / num2;

        System.out.println(num1 + "/" + num2 + " = " + result);

        // increment(++), decrement(--)
        num1 = 0;
        num1++;
        System.out.println("num1 = " + num1);

        ++num1;
        System.out.println("num1 = " + num1);

        int a, b;

        a = 0;
        b = 0;

        b = a++;	// b = (a++); 과 동일
        b = --a;
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        // 논리 연산자
        // && AND
        // || OR
        // !  NOT

        int num = 5;

        System.out.println(num <= 5);

        System.out.println(num > 0 && num <= 5);

        System.out.println(num > 10 || num > 0);

        num = 10; // 주석해보기
        System.out.println( !(num > 0 && num < 10) );
        // ** 중간의 논리 연산을 바꿈	num <= 0 || num >= 10 (다 뒤집힌다!)

        System.out.println( num != 9 );


        // 삼항 연산자
        // 값 = (조건) ? 값1 : 값2
        // 삼항 연산자가 발전해서 나온게 람다식

        int n;
        n = (num > 0) ? 100 : 200;
        System.out.println("n = " + n);

        char c;
        c = (num < 0) ? 'Y' : 'N';
        System.out.println("c = " + c);

        /*
         *
         * bit 연산 : 0, 1
         *
         * &		AND
         * |		OR
         * ^		XOR
         * <<		left shift
         * >>		right shift
         * ~		NOT
         *
         * */

        // AND

        /*
         * 		7		1
         * 		8421	8421
         * 		0111	0001
         *
         * 		8		5
         * 		8421	8421
         * 		1000	0101
         *
         * 		0111 0001		0 0 -> 0
         * 		1000 0101		0 1 -> 0
         * 		---------		1 0 -> 0
         * 		0000 0001		1 1 -> 1
         *
         * */

        int number = 0x71 & 0x85;

        System.out.println("number = " + number);
        System.out.printf("0x%x\n", number);


        // OR

        /*
         * 		7		1
         * 		8421	8421
         * 		0111	0001
         *
         * 		8		5
         * 		8421	8421
         * 		1000	0101
         *
         * 		0111 0001		0 0 -> 0
         * 		1000 0101		0 1 -> 1
         * 		---------		1 0 -> 1
         * 		1111 0101		1 1 -> 1
         *
         *		F	 5
         * */

        number = 0x71 | 0x85;
        System.out.println("number = " + number);
        System.out.printf("0x%x\n", number);


        // XOR

        /*
         * 		7		1
         * 		8421	8421
         * 		0111	0001
         *
         * 		8		5
         * 		8421	8421
         * 		1000	0101
         *
         * 		(암호화)
         * 		0111 0001		0 0 -> 0
         * 		1000 0101		0 1 -> 1
         * 		---------		1 0 -> 1
         * 		1111 0100		1 1 -> 0
         *
         *		(복호화)
         *		1111 0100	(data: 전송할 때 실제 데이터)
         *		1000 0101	(key : 키 값, 패스워드)
         *		---------
         *		0111 0001 -> 첫 번째 비트 값이 돌아왔다!
         * */
        // 보안 쪽에서 많이 사용, 보안의 제일 첫 번째 조건이 XOR 연산

        number = 0x71 ^ 0x85;
        System.out.println("number = " + number);
        System.out.printf("0x%x\n", number);

        number = 0xf4 ^ 0x85;
        System.out.printf("0x%x\n", number);


        // Left Shift == *2
        byte by;
        by = 0x1 << 2;
        System.out.println("by = " + by);

        // Right Shift == /2
        by = 0x4 >> 1;
        System.out.println("by = " + by);

        // ~ 반전 0 -> 1,  1 -> 0

        /*
         *		5		5
         *		8421	8421
         *		0101	0101
         *		------------
         *		1010	1010
         *		A		A
         *
         *
         * */

        by = ~0x55;
        System.out.printf("0x%x\n", by);

    }

}