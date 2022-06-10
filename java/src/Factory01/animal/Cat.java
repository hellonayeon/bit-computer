package Factory01.animal;

public class Cat implements Animal {
    @Override
    public void printDescription() {
        System.out.println("🐈");
    }

    public void method() {
        System.out.println("야옹");
    }
}
