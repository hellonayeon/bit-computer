package Factory01.animal;

public class Dog implements Animal{
    @Override
    public void printDescription() {
        System.out.println("🐕");
    }

    public void method() {
        System.out.println("왈왈");
    }
}
