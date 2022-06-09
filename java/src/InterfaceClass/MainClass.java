package InterfaceClass;

public class MainClass {
    public static void main(String[] args) {
        // 생성 안됨
//        MyInterface myInter = new MyInterface();

        MyClass mycls = new MyClass();
        mycls.method(1);

        YouClass ycls = new YouClass();
        ycls.method(100);
        ycls.func("Hello!");

        MyInterface my = new MyClass();
        my.method(234);

        MyInterface my2 = new YouClass();
        my2.method(345);

        ((YouInterface) my2).func("Bye~");
    }
}
