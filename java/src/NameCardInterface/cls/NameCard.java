package NameCardInterface.cls;

import NameCardInterface.inter.PrintNameInterface;

public class NameCard {

    String name;
    String phone;
    String email;

    PrintNameInterface pNameInterface;

    public NameCard(String name, String phone, String email) {
        super();
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public void setPrintNameCard(PrintNameInterface p) {
        this.pNameInterface = p;
    }

    public void print() {
        pNameInterface.print(this);
    }
}
