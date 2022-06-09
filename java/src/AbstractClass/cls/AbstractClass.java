package AbstractClass.cls;

import java.util.Comparator;

public abstract class AbstractClass {

    // 추상 클래스는 멤버 변수 포함 가능
    // 인터페이스는 멤버 변수 포함 불가능
    private int number;

    // 추상 클래스는 일반 메서드 포함 가능
    // 인터페이스는 일반 메서드 포함 불가능
    public void method() {

    }

    public abstract void abstractMethod();
}
