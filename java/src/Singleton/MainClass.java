package Singleton;

import Singleton.cls.HeClass;
import Singleton.cls.MyClass;
import Singleton.cls.YouClass;
import Singleton.single.SingletonClass;

public class MainClass {
    public static void main(String[] args) {

        MyClass myCls = new MyClass( 123 );
        YouClass youCls = new YouClass();

//        int n = myCls.getNumber();
//        youCls.setTag(n);

        System.out.println(youCls);

        SingletonClass sc = SingletonClass.getInstance();
        System.out.println(sc);
        System.out.println(sc);
        System.out.println(sc);

        myCls.method();
        youCls.func();

        System.out.println(youCls);

        HeClass heCls = new HeClass();
        heCls.proc();
        System.out.println(heCls);
    }
}
