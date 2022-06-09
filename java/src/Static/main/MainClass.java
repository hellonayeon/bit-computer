package Static.main;

import Static.cls.MyClass;

public class MainClass {
    public static void main(String[] args) {
        /*
        * static == 정적
        * */

        MyClass cls = new MyClass();

        cls.method(0, null);
        cls.method(0, null);

        MyClass myCls = new MyClass();
        myCls.method(0, null);

        MyClass.glNumber++; // class 변수
        // member 변수 -> instance 변수


    }
}
