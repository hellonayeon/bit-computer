package NameCardInterface.cls;

import NameCardInterface.inter.PrintNameInterface;

public class PrintNameCard implements PrintNameInterface {
    @Override
    public void print(NameCard nc) {
        System.out.println("이름: " + nc.name);
    }
}
