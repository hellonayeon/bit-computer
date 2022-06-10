package Observer;

import Observer.cls.MyClass;
import Observer.cls.ObserverA;

public class MainClass {
    public static void main(String[] args) {

        /**
         * Observer: 정찰 or 감시
         */

        MyClass cls = new MyClass();
        cls.setPassword("abc123");
        cls.addObserver(new ObserverA());

        cls.notifyObservers(cls.getPassword());
    }
}
