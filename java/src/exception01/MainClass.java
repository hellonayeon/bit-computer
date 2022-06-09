package exception01;

public class MainClass {
    public static void main(String[] args) {
        /**
         * Exception != Error
         *
         * number -> A B C
         * array -> index 범위 초과
         * class -> 없음
         *
         */

//        method();

//        try {
//            callClass();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        callClass();

    }

    static void method() throws IndexOutOfBoundsException {
        int array[] = {1, 2, 3};

        for (int i=0; i<4; i++) {
            System.out.println(array[i]);
        }
    }

//    static void callClass() throws ClassNotFoundException {
//        Class.forName("MyClass");
//        System.out.println("MyClass callClass()");
//    }

    static void callClass()  {
        try {
            Class.forName("MyClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("MyClass callClass()");
    }

}
