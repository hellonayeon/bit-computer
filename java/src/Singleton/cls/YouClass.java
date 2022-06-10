package Singleton.cls;

import Singleton.single.SingletonClass;

public class YouClass {

    private int tag;

//    public void setTag(int tag) {
//        this.tag = tag;
//    }

    public void func() {
        SingletonClass sc = SingletonClass.getInstance();
        tag = sc.num;
    }

    @Override
    public String toString() {
        return "YouClass{" +
                "tag=" + tag +
                '}';
    }
}
