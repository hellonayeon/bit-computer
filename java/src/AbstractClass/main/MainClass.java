package AbstractClass.main;

import AbstractClass.cls.AbstractClass;
import AbstractClass.cls.MyClass;

public class MainClass {
    public static void main(String[] args) {
        /*
        *
        * Abstract class: 추상 클래스
        *                 추상 메서드를 하나 이상 포함하고 있는 클래스
        *                 abstract method: 처리 내용은 없고 선언만 되어 있는 메서드
        *                                  처리 내용은 없다 = prototype 선언
        *                                  int method(char c); 메서드의 선언만 되어있는 함수가 추상 메서드
        *
        *                 interface: 추상 메서드
        *                            포함하는 메서드가 선언만 되어 있다.
        *                            다중 상속이 가능.
        *                            선언을 통해서 클래스의 내용 파악이 빠르다
        *                            부모 클래스의 instance 형으로 많이 사용
        * */

//        AbstractClass ac = new AbstractClass();
        MyClass mycls = new MyClass();
        mycls.abstractMethod();

        AbstractClass ac = new MyClass(); // Upcasting
        ac.abstractMethod();

        AbstractClass ac2 = new AbstractClass() {
            @Override
            public void abstractMethod() {
                System.out.println("ac2 abstractMethod()");
            }
        };

        ac2.abstractMethod();
    }
}
