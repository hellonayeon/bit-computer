package Final;

public class MainClass {
    public static void main(String[] args) {
        final int number = 10;
        final int NUMBERCOUNT = 100;

        int num = NUMBERCOUNT;
    }
}

// 클래스 앞에 final 키워드 = 더 이상 상속 불가능을 의미
/* final */ class SuperClass {
    void method() {
        System.out.println("SuperClass method()");
    }
}

class ChildClass extends SuperClass {
    @Override
    void method() {
        System.out.println("ChildClass method()");
    }
}