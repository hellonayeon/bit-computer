package NameCardInterface.cls;

import NameCardInterface.inter.PrintNameInterface;

public class PrintPhoneCard implements PrintNameInterface {
    @Override
    public void print(NameCard nc) {
        System.out.println("이름: " + nc.name);
        System.out.println("전화번호: " + nc.phone);
    }
}
