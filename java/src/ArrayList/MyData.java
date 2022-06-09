package ArrayList;

import InterfaceClass.MyInterface;

public class MyData {

    private int number;
    private String name;

    public MyData() {

    }

    public MyData(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyData{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}
