package Static.cls;

public class MyClass {

    /* 변수의 종류 */

    private int number; // 멤버변수

    public static int glNumber; // static 변수, 전역 변수


    public void method(int num, int[] arr) { // 매개변수: 외부에서 값을 받는 변수
        // int num 은 input 값이 확실하나,
        // int[] arr 는 input 값이 아닐 때가 많다
        // (외부에서 값을 받는 변수가 아니라 외부의 값을 세팅하는 변수)

        int localNum = 0; // 지역변수

        localNum++;
        glNumber++;
        number++;

        System.out.println("local: " + localNum);
        System.out.println("static: " + glNumber);
        System.out.println("member: " + number);
    }
}
