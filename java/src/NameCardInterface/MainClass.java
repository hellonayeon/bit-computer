package NameCardInterface;

import NameCardInterface.cls.NameCard;
import NameCardInterface.cls.PrintPhoneCard;

public class MainClass {
    public static void main(String[] args) {

        NameCard ncard = new NameCard("성춘향", "234", "sch@daum.net");

        ncard.setPrintNameCard(new PrintPhoneCard());
        ncard.print();
    }
}
