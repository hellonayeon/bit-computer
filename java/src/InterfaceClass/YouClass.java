package InterfaceClass;

public class YouClass implements MyInterface, YouInterface {

    @Override
    public void method(int n) {
        System.out.println("YouClass method(int n)");
    }

    @Override
    public void func(String str) {
        System.out.println("YouClass func(String str)");
    }
}
