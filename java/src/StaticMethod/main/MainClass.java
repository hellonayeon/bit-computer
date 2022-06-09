package StaticMethod.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainClass {
    public static void main(String[] args) {
//        MyClass cls = new MyClass();
//        cls.method(); // instance method
//        MyClass.staticMethod();

        // static 을 사용하는 이유
        MyClass mycls = MyClass.getObject();

//        Calendar cal = Calendar.getInstance();
//        Calendar cal = new GregorianCalendar();
    }
}
