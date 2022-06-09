package StaticMethod.main;

public class MyClass {

    public void method() {
        System.out.println("MyClass method()");
    }

    public static void staticMethod() {
        System.out.println("MyClass staticMethod()");
    }

    public static MyClass getObject() {
        MyClass my = new MyClass();

        my.method();

        // 처리1
        // 처리2

        return my;
    }
}
