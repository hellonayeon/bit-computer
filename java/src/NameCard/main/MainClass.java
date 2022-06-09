package NameCard.main;

import NameCard.cls.NameCard;
import NameCard.cls.PrintNameCard;
import NameCard.cls.PrintPhoneCard;

public class MainClass {
    public static void main(String[] args) {

        NameCard ncard = new NameCard("홍길동", "123", "hgd@naver.com");

        ncard.setPrintNameCard(new PrintNameCard());
        ncard.print();

        ncard.setPrintPhoneCard(new PrintPhoneCard());
        ncard.printPhone();
    }
}
